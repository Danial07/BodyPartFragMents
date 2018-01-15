package com.example.android.android_me;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.android_me.data.ImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if (savedInstanceState == null) {
            //  CreAting HeAD, BoDy and Leg frAgMentS
            HeAD_FragMent HeAD_FrAgMent = new HeAD_FragMent();
            Body_FragMent BODy_FrAgMent = new Body_FragMent();
            Leg_frAgMent leg_frAgMent = new Leg_frAgMent();

            //  Setting HeADS
            HeAD_FrAgMent.setHeaDs(ImageAssets.getHeads());

            //  Setting BODieS
            BODy_FrAgMent.setBODies(ImageAssets.getBodies());

            //  Setting LegS
            leg_frAgMent.setLegs(ImageAssets.getLegs());

            //  Setting HeAD, BoDy and Leg index
            Bundle extrAS = getIntent().getExtras();
            if(extrAS != null){
                int data = extrAS.getInt(MainActivity.wHicHFrAgMent);
                switch (data){
                    case 0 :
                        HeAD_FrAgMent.setIndex(extrAS.getInt(MainActivity.getHeAD));
                        BODy_FrAgMent.setIndex(0);
                        leg_frAgMent.setIndex(0);
                        break;
                    case 1 :
                        BODy_FrAgMent.setIndex(extrAS.getInt(MainActivity.getBODy));
                        HeAD_FrAgMent.setIndex(0);
                        leg_frAgMent.setIndex(0);
                        break;
                    case 2 :
                        leg_frAgMent.setIndex(extrAS.getInt(MainActivity.getLeGS));
                        HeAD_FrAgMent.setIndex(0);
                        BODy_FrAgMent.setIndex(0);
                        break;
                }
            }

            //  ADDing All frAgMentS to their reSpective cOntAinerS
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().add(R.id.HeADFragMent, HeAD_FrAgMent).commit();
            fragmentManager.beginTransaction().add(R.id.BODyFragMent, BODy_FrAgMent).commit();
            fragmentManager.beginTransaction().add(R.id.LegFragMent, leg_frAgMent).commit();
        }
    }

}
