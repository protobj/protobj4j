package io.protobj;

import io.protobj.config.LanguageType;
import org.junit.Test;

public class ProtobjFileGeneratorTest {

    public static final String SOURCE_DIR = "D:\\code\\protobj\\protobj-java\\src\\test\\resources";


    @Test
    public void writeJavaCode() throws Exception {
        String output_dir = "D:\\code\\protobj\\protobj-java\\src\\test\\java";
        String[] args = new String[]{
                "-s", SOURCE_DIR,//
                "-o", output_dir,//
                "-lang", LanguageType.java.name(),
        };
        Protobj.main(args);
    }

    public static void main(String[] args) throws Exception {
        ProtobjFileGeneratorTest protobjFileGeneratorTest = new ProtobjFileGeneratorTest();
        protobjFileGeneratorTest.writeJavaCode();
    }
}
