import java.util.HashMap;
import java.util.Map;

class ClaseA extends Climatizacion implements IA {
    private boolean ionizadorActivo = false;
    private String direccionVentilacion = "frontal";
    private Map<String, Perfil> perfiles = new HashMap<>();

    @Override
    public String ajustarNivelVentilacion(int nivel) {
        if (nivel >= 1 && nivel <= 5) {
            nivelVentilacion = nivel;
            return "Nivel de ventilación ajustado a " + nivel;
        }
        return "Error: Nivel de ventilación fuera de rango.";
    }

    @Override
    public String ventilacionDireccional(String direccion) {
        if (!estadoClimatizacion) return "Error: La climatización está apagada.";
        switch (direccion.toLowerCase()) {
            case "parabrisas", "frontal", "pies", "combinado" -> {
                direccionVentilacion = direccion;
                return "Dirección de ventilación ajustada a " + direccion;
            }
            default -> {
                return "Error: Dirección no válida.";
            }
        }
    }

    @Override
    public String activarIonizador(int intensidad) {
        if (estadoClimatizacion && intensidad >= 1 && intensidad <= 3) {
            ionizadorActivo = true;
            return "Ionizador activado con intensidad " + intensidad;
        }
        return estadoClimatizacion ? "Error: Intensidad de ionizador fuera de rango." : "Error: La climatización está apagada.";
    }

    @Override
    public String calefaccionAsientos(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            return "Calefacción de asientos ajustada a nivel " + nivel;
        }
        return "Error: Nivel de calefacción de asientos fuera de rango.";
    }

    @Override
    public String calefaccionVolante(int nivel) {
        if (nivel == 1 || nivel == 2) {
            return "Calefacción de volante ajustada a nivel " + nivel;
        }
        return "Error: Nivel de calefacción de volante fuera de rango.";
    }

    @Override
    public String activarCalefaccionRapida() {
        if (estadoClimatizacion) {
            temperatura += 5;
            return "Calefacción rápida activada. Temperatura incrementada temporalmente a " + temperatura + " grados.";
        }
        return "Error: La climatización está apagada.";
    }

    @Override
    public String crearPerfil(String nombre) {
        if (perfiles.size() < 3) {
            perfiles.put(nombre, new Perfil(temperatura, nivelVentilacion, direccionVentilacion, ionizadorActivo));
            return "Perfil " + nombre + " creado exitosamente.";
        }
        return "Error: Máximo de perfiles alcanzado.";
    }

    @Override
    public String seleccionarPerfil(String nombre) {
        Perfil perfil = perfiles.get(nombre);
        if (perfil != null) {
            this.temperatura = perfil.temperatura;
            this.nivelVentilacion = perfil.nivelVentilacion;
            this.direccionVentilacion = perfil.direccionVentilacion;
            this.ionizadorActivo = perfil.ionizadorActivo;
            return "Perfil " + nombre + " seleccionado.";
        }
        return "Error: Perfil no encontrado.";
    }

    private static class Perfil {
        int temperatura;
        int nivelVentilacion;
        String direccionVentilacion;
        boolean ionizadorActivo;

        Perfil(int temperatura, int nivelVentilacion, String direccionVentilacion, boolean ionizadorActivo) {
            this.temperatura = temperatura;
            this.nivelVentilacion = nivelVentilacion;
            this.direccionVentilacion = direccionVentilacion;
            this.ionizadorActivo = ionizadorActivo;
        }
    }
}