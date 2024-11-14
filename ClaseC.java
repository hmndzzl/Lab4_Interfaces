class ClaseC extends Climatizacion implements IC {
    private int nivelHumedad = 2;

    @Override
    public String modoSilencioso() {
        if (estadoClimatizacion) {
            nivelVentilacion = Math.min(1, nivelVentilacion);
            return "Modo silencioso activado.";
        }
        return "Error: La climatización está apagada.";
    }

    @Override
    public String controlHumedad(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            nivelHumedad = nivel;
            return "Humedad ajustada a nivel " + nivel;
        }
        return "Error: Nivel de humedad fuera de rango.";
    }

    @Override
    public String activarVentilacionZona(String zona) {
        if (estadoClimatizacion) {
            return "Ventilación dirigida a la zona: " + zona;
        }
        return "Error: La climatización está apagada.";
    }

    @Override
    public String activarCalefaccionRapida() {
        if (estadoClimatizacion) {
            temperatura += 5;
            return "Calefacción rápida activada. Temperatura incrementada temporalmente a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada.";
    }
}