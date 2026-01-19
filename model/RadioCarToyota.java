package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class implementing a Radio Interface for Toyota cars.
 * 
 * @author Grupo 17
 * 
 */
public class RadioCarToyota implements Radio {

    private boolean on;
    private String mode;
    private float currentFrequency;

    private static final float FM_MIN = 87.9f;
    private static final float FM_MAX = 107.9f;
    private static final float FM_STEP = 0.2f;

    private static final float AM_MIN = 530f;
    private static final float AM_MAX = 1610f;
    private static final float AM_STEP = 10f;

    private static final int NUM_BOTONES = 12;

    private Map<Integer, ButtonFrequency> buttonFrequencies;

    public RadioCarToyota() {
        this.on = false;
        this.mode = "FM";
        this.currentFrequency = FM_MIN;
        this.buttonFrequencies = new HashMap<>();
    }

    @Override
    public void turnOff() {
        this.on = false;
        
    }

    @Override
    public void turnOn() {
        this.on = true;
    }

    @Override
    public String levelUpFrequency() {

        if ("FM".equals(mode)) {
            currentFrequency += FM_STEP;
            currentFrequency = Math.round(currentFrequency * 10.0f) / 10.0f;

            if (currentFrequency > FM_MAX) {
                currentFrequency = FM_MIN;
            }
            return String.format("%.1f FM", currentFrequency);
        } else {
            currentFrequency += AM_STEP;

            if (currentFrequency > AM_MAX) {
                currentFrequency = AM_MIN;
            }
            return String.format("%.0f AM", currentFrequency);
        }
    }

    @Override
    public String levelDownFrequency() {

        if ("FM".equals(mode)) {
            currentFrequency -= FM_STEP;
            currentFrequency = Math.round(currentFrequency * 10.0f) / 10.0f;

            if (currentFrequency < FM_MIN) {
                currentFrequency = FM_MAX;
            }
            return String.format("%.1f FM", currentFrequency);
        } else {
            currentFrequency -= AM_STEP;

            if (currentFrequency < AM_MIN) {
                currentFrequency = AM_MAX;
            }
            return String.format("%.0f AM", currentFrequency);
        }
    }

    @Override
    public void changeMode(String mode) {
        if (!"AM".equals(mode) && !"FM".equals(mode)) {
            throw new IllegalArgumentException("Modo inválido");
        }

        this.mode = mode;
        if (mode.equals("FM")) {
            currentFrequency = FM_MIN;
        } else {
            currentFrequency = AM_MIN;
        }
    }

    @Override
    public void saveFrequency(int button, float frequency, String mode) {
        if (!on) {
            throw new IllegalStateException("El radio está apagado");
        }

        validateButton(button);

        buttonFrequencies.put(button, new ButtonFrequency(frequency, mode));
    }

    @Override
    public float selectFrecuency(int button) {

        validateButton(button);

        if (!buttonFrequencies.containsKey(button)) {
            throw new IllegalStateException("El botón " + button + " no tiene frecuencia guardada");
        }

        ButtonFrequency btnFreq = buttonFrequencies.get(button);
        this.currentFrequency = btnFreq.getFrequency();
        this.mode = btnFreq.getMode();

        return currentFrequency;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public String getMode() {
        return this.mode;
    }
    
    @Override
    public float getFrequency(){
        return currentFrequency;
    }

    private void validateButton(int button) {
        if (button < 1 || button > NUM_BOTONES) {
            throw new IllegalArgumentException(
                    "El botón debe estar entre 1 y " + NUM_BOTONES);
        }
    }

    @Override
    public String toString() {
        if (!on) {
            return "Radio: APAGADO";
        }

        String freqStr;
        if ("FM".equals(mode)) {
            freqStr = String.format("%.1f", currentFrequency);
        } else {
            freqStr = String.format("%.0f", currentFrequency);
        }

        return String.format("Radio: ENCENDIDO | %s %s", mode, freqStr);
    }

}
