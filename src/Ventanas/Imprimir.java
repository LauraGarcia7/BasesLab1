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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class Imprimir extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;

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
                
                JFrame frame = new JFrame("Factura");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new Imprimir();
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
    
    
    /* retornLogn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //ProductoDTO
            public void handle(ActionEvent event) {
                FacturaDTO fact= new FacturaDTO();
                UsuarioDTO user= new UsuarioDTO();
                ProductoDTO proc=new ProductoDTO();
               String total= fact.NombreSupermercado+"\n"+fact.Localidad+"\n************\n"+fact.codigoProducto+" "
                       +" "+fact.cantidad+" "+proc.PrecioUnitario+"\n El iva es de: "+fact.iva+"\n"+fact.total+"\n*********\n"+user.nombre+"\n";
                 System.out.println("\n\nImprimir Factura\n\n");
                 System.out.println(total);
                 EliminarFacturasFrm1111.ShowFrame();
                 
            }
        });*/
    private void createScene() {
        //Button adicionarUsuarios = new Button("Agregar factura");
        Button btn = new Button ("Aceptar'");
         FacturaDTO fact= new FacturaDTO();
                UsuarioDTO user= new UsuarioDTO();
                ProductoDTO proc=new ProductoDTO();
               String total= fact.NombreSupermercado+"\n"+fact.Localidad+"\n************\n"+fact.codigoProducto+" "
                       +" "+fact.cantidad+" "+proc.PrecioUnitario+"\n El iva es de: "+fact.iva+"\n"+fact.total+"\n*********\n"+user.nombre+"\n";
                 System.out.println("\n\nImprimir Factura\n\n");
                 System.out.println(total);
        Label imprimir = new Label(total);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
               //  EliminarFacturasFrm1111.ShowFrame();
               int a=1;
               VendedorFactura.ShowFrame(ERROR);
            }
        });
        
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);
        
        
              root.getChildren().add(imprimir);
        
        
        root.getChildren().add(btn);
        GridPane.setConstraints(btn, 0, 7);
        fxContainer.setScene(new Scene(root));
    }
    
}
