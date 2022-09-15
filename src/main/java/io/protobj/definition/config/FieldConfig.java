package io.protobj.definition.config;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.option.FieldOption;
import io.protobj.definition.option.FieldOptionValue;
import io.protobj.generator.GeneratorUtils;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther chenqiang
 * @date 2022/8/12
 */
public class FieldConfig {
    private Modifier modifier = Modifier.DFT;

    private String typeName;

    private String typeFullName;

    private String keyType;
    private String valueTypeName;
    private String valueTypeFullName;
    private String fieldName;

    private int fieldNum;

    private Map<FieldOption, FieldOptionValue> options = new HashMap<>();

    private String description;

    private String definition;

    public FieldConfig() {
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(String fieldNum) {
        this.fieldNum = Integer.parseInt(fieldNum);
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    public Map<FieldOption, FieldOptionValue> getOptions() {
        return options;
    }

    public void setOptions(Map<FieldOption, FieldOptionValue> options) {
        this.options = options;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getTypeFullName() {
        return typeFullName;
    }

    public void setTypeFullName(String typeFullName) {
        this.typeFullName = typeFullName;
    }

    public String getValueTypeName() {
        return valueTypeName;
    }

    public void setValueTypeName(String valueTypeName) {
        this.valueTypeName = valueTypeName;
    }

    public String getValueTypeFullName() {
        return valueTypeFullName;
    }

    public void setValueTypeFullName(String valueTypeFullName) {
        this.valueTypeFullName = valueTypeFullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefinition() {
        if (description != null) {
            return "//%s %s".formatted(definition, description);
        }
        return "//%s".formatted(definition);
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void initDefinition(ParserRuleContext context) {
        if (context.getChildCount() == 0) {
            setDefinition("");
            return;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < context.getChildCount(); i++) {
            builder.append(context.getChild(i).getText()).append(" ");
        }

        setDefinition(builder.toString());
    }

    public String getFirstUpperFieldName() {
        return GeneratorUtils.firstUpper(this.fieldName);
    }

    public FieldOptionValue getOption(FieldOption fieldOption) {
        return options.get(fieldOption);
    }

    public boolean isPolymorphic() {
        return getOption(FieldOption.polymorphic) != null;
    }


    public String getMessageName() {
        return FieldType.getBuiltinType(getTypeName()) == FieldType.MAP ? getValueTypeName() : getTypeName();
    }

    public String getMessageFullName() {
        return FieldType.getBuiltinType(getTypeName()) == FieldType.MAP ? getValueTypeFullName() : getTypeFullName();
    }
}
