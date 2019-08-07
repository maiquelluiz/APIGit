/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DBs.MetodosParaObjetos;

/**
 *
 * @author mblui
 */
public class Ultimos {

    private int idAparelhos;
    private int idAverbacao;
    private int idCFOP;
    private int idCST;
    private int idCST00;
    private int idCST20;
    private int idCST80;
    private int idCST81;
    private int idCST90;
    private int idCTe;
    private int idCTeAnulacao;
    private int idCTeComplementado;
    private int idCTeSefaz;
    private int idCTeSubstituicao;
    private int idCacerts;
    private int idCasos;
    private int idCertificado;
    private int idCidade;
    private int idCliente;
    private int idClienteEnderecos;
    private int idDocumentoAnterior;
    private int idEmailEnviado;
    private int idEmpresa;
    private int idEntrega;
    private int idEtiqueta;
    private int idEtiquetasCodBarras;
    private int idLeituraEtiqueta;
    private int idEvento;
    private int idFeriado;
    private int idFeriadoDetalhes;
    private int idGaragem;
    private int idItinerario;
    private int idItinerarioItens;
    private int idLote;
    private int idLoteMDFe;
    private int idMDFe;
    private int idMaquina;
    private int idMenus;
    private int idMotorista;
    private int idNFAntiga;
    private int idNFeItens;
    private int idNFeTerceiros;
    private int idNSU;
    private int idNotas;
    private int idOcorrencia;
    private int idParametro;
    private int idPedidosColeta;
    private int idPesoValor;
    private int idPesoValorSubRota;
    private int idPesoValorSubRotaCidade;
    private int idPosicao;
    private int idProtocolo;
    private int idProtocoloRedespacho;
    private int idProxyLog;
    private int idProxys;
    private int idRedespacho;
    private int idRetConsReci;
    private int idRotas;
    private int idSeguros;
    private int idSimulacaoFretes;
    private int idSubRotas;
    private int idSubRotasCidade;
    private int idTempoEmissao;
    private int idUsuarios;
    private int idVeiculo;
    private int idViagem;
    private int idVolumes;
    private int idWSSefaz;
    private int idXMLCTe;
    private int idXMLRetConsReciCTe;
    private int idXMLenviMDFe;
    private int idXMLs;
    private int idInfCTe;
    private int idInfMotorista;
    private int idInfMunCarrega;
    private int idInfMunDescarga;
    private int idInfPercurso;
    private int idInfVeiculo;
    private int idLinkMDFeInfCTe;
    private int idProtMDFe;
    private int idRetEvento;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.getIdAparelhos();
        hash = 89 * hash + this.getIdAverbacao();
        hash = 89 * hash + this.getIdCFOP();
        hash = 89 * hash + this.getIdCST();
        hash = 89 * hash + this.getIdCST00();
        hash = 89 * hash + this.getIdCST20();
        hash = 89 * hash + this.getIdCST80();
        hash = 89 * hash + this.getIdCST81();
        hash = 89 * hash + this.getIdCST90();
        hash = 89 * hash + this.getIdCTe();
        hash = 89 * hash + this.getIdCTeAnulacao();
        hash = 89 * hash + this.getIdCTeComplementado();
        hash = 89 * hash + this.getIdCTeSefaz();
        hash = 89 * hash + this.getIdCTeSubstituicao();
        hash = 89 * hash + this.getIdCacerts();
        hash = 89 * hash + this.getIdCasos();
        hash = 89 * hash + this.getIdCertificado();
        hash = 89 * hash + this.getIdCidade();
        hash = 89 * hash + this.getIdCliente();
        hash = 89 * hash + this.getIdClienteEnderecos();
        hash = 89 * hash + this.getIdDocumentoAnterior();
        hash = 89 * hash + this.getIdEmailEnviado();
        hash = 89 * hash + this.getIdEmpresa();
        hash = 89 * hash + this.getIdEntrega();
        hash = 89 * hash + this.getIdEtiqueta();
        hash = 89 * hash + this.getIdEtiquetasCodBarras();
        hash = 89 * hash + this.getIdLeituraEtiqueta();
        hash = 89 * hash + this.getIdEvento();
        hash = 89 * hash + this.getIdFeriado();
        hash = 89 * hash + this.getIdFeriadoDetalhes();
        hash = 89 * hash + this.getIdGaragem();
        hash = 89 * hash + this.getIdItinerario();
        hash = 89 * hash + this.getIdItinerarioItens();
        hash = 89 * hash + this.getIdLote();
        hash = 89 * hash + this.getIdLoteMDFe();
        hash = 89 * hash + this.getIdMDFe();
        hash = 89 * hash + this.getIdMaquina();
        hash = 89 * hash + this.getIdMenus();
        hash = 89 * hash + this.getIdMotorista();
        hash = 89 * hash + this.getIdNFAntiga();
        hash = 89 * hash + this.getIdNFeItens();
        hash = 89 * hash + this.getIdNFeTerceiros();
        hash = 89 * hash + this.getIdNSU();
        hash = 89 * hash + this.getIdNotas();
        hash = 89 * hash + this.getIdOcorrencia();
        hash = 89 * hash + this.getIdParametro();
        hash = 89 * hash + this.getIdPedidosColeta();
        hash = 89 * hash + this.getIdPesoValor();
        hash = 89 * hash + this.getIdPesoValorSubRota();
        hash = 89 * hash + this.getIdPesoValorSubRotaCidade();
        hash = 89 * hash + this.getIdPosicao();
        hash = 89 * hash + this.getIdProtocolo();
        hash = 89 * hash + this.getIdProtocoloRedespacho();
        hash = 89 * hash + this.getIdProxyLog();
        hash = 89 * hash + this.getIdProxys();
        hash = 89 * hash + this.getIdRedespacho();
        hash = 89 * hash + this.getIdRetConsReci();
        hash = 89 * hash + this.getIdRotas();
        hash = 89 * hash + this.getIdSeguros();
        hash = 89 * hash + this.getIdSimulacaoFretes();
        hash = 89 * hash + this.getIdSubRotas();
        hash = 89 * hash + this.getIdSubRotasCidade();
        hash = 89 * hash + this.getIdTempoEmissao();
        hash = 89 * hash + this.getIdUsuarios();
        hash = 89 * hash + this.getIdVeiculo();
        hash = 89 * hash + this.getIdViagem();
        hash = 89 * hash + this.getIdVolumes();
        hash = 89 * hash + this.getIdWSSefaz();
        hash = 89 * hash + this.getIdXMLCTe();
        hash = 89 * hash + this.getIdXMLRetConsReciCTe();
        hash = 89 * hash + this.getIdXMLenviMDFe();
        hash = 89 * hash + this.getIdXMLs();
        hash = 89 * hash + this.getIdInfCTe();
        hash = 89 * hash + this.getIdInfMotorista();
        hash = 89 * hash + this.getIdInfMunCarrega();
        hash = 89 * hash + this.getIdInfMunDescarga();
        hash = 89 * hash + this.getIdInfPercurso();
        hash = 89 * hash + this.getIdInfVeiculo();
        hash = 89 * hash + this.getIdLinkMDFeInfCTe();
        hash = 89 * hash + this.getIdProtMDFe();
        hash = 89 * hash + this.getIdRetEvento();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ultimos other = (Ultimos) obj;
        if (this.getIdAparelhos() != other.getIdAparelhos()) {
            return false;
        }
        if (this.getIdAverbacao() != other.getIdAverbacao()) {
            return false;
        }
        if (this.getIdCFOP() != other.getIdCFOP()) {
            return false;
        }
        if (this.getIdCST() != other.getIdCST()) {
            return false;
        }
        if (this.getIdCST00() != other.getIdCST00()) {
            return false;
        }
        if (this.getIdCST20() != other.getIdCST20()) {
            return false;
        }
        if (this.getIdCST80() != other.getIdCST80()) {
            return false;
        }
        if (this.getIdCST81() != other.getIdCST81()) {
            return false;
        }
        if (this.getIdCST90() != other.getIdCST90()) {
            return false;
        }
        if (this.getIdCTe() != other.getIdCTe()) {
            return false;
        }
        if (this.getIdCTeAnulacao() != other.getIdCTeAnulacao()) {
            return false;
        }
        if (this.getIdCTeComplementado() != other.getIdCTeComplementado()) {
            return false;
        }
        if (this.getIdCTeSefaz() != other.getIdCTeSefaz()) {
            return false;
        }
        if (this.getIdCTeSubstituicao() != other.getIdCTeSubstituicao()) {
            return false;
        }
        if (this.getIdCacerts() != other.getIdCacerts()) {
            return false;
        }
        if (this.getIdCasos() != other.getIdCasos()) {
            return false;
        }
        if (this.getIdCertificado() != other.getIdCertificado()) {
            return false;
        }
        if (this.getIdCidade() != other.getIdCidade()) {
            return false;
        }
        if (this.getIdCliente() != other.getIdCliente()) {
            return false;
        }
        if (this.getIdClienteEnderecos() != other.getIdClienteEnderecos()) {
            return false;
        }
        if (this.getIdDocumentoAnterior() != other.getIdDocumentoAnterior()) {
            return false;
        }
        if (this.getIdEmailEnviado() != other.getIdEmailEnviado()) {
            return false;
        }
        if (this.getIdEmpresa() != other.getIdEmpresa()) {
            return false;
        }
        if (this.getIdEntrega() != other.getIdEntrega()) {
            return false;
        }
        if (this.getIdEtiqueta() != other.getIdEtiqueta()) {
            return false;
        }
        if (this.getIdEtiquetasCodBarras() != other.getIdEtiquetasCodBarras()) {
            return false;
        }
        if (this.getIdLeituraEtiqueta() != other.getIdLeituraEtiqueta()) {
            return false;
        }
        if (this.getIdEvento() != other.getIdEvento()) {
            return false;
        }
        if (this.getIdFeriado() != other.getIdFeriado()) {
            return false;
        }
        if (this.getIdFeriadoDetalhes() != other.getIdFeriadoDetalhes()) {
            return false;
        }
        if (this.getIdGaragem() != other.getIdGaragem()) {
            return false;
        }
        if (this.getIdItinerario() != other.getIdItinerario()) {
            return false;
        }
        if (this.getIdItinerarioItens() != other.getIdItinerarioItens()) {
            return false;
        }
        if (this.getIdLote() != other.getIdLote()) {
            return false;
        }
        if (this.getIdLoteMDFe() != other.getIdLoteMDFe()) {
            return false;
        }
        if (this.getIdMDFe() != other.getIdMDFe()) {
            return false;
        }
        if (this.getIdMaquina() != other.getIdMaquina()) {
            return false;
        }
        if (this.getIdMenus() != other.getIdMenus()) {
            return false;
        }
        if (this.getIdMotorista() != other.getIdMotorista()) {
            return false;
        }
        if (this.getIdNFAntiga() != other.getIdNFAntiga()) {
            return false;
        }
        if (this.getIdNFeItens() != other.getIdNFeItens()) {
            return false;
        }
        if (this.getIdNFeTerceiros() != other.getIdNFeTerceiros()) {
            return false;
        }
        if (this.getIdNSU() != other.getIdNSU()) {
            return false;
        }
        if (this.getIdNotas() != other.getIdNotas()) {
            return false;
        }
        if (this.getIdOcorrencia() != other.getIdOcorrencia()) {
            return false;
        }
        if (this.getIdParametro() != other.getIdParametro()) {
            return false;
        }
        if (this.getIdPedidosColeta() != other.getIdPedidosColeta()) {
            return false;
        }
        if (this.getIdPesoValor() != other.getIdPesoValor()) {
            return false;
        }
        if (this.getIdPesoValorSubRota() != other.getIdPesoValorSubRota()) {
            return false;
        }
        if (this.getIdPesoValorSubRotaCidade() != other.getIdPesoValorSubRotaCidade()) {
            return false;
        }
        if (this.getIdPosicao() != other.getIdPosicao()) {
            return false;
        }
        if (this.getIdProtocolo() != other.getIdProtocolo()) {
            return false;
        }
        if (this.getIdProtocoloRedespacho() != other.getIdProtocoloRedespacho()) {
            return false;
        }
        if (this.getIdProxyLog() != other.getIdProxyLog()) {
            return false;
        }
        if (this.getIdProxys() != other.getIdProxys()) {
            return false;
        }
        if (this.getIdRedespacho() != other.getIdRedespacho()) {
            return false;
        }
        if (this.getIdRetConsReci() != other.getIdRetConsReci()) {
            return false;
        }
        if (this.getIdRotas() != other.getIdRotas()) {
            return false;
        }
        if (this.getIdSeguros() != other.getIdSeguros()) {
            return false;
        }
        if (this.getIdSimulacaoFretes() != other.getIdSimulacaoFretes()) {
            return false;
        }
        if (this.getIdSubRotas() != other.getIdSubRotas()) {
            return false;
        }
        if (this.getIdSubRotasCidade() != other.getIdSubRotasCidade()) {
            return false;
        }
        if (this.getIdTempoEmissao() != other.getIdTempoEmissao()) {
            return false;
        }
        if (this.getIdUsuarios() != other.getIdUsuarios()) {
            return false;
        }
        if (this.getIdVeiculo() != other.getIdVeiculo()) {
            return false;
        }
        if (this.getIdViagem() != other.getIdViagem()) {
            return false;
        }
        if (this.getIdVolumes() != other.getIdVolumes()) {
            return false;
        }
        if (this.getIdWSSefaz() != other.getIdWSSefaz()) {
            return false;
        }
        if (this.getIdXMLCTe() != other.getIdXMLCTe()) {
            return false;
        }
        if (this.getIdXMLRetConsReciCTe() != other.getIdXMLRetConsReciCTe()) {
            return false;
        }
        if (this.getIdXMLenviMDFe() != other.getIdXMLenviMDFe()) {
            return false;
        }
        if (this.getIdXMLs() != other.getIdXMLs()) {
            return false;
        }
        if (this.getIdInfCTe() != other.getIdInfCTe()) {
            return false;
        }
        if (this.getIdInfMotorista() != other.getIdInfMotorista()) {
            return false;
        }
        if (this.getIdInfMunCarrega() != other.getIdInfMunCarrega()) {
            return false;
        }
        if (this.getIdInfMunDescarga() != other.getIdInfMunDescarga()) {
            return false;
        }
        if (this.getIdInfPercurso() != other.getIdInfPercurso()) {
            return false;
        }
        if (this.getIdInfVeiculo() != other.getIdInfVeiculo()) {
            return false;
        }
        if (this.getIdLinkMDFeInfCTe() != other.getIdLinkMDFeInfCTe()) {
            return false;
        }
        if (this.getIdProtMDFe() != other.getIdProtMDFe()) {
            return false;
        }
        if (this.getIdRetEvento() != other.getIdRetEvento()) {
            return false;
        }
        return true;
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

