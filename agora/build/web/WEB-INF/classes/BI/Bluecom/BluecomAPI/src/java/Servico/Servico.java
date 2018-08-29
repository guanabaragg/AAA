/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Financeiro.Financeiro;
import Financeiro.FinanceiroDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author guana
 */
@Path("servico")
public class Servico {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Servico() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listarFinanceiro")
    public Response listarFinanceiro() {
        FinanceiroDAO dao = new FinanceiroDAO();
        List<Financeiro> lista = new ArrayList<>();
        lista = dao.listarFinanceiro();

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(lista);

        return Response.status(200).entity(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Consumes("application/json")
    public void postJson(String content) {
    }

    @GET
    @Consumes("application/json")
    public void getJson(String content) {
    }

}
