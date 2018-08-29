package CalcPA.calcularSomaTermos;

import javax.swing.JOptionPane;

/**
 *
 * @author alex Terça-Feira, 19 de Junho de 2018, 03:25
 *
 * GUANABARA E O REI
 */
public class calcSomaTermos {

    public static void main(String[] args) {

        int a1 = Integer.parseInt(JOptionPane.showInputDialog("Informe 1º Razao da P.A:"));
        int a2 = Integer.parseInt(JOptionPane.showInputDialog("Informe 2º Razao da P.A:"));
        int a3 = Integer.parseInt(JOptionPane.showInputDialog("Informe 3º Razao da P.A:"));

        int r = a2 - a1;
        JOptionPane.showMessageDialog(null, "A Razao é :  " + r);

        int n = Integer.parseInt(JOptionPane.showInputDialog("Um termo para ser somado.\nEx: 50 primeiros termos\nInforma a posiçao do termo:"));

        int aN = a1 + (n - 1) * r;

        int sN = (a1 + aN) * n / 2;

        JOptionPane.showMessageDialog(
                null, "A soma dos " + n + "º Primeiros Termos é :  " + sN);

        JOptionPane.showMessageDialog(
                null, "1º Razao da P.A: " + a1
                + "\n2º Razao da P.A: " + a2
                + "\n3º Razao da P.A: " + a3
                + "\nValor da Razao: " + r
                + "\nPosiçao do Termo: " + n
                + "\nA soma dos " + n + "º Primeiros Termos é : " + sN);

    }
}
