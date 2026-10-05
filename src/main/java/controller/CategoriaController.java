package controller;

import entity.Categoria;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("Categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaController {

    @GET
    @Path("findAll")
    public List<Categoria> findAll(){
        return Categoria.listAll();
    }

    @POST
    @Transactional
    public Response create(Categoria categoria) {
        categoria.persist();
        return Response.status(Response.Status.CREATED).entity(categoria).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Categoria categoria) {
        Categoria entity = Categoria.findById(id);
        if(entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setDescricao(categoria.getDescricao());
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Categoria entity = Categoria.findById(id);
        if(entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }
}
