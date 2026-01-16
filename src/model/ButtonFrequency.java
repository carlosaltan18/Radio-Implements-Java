package model;
/**
 * Class representing a button's saved frequency and mode.
 * @author  Grupo 17
 */

public class ButtonFrequency {
    private float frequency;
    private String mode;

    public ButtonFrequency(float frequency, String mode) {
        this.frequency = frequency;
        this.mode = mode;
    }

    public float getFrequency() {
        return frequency;
    }

    public String getMode() {
        return mode;
    }

    
}
