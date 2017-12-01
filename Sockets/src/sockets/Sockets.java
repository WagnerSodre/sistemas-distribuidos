/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

//Servidor

import java.io.*;
import java.net.*;

class TCPServidor{
    public static void main(String argv[]) throws Exception {
        String clienteSentenca;
        String sentencaCapturada;
        
        ServerSocket bemVindoSocket = new ServerSocket(9000);
        
        while (true){
            
            Socket conexaoSocket =  bemVindoSocket.accept();
            
            BufferedReader cadeiaCliente = 
                    new BufferedReader(new InputStreamReader (conexaoSocket.getInputStream()));
            DataOutputStream servidorParaCliente = new DataOutputStream(conexaoSocket.getOutputStream());
            
            clienteSentenca = cadeiaCliente.readLine();
            
            sentencaCapturada = clienteSentenca;
            
            System.out.println(sentencaCapturada);
            //servidorParaCliente.writeBytes(sentencaCapturada);
        }
    }
}