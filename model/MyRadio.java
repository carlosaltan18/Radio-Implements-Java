package model;
//grupo16
import java.util.HashMap;

public class MyRadio implements Radio { 
    private boolean isOn;
    private String mode;  
    public int frequency;
    public HashMap<Integer, Integer> presetButtons; 

    public MyRadio(boolean isOn, String mode, int frequency) {
        this.isOn = isOn;
        this.mode = mode;
        this.frequency = frequency;
        this.presetButtons = new HashMap<>();
    }

    public void turnOff() {
        this.isOn = false;
    }
    
    public void turnOn() {
        this.isOn = true;
    }
    
    public String levelUpFrequency() {
        if (mode.equals("FM")) {
            if (frequency < 1079) {
                frequency += 2;
            } else {
                frequency = 879; 
            }
        } else if (mode.equals("AM")) {
            if (frequency < 16100) {
                frequency += 100;
            } else {
                frequency = 5300; 
            }
        }
        return frequency / 10f + " " + mode; 
    }

    public String levelDownFrequency() {
        if (mode.equals("FM")) {
            if (frequency > 879) {
                frequency -= 2;
            } else {
                frequency = 1079; 
            }
        } else if (mode.equals("AM")) {
            if (frequency > 5300) {
                frequency -= 100;
            } else {
                frequency = 16100; 
            }
        }
        return frequency / 10f + " " + mode;
    }

    public void changeMode(String mode) {
        this.mode = mode;
        if (mode.equals("AM")) {
            frequency = 5300; 
        } else if (mode.equals("FM")) {
            frequency = 879; 
        }
    }

    public void saveFrequency(int button, float frequency, String mode) {
        presetButtons.put(button, (int)(frequency * 10));
    }

    public float selectFrecuency(int button) {
        if (presetButtons.containsKey(button)) {
            frequency = presetButtons.get(button);
            if (frequency > 1079) {
                mode = "AM";
            } else {
                mode = "FM";
            }
        }
        return frequency / 10f;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getMode() {
        return mode;
    }

    public float getFrequency() {
        return frequency / 10f;
    }
}