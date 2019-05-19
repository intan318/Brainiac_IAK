package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    Button btnSubmit;
    RadioGroup rg1;
    RadioButton radioSelected;

    int newscore4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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
        if (radioSelected.getText().toString().matches("William Shakespeare")){
            if (i.hasExtra("newscore3")) {
                Intent intent = new Intent();
                newscore4 = i.getIntExtra("newscore3", 0);
                newscore4 = newscore4 + 10;
                Toast.makeText(getApplicationContext(), "Correct Answer! Score : " + newscore4, Toast.LENGTH_SHORT).show();
                intent.putExtra("newscore4", newscore4);
                intent.setClass(Main5Activity.this, Main6Activity.class);
                startActivity(intent);
            }
            }
            else {
                if (i.hasExtra("newscore3")){
                    Intent intent = new Intent();
                    newscore4 = i.getIntExtra("newscore3", 0);
                    newscore4 = newscore4 + 0;
                    Toast.makeText(getApplicationContext(), "Wrong Answer! Score : "+ newscore4, Toast.LENGTH_SHORT).show();
                    intent.putExtra("newscore4", newscore4);
                    intent.setClass(Main5Activity.this, Main6Activity.class);
                    startActivity(intent);
                }
            }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
