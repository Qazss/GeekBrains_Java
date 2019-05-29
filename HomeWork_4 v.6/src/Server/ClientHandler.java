package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler {
    private Socket socket;
    private MyServer server;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private String nickname;

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
                            String authorizationData = inputStream.readUTF();
                            String[] tokens = authorizationData.split(" ");
                            String nickSQL = AuthService.getNickByAuthorization(tokens[1], tokens[2]);

                            if(authorizationData.startsWith("/auth") && server.isNotAuthorised(nickSQL)){
                                if(nickSQL != null){
                                    nickname = nickSQL;
                                    sendMessage("/authok");
                                    server.subscribe(ClientHandler.this);
                                    break;
                                } else {
                                    sendMessage("Неверный логин или пароль");
                                }
                            } else {
                                sendMessage("Данный пользователь уже авторизирован");
                            }
                        }

                        while(true) {
                            String text = inputStream.readUTF();
                            Date date = new Date();
                            SimpleDateFormat currentTime = new SimpleDateFormat("E hh:mm:ss");
                            if (text.equals("/end")) {
                                server.broadcastMessage("("+currentTime.format(date)+")" + nickname + " покинул чат");
                                break;
                            } else if (text.startsWith("/w")){
                                String[] personalMsg = text.split(" ", 3);
                                server.sendPersonalMsg(ClientHandler.this, personalMsg[1],
                                              "(" + currentTime.format(date) + ")" + nickname + " to " + personalMsg[1] + ": " +  personalMsg[2]);
                            } else {
                                server.broadcastMessage("(" + currentTime.format(date) + ")" + nickname + ": " + text);
                            }
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
                        server.unsubscribe(ClientHandler.this);
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

    public String getNickname() {
        return nickname;
    }
}