    /**
     * @return the idAverbacao
     */
    public int getIdAverbacao() {
        return idAverbacao;
    }

    /**
     * @param idAverbacao the idAverbacao to set
     */
    public void setIdAverbacao(int idAverbacao) {
        this.idAverbacao = idAverbacao;
    }

    /**
     * @return the idCFOP
     */
    public int getIdCFOP() {
        return idCFOP;
    }

    /**
     * @param idCFOP the idCFOP to set
     */
    public void setIdCFOP(int idCFOP) {
        this.idCFOP = idCFOP;
    }

    /**
     * @return the idCST
     */
    public int getIdCST() {
        return idCST;
    }

    /**
     * @param idCST the idCST to set
     */
    public void setIdCST(int idCST) {
        this.idCST = idCST;
    }

    /**
     * @return the idCST00
     */
    public int getIdCST00() {
        return idCST00;
    }

    /**
     * @param idCST00 the idCST00 to set
     */
    public void setIdCST00(int idCST00) {
        this.idCST00 = idCST00;
    }

    /**
     * @return the idCST20
     */
    public int getIdCST20() {
        return idCST20;
    }

    /**
     * @param idCST20 the idCST20 to set
     */
    public void setIdCST20(int idCST20) {
        this.idCST20 = idCST20;
    }

