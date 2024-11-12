class ClaseA extends Climatizacion implements IA {
    private boolean ionizadorActivo = false;
    private String direccionVentilacion = "frontal";

    @Override
    public void ajustarNivelVentilacion(int nivel) {
        if (nivel >= 1 && nivel <= 5) {
            nivelVentilacion = nivel;
        } else {
            throw new IllegalArgumentException("Error: Nivel de ventilación fuera de rango.");
        }
    }

    @Override
    public void ventilacionDireccional(String direccion) {
        switch (direccion.toLowerCase()) {
            case "parabrisas", "frontal", "pies" -> direccionVentilacion = direccion;
            case "combinado" -> direccionVentilacion = "parabrisas, frontal, pies";
            default -> throw new IllegalArgumentException("Error: Dirección no válida.");
        }
    }

    @Override
    public void activarIonizador() {
        if (!estadoClimatizacion) {
            throw new IllegalStateException("Error: La climatización está apagada.");
        }
        ionizadorActivo = !ionizadorActivo;
    }

    @Override
    public void calefaccionAsientos(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            // Implementación de ajuste de calefacción de asientos
        } else {
            throw new IllegalArgumentException("Error: Nivel de calefacción fuera de rango.");
        }
    }

    @Override
    public void calefaccionVolante(int nivel) {
        if (nivel == 1 || nivel == 2) {
            // Implementación de ajuste de calefacción del volante
        } else {
            throw new IllegalArgumentException("Error: Nivel de calefacción de volante fuera de rango.");
        }
    }
}