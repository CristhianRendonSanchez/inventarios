/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Producto.
 *
 * @author joans
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByValorUnitario", query = "SELECT p FROM Producto p WHERE p.valorUnitario = :valorUnitario")
    , @NamedQuery(name = "Producto.findByCantidadAlmacenada", query = "SELECT p FROM Producto p WHERE p.cantidadAlmacenada = :cantidadAlmacenada")})
public class Producto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The id producto. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    
    /** The nombre producto. */
    @Column(name = "nombreProducto")
    private String nombreProducto;
    
    /** The valor unitario. */
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorUnitario")
    private Float valorUnitario;
    
    /** The cantidad almacenada. */
    @Column(name = "cantidadAlmacenada")
    private Integer cantidadAlmacenada;

    /**
     * Instantiates a new producto.
     */
    public Producto() {
    }

    /**
     * Instantiates a new producto.
     *
     * @param idProducto the id producto
     */
    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Gets the id producto.
     *
     * @return the id producto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the id producto.
     *
     * @param idProducto the new id producto
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Gets the nombre producto.
     *
     * @return the nombre producto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Sets the nombre producto.
     *
     * @param nombreProducto the new nombre producto
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Gets the valor unitario.
     *
     * @return the valor unitario
     */
    public Float getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Sets the valor unitario.
     *
     * @param valorUnitario the new valor unitario
     */
    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Gets the cantidad almacenada.
     *
     * @return the cantidad almacenada
     */
    public Integer getCantidadAlmacenada() {
        return cantidadAlmacenada;
    }

    /**
     * Sets the cantidad almacenada.
     *
     * @param cantidadAlmacenada the new cantidad almacenada
     */
    public void setCantidadAlmacenada(Integer cantidadAlmacenada) {
        this.cantidadAlmacenada = cantidadAlmacenada;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Entidades.Producto[ idProducto=" + idProducto + " ]";
    }
}
