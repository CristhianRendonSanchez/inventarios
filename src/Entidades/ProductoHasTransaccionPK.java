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

/**
 *
 * @author joans
 */
@Embeddable
public class ProductoHasTransaccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idProducto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private int idTransaccion;

    public ProductoHasTransaccionPK() {
    }

    public ProductoHasTransaccionPK(int idProducto, int idTransaccion) {
        this.idProducto = idProducto;
        this.idTransaccion = idTransaccion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idTransaccion;
        return hash;
    }

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

    @Override
    public String toString() {
        return "Entidades.ProductoHasTransaccionPK[ idProducto=" + idProducto + ", idTransaccion=" + idTransaccion + " ]";
    }
}
