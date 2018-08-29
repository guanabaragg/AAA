/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author SQL
 */
@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements HttpSessionListener {

//    Util util = new Util();
//
//    Usuario usuario = new Usuario();
//    UsuarioService usuarioService = new UsuarioService();
//
//    Empresa empresa = new Empresa();
//    EmpresaService empresaService = new EmpresaService();
//
//    List<TipoDocumento> listaTipoDocumento = new ArrayList<TipoDocumento>();
//    TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
//    HashMap<String, String> listaTipoDocumentoContador = new HashMap<String, String>();
//
//    List<TipoVinculo> listaTipoVinculo = new ArrayList<TipoVinculo>();
//    TipoVinculoService tipoVinculoService = new TipoVinculoService();
//
//    ParceiroService parceiroService = new ParceiroService();
//    Parceiro parceiroV = new Parceiro();
//    List<Parceiro> listaParceiroVinculado = new ArrayList<Parceiro>();
//
//    ComissaoService comissaoService = new ComissaoService();
//    List<Comissao> listaComissao = new ArrayList<Comissao>();
    private HttpSession session;
    String usuario = "";
    String login = "";
    String senha = "";
    private String vEmail = null;
    private String color = "-blue";
    //String color = "-green";
    private String chave = "";
    private String vModulo = null;
//    private Modulo modulo = null;

    String home;

    private StreamedContent logo;

    public void download() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();

        HttpServletResponse ec = (HttpServletResponse) fc.getExternalContext().getResponse();

        ec.reset();

        ec.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        //ec.setContentLength(1024);
        ec.setHeader("Content-Disposition", "attachment; filename=\"Arquivo.docx\"");

        OutputStream output = ec.getOutputStream();

        HashMap<String, String> c = new HashMap();
        c.put("#Conteudo2", "Bruno Fontes");
        c.put("#Conteudo1", "Silas Ribeiro");
        c.put("#Conteudo3", "Luiz Barbosa");
        c.put("#Conteudo4", "Was.........");

//        Word w = new Word("C:\\Projetos\\Fontes\\ERP\\BACK\\src\\_Teste\\Template.docx");
//        w.setConteudo(c);
//        ByteArrayOutputStream stream = w.salvar();
//        output.write(stream.toByteArray());
//
//        //Para finalizar o processo
//        output.flush();
//        output.close();
//        fc.responseComplete();
    }

    public void iniciarParametro() {
        /*Verifica permissão de acesso*/
//        if (usuario.getAcOrgParametro() == null || usuario.getAcOrgParametro().equals("-1")) {
//            mudarPagina("/organizacional/acessonegado.jsf");
//            return;
//        }

    }

    public void iniciarADM() {

//        listaTipoDocumento = tipoDocumentoService.montarMenu(empresa.getSeqEmpresa(), usuario.getSeqUsuario());
//
//        listaTipoDocumentoContador = tipoDocumentoService.listarContador(empresa.getSeqEmpresa(), usuario.getSeqUsuario());
    }

