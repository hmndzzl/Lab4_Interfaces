class ClaseB extends Climatizacion implements IB {
    private boolean modoEcoActivo = false;

    @Override
    public String ajustarNivelVentilacion(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            nivelVentilacion = nivel;
            return "Nivel de ventilación ajustado a " + nivel;
        }
        return "Error: Nivel de ventilación fuera de rango.";
    }

    @Override
    public String modoEcoVentilacion() {
        if (estadoClimatizacion) {
            modoEcoActivo = !modoEcoActivo;
            nivelVentilacion = modoEcoActivo ? Math.max(1, nivelVentilacion - 1) : nivelVentilacion;
            return "Modo Eco de ventilación " + (modoEcoActivo ? "activado" : "desactivado");
        }
        return "Error: La climatización está apagada.";
    }

    @Override
    public String calefaccionAsientos(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            return "Calefacción de asientos ajustada a nivel " + nivel;
        }
        return "Error: Nivel de calefacción fuera de rango.";
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