    /**
     * @return the idCST80
     */
    public int getIdCST80() {
        return idCST80;
    }

    /**
     * @param idCST80 the idCST80 to set
     */
    public void setIdCST80(int idCST80) {
        this.idCST80 = idCST80;
    }

    /**
     * @return the idCST81
     */
    public int getIdCST81() {
        return idCST81;
    }

    /**
     * @param idCST81 the idCST81 to set
     */
    public void setIdCST81(int idCST81) {
        this.idCST81 = idCST81;
    }

    /**
     * @return the idCST90
     */
    public int getIdCST90() {
        return idCST90;
    }

    /**
     * @param idCST90 the idCST90 to set
     */
    public void setIdCST90(int idCST90) {
        this.idCST90 = idCST90;
    }

    /**
     * @return the idCTe
     */
    public int getIdCTe() {
        return idCTe;
    }

    /**
     * @param idCTe the idCTe to set
     */
    public void setIdCTe(int idCTe) {
        this.idCTe = idCTe;
    }

    /**
     * @return the idCTeAnulacao
     */
    public int getIdCTeAnulacao() {
        return idCTeAnulacao;
    }

    /**
     * @param idCTeAnulacao the idCTeAnulacao to set
     */
    public void setIdCTeAnulacao(int idCTeAnulacao) {
        this.idCTeAnulacao = idCTeAnulacao;
    }

