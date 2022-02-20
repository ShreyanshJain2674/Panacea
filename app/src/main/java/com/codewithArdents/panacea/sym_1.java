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
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.danny_jiang.tracinglibrary.bean.LetterFactory;
import com.danny_jiang.tracinglibrary.view.TracingLetterView;

public class sym_1 extends AppCompatActivity {

    TracingLetterView tl1,tl2,tl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sym1);

        tl1 = findViewById(R.id.trace1);


        setLetterView(tl1,LetterFactory.h_line,R.color.teal_200);

    }
    private void setLetterView(TracingLetterView letterView , int letterchar , int letter_color) {
        letterView.setLetterChar(letterchar);
        letterView.setStrokeColor(letter_color);
        letterView.setInstructMode(true);
        letterView.setTracingListener(new TracingLetterView.TracingListener() {
            @Override
            public void onFinish() {
                    Toast.makeText(sym_1.this,
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
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(sym_1.this);
        View layoutView = getLayoutInflater().inflate(layout,null);
        Button button = layoutView.findViewById(R.id.button);
        TextView tv = layoutView.findViewById(R.id.txtview);
        tv.startAnimation(AnimationUtils.loadAnimation(sym_1.this,R.anim.pulse));
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
        startActivity(new Intent(sym_1.this,homepage.class));
        finish();
    }
}
