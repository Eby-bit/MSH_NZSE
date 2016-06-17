package com.example.sven.mysmarthome_beta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Sven on 17.05.2016.
 */
public class kitchenActivity extends AppCompatActivity {
    private ArrayList<Light> kitchenLight;
    private ArrayList<Fridge> kitchenFridge;
    private static Heating kitchenHeating;

    private Integer heatingTemperature;

    public static Heating getKitchenHeating() {
        return kitchenHeating;
    }

    public static void setKitchenHeating(Heating kitchenHeating) {
        kitchenActivity.kitchenHeating = kitchenHeating;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        setTitle("Kitchen");
        if(heatingTemperature==null) heatingTemperature=14;
        this.kitchenLight = new ArrayList<>();
        this.kitchenLight.add(new Light(false));
        this.kitchenFridge = new ArrayList<>();
        this.kitchenFridge.add(new Fridge(false));
        final TextView temp= (TextView) findViewById(R.id.textView_heatingCurrTemp);
        final ProgressBar progTemp= (ProgressBar) findViewById(R.id.progressBar_heatingCurrTemp);
        final ImageButton plus= (ImageButton) findViewById(R.id.imageButton_heatingPlus);
        final ImageButton minus= (ImageButton) findViewById(R.id.imageButton_heatingMinus);
        final Switch lightSwitch = (Switch) findViewById(R.id.switch_Lights);
        final Switch fridgeSwitch = (Switch) findViewById(R.id.switch_fridgePower);
        final Switch heatingSwitch = (Switch) findViewById(R.id.switch_heatingPower);

        heatingSwitch.setChecked(true);
        kitchenHeating=new Heating();

        temp.setText(heatingTemperature.toString() + "°");
        progTemp.setProgress(heatingTemperature);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if(heatingTemperature.intValue()<kitchenHeating.getMaxTemp().intValue()&& heatingSwitch.isChecked()){
                    heatingTemperature++;
                    temp.setText(heatingTemperature.toString() + "°");
                    progTemp.setProgress(heatingTemperature);
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if(heatingTemperature.intValue()>kitchenHeating.getMinTemp().intValue() && heatingSwitch.isChecked()){
                    heatingTemperature--;
                    temp.setText(heatingTemperature.toString() + "°");
                    progTemp.setProgress(heatingTemperature);
                }
            }
        });

        heatingSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    temp.setText(heatingTemperature.toString() + "°");
                    progTemp.setProgress(heatingTemperature);
                }
                else{
                    temp.setText(kitchenHeating.getOff().toString() + "°");
                    progTemp.setProgress(kitchenHeating.getOff());
                }
            }
        });
        lightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    kitchenLight.get(0).setLightPower(true); // Getestet - Status wird gesetzt
                }
                else{
                    kitchenLight.get(0).setLightPower(false); // Getestet - Status wird gesetzt
                }
            }
        });
        fridgeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    kitchenFridge.get(0).setFridgePower(true); // Getestet - Status wird gesetzt
                }
                else{
                    kitchenFridge.get(0).setFridgePower(false); // Getestet - Status wird gesetzt
                }
            }
        });
    }
}
