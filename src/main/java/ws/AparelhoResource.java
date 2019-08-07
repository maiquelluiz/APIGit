/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import static Apoio.GsonBuilderFactory.GsonBuilderFactory;
import static Apoio.GsonBuilderFactory.getObject;
import Apoio.SystemExceptions;
import DB_FRETES.DB_DAO;
import Models.FRETES_Aparelho;
import Models.ParesIdSql;
import Models.Resposta;
import Seguranca.NivelPermissao;
import Seguranca.Seguro;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mblui
 */
@Path("/")
public class AparelhoResource {

    @Context
    private UriInfo context;
    
    Gson GSON;
    
    public AparelhoResource() {
        this.GSON = GsonBuilderFactory();
    }

    /**
     *
     * @param idAparelho
     * @param id
     * @param qtd
     * @return
     */
    @Seguro({NivelPermissao.NIVEL_1})
    @GET
    @Path("aparelhos/{idAparelho}/{id}/{qtd}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAparelhos(@PathParam("idAparelho") int idAparelho, @PathParam("id") int id, @PathParam("qtd") int qtd) {
        System.out.println("GET: aparelhos/"+idAparelho+"/"+id+"/"+qtd);
        Resposta resposta = new Resposta();

        try {
            ParesIdSql par = DB_DAO.getInstance().getAparelhos().CreateInsert(2, idAparelho, id, qtd);
            resposta.setObject(par);
            resposta.setcStat(200);
            resposta.setxStat("OK");            
        } catch (SystemExceptions.DBeException ex) {
            resposta.setcStat(500);
            resposta.setxStat(ex.getMessage());
        }

        return GSON.toJson(resposta);
    }
    
    /**
     *
     * @param imei
     * @return
     */
    @Seguro({NivelPermissao.NIVEL_1})
    @GET
    @Path("aparelho/{imei}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAparelho(@PathParam("imei") String imei) {
        System.out.println("GET: aparelho/"+imei);
        Resposta resposta = new Resposta();
        try {
            FRETES_Aparelho APARELHO = DB_DAO.getInstance().getAparelhos().Buscar(imei);
            if (APARELHO.getIdAparelhos() > 0) {
                resposta.setObject(APARELHO);
                resposta.setcStat(200);
                resposta.setxStat("OK");
            } else {
                resposta.setcStat(404);
                resposta.setxStat("Registro não encontrado.");
            }
        } catch (SystemExceptions.DBeException ex) {
            resposta.setcStat(500);
            resposta.setxStat(ex.getMessage());
        }

        return GSON.toJson(resposta);
    }
    
    /**
     * Insere Aparelho no Banco de dados Principal
     *
     * @param entrada
     * @return an instance of java.lang.String
     */
    @Seguro({NivelPermissao.NIVEL_1})
    @PUT
    @Path("aparelho")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String InsereAparelho(String entrada) {

        System.out.println("PUT: aparelho");
        Resposta recurso = GSON.fromJson(entrada, Resposta.class);
        Resposta OBJ = new Resposta();
        
        OBJ.setObject(getObject(GSON, recurso.getObject(FRETES_Aparelho.class), FRETES_Aparelho.class));
        OBJ.setcStat(recurso.getcStat());
        OBJ.setxStat(recurso.getxStat());

        Resposta resposta = new Resposta();        
        try {
            resposta.setObject(DB_DAO.getInstance().getAparelhos().Inserir(OBJ.getObject(FRETES_Aparelho.class)));
            resposta.setcStat(100);
            resposta.setxStat("Registro inserido com sucesso.");
            System.out.println("Sucesso!");
        } catch (SystemExceptions.DBeException ex) {
            resposta.setcStat(215);
            resposta.setxStat(ex.getMessage());
            System.out.println("Falha!");
            ex.printStackTrace();
        }
        return GSON.toJson(resposta);
    }
}
