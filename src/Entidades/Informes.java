package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controladores.*;

import java.util.List;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

/**
 *
 * @author PORTATIL
 */
public class Informes {

    private TransaccionJpaController CTransaccion = new TransaccionJpaController();

    public Informes() {
    }

    public void informeEntradas() {
        try {
            Object o[] = null;
            List<Transaccion> listT = CTransaccion.findTransaccionEntities();

            SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");

            FileOutputStream archivo = new FileOutputStream("reportes/Informe de Entradas.pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            Paragraph titulo = new Paragraph();
            titulo.add("Informe de Entradas \n \n");
            titulo.setLeading(15);
            titulo.setAlignment(1);
            documento.add(titulo);

            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(5);
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("fecha");
            table.addCell("id Transaccion");
            table.addCell("nombre Producto");
            table.addCell("cantidad");
            table.addCell("precio");

            for (int i = 0; i < listT.size(); i++) {

                if (listT.get(i).getTipo().equals("entrada")) {

                    String fecha = formato.format(listT.get(i).getFechaT());
                    String id = listT.get(i).getIdTransaccion().toString();
                    String nombre = listT.get(i).getNombreProducto();
                    String cantidad = listT.get(i).getCantidad().toString();
                    String precio = listT.get(i).getPrecio().toString();

                    table.addCell(fecha);
                    table.addCell(id);
                    table.addCell(nombre);
                    table.addCell(cantidad);
                    table.addCell(precio);

                }
            }
            documento.add(table);
            documento.close();
            
            JOptionPane.showMessageDialog(null,"informe de entradas generado con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        };
    }

    public void informeSalidas() {

        try {
            Object o[] = null;
            List<Transaccion> listT = CTransaccion.findTransaccionEntities();

            SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");

            FileOutputStream archivo = new FileOutputStream("reportes/Informe de Salidas.pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            Paragraph titulo = new Paragraph();
            titulo.add("Informe de Salidas \n \n");
            titulo.setLeading(15);
            titulo.setAlignment(1);
            documento.add(titulo);

            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(5);
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("fecha");
            table.addCell("id Transaccion");
            table.addCell("nombre Producto");
            table.addCell("cantidad");
            table.addCell("precio");

            for (int i = 0; i < listT.size(); i++) {

                if (listT.get(i).getTipo().equals("salida")) {

                    String fecha = formato.format(listT.get(i).getFechaT());
                    String id = listT.get(i).getIdTransaccion().toString();
                    String nombre = listT.get(i).getNombreProducto();
                    String cantidad = listT.get(i).getCantidad().toString();
                    String precio = listT.get(i).getPrecio().toString();

                    table.addCell(fecha);
                    table.addCell(id);
                    table.addCell(nombre);
                    table.addCell(cantidad);
                    table.addCell(precio);

                }
            }
            documento.add(table);
            documento.close();
            
            JOptionPane.showMessageDialog(null,"informe de salidas generado con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        };
    }

    public void informeDevoluciones() {
        try {
            Object o[] = null;
            List<Transaccion> listT = CTransaccion.findTransaccionEntities();

            SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");

            FileOutputStream archivo = new FileOutputStream("reportes/Informe de devoluciones.pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            Paragraph titulo =new Paragraph();
            titulo.add("Informe de Devoluciones \n \n");
            titulo.setAlignment(1);
            documento.add(titulo);

            documento.add( new Paragraph("Informe de Devoluciones entrada \n \n"));

            // Este codigo genera una tabla de 3 columnas
            PdfPTable table1 = new PdfPTable(5);
            PdfPTable table2 = new PdfPTable(5);
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table1.addCell("fecha");
            table1.addCell("id Transaccion");
            table1.addCell("nombre Producto");
            table1.addCell("cantidad");
            table1.addCell("precio");
            table2.addCell("fecha");
            table2.addCell("id Transaccion");
            table2.addCell("nombre Producto");
            table2.addCell("cantidad");
            table2.addCell("precio");

            for (int i = 0; i < listT.size(); i++) {

                if (listT.get(i).getTipo().equals("dev entrada")) {
                    String fecha = formato.format(listT.get(i).getFechaT());
                    String id = listT.get(i).getIdTransaccion().toString();
                    String nombre = listT.get(i).getNombreProducto();
                    String cantidad = listT.get(i).getCantidad().toString();
                    String precio = listT.get(i).getPrecio().toString();
                    table1.addCell(fecha);
                    table1.addCell(id);
                    table1.addCell(nombre);
                    table1.addCell(cantidad);
                    table1.addCell(precio);
                }
            }
            documento.add(table1);

            documento.add( new Paragraph("\n \n Informe de Devoluciones salida \n \n"));

            for (int i = 0; i < listT.size(); i++) {

                if (listT.get(i).getTipo().equals("dev salida")) {
                    String fecha = formato.format(listT.get(i).getFechaT());
                    String id = listT.get(i).getIdTransaccion().toString();
                    String nombre = listT.get(i).getNombreProducto();
                    String cantidad = listT.get(i).getCantidad().toString();
                    String precio = listT.get(i).getPrecio().toString();

                    table2.addCell(fecha);
                    table2.addCell(id);
                    table2.addCell(nombre);
                    table2.addCell(cantidad);
                    table2.addCell(precio);
                }

            }
            documento.add(table2);
            documento.close();
            JOptionPane.showMessageDialog(null,"informe de devoluciones generado con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        };
    }

}
