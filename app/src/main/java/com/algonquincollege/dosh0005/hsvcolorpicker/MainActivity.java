package com.algonquincollege.dosh0005.hsvcolorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 * HSV color picker
 * Created by Harsh Doshi : dosh0005
 */

public class MainActivity extends Activity implements Observer, SeekBar.OnSeekBarChangeListener {

    public AboutDialogFragment aboutDialog;
    public hsv hsv;

    public SeekBar HueSB;
    public SeekBar SaturationSB;
    public SeekBar ValueSB;
    public TextView ColorSwatch;
    public TextView HueTV;
    public TextView SaturationTV;
    public TextView ValueTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ini elements
        aboutDialog = new AboutDialogFragment();
        hsv = new hsv();
        hsv.addObserver(this);
        ColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        HueSB = (SeekBar) findViewById(R.id.hueSB);
        HueTV = (TextView) findViewById(R.id.hue);
        SaturationSB = (SeekBar) findViewById(R.id.saturationSB);
        SaturationTV = (TextView) findViewById(R.id.saturation);
        ValueSB = (SeekBar) findViewById(R.id.valueSB);
        ValueTV = (TextView) findViewById(R.id.value);


        //
        HueSB.setOnSeekBarChangeListener(this);
        SaturationSB.setOnSeekBarChangeListener(this);
        ValueSB.setOnSeekBarChangeListener(this);
        ColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText( getApplicationContext(), getHSVMessage(), Toast.LENGTH_SHORT ).show();
                return true;
            }
        });

        this.updateView();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aboutmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        if(item.getItemId() == R.id.aboutMenu){
            aboutDialog.show( getFragmentManager(), "About Me" );
            return true;
        }

        return false;
    }

    //return a formatted message with hue, saturation and value
    private String getHSVMessage(){
        return getResources().getString(
                R.string.hsv_values, hsv.getHue(),
                hsv.getSaturation(),
                hsv.getValue());
    }


    //update view ColorSwatch with model HSV value
    private void updateColorSwatch() {
        float[] hsvColor = {hsv.getHue(), hsv.getSaturation()/100.f, hsv.getValue()/100.f};
        ColorSwatch.setBackgroundColor(Color.HSVToColor(hsvColor));
    }

    //update view HueSB with model Hue value
    private void updateHueSB(){
        HueSB.setProgress( hsv.getHue() );
    }

    //update view SaturationSB with model Saturation value
    private void updateSaturationSB(){
        SaturationSB.setProgress( hsv.getSaturation() );
    }

    //update view ValueSB with model Value (Brightness) value
    private void updateValueSB(){
        ValueSB.setProgress( hsv.getValue() );
    }

    //update all view components with model values
    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }



    @Override
    public void update(Observable observable, Object o) {
        this.updateView();
    }


    //SEEK BAR METHODS IMPLEMENTATION

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        //If came from user return
        if ( !b ) {
            return;
        }

        // - Change model with input value.
        // - Update Label with current value.
        switch ( seekBar.getId() ) {
            case R.id.hueSB:
                hsv.setHue(HueSB.getProgress());
                HueTV.setText(getResources().getString(R.string.hue_progress, i).toUpperCase());
                break;

            case R.id.saturationSB:
                hsv.setSaturation(SaturationSB.getProgress());
                SaturationTV.setText(getResources().getString(R.string.saturation_progress, i).toUpperCase());
                break;

            case R.id.valueSB:
                hsv.setValue(ValueSB.getProgress());
                ValueTV.setText(getResources().getString(R.string.value_progress, i).toUpperCase());
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        //Change text back to original value
        switch (seekBar.getId()) {
            case R.id.hueSB:
                HueTV.setText(getResources().getString(R.string.hue));
                break;
            case R.id.saturationSB:
                SaturationTV.setText(getResources().getString(R.string.saturation));
                break;
            case R.id.valueSB:
                ValueTV.setText(getResources().getString(R.string.value));
                break;
        }
    }


    //BUTTON METHODS IMPLEMENTATION

    public void onColorButtonClick(View view) {
        switch (view.getId()){
            case R.id.blackButton:
                hsv.colorBlue();
                break;
            case R.id.redButton:
                hsv.colorRed();
                break;
            case R.id.limeButton:
                hsv.colorLime();
                break;
            case R.id.blueButton:
                hsv.colorBlue();
                break;
            case R.id.yellowButton:
                hsv.colorYellow();
                break;
            case R.id.cyanButton:
                hsv.colorCyan();
                break;
            case R.id.magentaButton:
                hsv.colorMagenta();
                break;
            case R.id.silverButton:
                hsv.colorSilver();
                break;
            case R.id.grayButton:
                hsv.colorGray();
                break;
            case R.id.maroonButton:
                hsv.colorMaroon();
                break;
            case R.id.oliveButton:
                hsv.colorOlive();
                break;
            case R.id.greenButton:
                hsv.colorGreen();
                break;
            case R.id.purpleButton:
                hsv.colorPurple();
                break;
            case R.id.tealButton:
                hsv.colorTeal();
                break;
            case  R.id.navyButton:
                hsv.colorNavy();
                break;
        }

        Toast.makeText( getApplicationContext(), getHSVMessage(), Toast.LENGTH_SHORT ).show();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        int[] hsvColor = { hsv.getHue(), hsv.getSaturation(), hsv.getValue() };
        savedInstanceState.putIntArray("HSV", hsvColor);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        if (savedInstanceState != null && savedInstanceState.containsKey("HSV")){
            int[] hsvColor = savedInstanceState.getIntArray("HSV");

            if (hsvColor != null && hsvColor.length == 3) {
                hsv.setHSV(hsvColor[0],hsvColor[1],hsvColor[2]);
            }
        }
    }
}
