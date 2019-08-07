/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Certificados;

import Apoio.GzipUtils;
import Apoio.SystemExceptions;
import DB_FRETES.DB_DAO;
import Models.FRETES_Certificado;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 *
 * @author Maiquel
 */
public final class OBJKeyStoreA1 {

    private static OBJKeyStoreA1 OBJKS = null;
    private static KeyStore ks = null;
    private static String senha = null;
    GzipUtils GZU = new GzipUtils();

    private OBJKeyStoreA1() throws SystemExceptions.DBeException, SystemExceptions.CertificadoException {
        try {
            //=======================================================================
            /*
            * Informações do Certificado Digital.
            *
            * configurando o certificado do A1
            */
            
            FRETES_Certificado OBJ_CERT = DB_DAO.getInstance().getCertificado().BuscarUltimo(-1);
            senha = OBJ_CERT.getSenha();
            
            //InputStream in = new FileInputStream(GZU.Byte_to_File(OBJ_CERT.getCertificado(), "cert.pfx"));
            
            InputStream in = GzipUtils.Byte_to_InputStream(OBJ_CERT.getCertificado());
            
            ks = KeyStore.getInstance("pkcs12");
            
            //ks.load(new FileInputStream(CONST.certificadoA1), senha.toCharArray());
            ks.load(in, senha.toCharArray());
            //=======================================================================
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException ex) {
            throw new SystemExceptions.CertificadoException(ex.getMessage());
        }

    }

    public static OBJKeyStoreA1 getInstance() throws SystemExceptions.DBeException, SystemExceptions.CertificadoException{
        if (OBJKS == null) {
            OBJKS = new OBJKeyStoreA1();
        }
        return OBJKS;
    }

    public KeyStore getKeyStore() {
        return ks;
    }

    public String getSenha() {
        return senha;
    }

}