//    public void iniciarComercial() {
//
//        listaComissao = comissaoService.listarLiberadoPorUsuario(usuario.getSeqUsuario());
//    }
//
//    public void carregarTabAuxParametro() {
//        listaTipoVinculo = tipoVinculoService.listar(usuario.getSeqEmpresa(), "", Situacao.ATIVO);
//    }
//
//    public void enviarSenhaEmail() {
//        if (usuarioService.enviarEmailSenha(vEmail) == true) {
//            //if (usuarioService.enviarEmailSenha(vEmail, transportadora.getSeqTransportadora()) == true) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Em alguns instantes você receberá um email com sua senha.", ""));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email não encontrado no sistema.", ""));
//        }
//
//    }
//
//    public void salvarParametro() {
//        empresa = empresaService.salvar(empresa);
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informações armazenadas com sucesso!", ""));
//
//        //sair();
//    }
//
//    public void upload(FileUploadEvent event) {
//        try {
//            util.copiarArquivoDisco(empresa.getSeqEmpresa(), Logo, "logo.png", event.getFile().getInputstream());
//            //copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        carregarlogo();
//
//        mudarPagina("/organizacional/parametro.jsf");
//
//    }
//    /*
//     public void copyFile(String fileName, InputStream in) {
//     try {
//     String caminho = "C:\\temp\\erp\\logo\\";
//     String nomeDoArquivo = String.valueOf(empresa.getSeqEmpresa());
//     //            OutputStream out = new FileOutputStream(new File(caminho + nomeDoArquivo + fileName));
//     OutputStream out = new FileOutputStream(new File(caminho + nomeDoArquivo + ".jpg"));
//
//     int read = 0;
//     byte[] bytes = new byte[1024];
//     while ((read = in.read(bytes)) != -1) {
//     out.write(bytes, 0, read);
//     }
//
//     in.close();
//     out.flush();
//     out.close();
//     } catch (IOException e) {
//     System.out.println(e.getMessage());
//     }
//
//     }
//     */
    public void mudarPagina(String pPagina) {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + pPagina);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarlogo() {
        try {
            //FileInputStream in = new FileInputStream(new File("C:\\Projetos\\CIM\\web\\images\\logo1pqn.png"));
            //System.out.println("C:\\Projetos\\CIM\\web\\images\\logo.png");
            //logo = new DefaultStreamedContent(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log() {

        FacesContext ctx = FacesContext.getCurrentInstance();

        if (login.equals("alex") && senha.equals("123")) {
            mudarPagina("/principal/principal.jsf");
        }
        System.out.println("Login: " + login + " | Senha: " + senha);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha invalido!", ""));
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getvModulo() {
        return vModulo;
    }

    public void setvModulo(String vModulo) {
        this.vModulo = vModulo;
    }

    public String getHome() {
        return home;
    }

//    public void logar() throws IOException {
//
//        FacesContext ctx = FacesContext.getCurrentInstance();
//
//        if (vModulo.equals("ADM")) {
//            modulo = Modulo.Administrativo;
//            home = ctx.getExternalContext().getRequestContextPath() + "/principal/principal.jsf";
//        }
//        vModulo = "ADM";
//        if (vModulo.equals("FV")) {
//            modulo = Modulo.Comercial;
//            home = ctx.getExternalContext().getRequestContextPath() + "/principal/comercial.jsf";
//        } else if (vModulo.equals("ADM")) {
//            modulo = Modulo.Administrativo;
//            home = ctx.getExternalContext().getRequestContextPath() + "/principal/principal.jsf";
//        }
//
//        usuario = usuarioService.validarAcesso(login, senha, chave, modulo);
//        System.out.println(chave);
//
//        if (usuario != null) {
//            empresa = empresaService.buscarEmpresaPorChave(chave);
//            session = (HttpSession) ctx.getExternalContext().getSession(false);
//            session.setAttribute("currentUser", usuario);
//            session.setAttribute("context", ctx.getExternalContext().getRequestContextPath());
//
//            color = usuario.getCor();
//            carregarlogo();
//            FacesContext.getCurrentInstance().getExternalContext().redirect(home);
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha invalido!.", ""));
//        }
//    }
    public void sair() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        s.invalidate();
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + "/");

        } catch (IOException ex) {
            System.out.println("deu merda no sair");
//            Logger.getLogger(UsuarioController.class
//                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void mudarCor(String color) {
//        if (color.equals("green")) {
//            this.color = null;
//        } else {
//            this.color = "-" + color;
//        }
//        usuario.setCor(this.color);
//        usuarioService.salvarUsuario(usuario);
//
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect(home);
//
//        } catch (IOException ex) {
//            Logger.getLogger(LoginController.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public void setHome(String home) {
        this.home = home;
    }

    public StreamedContent getLogo() {
        return logo;
    }

    public void setLogo(StreamedContent logo) {
        this.logo = logo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
