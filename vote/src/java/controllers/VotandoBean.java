package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entidades.Celula;
import entidades.Dados;
import entidades.Votado;
import models.VotadoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class VotandoBean {

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean sessao;

    private Votado votado;

    @EJB
    private VotadoServico votadoServico;

    public VotandoBean() {

        this.votado = new Votado();

    }

    public void votando(Dados dados, Celula celula) {

        try {

            this.votado = this.votadoServico.listarVotoEspecifico(this.sessao.getUsuario(), dados, celula);

            if (this.votado.getId() == null) {
                this.votadoServico.votar(dados, this.sessao.getUsuario());
                JSFUtil.addInfoMessage("Voto realizado com sucesso.");
            } else {
                JSFUtil.addErrorMessage("Você já realizou um voto.");
            }

        } catch (Exception e) {

            JSFUtil.addErrorMessage(e.getMessage());

        }

    }

    public List<Votado> listarVotados(Dados dados) {

        return this.votadoServico.listaVotado(dados);

    }

    public Votado getVotado() {
        return votado;
    }

    public void setVotado(Votado votado) {
        this.votado = votado;
    }

    public LoginBean getSessao() {
        return sessao;
    }

    public void setSessao(LoginBean sessao) {
        this.sessao = sessao;
    }

}
