package com.example.user.myapplication; /**
 * Created by user on 2017-12-26.
 */

import android.graphics.drawable.Drawable;

public class ListViewItem {
//    private Drawable iconDrawable ;
    private  int iconDrawable;
    private String titleStr ;
    private String descStr ;

    public void setIcon(int icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public int getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}
