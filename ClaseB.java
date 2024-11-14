class ClaseB extends Climatizacion implements IB {
    private boolean modoEcoActivo = false; //Modo ecológico por defecto apagado

    //Función para ajustar el nivel de ventilacion
    @Override
    public String ajustarNivelVentilacion(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            nivelVentilacion = nivel;
            return "Nivel de ventilación ajustado a " + nivel;
        }
        return "Error: Nivel de ventilación fuera de rango."; //Error si se ingresa un valor fuera de rango
    }

    //Función para activar el modo ecológico de ventilación
    @Override
    public String modoEcoVentilacion() {
        if (estadoClimatizacion) {
            modoEcoActivo = !modoEcoActivo;
            nivelVentilacion = modoEcoActivo ? Math.max(1, nivelVentilacion - 1) : nivelVentilacion;
            return "Modo Eco de ventilación " + (modoEcoActivo ? "activado" : "desactivado");
        }
        return "Error: La climatización está apagada."; //Error si la climatización está apagada
    }

    //Función para activar la calefacción de asientos
    @Override
    public String calefaccionAsientos(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            return "Calefacción de asientos ajustada a nivel " + nivel;
        }
        return "Error: Nivel de calefacción fuera de rango."; //Error si se ingresa un valor fuera de rango
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
