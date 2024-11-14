abstract class Climatizacion {
    protected boolean estadoClimatizacion = false; // Estado apagado por defecto
    protected int temperatura = 20; //Valor default de temperatura
    protected int nivelVentilacion = 1; //Valor default del nivel de ventilacion

    //Función para encender la climatizacion
    public String encender() {
        estadoClimatizacion = true;
        return "Climatización encendida.";
    }

    //Función para apagar la climatización
    public String apagar() {
        estadoClimatizacion = false;
        return "Climatización apagada.";
    }

    //Función para ajustar la temperatura
    public String ajustarTemperatura(int grados) {
        if (estadoClimatizacion) {
            temperatura += grados;
            return "Temperatura ajustada a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada.";
    }

    //Función para ajustar activar el modo automático
    public String modoAutomatico() {
        if (estadoClimatizacion) {
            temperatura = obtenerTemperaturaExterna();
            return "Modo automático activado. Temperatura ajustada a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada.";
    }

    //Función para obtener la temperatura externa
    private int obtenerTemperaturaExterna() {
        return 25; //Default 25º
    }

    //Función para activar el desempañador
    public String activarDesempañador() {
        if (estadoClimatizacion) {
            nivelVentilacion = 5;
            return "Desempañador activado.";
        }
        return "Error: La climatización está apagada."; //Error si la climatización está apagada
    }

    //Función para avisar si se necesita mantenimiento
    public String mostrarAvisoMantenimiento() {
        return "Aviso: Se recomienda realizar mantenimiento.";
    }
}