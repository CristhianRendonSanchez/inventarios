/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductoHasTransaccionPK.
 *
 * @author joans
 */
@Embeddable
public class ProductoHasTransaccionPK implements Serializable {

    /** The id producto. */
    @Basic(optional = false)
    @Column(name = "idProducto")
    private int idProducto;
    
    /** The id transaccion. */
    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private int idTransaccion;

    /**
     * Instantiates a new producto has transaccion PK.
     */
    public ProductoHasTransaccionPK() {
    }

    /**
     * Instantiates a new producto has transaccion PK.
     *
     * @param idProducto the id producto
     * @param idTransaccion the id transaccion
     */
    public ProductoHasTransaccionPK(int idProducto, int idTransaccion) {
        this.idProducto = idProducto;
        this.idTransaccion = idTransaccion;
    }

    /**
     * Gets the id producto.
     *
     * @return the id producto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the id producto.
     *
     * @param idProducto the new id producto
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Gets the id transaccion.
     *
     * @return the id transaccion
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Sets the id transaccion.
     *
     * @param idTransaccion the new id transaccion
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idTransaccion;
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoHasTransaccionPK)) {
            return false;
        }
        ProductoHasTransaccionPK other = (ProductoHasTransaccionPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idTransaccion != other.idTransaccion) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Entidades.ProductoHasTransaccionPK[ idProducto=" + idProducto + ", idTransaccion=" + idTransaccion + " ]";
    }
}
