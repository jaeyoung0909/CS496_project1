package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new OmokView(this));


    }

    class OmokView extends View {
        Context context;
        int[][] arr2D = new int[11][11];
        Bitmap bitmapEmpty = BitmapFactory.decodeResource(getResources(), R.drawable.panelempty);
        Bitmap bitmapWhite = BitmapFactory.decodeResource(getResources(), R.drawable.stonewhite);
        Bitmap bitmapBlack = BitmapFactory.decodeResource(getResources(), R.drawable.stoneblack);
        boolean flagStone = true;

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
//      System.out.println("x:"+x);
//      System.out.println("y:"+y);
            int i = 999;
            int j = 999;
            if(35*0<x&&x<=35*1) {j=0;}
            if(35*1<x&&x<=35*2) {j=1;}
            if(35*2<x&&x<=35*3) {j=2;}
            if(35*3<x&&x<=35*4) {j=3;}
            if(35*4<x&&x<=35*5) {j=4;}

            if(35*5<x&&x<=35*6) {j=5;}
            if(35*6<x&&x<=35*7) {j=6;}
            if(35*7<x&&x<=35*8) {j=7;}
            if(35*8<x&&x<=35*9) {j=8;}

            if(35*0<y&&y<=35*1) {i=0;}
            if(35*1<y&&y<=35*2) {i=1;}
            if(35*2<y&&y<=35*3) {i=2;}
            if(35*3<y&&y<=35*4) {i=3;}
            if(35*4<y&&y<=35*5) {i=4;}

            if(35*5<y&&y<=35*6) {i=5;}
            if(35*6<y&&y<=35*7) {i=6;}
            if(35*7<y&&y<=35*8) {i=7;}
            if(35*8<y&&y<=35*9) {i=8;}

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
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(arr2D[i+1][j+1]==0){ canvas.drawBitmap(bitmapEmpty, j*35, i*35, new Paint());}
                    if(arr2D[i+1][j+1]==1){ canvas.drawBitmap(bitmapWhite, j*35, i*35, new Paint());}
                    if(arr2D[i+1][j+1]==2){ canvas.drawBitmap(bitmapBlack, j*35, i*35, new Paint());}

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
