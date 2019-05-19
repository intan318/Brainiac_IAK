package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {
    Button btnSubmit;
    CheckBox cbxOxygen;
    CheckBox cbxCarbon;
    CheckBox cbxGlucose;
    CheckBox cbxWater;

    int score;
    int newscore6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        initializeLayoutComponent();

        Intent i = getIntent();
        score = i.getIntExtra("newscore5", 0);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                if (cbxOxygen.isChecked() && cbxGlucose.isChecked()){
                    newscore6 = score;
                    newscore6 = newscore6 + 10;

                    intent.putExtra("newscore6", newscore6);
                    Toast.makeText(getApplicationContext(), "Correct Answer! Score : "+newscore6, Toast.LENGTH_SHORT).show();
                }
                else {
                    newscore6 = score;
                    newscore6 = newscore6;
                    intent.putExtra("newscore6", newscore6);
                    Toast.makeText(getApplicationContext(), "Wrong Answer! Score : "+newscore6, Toast.LENGTH_SHORT).show();
                }
                intent.setClass(Main7Activity.this, Main8Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeLayoutComponent(){
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        cbxCarbon = (CheckBox) findViewById(R.id.cbxCarbon);
        cbxGlucose = (CheckBox) findViewById(R.id.cbxGlucose);
        cbxOxygen = (CheckBox) findViewById(R.id.cbxOxygen);
        cbxWater = (CheckBox) findViewById(R.id.cbxWater);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
