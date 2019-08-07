/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author mblui
 */
public class ParesId {
    
    @SerializedName("idMysql")
    @Expose
    private int idMysql;
    
    @SerializedName("idSQLite")
    @Expose
    private int idSQLite;

    /**
     * @return the idMysql
     */
    public int getIdMysql() {
        return idMysql;
    }

    /**
     * @param idMysql the idMysql to set
     */
    public void setIdMysql(int idMysql) {
        this.idMysql = idMysql;
    }

    /**
     * @return the idSQLite
     */
    public int getIdSQLite() {
        return idSQLite;
    }

    /**
     * @param idSQLite the idSQLite to set
     */
    public void setIdSQLite(int idSQLite) {
        this.idSQLite = idSQLite;
    }

}
