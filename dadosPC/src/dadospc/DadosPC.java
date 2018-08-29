/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadospc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author guana
 */
public class DadosPC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {

        String nomePc = InetAddress.getLocalHost().getHostName();
        System.out.println(nomePc);
        
        String ipPc = InetAddress.getLocalHost().getHostAddress();
        System.out.println(ipPc);
    }
    
}
