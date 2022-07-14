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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BookingFragment extends Fragment {
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference order;
    recyclerAdapter myAdapter;
    ArrayList<Order> orderList;


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

        orderList = new ArrayList<>();
        myAdapter = new recyclerAdapter(getActivity(), orderList);
        recyclerView.setAdapter(myAdapter);


        String userID = Common.CurrentUser.getUserID();

        order.child(userID).child("orderRequests").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Order myOrder = dataSnapshot.getValue(Order.class);

                    orderList.add(myOrder);
                }

                for (Order list : orderList) {
                    Log.d("orderData", " \n" + list.getOrderId() + "\n");
                }

                sortOrders();

                myAdapter.notifyDataSetChanged();
                Log.d("orderData", "data received successfully");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("orderData", "data failed");
            }
        });


        return view;
    }

    private void sortOrders() {
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getOrderId().compareToIgnoreCase(o2.getOrderId());
            }
        });

        Collections.reverse(orderList);
    }


}