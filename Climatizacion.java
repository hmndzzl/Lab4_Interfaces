abstract class Climatizacion {
    protected boolean estadoClimatizacion = false;
    protected int temperatura = 20;
    protected int nivelVentilacion = 1;

    public String encender() {
        estadoClimatizacion = true;
        return "Climatización encendida.";
    }

    public String apagar() {
        estadoClimatizacion = false;
        return "Climatización apagada.";
    }

    public String ajustarTemperatura(int grados) {
        if (estadoClimatizacion) {
            temperatura += grados;
            return "Temperatura ajustada a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada.";
    }

    public String modoAutomatico() {
        if (estadoClimatizacion) {
            temperatura = obtenerTemperaturaExterna();
            return "Modo automático activado. Temperatura ajustada a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada.";
    }

    private int obtenerTemperaturaExterna() {
        return 25;
    }

    public String activarDesempañador() {
        if (estadoClimatizacion) {
            nivelVentilacion = 5;
            return "Desempañador activado.";
        }
        return "Error: La climatización está apagada.";
    }

    public String mostrarAvisoMantenimiento() {
        return "Aviso: Se recomienda realizar mantenimiento.";
    }
}