package controller;

import entity.Transacao;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("Transacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransacaoController {

    @GET
    @Path("findAll")
    public List<Transacao> findAll(){
        return Transacao.listAll();
    }

    @POST
    @Transactional
    public Response create(Transacao transacao) {
        transacao.persist();
        return Response.status(Response.Status.CREATED).entity(transacao).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Transacao transacao) {
        Transacao entity = Transacao.findById(id);
        if(entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setDescricao(transacao.getDescricao());
        entity.setValor(transacao.getValor());
        entity.setTipo(transacao.getTipo());
        entity.setDatatransacao(transacao.getDatatransacao());
        entity.setConta(transacao.getConta());
        entity.setCategoria(transacao.getCategoria());
        
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Transacao entity = Transacao.findById(id);
        if(entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.noContent().build();
    }
}
