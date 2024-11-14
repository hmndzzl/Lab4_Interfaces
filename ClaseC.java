class ClaseC extends Climatizacion implements IC {
    private int nivelHumedad = 2; //Valor default de humedad

    //Función para activar el modo silencioso
    @Override
    public String modoSilencioso() {
        if (estadoClimatizacion) {
            nivelVentilacion = Math.min(1, nivelVentilacion);
            return "Modo silencioso activado.";
        }
        return "Error: La climatización está apagada."; //Error si la climatización está apagada
    }

    //Función para contorlar el nivel de humedad
    @Override
    public String controlHumedad(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            nivelHumedad = nivel;
            return "Humedad ajustada a nivel " + nivel;
        }
        return "Error: Nivel de humedad fuera de rango."; //Error si el nivel de humedad no está en el rango permitido
    }

    //Función para activar la ventilación dirigida a una zona
    @Override
    public String activarVentilacionZona(String zona) {
        if (estadoClimatizacion) {
            return "Ventilación dirigida a la zona: " + zona;
        }
        return "Error: La climatización está apagada."; //Error si la climatización está apagada
    }

    //Función para activar la calefacción rápida
    @Override
    public String activarCalefaccionRapida() {
        if (estadoClimatizacion) {
            temperatura += 5;
            return "Calefacción rápida activada. Temperatura incrementada temporalmente a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada."; //Error si la climatización está apagada
    }
}