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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodProducto", query = "SELECT p FROM Producto p WHERE p.codProducto = :codProducto")
    , @NamedQuery(name = "Producto.findByPrecios", query = "SELECT p FROM Producto p WHERE p.precios = :precios")
    , @NamedQuery(name = "Producto.findByTipoProducto", query = "SELECT p FROM Producto p WHERE p.tipoProducto = :tipoProducto")
    , @NamedQuery(name = "Producto.findByMateProducto", query = "SELECT p FROM Producto p WHERE p.mateProducto = :mateProducto")
    , @NamedQuery(name = "Producto.findByNomProducto", query = "SELECT p FROM Producto p WHERE p.nomProducto = :nomProducto")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_producto")
    private String codProducto;
    @Size(max = 10)
    @Column(name = "precios")
    private String precios;
    @Size(max = 45)
    @Column(name = "tipo_producto")
    private String tipoProducto;
    @Size(max = 45)
    @Column(name = "mate_producto")
    private String mateProducto;
    @Size(max = 45)
    @Column(name = "nom_producto")
    private String nomProducto;
    @Size(max = 45)
    @Column(name = "stock")
    private String stock;

    public Producto() {
    }

    public Producto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getPrecios() {
        return precios;
    }

    public void setPrecios(String precios) {
        this.precios = precios;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getMateProducto() {
        return mateProducto;
    }

    public void setMateProducto(String mateProducto) {
        this.mateProducto = mateProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Producto[ codProducto=" + codProducto + " ]";
    }
    
}
