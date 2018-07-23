package io;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhoubo
 * @create 2018-07-23 11:41
 */
public class SerializableTestTest {
    @Test
    public void deserialize() throws Exception {
        SerializableTest serializableTest = new SerializableTest(new TestObject());
        final Object o = serializableTest.deserialize();
        Assert.assertTrue(o instanceof TestObject);
        TestObject testObject = (TestObject) o;
        final Method[] declaredMethods = testObject.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
//            System.out.println("");
        }
        final Field[] fields = testObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field: " + field.getName());
        }

        System.out.println("class name = " + testObject.getClass().getName());
    }

    @Test
    public void serialize() throws Exception {
        SerializableTest serializableTest = new SerializableTest(new TestObject());
        serializableTest.serialize();
    }

}