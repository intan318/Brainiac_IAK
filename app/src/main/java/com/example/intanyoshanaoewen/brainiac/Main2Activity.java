package com.example.intanyoshanaoewen.brainiac;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rg1;
    RadioButton radioSelected;

    int newscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initializeLayoutComponent();
    }

    private void initializeLayoutComponent(){
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rg1 = (RadioGroup) findViewById(R.id.radioGroupAns1);
    }

    public void checkResult(View view) {
        int selectedId = rg1.getCheckedRadioButtonId();
        radioSelected = (RadioButton) findViewById(selectedId);
        if (radioSelected.getText().toString().matches("Lizard")){
            Intent intent = new Intent();
            newscore = newscore + 10;
            Toast.makeText(getApplicationContext(), "Correct Answer! Score : "+newscore, Toast.LENGTH_SHORT).show();
            intent.putExtra("newscore", newscore);
            intent.setClass(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent();
            newscore = newscore + 0;
            Toast.makeText(getApplicationContext(), "Wrong Answer! Score :"+ newscore, Toast.LENGTH_SHORT).show();
            intent.putExtra("newscore", newscore);
            intent.setClass(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Finish the quiz :)", Toast.LENGTH_SHORT).show();
    }
}
