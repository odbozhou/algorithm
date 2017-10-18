package asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by jiajia on 2017/10/18.
 */
public class ClassPrintVisitorTest {
    @Test
    public void visit() throws Exception {
        ClassReader classReader = new ClassReader("asm.AsmClassReadTest");
        ClassPrintVisitor classPrintVisitor = new ClassPrintVisitor();
        classReader.accept(classPrintVisitor,0);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("ChildClass.class"));
        InputStream inputStream = new ByteArrayInputStream(gen());
        byte[] bytes = new byte[1024];
        int b = inputStream.read(bytes);
        while (b != -1) {
            fileOutputStream.write(bytes);
            b = inputStream.read(bytes);
        }
        System.out.println("gen()" + gen());
    }

    private static byte[] gen() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT ,
                "asm/ChildClass", null, "java/lang/Object", new String[]{"asm/ParentInter"});

        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "zero", "I", null, new Integer(0))
                .visitEnd();

        cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
                .visitEnd();
        cw.visitEnd();
        return cw.toByteArray();
    }

/*    private static byte[] genHelloWorld() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT ,
                "HelloWorld", null, "java/lang/Object", new String[]{});


        cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
                .visitEnd();
        cw.visitEnd();
        return cw.toByteArray();
    }*/

}