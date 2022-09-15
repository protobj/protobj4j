package io.protobj;

import com.beust.jcommander.JCommander;
import io.protobj.config.LanguageType;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.java.JavaGenerator;
import io.protobj.config.Config;
import io.protobj.parser.ProtobjContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Protobj {

    public static void main(String[] args) throws Exception {

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

        switch (config.getLanguageType()) {
            case java -> new JavaGenerator(messageConfigMap, config).generate().join();
            default -> System.err.printf("unknown language :%s%n", config.getLanguageType());
        }
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
