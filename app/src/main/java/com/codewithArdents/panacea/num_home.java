package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class num_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_home);

        Button btn1= (Button) findViewById(R.id.nextNum);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Next",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(num_home.this,NumberSelection.class));

            }
        });
    }
}