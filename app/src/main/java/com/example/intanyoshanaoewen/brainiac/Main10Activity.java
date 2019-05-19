package com.example.intanyoshanaoewen.brainiac;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main10Activity extends AppCompatActivity {

    int newscore4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        TextView txtTotalScore = (TextView) findViewById(R.id.txtTotalScore);

        Intent intent = getIntent();

        if (intent.hasExtra("newscore8")) {
            int total = intent.getIntExtra("newscore8", 0);
            Toast.makeText(getApplicationContext(), "Correct Answer! Score : "+ total, Toast.LENGTH_SHORT).show();
            txtTotalScore.setText("Total Score : " + total + "/80");
        }
    }

    @Override
    public void onBackPressed() {
    }

    public void clickExit(View view) {
        finishAffinity();
    }
}
