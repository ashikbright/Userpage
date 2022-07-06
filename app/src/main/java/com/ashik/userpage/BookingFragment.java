package com.ashik.userpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class BookingFragment extends Fragment {
//    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_booking, container, false);
//        recyclerView=view.findViewById(R.id.recycler);
//        recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));
//        dataholder=new ArrayList<>();
//        datamodel ob1=new datamodel(R.drawable.empty,"Construction Workers","",R.drawable.empty);
//        dataholder.add(ob1);
//        datamodel ob2=new datamodel(R.drawable.empty,"Mistri","",R.drawable.empty);
//        dataholder.add(ob2);
//        datamodel ob3=new datamodel(R.drawable.empty,"Tiles|Marbel Misitri","",R.drawable.empty);
//        dataholder.add(ob3);
//        datamodel ob4=new datamodel(R.drawable.empty,"Painter","",R.drawable.empty);
//        dataholder.add(ob4);
//        datamodel ob5=new datamodel(R.drawable.empty,"Plumber","",R.drawable.empty);
//        dataholder.add(ob5);
//        datamodel ob6=new datamodel(R.drawable.empty,"Furniture Works","",R.drawable.empty);
//        dataholder.add(ob6);
//        datamodel ob7=new datamodel(R.drawable.empty,"Electrician","",R.drawable.empty);
//        dataholder.add(ob7);
//        datamodel ob8=new datamodel(R.drawable.empty,"Welder","",R.drawable.empty);
//        dataholder.add(ob8);
//        recyclerView.setAdapter(new adapter(dataholder));
        return view;
    }
}