/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amati.mattia
 */
public class ServerMultithread {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5500);
            System.out.println("server è attivo " + server.getInetAddress());
            while(true){
                Socket client = server.accept();
                Thread t = new Thread(new ServerThread(client));
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerMultithread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
