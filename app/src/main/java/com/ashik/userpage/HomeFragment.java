package com.ashik.userpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);


        init(view);


    return view;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init(View view) {

        Button btnOrder;
        ImageButton imgBtnLabour, imgBtnMistri, imgBtnTiles, imgBtnPaint, imgBtnFurniture, imgBtnPlumber, imgBtnWelder, imgBtnElectrician;
        Animation scaleUp, scaleDown;

        btnOrder =view.findViewById(R.id.btn_click_here);
        imgBtnLabour=view.findViewById(R.id.imgbtn_labour);
        imgBtnMistri=view.findViewById(R.id.imgbtn_mistri);
        imgBtnTiles=view.findViewById(R.id.imgbtn_tiles);
        imgBtnPaint=view.findViewById(R.id.imgbtn_painter);
        imgBtnFurniture=view.findViewById(R.id.imgbtn_furniture);
        imgBtnPlumber=view.findViewById(R.id.imgbtn_plumber);
        imgBtnWelder=view.findViewById(R.id.imgbtn_plumber2);
        imgBtnElectrician=view.findViewById(R.id.imgbtn_plumber3);


        scaleUp = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);

        btnOrder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    btnOrder.startAnimation(scaleUp);

                }else if(event.getAction()==MotionEvent.ACTION_DOWN){
                    btnOrder.startAnimation(scaleDown);
                }
                return false;
            }
        });


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getActivity(), ConfirmOrder.class));
            }
        });

        imgBtnLabour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    imgBtnLabour.startAnimation(scaleUp);

                }else if(event.getAction()==MotionEvent.ACTION_DOWN){
                    imgBtnLabour.startAnimation(scaleDown);
                }
                return false;
            }
        });

//        imgBtnLabour.setOnClickListener(v -> confirmOrder(0));

        imgBtnMistri.setOnClickListener(v -> confirmOrder(1));

        imgBtnTiles.setOnClickListener(v -> confirmOrder(2));

        imgBtnPaint.setOnClickListener(v -> confirmOrder(3));

        imgBtnFurniture.setOnClickListener(v -> confirmOrder(4));

        imgBtnPlumber.setOnClickListener(v -> confirmOrder(5));

        imgBtnWelder.setOnClickListener(v -> confirmOrder(6));

        imgBtnElectrician.setOnClickListener(v -> confirmOrder(7));

    }


    private  void confirmOrder(int selectedItem) {
    Intent intent = new Intent(getActivity(), ConfirmOrder.class);
    intent.putExtra("itemSelected", selectedItem);
    startActivity(intent);
    }


}