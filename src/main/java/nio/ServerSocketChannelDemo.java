package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by zhoubo on 2017/4/27.
 */
public class ServerSocketChannelDemo {
    public void ServerSocketChannelFun() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        boolean flag = true;
        while(flag) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            int c = socketChannel.read(byteBuffer);
            while (c != -1) {
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()) {
                    System.out.println((char)byteBuffer.get());
                }
                byteBuffer.clear();
                c = socketChannel.read(byteBuffer);
            }

            byteBuffer.clear();
            String transStr = "hello ServerChannel";
            byteBuffer.put(transStr.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }



        }
    }
}
