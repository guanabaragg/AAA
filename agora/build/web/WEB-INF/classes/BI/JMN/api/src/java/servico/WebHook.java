/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import RDWH.Lead;
import RDWH.LeadWH;
import Util.Conexao;
import bi.APagarDao;
import bi.APagar;
import bi.AReceber;
import bi.AReceberDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author guima
 */
@Path("bi")
public class WebHook {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Metodo1Resource
     */
    public WebHook() {
    }

    @POST
    @Produces("application/json")
    @Path("/exemplo")
    public Response exemplo(String pConteudo) throws Exception {

        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();

        LeadWH leadWh = (LeadWH) gson.fromJson(pConteudo, LeadWH.class);
        System.out.println("AAAAA");

        if (!leadWh.getLeads().isEmpty()) {
            for (Lead lead : leadWh.getLeads()) {
                System.out.println(lead.getEmail());
                salvarEmail(lead.getEmail());
            }
        }

        return Response.status(200).entity(gson.toJson(leadWh)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listarAPagar")
    public Response listarAPagar() {
        APagarDao dao = new APagarDao();
        List<APagar> lista = new ArrayList<>();
        lista = dao.listarAPagar();

        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
        String json = gson.toJson(lista);

        return Response.status(200).entity(json).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listarAReceber")
    public Response listarAReceber() {
        AReceberDao dao = new AReceberDao();
        List<AReceber> lista = new ArrayList<>();
        lista = dao.listarAReceber();

        //Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
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

    public void salvarEmail(String email) {

        try {
            Conexao conexao = new Conexao();
            Connection conn;
            conn = conexao.getConnection();

            String sql = "insert into sgm_cross(email) "
                    + " values (?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps = conn.prepareStatement(sql);

            ps.setString(1, email);

            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(WebHook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
