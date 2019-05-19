package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
    Button btnSubmit;
    CheckBox cbxEngland;
    CheckBox cbxWales;
    CheckBox cbxScotland;
    CheckBox cbxNorthIreland;

    int score;
    int newscore5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        initializeLayoutComponent();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent();
            Intent i = getIntent();
            score = i.getIntExtra("newscore4", 0);
            if (cbxEngland.isChecked() && cbxWales.isChecked() && cbxNorthIreland.isChecked() && cbxScotland.isChecked()) {
                newscore5 = score;
                newscore5 = newscore5 + 10;

                intent.putExtra("newscore5", newscore5);
                Toast.makeText(getApplicationContext(), "Correct Answer! Score : " + newscore5, Toast.LENGTH_SHORT).show();
            } else {

                newscore5 = score;
                newscore5 = newscore5 + 0;
                intent.putExtra("newscore5", newscore5);
                Toast.makeText(getApplicationContext(), "Wrong Answer! Score : " + newscore5, Toast.LENGTH_SHORT).show();
            }

            intent.setClass(Main6Activity.this, Main7Activity.class);
            startActivity(intent);
            }
        });

    }

    private void initializeLayoutComponent(){
        btnSubmit = (Button) findViewById (R.id.btnSubmit);
        cbxEngland = (CheckBox) findViewById(R.id.cbxEngland);
        cbxWales = (CheckBox) findViewById(R.id.cbxWales);
        cbxScotland = (CheckBox) findViewById(R.id.cbxScotland);
        cbxNorthIreland = (CheckBox) findViewById(R.id.cbxNorthIre);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
