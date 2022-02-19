package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class gender extends AppCompatActivity {

    private String gender="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        if(!Utility.getName(this).equals("")){
            startActivity(new Intent(com.codewithArdents.panacea.gender.this,homepage.class));
        }

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogrp);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch (checkedId){
                    case R.id.custom_button1:
                        findViewById(R.id.custom_button1).setBackground(getResources().getDrawable(R.drawable.r_boy));
                        findViewById(R.id.custom_button2).setBackground(getResources().getDrawable(R.drawable.girl));
                        gender = "Male";
                        break;
                    case R.id.custom_button2:
                        findViewById(R.id.custom_button2).setBackground(getResources().getDrawable(R.drawable.r_girl));
                        findViewById(R.id.custom_button1).setBackground(getResources().getDrawable(R.drawable.boy));
                        gender = "Female";
                        break;
                }


            }
        });



        findViewById(R.id.gender_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gender.equals("")){
                    Toast.makeText(gender.this, "Please Select the Gender", Toast.LENGTH_SHORT).show();
                }else if(gender.equals("Male")){
                    Intent i = new Intent(com.codewithArdents.panacea.gender.this,MainActivity.class);
                    i.putExtra("gender",0);
                    startActivity(i);
                }else{
                    Intent i = new Intent(com.codewithArdents.panacea.gender.this,MainActivity.class);
                    i.putExtra("gender",1);
                    startActivity(i);
                }
            }
        });

    }
}