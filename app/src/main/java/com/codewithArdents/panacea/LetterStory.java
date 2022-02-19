package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LetterStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_story);
        findViewById(R.id.story_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int letterchar = getIntent().getIntExtra("letter",-1);
                int lettercolor = getIntent().getIntExtra("color",-1);
                Intent i = new Intent(LetterStory.this,LetterDraw.class);
                i.putExtra("letter",letterchar);
                i.putExtra("color",lettercolor);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}