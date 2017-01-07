package xing.test.ditributed.chap01;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 基于Socket实现的最简单的客户端程序，仅向服务端发送一个信息，然后等待回复
 *
 * Created by xingoo on 2017/1/7.
 */
public class TcpBioSocketClient {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            //连接服务器
            Socket socket = new Socket(SERVER_IP,SERVER_PORT);
            System.out.println("客户端 启动 ...");

            //发送信息
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println(new BufferedReader(new InputStreamReader(System.in)).readLine());
            socket.shutdownOutput();

            //阻塞等待服务器回复

            //接收服务器响应
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while((line=in.readLine())!=null){
                System.out.println("接收到回复:"+line);
            }
            socket.shutdownInput();

            //关闭连接和输入输出流
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
