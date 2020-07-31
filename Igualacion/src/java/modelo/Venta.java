/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdProducto", query = "SELECT v FROM Venta v WHERE v.idProducto = :idProducto")
    , @NamedQuery(name = "Venta.findByCedComprador", query = "SELECT v FROM Venta v WHERE v.cedComprador = :cedComprador")
    , @NamedQuery(name = "Venta.findByNomProducto", query = "SELECT v FROM Venta v WHERE v.nomProducto = :nomProducto")
    , @NamedQuery(name = "Venta.findByEstadoProducto", query = "SELECT v FROM Venta v WHERE v.estadoProducto = :estadoProducto")
    , @NamedQuery(name = "Venta.findByTipoproducto", query = "SELECT v FROM Venta v WHERE v.tipoproducto = :tipoproducto")
    , @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Venta.findByPrecio", query = "SELECT v FROM Venta v WHERE v.precio = :precio")
    , @NamedQuery(name = "Venta.findByCodProducto", query = "SELECT v FROM Venta v WHERE v.codProducto = :codProducto")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_producto")
    private String idProducto;
    @Size(max = 10)
    @Column(name = "ced_comprador")
    private String cedComprador;
    @Size(max = 45)
    @Column(name = "nom_producto")
    private String nomProducto;
    @Size(max = 45)
    @Column(name = "estado_producto")
    private String estadoProducto;
    @Size(max = 45)
    @Column(name = "Tipo_producto")
    private String tipoproducto;
    @Size(max = 10)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 10)
    @Column(name = "Precio")
    private String precio;
    @Size(max = 45)
    @Column(name = "cod_producto")
    private String codProducto;

    public Venta() {
    }

    public Venta(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCedComprador() {
        return cedComprador;
    }

    public void setCedComprador(String cedComprador) {
        this.cedComprador = cedComprador;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venta[ idProducto=" + idProducto + " ]";
    }
    
}
