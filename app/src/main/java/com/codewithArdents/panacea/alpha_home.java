package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class alpha_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_home);
        Button btn= (Button) findViewById(R.id.nextalpha);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Next",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(alpha_home.this,LetterSelection.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(alpha_home.this,homepage.class));
        finish();
    }
}