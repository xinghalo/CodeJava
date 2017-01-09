package xing.test.ditributed.chap01;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

/**
 *参考文章：http://zhhphappy.iteye.com/blog/2032893
 *
 * Created by Administrator on 2017/1/7.
 */
public class TcpNioSocketClient {
    public static final int SERVER_PORT = 12345;
    public static final String SERVER_HOST = "localhost";

    public static void main(String[] args) throws IOException {
        //SocketChannel用于建立连接、监听事件以及操作读写
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);//设置非阻塞模式
        socketChannel.connect(new InetSocketAddress(InetAddress.getByName(SERVER_HOST),SERVER_PORT));

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);//注册感兴趣的事件

        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            if(socketChannel.isConnected()){
                String command = systemIn.readLine();
                socketChannel.write(Charset.forName("UTF-8").encode(command));

                if(command == null || "quit".equalsIgnoreCase(command.trim())){
                    IOUtils.closeQuietly(systemIn);
                    IOUtils.closeQuietly(socketChannel);
                    IOUtils.closeQuietly(selector);
                    System.out.println("Client quit!");
                    System.exit(0);
                }
            }
            int nKeys = selector.select(1000);
            if(nKeys>0){
                Set<SelectionKey> keys = selector.selectedKeys();
                for(SelectionKey key: keys){
                    if(key.isConnectable()){//发生连接事件
                        SocketChannel sc = (SocketChannel)key.channel();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                        sc.finishConnect();
                    }else if(key.isReadable()){//有流可以读取
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel sc = (SocketChannel) key.channel();
                        int readBytes = 0;
                        try{
                            int ret = 0;
                            try{
                                while((ret = sc.read(buffer))>0){
                                    readBytes+=ret;
                                }
                            }finally{
                                buffer.flip();
                            }
                            if(readBytes > 0){
                                System.out.println(Charset.forName("UTF-8").decode(buffer).toString());
                                buffer = null;
                            }
                        }finally {
                            if(buffer!=null){
                                buffer.clear();
                            }
                        }
                    }
                }
                selector.selectedKeys().clear();
            }
        }
    }
}
