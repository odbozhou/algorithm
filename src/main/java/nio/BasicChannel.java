package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhoubo on 2017/4/25.
 */
public class BasicChannel {
    public static void channelDemo1() throws IOException {
        RandomAccessFile file = new RandomAccessFile("G:\\test\\test.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);

        String str = "new data";
        try {
            int b = channel.read(byteBuffer);
            while (b != -1) {
                System.out.println("b = " + b);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char)byteBuffer.get());
                }
                byteBuffer.clear();
                b = channel.read(byteBuffer);
            }
            byteBuffer.clear();
            byteBuffer.put(str.getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            channel.close();
            file.close();
        }
    }
}
