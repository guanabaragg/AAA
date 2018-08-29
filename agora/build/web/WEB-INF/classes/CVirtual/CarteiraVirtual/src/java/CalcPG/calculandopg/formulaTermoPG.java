package CalcPG.calculandopg;

import javax.swing.JOptionPane;

/**
 *
 * @author alex Terça-Feira, 19 de Junho de 2018, 00:22
 *
 * GUANABARA E O REI
 */
public class formulaTermoPG {

    public static void main(String[] args) {

        /* Progama para fazer o caculo do valor de uma PG - Progressao Geometrica, Matematica 2º Ensino Medio. 
        
         Questao: 
        
         ENCONTRE O OITAVO TERMO DA P.G (4, 12, 36): 
        
         q = Razao 
         a1 = Primeiro termo
         N = valor do oitavo termo
         aN = a1 + (n -1).r  -- Formula do termo geral de uma PA 
        
         */
        double a1 = 4;

        double n = 8;

        double nn = (n - 1);

        double q = 3;
        
        double qq = Math.pow(q,nn);

        double aN = a1 * qq;

        System.out.println("Encontre o OITAVO Termo da P.G (4, 12, 36)\n"
                + "O valor do oitavo termo é :  " + aN);

    }
}
