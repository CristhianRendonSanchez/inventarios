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

// TODO: Auto-generated Javadoc
/**
 * The Class DevolucionForm.
 *
 * @author joans
 */
public class DevolucionForm extends javax.swing.JFrame {
    
    /** The Producto. */
    ProductoJpaController Producto = new ProductoJpaController();
    
    /** The Transaccion. */
    TransaccionJpaController Transaccion = new TransaccionJpaController();
    
    /** The Transacciones. */
    ProductoHasTransaccionJpaController Transacciones = new ProductoHasTransaccionJpaController();

    /**
     * Creates new form DevolucionForm.
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

        campoIdfactura = new javax.swing.JTextField();
        enviarDevoluciones = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(campoIdfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 192, 20));

        enviarDevoluciones.setText("Enviar");
        enviarDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarDevolucionesActionPerformed(evt);
            }
        });
        getContentPane().add(enviarDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, 20));

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
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Enviar devoluciones action performed.
     *
     * @param evt the evt
     */
    private void enviarDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarDevolucionesActionPerformed
        List<Producto> listP = Producto.findProductoEntities();
        List<Transaccion> listT = Transaccion.findTransaccionEntities();
        //List<ProductoHasTransaccion> listQ = Transacciones.findProductoHasTransaccionEntities();
        boolean bandera = true;
        
