//
// Programación Orientada a Objetos
// Sección 20
// Laboratorio #4 - Polimorfismo a través de Interfaces
// 
// Hugo Méndez - 241265
// Diego Calderón - 241263
// Pedro Caso - 241286
//

import java.util.Scanner; //Importar el scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Inicializar el scanner
        Climatizacion vehiculo = null;
        boolean continuar = true; //control del primer ciclo while

        while (continuar) {
            //Seleccionar la clase
            System.out.println("Seleccione la clase de vehículo:");
            System.out.println("1. Clase A");
            System.out.println("2. Clase B");
            System.out.println("3. Clase C");
            System.out.print("Ingrese el número de opción: ");
            int tipoVehiculo = scanner.nextInt();

            switch (tipoVehiculo) {
                case 1: //Clase A
                    vehiculo = new ClaseA();
                    continuar = false;
                    break;

                case 2: //Clase B
                    vehiculo = new ClaseB();
                    continuar = false;
                    break;

                case 3: //Clase C
                    vehiculo = new ClaseC();
                    continuar = false;
                    break;

                default: { //Salida si se agrega una opción inválida
                    System.out.println("Opción no válida, por favor ingrese una opción válida.");
                }
            }
        }
        

        boolean salir = false; //Control del menú
        while (!salir) {
            //Opciones generales
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Encender Climatización");
            System.out.println("2. Apagar Climatización");
            System.out.println("3. Ajustar Temperatura");
            System.out.println("4. Activar Modo Automático");
            System.out.println("5. Activar Desempañador");
            System.out.println("6. Mostrar Aviso de Mantenimiento");

            // Opciones específicas según clase
            if (vehiculo instanceof ClaseA) { //Opciones clase A
                System.out.println("7. Ajustar Nivel de Ventilación (1-5)");
                System.out.println("8. Ajustar Dirección de Ventilación");
                System.out.println("9. Activar Ionizador");
                System.out.println("10. Ajustar Calefacción de Asientos");
                System.out.println("11. Ajustar Calefacción de Volante");
                System.out.println("12. Activar Calefacción Rápida");
                System.out.println("13. Crear Perfil de Climatización");
                System.out.println("14. Seleccionar Perfil de Climatización");
            } else if (vehiculo instanceof ClaseB) { //Opciones clase B
                System.out.println("7. Ajustar Nivel de Ventilación (1-3)");
                System.out.println("8. Activar Modo Eco de Ventilación");
                System.out.println("9. Ajustar Calefacción de Asientos");
                System.out.println("10. Activar Calefacción Rápida");
            } else if (vehiculo instanceof ClaseC) { //Opciones clase C
                System.out.println("7. Activar Modo Silencioso");
                System.out.println("8. Control de Humedad");
                System.out.println("9. Activar Ventilación en Zona Específica");
                System.out.println("10. Activar Calefacción Rápida");
            }

            System.out.println("0. Salir");
            int opcion = scanner.nextInt(); //Ingresar opción
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                //Opciones Generales
                case 1 -> System.out.println(vehiculo.encender());
                case 2 -> System.out.println(vehiculo.apagar());
                case 3 -> {
                    System.out.print("Ingrese la cantidad de grados a ajustar (+/-): ");
                    int grados = scanner.nextInt();
                    System.out.println(vehiculo.ajustarTemperatura(grados));
                }
                case 4 -> System.out.println(vehiculo.modoAutomatico());
                case 5 -> System.out.println(vehiculo.activarDesempañador());
                case 6 -> System.out.println(vehiculo.mostrarAvisoMantenimiento());

                // Opciones dependiendo de la clase
                case 7 -> {
                    if (vehiculo instanceof ClaseA) { //Clase A
                        System.out.print("Ingrese el nivel de ventilación (1-5): ");
                        int nivel = scanner.nextInt();
                        System.out.println(((ClaseA) vehiculo).ajustarNivelVentilacion(nivel));
                    } else if (vehiculo instanceof ClaseB) { //Clase B
                        System.out.print("Ingrese el nivel de ventilación (1-3): ");
                        int nivel = scanner.nextInt();
                        System.out.println(((ClaseB) vehiculo).ajustarNivelVentilacion(nivel));
                    } else if (vehiculo instanceof ClaseC) { //Clase C
                        System.out.println(((ClaseC) vehiculo).modoSilencioso());
                    }
                }
                case 8 -> { 
                    if (vehiculo instanceof ClaseA) { //ClaseA
                        System.out.print("Ingrese la dirección de ventilación (parabrisas, frontal, pies, combinado): ");
                        String direccion = scanner.nextLine();
                        System.out.println(((ClaseA) vehiculo).ventilacionDireccional(direccion));
                    } else if (vehiculo instanceof ClaseB) { //ClaseB
                        System.out.println(((ClaseB) vehiculo).modoEcoVentilacion());
                    } else if (vehiculo instanceof ClaseC) { //ClaseC
                        System.out.print("Ingrese el nivel de humedad (1-3): ");
                        int nivel = scanner.nextInt();
                        System.out.println(((ClaseC) vehiculo).controlHumedad(nivel));
                    }
                }
                case 9 -> {
                    if (vehiculo instanceof ClaseA) { //Verificar que sea clase A
                        System.out.print("Ingrese la intensidad del ionizador (1-3): ");
                        int intensidad = scanner.nextInt();
                        System.out.println(((ClaseA) vehiculo).activarIonizador(intensidad));
                    } else if (vehiculo instanceof ClaseB) {
                        System.out.print("Ingrese el nivel de calefacción de los asientos (1-3): ");
                        int nivel = scanner.nextInt();
                        System.out.println(((ClaseB) vehiculo).calefaccionAsientos(nivel));
                    } else if (vehiculo instanceof ClaseC) {
                        System.out.print("Ingrese la zona de ventilación (parabrisas o pies): ");
                        String zona = scanner.nextLine();
                        System.out.println(((ClaseC) vehiculo).activarVentilacionZona(zona));
                    }
                }
                case 10 -> {
                    if (vehiculo instanceof ClaseA) { //Verificar que sea clase A
                        System.out.print("Ingrese el nivel de calefacción de los asientos (1-3): ");
                        int nivel = scanner.nextInt();
                        System.out.println(((ClaseA) vehiculo).calefaccionAsientos(nivel));
                    } else if (vehiculo instanceof ClaseB || vehiculo instanceof ClaseC) {
                        System.out.println(((ClaseB) vehiculo).activarCalefaccionRapida());
                    }
                }
                case 11 -> {
                    if (vehiculo instanceof ClaseA) { //Verificar que sea clase A
                        System.out.print("Ingrese el nivel de calefacción del volante (1-2): ");
                        int nivel = scanner.nextInt();
                        System.out.println(((ClaseA) vehiculo).calefaccionVolante(nivel));
                    }
                }
                case 12 -> {
                    if (vehiculo instanceof ClaseA) { //Verificar que sea clase A
                        System.out.println(((ClaseA) vehiculo).activarCalefaccionRapida());
                    }
                }
                case 13 -> {
                    if (vehiculo instanceof ClaseA) { //Verificar que sea clase A
                        System.out.print("Ingrese el nombre del perfil: ");
                        String nombre = scanner.nextLine();
                        System.out.println(((ClaseA) vehiculo).crearPerfil(nombre));
                    }
                }
                case 14 -> {
                    if (vehiculo instanceof ClaseA) { //Verificar que sea clase A
                        System.out.print("Ingrese el nombre del perfil a seleccionar: ");
                        String nombre = scanner.nextLine();
                        System.out.println(((ClaseA) vehiculo).seleccionarPerfil(nombre));
                    }
                }
                case 0 -> salir = true; //Salir del programa
                default -> System.out.println("Opción no válida."); //Salida si se ingresa una opción no válida
            }
        }
        scanner.close(); //Cerrar scanner
        System.out.println("Programa terminado."); //Confirmación que el programa terminó exitosamente
    }
}

