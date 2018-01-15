package com.example.android.android_me;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 1/15/2018.
 */

public class HeAD_FragMent extends Fragment {
    private List<Integer> HeADS;
    private int index;
    private final String TAG = "HeADS";
    private final String retriveHeADS = "retriveHeADS";
    private final String retrieveInDex = "retrieveInDex";
    private ImageView iMAgeView;

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.body_fragment, container, false);
        iMAgeView = (ImageView) rootView;
        iMAgeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index < HeADS.size()){
                    setiMAge(index);
                }
                else {
                    index = 0;
                    setiMAge(index);
                }
            }
        });
        if(savedInstanceState != null){
            HeADS = savedInstanceState.getIntegerArrayList(retriveHeADS);
            index = savedInstanceState.getInt(retrieveInDex);
            setiMAge(index);
        }
        else {
            if (HeADS != null) {
                setiMAge(index);
            } else {
                Log.d(TAG, "No Legs fOUnd");
            }
        }
        return rootView;
    }
    public void setHeaDs(List<Integer> HeADS){
        this.HeADS = HeADS;
    }
    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(retriveHeADS, (ArrayList) HeADS);
        outState.putInt(retrieveInDex, index);
    }

    private void setiMAge(int iMAgeInDex){
        iMAgeView.setImageResource(HeADS.get(iMAgeInDex));
    }
}
