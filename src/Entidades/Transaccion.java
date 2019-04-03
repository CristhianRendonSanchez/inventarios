/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Transaccion.
 *
 * @author joans
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "Transaccion.findByFechaT", query = "SELECT t FROM Transaccion t WHERE t.fechaT = :fechaT")
    , @NamedQuery(name = "Transaccion.findByNombreProducto", query = "SELECT t FROM Transaccion t WHERE t.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Transaccion.findByCantidad", query = "SELECT t FROM Transaccion t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "Transaccion.findByPrecio", query = "SELECT t FROM Transaccion t WHERE t.precio = :precio")
    , @NamedQuery(name = "Transaccion.findByTipo", query = "SELECT t FROM Transaccion t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Transaccion.findByDevolucion", query = "SELECT t FROM Transaccion t WHERE t.devolucion = :devolucion")})
public class Transaccion implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The id transaccion. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private Integer idTransaccion;
    
    /** The fecha T. */
    @Basic(optional = false)
    @Column(name = "fechaT")
    @Temporal(TemporalType.DATE)
    private Date fechaT;
    
    /** The nombre producto. */
    @Basic(optional = false)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    
    /** The cantidad. */
    @Column(name = "cantidad")
    private Integer cantidad;
    
    /** The precio. */
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    
    /** The tipo. */
    @Column(name = "tipo")
    private String tipo;
    
    /** The devolucion. */
    @Basic(optional = false)
    @Column(name = "devolucion")
    private boolean devolucion;

    /**
     * Instantiates a new transaccion.
     */
    public Transaccion() {
    }

    /**
     * Instantiates a new transaccion.
     *
     * @param idTransaccion the id transaccion
     */
    public Transaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Instantiates a new transaccion.
     *
     * @param idTransaccion the id transaccion
     * @param fechaT the fecha T
     * @param nombreProducto the nombre producto
     * @param devolucion the devolucion
     */
    public Transaccion(Integer idTransaccion, Date fechaT, String nombreProducto, boolean devolucion) {
        this.idTransaccion = idTransaccion;
        this.fechaT = fechaT;
        this.nombreProducto = nombreProducto;
        this.devolucion = devolucion;
    }

    /**
     * Gets the id transaccion.
     *
     * @return the id transaccion
     */
    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Sets the id transaccion.
     *
     * @param idTransaccion the new id transaccion
     */
    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Gets the fecha T.
     *
     * @return the fecha T
     */
    public Date getFechaT() {
        return fechaT;
    }

    /**
     * Sets the fecha T.
     *
     * @param fechaT the new fecha T
     */
    public void setFechaT(Date fechaT) {
        this.fechaT = fechaT;
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
     * Gets the cantidad.
     *
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Sets the cantidad.
     *
     * @param cantidad the new cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Gets the precio.
     *
     * @return the precio
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Sets the precio.
     *
     * @param precio the new precio
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets the devolucion.
     *
     * @return the devolucion
     */
    public boolean getDevolucion() {
        return devolucion;
    }

    /**
     * Sets the devolucion.
     *
     * @param devolucion the new devolucion
     */
    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Entidades.Transaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
