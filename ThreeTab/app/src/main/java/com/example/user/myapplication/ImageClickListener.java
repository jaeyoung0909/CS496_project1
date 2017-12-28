package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by user on 2017-12-28.
 */

public class ImageClickListener implements OnClickListener {


    Context context;
    int imageID;
    public ImageClickListener (Context context, int imageID){
        this.context = context;
        this.imageID = imageID;
    }
    public void onClick(View view) {
        Intent intent = new Intent(context, Gallery_picture.class);
        intent.putExtra("image_ID", imageID);
        context.startActivity(intent);
    }


}
