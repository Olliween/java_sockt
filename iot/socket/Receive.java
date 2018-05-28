package com.iot.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Name: Receive
 * @Description:
 * @author: Olliween
 * @date: 2018/5/11 16:35
 */
public class Receive extends Thread {
    private Socket socket;

    public Receive(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private InputStream inputStream = null;

    public void accept() {
        try {
            inputStream = socket.getInputStream();
            byte[] bs = new byte[1024];
            int len = inputStream.read(bs);
            String strlist = new String(bs, 0, len);
            System.err.println("收到的信息：" + strlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while (true) {
                accept();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
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
