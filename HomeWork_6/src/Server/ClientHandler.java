package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private MyServer server;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ClientHandler(Socket socket, MyServer server){
        this.socket = socket;
        this.server = server;

        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true) {
                            String text = inputStream.readUTF();
                            if (text.equals("/end")) {
                                break;
                            }
                            server.broadcastMessage(text);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String text){
        try {
            outputStream.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
