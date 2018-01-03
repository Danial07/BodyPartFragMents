package com.example.android.android_me;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.data.ImageAssets;

/**
 * Created by dell on 1/3/2018.
 */

public class Body_FragMent extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.body_fragment, container, false);
        ImageView iMAgeView = (ImageView) view.findViewById(R.id.Body);
        iMAgeView.setImageResource(ImageAssets.getHeadAtPOsition(0));
        return view;
    }
}
