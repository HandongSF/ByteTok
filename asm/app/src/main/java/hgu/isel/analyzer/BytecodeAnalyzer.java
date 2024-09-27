package hgu.isel.analyzer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;

public class BytecodeAnalyzer extends ClassVisitor {

    public BytecodeAnalyzer() {
        super(Opcodes.ASM9);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("Method: " + name + " " + descriptor);

        return new MethodVisitor(Opcodes.ASM9) {
            @Override
            public void visitCode() {
                super.visitCode();
                System.out.println("Raw Bytecode (Hex) for method: " + name);
            }

            @Override
            public void visitInsn(int opcode) {
                super.visitInsn(opcode);
                // Convert opcode to hexadecimal
                String hexOpcode = String.format("%02X", opcode);
                System.out.println("Opcode: " + opcode + " -> Hex: " + hexOpcode);
            }

            // Capture other types of bytecode instructions as well
            @Override
            public void visitVarInsn(int opcode, int var) {
                super.visitVarInsn(opcode, var);
                String hexOpcode = String.format("%02X", opcode);
                System.out.println("VarInsn Opcode: " + hexOpcode + " Var: " + var);
            }

            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                String hexOpcode = String.format("%02X", opcode);
                System.out.println("MethodInsn Opcode: " + hexOpcode + " Method: " + name);
            }
        };
    }

    // Analyze the .class file by loading from a file path
    public void analyzeClassFile(String classFilePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(classFilePath)) {
            ClassReader classReader = new ClassReader(inputStream);
            BytecodeAnalyzer analyzer = new BytecodeAnalyzer();
            classReader.accept(analyzer, 0);
        }
    }
}