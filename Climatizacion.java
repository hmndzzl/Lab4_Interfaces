abstract class Climatizacion {
    protected boolean estadoClimatizacion = false;
    protected int temperatura = 20; // Valor inicial
    protected int nivelVentilacion = 1; // Valor inicial

    public void encender() {
        estadoClimatizacion = true;
    }

    public void apagar() {
        estadoClimatizacion = false;
    }

    public void ajustarTemperatura(int grados) {
        if (estadoClimatizacion) {
            temperatura += grados;
        } else {
            throw new IllegalStateException("Error: La climatización está apagada.");
        }
    }

    public void modoAutomatico() {
        if (!estadoClimatizacion) {
            throw new IllegalStateException("Error: La climatización está apagada.");
        }
        // Implementación del modo automático que ajusta la temperatura automáticamente
        temperatura = obtenerTemperaturaExterna(); // Asume un método que simula la temperatura externa
    }

    private int obtenerTemperaturaExterna() {
        // Simulación de obtención de temperatura externa (puede ser reemplazado por datos de un sensor)
        return 25;
    }

    public void activarDesempañador() {
        if (!estadoClimatizacion) {
            throw new IllegalStateException("Error: La climatización está apagada.");
        }
        // Implementación del desempañador (ajusta ventilación y temperatura)
        nivelVentilacion = 5; // Máxima ventilación para desempañar
    }
}