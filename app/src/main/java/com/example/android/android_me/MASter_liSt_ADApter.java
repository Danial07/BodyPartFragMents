package com.example.android.android_me;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;



public class MASter_liSt_ADApter extends BaseAdapter {
    private List<Integer> IMAgeIDS;
    private Context MCOntext;
    public MASter_liSt_ADApter(Context context, List<Integer> IMAgeIDS){
        MCOntext = context;
        this.IMAgeIDS = IMAgeIDS;
    }
    @Override
    public int getCount() {
        return IMAgeIDS.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = new ImageView(MCOntext);
            // Define the layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        // Set the image resource and return the newly created ImageView
        imageView.setImageResource(IMAgeIDS.get(position));
        return imageView;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
}
