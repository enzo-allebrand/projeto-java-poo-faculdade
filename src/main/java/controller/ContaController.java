package controller;

import entity.Conta;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("Conta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContaController {

    @GET
    @Path("findAll")
    public List<Conta> findAll(){
        return Conta.listAll();
    }

    @POST
    @Transactional
    public Response create(Conta conta) {
        conta.persist();
        return Response.status(Response.Status.CREATED).entity(conta).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Conta conta) {
        Conta entity = Conta.findById(id);
        if(entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setDescricao(conta.getDescricao());
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Conta entity = Conta.findById(id);
        if(entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }
}
