class ClaseC extends Climatizacion implements IC {
    private int nivelHumedad = 2; // Valor inicial de humedad en modo medio
    private boolean modoSilenciosoActivo = false;

    @Override
    public void modoSilencioso() {
        if (!estadoClimatizacion) {
            throw new IllegalStateException("Error: La climatización está apagada.");
        }
        modoSilenciosoActivo = !modoSilenciosoActivo;
        if (modoSilenciosoActivo) {
            nivelVentilacion = Math.min(1, nivelVentilacion); // Reduce la ventilación al mínimo
        }
    }

    @Override
    public void controlHumedad(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            nivelHumedad = nivel;
        } else {
            throw new IllegalArgumentException("Error: Nivel de humedad fuera de rango.");
        }
    }
}