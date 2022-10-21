package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {

    private View view;
    private Context context;
    private List<String> list;

    public Myadapter(Context context,List<String> list) {
        this.context = context;
        this.list=list;
    }

    public Myadapter() {
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        Myholder holder;
        holder = new Myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView.setText(list.get(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Activity2.class);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();

    }
    public class Myholder extends RecyclerView.ViewHolder{
        private final TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView_item);
        }
    }
}

