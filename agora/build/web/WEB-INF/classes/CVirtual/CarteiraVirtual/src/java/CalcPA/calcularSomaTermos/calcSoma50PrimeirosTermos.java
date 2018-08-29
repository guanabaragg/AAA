package CalcPA.calcularSomaTermos;

import javax.swing.JOptionPane;

/**
 *
 * @author alex Terça-Feira, 19 de Junho de 2018, 03:25
 *
 * GUANABARA E O REI
 */
public class calcSoma50PrimeirosTermos {

    public static void main(String[] args) {

        /* Calcular a soma dos 50 primeiros termos da P.A (1, 3, 5, 7..)         
        
         r = Razao 
         a1 = Primeiro termo
         n = numero da p.a a ser somado
         a50 = 1 + (50 -1).2  -- Formula para calcular 50 primeiros termos de uma PA 
        
         */
        int a50 = 1 + (50 - 1) * 2;
        int s50 = (1 + a50) * 50 / 2;
        //System.out.println(s50);
        JOptionPane.showMessageDialog(null, "Calculando 50 primeiros termos de uma PA (1, 3, 5, 7..)\n"
                + "Posiçao do termo 50:  " + a50
                + "\nSoma dos 50 1º:  " + s50);

    }
}
