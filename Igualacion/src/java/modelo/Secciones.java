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
@Table(name = "secciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secciones.findAll", query = "SELECT s FROM Secciones s")
    , @NamedQuery(name = "Secciones.findByCedula", query = "SELECT s FROM Secciones s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "Secciones.findByNombre", query = "SELECT s FROM Secciones s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Secciones.findByDireccion", query = "SELECT s FROM Secciones s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Secciones.findByFecha", query = "SELECT s FROM Secciones s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Secciones.findByTelefono", query = "SELECT s FROM Secciones s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "Secciones.findByCorreo", query = "SELECT s FROM Secciones s WHERE s.correo = :correo")})
public class Secciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;

    public Secciones() {
    }

    public Secciones(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secciones)) {
            return false;
        }
        Secciones other = (Secciones) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Secciones[ cedula=" + cedula + " ]";
    }
    
}
