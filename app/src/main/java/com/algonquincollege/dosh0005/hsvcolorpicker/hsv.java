package com.algonquincollege.dosh0005.hsvcolorpicker;

import java.util.Observable;

/**
 * HSV color picker
 * Created by Harsh Doshi : dosh0005
 */

public class hsv extends Observable {

    // Public
    public static final int MAX_HUE = 359;
    public static final int MIN_HUE = 0;
    public static final int MAX_SATURATION = 100;
    public static final int MIN_SATURATION = 0;
    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;
    // Private
    private int hue;
    private int saturation;
    private int value;

    // default const
    public hsv() {
        this( MIN_HUE, MIN_SATURATION, MIN_VALUE );
    }

    // custom const
    public hsv( int hue, int saturation, int value ) {
        super();
        setHSV(hue,saturation,value);
    }

    private void updateObservers(){
        this.setChanged();
        this.notifyObservers();
    }

    public void colorRed(){
        setHSV( MIN_HUE, MAX_SATURATION, MAX_VALUE );
    }
    public void colorLime(){
        setHSV( 120, 76, 80 );
    }
    public void colorBlue(){
        setHSV( 240, MAX_SATURATION, MAX_VALUE );
    }
    public void colorYellow(){
        setHSV( 60, MAX_SATURATION, MAX_VALUE );
    }
    public void colorCyan(){
        setHSV( 180, MAX_SATURATION, MAX_VALUE );
    }
    public void colorMagenta(){
        setHSV( 300, MAX_SATURATION, MAX_VALUE );
    }
    public void colorSilver(){
        setHSV( MIN_HUE, MIN_SATURATION, 75 );
    }
    public void colorGray(){
        setHSV( MIN_HUE, MIN_SATURATION, 50 );
    }
    public void colorMaroon(){
        setHSV( MIN_HUE, MAX_SATURATION, 50 );
    }
    public void colorOlive(){
        setHSV( 60, MAX_SATURATION, 50 );
    }
    public void colorGreen(){
        setHSV( 120, MAX_SATURATION, 50 );
    }
    public void colorPurple(){
        setHSV( 300, MAX_SATURATION, 50 );
    }
    public void colorTeal(){
        setHSV( 180, MAX_SATURATION, 50 );
    }
    public void colorNavy(){
        setHSV( 240, MAX_SATURATION, 50 );
    }
    public void colorBlack(){
        setHSV( MIN_HUE, MIN_SATURATION, MIN_VALUE );
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        if (hue <= this.MAX_HUE && hue >= this.MIN_HUE) {
            this.hue = hue;
        }
        this.updateObservers();
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        if (saturation <= this.MAX_SATURATION && saturation >= this.MIN_SATURATION) {
            this.saturation = saturation;
        }
        this.updateObservers();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value <= this.MAX_VALUE && value >= this.MIN_VALUE) {
            this.value = value;
        }
        this.updateObservers();
    }

    public void setHSV( int hue, int saturation, int value ) {
        setHue(hue);
        setSaturation(saturation);
        setValue(value);
    }

}
