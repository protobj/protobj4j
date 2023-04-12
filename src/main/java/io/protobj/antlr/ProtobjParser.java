// Generated from /Users/chenqiang/IdeaProjects/framework/protobj/Protobj.g4 by ANTLR 4.10.1
package io.protobj.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProtobjParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, PACKAGE=2, REPEATED=3, MAP=4, BOOL=5, I8=6, U8=7, I16=8, U16=9, 
		I32=10, U32=11, S32=12, F32=13, SF32=14, I64=15, U64=16, S64=17, F64=18, 
		SF64=19, STRING=20, DOUBLE=21, FLOAT=22, ENUM=23, MESSAGE=24, EXTEND=25, 
		SET=26, ARRAY=27, DEFAULT=28, SEMI=29, EQ=30, LP=31, RP=32, LB=33, RB=34, 
		LC=35, RC=36, LT=37, GT=38, DOT=39, COMMA=40, COLON=41, PLUS=42, MINUS=43, 
		STR_LIT=44, BOOL_LIT=45, FLOAT_LIT=46, INT_LIT=47, IDENTIFIER=48, WS=49, 
		LINE_COMMENT=50, COMMENT=51;
	public static final int
		RULE_protobj = 0, RULE_packageStatement = 1, RULE_importStatement = 2, 
		RULE_optionName = 3, RULE_field = 4, RULE_modifier = 5, RULE_fieldOptions = 6, 
		RULE_fieldOption = 7, RULE_fieldNumber = 8, RULE_extendsField = 9, RULE_mapField = 10, 
		RULE_mapType = 11, RULE_keyType = 12, RULE_type_ = 13, RULE_topLevelDef = 14, 
		RULE_enumDef = 15, RULE_enumBody = 16, RULE_enumElement = 17, RULE_enumField = 18, 
		RULE_messageDef = 19, RULE_messageIndex = 20, RULE_messageBody = 21, RULE_messageElement = 22, 
		RULE_constant = 23, RULE_blockLit = 24, RULE_emptyStatement_ = 25, RULE_ident = 26, 
		RULE_fullIdent = 27, RULE_messageName = 28, RULE_enumName = 29, RULE_fieldName = 30, 
		RULE_mapName = 31, RULE_messageType = 32, RULE_enumType = 33, RULE_intLit = 34, 
		RULE_strLit = 35, RULE_boolLit = 36, RULE_floatLit = 37, RULE_keywords = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"protobj", "packageStatement", "importStatement", "optionName", "field", 
			"modifier", "fieldOptions", "fieldOption", "fieldNumber", "extendsField", 
			"mapField", "mapType", "keyType", "type_", "topLevelDef", "enumDef", 
			"enumBody", "enumElement", "enumField", "messageDef", "messageIndex", 
			"messageBody", "messageElement", "constant", "blockLit", "emptyStatement_", 
			"ident", "fullIdent", "messageName", "enumName", "fieldName", "mapName", 
			"messageType", "enumType", "intLit", "strLit", "boolLit", "floatLit", 
			"keywords"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'package'", "'lst'", "'map'", "'bool'", "'i8'", "'u8'", 
			"'i16'", "'u16'", "'i32'", "'u32'", "'s32'", "'f32'", "'sf32'", "'i64'", 
			"'u64'", "'s64'", "'f64'", "'sf64'", "'string'", "'double'", "'float'", 
			"'enum'", "'message'", "'ext'", "'set'", "'arr'", "'dft'", "';'", "'='", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'", "'.'", "','", 
			"':'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "PACKAGE", "REPEATED", "MAP", "BOOL", "I8", "U8", "I16", 
			"U16", "I32", "U32", "S32", "F32", "SF32", "I64", "U64", "S64", "F64", 
			"SF64", "STRING", "DOUBLE", "FLOAT", "ENUM", "MESSAGE", "EXTEND", "SET", 
			"ARRAY", "DEFAULT", "SEMI", "EQ", "LP", "RP", "LB", "RB", "LC", "RC", 
			"LT", "GT", "DOT", "COMMA", "COLON", "PLUS", "MINUS", "STR_LIT", "BOOL_LIT", 
			"FLOAT_LIT", "INT_LIT", "IDENTIFIER", "WS", "LINE_COMMENT", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Protobj.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProtobjParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProtobjContext extends ParserRuleContext {
		public PackageStatementContext packageStatement() {
			return getRuleContext(PackageStatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ProtobjParser.EOF, 0); }
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<TopLevelDefContext> topLevelDef() {
			return getRuleContexts(TopLevelDefContext.class);
		}
		public TopLevelDefContext topLevelDef(int i) {
			return getRuleContext(TopLevelDefContext.class,i);
		}
		public List<EmptyStatement_Context> emptyStatement_() {
			return getRuleContexts(EmptyStatement_Context.class);
		}
		public EmptyStatement_Context emptyStatement_(int i) {
			return getRuleContext(EmptyStatement_Context.class,i);
		}
		public ProtobjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_protobj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterProtobj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitProtobj(this);
		}
	}

	public final ProtobjContext protobj() throws RecognitionException {
		ProtobjContext _localctx = new ProtobjContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_protobj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			packageStatement();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << ENUM) | (1L << MESSAGE) | (1L << SEMI))) != 0)) {
				{
				setState(82);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IMPORT:
					{
					setState(79);
					importStatement();
					}
					break;
				case ENUM:
				case MESSAGE:
					{
					setState(80);
					topLevelDef();
					}
					break;
				case SEMI:
					{
					setState(81);
					emptyStatement_();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageStatementContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(ProtobjParser.PACKAGE, 0); }
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public PackageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterPackageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitPackageStatement(this);
		}
	}

	public final PackageStatementContext packageStatement() throws RecognitionException {
		PackageStatementContext _localctx = new PackageStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(PACKAGE);
			setState(90);
			fullIdent();
			setState(91);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ProtobjParser.IMPORT, 0); }
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(IMPORT);
			setState(94);
			fullIdent();
			setState(95);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionNameContext extends ParserRuleContext {
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public OptionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterOptionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitOptionName(this);
		}
	}

	public final OptionNameContext optionName() throws RecognitionException {
		OptionNameContext _localctx = new OptionNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_optionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			fullIdent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ProtobjParser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public TerminalNode LB() { return getToken(ProtobjParser.LB, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public TerminalNode RB() { return getToken(ProtobjParser.RB, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			modifier();
			setState(100);
			type_();
			setState(101);
			fieldName();
			setState(102);
			match(EQ);
			setState(103);
			fieldNumber();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(104);
				match(LB);
				setState(105);
				fieldOptions();
				setState(106);
				match(RB);
				}
			}

			setState(110);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode REPEATED() { return getToken(ProtobjParser.REPEATED, 0); }
		public TerminalNode SET() { return getToken(ProtobjParser.SET, 0); }
		public TerminalNode ARRAY() { return getToken(ProtobjParser.ARRAY, 0); }
		public TerminalNode DEFAULT() { return getToken(ProtobjParser.DEFAULT, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(112);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << REPEATED) | (1L << SET) | (1L << ARRAY) | (1L << DEFAULT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldOptionsContext extends ParserRuleContext {
		public List<FieldOptionContext> fieldOption() {
			return getRuleContexts(FieldOptionContext.class);
		}
		public FieldOptionContext fieldOption(int i) {
			return getRuleContext(FieldOptionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ProtobjParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ProtobjParser.COMMA, i);
		}
		public FieldOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterFieldOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitFieldOptions(this);
		}
	}

	public final FieldOptionsContext fieldOptions() throws RecognitionException {
		FieldOptionsContext _localctx = new FieldOptionsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			fieldOption();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				fieldOption();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ProtobjParser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FieldOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterFieldOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitFieldOption(this);
		}
	}

	public final FieldOptionContext fieldOption() throws RecognitionException {
		FieldOptionContext _localctx = new FieldOptionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			optionName();
			setState(124);
			match(EQ);
			setState(125);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNumberContext extends ParserRuleContext {
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public FieldNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterFieldNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitFieldNumber(this);
		}
	}

	public final FieldNumberContext fieldNumber() throws RecognitionException {
		FieldNumberContext _localctx = new FieldNumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			intLit();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtendsFieldContext extends ParserRuleContext {
		public TerminalNode EXTEND() { return getToken(ProtobjParser.EXTEND, 0); }
		public MessageTypeContext messageType() {
			return getRuleContext(MessageTypeContext.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ProtobjParser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public TerminalNode LB() { return getToken(ProtobjParser.LB, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public TerminalNode RB() { return getToken(ProtobjParser.RB, 0); }
		public ExtendsFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterExtendsField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitExtendsField(this);
		}
	}

	public final ExtendsFieldContext extendsField() throws RecognitionException {
		ExtendsFieldContext _localctx = new ExtendsFieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_extendsField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(EXTEND);
			setState(130);
			messageType();
			setState(131);
			fieldName();
			setState(132);
			match(EQ);
			setState(133);
			fieldNumber();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(134);
				match(LB);
				setState(135);
				fieldOptions();
				setState(136);
				match(RB);
				}
			}

			setState(140);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapFieldContext extends ParserRuleContext {
		public MapTypeContext mapType() {
			return getRuleContext(MapTypeContext.class,0);
		}
		public MapNameContext mapName() {
			return getRuleContext(MapNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ProtobjParser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public TerminalNode DEFAULT() { return getToken(ProtobjParser.DEFAULT, 0); }
		public TerminalNode LB() { return getToken(ProtobjParser.LB, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public TerminalNode RB() { return getToken(ProtobjParser.RB, 0); }
		public MapFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMapField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMapField(this);
		}
	}

	public final MapFieldContext mapField() throws RecognitionException {
		MapFieldContext _localctx = new MapFieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mapField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(142);
				match(DEFAULT);
				}
			}

			setState(145);
			mapType();
			setState(146);
			mapName();
			setState(147);
			match(EQ);
			setState(148);
			fieldNumber();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(149);
				match(LB);
				setState(150);
				fieldOptions();
				setState(151);
				match(RB);
				}
			}

			setState(155);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapTypeContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(ProtobjParser.MAP, 0); }
		public TerminalNode LT() { return getToken(ProtobjParser.LT, 0); }
		public KeyTypeContext keyType() {
			return getRuleContext(KeyTypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ProtobjParser.COMMA, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(ProtobjParser.GT, 0); }
		public MapTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMapType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMapType(this);
		}
	}

	public final MapTypeContext mapType() throws RecognitionException {
		MapTypeContext _localctx = new MapTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mapType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(MAP);
			setState(158);
			match(LT);
			setState(159);
			keyType();
			setState(160);
			match(COMMA);
			setState(161);
			type_();
			setState(162);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyTypeContext extends ParserRuleContext {
		public TerminalNode I8() { return getToken(ProtobjParser.I8, 0); }
		public TerminalNode U8() { return getToken(ProtobjParser.U8, 0); }
		public TerminalNode I16() { return getToken(ProtobjParser.I16, 0); }
		public TerminalNode U16() { return getToken(ProtobjParser.U16, 0); }
		public TerminalNode I32() { return getToken(ProtobjParser.I32, 0); }
		public TerminalNode U32() { return getToken(ProtobjParser.U32, 0); }
		public TerminalNode S32() { return getToken(ProtobjParser.S32, 0); }
		public TerminalNode F32() { return getToken(ProtobjParser.F32, 0); }
		public TerminalNode SF32() { return getToken(ProtobjParser.SF32, 0); }
		public TerminalNode I64() { return getToken(ProtobjParser.I64, 0); }
		public TerminalNode U64() { return getToken(ProtobjParser.U64, 0); }
		public TerminalNode S64() { return getToken(ProtobjParser.S64, 0); }
		public TerminalNode F64() { return getToken(ProtobjParser.F64, 0); }
		public TerminalNode SF64() { return getToken(ProtobjParser.SF64, 0); }
		public TerminalNode STRING() { return getToken(ProtobjParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(ProtobjParser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(ProtobjParser.FLOAT, 0); }
		public KeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterKeyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitKeyType(this);
		}
	}

	public final KeyTypeContext keyType() throws RecognitionException {
		KeyTypeContext _localctx = new KeyTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_keyType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << I8) | (1L << U8) | (1L << I16) | (1L << U16) | (1L << I32) | (1L << U32) | (1L << S32) | (1L << F32) | (1L << SF32) | (1L << I64) | (1L << U64) | (1L << S64) | (1L << F64) | (1L << SF64) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_Context extends ParserRuleContext {
		public KeyTypeContext keyType() {
			return getRuleContext(KeyTypeContext.class,0);
		}
		public MessageTypeContext messageType() {
			return getRuleContext(MessageTypeContext.class,0);
		}
		public EnumTypeContext enumType() {
			return getRuleContext(EnumTypeContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterType_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitType_(this);
		}
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_type_);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				keyType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				messageType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				enumType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelDefContext extends ParserRuleContext {
		public MessageDefContext messageDef() {
			return getRuleContext(MessageDefContext.class,0);
		}
		public EnumDefContext enumDef() {
			return getRuleContext(EnumDefContext.class,0);
		}
		public TopLevelDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterTopLevelDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitTopLevelDef(this);
		}
	}

	public final TopLevelDefContext topLevelDef() throws RecognitionException {
		TopLevelDefContext _localctx = new TopLevelDefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_topLevelDef);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				messageDef();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				enumDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDefContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(ProtobjParser.ENUM, 0); }
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public EnumDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEnumDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEnumDef(this);
		}
	}

	public final EnumDefContext enumDef() throws RecognitionException {
		EnumDefContext _localctx = new EnumDefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_enumDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(ENUM);
			setState(176);
			enumName();
			setState(177);
			enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(ProtobjParser.LC, 0); }
		public TerminalNode RC() { return getToken(ProtobjParser.RC, 0); }
		public List<EnumElementContext> enumElement() {
			return getRuleContexts(EnumElementContext.class);
		}
		public EnumElementContext enumElement(int i) {
			return getRuleContext(EnumElementContext.class,i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEnumBody(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(LC);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << PACKAGE) | (1L << REPEATED) | (1L << MAP) | (1L << BOOL) | (1L << I8) | (1L << U8) | (1L << I16) | (1L << U16) | (1L << I32) | (1L << U32) | (1L << S32) | (1L << F32) | (1L << SF32) | (1L << I64) | (1L << U64) | (1L << S64) | (1L << F64) | (1L << SF64) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << ENUM) | (1L << MESSAGE) | (1L << EXTEND) | (1L << SET) | (1L << ARRAY) | (1L << DEFAULT) | (1L << SEMI) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(180);
				enumElement();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(RC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumElementContext extends ParserRuleContext {
		public EnumFieldContext enumField() {
			return getRuleContext(EnumFieldContext.class,0);
		}
		public EmptyStatement_Context emptyStatement_() {
			return getRuleContext(EmptyStatement_Context.class,0);
		}
		public EnumElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEnumElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEnumElement(this);
		}
	}

	public final EnumElementContext enumElement() throws RecognitionException {
		EnumElementContext _localctx = new EnumElementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_enumElement);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case PACKAGE:
			case REPEATED:
			case MAP:
			case BOOL:
			case I8:
			case U8:
			case I16:
			case U16:
			case I32:
			case U32:
			case S32:
			case F32:
			case SF32:
			case I64:
			case U64:
			case S64:
			case F64:
			case SF64:
			case STRING:
			case DOUBLE:
			case FLOAT:
			case ENUM:
			case MESSAGE:
			case EXTEND:
			case SET:
			case ARRAY:
			case DEFAULT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				enumField();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				emptyStatement_();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumFieldContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ProtobjParser.EQ, 0); }
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public EnumFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEnumField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEnumField(this);
		}
	}

	public final EnumFieldContext enumField() throws RecognitionException {
		EnumFieldContext _localctx = new EnumFieldContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_enumField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			ident();
			setState(193);
			match(EQ);
			setState(194);
			intLit();
			setState(195);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageDefContext extends ParserRuleContext {
		public TerminalNode MESSAGE() { return getToken(ProtobjParser.MESSAGE, 0); }
		public MessageNameContext messageName() {
			return getRuleContext(MessageNameContext.class,0);
		}
		public MessageBodyContext messageBody() {
			return getRuleContext(MessageBodyContext.class,0);
		}
		public TerminalNode LB() { return getToken(ProtobjParser.LB, 0); }
		public MessageIndexContext messageIndex() {
			return getRuleContext(MessageIndexContext.class,0);
		}
		public TerminalNode RB() { return getToken(ProtobjParser.RB, 0); }
		public MessageDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMessageDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMessageDef(this);
		}
	}

	public final MessageDefContext messageDef() throws RecognitionException {
		MessageDefContext _localctx = new MessageDefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_messageDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(MESSAGE);
			setState(198);
			messageName();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(199);
				match(LB);
				setState(200);
				messageIndex();
				setState(201);
				match(RB);
				}
			}

			setState(205);
			messageBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageIndexContext extends ParserRuleContext {
		public TerminalNode INT_LIT() { return getToken(ProtobjParser.INT_LIT, 0); }
		public MessageIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMessageIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMessageIndex(this);
		}
	}

	public final MessageIndexContext messageIndex() throws RecognitionException {
		MessageIndexContext _localctx = new MessageIndexContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_messageIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(INT_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageBodyContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(ProtobjParser.LC, 0); }
		public TerminalNode RC() { return getToken(ProtobjParser.RC, 0); }
		public List<MessageElementContext> messageElement() {
			return getRuleContexts(MessageElementContext.class);
		}
		public MessageElementContext messageElement(int i) {
			return getRuleContext(MessageElementContext.class,i);
		}
		public MessageBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMessageBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMessageBody(this);
		}
	}

	public final MessageBodyContext messageBody() throws RecognitionException {
		MessageBodyContext _localctx = new MessageBodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_messageBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(LC);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << PACKAGE) | (1L << REPEATED) | (1L << MAP) | (1L << BOOL) | (1L << I8) | (1L << U8) | (1L << I16) | (1L << U16) | (1L << I32) | (1L << U32) | (1L << S32) | (1L << F32) | (1L << SF32) | (1L << I64) | (1L << U64) | (1L << S64) | (1L << F64) | (1L << SF64) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << ENUM) | (1L << MESSAGE) | (1L << EXTEND) | (1L << SET) | (1L << ARRAY) | (1L << DEFAULT) | (1L << SEMI) | (1L << DOT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(210);
				messageElement();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(RC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageElementContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ExtendsFieldContext extendsField() {
			return getRuleContext(ExtendsFieldContext.class,0);
		}
		public MapFieldContext mapField() {
			return getRuleContext(MapFieldContext.class,0);
		}
		public EmptyStatement_Context emptyStatement_() {
			return getRuleContext(EmptyStatement_Context.class,0);
		}
		public MessageElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMessageElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMessageElement(this);
		}
	}

	public final MessageElementContext messageElement() throws RecognitionException {
		MessageElementContext _localctx = new MessageElementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_messageElement);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				field();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				extendsField();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				mapField();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				emptyStatement_();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(ProtobjParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(ProtobjParser.PLUS, 0); }
		public FloatLitContext floatLit() {
			return getRuleContext(FloatLitContext.class,0);
		}
		public StrLitContext strLit() {
			return getRuleContext(StrLitContext.class,0);
		}
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public BlockLitContext blockLit() {
			return getRuleContext(BlockLitContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constant);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				fullIdent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(225);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(228);
				intLit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(229);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(232);
				floatLit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				strLit();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				boolLit();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(235);
				blockLit();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockLitContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(ProtobjParser.LC, 0); }
		public TerminalNode RC() { return getToken(ProtobjParser.RC, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ProtobjParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ProtobjParser.COLON, i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public BlockLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterBlockLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitBlockLit(this);
		}
	}

	public final BlockLitContext blockLit() throws RecognitionException {
		BlockLitContext _localctx = new BlockLitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_blockLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(LC);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << PACKAGE) | (1L << REPEATED) | (1L << MAP) | (1L << BOOL) | (1L << I8) | (1L << U8) | (1L << I16) | (1L << U16) | (1L << I32) | (1L << U32) | (1L << S32) | (1L << F32) | (1L << SF32) | (1L << I64) | (1L << U64) | (1L << S64) | (1L << F64) | (1L << SF64) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << ENUM) | (1L << MESSAGE) | (1L << EXTEND) | (1L << SET) | (1L << ARRAY) | (1L << DEFAULT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(239);
				ident();
				setState(240);
				match(COLON);
				setState(241);
				constant();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(RC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatement_Context extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(ProtobjParser.SEMI, 0); }
		public EmptyStatement_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEmptyStatement_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEmptyStatement_(this);
		}
	}

	public final EmptyStatement_Context emptyStatement_() throws RecognitionException {
		EmptyStatement_Context _localctx = new EmptyStatement_Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_emptyStatement_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ProtobjParser.IDENTIFIER, 0); }
		public KeywordsContext keywords() {
			return getRuleContext(KeywordsContext.class,0);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitIdent(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_ident);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(IDENTIFIER);
				}
				break;
			case IMPORT:
			case PACKAGE:
			case REPEATED:
			case MAP:
			case BOOL:
			case I8:
			case U8:
			case I16:
			case U16:
			case I32:
			case U32:
			case S32:
			case F32:
			case SF32:
			case I64:
			case U64:
			case S64:
			case F64:
			case SF64:
			case STRING:
			case DOUBLE:
			case FLOAT:
			case ENUM:
			case MESSAGE:
			case EXTEND:
			case SET:
			case ARRAY:
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				keywords();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullIdentContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ProtobjParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ProtobjParser.DOT, i);
		}
		public FullIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterFullIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitFullIdent(this);
		}
	}

	public final FullIdentContext fullIdent() throws RecognitionException {
		FullIdentContext _localctx = new FullIdentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fullIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			ident();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(257);
				match(DOT);
				setState(258);
				ident();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public MessageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMessageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMessageName(this);
		}
	}

	public final MessageNameContext messageName() throws RecognitionException {
		MessageNameContext _localctx = new MessageNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_messageName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public EnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEnumName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEnumName(this);
		}
	}

	public final EnumNameContext enumName() throws RecognitionException {
		EnumNameContext _localctx = new EnumNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_enumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public MapNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMapName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMapName(this);
		}
	}

	public final MapNameContext mapName() throws RecognitionException {
		MapNameContext _localctx = new MapNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_mapName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageTypeContext extends ParserRuleContext {
		public MessageNameContext messageName() {
			return getRuleContext(MessageNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(ProtobjParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ProtobjParser.DOT, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public MessageTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterMessageType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitMessageType(this);
		}
	}

	public final MessageTypeContext messageType() throws RecognitionException {
		MessageTypeContext _localctx = new MessageTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_messageType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(272);
				match(DOT);
				}
			}

			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(275);
					ident();
					setState(276);
					match(DOT);
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(283);
			messageName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumTypeContext extends ParserRuleContext {
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(ProtobjParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ProtobjParser.DOT, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public EnumTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitEnumType(this);
		}
	}

	public final EnumTypeContext enumType() throws RecognitionException {
		EnumTypeContext _localctx = new EnumTypeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_enumType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(285);
				match(DOT);
				}
			}

			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(288);
					ident();
					setState(289);
					match(DOT);
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(296);
			enumName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntLitContext extends ParserRuleContext {
		public TerminalNode INT_LIT() { return getToken(ProtobjParser.INT_LIT, 0); }
		public IntLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitIntLit(this);
		}
	}

	public final IntLitContext intLit() throws RecognitionException {
		IntLitContext _localctx = new IntLitContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_intLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(INT_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrLitContext extends ParserRuleContext {
		public TerminalNode STR_LIT() { return getToken(ProtobjParser.STR_LIT, 0); }
		public StrLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterStrLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitStrLit(this);
		}
	}

	public final StrLitContext strLit() throws RecognitionException {
		StrLitContext _localctx = new StrLitContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_strLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(STR_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLitContext extends ParserRuleContext {
		public TerminalNode BOOL_LIT() { return getToken(ProtobjParser.BOOL_LIT, 0); }
		public BoolLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterBoolLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitBoolLit(this);
		}
	}

	public final BoolLitContext boolLit() throws RecognitionException {
		BoolLitContext _localctx = new BoolLitContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_boolLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(BOOL_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatLitContext extends ParserRuleContext {
		public TerminalNode FLOAT_LIT() { return getToken(ProtobjParser.FLOAT_LIT, 0); }
		public FloatLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterFloatLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitFloatLit(this);
		}
	}

	public final FloatLitContext floatLit() throws RecognitionException {
		FloatLitContext _localctx = new FloatLitContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_floatLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(FLOAT_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordsContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ProtobjParser.IMPORT, 0); }
		public TerminalNode PACKAGE() { return getToken(ProtobjParser.PACKAGE, 0); }
		public TerminalNode REPEATED() { return getToken(ProtobjParser.REPEATED, 0); }
		public TerminalNode MAP() { return getToken(ProtobjParser.MAP, 0); }
		public TerminalNode BOOL() { return getToken(ProtobjParser.BOOL, 0); }
		public TerminalNode I8() { return getToken(ProtobjParser.I8, 0); }
		public TerminalNode U8() { return getToken(ProtobjParser.U8, 0); }
		public TerminalNode I16() { return getToken(ProtobjParser.I16, 0); }
		public TerminalNode U16() { return getToken(ProtobjParser.U16, 0); }
		public TerminalNode I32() { return getToken(ProtobjParser.I32, 0); }
		public TerminalNode U32() { return getToken(ProtobjParser.U32, 0); }
		public TerminalNode S32() { return getToken(ProtobjParser.S32, 0); }
		public TerminalNode F32() { return getToken(ProtobjParser.F32, 0); }
		public TerminalNode SF32() { return getToken(ProtobjParser.SF32, 0); }
		public TerminalNode I64() { return getToken(ProtobjParser.I64, 0); }
		public TerminalNode U64() { return getToken(ProtobjParser.U64, 0); }
		public TerminalNode S64() { return getToken(ProtobjParser.S64, 0); }
		public TerminalNode F64() { return getToken(ProtobjParser.F64, 0); }
		public TerminalNode SF64() { return getToken(ProtobjParser.SF64, 0); }
		public TerminalNode STRING() { return getToken(ProtobjParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(ProtobjParser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(ProtobjParser.FLOAT, 0); }
		public TerminalNode ENUM() { return getToken(ProtobjParser.ENUM, 0); }
		public TerminalNode MESSAGE() { return getToken(ProtobjParser.MESSAGE, 0); }
		public TerminalNode EXTEND() { return getToken(ProtobjParser.EXTEND, 0); }
		public TerminalNode SET() { return getToken(ProtobjParser.SET, 0); }
		public TerminalNode ARRAY() { return getToken(ProtobjParser.ARRAY, 0); }
		public TerminalNode DEFAULT() { return getToken(ProtobjParser.DEFAULT, 0); }
		public KeywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).enterKeywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobjListener ) ((ProtobjListener)listener).exitKeywords(this);
		}
	}

	public final KeywordsContext keywords() throws RecognitionException {
		KeywordsContext _localctx = new KeywordsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << PACKAGE) | (1L << REPEATED) | (1L << MAP) | (1L << BOOL) | (1L << I8) | (1L << U8) | (1L << I16) | (1L << U16) | (1L << I32) | (1L << U32) | (1L << S32) | (1L << F32) | (1L << SF32) | (1L << I64) | (1L << U64) | (1L << S64) | (1L << F64) | (1L << SF64) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << ENUM) | (1L << MESSAGE) | (1L << EXTEND) | (1L << SET) | (1L << ARRAY) | (1L << DEFAULT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u0135\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000S\b\u0000\n\u0000\f\u0000V\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004m\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0003\u0005r\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006w\b\u0006\n\u0006\f\u0006z\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008b\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0003\n\u0090\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u009a\b\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\r\u00aa\b\r\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00ae\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00b6\b\u0010\n\u0010"+
		"\f\u0010\u00b9\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00bf\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00cc\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00d4\b\u0015\n\u0015"+
		"\f\u0015\u00d7\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00df\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u00e3\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00e7\b"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00ed"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u00f4\b\u0018\n\u0018\f\u0018\u00f7\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u00ff\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0104\b\u001b\n\u001b"+
		"\f\u001b\u0107\t\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0003 \u0112\b"+
		" \u0001 \u0001 \u0001 \u0005 \u0117\b \n \f \u011a\t \u0001 \u0001 \u0001"+
		"!\u0003!\u011f\b!\u0001!\u0001!\u0001!\u0005!\u0124\b!\n!\f!\u0127\t!"+
		"\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0000\u0000\'\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJL\u0000\u0004\u0002\u0000\u0003\u0003\u001a\u001c\u0001\u0000\u0006"+
		"\u0016\u0001\u0000*+\u0001\u0000\u0001\u001c\u012e\u0000N\u0001\u0000"+
		"\u0000\u0000\u0002Y\u0001\u0000\u0000\u0000\u0004]\u0001\u0000\u0000\u0000"+
		"\u0006a\u0001\u0000\u0000\u0000\bc\u0001\u0000\u0000\u0000\nq\u0001\u0000"+
		"\u0000\u0000\fs\u0001\u0000\u0000\u0000\u000e{\u0001\u0000\u0000\u0000"+
		"\u0010\u007f\u0001\u0000\u0000\u0000\u0012\u0081\u0001\u0000\u0000\u0000"+
		"\u0014\u008f\u0001\u0000\u0000\u0000\u0016\u009d\u0001\u0000\u0000\u0000"+
		"\u0018\u00a4\u0001\u0000\u0000\u0000\u001a\u00a9\u0001\u0000\u0000\u0000"+
		"\u001c\u00ad\u0001\u0000\u0000\u0000\u001e\u00af\u0001\u0000\u0000\u0000"+
		" \u00b3\u0001\u0000\u0000\u0000\"\u00be\u0001\u0000\u0000\u0000$\u00c0"+
		"\u0001\u0000\u0000\u0000&\u00c5\u0001\u0000\u0000\u0000(\u00cf\u0001\u0000"+
		"\u0000\u0000*\u00d1\u0001\u0000\u0000\u0000,\u00de\u0001\u0000\u0000\u0000"+
		".\u00ec\u0001\u0000\u0000\u00000\u00ee\u0001\u0000\u0000\u00002\u00fa"+
		"\u0001\u0000\u0000\u00004\u00fe\u0001\u0000\u0000\u00006\u0100\u0001\u0000"+
		"\u0000\u00008\u0108\u0001\u0000\u0000\u0000:\u010a\u0001\u0000\u0000\u0000"+
		"<\u010c\u0001\u0000\u0000\u0000>\u010e\u0001\u0000\u0000\u0000@\u0111"+
		"\u0001\u0000\u0000\u0000B\u011e\u0001\u0000\u0000\u0000D\u012a\u0001\u0000"+
		"\u0000\u0000F\u012c\u0001\u0000\u0000\u0000H\u012e\u0001\u0000\u0000\u0000"+
		"J\u0130\u0001\u0000\u0000\u0000L\u0132\u0001\u0000\u0000\u0000NT\u0003"+
		"\u0002\u0001\u0000OS\u0003\u0004\u0002\u0000PS\u0003\u001c\u000e\u0000"+
		"QS\u00032\u0019\u0000RO\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000WX\u0005\u0000\u0000\u0001X\u0001\u0001\u0000\u0000\u0000"+
		"YZ\u0005\u0002\u0000\u0000Z[\u00036\u001b\u0000[\\\u0005\u001d\u0000\u0000"+
		"\\\u0003\u0001\u0000\u0000\u0000]^\u0005\u0001\u0000\u0000^_\u00036\u001b"+
		"\u0000_`\u0005\u001d\u0000\u0000`\u0005\u0001\u0000\u0000\u0000ab\u0003"+
		"6\u001b\u0000b\u0007\u0001\u0000\u0000\u0000cd\u0003\n\u0005\u0000de\u0003"+
		"\u001a\r\u0000ef\u0003<\u001e\u0000fg\u0005\u001e\u0000\u0000gl\u0003"+
		"\u0010\b\u0000hi\u0005!\u0000\u0000ij\u0003\f\u0006\u0000jk\u0005\"\u0000"+
		"\u0000km\u0001\u0000\u0000\u0000lh\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005\u001d\u0000\u0000o\t\u0001"+
		"\u0000\u0000\u0000pr\u0007\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u000b\u0001\u0000\u0000\u0000sx\u0003\u000e"+
		"\u0007\u0000tu\u0005(\u0000\u0000uw\u0003\u000e\u0007\u0000vt\u0001\u0000"+
		"\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000y\r\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000"+
		"{|\u0003\u0006\u0003\u0000|}\u0005\u001e\u0000\u0000}~\u0003.\u0017\u0000"+
		"~\u000f\u0001\u0000\u0000\u0000\u007f\u0080\u0003D\"\u0000\u0080\u0011"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0019\u0000\u0000\u0082\u0083"+
		"\u0003@ \u0000\u0083\u0084\u0003<\u001e\u0000\u0084\u0085\u0005\u001e"+
		"\u0000\u0000\u0085\u008a\u0003\u0010\b\u0000\u0086\u0087\u0005!\u0000"+
		"\u0000\u0087\u0088\u0003\f\u0006\u0000\u0088\u0089\u0005\"\u0000\u0000"+
		"\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0086\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\u001d\u0000\u0000\u008d\u0013\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0005\u001c\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0003\u0016\u000b\u0000\u0092\u0093\u0003>\u001f\u0000\u0093"+
		"\u0094\u0005\u001e\u0000\u0000\u0094\u0099\u0003\u0010\b\u0000\u0095\u0096"+
		"\u0005!\u0000\u0000\u0096\u0097\u0003\f\u0006\u0000\u0097\u0098\u0005"+
		"\"\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0095\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0005\u001d\u0000\u0000\u009c\u0015\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005\u0004\u0000\u0000\u009e\u009f\u0005%\u0000"+
		"\u0000\u009f\u00a0\u0003\u0018\f\u0000\u00a0\u00a1\u0005(\u0000\u0000"+
		"\u00a1\u00a2\u0003\u001a\r\u0000\u00a2\u00a3\u0005&\u0000\u0000\u00a3"+
		"\u0017\u0001\u0000\u0000\u0000\u00a4\u00a5\u0007\u0001\u0000\u0000\u00a5"+
		"\u0019\u0001\u0000\u0000\u0000\u00a6\u00aa\u0003\u0018\f\u0000\u00a7\u00aa"+
		"\u0003@ \u0000\u00a8\u00aa\u0003B!\u0000\u00a9\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u001b\u0001\u0000\u0000\u0000\u00ab\u00ae\u0003&\u0013\u0000"+
		"\u00ac\u00ae\u0003\u001e\u000f\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u001d\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0005\u0017\u0000\u0000\u00b0\u00b1\u0003:\u001d\u0000\u00b1"+
		"\u00b2\u0003 \u0010\u0000\u00b2\u001f\u0001\u0000\u0000\u0000\u00b3\u00b7"+
		"\u0005#\u0000\u0000\u00b4\u00b6\u0003\"\u0011\u0000\u00b5\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005"+
		"$\u0000\u0000\u00bb!\u0001\u0000\u0000\u0000\u00bc\u00bf\u0003$\u0012"+
		"\u0000\u00bd\u00bf\u00032\u0019\u0000\u00be\u00bc\u0001\u0000\u0000\u0000"+
		"\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf#\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u00034\u001a\u0000\u00c1\u00c2\u0005\u001e\u0000\u0000\u00c2\u00c3"+
		"\u0003D\"\u0000\u00c3\u00c4\u0005\u001d\u0000\u0000\u00c4%\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0018\u0000\u0000\u00c6\u00cb\u00038\u001c"+
		"\u0000\u00c7\u00c8\u0005!\u0000\u0000\u00c8\u00c9\u0003(\u0014\u0000\u00c9"+
		"\u00ca\u0005\"\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c7"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0003*\u0015\u0000\u00ce\'\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005/\u0000\u0000\u00d0)\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d5\u0005#\u0000\u0000\u00d2\u00d4\u0003,\u0016\u0000\u00d3"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0005$\u0000\u0000\u00d9+\u0001\u0000\u0000\u0000\u00da\u00df\u0003"+
		"\b\u0004\u0000\u00db\u00df\u0003\u0012\t\u0000\u00dc\u00df\u0003\u0014"+
		"\n\u0000\u00dd\u00df\u00032\u0019\u0000\u00de\u00da\u0001\u0000\u0000"+
		"\u0000\u00de\u00db\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df-\u0001\u0000\u0000\u0000"+
		"\u00e0\u00ed\u00036\u001b\u0000\u00e1\u00e3\u0007\u0002\u0000\u0000\u00e2"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e4\u00ed\u0003D\"\u0000\u00e5\u00e7"+
		"\u0007\u0002\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00ed"+
		"\u0003J%\u0000\u00e9\u00ed\u0003F#\u0000\u00ea\u00ed\u0003H$\u0000\u00eb"+
		"\u00ed\u00030\u0018\u0000\u00ec\u00e0\u0001\u0000\u0000\u0000\u00ec\u00e2"+
		"\u0001\u0000\u0000\u0000\u00ec\u00e6\u0001\u0000\u0000\u0000\u00ec\u00e9"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ed/\u0001\u0000\u0000\u0000\u00ee\u00f5\u0005"+
		"#\u0000\u0000\u00ef\u00f0\u00034\u001a\u0000\u00f0\u00f1\u0005)\u0000"+
		"\u0000\u00f1\u00f2\u0003.\u0017\u0000\u00f2\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f3\u00ef\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0005$\u0000\u0000\u00f91\u0001\u0000\u0000\u0000\u00fa\u00fb"+
		"\u0005\u001d\u0000\u0000\u00fb3\u0001\u0000\u0000\u0000\u00fc\u00ff\u0005"+
		"0\u0000\u0000\u00fd\u00ff\u0003L&\u0000\u00fe\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff5\u0001\u0000\u0000\u0000"+
		"\u0100\u0105\u00034\u001a\u0000\u0101\u0102\u0005\'\u0000\u0000\u0102"+
		"\u0104\u00034\u001a\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0107"+
		"\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0001\u0000\u0000\u0000\u01067\u0001\u0000\u0000\u0000\u0107\u0105\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u00034\u001a\u0000\u01099\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u00034\u001a\u0000\u010b;\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u00034\u001a\u0000\u010d=\u0001\u0000\u0000\u0000\u010e\u010f\u0003"+
		"4\u001a\u0000\u010f?\u0001\u0000\u0000\u0000\u0110\u0112\u0005\'\u0000"+
		"\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000"+
		"\u0000\u0112\u0118\u0001\u0000\u0000\u0000\u0113\u0114\u00034\u001a\u0000"+
		"\u0114\u0115\u0005\'\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116"+
		"\u0113\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119"+
		"\u011b\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b"+
		"\u011c\u00038\u001c\u0000\u011cA\u0001\u0000\u0000\u0000\u011d\u011f\u0005"+
		"\'\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000"+
		"\u0000\u0000\u011f\u0125\u0001\u0000\u0000\u0000\u0120\u0121\u00034\u001a"+
		"\u0000\u0121\u0122\u0005\'\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000"+
		"\u0123\u0120\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000"+
		"\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000"+
		"\u0126\u0128\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\u0003:\u001d\u0000\u0129C\u0001\u0000\u0000\u0000\u012a\u012b"+
		"\u0005/\u0000\u0000\u012bE\u0001\u0000\u0000\u0000\u012c\u012d\u0005,"+
		"\u0000\u0000\u012dG\u0001\u0000\u0000\u0000\u012e\u012f\u0005-\u0000\u0000"+
		"\u012fI\u0001\u0000\u0000\u0000\u0130\u0131\u0005.\u0000\u0000\u0131K"+
		"\u0001\u0000\u0000\u0000\u0132\u0133\u0007\u0003\u0000\u0000\u0133M\u0001"+
		"\u0000\u0000\u0000\u0019RTlqx\u008a\u008f\u0099\u00a9\u00ad\u00b7\u00be"+
		"\u00cb\u00d5\u00de\u00e2\u00e6\u00ec\u00f5\u00fe\u0105\u0111\u0118\u011e"+
		"\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}