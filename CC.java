public class CC implements Sistema {
    private boolean estado;
    private int temperatura;
    private boolean modoA;
    private String distribucion;
    private boolean desempañador;
    private String nivel_vent;
    private String zona_vent;
    private boolean modoS;
    private String nivel_humedad;
    private float indicador_humedad;

    // Estados iniciales de la claseC
    public CC() {
        this.estado = false;
        this.temperatura = 20;
        this.modoA = false;
        this.distribucion = "frontal";
        this.desempañador = false;
        this.nivel_vent = "medio";
        this.zona_vent = "pies";
        this.modoS = false;
        this.nivel_humedad = "medio";
        this.indicador_humedad = 50.0f;
    }

    //Metodos generales de la interfaz 
    
    // Opcion de sistema encendido
    @Override
    public void encender() {
        estado = true;
    }
    // Opcion de sistema apagado, si esta activo no se permiten cambios
    @Override
    public void apagar() {
        estado = false;
    }
    // Ajuste de temperatura con incremento de grado en grado
    @Override
    public boolean ajustarTemperatura(int incremento) {
        if (estado) {
            temperatura += incremento;
            return true;
        } else {
            return false;
        }
    }
    // Opcion que activa el modo Automatico de ajuste de temperatura
    @Override
    public boolean activarModoAutomatico() {
        if (estado) {
            modoA = true;
            return true;
        } else {
            return false;
        }
    }

    //Opcion de la configuracion del ajuste de distribucion del aire 
    @Override
    public boolean configurarDistribucionAire(String distribucion) {
        if (estado) {
            this.distribucion = distribucion;
            return true;            
        } else {
            return false;
        }
    }
    //Opciones para activar y desactivar el desempañador de vidrios 
    @Override
    public boolean activarDesempañador() {
        if (estado) {
            desempañador = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean desactivarDesempañador() {
        if (estado) {
            desempañador = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEstado() {
        return estado;
    }

    @Override
    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public boolean isModoAutomatico() {
        return modoA;
    }

    @Override
    public String getDistribucionAire() {
        return distribucion;
    }

    @Override
    public boolean isDesempañadorActivo() {
        return desempañador;
    }

    // Métodos específicos de ClaseC

    //Opcion ajuste del nivel de ventilacion -> bajo, alto, medio (Set y get)
    public String getNivelVentilacion() {
        return nivel_vent;
    }

    public boolean setNivelVentilacion(String nivel_vent) {
        if (estado) {
            this.nivel_vent = nivel_vent;
            return true;
        } else {
            return false;
        }
    }
    // Opción seleccion de la zona de ventilacion (Set y get)
    public String getZonaVentilacion() {
        return zona_vent;
    }

    public boolean setZonaVentilacion(String zona_vent) {
        if (estado) {
            this.zona_vent = zona_vent;
            return true;
        } else {
            return false;
        }
    }
    // Opcion modo silencioso (Set y get)
    public boolean isModoSilencioso() {
        return modoS;
    }

    public boolean activarModoSilencioso() {
        if (estado) {
            modoS = true;
            return true;
        } else {
            return false;
        }
    }

    // Opcion justar nivel de Humedad (Set y get)
    public String getNivelHumedad() {
        return nivel_humedad;
    }

    
    public boolean setNivelHumedad(String nivel_humedad) {
        if (estado) {
            this.nivel_humedad = nivel_humedad;
            return true;
        } else {
            return false;
        }
    }

    //Opcion del indicador de Humedad (Set y get)
    public float getIndicadorHumedad() {
        return indicador_humedad;
    }

    public boolean actualizarIndicadorHumedad(float indicador_humedad) {
        if (estado) {
            this.indicador_humedad = indicador_humedad;
            return true;
        } else {
            return true;
        }
    }

}
