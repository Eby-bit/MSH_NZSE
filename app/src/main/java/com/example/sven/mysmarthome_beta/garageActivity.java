package com.example.sven.mysmarthome_beta;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;

/**
 * Created by Sven on 17.05.2016.
 */
public class garageActivity extends AppCompatActivity {

    private static final String PREFERENCES_GARAGE="garagePrefs";
    private static Boolean garage=false;
    private ArrayList<Light> garageLight;
    private ArrayList<Fridge> garageFridge;;

    public void turnOffAll(){
        for(Light Object: garageLight){
            Object.setLightPower(false);
        }
        for(Fridge Object: garageFridge){
            Object.setFridgePower(false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        setTitle("Garage");
        this.garageLight = new ArrayList<>();
        this.garageLight.add(new Light(false));
        this.garageFridge = new ArrayList<>();
        this.garageFridge.add(new Fridge(false));
        final Switch lightSwitch = (Switch) findViewById(R.id.switch_Lights);
        final Switch fridgeSwitch = (Switch) findViewById(R.id.switch_fridgePower);
        final SharedPreferences settings = getSharedPreferences(PREFERENCES_GARAGE, Context.MODE_PRIVATE);

        boolean garageLightSwitch= settings.getBoolean("garageLightPref", false);
        lightSwitch.setChecked(garageLightSwitch);
        lightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    garageLight.get(0).setLightPower(true); // Getestet - Status wird gesetzt
                    garage=true;
                }
                else{
                    garageLight.get(0).setLightPower(false); // Getestet - Status wird gesetzt
                    garage=false;
                }
                settings.edit().putBoolean("garageLightPref", garage).commit();
            }
        });
        fridgeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    garageFridge.get(0).setFridgePower(true); // Getestet - Status wird gesetzt
                }
                else{
                    garageFridge.get(0).setFridgePower(false); // Getestet - Status wird gesetzt
                }
            }
        });
    }
}
