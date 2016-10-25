package org.mcsg.survivalgames.net;

import org.mcsg.survivalgames.SurvivalGames;

import java.net.ServerSocket;
import java.net.Socket;


public class Webserver extends Thread {

    public void run() {
        try {
            ServerSocket st = new ServerSocket(880);

            while (!SurvivalGames.isDisabling()) {

                Socket skt = st.accept();

                // Spin off request to a new thread to be handled
                Connection c = new Connection(skt);
                c.start();
                // st.close();
            }
            st.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}

