package com.example.android.android_me;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.android_me.data.ImageAssets;

import static android.R.attr.button;
import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity implements MASter_lISt_frAgMent.OnClickListener{
    public final static String getHeAD = "getHeAD";
    public final static String getBODy = "getBODy";
    public final static String getLeGS = "getLeGS";
    public final static String wHicHFrAgMent = "getFrAgMent";
    private int HeADInDex;
    private int bODyInDex;
    private int legInDex;
    private int bODyPartIndex;
    private boolean MtwOPAne;
    private MASter_lISt_frAgMent MLF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MLF = (MASter_lISt_frAgMent) getFragmentManager().findFragmentById(R.id.MASterLISt_frAgMent);
        MLF.setbODyPArtS(ImageAssets.getAllBODyPArtS());
        if((LinearLayout) findViewById(R.id.DUAl_pAne) != null){
            MtwOPAne = true;
            if (savedInstanceState == null) {
                FragmentManager fragmentManager = getFragmentManager();
                //  CreAting HeAD, BoDy and Leg frAgMentS
                HeAD_FragMent HeAD_FrAgMent = new HeAD_FragMent();
                Body_FragMent BODy_FrAgMent = new Body_FragMent();
                Leg_frAgMent leg_frAgMent = new Leg_frAgMent();

                //  Setting HeADS
                HeAD_FrAgMent.setHeaDs(ImageAssets.getHeads());
                HeAD_FrAgMent.setIndex(0);

                //  Setting BODieS
                BODy_FrAgMent.setBODies(ImageAssets.getBodies());
                BODy_FrAgMent.setIndex(0);

                //  Setting LegS
                leg_frAgMent.setLegs(ImageAssets.getLegs());
                leg_frAgMent.setIndex(0);
                fragmentManager.beginTransaction().add(R.id.HeADFragMent, HeAD_FrAgMent).commit();
                fragmentManager.beginTransaction().add(R.id.BODyFragMent, BODy_FrAgMent).commit();
                fragmentManager.beginTransaction().add(R.id.LegFragMent, leg_frAgMent).commit();
            }
        }

        //  CHecking for Device OrientAtion in One pAne MODe
        else if(savedInstanceState != null && !MtwOPAne){
            bODyPartIndex = savedInstanceState.getInt(wHicHFrAgMent);
        }
    }

    @Override
    public void onClick(int inDex) {
        bODyPartIndex = inDex;
        if(MtwOPAne){
            int inD = bODyPartIndex / AverAgeBODyPArtS();
            switch (inD){
                case 0:
                    HeADInDex = bODyPartIndex % AverAgeBODyPArtS();
                    HeAD_FragMent HeAD_frAg = new HeAD_FragMent();
                    HeAD_frAg.setHeaDs(ImageAssets.getHeads());
                    HeAD_frAg.setIndex(HeADInDex);
                    getFragmentManager().beginTransaction().replace(R.id.HeADFragMent, HeAD_frAg).commit();
                    break;
                case 1:
                    bODyInDex = bODyPartIndex % AverAgeBODyPArtS();
                    Body_FragMent BODy_frag = new Body_FragMent();
                    BODy_frag.setBODies(ImageAssets.getBodies());
                    BODy_frag.setIndex(bODyInDex);
                    getFragmentManager().beginTransaction().replace(R.id.BODyFragMent, BODy_frag).commit();
                    break;
                case 2:
                    legInDex = bODyPartIndex % AverAgeBODyPArtS();
                    Leg_frAgMent Leg_frag = new Leg_frAgMent();
                    Leg_frag.setLegs(ImageAssets.getLegs());
                    Leg_frag.setIndex(legInDex);
                    getFragmentManager().beginTransaction().replace(R.id.LegFragMent, Leg_frag).commit();
                    break;
            }
        }
    }
    private int AverAgeBODyPArtS(){
        return ImageAssets.getAllBODyPArtS().size() / 3;
    }

    @Override
    public void onSaveInstanceState(Bundle cUrrentState) {
        super.onSaveInstanceState(cUrrentState);
        if(!MtwOPAne) {
            cUrrentState.putInt(wHicHFrAgMent, bODyPartIndex);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        //  Checking for Two pAne MODe and then Setting GridView and Button AccOrDing to twO pAne
        if(MtwOPAne) {
           MLF.setGridViewCOlUMnS(2);
            MLF.getButton().setVisibility(View.INVISIBLE);
        }
        //  It is One pAne MODe and Setting OnClickListener on Button
        else{
            MLF.getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int inDex = bODyPartIndex / AverAgeBODyPArtS();
                    Intent newActivity = null;
                    switch(inDex){
                        case 0 :
                            HeADInDex = bODyPartIndex % AverAgeBODyPArtS();
                            newActivity = new Intent(getApplicationContext(), AndroidMeActivity.class);
                            newActivity.putExtra(getHeAD, HeADInDex);
                            break;
                        case 1 :
                            bODyInDex = bODyPartIndex % AverAgeBODyPArtS();
                            newActivity = new Intent(getApplicationContext(), AndroidMeActivity.class);
                            newActivity.putExtra(getBODy, bODyInDex);
                            break;
                        case 2 :
                            legInDex = bODyPartIndex % AverAgeBODyPArtS();
                            newActivity = new Intent(getApplicationContext(), AndroidMeActivity.class);
                            newActivity.putExtra(getLeGS, legInDex);
                            break;
                    }
                    try {
                        newActivity.putExtra(wHicHFrAgMent, inDex);
                        startActivity(newActivity);
                    }
                    catch(NullPointerException ex){
                        Log.e("ErrOr : ", ex.getMessage());
                    }
                }
            });
        }
    }

}
