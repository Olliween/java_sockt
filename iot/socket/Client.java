package com.iot.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @Name: Client
 * @Description:
 * @author: Olliween
 * @date: 2018/5/11 15:59
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //数据传输格式:设备序列号@命令码@数据
            socket = new Socket("localhost", 8888);
            System.out.println("输入要发送给服务器的信息:");
            new Send(socket).start();
            new Receive(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
