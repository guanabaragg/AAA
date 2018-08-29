package CalcPG.calculandopg;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author alex
 */
@ManagedBean
public class calcTermoPG {

    private int r1;
    private int r2;
    private int r3;
    private int q;
    private int n;
    private int aN;

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

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
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

        if (r1 == 0 && r2 == 0 && r3 == 0 && n == 0) {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor insira dados validos!", ""));

        } else if (r1 != 0 && r2 != 0 && n != 0) {

            setQ((r2 / r1));

            setR3(r2 * q);

            getR1();

            getN();

            int nn = (n - 1);

            int qq = (int) Math.pow(q, nn);

            aN = r1 * qq;

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", ""));

        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Favor insira dados validos!", ""));
        }

    }

    public void atualizar() {

        setR1(0);
        setR2(0);
        setR3(0);
        setN(0);

    }

}
