//
// Programación Orientada a Objetos
// Sección 20
// Laboratorio #4 - Polimorfismo a través de Interfaces
// 
// Hugo Méndez - 241265
// Diego Calderón - 241263
// Pedro Caso - 241286
//

import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame {
    private Climatizacion vehiculo;
    private final JTextArea outputArea;
    private final JButton opcionesEspecificasBtn;

    public GUI() {
        setTitle("Sistema de Climatización de Vehículos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel mainPanel = new JPanel();
        add(mainPanel);

        // Panel de selección de vehículo
        String[] vehiculos = {"Seleccione un vehículo", "Clase A", "Clase B", "Clase C"};
        JComboBox<String> vehiculoComboBox = new JComboBox<>(vehiculos);
        vehiculoComboBox.addActionListener(e -> seleccionarVehiculo((String) vehiculoComboBox.getSelectedItem()));

        // Botón de opciones específicas de clase
        opcionesEspecificasBtn = new JButton("Opciones Específicas");
        opcionesEspecificasBtn.addActionListener(e -> {
            if (vehiculo != null) {
                mostrarOpcionesEspecificas();
            } else {
                output("Error: Seleccione un vehículo primero.");
            }
        });

        // Panel de botones de opciones generales
        JButton encenderBtn = new JButton("Encender Climatización");
        JButton apagarBtn = new JButton("Apagar Climatización");
        JButton ajustarTemperaturaBtn = new JButton("Ajustar Temperatura");
        JButton modoAutomaticoBtn = new JButton("Modo Automático");
        JButton activarDesempañadorBtn = new JButton("Activar Desempañador");
        JButton mantenimientoBtn = new JButton("Mostrar Aviso de Mantenimiento");

        encenderBtn.addActionListener(e -> output("Encender Climatización: " + vehiculo.encender()));
        apagarBtn.addActionListener(e -> output("Apagar Climatización: " + vehiculo.apagar()));
        ajustarTemperaturaBtn.addActionListener(e -> ajustarTemperatura());
        modoAutomaticoBtn.addActionListener(e -> output("Modo Automático: " + vehiculo.modoAutomatico()));
        activarDesempañadorBtn.addActionListener(e -> output("Activar Desempañador: " + vehiculo.activarDesempañador()));
        mantenimientoBtn.addActionListener(e -> output("Mostrar Aviso de Mantenimiento: " + vehiculo.mostrarAvisoMantenimiento()));

        mainPanel.add(vehiculoComboBox);
        mainPanel.add(encenderBtn);
        mainPanel.add(apagarBtn);
        mainPanel.add(ajustarTemperaturaBtn);
        mainPanel.add(modoAutomaticoBtn);
        mainPanel.add(activarDesempañadorBtn);
        mainPanel.add(mantenimientoBtn);
        mainPanel.add(opcionesEspecificasBtn);
        mainPanel.add(scrollPane);

        setVisible(true);
    }

    private void seleccionarVehiculo(String tipo) {
        switch (tipo) {
            case "Clase A":
                vehiculo = new ClaseA();
                output("Vehículo Clase A seleccionado.");
                break;
            case "Clase B":
                vehiculo = new ClaseB();
                output("Vehículo Clase B seleccionado.");
                break;
            case "Clase C":
                vehiculo = new ClaseC();
                output("Vehículo Clase C seleccionado.");
                break;
            default:
                vehiculo = null;
                output("Seleccione un tipo de vehículo válido.");
                break;
        }
    }

    private void mostrarOpcionesEspecificas() {
        JPanel opcionesPanel = new JPanel();

        if (vehiculo instanceof ClaseA) {
            agregarBoton(opcionesPanel, "Ajustar Nivel de Ventilación (1-5)", e -> ajustarNivelVentilacion(1, 5));
            agregarBoton(opcionesPanel, "Ajustar Dirección de Ventilación", e -> ajustarDireccionVentilacion());
            agregarBoton(opcionesPanel, "Activar Ionizador", e -> activarIonizador());
            agregarBoton(opcionesPanel, "Ajustar Calefacción de Asientos", e -> ajustarCalefaccionAsientos(1, 3));
            agregarBoton(opcionesPanel, "Ajustar Calefacción de Volante", e -> ajustarCalefaccionVolante(1, 2));
            agregarBoton(opcionesPanel, "Activar Calefacción Rápida", e -> activarCalefaccionRapida());
            agregarBoton(opcionesPanel, "Crear Perfil de Climatización", e -> crearPerfil());
            agregarBoton(opcionesPanel, "Seleccionar Perfil de Climatización", e -> seleccionarPerfil());
        } else if (vehiculo instanceof ClaseB) {
            agregarBoton(opcionesPanel, "Ajustar Nivel de Ventilación (1-3)", e -> ajustarNivelVentilacion(1, 3));
            agregarBoton(opcionesPanel, "Activar Modo Eco de Ventilación", e -> modoEco());
            agregarBoton(opcionesPanel, "Ajustar Calefacción de Asientos", e -> ajustarCalefaccionAsientos(1, 3));
            agregarBoton(opcionesPanel, "Activar Calefacción Rápida", e -> activarCalefaccionRapida());
        } else if (vehiculo instanceof ClaseC) {
            agregarBoton(opcionesPanel, "Activar Modo Silencioso", e -> modoSilencioso());
            agregarBoton(opcionesPanel, "Control de Humedad", e -> controlHumedad());
            agregarBoton(opcionesPanel, "Ventilación en Zona Específica", e -> activarVentilacionZona());
            agregarBoton(opcionesPanel, "Activar Calefacción Rápida", e -> activarCalefaccionRapida());
        }

        JOptionPane.showMessageDialog(this, opcionesPanel, "Opciones Específicas", JOptionPane.PLAIN_MESSAGE);
    }

    private void agregarBoton(JPanel panel, String titulo, ActionListener listener) {
        JButton button = new JButton(titulo);
        button.addActionListener(listener);
        panel.add(button);
    }

    private void ajustarTemperatura() {
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de grados a ajustar (+/-):");
        int grados = Integer.parseInt(input);
        output("Ajustar Temperatura: " + vehiculo.ajustarTemperatura(grados));
    }

    private void ajustarNivelVentilacion(int min, int max) {
        String input = JOptionPane.showInputDialog("Ingrese el nivel de ventilación (" + min + "-" + max + "):");
        int nivel = Integer.parseInt(input);
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).ajustarNivelVentilacion(nivel));
        else if (vehiculo instanceof ClaseB) output(((ClaseB) vehiculo).ajustarNivelVentilacion(nivel));
    }

    private void ajustarDireccionVentilacion() {
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección de ventilación (parabrisas, frontal, pies, combinado):");
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).ventilacionDireccional(direccion));
    }

    private void activarIonizador() {
        String input = JOptionPane.showInputDialog("Ingrese la intensidad del ionizador (1-3):");
        int intensidad = Integer.parseInt(input);
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).activarIonizador(intensidad));
    }

    private void ajustarCalefaccionAsientos(int min, int max) {
        String input = JOptionPane.showInputDialog("Ingrese el nivel de calefacción de los asientos (" + min + "-" + max + "):");
        int nivel = Integer.parseInt(input);
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).calefaccionAsientos(nivel));
        else if (vehiculo instanceof ClaseB) output(((ClaseB) vehiculo).calefaccionAsientos(nivel));
    }

    private void ajustarCalefaccionVolante(int min, int max) {
        String input = JOptionPane.showInputDialog("Ingrese el nivel de calefacción del volante (" + min + "-" + max + "):");
        int nivel = Integer.parseInt(input);
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).calefaccionVolante(nivel));
    }

    private void activarCalefaccionRapida() {
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).activarCalefaccionRapida());
        else if (vehiculo instanceof ClaseB) output(((ClaseB) vehiculo).activarCalefaccionRapida());
        else if (vehiculo instanceof ClaseC) output(((ClaseC) vehiculo).activarCalefaccionRapida());
    }

    private void crearPerfil() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del perfil:");
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).crearPerfil(nombre));
    }

    private void seleccionarPerfil() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del perfil a seleccionar:");
        if (vehiculo instanceof ClaseA) output(((ClaseA) vehiculo).seleccionarPerfil(nombre));
    }

    private void modoEco() {
        if (vehiculo instanceof ClaseB) output(((ClaseB) vehiculo).modoEcoVentilacion());
    }

    private void modoSilencioso() {
        if (vehiculo instanceof ClaseC) output(((ClaseC) vehiculo).modoSilencioso());
    }

    private void controlHumedad() {
        String input = JOptionPane.showInputDialog("Ingrese el nivel de humedad (1-3):");
        int nivel = Integer.parseInt(input);
        if (vehiculo instanceof ClaseC) output(((ClaseC) vehiculo).controlHumedad(nivel));
    }

    private void activarVentilacionZona() {
        String zona = JOptionPane.showInputDialog("Ingrese la zona de ventilación (parabrisas o pies):");
        if (vehiculo instanceof ClaseC) output(((ClaseC) vehiculo).activarVentilacionZona(zona));
    }

    private void output(String message) {
        outputArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
