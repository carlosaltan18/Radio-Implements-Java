package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.Radio;
import model.RadioCarToyota;

public class RadioCarToyotaTest {

    private Radio radio;
    
    @Before
    public void setUp() {
        radio = new RadioCarToyota();
    }

    @Test
    public void shouldSaveAndRestoreFrequencyWithMode() {
        radio.turnOn();

        radio.saveFrequency(1, 101.5f, "FM");
        radio.saveFrequency(2, 680f, "AM");

        float selectedFrequency = radio.selectFrecuency(2);

        assertEquals(680f, selectedFrequency, 0.0f);
        assertEquals("AM", radio.getMode());
    }

    @Test
    public void shouldWrapAroundWhenExceedingFmMaxFrequency() {
        radio.turnOn();
        radio.changeMode("FM");

        radio.saveFrequency(1, 107.9f, "FM");
        radio.selectFrecuency(1);

        String result = radio.levelUpFrequency();

        assertEquals("87.9 FM", result);
    }
}
