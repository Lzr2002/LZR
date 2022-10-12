package com.example.test;

import android.os.Bundle;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;



public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view;
        view=inflater.inflate(R.layout.fragment_2,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.rec);
        List<String> list=new ArrayList<>();
        for(int i=1;i<10;i++)
        {
            list.add("这是第"+i+" 个列表");
        }

        Context context=getContext();
        Myadapter adapter =new Myadapter(context,list);
        LinearLayoutManager layoutManager =new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
