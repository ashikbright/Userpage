package com.ashik.userpage.utility;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.ashik.userpage.R;

public class NetworkChangeListener extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        try{
            if (!isOnline(context)){
                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                View layoutDialogView = inflater.inflate(R.layout.check_internet_dialog, null);
                Button btnRetry = layoutDialogView.findViewById(R.id.btnRetry);
                builder.setView(layoutDialogView);

                AlertDialog dialog = builder.create();
                dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.setCancelable(false);
                dialog.show();

                btnRetry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        onReceive(context, intent);
                    }
                });

            }

        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

    }


    public boolean isOnline(Context context){
        try{
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }

    }

    public void showDialog(Context context, Intent intent) {




    }

}
