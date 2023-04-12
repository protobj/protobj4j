package io.protobj.config;

import com.beust.jcommander.Parameter;

public class Config {
    @Parameter(names = {"--help", "-h"})
    private boolean help;


    @Parameter(names = {"--source_dir", "-s"}, description = "源目录", required = true)
    private String sourceDir;

    @Parameter(names = {"--language", "-lang"}, description = "生成的语言:java", required = true)
    private LanguageType languageType;

    @Parameter(names = {"--output_dir", "-o"}, description = "输出目录", required = true)
    private String outputDir;

    @Parameter(names = {"--output_type", "-o_type"}, description = "输出选项:all,schema,message default:all")
    private OutputType outputType = OutputType.all;


    private boolean javaRuntime;

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }

    public OutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }

    public boolean isJavaRuntime() {
        return javaRuntime;
    }

    public void setJavaRuntime(boolean javaRuntime) {
        this.javaRuntime = javaRuntime;
    }
}
