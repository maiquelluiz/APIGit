/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBs;

import Apoio.GzipUtils;
import Apoio.SystemExceptions;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.ParesIdSql;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Maiquel
 */
public class DAO_Generic {

    private Object OBJ;
    private String nomeTabela;
    private String nomeId;
    private String nomeCampos;
    private Class tipo;
    private InterfaceDB IDB;

    public DAO_Generic(Class tipo, String nomeTabela, String nomeId) {
        try {
            this.IDB = new InterfaceDB();
            this.OBJ = tipo.newInstance();
            this.nomeTabela = nomeTabela;
            this.nomeId = nomeId;
            this.nomeCampos = IDB.nomeDosCampos(OBJ);
            this.tipo = tipo;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DAO_Generic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public <T> T BuscarId(int id) throws SystemExceptions.DBeException {
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ");
            query.append(getNomeCampos());
            query.append(" from ");
            query.append(getNomeTabela());
            query.append(" where ");
            query.append(getNomeId());
            query.append(" = ");
            query.append(id);
            return (T) IDB.Buscar(query.toString(), tipo.newInstance());
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public <T> T BuscarIdANT(int id) throws SystemExceptions.DBeException {
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ");
            query.append(getNomeCampos());
            query.append(" from ");
            query.append(getNomeTabela());
            query.append(" where idANT = ");
            query.append(id);
            return (T) IDB.Buscar(query.toString(), tipo.newInstance());
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public <T> T BuscarId(BigInteger id) throws SystemExceptions.DBeException {
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ");
            query.append(getNomeCampos());
            query.append(" from ");
            query.append(getNomeTabela());
            query.append(" where ");
            query.append(getNomeId());
            query.append(" = ");
            query.append(id);
            return (T) IDB.Buscar(query.toString(), tipo.newInstance());
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public <T> List<T> Listar(int idAparelho, int id, int qtd) throws SystemExceptions.DBeException {
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ");
            query.append(getNomeCampos());
            query.append(" from ");
            query.append(getNomeTabela());
            query.append(" where ");
            query.append(getNomeId());
            query.append(" >= ");
            query.append(id);
            query.append(" AND (idAparelho <> ");
            query.append(idAparelho);
            query.append(" OR idANT > 0) LIMIT ");
            query.append(qtd);
            List ls = new ArrayList();
            Object obj;
            for (Iterator iterator = IDB.BuscarLista(query.toString(), tipo.newInstance()).iterator(); iterator.hasNext(); ls.add(obj)) {
                obj = iterator.next();
            }
            return ls;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public <T> T BuscarUltimo(int idAparelho) throws SystemExceptions.DBeException {
        try {
            StringBuilder query = new StringBuilder();
            query.append("select ");
            query.append(getNomeCampos());
            query.append(" from ");
            query.append(getNomeTabela());
            query.append(" WHERE idAparelho <> ");
            query.append(idAparelho);
            query.append(" OR idANT > 0 order by ");
            query.append(getNomeId());
            query.append(" desc limit 1");
            return (T) IDB.Buscar(query.toString(), tipo.newInstance());
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public int BuscarUltimoId() throws SystemExceptions.DBeException {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append(getNomeId());
        query.append(" from ");
        query.append(getNomeTabela());
        query.append(" order by ");
        query.append(getNomeId());
        query.append(" desc limit 1");
        try {
            return (int) IDB.BuscarInt(query.toString());
        } catch (SystemExceptions.DBeException ex) {
            throw new SystemExceptions.DBeException(ex.getMessage());
        }

    }

    /**
     *
     * @param obj
     * @param usuario
     * @throws SystemExceptions.DBeException
     */
    public void Atualizar(Object obj, int usuario) throws SystemExceptions.DBeException {
        IDB.Atualizar(getNomeTabela(), getNomeId(), obj, usuario);
    }

    public int Inserir(Object obj) throws SystemExceptions.DBeException {
        return IDB.Inserir(getNomeTabela(), obj);
    }

    public <T> T SQLBuscar(StringBuilder query) throws SystemExceptions.DBeException {
        try {
            return (T) IDB.Buscar(query.toString(), tipo.newInstance());
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public <T> List<T> SQLListar(StringBuilder query) throws SystemExceptions.DBeException {
        try {
            List ls = new ArrayList();
            Object obj;
            for (Iterator iterator = IDB.BuscarLista(query.toString(), tipo.newInstance()).iterator(); iterator.hasNext(); ls.add(obj)) {
                obj = iterator.next();
            }
            return ls;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SystemExceptions.DBeException("Erro: " + ex);
        }
    }

    public String CreateTable() throws SystemExceptions.DBeException {
        String sql = "SHOW CREATE TABLE SaoJoaoEncomendas." + nomeTabela;
        return IDB.CreateTable(sql);
    }

    private String CreateUpdate(String tabela, String idName, int idVal) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ");
        sql.append(tabela);
        sql.append(" SET visivel='A' WHERE ");
        sql.append(idName);
        sql.append("=");
        sql.append(idVal);
        sql.append(";");
        return sql.toString();
    }

    // Cria insert para SQLite a partir do MySQL
    public ParesIdSql CreateInsert(int mod, int idAparelho, int id, int qtd) throws SystemExceptions.DBeException {
        ParesIdSql ret = new ParesIdSql();

        StringBuilder sqlUpdate = new StringBuilder();
        try {
            StringBuilder sqlInsert = new StringBuilder();
            sqlInsert.append("INSERT INTO ");
            sqlInsert.append(getNomeTabela());
            sqlInsert.append("(");
            sqlInsert.append(getNomeCampos());
            sqlInsert.append(") VALUES ");

            StringBuilder query = new StringBuilder();
            switch (mod) {
                case 1:
                    query.append("select ");
                    query.append(getNomeCampos());
                    query.append(" from ");
                    query.append(getNomeTabela());
                    query.append(" where ");
                    query.append(getNomeId());
                    query.append(" >= ");
                    query.append(id);
                    query.append(" LIMIT ");
                    query.append(qtd);
                    break;
                case 2:
                    query.append("select ");
                    query.append(getNomeCampos());
                    query.append(" from ");
                    query.append(getNomeTabela());
                    query.append(" where ");
                    query.append(getNomeId());
                    query.append(" >= ");
                    query.append(id);
                    query.append(" AND (idAparelho <> ");
                    query.append(idAparelho);
                    query.append(" OR idANT > 0) LIMIT ");
                    query.append(qtd);
                    break;
                case 3:
                    query.append("select ");
                    query.append(getNomeCampos());
                    query.append(" from ");
                    query.append(getNomeTabela());
                    query.append(" where ");
                    query.append(getNomeId());
                    query.append(" >= ");
                    query.append(id);
                    query.append(" and dhEmi > NOW() - INTERVAL 30 day limit ");
                    query.append(qtd);
                    break;
                case 4:
                    query.append("select ");
                    query.append(getNomeCampos());
                    query.append(" from ");
                    query.append(getNomeTabela());
                    query.append(" where ");
                    query.append(getNomeId());
                    query.append(" >= ");
                    query.append(id);
                    query.append(" and idAparelho <> ");
                    query.append(idAparelho);
                    query.append(" and dhEmi > NOW() - INTERVAL 30 day limit ");
                    query.append(qtd);
                    break;
                case 5:
                    query.append("select ");
                    query.append(getNomeCampos());
                    query.append(" from ");
                    query.append(getNomeTabela());
                    query.append(" where ");
                    query.append(getNomeId());
                    query.append(" >= ");
                    query.append(id);
                    query.append(" and idAparelho <> ");
                    query.append(idAparelho);
                    query.append(" and dhRegistro > NOW() - INTERVAL 30 day limit ");
                    query.append(qtd);
                    break;
                default:
                    query.append("select ");
                    query.append(getNomeCampos());
                    query.append(" from ");
                    query.append(getNomeTabela());
                    query.append(" where ");
                    query.append(getNomeId());
                    query.append(" >= ");
                    query.append(id);
                    query.append(" and dhRegistro > NOW() - INTERVAL 30 day limit ");
                    query.append(qtd);
                    break;
            }

            int a = 0;
            Object obj;
            for (Iterator iterator = IDB.BuscarLista(query.toString(), tipo.newInstance()).iterator(); iterator.hasNext();) {
                obj = iterator.next();
                int i = 0;

                for (Field field : obj.getClass().getDeclaredFields()) {
                    if (field.getName().equalsIgnoreCase(nomeId)) {
                        ret.setUltimoId(Integer.parseInt(IDB.preparaRetorno(obj, field)));
                    }
                    if (i == 0) {
                        sqlInsert.append("(");
                        sqlInsert.append(IDB.preparaRetorno(obj, field));
                    } else {
                        sqlInsert.append(", ");
                        sqlInsert.append(IDB.preparaRetorno(obj, field));
                    }
                    i++;
                }
                sqlInsert.append(")");
                a++;
            }

            if (a > 0) {
                ret.setSQL(sqlInsert.toString().replace(")(", "), ("));
            } else {
                ret.setSQL("");
            }

            return ret;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException  ex) {
            ex.printStackTrace();
            throw new SystemExceptions.DBeException(ex.getMessage());
        }
    }

    /**
     * @return the nomeTabela
     */
    public String getNomeTabela() {
        return nomeTabela;
    }

    /**
     * @return the nomeId
     */
    public String getNomeId() {
        return nomeId;
    }

    /**
     * @return the nomeCampos
     */
    public String getNomeCampos() {
        return nomeCampos;
    }
}
