package com.iot.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Name: Server
 * @Description:
 * @author: Olliween
 * @date: 2018/5/11 15:59
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("开启了8888端口,准备客户端的连接");
            socket = serverSocket.accept();
            if (socket != null) {
                System.out.println("有客户端连接");
                new Send(socket).start();
                new Receive(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
