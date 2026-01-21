package model;

public class RadioCar implements Radio {
    
    private boolean on;
    private String mode; // AM or FM
    private float frequency;
    private float[] fmButtons;
    private float [] amButtons;

    public RadioCar(){
        this.on = false;
        this.mode = "FM";
        this.frequency = 87.9f;
        this.fmButtons = new float[12];
        this.amButtons = new float[12];

    }

    @Override
    public void turnOn(){
        on = true;
    }

    @Override
    public void turnOff(){
        on = false;
    }

    @Override
    public boolean isOn(){
        return on;
    }

    @Override
    public String getMode(){
        return mode;
    }

    @Override
    public float getFrequency(){
        return frequency;
    }

    @Override
    public void changeMode(String mode){
        if (mode.equals("AM") || mode.equals("FM")) {
            this.mode = mode;

            if (mode.equals("FM")){
                frequency = 87.9f;

            } else {
                frequency =530;
            }
        } 

    }

    @Override
    public String levelUpFrequency(){
        if (mode.equals("FM")){
            frequency += 0.2f;
            if (frequency > 107.9f){
                frequency = 87.9f;
            } } else if (mode.equals("AM")){
                frequency += 10;
                if (frequency > 1610){
                    frequency =530;
                }
            }

            return mode + " " + String.format("%.1f", frequency);



        }
    
    @Override
    public String levelDownFrequency(){
        if (mode.equals("FM")){
            frequency -= 0.2f;
            if (frequency > 107.9f){
                frequency = 87.9f;
            } } else if (mode.equals("AM")){
                frequency -= 10;
                if (frequency > 1610){
                    frequency =530;
                }
            }

            return mode + " " + String.format("%.1f", frequency);



        }

    @Override
    public void saveFrequency(int button, float frequency, String mode) {
        if (button < 1 || button > 12) {
            return;
        }

        int index = button -1;

        if (mode.equals("FM")){
            fmButtons[index] = frequency;
        } else if (mode.equals("AM")){
            amButtons[index] = frequency;
        }

    }

    @Override
    public float selectFrecuency(int button) {
        if (button < 1 || button > 12){
            return frequency;

        }

        int index = button -1;

        if (mode.equals("FM")){
            frequency = fmButtons[index];

        } else if (mode.equals("AM")){
            frequency = amButtons[index];
        }

        return frequency;
    }


    }




