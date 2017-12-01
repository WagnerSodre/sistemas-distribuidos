/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.*;
import java.net.*;

/**
 *
 * @author Nelsin
 */
public class SocketCliente3 {
    public static void main(String argv[]) throws Exception{
        String sentenca;
        
        BufferedReader cadeiaUsuario = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clienteSocket = new Socket("Localhost", 9000);
        
        DataOutputStream clienteParaServidor = new DataOutputStream(clienteSocket.getOutputStream());
        
        BufferedReader cadeiaServidor = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        
        sentenca = cadeiaUsuario.readLine();
        
        clienteParaServidor.writeBytes(sentenca);
        
        clienteSocket.close();
    }
}