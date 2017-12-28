package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);
        setContentView(new OmokView(this));
    }
    class OmokView extends View{
        Context context;
        int[][] arr2D = new int[101][101];
        Bitmap bitmapEmpty = BitmapFactory.decodeResource(getResources(), R.drawable.panelempty);
        Bitmap bitmapEmpty1 = Bitmap.createScaledBitmap(bitmapEmpty,400,400,true);
        Bitmap bitmapWhite = BitmapFactory.decodeResource(getResources(), R.drawable.stonewhite);
        Bitmap bitmapWhite1 = Bitmap.createScaledBitmap(bitmapWhite,40,40,true);
        Bitmap bitmapBlack = BitmapFactory.decodeResource(getResources(), R.drawable.stoneblack);
        Bitmap bitmapBlack1 = Bitmap.createScaledBitmap(bitmapBlack,40,40,true);
        boolean flagStone = true;
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
//      System.out.println("x:"+x);
//      System.out.println("y:"+y);
            int i = 999;
            int j = 999;
            for(int k=0; k<=99 ; k++){
                if(35*k<x&&x<=35*(k+1)){
                    j=k;
                }
                if(35*k<y&&y<=35*(k+1)){
                    i=k;
                }
            }
            if(!(i==999||j==999)&&arr2D[i+1][j+1]==0){
                if(flagStone){
                    arr2D[i+1][j+1]=1;
                }else{
                    arr2D[i+1][j+1]=2;
                }
                if(isGameOver(i+1,j+1)){
                    Toast toast = Toast.makeText(context, "수고하셨습니다.", Toast.LENGTH_LONG);
                    toast.show();
                }
                invalidate();
                flagStone =! flagStone;
            }
            Log.d("taekwon","e:"+event+"x:"+x+"y:+"+y);
            return super.onTouchEvent(event);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            for(int i=0;i<99;i++){
                for(int j=0;j<99;j++){
                    if(arr2D[i+1][j+1]==0){ canvas.drawBitmap(bitmapEmpty, j*35, i*35, new Paint());}
                    if(arr2D[i+1][j+1]==1){ canvas.drawBitmap(bitmapWhite1, j*35, i*35, new Paint());}
                    if(arr2D[i+1][j+1]==2){ canvas.drawBitmap(bitmapBlack1, j*35, i*35, new Paint());}

                }
            }
            super.onDraw(canvas);
        }
        public OmokView(Context context) {
            super(context);
            this.context = context;
        }
        private boolean isGameOver(int compensateI,int compensateJ){
            int countUp   = getCountUp(compensateI,compensateJ);
            int countDown   = getCountDown(compensateI,compensateJ);
            int countLeft   = getCountLeft(compensateI,compensateJ);
            int countRight   = getCountRight(compensateI,compensateJ);
            int countLeftUp  = getCountLeftUp(compensateI,compensateJ);
            int countLeftDown  = getCountLeftDown(compensateI,compensateJ);
            int countRightUp  = getCountRightUp(compensateI,compensateJ);
            int countRightDown  = getCountRightDown(compensateI,compensateJ);

            int countHorizontal = countLeft + countRight + 1;
            int countVertical = countUp + countDown + 1;
            int countSlush  = countRightUp + countLeftDown + 1;
            int countBackSlush = countRightDown + countLeftUp + 1;

            if(countHorizontal==5) {return true;}
            if(countVertical==5) {return true;}
            if(countSlush==5)  {return true;}
            if(countBackSlush==5) {return true;}

            return false;
        }
        private int getCountRightDown(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateJ++;
                compensateI++;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
        private int getCountRightUp(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateJ++;
                compensateI--;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
        private int getCountLeftDown(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateJ--;
                compensateI++;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
        private int getCountLeftUp(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateJ--;
                compensateI--;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
        private int getCountRight(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateJ++;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
        private int getCountLeft(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateJ--;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
        private int getCountUp(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateI--;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }

        private int getCountDown(int compensateI,int compensateJ){
            int count=0;
            int intStone = 2 ;
            if(flagStone){intStone=1;}

            while(true){
                compensateI++;
                if(arr2D[compensateI][compensateJ]==intStone){
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }


    }
}