    /**
     * @return the idCTeComplementado
     */
    public int getIdCTeComplementado() {
        return idCTeComplementado;
    }

    /**
     * @param idCTeComplementado the idCTeComplementado to set
     */
    public void setIdCTeComplementado(int idCTeComplementado) {
        this.idCTeComplementado = idCTeComplementado;
    }

    /**
     * @return the idCTeSefaz
     */
    public int getIdCTeSefaz() {
        return idCTeSefaz;
    }

    /**
     * @param idCTeSefaz the idCTeSefaz to set
     */
    public void setIdCTeSefaz(int idCTeSefaz) {
        this.idCTeSefaz = idCTeSefaz;
    }

    /**
     * @return the idCTeSubstituicao
     */
    public int getIdCTeSubstituicao() {
        return idCTeSubstituicao;
    }

    /**
     * @param idCTeSubstituicao the idCTeSubstituicao to set
     */
    public void setIdCTeSubstituicao(int idCTeSubstituicao) {
        this.idCTeSubstituicao = idCTeSubstituicao;
    }

    /**
     * @return the idCacerts
     */
    public int getIdCacerts() {
        return idCacerts;
    }

    /**
     * @param idCacerts the idCacerts to set
     */
    public void setIdCacerts(int idCacerts) {
        this.idCacerts = idCacerts;
    }

