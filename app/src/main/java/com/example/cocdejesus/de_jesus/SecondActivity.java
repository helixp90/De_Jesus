package com.example.cocdejesus.de_jesus;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondActivity extends Activity {

    public int []buttonid;

    public List<Button> buttons = new ArrayList<>();

    public List<String> letters = new ArrayList<>();

    public TextView countdowntxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonid = new int[] {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10,
                R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16 };

        letters = Arrays.asList("A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H");

        countdowntxt = findViewById(R.id.countdown);

        try {

            for (int i = 0; i < buttonid.length; i++) {

                Button button = findViewById(buttonid[i]);
                buttons.add(button);
            }

            Collections.shuffle(letters);

            for (int i = 0; i < letters.size(); i++) {

                buttons.get(i).setText(letters.get(i));

            }

            new CountDownTimer(3000, 1000) {

                public void onTick(long untilFinish) {

                    for (int i = 0; i < buttons.size(); i++) {

                        buttons.get(i).setEnabled(false);
                    }

                    countdowntxt.setText(String.valueOf(untilFinish / 1000));

                }

                public void onFinish() {

                    for (int i = 0; i < buttons.size(); i++) {

                        buttons.get(i).setText("???");
                        buttons.get(i).setEnabled(true);
                    }
                }
            }.start();
        }

        catch (Exception e) {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}
