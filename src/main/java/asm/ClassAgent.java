package asm;



import jdk.internal.org.objectweb.asm.*;

import java.io.*;

public class ClassAgent {
        public void agent() throws IOException {
            File file = new File("ChildClass.class");
            InputStream inputStream = new FileInputStream(file);
            ClassWriter cw = new ClassWriter(0);
            ClassVisitor cv = new ClassVisitor(Opcodes.ASM4, cw) {
                @Override
                public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
                    cv.visit(i, Opcodes.ACC_PUBLIC , s, s1, s2, strings);
                }

                @Override
                public void visitSource(String s, String s1) {
                    super.visitSource(s, s1);
                }

                @Override
                public void visitOuterClass(String s, String s1, String s2) {
                    super.visitOuterClass(s, s1, s2);
                }

                @Override
                public AnnotationVisitor visitAnnotation(String s, boolean b) {
                    return super.visitAnnotation(s, b);
                }

                @Override
                public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String s, boolean b) {
                    return super.visitTypeAnnotation(i, typePath, s, b);
                }

                @Override
                public void visitAttribute(Attribute attribute) {
                    super.visitAttribute(attribute);
                }

                @Override
                public void visitInnerClass(String s, String s1, String s2, int i) {
                    super.visitInnerClass(s, s1, s2, i);
                }

                @Override
                public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
                    return super.visitField(i, s, s1, s2, o);
                }

                @Override
                public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
                    if (s.startsWith("compare")) {
                        System.out.println(s);
                        return null;
                    }
                    return cv.visitMethod(Opcodes.ACC_PUBLIC, s, s1, s2, strings);
                }

                @Override
                public void visitEnd() {
                    super.visitEnd();
                }
            };
            ClassReader cr = new ClassReader(inputStream);
            cr.accept(cv, 0);
            cw.toByteArray();
            OutputStream outputStream = new FileOutputStream(new File("ChildClassA.class"));
            outputStream.write(cw.toByteArray());
            outputStream.close();
        }
}
