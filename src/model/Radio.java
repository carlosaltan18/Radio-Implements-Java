package model; 
/**
 * Interface representing a Radio with basic functionalities.
 * 
 * @author Grupo 16, Grupo 17, Grupo 18 
 */
public interface Radio {

    void turnOff();

    void turnOn();

    String levelUpFrequency();

    String levelDownFrequency();

    void changeMode(String mode);

    void saveFrequency(int button, float frequency, String mode);

    float selectFrecuency(int button);

    boolean isOn();

    String getMode();


}