/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mblui
 */

@XmlRootElement(name="Certificado")
@XmlAccessorType(XmlAccessType.FIELD)
public class Certificado {
    @XmlElement
    private String idCertificado;
    @XmlElement
    private String serial;
    @XmlElement
    private String senha;
    @XmlElement
    private String validade;
    @XmlElement
    private String certificado;
    @XmlElement
    private String fingerprint;
    @XmlElement
    private String dhRegistro;
    @XmlElement
    private String idUsuario;
    @XmlElement
    private String idANT;
    @XmlElement
    private String visivel;

    public String getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(String idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getDhRegistro() {
        return dhRegistro;
    }

    public void setDhRegistro(String dhRegistro) {
        this.dhRegistro = dhRegistro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdANT() {
        return idANT;
    }

    public void setIdANT(String idANT) {
        this.idANT = idANT;
    }

    public String getVisivel() {
        return visivel;
    }

    public void setVisivel(String visivel) {
        this.visivel = visivel;
    }

    /**
     * @return the fingerprint
     */
    public String getFingerprint() {
        return fingerprint;
    }

    /**
     * @param fingerprint the fingerprint to set
     */
    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
