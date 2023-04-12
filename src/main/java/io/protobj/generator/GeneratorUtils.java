package io.protobj.generator;

import io.protobj.config.LanguageType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GeneratorUtils {
    private final static Pattern FORMAT_PATTERN = Pattern.compile("[$]\\{(?<key>.*?)}");

    public static void writeFile(LanguageType languageType, String fileName, String outputDir, String pkg, String content) throws IOException {
        String separator = File.separator;
        Path path = Paths.get(outputDir, pkg.replaceAll("\\.", separator), "%s.%s".formatted(fileName, languageType.getFileSuffix()));
        File file = path.toFile();
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            if (!mkdirs) {
                throw new RuntimeException("file cant create %s".formatted(file.getParentFile()));
            }
        }
        Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }


    public static String firstUpper(String type) {
        return type.substring(0, 1).toUpperCase() + type.substring(1);
    }

    //indexed
    public static String i(String format, Object... params) {
        if (params.length == 0) {
            return format;
        }
        return replace(format, t -> params[Integer.parseInt(t)]);
    }

    //named
    public static String n(String format, Map<String, ?> params) {
        if (params == null || params.size() == 0) {
            return format;
        }
        return replace(format, params::get);
    }

    //named
    public static String n(String format, Object... params) {
        if (params == null || params.length == 0) {
            return format;
        }
        if ((params.length & 1) != 0) { // implicit nullcheck of input
            throw new InternalError("length is odd");
        }
        return replace(format, (key) -> {
            for (int i = 0; i < params.length; i++) {
                if (key.endsWith(params[i].toString())) {
                    return params[i + 1];
                }
            }
            throw new RuntimeException("not found key [%s] ".formatted(key));
        });
    }

    public static String replace(String format, Function<String, ?> valueGet) {
        StringBuilder buf = new StringBuilder();
        Matcher matcher = FORMAT_PATTERN.matcher(format);
        while (matcher.find()) {
            String namedParam = matcher.group("key");
            Object value = valueGet.apply(namedParam);
            try {
                matcher.appendReplacement(buf, value == null ? "" : value.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        matcher.appendTail(buf);
        return buf.toString();
    }
}
