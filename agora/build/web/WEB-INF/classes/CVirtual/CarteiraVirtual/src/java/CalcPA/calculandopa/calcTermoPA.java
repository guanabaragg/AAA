package CalcPA.calculandopa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author alex
 */
@ManagedBean
public class calcTermoPA {

    private int r1 = 0;
    private int r2 = 0;
    private int r3 = 0;
    private int r = 0;
    private int a1 = 0;
    private int n = 0;
    private int aN = (int) 0;

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getR3() {
        return r3;
    }

    public void setR3(int r3) {
        this.r3 = r3;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getaN() {
        return aN;
    }

    public void setaN(int aN) {
        this.aN = aN;
    }

    public void calcular() {
        FacesContext context = FacesContext.getCurrentInstance();

        System.out.println("Metodo calcular chamado!");

        if (r1 == 0 && r2 == 0 && r3 == 0 && n == 0) {

            System.out.println("Favor insira dados validos!");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor insira dados validos!", ""));

        } else if (r1 != 0 && r2 != 0 && n != 0) {

            setR3((r2 - r1) + r2);

            r = r2 - r1;

            getR1();

            getN();

            aN = getR1() + (getN() - 1) * r;

            System.out.println("Sucesso!");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", ""));

        } else {
            System.out.println("Favor insira dados validos!");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor insira dados validos!", ""));
        }

    }

    public void atualizar() {
        //FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("Metodo atualizar chamado!");
        setR1(0);
        setR2(0);
        setR3(0);
        setN(0);

        //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", ""));
    }

}