/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconex;

import Controladores.ProductoJpaController;
import Entidades.Producto;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class OpcionesForm.
 *
 * @author joans
 */
public class OpcionesForm extends javax.swing.JFrame {
    
    /** The C producto. */
    ProductoJpaController CProducto = new ProductoJpaController();
    
    /**
     * Creates new form OpcionesForm.
     */
    public OpcionesForm() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

     /**
      * Cantidad.
      *
      * @param nombre the nombre
      * @return the int
      */
     //FUNCION QUE ME PASO MANUEL 
    public int cantidad(String nombre) {
        List<Producto> listP = CProducto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                int respuesta = listP.get(i).getCantidadAlmacenada();
                return respuesta;
            }
        }
        return 0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de Transacción");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 100, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 100, -1));

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Devolución");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 190, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 10, 80, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * J button 1 action performed.
     *
     * @param evt the evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        CompraForm compra = new CompraForm();
        compra.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * J button 2 action performed.
     *
     * @param evt the evt
     */
    //BOTON VENTA
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentaForm venta = new VentaForm();
        venta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * J button 4 action performed.
     *
     * @param evt the evt
     */
    //BOTON CERRAR
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /**
     * J button 3 action performed.
     *
     * @param evt the evt
     */
    //BOTON DEVOLUCION DE MANUEL
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DevolucionForm devolucion = new DevolucionForm();
        devolucion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpcionesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcionesForm().setVisible(true);
            }
        });
    }

    /** The j button 1. */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    
    /** The j button 2. */
    private javax.swing.JButton jButton2;
    
    /** The j button 3. */
    private javax.swing.JButton jButton3;
    
    /** The j button 4. */
    private javax.swing.JButton jButton4;
    
    /** The j label 1. */
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
