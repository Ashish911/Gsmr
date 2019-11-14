package com.example.gsmr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int min = 1;
    int max = 100;

    Random r = new Random();
    int I1 = r.nextInt(max - min + 1) + min;
    int I2 = r.nextInt(max - min + 1) + min;
    int Score = 0;
    String Result = "";

    Button btnFirst, btnSecond;
    TextView tvScore, tvResult;

    public void ShowResult(){
        if (Score == 10){
            Result = "You Win";
            Score = 0;
        }
        else if (Score == -10){
            Result = "You Lose";
            Score = 0;
        }
    }

    public void ResetResult(){
        if (Score > 0 && Score <10){
            Result = "";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Binding
        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        tvScore = findViewById(R.id.tvScore);
        tvResult = findViewById(R.id.tvResult);
        //Putting Random numbers on buttons
        btnFirst.setText(Integer.toString(I1));
        btnSecond.setText(Integer.toString(I2));
        //Setting Click Listener

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int First, Second;
                First = Integer.parseInt(btnFirst.getText().toString());
                Second = Integer.parseInt(btnSecond.getText().toString());
                //Condition for score and result
                if (First > Second){
                    Score = Score + 1;
                }
                else if (First < Second)
                {
                    Score = Score - 1;
                }
                ShowResult();
                tvScore.setText("Your Score: ".concat(Integer.toString(Score)));
                tvResult.setText(Result);
                int I1 = r.nextInt(max - min + 1) + min;
                int I2 = r.nextInt(max - min + 1) + min;
                btnFirst.setText(Integer.toString(I1));
                btnSecond.setText(Integer.toString(I2));
                ResetResult();
                tvResult.setText(Result);

            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int First, Second;
                First = Integer.parseInt(btnFirst.getText().toString());
                Second = Integer.parseInt(btnSecond.getText().toString());
                //Condition for score and result
                if (Second > First){
                    Score = Score + 1;
                }
                else if (Second < First)
                {
                    Score = Score - 1;
                }
                ShowResult();
                tvScore.setText( "Your Score: ".concat(Integer.toString(Score)));
                tvResult.setText(Result);
                int I1 = r.nextInt(max - min + 1) + min;
                int I2 = r.nextInt(max - min + 1) + min;
                btnFirst.setText(Integer.toString(I1));
                btnSecond.setText(Integer.toString(I2));
                ResetResult();
                tvResult.setText(Result);
            }
        });
    }
}
