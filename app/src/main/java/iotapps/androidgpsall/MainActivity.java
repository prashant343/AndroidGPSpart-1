package iotapps.androidgpsall;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button locationbutton;
    gpstrackingservice gps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationbutton = (Button) findViewById(R.id.button);


        locationbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //gps class
                gps = new gpstrackingservice(MainActivity.this);

                //gps class variables
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();


                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{

                    // this else is for the condition when the user has not allowed the app to access the location we will present
                    // the setting screen to user in next tutorial.


                }

            }
        });
    }
    }

