package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    Button btnSubmit;
    EditText txtAnswer;

    int score = 0;
    int newscore7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        initializeLayoutComponent();

        Intent i = getIntent();
        score = i.getIntExtra("newscore6", 0);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                String takeString = txtAnswer.getText().toString();

                if (takeString.matches("[Ss]ingapore")){
                    newscore7 = score + 10;
                    intent.putExtra("newscore7", newscore7).toString();
                    Toast.makeText(getApplicationContext(), "Correct Answer! Score : "+newscore7, Toast.LENGTH_SHORT).show();
                }
                else {
                    newscore7 = score + 0;
                    intent.putExtra("newscore7", newscore7).toString();
                    Toast.makeText(getApplicationContext(), "Wrong Answer! Score : "+newscore7, Toast.LENGTH_SHORT).show();
                }
                intent.setClass(Main8Activity.this, Main9Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeLayoutComponent(){
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtAnswer = (EditText) findViewById(R.id.txtAnswer);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
