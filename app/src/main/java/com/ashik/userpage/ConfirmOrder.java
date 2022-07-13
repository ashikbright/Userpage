package com.ashik.userpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ashik.userpage.Common.Common;
import com.ashik.userpage.Models.Order;
import com.ashik.userpage.Models.Request;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ConfirmOrder extends AppCompatActivity {
    EditText editTotalWorkers;
    EditText editNoDays;
    EditText editLocation;
    Button placeOrderButton;
    Spinner spinner;
    FirebaseDatabase database;
    DatabaseReference orderReference;
    DatabaseReference requestReference;
    public static int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        editTotalWorkers = findViewById(R.id.edtnWorkers);
        editNoDays = findViewById(R.id.edtNDays);
        editLocation = findViewById(R.id.edtLocation);
        placeOrderButton = findViewById(R.id.BtnSave);
        spinner = findViewById(R.id.wtype);


        database = FirebaseDatabase.getInstance();
        requestReference = database.getReference().child("Orders");
        orderReference = requestReference.child(Common.CurrentUser.getUserID());

        String[] workerType = getResources().getStringArray(R.array.worker_type);

        Intent mIntent = getIntent();
        int selectedItem = mIntent.getIntExtra("itemSelected", 0);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(this, R.layout.worker_type_spinner_layout, workerType);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(selectedItem);


        orderReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Log.d("ColumnExist", "column found");
                } else {
                    Log.d("ColumnExist", "column not found");
                    counter = 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = checkoutData();
                if (res == 1) {
                    editTotalWorkers.getText().clear();
                    editNoDays.getText().clear();
                    editLocation.getText().clear();
                }

            }
        });

    }


    private int checkoutData() {

        String worker_type = spinner.getSelectedItem().toString();
        String totalWorkers = editTotalWorkers.getText().toString();
        String totalDays = editNoDays.getText().toString();
        String address = editLocation.getText().toString();
        String orderId = String.valueOf(System.currentTimeMillis());
        String date = getDate();


        if (totalWorkers.isEmpty()) {
            editTotalWorkers.setError("required!");
            editTotalWorkers.requestFocus();
            return 0;
        }

        if (totalDays.isEmpty()) {
            editNoDays.setError("required!");
            editNoDays.requestFocus();
            return 0;
        }

        if (address.isEmpty()) {
            editLocation.setError("required!");
            editLocation.requestFocus();
            return 0;
        }

        Request request = new Request(
                Common.CurrentUser.getUserID(),
                Common.CurrentUser.getName(),
                Common.CurrentUser.getPhone(),
                Common.CurrentUser.getEmail()
        );


        Order workInfo = new Order(
                orderId,
                worker_type,
                totalWorkers,
                totalDays,
                address,
                date
        );

        orderReference.child("userInfo").setValue(request);

        DatabaseReference currentOrder = orderReference.child(String.valueOf(counter));
        counter++;
        currentOrder.setValue(workInfo);


//        new Database(getBaseContext()).cleanCart();
        Toast.makeText(this, "Thank you order placed.", Toast.LENGTH_SHORT).show();
        finish();


        return 1;
    }

    private String getDate() {
        Date c = Calendar.getInstance().getTime();
        Log.d("currentTime", "Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        return formattedDate;
    }

}