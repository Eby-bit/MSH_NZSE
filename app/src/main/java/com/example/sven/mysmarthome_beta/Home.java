package com.example.sven.mysmarthome_beta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity{

    private static garageActivity garage;
    public void turnOffAll(){
    }
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Homefinity");
        System.out.println("Moin moin");
    }
    public void openLayout(View view){
        String button_text;
        button_text= ((Button) view).getText().toString();

        if(button_text.equals("Bathroom")){
            Intent intent=new Intent(this, bathroomActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(button_text.equals("Garage")){
            Intent intent=new Intent(this, garageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if(button_text.equals("Living Room")){
            Intent intent=new Intent(this, livingRoomActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(button_text.equals("Kitchen")){
            Intent intent=new Intent(this, kitchenActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }

    public void PowerOff(View view){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        turnOffAll();
                        /*
                        ImageView garagelightOff= (ImageView) findViewById(R.id.imageView_lightOff_garage);
                        ImageView livingRoomlightOff= (ImageView) findViewById(R.id.imageView_lightOff_livingroom);
                        ImageView bathroomlightOff= (ImageView) findViewById(R.id.imageView_lightOff_bathroom);
                        ImageView kitchenlightOff= (ImageView) findViewById(R.id.imageView_lightOff_kitchen);

                        ImageView garagelightOn= (ImageView) findViewById(R.id.imageView_lightOn_garage);
                        ImageView livingRoomlightOn= (ImageView) findViewById(R.id.imageView_lightOn_livingroom);
                        ImageView bathroomlightOn= (ImageView) findViewById(R.id.imageView_lightOn_bathroom);
                        ImageView kitchenlightOn= (ImageView) findViewById(R.id.imageView_lightOn_kitchen);

                        garagelightOff.setVisibility(View.VISIBLE);
                        livingRoomlightOff.setVisibility(View.VISIBLE);
                        bathroomlightOff.setVisibility(View.VISIBLE);
                        kitchenlightOff.setVisibility(View.VISIBLE);

                        garagelightOn.setVisibility(View.INVISIBLE);
                        livingRoomlightOn.setVisibility(View.INVISIBLE);
                        bathroomlightOn.setVisibility(View.INVISIBLE);
                        kitchenlightOn.setVisibility(View.INVISIBLE);
                        */
                        //Toast.makeText(getApplicationContext(),
                          //      "Alle Benutzer ausgeschaltet!", Toast.LENGTH_LONG).show();

                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setMessage("Switch Off Power for Consumers?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        System.out.println("Saving Main Home");
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        System.out.println("Restoring Main Home");
    }
}
