package com.ashik.userpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ashik.userpage.utility.Worker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmOrder extends AppCompatActivity  {
    EditText editNoWorker;
    EditText editNoDays;
    EditText editLocation;
    Button button;
    Spinner spinner;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        editNoWorker=findViewById(R.id.edtnWorkers);
        editNoDays =findViewById(R.id.edtNDays);
        editLocation=findViewById(R.id.edtLocation);
        button=findViewById(R.id.BtnSave);
        spinner=findViewById(R.id.wtype);



        databaseReference=FirebaseDatabase.getInstance().getReference().child("Checkout");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkoutData();
                //clearing data
                editNoWorker.getText().clear();
                editNoDays.getText().clear();
                editLocation.getText().clear();
            }
        });


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

    }
    private  void checkoutData(){

        String worker_type = spinner.getSelectedItem().toString();
        String NoWorkers = editNoWorker.getText().toString();
        String nDays = editNoDays.getText().toString();
        String location = editLocation.getText().toString();


        Worker worker=new Worker(worker_type, NoWorkers, nDays,location);
        databaseReference.push().setValue(worker);
        Toast.makeText(this, "CheckOut Done...", Toast.LENGTH_SHORT).show();



    }

}