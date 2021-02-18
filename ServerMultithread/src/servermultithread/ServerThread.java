/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amati.mattia
 */
public class ServerThread implements Runnable{
    private Socket clientScoket;

    public ServerThread(Socket clientScoket) {
        this.clientScoket = clientScoket;
    }
    
    @Override
    public void run() {
        System.out.println("server partito");
        try {
            InputStream dalServer = clientScoket.getInputStream();
                BufferedReader lettore = new BufferedReader(
                        new InputStreamReader(dalServer));
            String risposta = lettore.readLine();
            lettore.close();
            OutputStream versoclient = clientScoket.getOutputStream();
            BufferedWriter scrittore = new BufferedWriter(new OutputStreamWriter(versoclient));      
            Thread.sleep(1000);
            scrittore.write(risposta.toUpperCase());
            scrittore.close();
            versoclient.close();
//            clientScoket.close();
            System.out.println("chisura connesione");
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
