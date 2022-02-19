package com.codewithArdents.panacea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shawnlin.numberpicker.NumberPicker;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NumberPicker numberPicker;
    int age=-1;
    EditText name;
    Boolean isImage=false;
    String photoUri="";
    int RESULT_LOAD_IMG = 444;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int k = getIntent().getIntExtra("gender",0);
        LinearLayout ll = findViewById(R.id.ll1);
        ImageView imgv = findViewById(R.id.imageview);
        ImageView imgv2 = findViewById(R.id.camera_bg_small);
        AppCompatButton butn = findViewById(R.id.profile_next);
        numberPicker = findViewById(R.id.number_picker);

        if (k==1){
            ll.setBackground(getDrawable(R.drawable.age_bg2));
            imgv.setImageResource(R.drawable.girl_dummy);
            imgv2.setImageResource(R.drawable.camera_bg2);
            butn.setTextColor(getResources().getColor(R.color.girl_color));
            numberPicker.setSelectedTextColor(getResources().getColor(R.color.girl_color));
        }

        name = findViewById(R.id.profile_name);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                age = newVal;
            }
        });

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });

        findViewById(R.id.profile_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }else if(!isImage){
                    Toast.makeText(MainActivity.this, "Please Select Your Image", Toast.LENGTH_SHORT).show();
                }else if(age==-1){
                    Toast.makeText(MainActivity.this, "Please Select Your Age", Toast.LENGTH_SHORT).show();
                }
                else{
                    Utility.setAge(MainActivity.this,age);
                    Utility.setGender(MainActivity.this,"Male");
                    Utility.setName(MainActivity.this,name.getText().toString());
                    Utility.setPhoto(MainActivity.this,photoUri);
                    startActivity(new Intent(MainActivity.this,homepage.class));
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                photoUri = imageUri.toString();
                ImageView v = findViewById(R.id.imageview);
                v.setImageBitmap(selectedImage);
                isImage = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(MainActivity.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }
}