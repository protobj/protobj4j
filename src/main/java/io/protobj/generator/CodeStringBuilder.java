package io.protobj.generator;

import java.util.HashSet;
import java.util.Set;

public class CodeStringBuilder {

    public static final String intent = " ";
    public static final String tab = intent.repeat(4);

    public int current = 0;

    private final StringBuilder builder;
    private final StringBuilder line;

    private final Set<String> importMessages;

    public CodeStringBuilder() {
        this.builder = new StringBuilder();
        this.importMessages = new HashSet<>();
        this.line = new StringBuilder();
    }


    public void setCurrent(int current) {
        this.current = current;
    }

    private char lastChar;

    public CodeStringBuilder add(String value) {
        this.line.append(value);
        return this;
    }


    private void append0(String value) {
        if (current > 0) {
            builder.append(tab.repeat(current)).append(value);
        } else {
            builder.append(value);
        }
    }

    public CodeStringBuilder add(CodeStringBuilder stringBuilder) {
        this.builder.append(stringBuilder.builder);
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    public void addImportMessage(String importMessage) {
        if (importMessage != null) {
            importMessages.add(importMessage);
        }
    }

    public void addImportMessages(Set<String> importMessage) {
        if (importMessage != null) {
            importMessages.addAll(importMessage);
        }
    }

    public Set<String> getImportMessages() {
        return importMessages;
    }

    public CodeStringBuilder newLine() {
        return newLine(1);
    }

    public CodeStringBuilder newLine(int count) {
        String line = this.line.append(System.lineSeparator().repeat(count)).toString();
        this.line.setLength(0);
        addLine(line);
        return this;
    }

    private void addLine(String value) {
//        String all = value.trim();
        String all = value.replaceAll(System.lineSeparator(), "").trim();
        if ((all.startsWith("}") && all.endsWith("{"))) {
            current--;
            if (current < 0) {
                current = 0;
            }
            append0(value);
            current++;
        } else if (all.endsWith("{")) {
            append0(value);
            current++;
        } else if (all.endsWith("}") || all.endsWith("});") || all.startsWith("} while")) {
            current--;
            if (current < 0) {
                current = 0;
            }
            append0(value);
        } else if (all.endsWith(":")) {
            append0(value);
            current++;
            lastChar = ':';
        } else if (lastChar == ':') {
            append0(value);
            current--;
            if (current < 0) {
                current = 0;
            }
            lastChar = 'a';
        } else {
            append0(value);
        }
    }
}