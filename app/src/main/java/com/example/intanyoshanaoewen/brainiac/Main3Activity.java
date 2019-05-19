package com.example.intanyoshanaoewen.brainiac;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rg1;
    RadioButton radioSelected;

    int newscore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initializeLayoutComponent();
    }

    private void initializeLayoutComponent(){
        btnSubmit = (Button) findViewById(R.id.btnStart);
        rg1 = (RadioGroup) findViewById(R.id.radioGroupAns1);
    }

    public void checkResult(View view) {
        Intent i = getIntent();
        int selectedId = rg1.getCheckedRadioButtonId();
        radioSelected = (RadioButton) findViewById(selectedId);
        if (radioSelected.getText().toString().matches("Egypt")) {
            if (i.hasExtra("newscore")) {
                Intent intent = new Intent();
                newscore2 = i.getIntExtra("newscore", 0);
                newscore2 = newscore2 + 10;
                Toast.makeText(getApplicationContext(), "Correct Answer! Score : "+newscore2, Toast.LENGTH_SHORT).show();
                intent.putExtra("newscore2", newscore2);
                intent.setClass(Main3Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        }

        else {
            if (i.hasExtra("newscore")){
              Intent intent = new Intent();
              newscore2 = i.getIntExtra("newscore", 0);
              newscore2 = newscore2 + 0;
              Toast.makeText(getApplicationContext(), "Wrong Answer! Score : "+newscore2, Toast.LENGTH_SHORT).show();
              intent.putExtra("newscore2", newscore2);
              intent.setClass(Main3Activity.this, Main4Activity.class);
              startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
         Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
