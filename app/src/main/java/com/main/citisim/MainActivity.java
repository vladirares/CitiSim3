package com.main.citisim;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                TextView okmsg = (TextView) findViewById(R.id.okmsg);


                //------LOGARE-------
                okmsg.setText("");
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //okmsg.setText("ok");

                    if(isServicesOK())
                    openMap();

                }
                else
                {
                    AuthentificationException e = new AuthentificationException();
                    throw e;

                }

                //------LOGARE-------//
            }
        });
    }

    public void openMap(){
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }


    public boolean isServicesOK(){
        Log.d(TAG,"isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS) {
            Log.d(TAG,"isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Log.d(TAG,"isServicesOK: a version error occured");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else {
            Toast.makeText(this,"an error occured",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public class AuthentificationException extends RuntimeException{
        AuthentificationException(){
            super("Autentificare esuata");
        }
    }



}

