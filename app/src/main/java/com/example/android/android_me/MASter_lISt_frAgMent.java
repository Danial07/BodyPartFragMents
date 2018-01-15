package com.example.android.android_me;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


import java.util.List;


public class MASter_lISt_frAgMent extends Fragment {
    private List<Integer> bODyPArtS;
    private GridView grid;
    private View rootView;
    private Button button;
    public interface OnClickListener{
        void onClick(int inDex);
    }
    private OnClickListener McAllBack;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        try{
            McAllBack = (OnClickListener) getActivity();
            rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        }
        catch (ClassCastException ex){
            Log.e("ErrOr : ", ex.getMessage(), ex);
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        grid = (GridView) rootView.findViewById(R.id.MASter_GrID);
        button = (Button) rootView.findViewById(R.id.but1);
        if(grid != null) {
            grid.setAdapter(new MASter_liSt_ADApter(getActivity(), bODyPArtS));
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    McAllBack.onClick(i);
                }
            });
        }
        else {
            Toast.makeText(getActivity(), "grid nUll", Toast.LENGTH_SHORT).show();
        }
    }
    public void setbODyPArtS(List<Integer> bODyPArtS1){
        bODyPArtS = bODyPArtS1;
    }

    //  MetHOD fOr Setting griD vIew cOlUMnS
    public void setGridViewCOlUMnS(int cOlUMnS) {
        if(grid != null){
          grid.setNumColumns(cOlUMnS);
        }
    }

    //  MetHOD fOr getting bUttOn
    public Button getButton() {
        if(button != null){
            return button;
        }
        return null;
    }
}