    /**
     * @return the idCasos
     */
    public int getIdCasos() {
        return idCasos;
    }

    /**
     * @param idCasos the idCasos to set
     */
    public void setIdCasos(int idCasos) {
        this.idCasos = idCasos;
    }

    /**
     * @return the idCertificado
     */
    public int getIdCertificado() {
        return idCertificado;
    }

    /**
     * @param idCertificado the idCertificado to set
     */
    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
    }

    /**
     * @return the idCidade
     */
    public int getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idClienteEnderecos
     */
    public int getIdClienteEnderecos() {
        return idClienteEnderecos;
    }

    /**
     * @param idClienteEnderecos the idClienteEnderecos to set
     */
    public void setIdClienteEnderecos(int idClienteEnderecos) {
        this.idClienteEnderecos = idClienteEnderecos;
    }

    /**
     * @return the idDocumentoAnterior
     */
    public int getIdDocumentoAnterior() {
        return idDocumentoAnterior;
    }

    /**
     * @param idDocumentoAnterior the idDocumentoAnterior to set
     */
    public void setIdDocumentoAnterior(int idDocumentoAnterior) {
        this.idDocumentoAnterior = idDocumentoAnterior;
    }

    /**
     * @return the idEmailEnviado
     */
    public int getIdEmailEnviado() {
        return idEmailEnviado;
    }

    /**
     * @param idEmailEnviado the idEmailEnviado to set
     */
    public void setIdEmailEnviado(int idEmailEnviado) {
        this.idEmailEnviado = idEmailEnviado;
    }

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the idEntrega
     */
    public int getIdEntrega() {
        return idEntrega;
    }

    /**
     * @param idEntrega the idEntrega to set
     */
    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    /**
     * @return the idEtiqueta
     */
    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    /**
     * @param idEtiqueta the idEtiqueta to set
     */
    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    /**
     * @return the idEtiquetasCodBarras
     */
    public int getIdEtiquetasCodBarras() {
        return idEtiquetasCodBarras;
    }

    /**
     * @param idEtiquetasCodBarras the idEtiquetasCodBarras to set
     */
    public void setIdEtiquetasCodBarras(int idEtiquetasCodBarras) {
        this.idEtiquetasCodBarras = idEtiquetasCodBarras;
    }

    /**
     * @return the idLeituraEtiqueta
     */
    public int getIdLeituraEtiqueta() {
        return idLeituraEtiqueta;
    }

    /**
     * @param idLeituraEtiqueta the idLeituraEtiqueta to set
     */
    public void setIdLeituraEtiqueta(int idLeituraEtiqueta) {
        this.idLeituraEtiqueta = idLeituraEtiqueta;
    }

    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the idFeriado
     */
    public int getIdFeriado() {
        return idFeriado;
    }

    /**
     * @param idFeriado the idFeriado to set
     */
    public void setIdFeriado(int idFeriado) {
        this.idFeriado = idFeriado;
    }

    /**
     * @return the idFeriadoDetalhes
     */
    public int getIdFeriadoDetalhes() {
        return idFeriadoDetalhes;
    }

    /**
     * @param idFeriadoDetalhes the idFeriadoDetalhes to set
     */
    public void setIdFeriadoDetalhes(int idFeriadoDetalhes) {
        this.idFeriadoDetalhes = idFeriadoDetalhes;
    }

    /**
     * @return the idGaragem
     */
    public int getIdGaragem() {
        return idGaragem;
    }

    /**
     * @param idGaragem the idGaragem to set
     */
    public void setIdGaragem(int idGaragem) {
        this.idGaragem = idGaragem;
    }

    /**
     * @return the idItinerario
     */
    public int getIdItinerario() {
        return idItinerario;
    }

    /**
     * @param idItinerario the idItinerario to set
     */
    public void setIdItinerario(int idItinerario) {
        this.idItinerario = idItinerario;
    }

    /**
     * @return the idItinerarioItens
     */
    public int getIdItinerarioItens() {
        return idItinerarioItens;
    }

    /**
     * @param idItinerarioItens the idItinerarioItens to set
     */
    public void setIdItinerarioItens(int idItinerarioItens) {
        this.idItinerarioItens = idItinerarioItens;
    }

    /**
     * @return the idLote
     */
    public int getIdLote() {
        return idLote;
    }

    /**
     * @param idLote the idLote to set
     */
    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    /**
     * @return the idLoteMDFe
     */
    public int getIdLoteMDFe() {
        return idLoteMDFe;
    }

    /**
     * @param idLoteMDFe the idLoteMDFe to set
     */
    public void setIdLoteMDFe(int idLoteMDFe) {
        this.idLoteMDFe = idLoteMDFe;
    }

    /**
     * @return the idMDFe
     */
    public int getIdMDFe() {
        return idMDFe;
    }

    /**
     * @param idMDFe the idMDFe to set
     */
    public void setIdMDFe(int idMDFe) {
        this.idMDFe = idMDFe;
    }

    /**
     * @return the idMaquina
     */
    public int getIdMaquina() {
        return idMaquina;
    }

    /**
     * @param idMaquina the idMaquina to set
     */
    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    /**
     * @return the idMenus
     */
    public int getIdMenus() {
        return idMenus;
    }

    /**
     * @param idMenus the idMenus to set
     */
    public void setIdMenus(int idMenus) {
        this.idMenus = idMenus;
    }

    /**
     * @return the idMotorista
     */
    public int getIdMotorista() {
        return idMotorista;
    }

    /**
     * @param idMotorista the idMotorista to set
     */
    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    /**
     * @return the idNFAntiga
     */
    public int getIdNFAntiga() {
        return idNFAntiga;
    }

    /**
     * @param idNFAntiga the idNFAntiga to set
     */
    public void setIdNFAntiga(int idNFAntiga) {
        this.idNFAntiga = idNFAntiga;
    }

    /**
     * @return the idNFeItens
     */
    public int getIdNFeItens() {
        return idNFeItens;
    }

    /**
     * @param idNFeItens the idNFeItens to set
     */
    public void setIdNFeItens(int idNFeItens) {
        this.idNFeItens = idNFeItens;
    }

    /**
     * @return the idNFeTerceiros
     */
    public int getIdNFeTerceiros() {
        return idNFeTerceiros;
    }

    /**
     * @param idNFeTerceiros the idNFeTerceiros to set
     */
    public void setIdNFeTerceiros(int idNFeTerceiros) {
        this.idNFeTerceiros = idNFeTerceiros;
    }

    /**
     * @return the idNSU
     */
    public int getIdNSU() {
        return idNSU;
    }

    /**
     * @param idNSU the idNSU to set
     */
    public void setIdNSU(int idNSU) {
        this.idNSU = idNSU;
    }

    /**
     * @return the idNotas
     */
    public int getIdNotas() {
        return idNotas;
    }

    /**
     * @param idNotas the idNotas to set
     */
    public void setIdNotas(int idNotas) {
        this.idNotas = idNotas;
    }

    /**
     * @return the idOcorrencia
     */
    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    /**
     * @param idOcorrencia the idOcorrencia to set
     */
    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    /**
     * @return the idParametro
     */
    public int getIdParametro() {
        return idParametro;
    }

    /**
     * @param idParametro the idParametro to set
     */
    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    /**
     * @return the idPedidosColeta
     */
    public int getIdPedidosColeta() {
        return idPedidosColeta;
    }

    /**
     * @param idPedidosColeta the idPedidosColeta to set
     */
    public void setIdPedidosColeta(int idPedidosColeta) {
        this.idPedidosColeta = idPedidosColeta;
    }

    /**
     * @return the idPesoValor
     */
    public int getIdPesoValor() {
        return idPesoValor;
    }

    /**
     * @param idPesoValor the idPesoValor to set
     */
    public void setIdPesoValor(int idPesoValor) {
        this.idPesoValor = idPesoValor;
    }

    /**
     * @return the idPesoValorSubRota
     */
    public int getIdPesoValorSubRota() {
        return idPesoValorSubRota;
    }

    /**
     * @param idPesoValorSubRota the idPesoValorSubRota to set
     */
    public void setIdPesoValorSubRota(int idPesoValorSubRota) {
        this.idPesoValorSubRota = idPesoValorSubRota;
    }

    /**
     * @return the idPesoValorSubRotaCidade
     */
    public int getIdPesoValorSubRotaCidade() {
        return idPesoValorSubRotaCidade;
    }

    /**
     * @param idPesoValorSubRotaCidade the idPesoValorSubRotaCidade to set
     */
    public void setIdPesoValorSubRotaCidade(int idPesoValorSubRotaCidade) {
        this.idPesoValorSubRotaCidade = idPesoValorSubRotaCidade;
    }

    /**
     * @return the idPosicao
     */
    public int getIdPosicao() {
        return idPosicao;
    }

    /**
     * @param idPosicao the idPosicao to set
     */
    public void setIdPosicao(int idPosicao) {
        this.idPosicao = idPosicao;
    }

    /**
     * @return the idProtocolo
     */
    public int getIdProtocolo() {
        return idProtocolo;
    }

    /**
     * @param idProtocolo the idProtocolo to set
     */
    public void setIdProtocolo(int idProtocolo) {
        this.idProtocolo = idProtocolo;
    }

    /**
     * @return the idProtocoloRedespacho
     */
    public int getIdProtocoloRedespacho() {
        return idProtocoloRedespacho;
    }

    /**
     * @param idProtocoloRedespacho the idProtocoloRedespacho to set
     */
    public void setIdProtocoloRedespacho(int idProtocoloRedespacho) {
        this.idProtocoloRedespacho = idProtocoloRedespacho;
    }

    /**
     * @return the idProxyLog
     */
    public int getIdProxyLog() {
        return idProxyLog;
    }

    /**
     * @param idProxyLog the idProxyLog to set
     */
    public void setIdProxyLog(int idProxyLog) {
        this.idProxyLog = idProxyLog;
    }

    /**
     * @return the idProxys
     */
    public int getIdProxys() {
        return idProxys;
    }

    /**
     * @param idProxys the idProxys to set
     */
    public void setIdProxys(int idProxys) {
        this.idProxys = idProxys;
    }

    /**
     * @return the idRedespacho
     */
    public int getIdRedespacho() {
        return idRedespacho;
    }

    /**
     * @param idRedespacho the idRedespacho to set
     */
    public void setIdRedespacho(int idRedespacho) {
        this.idRedespacho = idRedespacho;
    }

    /**
     * @return the idRetConsReci
     */
    public int getIdRetConsReci() {
        return idRetConsReci;
    }

    /**
     * @param idRetConsReci the idRetConsReci to set
     */
    public void setIdRetConsReci(int idRetConsReci) {
        this.idRetConsReci = idRetConsReci;
    }

    /**
     * @return the idRotas
     */
    public int getIdRotas() {
        return idRotas;
    }

    /**
     * @param idRotas the idRotas to set
     */
    public void setIdRotas(int idRotas) {
        this.idRotas = idRotas;
    }

    /**
     * @return the idSeguros
     */
    public int getIdSeguros() {
        return idSeguros;
    }

    /**
     * @param idSeguros the idSeguros to set
     */
    public void setIdSeguros(int idSeguros) {
        this.idSeguros = idSeguros;
    }

    /**
     * @return the idSimulacaoFretes
     */
    public int getIdSimulacaoFretes() {
        return idSimulacaoFretes;
    }

    /**
     * @param idSimulacaoFretes the idSimulacaoFretes to set
     */
    public void setIdSimulacaoFretes(int idSimulacaoFretes) {
        this.idSimulacaoFretes = idSimulacaoFretes;
    }

    /**
     * @return the idSubRotas
     */
    public int getIdSubRotas() {
        return idSubRotas;
    }

    /**
     * @param idSubRotas the idSubRotas to set
     */
    public void setIdSubRotas(int idSubRotas) {
        this.idSubRotas = idSubRotas;
    }

    /**
     * @return the idSubRotasCidade
     */
    public int getIdSubRotasCidade() {
        return idSubRotasCidade;
    }

    /**
     * @param idSubRotasCidade the idSubRotasCidade to set
     */
    public void setIdSubRotasCidade(int idSubRotasCidade) {
        this.idSubRotasCidade = idSubRotasCidade;
    }

    /**
     * @return the idTempoEmissao
     */
    public int getIdTempoEmissao() {
        return idTempoEmissao;
    }

    /**
     * @param idTempoEmissao the idTempoEmissao to set
     */
    public void setIdTempoEmissao(int idTempoEmissao) {
        this.idTempoEmissao = idTempoEmissao;
    }

    /**
     * @return the idUsuarios
     */
    public int getIdUsuarios() {
        return idUsuarios;
    }

    /**
     * @param idUsuarios the idUsuarios to set
     */
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    /**
     * @return the idVeiculo
     */
    public int getIdVeiculo() {
        return idVeiculo;
    }

    /**
     * @param idVeiculo the idVeiculo to set
     */
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    /**
     * @return the idViagem
     */
    public int getIdViagem() {
        return idViagem;
    }

    /**
     * @param idViagem the idViagem to set
     */
    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    /**
     * @return the idVolumes
     */
    public int getIdVolumes() {
        return idVolumes;
    }

    /**
     * @param idVolumes the idVolumes to set
     */
    public void setIdVolumes(int idVolumes) {
        this.idVolumes = idVolumes;
    }

    /**
     * @return the idWSSefaz
     */
    public int getIdWSSefaz() {
        return idWSSefaz;
    }

    /**
     * @param idWSSefaz the idWSSefaz to set
     */
    public void setIdWSSefaz(int idWSSefaz) {
        this.idWSSefaz = idWSSefaz;
    }

    /**
     * @return the idXMLCTe
     */
    public int getIdXMLCTe() {
        return idXMLCTe;
    }

    /**
     * @param idXMLCTe the idXMLCTe to set
     */
    public void setIdXMLCTe(int idXMLCTe) {
        this.idXMLCTe = idXMLCTe;
    }

    /**
     * @return the idXMLRetConsReciCTe
     */
    public int getIdXMLRetConsReciCTe() {
        return idXMLRetConsReciCTe;
    }

    /**
     * @param idXMLRetConsReciCTe the idXMLRetConsReciCTe to set
     */
    public void setIdXMLRetConsReciCTe(int idXMLRetConsReciCTe) {
        this.idXMLRetConsReciCTe = idXMLRetConsReciCTe;
    }

    /**
     * @return the idXMLenviMDFe
     */
    public int getIdXMLenviMDFe() {
        return idXMLenviMDFe;
    }

    /**
     * @param idXMLenviMDFe the idXMLenviMDFe to set
     */
    public void setIdXMLenviMDFe(int idXMLenviMDFe) {
        this.idXMLenviMDFe = idXMLenviMDFe;
    }

    /**
     * @return the idXMLs
     */
    public int getIdXMLs() {
        return idXMLs;
    }

    /**
     * @param idXMLs the idXMLs to set
     */
    public void setIdXMLs(int idXMLs) {
        this.idXMLs = idXMLs;
    }

    /**
     * @return the idInfCTe
     */
    public int getIdInfCTe() {
        return idInfCTe;
    }

    /**
     * @param idInfCTe the idInfCTe to set
     */
    public void setIdInfCTe(int idInfCTe) {
        this.idInfCTe = idInfCTe;
    }

    /**
     * @return the idInfMotorista
     */
    public int getIdInfMotorista() {
        return idInfMotorista;
    }

    /**
     * @param idInfMotorista the idInfMotorista to set
     */
    public void setIdInfMotorista(int idInfMotorista) {
        this.idInfMotorista = idInfMotorista;
    }

    /**
     * @return the idInfMunCarrega
     */
    public int getIdInfMunCarrega() {
        return idInfMunCarrega;
    }

    /**
     * @param idInfMunCarrega the idInfMunCarrega to set
     */
    public void setIdInfMunCarrega(int idInfMunCarrega) {
        this.idInfMunCarrega = idInfMunCarrega;
    }

    /**
     * @return the idInfMunDescarga
     */
    public int getIdInfMunDescarga() {
        return idInfMunDescarga;
    }

    /**
     * @param idInfMunDescarga the idInfMunDescarga to set
     */
    public void setIdInfMunDescarga(int idInfMunDescarga) {
        this.idInfMunDescarga = idInfMunDescarga;
    }

    /**
     * @return the idInfPercurso
     */
    public int getIdInfPercurso() {
        return idInfPercurso;
    }

    /**
     * @param idInfPercurso the idInfPercurso to set
     */
    public void setIdInfPercurso(int idInfPercurso) {
        this.idInfPercurso = idInfPercurso;
    }

    /**
     * @return the idInfVeiculo
     */
    public int getIdInfVeiculo() {
        return idInfVeiculo;
    }

    /**
     * @param idInfVeiculo the idInfVeiculo to set
     */
    public void setIdInfVeiculo(int idInfVeiculo) {
        this.idInfVeiculo = idInfVeiculo;
    }

    /**
     * @return the idLinkMDFeInfCTe
     */
    public int getIdLinkMDFeInfCTe() {
        return idLinkMDFeInfCTe;
    }

    /**
     * @param idLinkMDFeInfCTe the idLinkMDFeInfCTe to set
     */
    public void setIdLinkMDFeInfCTe(int idLinkMDFeInfCTe) {
        this.idLinkMDFeInfCTe = idLinkMDFeInfCTe;
    }

    /**
     * @return the idProtMDFe
     */
    public int getIdProtMDFe() {
        return idProtMDFe;
    }

    /**
     * @param idProtMDFe the idProtMDFe to set
     */
    public void setIdProtMDFe(int idProtMDFe) {
        this.idProtMDFe = idProtMDFe;
    }

    /**
     * @return the idRetEvento
     */
    public int getIdRetEvento() {
        return idRetEvento;
    }

    /**
     * @param idRetEvento the idRetEvento to set
     */
    public void setIdRetEvento(int idRetEvento) {
        this.idRetEvento = idRetEvento;
    }
    
    
}
