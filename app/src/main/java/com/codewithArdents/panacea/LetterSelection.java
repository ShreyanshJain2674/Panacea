package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

public class LetterSelection extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_selection);
        rv = findViewById(R.id.letters_recycler);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> color = new ArrayList<>();

        list.add(R.drawable.letter_a);
        list.add(R.drawable.letter_b);
        list.add(R.drawable.letter_c);
        list.add(R.drawable.letter_d);
        list.add(R.drawable.letter_e);
        list.add(R.drawable.letter_f);
        list.add(R.drawable.letter_g);
        list.add(R.drawable.letter_h);
        list.add(R.drawable.letter_i);
        list.add(R.drawable.letter_j);
        list.add(R.drawable.letter_k);
        list.add(R.drawable.letter_l);
        list.add(R.drawable.letter_m);
        list.add(R.drawable.letter_n);
        list.add(R.drawable.letter_o);
        list.add(R.drawable.letter_p);
        list.add(R.drawable.letter_q);
        list.add(R.drawable.letter_r);
        list.add(R.drawable.letter_s);
        list.add(R.drawable.letter_t);
        list.add(R.drawable.letter_u);
        list.add(R.drawable.letter_v);
        list.add(R.drawable.letter_w);
        list.add(R.drawable.letter_x);
        list.add(R.drawable.letter_y);
        list.add(R.drawable.letter_z);

        String[] str = getResources().getStringArray(R.array.alpha_colors);
        for (String s : str) {
            color.add(Color.parseColor(s));
        }
        LetterCard_Adapter card_adapter = new LetterCard_Adapter(this,list,color,false);
        rv.setAdapter(card_adapter);
        rv.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LetterSelection.this,alpha_home.class));
    }
}