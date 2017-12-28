package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class phonenumber2 extends AppCompatActivity {
    private EditText name;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonenumber2);
        //커스텀 다이얼로그의 각 위젯들을 정의한다.
        name = (EditText) findViewById(R.id.message);
        phone = (EditText) findViewById(R.id.phonenumber);
        final Button okButton = (Button) findViewById(R.id.okButton);
        final Button canceButton = (Button) findViewById(R.id.cancelButton);
    }
    public void okclick(View view){
        Intent intent = new Intent(this, PhoneNumber.class);
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("phone",phone.getText().toString());
        startActivity(intent);
        Toast toast = Toast.makeText(this, "추가하였습니다.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }
    public void canclick(View view){
        Intent intent = new Intent(this, PhoneNumber.class);
        startActivity(intent);
        Toast toast = Toast.makeText(this, "취소하였습니다.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }
}
