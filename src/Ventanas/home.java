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
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Sulay2016
 */
public class home extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;
    private static Integer Perfil;

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
                ShowFrame(1);
            }
        });
    }

    public static void ShowFrame(Integer perfil) {
        home.Perfil = perfil;
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet applet = new home();
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

        Button adicionarUsuarios = new Button("Adicionar Usuarios");
        Button AdicionarProductos = new Button("Adicionar Productos");
        Button retornLogn = new Button("Cambiar Usuario");
        Button Salir = new Button("cerrar");

        adicionarUsuarios.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Adicionar usuarios");

                adicionarUsuariosFrm.ShowFrame();
            }
        });
        
        AdicionarProductos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 System.out.println("Adicionar Productos");
                  adicionarProductosFrm1.ShowFrame();
            }
        });
       retornLogn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 System.out.println("Cambio de Usuario");
                 String [] args={""};
                 Login.main(args);
            }
        });
        
         Salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 System.out.println("Adios");
                System.exit(0);
            }
        });

        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);

        //administrador
        if (Perfil == 1) {
            root.getChildren().add(adicionarUsuarios);
            GridPane.setConstraints(adicionarUsuarios, 0, 0);
        } else  if (Perfil == 2) {
            root.getChildren().add(AdicionarProductos);
            GridPane.setConstraints(AdicionarProductos, 0, 0);
        } else  if (Perfil == 3) {
            root.getChildren().add(retornLogn);
            GridPane.setConstraints(retornLogn, 0, 0);
        }else  if (Perfil == 4) {
            root.getChildren().add(Salir);
            GridPane.setConstraints(Salir, 0, 0);}
        
        
        

        root.getChildren().add(AdicionarProductos);
        GridPane.setConstraints(AdicionarProductos, 0, 1);
        
        root.getChildren().add(retornLogn);
        GridPane.setConstraints(retornLogn, 0, 2);
        
        root.getChildren().add(Salir);
        GridPane.setConstraints(Salir, 0, 3);
        

        fxContainer.setScene(new Scene(root));

    }

}
