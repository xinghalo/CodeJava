package xing.test.ditributed.chap01;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于BIO实现的最简单的单线程服务器，不断接收用户请求，处理后返回信息
 *
 * Created by xingoo on 2017/1/7.
 */
public class TcpBioSocketServer {
    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("服务器 启动...");

        while(true){
            try{
                //方法一直阻塞直到接收客户端连接请求
                socket = serverSocket.accept();
                System.out.println("接收连接请求: "+socket.getInetAddress()+":"+socket.getPort());

                //接收客户端的输入信息
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = null;
                StringBuilder sb = new StringBuilder();
                while((line=in.readLine())!=null){
                    System.out.println("接收到:"+line);
                    sb.append(line);
                }
                socket.shutdownInput();

                Thread.sleep(3000);//服务器处理需要3秒钟，客户端需要等待

                //回复客户端
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println("接收到你的消息:"+sb.toString());

                //关闭连接
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
                IOUtils.closeQuietly(socket);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
