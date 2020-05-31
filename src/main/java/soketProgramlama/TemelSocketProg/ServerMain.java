package soketProgramlama.TemelSocketProg;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerMain {
    private JPanel mainPanel;

    static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream sendMsg;
    static DataInputStream getMsg;

    static List<ServerConnection> connectionList=new LinkedList<ServerConnection>();      //clientleri listelemek için
    static boolean serverRun=true;                                              //server çalışıyorsa true

    public static void main(String[] args) {

        try {
            serverSocket=new ServerSocket(6066);
            System.out.println("Server çalışıyor");

            while (serverRun){
                socket=serverSocket.accept();
                ServerConnection serverConnection=new ServerConnection(socket);
                serverConnection.start();
                connectionList.add(serverConnection);
                System.out.println("Client number: "+connectionList.size());
            }

            sendMsg=new DataOutputStream(socket.getOutputStream());
            getMsg=new DataInputStream(socket.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
