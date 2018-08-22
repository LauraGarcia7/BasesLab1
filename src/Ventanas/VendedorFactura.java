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
import models.FacturaDTO;
import models.ProductoDTO;
import models.UsuarioDTO;

/**
 *
 * @author Sulay2016
 */
public class VendedorFactura extends JApplet {

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
        VendedorFactura.Perfil = perfil;
        JFrame frame = new JFrame("Factura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet applet = new VendedorFactura();
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

        Button adicionarUsuarios = new Button("Agregar factura");
        Button AdicionarProductos = new Button("Modificar factura");
        Button retornLogn = new Button("Eliminar factura");
        Button retornLogn1 = new Button("Imprimir factura");
        Button Salir = new Button("cerrar");

        adicionarUsuarios.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Agregar factura");

                AdicionarFacturaFrm11.ShowFrame();
            }
        });
        
        AdicionarProductos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 System.out.println("Modificar factura");
                  EditarFacturasFrm111.ShowFrame();
            }
        });
       retornLogn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 System.out.println("Eliminar factura");
                 EliminarFacturasFrm1111.ShowFrame();
                 
            }
        });
       retornLogn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //ProductoDTO
            public void handle(ActionEvent event) {
               /* FacturaDTO fact= new FacturaDTO();
                UsuarioDTO user= new UsuarioDTO();
                ProductoDTO proc=new ProductoDTO();
               String total= fact.NombreSupermercado+"\n"+fact.Localidad+"\n************\n"+fact.codigoProducto+" "
                       +" "+fact.cantidad+" "+proc.PrecioUnitario+"\n El iva es de: "+fact.iva+"\n"+fact.total+"\n*********\n"+user.nombre+"\n";
                 System.out.println("\n\nImprimir Factura\n\n");
                 System.out.println(total);*/
                 //EliminarFacturasFrm1111.ShowFrame();
                 String [] args = null;
                 Imprimir.main(args);
                 
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
            root.getChildren().add(retornLogn1);
            GridPane.setConstraints(retornLogn1, 0, 0);}
        else  if (Perfil == 5) {
            root.getChildren().add(Salir);
            GridPane.setConstraints(Salir, 0, 0);}
        
        ///retornLogn1

        root.getChildren().add(AdicionarProductos);
        GridPane.setConstraints(AdicionarProductos, 0, 1);
        
        root.getChildren().add(retornLogn);
        GridPane.setConstraints(retornLogn, 0, 2);
        
        root.getChildren().add(retornLogn1);
        GridPane.setConstraints(retornLogn1, 0, 3);
        
        root.getChildren().add(Salir);
        GridPane.setConstraints(Salir, 0, 4);
        

        fxContainer.setScene(new Scene(root));

    }

}
