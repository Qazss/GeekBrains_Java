package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MyServer {
    private Vector<ClientHandler> clients;

    public MyServer(){
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            server = new ServerSocket(7189);
            System.out.println("Сервер запущен");

            while(true){
                socket = server.accept();
                System.out.println("Клиент подключен");
                clients.add(new ClientHandler(socket, this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMessage(String message){
        for(ClientHandler o: clients){
            o.sendMessage(message);
        }
    }
}
