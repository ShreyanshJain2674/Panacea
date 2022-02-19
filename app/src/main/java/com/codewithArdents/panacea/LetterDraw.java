package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.airbnb.lottie.LottieAnimationView;
import com.danny_jiang.tracinglibrary.view.TracingLetterView;

public class LetterDraw extends AppCompatActivity {

    TracingLetterView letterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_draw);
        letterView = findViewById(R.id.letter_view);
        int letterchar = getIntent().getIntExtra("letter",-1);
        int letter_color = getIntent().getIntExtra("color",-1);
        Log.e("letterview","yes");
        setLetterView(letterView,letterchar,letter_color);
    }
    private void setLetterView(TracingLetterView letterView , int letterchar , int letter_color) {
        letterView.setLetterChar(letterchar);
        letterView.setStrokeColor(letter_color);
        letterView.setInstructMode(true);
        letterView.setTracingListener(new TracingLetterView.TracingListener() {
            @Override
            public void onFinish() {
                Toast.makeText(LetterDraw.this,
                        "tracing finished", Toast.LENGTH_SHORT).show();
                showAlertDialog(R.layout.congratulation_dialogue);
            }

            @Override
            public void onTracing(float x, float y) {
                Log.e("ABC", "tracing x : " + x + " y : " + y);
            }
        });
    }

    private void showAlertDialog(int layout) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LetterDraw.this);
        View layoutView = getLayoutInflater().inflate(layout,null);
        Button button = layoutView.findViewById(R.id.button);
        TextView tv = layoutView.findViewById(R.id.txtview);
        tv.startAnimation(AnimationUtils.loadAnimation(LetterDraw.this,R.anim.pulse));
        dialogBuilder.setView(layoutView);
        AlertDialog alertdialog = dialogBuilder.create();
        alertdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertdialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertdialog.show();
        LottieAnimationView lottieAnimationView = layoutView.findViewById(R.id.congrats_anim);
        LottieAnimationView lottieAnimationView2 = layoutView.findViewById(R.id.congrats_anim2);
        lottieAnimationView.playAnimation();
        lottieAnimationView2.playAnimation();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.cancelAnimation();
                //startActivity(new Intent(LetterDraw.this,LetterSelection.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LetterDraw.this,LetterSelection.class));
        finish();
    }
}