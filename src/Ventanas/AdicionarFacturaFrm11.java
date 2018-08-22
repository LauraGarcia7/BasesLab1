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
import models.ProductoDTO;
import models.UsuarioDTO;

/**
 *
 * @author Sulay2016
 */
public class AdicionarFacturaFrm11 extends JApplet {

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
        frame = new JFrame("Adicionar Factura");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JApplet applet = new AdicionarFacturaFrm11();
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
    
    public String cedula ;
    public String codigoProducto;
    public String cantidad;

    private void createScene() {
        Label labelNombre = new Label("Ingrese el cedula:");
        Label labelcantidad = new Label("Ingrese codigoProducto:");
        Label labelFechaFabricacion = new Label("Ingrese cantidad producto:");
        Label labelFechaCaducidad = new Label("Ingrese cantidad:");
        Label labelEstado = new Label("Ingrese el Estado:");

        TextField textNombre = new TextField();
        TextField textcantidad = new TextField();
        TextField textFechaFabricacion = new TextField();
        TextField textFechaCaducidad = new TextField();
        TextField textProveedor = new TextField();
        TextField textPrecioUnitario = new TextField();
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Agregar",
                        "Eliminar"
                );
        ComboBox comboPerfil = new ComboBox(options);
        comboPerfil.setValue("Guardar");
        
        
        Button btn = new Button();
        btn.setText("Aceptar");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ProductoDTO usuario = new ProductoDTO();
                usuario.ombreProducto = textNombre.getText();
                usuario.cantidad = textcantidad.getText();
                usuario.fechaFabricacion = textFechaFabricacion.getText();
                usuario.fechaCaducidad = textFechaCaducidad.getText();
                usuario.proveedor = textProveedor.getText();
                usuario.PrecioUnitario = textPrecioUnitario.getText();
                usuario.perfil = comboPerfil.getValue() == "Agregar" ? 1: 2;
              
              
                if (GuardarUsuario(usuario)) {
                    AdicionarFacturaFrm11.frame.setVisible(false);
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

        root.getChildren().add(labelcantidad);
        GridPane.setConstraints(labelcantidad, 0, 1);

        root.getChildren().add(textcantidad);
        GridPane.setConstraints(textcantidad, 1, 1);

        root.getChildren().add(labelFechaFabricacion);
        GridPane.setConstraints(labelFechaFabricacion, 0, 2);

        root.getChildren().add(textFechaFabricacion);
        GridPane.setConstraints(textFechaFabricacion, 1, 2);

        root.getChildren().add(labelFechaCaducidad);
        GridPane.setConstraints(labelFechaCaducidad, 0, 3);

        root.getChildren().add(textFechaCaducidad);
        GridPane.setConstraints(textFechaCaducidad, 1, 3);

        
       
        
        root.getChildren().add(labelEstado);
        GridPane.setConstraints(labelEstado, 0, 6);

        root.getChildren().add(comboPerfil);
        GridPane.setConstraints(comboPerfil, 1, 6);

        root.getChildren().add(btn);
        GridPane.setConstraints(btn, 0, 7, 2, 1, HPos.CENTER, VPos.CENTER);

        fxContainer.setScene(new Scene(root));
    }

    private Boolean GuardarUsuario(ProductoDTO usuario) {
        return true;
    }

}
