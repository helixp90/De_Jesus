package com.example.cocdejesus.de_jesus;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ThirdActivity extends Activity {

    public int ccounter, incounter, buttoncounter;

    public int []buttonid;

    public List<Button> buttons = new ArrayList<>();

    public List<String> letters = new ArrayList<>();

    public TextView countdowntxt, correct, incorrect;

    public String laststring, firststring;

    public Button lastbutton, firstbutton;

    public Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ccounter = 0;
        incounter = 0;
        buttoncounter = 0;

        firststring = null;
        laststring = null;

        firstbutton = null;
        lastbutton = null;

        buttonid = new int[] {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10,
                R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20, R.id.btn21, R.id.btn22,
                R.id.btn23, R.id.btn24};

        letters = Arrays.asList("1", "1", "@", "@", "2", "2", "#", "#", "3", "3", "$", "$", "4", "4", "%", "%", "5", "5", "^", "^", "6", "6", "&", "&");

        countdowntxt = findViewById(R.id.countdown);
        correct = findViewById(R.id.correcttxt);
        incorrect = findViewById(R.id.incorrecttxt);

        handler = new Handler();

        try {

            for (int i = 0; i < buttonid.length; i++) {

                Button button = findViewById(buttonid[i]);
                buttons.add(button);
            }

            Collections.shuffle(letters);

            for (int i = 0; i < letters.size(); i++) {

                buttons.get(i).setText(letters.get(i));


            }


            new CountDownTimer(5000, 1000) {

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

    public void game(View v) {

        try {

            buttoncounter++;

            if (buttoncounter < 3) {

                firstbutton = findViewById(v.getId());

                //firstbutton = buttonx;

                firstbutton.setEnabled(false);

                for (int i = 0; i < letters.size(); i++) {

                    if (buttons.get(i).getId() == v.getId()) {

                        firststring = letters.get(i);
                        firstbutton.setText(firststring);

                        //Log.d("IT WAS ME BITCH", firstbutton.getText().toString());
                        //firstbutton = buttonx;

                        //Toast.makeText(this, firststring, Toast.LENGTH_SHORT).show();
                        break;
                    }
                }



                Log.d("WTF", Integer.toString(buttoncounter));

                if (laststring == null) {

                    laststring = firststring;
                    lastbutton = firstbutton;



                    //Toast.makeText(this, laststring, Toast.LENGTH_SHORT).show();

                }

                else {





                    if (firststring == laststring) {

                        //Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();

                        ccounter++;

                        correct.setText(Integer.toString(ccounter));

                        firstbutton = null;
                        lastbutton = null;

                        firststring = null;
                        laststring = null;

                        buttoncounter = 0;

                    }

                    else {
                        //Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();

                        incounter++;

                        incorrect.setText(Integer.toString(incounter));

                        //Log.d("DIO", firstbutton.getText().toString());
                        // Log.d("DIO", lastbutton.getText().toString());

                        //Log.d("DIO", firstbutton.getText().toString());
                        //Log.d("DIO", lastbutton.getText().toString());

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                firstbutton.setEnabled(true);
                                lastbutton.setEnabled(true);

                                firstbutton.setText("???");
                                lastbutton.setText("???");

                                firstbutton = null;
                                lastbutton = null;

                                firststring = null;
                                laststring = null;

                                buttoncounter = 0;
                            }
                        }, 2000);


                    }




                }


            }



        }

        catch (Exception e) {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

     public void bonus (View v) {

        Button b = findViewById(v.getId());
        b.setText("BONUS X)");
        b.setEnabled(false);

     }
}
