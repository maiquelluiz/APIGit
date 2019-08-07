/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mblui
 */
@XmlRootElement(name="Aparelho")
@XmlAccessorType(XmlAccessType.FIELD)
public class FRETES_Aparelho {

    
    @XmlElement
    private int idAparelhos;
    @XmlElement
    private int responsavel;
    @XmlElement
    private String imei;
    @XmlElement
    private String numero;
    @XmlElement
    private String simCard;
    @XmlElement
    private String modelo;
    @XmlElement
    private String operadora;
    @XmlElement
    private Timestamp dhRegistro;
    @XmlElement
    private int idUsuario;
    @XmlElement
    private int idAparelho;
    @XmlElement
    private int idANT;
    @XmlElement
    private String visivel;

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idAparelhos;
        hash = 97 * hash + this.responsavel;
        hash = 97 * hash + Objects.hashCode(this.imei);
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.simCard);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        hash = 97 * hash + Objects.hashCode(this.operadora);
        hash = 97 * hash + Objects.hashCode(this.dhRegistro);
        hash = 97 * hash + this.idUsuario;
        hash = 97 * hash + this.idAparelho;
        hash = 97 * hash + this.idANT;
        hash = 97 * hash + Objects.hashCode(this.visivel);
        return hash;
    }

    /**
     * @return the idAparelho
     */
    public int getIdAparelho() {
        return idAparelho;
    }

    /**
     * @param idAparelho the idAparelho to set
     */
    public void setIdAparelho(int idAparelho) {
        this.idAparelho = idAparelho;
    }
    
    /**
     * @return the responsavel
     */
    public int getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(int responsavel) {
        this.responsavel = responsavel;
    }
    
    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei the imei to set
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the simCard
     */
    public String getSimCard() {
        return simCard;
    }

    /**
     * @param simCard the simCard to set
     */
    public void setSimCard(String simCard) {
        this.simCard = simCard;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the operadora
     */
    public String getOperadora() {
        return operadora;
    }

    /**
     * @param operadora the operadora to set
     */
    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    /**
     * @return the dhRegistro
     */
    public Timestamp getDhRegistro() {
        return dhRegistro;
    }

    /**
     * @param dhRegistro the dhRegistro to set
     */
    public void setDhRegistro(Timestamp dhRegistro) {
        this.dhRegistro = dhRegistro;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idANT
     */
    public int getIdANT() {
        return idANT;
    }

    /**
     * @param idANT the idANT to set
     */
    public void setIdANT(int idANT) {
        this.idANT = idANT;
    }

    /**
     * @return the visivel
     */
    public String getVisivel() {
        return visivel;
    }

    /**
     * @param visivel the visivel to set
     */
    public void setVisivel(String visivel) {
        this.visivel = visivel;
    }

    /**
     * @return the idAparelhos
     */
    public int getIdAparelhos() {
        return idAparelhos;
    }

    /**
     * @param idAparelhos the idAparelhos to set
     */
    public void setIdAparelhos(int idAparelhos) {
        this.idAparelhos = idAparelhos;
    }

    
    

    

}
