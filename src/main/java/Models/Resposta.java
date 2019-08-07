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
public class Resposta {

    @SerializedName("dados")
    @Expose
    private Object object;
    @SerializedName("cStat")
    @Expose
    private int cStat;
    @SerializedName("xStat")
    @Expose
    private String xStat;

    public Object getObject() {
        return object;
    }
    
    public <T> T getObject(Class<T> classReference) {
        return (T) object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getcStat() {
        return cStat;
    }

    public void setcStat(int cStat) {
        this.cStat = cStat;
    }

    public String getxStat() {
        return xStat;
    }

    public void setxStat(String xStat) {
        this.xStat = xStat;
    }
}