        Producto p = new Producto();
        int idFactura = Integer.parseInt(campoIdfactura.getText());
        for (int i = 0; i < listT.size(); i++) {
            if (listT.get(i).getIdTransaccion() == idFactura) {
                Date fecha = listT.get(i).getFechaT();
                String nombre = listT.get(i).getNombreProducto();
                String tipo = listT.get(i).getTipo();
                float precioDeLaTransacion = listT.get(i).getPrecio();
                int cantidadEnLaTransaccion = listT.get(i).getCantidad();
                boolean estadoDevolucion = listT.get(i).getDevolucion();
                int idTransaccion = listT.get(i).getIdTransaccion();
                
                int idProducto = traerId(nombre);
                int cantidadEnInventario = cantidad(nombre);

                //System.out.println(cantidadTransaciones(nombre) + tipo);
                if (cantidad(nombre) > 0 && tipo.equals("entrada") && estadoDevolucion == false) {
                    try {
                        //se trata como una salida (devolucion a proveedor) se actualiza el valor en la bd
                        Producto eActualizable = Producto.findProducto(idProducto);
                        //System.out.println(eActualizable);
                        System.out.println("LA CANTIDAD DE LA TRANSACCION FUE DE " + cantidadEnLaTransaccion);
                        int nuevaCantidad = cantidadEnInventario - cantidadEnLaTransaccion;
                        
                        if (nuevaCantidad < 0) {
                            JOptionPane.showMessageDialog(null, "Lo sentimos, no tenemos esa cantidad.\nSolo poseemos " + cantidadEnInventario
                                    + " articulos en el inventario\n y tu estás solicitando devolución de " + cantidadEnLaTransaccion + " articulos.", "Total excedido", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            
                            float totalSalida = precioDeLaTransacion * cantidadEnLaTransaccion;
                            
                            float precioDeInventario = traerValorU(nombre) * cantidadEnInventario;

                            //Este es el Valor Total de la transaccion
                            float actualizacionSaldo = totalSalida - precioDeInventario;
                            
                            float valorUnitario = actualizacionSaldo / nuevaCantidad;
                            
                            eActualizable.setCantidadAlmacenada(nuevaCantidad);
                            eActualizable.setNombreProducto(nombre);
                            eActualizable.setValorUnitario(valorUnitario);
                            Producto.edit(eActualizable);

                            //REALIZAMOS LA TRANSACCION DE LA DEVOLUCION POR ENTRADA
                            Transaccion registro = new Transaccion();
                            registro.setFechaT(fecha);
                            registro.setNombreProducto(nombre);
                            registro.setCantidad(cantidadEnLaTransaccion);
                            registro.setPrecio(precioDeLaTransacion);
                            registro.setTipo("dev Entrada");
                            registro.setDevolucion(false);
                            
                            Transaccion.create(registro);

                            //
                            Transaccion actualizable = Transaccion.findTransaccion(idTransaccion);
                            actualizable.setDevolucion(true);
                            Transaccion.edit(actualizable);
                            
                            JOptionPane.showMessageDialog(null, "Devolución Exitosa.");
                            this.setVisible(false);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error, revisa tus datos.");
                    }
                    //NOTA
                } else if (cantidad(nombre) > 0 && tipo.equals("entrada") && estadoDevolucion == true) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, esta devolución ya fue\nRealizada anteriormente.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                } else if (cantidad(nombre) > 0 && tipo.equals("salida") && estadoDevolucion == false) {
                    //se trata como una entrada (devolucion de un cliente a nosotros )se actualiza el valor en la bd 
                    try {
                        Producto eActualizable = Producto.findProducto(idProducto);
                        
                        int nuevaCantidad = cantidadEnInventario + cantidadEnLaTransaccion;
                        float valorUnitario;
                        float totalSalida = precioDeLaTransacion * cantidadEnLaTransaccion;
                        float precioDeInventario = traerValorU(nombre) * cantidadEnInventario;

                        //Este es el Valor Total de la transaccion
                        float actualizacionSaldo = totalSalida + precioDeInventario;
                        
                        valorUnitario = actualizacionSaldo / nuevaCantidad;
                        
                        eActualizable.setCantidadAlmacenada(nuevaCantidad);
                        // eActualizable.setNombreProducto(nombre);
                        eActualizable.setValorUnitario(valorUnitario);
                        Producto.edit(eActualizable);

                        //REALIZAMOS LA TRANSACCION DE LA DEVOLUCION POR ENTRADA
                        Transaccion registro = new Transaccion();
                        registro.setFechaT(fecha);
                        registro.setNombreProducto(nombre);
                        registro.setCantidad(cantidadEnLaTransaccion);
                        registro.setPrecio(precioDeLaTransacion);
                        registro.setTipo("dev Salida");
                        registro.setDevolucion(false);
                        
                        Transaccion.create(registro);

                        //
                        Transaccion actualizable = Transaccion.findTransaccion(idTransaccion);
                        actualizable.setDevolucion(true);
                        Transaccion.edit(actualizable);
                        
                        JOptionPane.showMessageDialog(null, "Devolución Exitosa.");
                        this.setVisible(false);
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error, revisa tus datos");
                    }
//AQIO
                } else if (cantidad(nombre) > 0 && tipo.equals("salida") && estadoDevolucion == true) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, esta devolución ya fue\nRealizada anteriormente.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    
                } else {
                    bandera = false;
                }
            }
            
        }
        if (bandera != true) { //VA A VENDER UN PRODUCTO QUE NO EXISTE:
            JOptionPane.showMessageDialog(null, "Estás intentando devolver algo que no existe!\nRevisa tu inventario.", "ERROR", JOptionPane.WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_enviarDevolucionesActionPerformed

    /**
     * J button 1 action performed.
     *
     * @param evt the evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Campo idfactura action performed.
     *
     * @param evt the evt
     */
    private void campoIdfacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdfacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdfacturaActionPerformed

    /**
     * Campo idfactura key typed.
     *
     * @param evt the evt
     */
    private void campoIdfacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIdfacturaKeyTyped
        char c = evt.getKeyChar();
        
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_campoIdfacturaKeyTyped
    
    /**
     * Cantidad transaciones.
     *
     * @param nombre the nombre
     * @return the int
     */
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
    
    /**
     * Cantidad.
     *
     * @param nombre the nombre
     * @return the int
     */
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
    
    /**
     * Busqueda id.
     *
     * @param id the id
     * @return true, if successful
     */
    public boolean busquedaId(int id) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getIdProducto().equals(id)) {
                return true;
            }
            
        }
        return false;
    }
    
    /**
     * Traer id.
     *
     * @param nombre the nombre
     * @return the int
     */
    public int traerId(String nombre) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                int idRespueseta = listP.get(i).getIdProducto();
                return idRespueseta;
            }
            
        }
        return 0;
    }
    
    /**
     * Busqueda nombre.
     *
     * @param nombre the nombre
     * @return true, if successful
     */
    public boolean busquedaNombre(String nombre) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                return true;
            }
            
        }
        return false;
    }
    
    /**
     * Traer nombre.
     *
     * @param nombre the nombre
     * @return the int
     */
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
    
    /**
     * Traer valor U.
     *
     * @param nombre the nombre
     * @return the float
     */
    //FUNCION QUE ME PASO MANUEL 
    public float traerValorU(String nombre) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getNombreProducto().equals(nombre)) {
                float resultadoBusqueda = listP.get(i).getValorUnitario();
                return resultadoBusqueda;

            }

        }
        return 0;
    }
    
    /**
     * Busqueda.
     *
     * @param id the id
     * @return true, if successful
     */
    public boolean busqueda(int id) {
        List<Producto> listP = Producto.findProductoEntities();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getIdProducto() == id) {
                return true;
            }
            
        }
        return false;
    }
    
    /** The modelo 1. */
    DefaultTableModel modelo1;
    
    /**
     * Crear modelo.
     */
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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
            
        }
    }
    
    /**
     * Cargar informacion.
     */
    private void CargarInformacion() {
        try {
            
            Object o[] = null;
            List<Producto> listP = Producto.findProductoEntities();
            List<Transaccion> listT = Transaccion.findTransaccionEntities();
            List<ProductoHasTransaccion> listQ = Transacciones.findProductoHasTransaccionEntities();
            for (int i = 0; i < listT.size(); i++) {
                int IdFacturaDevolucion = Integer.parseInt(campoIdfactura.getText());
                
                //System.out.println("estoy aqui otra vez");
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
            //System.out.print("esto es de aqui");
        }
        
    }

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


    /** The campo idfactura. */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoIdfactura;
    
    /** The enviar devoluciones. */
    private javax.swing.JButton enviarDevoluciones;
    
    /** The j button 1. */
    private javax.swing.JButton jButton1;
    
    /** The j label 1. */
    private javax.swing.JLabel jLabel1;
    
    /** The j label 2. */
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
