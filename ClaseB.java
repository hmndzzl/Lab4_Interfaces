class ClaseB extends Climatizacion implements IB {
    private boolean modoEcoActivo = false;

    @Override
    public void ajustarNivelVentilacion(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            nivelVentilacion = nivel;
        } else {
            throw new IllegalArgumentException("Error: Nivel de ventilación fuera de rango.");
        }
    }

    @Override
    public void modoEcoVentilacion() {
        if (!estadoClimatizacion) {
            throw new IllegalStateException("Error: La climatización está apagada.");
        }
        modoEcoActivo = !modoEcoActivo;
        if (modoEcoActivo) {
            nivelVentilacion = Math.max(1, nivelVentilacion - 1); // Reduce el nivel de ventilación
        }
    }

    @Override
    public void calefaccionAsientos(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            // Implementación de ajuste de calefacción de asientos
        } else {
            throw new IllegalArgumentException("Error: Nivel de calefacción fuera de rango.");
        }
    }
}