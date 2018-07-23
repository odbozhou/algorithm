package io;

import java.io.*;

/**
 * 序列化测试
 *
 * @author zhoubo
 * @create 2018-07-23 10:56
 */
public class SerializableTest {

    private Object object;

    public SerializableTest(Object object) {
        this.object = object;
    }

    public Object deserialize() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(new File("target/object.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        final Object o = objectInputStream.readObject();
        return o;
    }

    public void serialize() throws IOException {
//        ObjectOutput outputStream = new ObjectOutput(new File("target/object.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("target/object.txt")));
        OutputStream outputStream = new FileOutputStream(new File("target/object.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
    }
}
