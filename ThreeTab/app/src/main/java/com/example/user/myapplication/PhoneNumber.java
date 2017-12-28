package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import DB.DbOpenHelper;

public class PhoneNumber extends AppCompatActivity {
    private ListViewAdapter adapter;
    private ListView listview;
    private List<ListViewItem> list;
    private ArrayList<ListViewItem> arraylist;
    private List<String> list1;
    private Cursor mCursor;
    private DbOpenHelper mDbopenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        final EditText editSearch = (EditText) findViewById(R.id.editSearch);
        listview = (ListView) findViewById(R.id.listview1);
        list = new ArrayList<>();
/*        SharedPreferences prefer = getSharedPreferences("loadphone",0);
        String val1 = prefer.getString("name",null);
        String val2 = prefer.getString("phone",null);
        list.add(mlistview(ContextCompat.getDrawable(this, R.drawable.iu),val1,val2));
        SharedPreferences.Editor editor = prefer.edit();
        editor.clear();
        editor.commit();*/
        Intent intent = getIntent();
        String val1 = intent.getStringExtra("name");
        String val2 = intent.getStringExtra("phone");
        if(val1!=null && val2!=null){
            list.add(mlistview(ContextCompat.getDrawable(this, R.drawable.iu), val1, val2));
        }
        settingList();

        list1 = new ArrayList<>();
        Button button = (Button) findViewById(R.id.diabutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //커스텀 다이얼로그를 생성한다.
                CustomDialog customDialog = new CustomDialog(PhoneNumber.this);
                customDialog.callFunction(list1);
            }
        });
        

        //복사
        arraylist = new ArrayList<ListViewItem>();
        arraylist.addAll(list);

        adapter = new ListViewAdapter(list, this);
        //리스트뷰에 adapter를 연결
        listview.setAdapter(adapter);

        //input창에 검색어를 입력시 이벤트 리스너 정의
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //input창에 입력할때마다 호출
                //search메소드를 호출
                String text = editSearch.getText().toString();
                search(text);
            }
        });

/*        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),  phoneclicked.class);
                //outExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값
                //intent.putExtra("profile", ContextCompat.getDrawable(this, R.drawable.iu));
                intent.putExtra("name", list.get(i).getTitle());
                intent.putExtra("number", list.get(i).getDesc());
                startActivity(intent);
            }
        });*/
    }
    public void Button_add(View view) {
        Intent intent = new Intent(this, phonenumber2.class);
        startActivity(intent);
    }
    public void search(String charText){
        list.clear();
        if(charText.length()==0){
            list.addAll(arraylist);
        }
        //문자 입력시
        else{
            //리스트의 모든 데이터를 검색
            for(int i=0; i<arraylist.size(); i++){
                if(arraylist.get(i).getTitle().toLowerCase().contains(charText)){
                    list.add(arraylist.get(i));
                }
            }
        }
        //리스트 데이터가 변경-> adapter를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();;
    }

    private void settingList(){
/*
        mCursor = null;
        mCursor = mDbopenHelper.getAllColumns();
*/
        list.add(mlistview(ContextCompat.getDrawable(this, R.drawable.iu),"abcd", "01036616302"));
        list.add(mlistview(ContextCompat.getDrawable(this, R.drawable.iu),"abdcc", "01036616302"));
        list.add(mlistview(ContextCompat.getDrawable(this, R.drawable.iu),"aaaadd", "01036616302"));
/*
        if(mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    list.add(mlistview(ContextCompat.getDrawable(this, R.drawable.iu), mCursor.getString(mCursor.getColumnIndex("name")), mCursor.getString(mCursor.getColumnIndex("contact"))));
                } while (mCursor.moveToNext());
            }
        }*/
    }
    public ListViewItem mlistview(Drawable icon, String title, String desc){
        ListViewItem item = new ListViewItem();
        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        return item;
    }
}
