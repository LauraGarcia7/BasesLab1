/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Sulay2016
 */
public class loginAdmin extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;
    private static JFrame frame;

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

                frame = new JFrame("Login ADMINISTRADOR");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new loginAdmin();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                applet.start();
            }
        });
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
        Button btn = new Button();
        btn.setText("INGRESAR ");

        Label usuarioLabel = new Label();
        usuarioLabel.setText("Ingrese el usuario");

        Label passLabel = new Label();
        passLabel.setText("Ingrese la contraseña");

        TextField textUsuario = new TextField();
        TextField textPassword = new TextField();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Integer perfil = ValidarUsuario(textUsuario.getText(), textPassword.getText());

                if (perfil != 0) {
                    home.ShowFrame(perfil);
                }
            }
        });

        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);

        //agrega elementops a el panel principal
        root.getChildren().add(usuarioLabel);
        GridPane.setConstraints(usuarioLabel, 0, 0);

        root.getChildren().add(textUsuario);
        GridPane.setConstraints(textUsuario, 1, 0);

        root.getChildren().add(passLabel);
        GridPane.setConstraints(passLabel, 0, 1);

        root.getChildren().add(textPassword);
        GridPane.setConstraints(textPassword, 1, 1);

        root.getChildren().add(btn);
        GridPane.setConstraints(btn, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);

        fxContainer.setScene(new Scene(root));
    }

    private Integer ValidarUsuario(String usuario, String password) {
        //valides el usuario contra el servelet
        return 1;
    }

}
