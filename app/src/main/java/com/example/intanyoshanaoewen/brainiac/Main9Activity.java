package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {
    Button btnSubmit;
    EditText txtAnswer;

    int score = 0;
    int newscore8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        initializeLayoutComponent();

        Intent i = getIntent();
        score = i.getIntExtra("newscore7", 0);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();

                intent.setClass(Main9Activity.this, Main10Activity.class);
                String takeString = txtAnswer.getText().toString();

                if (takeString.matches("[Aa]mazon")){
                    newscore8 = score + 10;
                    intent.putExtra("newscore8", newscore8).toString();
                    Toast.makeText(getApplicationContext(), "Correct Answer! Score : "+newscore8, Toast.LENGTH_SHORT).show();
                }
                else {
                    newscore8 = score + 0;
                    intent.putExtra("newscore8", newscore8).toString();
                    Toast.makeText(getApplicationContext(), "Wrong Answer! Score : "+newscore8, Toast.LENGTH_SHORT).show();
                }
                intent.setClass(Main9Activity.this, Main10Activity.class);
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
