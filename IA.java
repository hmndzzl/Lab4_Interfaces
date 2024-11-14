interface IA {
    String ajustarNivelVentilacion(int nivel);
    String ventilacionDireccional(String direccion);
    String activarIonizador(int intensidad);
    String calefaccionAsientos(int nivel);
    String calefaccionVolante(int nivel);
    String activarCalefaccionRapida();
    String crearPerfil(String nombre);
    String seleccionarPerfil(String nombre);
}