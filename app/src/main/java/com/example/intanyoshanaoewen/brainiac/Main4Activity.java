package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button btnSubmit;
    RadioGroup rg1;
    RadioButton radioSelected;

    int score = 0;
    int newscore3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        initializeLayoutComponent();
    }

    private void initializeLayoutComponent(){
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rg1 = (RadioGroup) findViewById(R.id.radioGroupAns1);
    }

    public void checkResult(View view) {
        Intent i = getIntent();
        int selectedId = rg1.getCheckedRadioButtonId();
        radioSelected = (RadioButton) findViewById(selectedId);
        if (radioSelected.getText().toString().matches("Umbilical Cord")) {
            if (i.hasExtra("newscore2")) {
                Intent intent = new Intent();
                newscore3 = i.getIntExtra("newscore2", 0);
                newscore3 = newscore3 + 10;
                Toast.makeText(getApplicationContext(), "Correct Answer! Score : " + newscore3, Toast.LENGTH_SHORT).show();
                intent.putExtra("newscore3", newscore3);
                intent.setClass(Main4Activity.this, Main5Activity.class);
                startActivity(intent);
            }
        }
            else {
                if (i.hasExtra("newscore2")){
                    Intent intent = new Intent();
                    newscore3 = i.getIntExtra("newscore2", 0);
                    newscore3 = newscore3 + 0;
                    intent.putExtra("newscore3", newscore3);
                    intent.setClass(Main4Activity.this, Main5Activity.class);
                    startActivity(intent);
                }
            }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
