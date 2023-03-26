package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimatinAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ImageView imageView=findViewById(R.id.imageView9);
        imageView.animate().scaleYBy(100).setDuration(2000);
        imageView.animate().scaleXBy(100).setDuration(2000);
        imageView.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
