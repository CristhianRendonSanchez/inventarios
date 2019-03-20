/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconex;

import Controladores.ProductoHasTransaccionJpaController;
import Controladores.ProductoJpaController;
import Controladores.TransaccionJpaController;
import Entidades.Producto;
import Entidades.ProductoHasTransaccion;
import Entidades.Transaccion;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joans
 */
public class DevolucionForm extends javax.swing.JFrame {
    ProductoJpaController Producto = new ProductoJpaController();
    TransaccionJpaController Transaccion = new TransaccionJpaController();
    ProductoHasTransaccionJpaController Transacciones = new ProductoHasTransaccionJpaController();

    /**
     * Creates new form DevolucionForm
     */
    public DevolucionForm() {
        initComponents();
        this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consultarDevoluciones = new javax.swing.JButton();
        campoIdfactura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDevoluciones = new javax.swing.JTable();
        enviarDevoluciones = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultarDevoluciones.setText("Consultar");
        consultarDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarDevolucionesActionPerformed(evt);
            }
        });
        getContentPane().add(consultarDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        campoIdfactura.setToolTipText("");
        campoIdfactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdfacturaActionPerformed(evt);
            }
        });
        campoIdfactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoIdfacturaKeyTyped(evt);
            }
        });
        getContentPane().add(campoIdfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 192, -1));

        tablaDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDevoluciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 340, 210));

        enviarDevoluciones.setText("Enviar");
        enviarDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarDevolucionesActionPerformed(evt);
            }
        });
        getContentPane().add(enviarDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 312, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Transaccion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarDevolucionesActionPerformed
        List<Producto> listP = Producto.findProductoEntities();
        List<Transaccion> listT = Transaccion.findTransaccionEntities();
        List<ProductoHasTransaccion> listQ = Transacciones.findProductoHasTransaccionEntities();

        Producto p = new Producto();
        int idFactura = Integer.parseInt(campoIdfactura.getText());
        for (int i = 0; i < listT.size(); i++) {
            if (listT.get(i).getIdTransaccion() == idFactura) {
                Date fecha = listT.get(i).getFechaT();
                String nombre = listT.get(i).getNombreProducto();
                String tipo = listT.get(i).getTipo();
                float precioDeLaTransacion = listT.get(i).getPrecio();
                float precio = 0;
                int cantidadEnLaTransaccion = listT.get(i).getCantidad();
                int cantidadEnInventario = listP.get(i).getCantidadAlmacenada();
                int idProducto = traerId(nombre);

                System.out.println(cantidadTransaciones(nombre) + tipo);

                if (cantidadTransaciones(nombre) > 0 && tipo.equals("entrada")) {
                    try {
                        //se trata como una salida (devolucion a proveedor) se actualiza el valor en la bd
                        System.out.println("entre caso 1 ");
                        Producto eActualizable = Producto.findProducto(idProducto);
                        int nuevaCantidad = cantidadEnLaTransaccion - cantidadEnInventario;
                        float valorUnitario;
                        float totalSalida = precioDeLaTransacion * cantidadEnLaTransaccion;//
                        float precioDeInventario = listP.get(i).getValorUnitario();
                        float actualizacionSaldo = totalSalida + precioDeInventario;// ojo aqui preguntarles
                        valorUnitario = actualizacionSaldo / nuevaCantidad;

                        eActualizable.setCantidadAlmacenada(nuevaCantidad);
                        eActualizable.setNombreProducto(nombre);
                        eActualizable.setValorUnitario(precio);
                        Producto.edit(eActualizable);

                        Producto.create(eActualizable);

                        Transaccion registro = new Transaccion();
                        registro.setFechaT(fecha);
                        registro.setNombreProducto(nombre);
                        registro.setCantidad(cantidadEnInventario);
                        registro.setPrecio(actualizacionSaldo);
                        registro.setTipo("devolucion");
                        Transaccion.create(registro);
                    } catch (Exception ex) {

                    }

                }
                if (cantidadTransaciones(nombre) == 0 && tipo.equals("entrada")) {
                    System.out.println("entre caso 2 ");
                    //se trata como una salida (devolucion a proveedor) y se crea nuevamente el valor en la bd
                    JOptionPane.showMessageDialog(null, "no existe registros previos de este producto\n+"
                            + " verifique porfavor en el boton consultar");

                }
                if (cantidadTransaciones(nombre) > 0 && tipo.equals("salida")) {
                    //se trata como una entrada (devolucion de un cliente a nosotros )se actualiza el valor en la bd 
                    System.out.println("entre caso 3 ");
                    try {
                        Producto eActualizable = Producto.findProducto(idProducto);
                        int nuevaCantidad = cantidadEnLaTransaccion + cantidadEnInventario;
                        float valorUnitario;
                        float totalEntrada = precioDeLaTransacion * cantidadEnLaTransaccion;//
                        float precioDeInventario = listP.get(i).getValorUnitario();
                        float actualizacionSaldo = totalEntrada + precioDeInventario;
                        valorUnitario = actualizacionSaldo / nuevaCantidad;

                        eActualizable.setCantidadAlmacenada(nuevaCantidad);
                        eActualizable.setNombreProducto(nombre);
                        eActualizable.setValorUnitario(valorUnitario);
                        Producto.edit(eActualizable);

                        Transaccion registro = new Transaccion();
                        registro.setFechaT(fecha);
                        registro.setNombreProducto(nombre);
                        registro.setCantidad(cantidadEnInventario);
                        registro.setPrecio(actualizacionSaldo);
                        registro.setTipo("devolucion");
                        Transaccion.create(registro);
                    } catch (Exception ex) {

                    }

                }

                if (cantidad(nombre) == 0 && tipo.equals("salida")) {
                    System.out.println("entre caso 4 ");
                    //se trata como una entrada (devolucion de un cliente hacia nosotros) que ya no esta registrada en la bd
                    try {
                        Producto eActualizable = new Producto();
                        int nuevaCantidad = cantidadEnLaTransaccion + cantidadEnInventario;
                        eActualizable.setCantidadAlmacenada(nuevaCantidad);
                        eActualizable.setNombreProducto(nombre);
                        eActualizable.setValorUnitario(precioDeLaTransacion);
                        Producto.create(eActualizable);

                        Transaccion registro = new Transaccion();
                        registro.setFechaT(fecha);
                        registro.setNombreProducto(nombre);
                        registro.setCantidad(cantidadEnInventario);
                        float dinero = precioDeLaTransacion * cantidadEnInventario;
                        registro.setPrecio(precio);
                        registro.setTipo("devolucion");
                        Transaccion.create(registro);

                        JOptionPane.showMessageDialog(null, "devolucion exitosa");
                    } catch (Exception ex) {

                    }

                }

                p.setCantidadAlmacenada(cantidadEnInventario);
                p.setNombreProducto(nombre);
                p.setValorUnitario(precio);

            }
        }
    }//GEN-LAST:event_enviarDevolucionesActionPerformed

    private void consultarDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarDevolucionesActionPerformed
        int prueba = Integer.parseInt(campoIdfactura.getText());
        if (campoIdfactura.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "por favor ingrese un Id");
        } else {
            CrearModelo();
            CargarInformacion();
            if (busquedaId(prueba) == true) {
                JOptionPane.showMessageDialog(null, "la factura existe ");
            } else {
                JOptionPane.showMessageDialog(null, "la factura no existe");
            }

        }
    }//GEN-LAST:event_consultarDevolucionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoIdfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdfacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdfacturaActionPerformed

    private void campoIdfacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIdfacturaKeyTyped
        char c = evt.getKeyChar();
       
       if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_campoIdfacturaKeyTyped

    public int cantidadTransaciones(String nombre) {
        List<Transaccion> listT = Transaccion.findTransaccionEntities();
        for (int i = 0; i < listT.size(); i++) {
            if (listT.get(i).getNombreProducto().equals(nombre)) {
                int respuesta = listT.get(i).getCantidad();
                return respuesta;
            }
        }
        return 0;
    }
    public int cantidad(String nombre) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                int respuesta = listP.get(i).getCantidadAlmacenada();
                return respuesta;
            }
        }
        return 0;
    }
    
    public boolean busquedaId(int id) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getIdProducto().equals(id)) {
                return true;
            }

        }
        return false;
    }
    
      public int traerId(String nombre ) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                int idRespueseta= listP.get(i).getIdProducto();
                return idRespueseta;
            }

        }
        return 0;
    }

    public boolean busquedaNombre(String nombre) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                return true;
            }

        }
        return false;
    }

    public int traerNombre(String nombre) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                int resultadoBusqueda = listP.get(i).getIdProducto();
                return resultadoBusqueda;

            }

        }
        return 0;
    }

    public boolean busqueda(int id) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getIdProducto() == id) {
                return true;
            }

        }
        return false;
    }
    
    
    DefaultTableModel modelo1;
    
    private void CrearModelo() {
        try {
            modelo1 = (new DefaultTableModel(
                    null, new String[]{
                        "id Transaccion", "Fecha", "Nombre",
                        "Cantidad", "Precio", "Tipo"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,};
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tablaDevoluciones.setModel(modelo1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");

        }
    }

    private void CargarInformacion() {
        try {

            Object o[] = null;
            List<Producto> listP = Producto.findProductoEntities();
            List<Transaccion> listT = Transaccion.findTransaccionEntities();
            List<ProductoHasTransaccion> listQ = Transacciones.findProductoHasTransaccionEntities();
            for (int i = 0; i < listT.size(); i++) {
                int IdFacturaDevolucion = Integer.parseInt(campoIdfactura.getText());

                System.out.println("estoy aqui otra vez");
                modelo1.addRow(o);
                modelo1.setValueAt(listT.get(i).getIdTransaccion(), i, 0);
                modelo1.setValueAt(listT.get(i).getFechaT(), i, 1);
                modelo1.setValueAt(listT.get(i).getNombreProducto(), i, 2);
                modelo1.setValueAt(listT.get(i).getCantidad(), i, 3);
                modelo1.setValueAt(listT.get(i).getPrecio(), i, 4);
                modelo1.setValueAt(listT.get(i).getTipo(), i, 5);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print("esto es de aqui");
        }

    } 
    /**
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
            java.util.logging.Logger.getLogger(DevolucionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevolucionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevolucionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevolucionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevolucionForm().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoIdfactura;
    private javax.swing.JButton consultarDevoluciones;
    private javax.swing.JButton enviarDevoluciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDevoluciones;
    // End of variables declaration//GEN-END:variables
}