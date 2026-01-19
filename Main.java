import java.util.Scanner;
import model.Radio;
import model.RadioCarToyota;

/**
 * Class implementing a Main operation of the program
 * 
 * @author Grupo 17
 * 
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Radio radio = new RadioCarToyota();
        int stateRadio = 0;
        int option = 0;

        while (option != 9) {

            if (!radio.isOn()) {
                System.out.println("\n===================================");
                System.out.println("=====   Radio Toyota Apagado   ====");
                System.out.println("===================================");
                System.out.println("1. Encender radio");
                System.out.print("Seleccione una opción: ");

                stateRadio = sc.nextInt();

                try {
                    if (stateRadio == 1) {
                        radio.turnOn();
                        System.out.println("Radio Encendida "+ radio.getFrequency() + " " + radio.getMode()); 
                    } else {
                        System.out.println("Opción inválida");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else {

                System.out.println("\n==================================");
                System.out.println("     Radio Toyota  "+ radio.getFrequency()+" "+ radio.getMode());
                System.out.println("==================================");
                System.out.println("1. Apagar radio");
                System.out.println("2. Subir frecuencia");
                System.out.println("3. Bajar frecuencia");
                System.out.println("4. Cambiar modo (AM/FM)");
                System.out.println("5. Guardar frecuencia");
                System.out.println("6. Seleccionar frecuencia guardada");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");

                option = sc.nextInt();

                try {
                    switch (option) {

                        case 1:
                            radio.turnOff();
                            System.out.println("\n---------- Apagando Radio ---------------");
                            stateRadio = 0;
                            break;

                        case 2:
                            System.out.println("\nFrecuencia actual: " + radio.levelUpFrequency());
                            break;

                        case 3:
                            System.out.println("\nFrecuencia actual: " + radio.levelDownFrequency());
                            break;

                        case 4:
                            if("AM".equals(radio.getMode())){
                                radio.changeMode("FM");
                                System.out.println("\nModo cambiado a " + radio.getMode());
                            } else  {
                                radio.changeMode("AM");
                                System.out.println("\nModo cambiado a " + radio.getMode());
                            }
                            break;

                        case 5:
                            System.out.print("\nNúmero de botón (1-12): ");
                            int buttonSave = sc.nextInt();
                            radio.saveFrequency(buttonSave, radio.getFrequency(), radio.getMode());
                            System.out.println("\nFrecuencia guardada");
                            break;

                        case 6:
                            System.out.print("\nNúmero de botón (1-12): ");
                            int buttonSelect = sc.nextInt();
                            float freq = radio.selectFrecuency(buttonSelect);
                            System.out.println("\nFrecuencia seleccionada: " + freq + " " + radio.getMode());
                            break;

                        case 7:
                            System.out.println("\nSaliendo del programa...");
                            break;

                        default:
                            System.out.println("\nOpción inválida");
                    }
                } catch (Exception e) {
                    System.out.println("\nError: " + e.getMessage());
                }
            }
        }

        sc.close();
    }
}
