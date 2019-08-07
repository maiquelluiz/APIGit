package DB_FRETES;

import DBs.DAO_Generic;
import DBs.DAO;
import Apoio.SystemExceptions;
import Models.FRETES_Aparelho;

/**
 * Criado por Maiquel Luiz em 13/07/2018.
 */
public class DAO_Aparelhos extends DAO_Generic implements DAO<FRETES_Aparelho>{

    public DAO_Aparelhos() {
        super(FRETES_Aparelho.class, "FRETES_Aparelho", "idAparelhos");
    }

    public FRETES_Aparelho Buscar(String imei) throws SystemExceptions.DBeException {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append(getNomeCampos());
        query.append(" from ");
        query.append(getNomeTabela());
        query.append(" where imei = '");
        query.append(imei);
        query.append("' and visivel = 'S'");
        return SQLBuscar(query);
    }

    @Override
    public FRETES_Aparelho BuscarUltimo(int idAparelho) throws SystemExceptions.DBeException {
        return super.BuscarUltimo(idAparelho); //To change body of generated methods, choose Tools | Templates. aquii 1
    }

    @Override
    public FRETES_Aparelho BuscarId(int id) throws SystemExceptions.DBeException {
        return super.BuscarId(id); //To change body of generated methods, choose Tools | Templates. aquii 1
    }

}
