package com.ashik.userpage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ashik.userpage.Common.Common;
import com.ashik.userpage.Models.Order;
import com.ashik.userpage.ViewHolder.recyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;


public class BookingFragment extends Fragment {
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference order;
    recyclerAdapter myAdapter;
    ArrayList<Order> listOrder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        database = FirebaseDatabase.getInstance();
        order = database.getReference("Orders");

        recyclerView = view.findViewById(R.id.BookingsRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        listOrder = new ArrayList<>();
        myAdapter = new recyclerAdapter(getActivity(), listOrder);
        recyclerView.setAdapter(myAdapter);


        String userID = Common.CurrentUser.getUserID();

        order.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Order myOrder = dataSnapshot.getValue(Order.class);
                    String id = myOrder.getOrderId();
                    listOrder.add(myOrder);
                }

                myAdapter.notifyDataSetChanged();
                Log.d("orderData", "data received successfully");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("orderData", "data failed");
            }
        });



//        recyclerView=view.findViewById(R.id.recycler);
//        recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));
//        dataholder=new ArrayList<>();
//        datamodel ob1=new datamodel(R.drawable.empty,"Construction Workers","",R.drawable.empty);
//        dataholder.add(ob1);
//        datamodel ob2=new datamodel(R.drawable.empty,"Mistri","",R.drawable.empty);
//        dataholder.add(ob2);

//        recyclerView.setAdapter(new adapter(dataholder));
        return view;
    }


}