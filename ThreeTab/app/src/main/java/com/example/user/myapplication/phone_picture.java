package com.example.user.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class phone_picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_picture);

        ImageView imageView = (ImageView)findViewById(R.id.imageview2);
        Intent intent = getIntent();

        int imageID = intent.getIntExtra("image", 0);
        imageView.setImageResource(imageID);
    }
}
