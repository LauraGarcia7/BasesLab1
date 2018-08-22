/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import models.UsuarioDTO;

/**
 *
 * @author Sulay2016
 */
public class adicionarUsuariosFrm extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;
    public static JFrame frame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }

                ShowFrame();
            }
        });
    }

    public static void ShowFrame() {
        frame = new JFrame("Adicionar Usuarios");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JApplet applet = new adicionarUsuariosFrm();
        applet.init();

        frame.setContentPane(applet.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        applet.start();
    }

    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                createScene();
            }
        });
    }

    private void createScene() {
        Label labelNombre = new Label("Ingrese el nombre:");
        Label labelCedula = new Label("Ingrese la cedula:");
        Label labelTelefono = new Label("Ingrese el telefono:");
        Label labelDireccion = new Label("Ingrese la dirreccion:");
        Label labelUsuario = new Label("Ingrese el usuario:");
        Label labelPassword = new Label("Ingrese la contraseña:");
        Label labelPerfil = new Label("Ingrese el perfil:");

        TextField textNombre = new TextField();
        TextField textCedula = new TextField();
        TextField textTelefono = new TextField();
        TextField textDireccion = new TextField();
        TextField textUsuario = new TextField();
        TextField textPassword = new TextField();
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Administrador",
                        "Cajero"
                );
        ComboBox comboPerfil = new ComboBox(options);
        comboPerfil.setValue("Cajero");
        
        
        Button btn = new Button();
        btn.setText("GUARDAR");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.nombre = textNombre.getText();
                usuario.cedula = textCedula.getText();
                usuario.telefono = textTelefono.getText();
                usuario.direccion = textDireccion.getText();
                usuario.usuario = textUsuario.getText();
                usuario.password = textPassword.getText();
                usuario.perfil = comboPerfil.getValue() == "Administrador" ? 1: 2;

                if (GuardarUsuario(usuario)) {
                    adicionarUsuariosFrm.frame.setVisible(false);
                }
            }
        });

        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);

        //agrega elementops a el panel principal
        root.getChildren().add(labelNombre);
        GridPane.setConstraints(labelNombre, 0, 0);

        root.getChildren().add(textNombre);
        GridPane.setConstraints(textNombre, 1, 0);

        root.getChildren().add(labelCedula);
        GridPane.setConstraints(labelCedula, 0, 1);

        root.getChildren().add(textCedula);
        GridPane.setConstraints(textCedula, 1, 1);

        root.getChildren().add(labelTelefono);
        GridPane.setConstraints(labelTelefono, 0, 2);

        root.getChildren().add(textTelefono);
        GridPane.setConstraints(textTelefono, 1, 2);

        root.getChildren().add(labelDireccion);
        GridPane.setConstraints(labelDireccion, 0, 3);

        root.getChildren().add(textDireccion);
        GridPane.setConstraints(textDireccion, 1, 3);

        root.getChildren().add(labelUsuario);
        GridPane.setConstraints(labelUsuario, 0, 4);

        root.getChildren().add(textUsuario);
        GridPane.setConstraints(textUsuario, 1, 4);

        root.getChildren().add(labelPassword);
        GridPane.setConstraints(labelPassword, 0, 5);

        root.getChildren().add(textPassword);
        GridPane.setConstraints(textPassword, 1, 5);
        
        root.getChildren().add(labelPerfil);
        GridPane.setConstraints(labelPerfil, 0, 6);

        root.getChildren().add(comboPerfil);
        GridPane.setConstraints(comboPerfil, 1, 6);

        root.getChildren().add(btn);
        GridPane.setConstraints(btn, 0, 7, 2, 1, HPos.CENTER, VPos.CENTER);

        fxContainer.setScene(new Scene(root));
    }

    private Boolean GuardarUsuario(UsuarioDTO usuario) {
        return true;
    }

}
