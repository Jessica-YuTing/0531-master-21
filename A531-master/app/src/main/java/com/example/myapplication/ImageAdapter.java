package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public ImageAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return 8;
    } //共 8個圖可以猜

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if(convertView == null) //使用convertView主要是緩存圖片View
        {
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(300,400)); //設定畫面大小
            imageView.setScaleType(ImageView.ScaleType.FIT_XY); //fitXY的目標是填充整個ImageView
        }

        else
            imageView = (ImageView) convertView;

        imageView.setImageResource(R.drawable.hidden);
        return imageView;
    }
}
