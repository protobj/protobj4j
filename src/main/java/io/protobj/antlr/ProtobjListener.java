// Generated from D:/code/protobj/protobj-java/src/main/resources\Protobj.g4 by ANTLR 4.10.1
package io.protobj.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProtobjParser}.
 */
public interface ProtobjListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#protobj}.
	 * @param ctx the parse tree
	 */
	void enterProtobj(ProtobjParser.ProtobjContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#protobj}.
	 * @param ctx the parse tree
	 */
	void exitProtobj(ProtobjParser.ProtobjContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#packageStatement}.
	 * @param ctx the parse tree
	 */
	void enterPackageStatement(ProtobjParser.PackageStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#packageStatement}.
	 * @param ctx the parse tree
	 */
	void exitPackageStatement(ProtobjParser.PackageStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(ProtobjParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(ProtobjParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#optionName}.
	 * @param ctx the parse tree
	 */
	void enterOptionName(ProtobjParser.OptionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#optionName}.
	 * @param ctx the parse tree
	 */
	void exitOptionName(ProtobjParser.OptionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ProtobjParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ProtobjParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(ProtobjParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(ProtobjParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#fieldOptions}.
	 * @param ctx the parse tree
	 */
	void enterFieldOptions(ProtobjParser.FieldOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#fieldOptions}.
	 * @param ctx the parse tree
	 */
	void exitFieldOptions(ProtobjParser.FieldOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#fieldOption}.
	 * @param ctx the parse tree
	 */
	void enterFieldOption(ProtobjParser.FieldOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#fieldOption}.
	 * @param ctx the parse tree
	 */
	void exitFieldOption(ProtobjParser.FieldOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#fieldNumber}.
	 * @param ctx the parse tree
	 */
	void enterFieldNumber(ProtobjParser.FieldNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#fieldNumber}.
	 * @param ctx the parse tree
	 */
	void exitFieldNumber(ProtobjParser.FieldNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#extendsField}.
	 * @param ctx the parse tree
	 */
	void enterExtendsField(ProtobjParser.ExtendsFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#extendsField}.
	 * @param ctx the parse tree
	 */
	void exitExtendsField(ProtobjParser.ExtendsFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#mapField}.
	 * @param ctx the parse tree
	 */
	void enterMapField(ProtobjParser.MapFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#mapField}.
	 * @param ctx the parse tree
	 */
	void exitMapField(ProtobjParser.MapFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#mapType}.
	 * @param ctx the parse tree
	 */
	void enterMapType(ProtobjParser.MapTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#mapType}.
	 * @param ctx the parse tree
	 */
	void exitMapType(ProtobjParser.MapTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#keyType}.
	 * @param ctx the parse tree
	 */
	void enterKeyType(ProtobjParser.KeyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#keyType}.
	 * @param ctx the parse tree
	 */
	void exitKeyType(ProtobjParser.KeyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#type_}.
	 * @param ctx the parse tree
	 */
	void enterType_(ProtobjParser.Type_Context ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#type_}.
	 * @param ctx the parse tree
	 */
	void exitType_(ProtobjParser.Type_Context ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#topLevelDef}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDef(ProtobjParser.TopLevelDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#topLevelDef}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDef(ProtobjParser.TopLevelDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#enumDef}.
	 * @param ctx the parse tree
	 */
	void enterEnumDef(ProtobjParser.EnumDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#enumDef}.
	 * @param ctx the parse tree
	 */
	void exitEnumDef(ProtobjParser.EnumDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(ProtobjParser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(ProtobjParser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#enumElement}.
	 * @param ctx the parse tree
	 */
	void enterEnumElement(ProtobjParser.EnumElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#enumElement}.
	 * @param ctx the parse tree
	 */
	void exitEnumElement(ProtobjParser.EnumElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#enumField}.
	 * @param ctx the parse tree
	 */
	void enterEnumField(ProtobjParser.EnumFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#enumField}.
	 * @param ctx the parse tree
	 */
	void exitEnumField(ProtobjParser.EnumFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#messageDef}.
	 * @param ctx the parse tree
	 */
	void enterMessageDef(ProtobjParser.MessageDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#messageDef}.
	 * @param ctx the parse tree
	 */
	void exitMessageDef(ProtobjParser.MessageDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#messageIndex}.
	 * @param ctx the parse tree
	 */
	void enterMessageIndex(ProtobjParser.MessageIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#messageIndex}.
	 * @param ctx the parse tree
	 */
	void exitMessageIndex(ProtobjParser.MessageIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#messageBody}.
	 * @param ctx the parse tree
	 */
	void enterMessageBody(ProtobjParser.MessageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#messageBody}.
	 * @param ctx the parse tree
	 */
	void exitMessageBody(ProtobjParser.MessageBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#messageElement}.
	 * @param ctx the parse tree
	 */
	void enterMessageElement(ProtobjParser.MessageElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#messageElement}.
	 * @param ctx the parse tree
	 */
	void exitMessageElement(ProtobjParser.MessageElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(ProtobjParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(ProtobjParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#blockLit}.
	 * @param ctx the parse tree
	 */
	void enterBlockLit(ProtobjParser.BlockLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#blockLit}.
	 * @param ctx the parse tree
	 */
	void exitBlockLit(ProtobjParser.BlockLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(ProtobjParser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(ProtobjParser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(ProtobjParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(ProtobjParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#fullIdent}.
	 * @param ctx the parse tree
	 */
	void enterFullIdent(ProtobjParser.FullIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#fullIdent}.
	 * @param ctx the parse tree
	 */
	void exitFullIdent(ProtobjParser.FullIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#messageName}.
	 * @param ctx the parse tree
	 */
	void enterMessageName(ProtobjParser.MessageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#messageName}.
	 * @param ctx the parse tree
	 */
	void exitMessageName(ProtobjParser.MessageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#enumName}.
	 * @param ctx the parse tree
	 */
	void enterEnumName(ProtobjParser.EnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#enumName}.
	 * @param ctx the parse tree
	 */
	void exitEnumName(ProtobjParser.EnumNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(ProtobjParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(ProtobjParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#mapName}.
	 * @param ctx the parse tree
	 */
	void enterMapName(ProtobjParser.MapNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#mapName}.
	 * @param ctx the parse tree
	 */
	void exitMapName(ProtobjParser.MapNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#messageType}.
	 * @param ctx the parse tree
	 */
	void enterMessageType(ProtobjParser.MessageTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#messageType}.
	 * @param ctx the parse tree
	 */
	void exitMessageType(ProtobjParser.MessageTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#enumType}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(ProtobjParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#enumType}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(ProtobjParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#intLit}.
	 * @param ctx the parse tree
	 */
	void enterIntLit(ProtobjParser.IntLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#intLit}.
	 * @param ctx the parse tree
	 */
	void exitIntLit(ProtobjParser.IntLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#strLit}.
	 * @param ctx the parse tree
	 */
	void enterStrLit(ProtobjParser.StrLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#strLit}.
	 * @param ctx the parse tree
	 */
	void exitStrLit(ProtobjParser.StrLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#boolLit}.
	 * @param ctx the parse tree
	 */
	void enterBoolLit(ProtobjParser.BoolLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#boolLit}.
	 * @param ctx the parse tree
	 */
	void exitBoolLit(ProtobjParser.BoolLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#floatLit}.
	 * @param ctx the parse tree
	 */
	void enterFloatLit(ProtobjParser.FloatLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#floatLit}.
	 * @param ctx the parse tree
	 */
	void exitFloatLit(ProtobjParser.FloatLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobjParser#keywords}.
	 * @param ctx the parse tree
	 */
	void enterKeywords(ProtobjParser.KeywordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobjParser#keywords}.
	 * @param ctx the parse tree
	 */
	void exitKeywords(ProtobjParser.KeywordsContext ctx);
}