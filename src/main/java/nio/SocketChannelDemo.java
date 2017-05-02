package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by zhoubo on 2017/4/27.
 */
public class SocketChannelDemo {
    public void SocketChannelFun() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();



        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));


        String transStr = "hello ServerSocketChannel";
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        byteBuffer.put(transStr.getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }

        byteBuffer.clear();
        byteBuffer.flip();
        int c = socketChannel.read(byteBuffer);
        while (c != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            c = socketChannel.read(byteBuffer);
        }






    }
}
