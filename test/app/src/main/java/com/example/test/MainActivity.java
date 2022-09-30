package com.example.test;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;

import android.os.Bundle;

import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment Fragment1,Fragment2,Fragment3,Fragment4;
    private LinearLayout linearlayout1,linearlayout2,linearlayout3,linearlayout4;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1=new Fragment1();
        Fragment2=new Fragment2();
        Fragment3=new Fragment3();
        Fragment4=new Fragment4();
        manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction()
                .add(R.id.framelayout1,Fragment1)
                //            .add(R.id.framelayout1,Fragment2)
                //            .add(R.id.framelayout1,Fragment3)
                //            .add(R.id.framelayout1,Fragment4)
                ;
        transaction.commit();
        linearlayout1=findViewById(R.id.linearlayout1);
        linearlayout2=findViewById(R.id.linearlayout2);
        linearlayout3=findViewById(R.id.linearlayout3);
        linearlayout4=findViewById(R.id.linearlayout4);
        linearlayout1.setOnClickListener(this);
        linearlayout2.setOnClickListener(this);
        linearlayout3.setOnClickListener(this);
        linearlayout4.setOnClickListener(this);
    }

    private void select(int i){
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.slide_out_right);
        switch (i){
            case 1:
                transaction.replace(R.id.framelayout1,Fragment1).commit();
                break;
            case 2:
                transaction.replace(R.id.framelayout1,Fragment2).commit();
                break;
            case 3:
                transaction.replace(R.id.framelayout1,Fragment3).commit();
                break;
            case 4:
                transaction.replace(R.id.framelayout1,Fragment4).commit();
                break;


        }

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linearlayout1:
                select(1);
                break;
            case R.id.linearlayout2:
                select(2);
                break;
            case R.id.linearlayout3:
                select(3);
                break;
            case R.id.linearlayout4:
                select(4);
                break;

        }

    }

}