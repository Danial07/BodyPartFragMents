package com.example.android.android_me.data;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 1/2/2018.
 */

public class ImageAssets {
    private static List<Integer> Heads = new ArrayList<Integer>(){{
        add(R.drawable.head1);
        add(R.drawable.head2);
        add(R.drawable.head3);
        add(R.drawable.head4);
        add(R.drawable.head5);
        add(R.drawable.head6);
        add(R.drawable.head7);
        add(R.drawable.head8);
        add(R.drawable.head9);
        add(R.drawable.head10);
        add(R.drawable.head11);
        add(R.drawable.head12);
    }};
    private static List<Integer> body = new ArrayList<Integer>(){{
        add(R.drawable.body1);
        add(R.drawable.body2);
        add(R.drawable.body3);
        add(R.drawable.body4);
        add(R.drawable.body5);
        add(R.drawable.body6);
        add(R.drawable.body7);
        add(R.drawable.body8);
        add(R.drawable.body9);
        add(R.drawable.body10);
        add(R.drawable.body11);
        add(R.drawable.body12);
    }};
    private static List<Integer> legs = new ArrayList<Integer>(){{
        add(R.drawable.legs1);
        add(R.drawable.legs2);
        add(R.drawable.legs3);
        add(R.drawable.legs4);
        add(R.drawable.legs5);
        add(R.drawable.legs6);
        add(R.drawable.legs7);
        add(R.drawable.legs8);
        add(R.drawable.legs9);
        add(R.drawable.legs10);
        add(R.drawable.legs11);
        add(R.drawable.legs12);
    }};
    private static List<Integer> AllBODyPArtS = new ArrayList<Integer>(){{
        addAll(Heads);
        addAll(body);
        addAll(legs);
    }};
    public static List<Integer> getHeads(){
        // Returning a fUll list of Heads
        return Heads;
    }
    public static int getHeadAtPOsition(int pOsition){
        //  RetUrning Head at specific pOsition
        return Heads.get(pOsition);
    }
    public static List<Integer> getBodies(){
        //  Returning a fUll list of Bodies
        return body;
    }
    public static int getBodyAtPOsition(int pOsition){
        //  RetUrning Body at specific pOsition
        return body.get(pOsition);
    }
    public static List<Integer> getLegs(){
        //  Returning a fUll list of Legs
        return legs;
    }
    public static int getLegAtPOsition(int pOsition){
        //  RetUrning Leg at specific pOsition
        return legs.get(pOsition);
    }
    public static void setHeadAtPOsition(int Head, int pOSition){
        //  Setting Head at Specific pOStion
        Heads.set(pOSition, Head);
    }
    public static void setBOdyAtPOsition(int Body, int pOsition){
        //  Setting Body at Specific pOStion
        body.set(pOsition, Body);
    }
    public static void setLegAtPOsition(int Legs, int pOsition){
        //  Setting Legs at Specific pOStion
        legs.set(pOsition, Legs);
    }
    public static List<Integer> getAllBODyPArtS(){
        // Returning a fUll list of All BODy pArtS
        return AllBODyPArtS;
    }
    public static void setAllBODyPArtS(List<Integer> AllboDyPArtS){
        //  Setting All BODy PArtS
        AllBODyPArtS = AllboDyPArtS;
    }
}
