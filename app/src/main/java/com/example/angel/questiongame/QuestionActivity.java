package com.example.angel.questiongame;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * Created on 02/04/2017.
 */



public class QuestionActivity extends Activity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3;

    List<Integer> questions_answered;
    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int type = getIntent().getExtras().getInt("type");

        questions_answered = new ArrayList<>();

        QuizHelper db = new QuizHelper(this);
        quesList = db.getQuestionType(type );
        if (quesList.size()<=0){
            finish();

            Intent i = new Intent(this,Options.class);
            startActivity(i);

            Toast.makeText(this,"Dont have question yet, try with another topic",Toast.LENGTH_LONG).show();
            return;
        }

        currentIndex = getRandomIndex();

        currentQ = quesList.get(currentIndex);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        scored = (TextView) findViewById(R.id.score);
        times = (TextView) findViewById(R.id.timers);
        setQuestionView();
        times.setText("00:02:00");
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button1.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
    }
    public void getAnswer(String AnswerString) {

        questions_answered.add(currentIndex);

        if (currentQ.getANSWER().equals(AnswerString)) {
            score++;
            scored.setText("Score : " + score);
        } else {
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }
        if (qid < 10) {
            currentIndex = getRandomIndex();
            currentQ = quesList.get(currentIndex);
            setQuestionView();
        } else {

            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }

    public int getRandomIndex(){
        int randomNum = 0;
        while (questions_answered.indexOf(randomNum)>=0){
            Random rand = new Random();
            randomNum = rand.nextInt(( (quesList.size()-1)  - 0) + 1) + 0;
        }
        return randomNum;

    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }
        @Override
        public void onFinish() {
            times.setText("Time is up");
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }
    }
    private void setQuestionView() {

        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        qid++;
    }
}