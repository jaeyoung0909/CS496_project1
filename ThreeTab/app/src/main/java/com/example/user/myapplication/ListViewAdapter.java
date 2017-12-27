package com.example.user.myapplication; /**
 * Created by user on 2017-12-26.
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.renderscript.Sampler;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    //private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    private LayoutInflater inflate; //
    private ValueHolder viewHolder;
    private List<ListViewItem> list;
    private Context context;

    //ListviewAdapter의 생성자
    public ListViewAdapter(List<ListViewItem> list, Context context){
        //this.listViewItemList = listViewItemList; //
        this.list = list;
        this.context = context; //
        this.inflate = LayoutInflater.from(context); //
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //final Context context = parent.getContext();
        if(convertView==null){
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.listview_item, parent, false);
            convertView = inflate.inflate(R.layout.listview_item,null);

            viewHolder = new ValueHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imageview1);
            viewHolder.title = (TextView) convertView.findViewById(R.id.textview1);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.textview2);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ValueHolder)convertView.getTag();
        }
        ListViewItem listViewItem = list.get(position);
        viewHolder.icon.setImageDrawable(listViewItem.getIcon());
        viewHolder.title.setText(listViewItem.getTitle());
        viewHolder.desc.setText(listViewItem.getDesc());
/*
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageview1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textview1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textview2);

        ListViewItem listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
*/
        return convertView;
    }/*
    public void addItem(Drawable icon, String title, String desc){
        ListViewItem item = new ListViewItem();
        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        listViewItemList.add(item);
    }*/
    static class ValueHolder{
        ImageView icon;
        TextView title;
        TextView desc;
    }
}