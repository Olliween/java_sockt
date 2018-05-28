package com.iot.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Name: Send
 * @Description:
 * @author: Olliween
 * @date: 2018/5/11 16:40
 */
public class Send extends Thread{
    private Socket socket;

    public Send(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private OutputStream outputStream;
    public  void  write(String message) {
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while (true) {
                String message = new Scanner(System.in).next();
                if (message == "exit") {
                    break;
                }
                write(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
