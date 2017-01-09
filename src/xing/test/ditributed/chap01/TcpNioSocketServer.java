package xing.test.ditributed.chap01;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/7.
 */
public class TcpNioSocketServer {
    public static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        //ServerSocketChannel用于监听端口以及监听连接事件
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();//打开服务器套接字通道
        ServerSocket serverSocket = ssc.socket();//检索与之关联的服务器套接字
        serverSocket.bind(new InetSocketAddress(SERVER_PORT));
        System.out.println("服务器监听端口:"+SERVER_PORT);

        ssc.configureBlocking(false);
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            int nKeys = selector.select(1000);
            if(nKeys > 0){
                Set<SelectionKey> keys = selector.selectedKeys();
                for(SelectionKey key: keys){
                    if(key.isAcceptable()){
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();

                        if(socketChannel == null){
                            continue;
                        }
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if(key.isReadable()){
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel sc = (SocketChannel) key.channel();
                        int readBytes = 0;
                        String message = null;
                        try{
                            int ret = 0;
                            try {
                                while ((ret = sc.read(buffer)) > 0) {
                                    readBytes += ret;
                                }
                            }catch (Exception e){
                                readBytes = 0;
                            }finally{
                                buffer.flip();
                            }

                            if(readBytes > 0){
                                message = Charset.forName("UTF-8").decode(buffer).toString();
                                buffer = null;
                            }
                        }finally {
                            if(buffer!=null){
                                buffer.clear();
                            }
                        }

                        if(readBytes > 0){
                            System.out.println("message from client:"+message);
                            if("quit".equalsIgnoreCase(message.trim())){
                                IOUtils.closeQuietly(sc);
                                IOUtils.closeQuietly(selector);
                                System.out.println("server has been shutdown");
                                System.exit(0);
                            }
                            String outMessage = "server response:"+message;
                            sc.write(Charset.forName("UTF-8").encode(outMessage));
                        }
                    }
                }
                selector.selectedKeys().clear();
            }
        }
    }
}
