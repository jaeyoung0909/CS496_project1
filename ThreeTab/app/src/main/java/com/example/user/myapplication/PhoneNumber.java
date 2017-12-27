package com.example.user.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        /*ListView listview = (ListView)findViewById(R.id.listview1);

       List<String> list = new ArrayList<>();
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
       listview.setAdapter(adapter);*/

        ListView listview = (ListView) findViewById(R.id.listview1);
        ListViewAdapter adapter = new ListViewAdapter();

        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.iu),"IU1", "01036616302");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.iu),"IU2", "01024397233");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.iu),"IU3", "01036616302");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String titlteStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable icconDrawble = item.getIcon();
            }
        });
    }
}
