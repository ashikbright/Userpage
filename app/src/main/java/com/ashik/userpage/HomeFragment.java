package com.ashik.userpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    Button btnorder;
    ImageButton imgBtnLabour,imgBtnMistri,imgBtnTiles,imgBtnPaint,imgBtnFurniture,imgBtnPlumber,imgBtnWelder,imgBtnElectrician;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

       btnorder=view.findViewById(R.id.btnclchere);
       imgBtnLabour=view.findViewById(R.id.imgbtn_labour);
       imgBtnMistri=view.findViewById(R.id.imgbtn_mistri);
       imgBtnTiles=view.findViewById(R.id.imgbtn_tiles);
       imgBtnPaint=view.findViewById(R.id.imgbtn_painter);
       imgBtnFurniture=view.findViewById(R.id.imgbtn_furniture);
       imgBtnPlumber=view.findViewById(R.id.imgbtn_plumber);
       imgBtnWelder=view.findViewById(R.id.imgbtn_plumber2);
       imgBtnElectrician=view.findViewById(R.id.imgbtn_plumber3);

       btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnLabour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnMistri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnTiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnFurniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnPlumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnWelder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });

        imgBtnElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmorder();
            }
        });
    return view;
    }
    private  void confirmorder(){
    Intent intent=new Intent(getActivity(),ConfirmOrder.class);
    startActivity(intent);
}
}