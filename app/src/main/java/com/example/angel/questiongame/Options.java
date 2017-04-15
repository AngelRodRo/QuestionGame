package com.example.angel.questiongame;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created on 02/04/2017.
 */


public class Options extends Activity {

    Button btnhard,btnintermediate,btntime,btnuntime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);

        btnhard = (Button) findViewById(R.id.btnhard);
        btnintermediate = (Button) findViewById(R.id.btnintermediate);
        btntime = (Button) findViewById(R.id.btntime);
        btnuntime = (Button) findViewById(R.id.btnuntime);

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
                finish();
            }
        });
        btnuntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity.class);
                intent.putExtra("type",3);
                startActivity(intent);
                finish();
            }
        });
        btnhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
                finish();
            }
        });

        btnintermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Options.this,
                        QuestionActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
                finish();
            }
        });

    }

}