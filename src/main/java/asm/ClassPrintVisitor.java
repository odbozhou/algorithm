package asm;


import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * Created by jiajia on 2017/10/18.
 */
public class ClassPrintVisitor extends ClassVisitor {

    public ClassPrintVisitor() {
        super(Opcodes.ASM4);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        System.out.println("i = " + i + " s = " + s + " s1 " + s1 + " s2 " + s2);
        System.out.println(s + " extends " + s2 + " { ");
    }

    @Override
    public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
        System.out.println("field name " + s + " desc " + s1);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        System.out.println("method name " + s + " desc " + s1);
        return null;
    }

    @Override
    public void visitEnd() {
        System.out.println(" } ");
    }


}
