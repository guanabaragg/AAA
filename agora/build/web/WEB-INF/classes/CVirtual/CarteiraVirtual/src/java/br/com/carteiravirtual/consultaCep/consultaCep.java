package br.com.carteiravirtual.consultaCep;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author alex
 */
@ManagedBean
public class consultaCep {

    private String ceep;
    private String ruua;
    private String baiirro;
    private String ciidade;
    private String uff;

    /*
     public static void main(String[] args) {

     WebServiceCep webServiceCep = WebServiceCep.searchCep(JOptionPane.showInputDialog("Informe seu Cep:"));

     if (webServiceCep.wasSuccessful()) {

     JOptionPane.showMessageDialog(null, "Cep: " + webServiceCep.getCep()
     + "\nLogradouro: " + webServiceCep.getLogradouroFull()
     + "\nBairro: " + webServiceCep.getBairro()
     + "\nCidade: "
     + webServiceCep.getCidade() + " - " + webServiceCep.getUf());

     } else {
     JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

     JOptionPane.showMessageDialog(null, "Descriçao do erro: " + webServiceCep.getResultText());
     }
     }
     */
    public void consultar() {

        System.out.println("Metodo Consultar Chamado!");

        FacesContext context = FacesContext.getCurrentInstance();

        WebServiceCep webServiceCep = WebServiceCep.searchCep(getCeep());

        if (ceep.length() < 8 && ceep.equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um cep correto!", ""));
        } else if (ceep.length() >= 8) {
            if (webServiceCep.wasSuccessful()) {
                setRuua(webServiceCep.getLogradouroFull());
                setBaiirro(webServiceCep.getBairro());
                setCiidade(webServiceCep.getCidade());
                setUff(webServiceCep.getUf());
            } else {
                System.out.println("Descriçao do erro: " + webServiceCep.getResultText());
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Cep nao encontrado"));
            }
        }
    }

    public void atualizar() {
        setCeep("");
        setRuua("");
        setBaiirro("");
        setCiidade("");
        setUff("");
    }

    public String getBaiirro() {
        return baiirro;
    }

    public void setBaiirro(String baiirro) {
        this.baiirro = baiirro;
    }

    public String getCeep() {
        return ceep;
    }

    public void setCeep(String ceep) {
        this.ceep = ceep;
    }

    public String getRuua() {
        return ruua;
    }

    public void setRuua(String ruua) {
        this.ruua = ruua;
    }

    public String getCiidade() {
        return ciidade;
    }

    public void setCiidade(String ciidade) {
        this.ciidade = ciidade;
    }

    public String getUff() {
        return uff;
    }

    public void setUff(String uff) {
        this.uff = uff;
    }

}
