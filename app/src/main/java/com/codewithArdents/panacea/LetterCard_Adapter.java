package com.codewithArdents.panacea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LetterCard_Adapter extends RecyclerView.Adapter<LetterCard_Adapter.MyViewHolder> {

    Context context;
    ArrayList<Integer> letterlist;
    ArrayList<Integer> colors;
    boolean isNum;

    public LetterCard_Adapter(Context context , ArrayList<Integer> letterlist, ArrayList<Integer> colors, boolean isNum ) {
        this.context = context;
        this.letterlist = letterlist;
        this.colors = colors;
        this.isNum = isNum;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.letters_cardview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgview.setImageResource(letterlist.get(position));
        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isNum)
                {
                    if(Utility.getValue((Activity) context)==0){
                        Utility.setValue(((Activity) context),1 );
                        Intent intent = new Intent(context,LetterStory.class);
                        intent.putExtra("letter",holder.getAdapterPosition()+1);
                        intent.putExtra("color",colors.get(holder.getAdapterPosition()));
                        Log.e("pos"," "+holder.getAdapterPosition());
                        context.startActivity(intent);
                    }else{
                        Intent intent = new Intent(context,LetterDraw.class);
                        intent.putExtra("color",colors.get(holder.getAdapterPosition()));
                        intent.putExtra("letter",holder.getAdapterPosition()+1);
                        Log.e("pos"," "+holder.getAdapterPosition());
                        context.startActivity(intent);
                    }
                }
                else
                {
                    Intent intent = new Intent(context,LetterDraw.class);
                    intent.putExtra("letter",holder.getAdapterPosition()+30);
                    intent.putExtra("color",colors.get(holder.getAdapterPosition()));
                    context.startActivity(intent);
                }

                Log.e("pos"," "+holder.getAdapterPosition());

            }
        });
    }

    @Override
    public int getItemCount() {
        return letterlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.letter_image);
        }
    }
}
