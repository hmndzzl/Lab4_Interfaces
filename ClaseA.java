//Importar librerias para el sistema de perfiles
import java.util.HashMap;
import java.util.Map;

class ClaseA extends Climatizacion implements IA {
    private boolean ionizadorActivo = false; //Controlar el ionizador
    private String direccionVentilacion = "frontal"; //Dirección default de la ventilación
    private Map<String, Perfil> perfiles = new HashMap<>(); //Almacenar Perfiles

    @Override
    //Función para ajustar el nivel de ventilación
    public String ajustarNivelVentilacion(int nivel) {
        if (nivel >= 1 && nivel <= 5) {
            nivelVentilacion = nivel;
            return "Nivel de ventilación ajustado a " + nivel;
        }
        return "Error: Nivel de ventilación fuera de rango."; //Salida por si se ingresa un valor fuera de rango
    }

    //Función para seleccionar la posición de la ventilación
    @Override
    public String ventilacionDireccional(String direccion) {
        if (!estadoClimatizacion) return "Error: La climatización está apagada."; //Error si la ventilación está apagada
        switch (direccion.toLowerCase()) {
            case "parabrisas", "frontal", "pies", "combinado" -> {
                direccionVentilacion = direccion;
                return "Dirección de ventilación ajustada a " + direccion;
            }
            default -> {
                return "Error: Dirección no válida."; //Error si se ingresa una posición de la ventilación inválida
            }
        }
    }

    //Función para activar el ionizador
    @Override
    public String activarIonizador(int intensidad) {
        if (estadoClimatizacion && intensidad >= 1 && intensidad <= 3) {
            ionizadorActivo = true;
            return "Ionizador activado con intensidad " + intensidad;
        }
        return estadoClimatizacion ? "Error: Intensidad de ionizador fuera de rango." : "Error: La climatización está apagada."; //Retorna error si la climatización está apagada
    }

    //Función para configurar la calefacción de los asientos
    @Override
    public String calefaccionAsientos(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            return "Calefacción de asientos ajustada a nivel " + nivel;
        }
        return "Error: Nivel de calefacción de asientos fuera de rango."; //Salida si se ingresa un valor fuera de rango
    }

    //Función para configurar la calefacción del volante
    @Override
    public String calefaccionVolante(int nivel) {
        if (nivel == 1 || nivel == 2) {
            return "Calefacción de volante ajustada a nivel " + nivel;
        }
        return "Error: Nivel de calefacción de volante fuera de rango."; //Salida si se ingresa un valor fuera de rango
    }

    @Override
    public String activarCalefaccionRapida() {
        if (estadoClimatizacion) {
            temperatura += 5;
            return "Calefacción rápida activada. Temperatura incrementada temporalmente a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada."; //Error si la climatización está apagada
    }

    //Función para crear un nuevo perfil
    @Override
    public String crearPerfil(String nombre) {
        if (perfiles.size() < 3) { //Máximo de perfiles = 3
            perfiles.put(nombre, new Perfil(temperatura, nivelVentilacion, direccionVentilacion, ionizadorActivo));
            return "Perfil " + nombre + " creado exitosamente.";
        }
        return "Error: Máximo de perfiles alcanzado."; //Error si ya existen 3 perfiles
    }

    //Función para seleccionar un perfil previamente creado
    @Override
    public String seleccionarPerfil(String nombre) {
        Perfil perfil = perfiles.get(nombre);
        if (perfil != null) { //Cargar las configuraciones del perfil seleccionado
            this.temperatura = perfil.temperatura;
            this.nivelVentilacion = perfil.nivelVentilacion;
            this.direccionVentilacion = perfil.direccionVentilacion;
            this.ionizadorActivo = perfil.ionizadorActivo;
            return "Perfil " + nombre + " seleccionado.";
        }
        return "Error: Perfil no encontrado."; //Error si no existe el perfil
    }

    //Clase interna para almacenar las configuraciones de cada perfil
    private static class Perfil {
        int temperatura;
        int nivelVentilacion;
        String direccionVentilacion;
        boolean ionizadorActivo;

        //Inicializador
        Perfil(int temperatura, int nivelVentilacion, String direccionVentilacion, boolean ionizadorActivo) {
            this.temperatura = temperatura;
            this.nivelVentilacion = nivelVentilacion;
            this.direccionVentilacion = direccionVentilacion;
            this.ionizadorActivo = ionizadorActivo;
        }
    }
}