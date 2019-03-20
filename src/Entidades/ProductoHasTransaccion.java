/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joans
 */
@Entity
@Table(name = "producto_has_transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasTransaccion.findAll", query = "SELECT p FROM ProductoHasTransaccion p")
    , @NamedQuery(name = "ProductoHasTransaccion.findByIdProducto", query = "SELECT p FROM ProductoHasTransaccion p WHERE p.productoHasTransaccionPK.idProducto = :idProducto")
    , @NamedQuery(name = "ProductoHasTransaccion.findByIdTransaccion", query = "SELECT p FROM ProductoHasTransaccion p WHERE p.productoHasTransaccionPK.idTransaccion = :idTransaccion")})
public class ProductoHasTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoHasTransaccionPK productoHasTransaccionPK;

    public ProductoHasTransaccion() {
    }

    public ProductoHasTransaccion(ProductoHasTransaccionPK productoHasTransaccionPK) {
        this.productoHasTransaccionPK = productoHasTransaccionPK;
    }

    public ProductoHasTransaccion(int idProducto, int idTransaccion) {
        this.productoHasTransaccionPK = new ProductoHasTransaccionPK(idProducto, idTransaccion);
    }

    public ProductoHasTransaccionPK getProductoHasTransaccionPK() {
        return productoHasTransaccionPK;
    }

    public void setProductoHasTransaccionPK(ProductoHasTransaccionPK productoHasTransaccionPK) {
        this.productoHasTransaccionPK = productoHasTransaccionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoHasTransaccionPK != null ? productoHasTransaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasTransaccion)) {
            return false;
        }
        ProductoHasTransaccion other = (ProductoHasTransaccion) object;
        if ((this.productoHasTransaccionPK == null && other.productoHasTransaccionPK != null) || (this.productoHasTransaccionPK != null && !this.productoHasTransaccionPK.equals(other.productoHasTransaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductoHasTransaccion[ productoHasTransaccionPK=" + productoHasTransaccionPK + " ]";
    }
    
}
