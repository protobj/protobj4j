package io.protobj.core;

import com.beust.jcommander.JCommander;
import io.protobj.config.Config;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.java.JavaGenerator;
import io.protobj.parser.ProtobjContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProtobjRuntime {

    public static void main(String[] args) throws Exception {
        args = new String[]{
                "-s", "/Users/chenqiang/IdeaProjects/framework/protobj",//
                "-o", "/Users/chenqiang/IdeaProjects/framework/protobj/src/main/java",//
//                "-s", "D:\\ideaprojects\\framework\\protobj",//
//                "-o", "D:\\ideaprojects\\framework\\protobj\\src\\main\\java",//
                "-lang", "java",
        };

        Config config = new Config();

        JCommander commander = JCommander.newBuilder().addObject(config).build();
        commander.parse(args);

        if (config.isHelp()) {
            commander.usage();
            return;
        }

        String sourceDir = config.getSourceDir();
        List<File> fileList = new ArrayList<>();
        File dir = new File(sourceDir);
        getFileNames(dir, fileList);

        ProtobjContext protobjContext = new ProtobjContext();
        Map<String, MessageConfig> messageConfigMap = protobjContext.load(fileList);
        config.setJavaRuntime(true);
        JavaGenerator javaGenerator = new JavaGenerator(messageConfigMap, config);

//        InMemoryJavaCompiler inMemoryJavaCompiler = InMemoryJavaCompiler.newInstance();
//        List<GeneratorResult> generatorResults = javaGenerator.generateSchemaRuntime();
//        for (GeneratorResult generatorResult : generatorResults) {
//            inMemoryJavaCompiler.addSource(generatorResult.className(), generatorResult.content());
//        }
//        Map<String, Class<?>> stringClassMap = inMemoryJavaCompiler.compileAll();


    }


    private static void getFileNames(File dir, List<File> fileList) {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".protobj")) {
                    fileList.add(file);
                }
            } else if (file.isDirectory()) {
                getFileNames(file, fileList);
            }
        }
    }
}
