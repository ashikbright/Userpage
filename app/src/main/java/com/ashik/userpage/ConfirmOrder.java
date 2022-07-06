package com.ashik.userpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ashik.userpage.utility.Worker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class ConfirmOrder extends AppCompatActivity  {
    EditText editNworker;
    EditText editNdays;
    EditText editLocation;
    Button button;
    Spinner spinner;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNworker=findViewById(R.id.edtnWorkers);
        editNdays=findViewById(R.id.edtNDays);
        editLocation=findViewById(R.id.edtLocation);
        button=findViewById(R.id.BtnSave);
        spinner=findViewById(R.id.wtype);

        databaseReference=FirebaseDatabase.getInstance().getReference().child("Checkout");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkoutdata();
                //clearing data
                editNworker.getText().clear();
                editNdays.getText().clear();
                editLocation.getText().clear();
            }
        });

    }
    private  void checkoutdata(){

        String worker_type=spinner.getSelectedItem().toString();
        String nworkers=editNworker.getText().toString();
        String ndays=editNdays.getText().toString();
        String location=editLocation.getText().toString();
        /*if(worker_type=="Choose Worker Type")
        {
            Toast.makeText(this, "Choose a Worker!!!", Toast.LENGTH_SHORT).show();
        }
        else{}*/
        Worker worker=new Worker(worker_type,nworkers,ndays,location);
        databaseReference.push().setValue(worker);
        Toast.makeText(this, "CheckOut Done...", Toast.LENGTH_SHORT).show();



    }

}