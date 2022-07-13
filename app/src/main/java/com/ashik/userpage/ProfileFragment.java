package com.ashik.userpage;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import com.ashik.userpage.ViewHolder.ListAdapter;
import com.google.firebase.auth.FirebaseAuth;


import static android.content.Context.MODE_PRIVATE;


public class ProfileFragment extends Fragment {

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private String name, phone, email;
    private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        progressBar = view.findViewById(R.id.user_progressBar);
        listView = view.findViewById(R.id.user_profile_list_view);
        mAuth = FirebaseAuth.getInstance();

        progressBar.setVisibility(View.VISIBLE);

        try {
            SharedPreferences sp = requireActivity().getSharedPreferences("userInfo",MODE_PRIVATE);
            name = sp.getString("name", name);
            phone = sp.getString("phone", phone);
            email = sp.getString("email", email);

        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        displayList(name, phone, email);
        if (name != null && phone != null && email != null){
            progressBar.setVisibility(View.GONE);

        }else{
            progressBar.setVisibility(View.VISIBLE);
        }


        Handler handler = new Handler();
        handler.postDelayed(() -> progressBar.setVisibility(View.GONE), 5000);

        return view;
    }


    public void displayList(String name, String phone, String email) {

        int[] imageIDs = {
                R.drawable.profile_icon, R.drawable.mobile_icon, R.drawable.email_icon,
                R.drawable.share_icon, R.drawable.start_icon, R.drawable.logout_icon
        };

        String[] itemNames = {
                "Name", "Mobile", "Email", "Refer a Friend", "Rate Builders Hub", "LOG OUT"
        };

        String[] data = {
                name, phone, email, " ", " ", " "
        };

        ListAdapter listAdapter = new ListAdapter(getActivity(), imageIDs, itemNames, data);
        listView.setAdapter(listAdapter);
        
        listView.setOnItemClickListener((parent, view, position, id) -> {
            int selectedItemPosition = position + 1;

            switch (selectedItemPosition){
                case 1:
                        Toast.makeText(getActivity(), "Name", Toast.LENGTH_SHORT).show();
                        break;

                case 2:
                        Toast.makeText(getActivity(), "Phone", Toast.LENGTH_SHORT).show();
                        break;

                case 3:
                        Toast.makeText(getActivity(), "Email", Toast.LENGTH_SHORT).show();
                        break;

                case 4:
                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String body = "Download Builder Hub now!/n {appLink}" ;
                        String sub = "Share with your friends";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                        myIntent.putExtra(Intent.EXTRA_TEXT,body);
                        startActivity(Intent.createChooser(myIntent, "Share Using"));
                        break;

                case 5:
                           new AlertDialog.Builder(getActivity())
                                   .setIcon(R.drawable.start_icon)
                                   .setTitle("Rate this app")
                                   .setMessage(R.string.rate_dialog_message)
                                   .setPositiveButton("Rate It Now", (dialog, which) -> {

                                   })
                                   .setNeutralButton("Remind Me Later", (dialog, which) ->{

                                   })
                                   .setNegativeButton("No, Thanks", (dialog, which) -> {

                                   })
                                   .show();
                        break;

                case 6:

                    new AlertDialog.Builder(getActivity())
                            .setIcon(R.drawable.warning_icon)
                            .setTitle("LOGOUT")
                                .setMessage("Do you really want to log out?")
                            .setPositiveButton("Yes", (dialog, which) -> {
                                progressBar.setVisibility(View.VISIBLE);
                                mAuth.signOut();
                                progressBar.setVisibility(View.GONE);
                                Intent intent = new Intent(getActivity(), loginActivity.class);
                                startActivity(intent);
                            })
                            .setNegativeButton("No", null)
                            .show();
                    break;

            }
        });


    }

}