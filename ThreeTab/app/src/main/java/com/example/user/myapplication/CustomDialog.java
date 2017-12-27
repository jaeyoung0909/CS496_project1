package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Dialog;
import android.widget.Toast;

import java.util.List;

import DB.DbOpenHelper;

/**
 * Created by user on 2017-12-27.
 */

public class CustomDialog extends PhoneNumber
{
    private Context context;
    private DbOpenHelper mDbOpenHelper;
    public CustomDialog(Context context){
        this.context = context;
    }

    public void callFunction(final List<String> list){
        final Dialog dig = new Dialog(context);

        dig.requestWindowFeature(Window.FEATURE_NO_TITLE);
/*        SharedPreferences sp = getSharedPreferences("loadphone", 0);
        final SharedPreferences.Editor editor = sp.edit();*/

        dig.setContentView(R.layout.custom_dialog);
        dig.show();

        //커스텀 다이얼로그의 각 위젯들을 정의한다.
        final EditText name = (EditText) dig.findViewById(R.id.message);
        final EditText phone = (EditText) dig.findViewById(R.id.phonenumber);
        final Button okButton = (Button) dig.findViewById(R.id.okButton);
        final Button canceButton = (Button) dig.findViewById(R.id.cancelButton);
        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //확인 버튼 클릭시 메인 액티비티에서 설정한 main_label에
                //커스텀 다이얼로그에서 입력한 메시지를 대입한다.
               /* editor.putString("name", name.getText().toString());
                editor.putString("phone", phone.getText().toString());
                editor.commit();*/

                mDbOpenHelper.insertColumn(name.getText().toString(), phone.getText().toString());
                Toast toast = Toast.makeText(context, "추가하였습니다.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
                toast.show();
                dig.dismiss();;
            }
        });
        canceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context, "취소하였습니다.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
                toast.show();
                dig.dismiss();
            }
        });
    }

}
