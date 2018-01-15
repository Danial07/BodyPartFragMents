package com.example.android.android_me;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.data.ImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 1/3/2018.
 */

public class Body_FragMent extends Fragment {
    private List<Integer> BODieS;
    private int index;
    private final String TAG = "BODieS";
    private final String retriveBODieS = "retriveBODieS";
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
                if(index < BODieS.size()){
                    setiMAge(index);
                }
                else {
                    index = 0;
                    setiMAge(index);
                }
            }
        });
        if(savedInstanceState != null){
            BODieS = savedInstanceState.getIntegerArrayList(retriveBODieS);
            index = savedInstanceState.getInt(retrieveInDex);
            setiMAge(index);
        }
        else {
            if (BODieS != null) {
                setiMAge(index);
            } else {
                Log.d(TAG, "No Legs fOUnd");
            }
        }
        return rootView;
    }
    public void setBODies(List<Integer> BODieS){
        this.BODieS = BODieS;
    }
    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(retriveBODieS, (ArrayList) BODieS);
        outState.putInt(retrieveInDex, index);
    }

    private void setiMAge(int iMAgeInDex){
        iMAgeView.setImageResource(BODieS.get(iMAgeInDex));
    }
}
