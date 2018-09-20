package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestClass {
    @TestAnnotation(id = "1", name = "test")
    public Integer test() {
       return 1;
    }
    @TestAnnotation(id = "2")
    public Integer test1() {
       return 2;
    }


    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Field[] fields = testClass.getClass().getFields();
        Method[] methods = TestClass.class.getMethods();
        for (Method method : methods){
            TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
            if(null != annotation) {
                System.out.println(annotation.id());
                System.out.println(annotation.name());
                System.out.println(method.getName());
            }
        }

    }
}
