package com.example.angel.questiongame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    static String USER_PRF = "user_prf";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    Button btnSaveName;
    EditText edtName;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        preferences =  getSharedPreferences(USER_PRF, Context.MODE_PRIVATE);
        editor = preferences.edit();

        ctx = this;

        btnSaveName = (Button) findViewById(R.id.btnSave);
        edtName = (EditText) findViewById(R.id.edtName);

        btnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name",edtName.getText().toString());
                editor.commit();


                Intent i = new Intent(ctx,Options.class);
                startActivity(i);

                finish();
            }
        });
    }


}
