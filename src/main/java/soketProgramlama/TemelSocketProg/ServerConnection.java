package soketProgramlama.TemelSocketProg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection extends Thread{

    Socket socket;
    DataOutputStream sendMsg;
    DataInputStream getMsg;
    boolean serverRun;

    ServerConnection(Socket socket){
        super("ServerConnectionThread");
        this.socket=socket;
    }

    public void sendToClient(String msg) throws IOException {
        sendMsg.writeUTF("msg");
        sendMsg.flush();
    }

    public void sendToAllClient(String msg) throws IOException {
        for(int i=0;i<ServerMain.connectionList.size();i++){
            ServerConnection serverConnection=ServerMain.connectionList.get(i);
            serverConnection.sendToClient(msg);
        }
    }

    @Override
    public void run() {

        try {
            getMsg=new DataInputStream(socket.getInputStream());
            sendMsg=new DataOutputStream(socket.getOutputStream());

            while (serverRun){
                String msg=getMsg.readUTF();
                System.out.println(msg);
                sendToAllClient(msg);
            }

            sendMsg.close();
            getMsg.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
