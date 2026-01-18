package src.main;

import java.util.Scanner;
import src.model.Radio;
import src.model.RadioCarToyota;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Radio radio = new RadioCarToyota();

        int option = 0;

        while (option != 9) {
            System.out.println("==================================");
            System.out.println("=====       Radio Toyota      ====");
            System.out.println("==================================");
            System.out.println("1. Encender radio");
            System.out.println("2. Apagar radio");
            System.out.println("3. Subir frecuencia");
            System.out.println("4. Bajar frecuencia");
            System.out.println("5. Cambiar modo (AM/FM)");
            System.out.println("6. Guardar frecuencia");
            System.out.println("7. Seleccionar frecuencia guardada");
            System.out.println("8. Ver estado del radio");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            option = sc.nextInt();

            try {
                switch (option) {
                    case 1:
                        radio.turnOn();
                        System.out.println("Radio encendido");
                        break;

                    case 2:
                        radio.turnOff();
                        System.out.println("Radio apagado");
                        break;

                    case 3:
                        System.out.println("Frecuencia actual: " + radio.levelUpFrequency());
                        break;

                    case 4:
                        System.out.println("Frecuencia actual: " + radio.levelDownFrequency());
                        break;

                    case 5:
                        System.out.print("Ingrese modo (AM o FM): ");
                        String mode = sc.next();
                        radio.changeMode(mode.toUpperCase());
                        System.out.println("Modo cambiado a " + radio.getMode());
                        break;

                    case 6:
                        System.out.print("Número de botón (1-12): ");
                        int buttonSave = sc.nextInt();
                        System.out.print("Frecuencia a guardar: ");
                        float freqSave = sc.nextFloat();
                        System.out.print("Modo (AM o FM): ");
                        String modeSave = sc.next();
                        radio.saveFrequency(buttonSave, freqSave, modeSave.toUpperCase());
                        System.out.println("Frecuencia guardada");
                        break;

                    case 7:
                        System.out.print("Número de botón (1-12): ");
                        int buttonSelect = sc.nextInt();
                        float freq = radio.selectFrecuency(buttonSelect);
                        System.out.println("Frecuencia seleccionada: " + freq + " " + radio.getMode());
                        break;

                    case 8:
                        System.out.println(radio.toString());
                        break;

                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
