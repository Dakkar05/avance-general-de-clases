/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Estudiante;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("modelo.estudiante")
public class EstudianteFacadeREST extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "IgualacionPU")
    private EntityManager em;

    public EstudianteFacadeREST() {
        super(Estudiante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Estudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Estudiante entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Estudiante find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Estudiante> findAll() {
        return super.findAll();
    }

    @POST
    @Path("obtener")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Estudiante> buscarEst() {
        return super.findAll();
    }

    @POST
    @Path("Hola")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Mensage() {
        return "Hola mundo";
    }

    @GET
    @Path("holaNombre")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String Holanombre(@QueryParam("n") String nom) {
        return "bienenido:" + nom;
    }

    @GET
    @Path("suma")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String result(@QueryParam("sum1") int num1, @QueryParam("sum2") int num2) {
        int res = num1 + num2;
        return "el resultado es: " + res;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("mult")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String mult(@FormParam("num1") int num1, @FormParam("num2") int num2) {
        int res = num1 * num2;
        return "El resultado es: " + res;
    }

    @GET
    @Path("comparacion")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String comparacion(@QueryParam("num1") int num1, @QueryParam("num2") int num2) {
        if (num1 > num2) {
            return num1 + " es mayor";
        } else {
            return num2 + " es mayor";
        }
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("cedula") String cedula, @FormParam("nombres") String nombres, @FormParam("apellidos") String apellidos, @FormParam("telefono") String telefono,
            @FormParam("barrio") String barrio, @FormParam("Ncasa") String Ncasa, @FormParam("direccion") String direccion, @FormParam("correo") String correo) {

        Estudiante ob = new Estudiante(cedula, nombres, apellidos, telefono, barrio, Ncasa, direccion, correo);
        if (cedula.length() == 10) {
            super.create(ob);
            return "el objeto se inserto con exito";
        } else {
            return "la cedula debe tener 10 caracteres";
        }

    }
    
    @POST
    @Path("readBarrio")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List <Estudiante> leerBarrio(@FormParam("barrio")String barrio){
        TypedQuery consulta= getEntityManager().createQuery("SELECT e FROM Estudiante e WHERE e.barrio = :barrio",Estudiante.class);
        consulta.setParameter("barrio", barrio);
        return consulta.getResultList();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
