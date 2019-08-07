/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBs;

import Apoio.SystemExceptions;
import java.math.BigInteger;

/**
 *
 * @author mblui
 * @param <T>
 */
public interface DAO <T> {
    public T BuscarUltimo(int idAparelho)throws SystemExceptions.DBeException;
    public T BuscarId(int id) throws SystemExceptions.DBeException;
}
