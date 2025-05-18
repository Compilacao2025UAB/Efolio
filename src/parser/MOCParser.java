// Generated from d:/_UAb/Ano_3/2Sem/21018 - Compilação/2104775_EfolioB/Efolio/src/MOC.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MOCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, DOT=2, COMA=3, SEMICOLON=4, LEFTBRACE=5, RIGHTBRACE=6, LEFTBRACKET=7, 
		RIGHTBRACKET=8, LEFTPARENTESIS=9, RIGHTPARENTESIS=10, ASSIGN=11, BLOCKCOMMENT=12, 
		LINECOMMENT=13, ADD=14, SUBTRACT=15, MULTIPLY=16, DIVIDE=17, MODULE=18, 
		NOT=19, AND=20, OR=21, LT=22, GT=23, LEQ=24, GEQ=25, EQUAL=26, NOTEQUAL=27, 
		INT=28, DOUBLE=29, VOID=30, RETURN=31, DOUBLE_LITERAL=32, INT_LITERAL=33, 
		CHAR_LITERAL=34, STRING_LITERAL=35, IF=36, ELSE=37, WHILE=38, FOR=39, 
		WRITE=40, WRITEC=41, WRITEV=42, WRITES=43, READ=44, READC=45, READS=46, 
		IDENTIFIER=47, DIGIT=48, SPACE=49;
	public static final int
		RULE_program = 0, RULE_localFuncDecl = 1, RULE_localFuncDef = 2, RULE_statement = 3, 
		RULE_blockStatement = 4, RULE_returnStatement = 5, RULE_readStatement = 6, 
		RULE_writeStatement = 7, RULE_assignment = 8, RULE_assignable = 9, RULE_expression = 10, 
		RULE_assExpr = 11, RULE_orExpr = 12, RULE_andExpr = 13, RULE_relExpr = 14, 
		RULE_addExpr = 15, RULE_mulExpr = 16, RULE_unaryExpr = 17, RULE_castExpr = 18, 
		RULE_primeExpr = 19, RULE_intLiteral = 20, RULE_doubleLiteral = 21, RULE_charLiteral = 22, 
		RULE_stringLiteral = 23, RULE_expressionList = 24, RULE_funcDeclaration = 25, 
		RULE_funcDefinition = 26, RULE_readFunc = 27, RULE_parameterList = 28, 
		RULE_parameter = 29, RULE_funcType = 30, RULE_declaration = 31, RULE_variableInit = 32, 
		RULE_arrayLiteral = 33, RULE_varType = 34, RULE_loop = 35, RULE_conditional = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "localFuncDecl", "localFuncDef", "statement", "blockStatement", 
			"returnStatement", "readStatement", "writeStatement", "assignment", "assignable", 
			"expression", "assExpr", "orExpr", "andExpr", "relExpr", "addExpr", "mulExpr", 
			"unaryExpr", "castExpr", "primeExpr", "intLiteral", "doubleLiteral", 
			"charLiteral", "stringLiteral", "expressionList", "funcDeclaration", 
			"funcDefinition", "readFunc", "parameterList", "parameter", "funcType", 
			"declaration", "variableInit", "arrayLiteral", "varType", "loop", "conditional"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'.'", "','", "';'", "'{'", "'}'", "'['", "']'", "'('", "')'", 
			"'='", null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'&&'", 
			"'||'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'int'", "'double'", 
			"'void'", "'return'", null, null, null, null, "'if'", "'else'", "'while'", 
			"'for'", "'write'", "'writec'", "'writev'", "'writes'", "'read'", "'readc'", 
			"'reads'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "DOT", "COMA", "SEMICOLON", "LEFTBRACE", "RIGHTBRACE", 
			"LEFTBRACKET", "RIGHTBRACKET", "LEFTPARENTESIS", "RIGHTPARENTESIS", "ASSIGN", 
			"BLOCKCOMMENT", "LINECOMMENT", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", 
			"MODULE", "NOT", "AND", "OR", "LT", "GT", "LEQ", "GEQ", "EQUAL", "NOTEQUAL", 
			"INT", "DOUBLE", "VOID", "RETURN", "DOUBLE_LITERAL", "INT_LITERAL", "CHAR_LITERAL", 
			"STRING_LITERAL", "IF", "ELSE", "WHILE", "FOR", "WRITE", "WRITEC", "WRITEV", 
			"WRITES", "READ", "READC", "READS", "IDENTIFIER", "DIGIT", "SPACE"
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
	public String getGrammarFileName() { return "MOC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MOCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MOCParser.EOF, 0); }
		public List<FuncDeclarationContext> funcDeclaration() {
			return getRuleContexts(FuncDeclarationContext.class);
		}
		public FuncDeclarationContext funcDeclaration(int i) {
			return getRuleContext(FuncDeclarationContext.class,i);
		}
		public List<FuncDefinitionContext> funcDefinition() {
			return getRuleContexts(FuncDefinitionContext.class);
		}
		public FuncDefinitionContext funcDefinition(int i) {
			return getRuleContext(FuncDefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281337269879328L) != 0)) {
				{
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(74);
					funcDeclaration();
					}
					break;
				case 2:
					{
					setState(75);
					funcDefinition();
					}
					break;
				case 3:
					{
					setState(76);
					statement();
					}
					break;
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalFuncDeclContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public LocalFuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localFuncDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterLocalFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitLocalFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitLocalFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalFuncDeclContext localFuncDecl() throws RecognitionException {
		LocalFuncDeclContext _localctx = new LocalFuncDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_localFuncDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			funcType();
			setState(85);
			match(IDENTIFIER);
			setState(86);
			match(LEFTPARENTESIS);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				setState(87);
				parameterList();
				}
			}

			setState(90);
			match(RIGHTPARENTESIS);
			setState(91);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalFuncDefContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public LocalFuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localFuncDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterLocalFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitLocalFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitLocalFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalFuncDefContext localFuncDef() throws RecognitionException {
		LocalFuncDefContext _localctx = new LocalFuncDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_localFuncDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			funcType();
			setState(94);
			match(IDENTIFIER);
			setState(95);
			match(LEFTPARENTESIS);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				setState(96);
				parameterList();
				}
			}

			setState(99);
			match(RIGHTPARENTESIS);
			setState(100);
			blockStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public LocalFuncDeclContext localFuncDecl() {
			return getRuleContext(LocalFuncDeclContext.class,0);
		}
		public LocalFuncDefContext localFuncDef() {
			return getRuleContext(LocalFuncDefContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				readStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				writeStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				localFuncDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				localFuncDef();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				assignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				declaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				loop();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(109);
				conditional();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(110);
				returnStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(111);
				blockStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(112);
				expression();
				setState(113);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LEFTBRACE() { return getToken(MOCParser.LEFTBRACE, 0); }
		public TerminalNode RIGHTBRACE() { return getToken(MOCParser.RIGHTBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(LEFTBRACE);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281337269879328L) != 0)) {
				{
				{
				setState(118);
				statement();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(RIGHTBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MOCParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(RETURN);
			setState(127);
			expression();
			setState(128);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadStatementContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MOCParser.READ, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public TerminalNode READC() { return getToken(MOCParser.READC, 0); }
		public TerminalNode READS() { return getToken(MOCParser.READS, 0); }
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitReadStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitReadStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_readStatement);
		try {
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(READ);
				setState(131);
				match(LEFTPARENTESIS);
				setState(132);
				match(IDENTIFIER);
				setState(133);
				match(RIGHTPARENTESIS);
				setState(134);
				match(SEMICOLON);
				}
				break;
			case READC:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(READC);
				setState(136);
				match(LEFTPARENTESIS);
				setState(137);
				match(IDENTIFIER);
				setState(138);
				match(RIGHTPARENTESIS);
				setState(139);
				match(SEMICOLON);
				}
				break;
			case READS:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(READS);
				setState(141);
				match(LEFTPARENTESIS);
				setState(142);
				match(IDENTIFIER);
				setState(143);
				match(RIGHTPARENTESIS);
				setState(144);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStatementContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MOCParser.WRITE, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public TerminalNode WRITEC() { return getToken(MOCParser.WRITEC, 0); }
		public TerminalNode WRITEV() { return getToken(MOCParser.WRITEV, 0); }
		public TerminalNode WRITES() { return getToken(MOCParser.WRITES, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MOCParser.STRING_LITERAL, 0); }
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitWriteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_writeStatement);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(WRITE);
				setState(148);
				match(LEFTPARENTESIS);
				setState(149);
				expression();
				setState(150);
				match(RIGHTPARENTESIS);
				setState(151);
				match(SEMICOLON);
				}
				break;
			case WRITEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(WRITEC);
				setState(154);
				match(LEFTPARENTESIS);
				setState(155);
				expression();
				setState(156);
				match(RIGHTPARENTESIS);
				setState(157);
				match(SEMICOLON);
				}
				break;
			case WRITEV:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(WRITEV);
				setState(160);
				match(LEFTPARENTESIS);
				setState(161);
				expression();
				setState(162);
				match(RIGHTPARENTESIS);
				setState(163);
				match(SEMICOLON);
				}
				break;
			case WRITES:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				match(WRITES);
				setState(166);
				match(LEFTPARENTESIS);
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(167);
					expression();
					}
					break;
				case 2:
					{
					setState(168);
					match(STRING_LITERAL);
					}
					break;
				}
				setState(171);
				match(RIGHTPARENTESIS);
				setState(172);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MOCParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			assignable();
			setState(176);
			match(ASSIGN);
			setState(177);
			expression();
			setState(178);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(MOCParser.LEFTBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHTBRACKET() { return getToken(MOCParser.RIGHTBRACKET, 0); }
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitAssignable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitAssignable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignable);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(IDENTIFIER);
				setState(182);
				match(LEFTBRACKET);
				setState(183);
				expression();
				setState(184);
				match(RIGHTBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public AssExprContext assExpr() {
			return getRuleContext(AssExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			assExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssExprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MOCParser.ASSIGN, 0); }
		public AssExprContext assExpr() {
			return getRuleContext(AssExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public AssExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterAssExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitAssExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitAssExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssExprContext assExpr() throws RecognitionException {
		AssExprContext _localctx = new AssExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assExpr);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(IDENTIFIER);
				setState(191);
				match(ASSIGN);
				setState(192);
				assExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				orExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(MOCParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MOCParser.OR, i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			andExpr();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(197);
				match(OR);
				setState(198);
				andExpr();
				}
				}
				setState(203);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ParserRuleContext {
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MOCParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MOCParser.AND, i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			relExpr();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(205);
				match(AND);
				setState(206);
				relExpr();
				}
				}
				setState(211);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelExprContext extends ParserRuleContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public List<TerminalNode> LT() { return getTokens(MOCParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(MOCParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(MOCParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(MOCParser.GT, i);
		}
		public List<TerminalNode> LEQ() { return getTokens(MOCParser.LEQ); }
		public TerminalNode LEQ(int i) {
			return getToken(MOCParser.LEQ, i);
		}
		public List<TerminalNode> GEQ() { return getTokens(MOCParser.GEQ); }
		public TerminalNode GEQ(int i) {
			return getToken(MOCParser.GEQ, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(MOCParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(MOCParser.EQUAL, i);
		}
		public List<TerminalNode> NOTEQUAL() { return getTokens(MOCParser.NOTEQUAL); }
		public TerminalNode NOTEQUAL(int i) {
			return getToken(MOCParser.NOTEQUAL, i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitRelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			addExpr();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264241152L) != 0)) {
				{
				{
				setState(213);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 264241152L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				addExpr();
				}
				}
				setState(219);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ParserRuleContext {
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(MOCParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(MOCParser.ADD, i);
		}
		public List<TerminalNode> SUBTRACT() { return getTokens(MOCParser.SUBTRACT); }
		public TerminalNode SUBTRACT(int i) {
			return getToken(MOCParser.SUBTRACT, i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			mulExpr();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(221);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUBTRACT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(222);
				mulExpr();
				}
				}
				setState(227);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(MOCParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(MOCParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(MOCParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(MOCParser.DIVIDE, i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			unaryExpr();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(229);
				_la = _input.LA(1);
				if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(230);
				unaryExpr();
				}
				}
				setState(235);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(MOCParser.NOT, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public TerminalNode SUBTRACT() { return getToken(MOCParser.SUBTRACT, 0); }
		public CastExprContext castExpr() {
			return getRuleContext(CastExprContext.class,0);
		}
		public PrimeExprContext primeExpr() {
			return getRuleContext(PrimeExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unaryExpr);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(NOT);
				setState(237);
				unaryExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(SUBTRACT);
				setState(239);
				unaryExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				castExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				primeExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CastExprContext extends ParserRuleContext {
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public CastExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExprContext castExpr() throws RecognitionException {
		CastExprContext _localctx = new CastExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_castExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(LEFTPARENTESIS);
			setState(245);
			varType();
			setState(246);
			match(RIGHTPARENTESIS);
			setState(247);
			unaryExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimeExprContext extends ParserRuleContext {
		public ReadFuncContext readFunc() {
			return getRuleContext(ReadFuncContext.class,0);
		}
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(MOCParser.LEFTBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHTBRACKET() { return getToken(MOCParser.RIGHTBRACKET, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public IntLiteralContext intLiteral() {
			return getRuleContext(IntLiteralContext.class,0);
		}
		public DoubleLiteralContext doubleLiteral() {
			return getRuleContext(DoubleLiteralContext.class,0);
		}
		public CharLiteralContext charLiteral() {
			return getRuleContext(CharLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode LEFTBRACE() { return getToken(MOCParser.LEFTBRACE, 0); }
		public TerminalNode RIGHTBRACE() { return getToken(MOCParser.RIGHTBRACE, 0); }
		public PrimeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterPrimeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitPrimeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitPrimeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimeExprContext primeExpr() throws RecognitionException {
		PrimeExprContext _localctx = new PrimeExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primeExpr);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				readFunc();
				setState(250);
				match(LEFTPARENTESIS);
				setState(251);
				match(RIGHTPARENTESIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(IDENTIFIER);
				setState(254);
				match(LEFTBRACKET);
				setState(255);
				expression();
				setState(256);
				match(RIGHTBRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				match(IDENTIFIER);
				setState(259);
				match(LEFTPARENTESIS);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 263947215733280L) != 0)) {
					{
					setState(260);
					expressionList();
					}
				}

				setState(263);
				match(RIGHTPARENTESIS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				match(IDENTIFIER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				intLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(266);
				doubleLiteral();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(267);
				charLiteral();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(268);
				stringLiteral();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(269);
				match(LEFTPARENTESIS);
				setState(270);
				expression();
				setState(271);
				match(RIGHTPARENTESIS);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(273);
				match(LEFTBRACE);
				setState(274);
				expressionList();
				setState(275);
				match(RIGHTBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(MOCParser.INT_LITERAL, 0); }
		public IntLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntLiteralContext intLiteral() throws RecognitionException {
		IntLiteralContext _localctx = new IntLiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_intLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(INT_LITERAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoubleLiteralContext extends ParserRuleContext {
		public TerminalNode DOUBLE_LITERAL() { return getToken(MOCParser.DOUBLE_LITERAL, 0); }
		public DoubleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleLiteralContext doubleLiteral() throws RecognitionException {
		DoubleLiteralContext _localctx = new DoubleLiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_doubleLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(DOUBLE_LITERAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CharLiteralContext extends ParserRuleContext {
		public TerminalNode CHAR_LITERAL() { return getToken(MOCParser.CHAR_LITERAL, 0); }
		public CharLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitCharLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharLiteralContext charLiteral() throws RecognitionException {
		CharLiteralContext _localctx = new CharLiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_charLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(CHAR_LITERAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(MOCParser.STRING_LITERAL, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(STRING_LITERAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MOCParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MOCParser.COMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			expression();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(288);
				match(COMA);
				setState(289);
				expression();
				}
				}
				setState(294);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclarationContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FuncDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterFuncDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitFuncDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitFuncDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclarationContext funcDeclaration() throws RecognitionException {
		FuncDeclarationContext _localctx = new FuncDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_funcDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			funcType();
			setState(296);
			match(IDENTIFIER);
			setState(297);
			match(LEFTPARENTESIS);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				setState(298);
				parameterList();
				}
			}

			setState(301);
			match(RIGHTPARENTESIS);
			setState(302);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefinitionContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FuncDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterFuncDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitFuncDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitFuncDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefinitionContext funcDefinition() throws RecognitionException {
		FuncDefinitionContext _localctx = new FuncDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_funcDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			funcType();
			setState(305);
			match(IDENTIFIER);
			setState(306);
			match(LEFTPARENTESIS);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				setState(307);
				parameterList();
				}
			}

			setState(310);
			match(RIGHTPARENTESIS);
			setState(311);
			blockStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadFuncContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MOCParser.READ, 0); }
		public TerminalNode READC() { return getToken(MOCParser.READC, 0); }
		public TerminalNode READS() { return getToken(MOCParser.READS, 0); }
		public ReadFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterReadFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitReadFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitReadFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadFuncContext readFunc() throws RecognitionException {
		ReadFuncContext _localctx = new ReadFuncContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_readFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MOCParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MOCParser.COMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			parameter();
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(316);
				match(COMA);
				setState(317);
				parameter();
				}
				}
				setState(322);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(MOCParser.LEFTBRACKET, 0); }
		public TerminalNode RIGHTBRACKET() { return getToken(MOCParser.RIGHTBRACKET, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_parameter);
		int _la;
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				funcType();
				setState(324);
				match(IDENTIFIER);
				setState(325);
				match(LEFTBRACKET);
				setState(326);
				match(RIGHTBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				funcType();
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(329);
					match(IDENTIFIER);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncTypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MOCParser.VOID, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_funcType);
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(VOID);
				}
				break;
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				varType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<VariableInitContext> variableInit() {
			return getRuleContexts(VariableInitContext.class);
		}
		public VariableInitContext variableInit(int i) {
			return getRuleContext(VariableInitContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(MOCParser.SEMICOLON, 0); }
		public List<TerminalNode> COMA() { return getTokens(MOCParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MOCParser.COMA, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			varType();
			setState(339);
			variableInit();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(340);
				match(COMA);
				setState(341);
				variableInit();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(347);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableInitContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MOCParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MOCParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFTBRACKET() { return getToken(MOCParser.LEFTBRACKET, 0); }
		public TerminalNode RIGHTBRACKET() { return getToken(MOCParser.RIGHTBRACKET, 0); }
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public VariableInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterVariableInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitVariableInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitVariableInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitContext variableInit() throws RecognitionException {
		VariableInitContext _localctx = new VariableInitContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_variableInit);
		int _la;
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				match(IDENTIFIER);
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(350);
					match(ASSIGN);
					setState(351);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				match(IDENTIFIER);
				setState(355);
				match(LEFTBRACKET);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 263947215733280L) != 0)) {
					{
					setState(356);
					expression();
					}
				}

				setState(359);
				match(RIGHTBRACKET);
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(360);
					match(ASSIGN);
					setState(363);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						setState(361);
						arrayLiteral();
						}
						break;
					case 2:
						{
						setState(362);
						expression();
						}
						break;
					}
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LEFTBRACE() { return getToken(MOCParser.LEFTBRACE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RIGHTBRACE() { return getToken(MOCParser.RIGHTBRACE, 0); }
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arrayLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(LEFTBRACE);
			setState(370);
			expressionList();
			setState(371);
			match(RIGHTBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MOCParser.INT, 0); }
		public TerminalNode LEFTBRACKET() { return getToken(MOCParser.LEFTBRACKET, 0); }
		public TerminalNode RIGHTBRACKET() { return getToken(MOCParser.RIGHTBRACKET, 0); }
		public TerminalNode DOUBLE() { return getToken(MOCParser.DOUBLE, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_varType);
		int _la;
		try {
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(INT);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFTBRACKET) {
					{
					setState(374);
					match(LEFTBRACKET);
					setState(375);
					match(RIGHTBRACKET);
					}
				}

				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				match(DOUBLE);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFTBRACKET) {
					{
					setState(379);
					match(LEFTBRACKET);
					setState(380);
					match(RIGHTBRACKET);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MOCParser.FOR, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MOCParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MOCParser.SEMICOLON, i);
		}
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MOCParser.WHILE, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_loop);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				match(FOR);
				setState(386);
				match(LEFTPARENTESIS);
				setState(387);
				expression();
				setState(388);
				match(SEMICOLON);
				setState(389);
				expression();
				setState(390);
				match(SEMICOLON);
				setState(391);
				expression();
				setState(392);
				match(RIGHTPARENTESIS);
				setState(393);
				blockStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				match(WHILE);
				setState(396);
				match(LEFTPARENTESIS);
				setState(397);
				expression();
				setState(398);
				match(RIGHTPARENTESIS);
				setState(399);
				blockStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MOCParser.IF, 0); }
		public TerminalNode LEFTPARENTESIS() { return getToken(MOCParser.LEFTPARENTESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHTPARENTESIS() { return getToken(MOCParser.RIGHTPARENTESIS, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MOCParser.ELSE, 0); }
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MOCListener ) ((MOCListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MOCVisitor ) return ((MOCVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(IF);
			setState(404);
			match(LEFTPARENTESIS);
			setState(405);
			expression();
			setState(406);
			match(RIGHTPARENTESIS);
			setState(407);
			blockStatement();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(408);
				match(ELSE);
				setState(409);
				blockStatement();
				}
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
		"\u0004\u00011\u019d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"N\b\u0000\n\u0000\f\u0000Q\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001Y\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002b\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003t\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004x\b\u0004\n\u0004"+
		"\f\u0004{\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0092"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00aa"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ae\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00bb\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00c3\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f"+
		"\u00c8\b\f\n\f\f\f\u00cb\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u00d0\b\r"+
		"\n\r\f\r\u00d3\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00d8"+
		"\b\u000e\n\u000e\f\u000e\u00db\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u00e0\b\u000f\n\u000f\f\u000f\u00e3\t\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00e8\b\u0010\n\u0010\f\u0010\u00eb\t\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00f3\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0106\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0116\b\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0123\b\u0018\n\u0018\f\u0018\u0126\t\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u012c\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0135\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u013f\b\u001c\n"+
		"\u001c\f\u001c\u0142\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u014b\b\u001d\u0003"+
		"\u001d\u014d\b\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u0151\b\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0157\b\u001f"+
		"\n\u001f\f\u001f\u015a\t\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0003 \u0161\b \u0001 \u0001 \u0001 \u0003 \u0166\b \u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u016c\b \u0003 \u016e\b \u0003 \u0170\b \u0001!\u0001"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0003\"\u0179\b\"\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u017e\b\"\u0003\"\u0180\b\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0003#\u0192\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u019b\b$\u0001$\u0000\u0000%\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFH\u0000\u0004\u0001\u0000\u0016\u001b\u0001\u0000\u000e\u000f"+
		"\u0001\u0000\u0010\u0011\u0001\u0000,.\u01b3\u0000O\u0001\u0000\u0000"+
		"\u0000\u0002T\u0001\u0000\u0000\u0000\u0004]\u0001\u0000\u0000\u0000\u0006"+
		"s\u0001\u0000\u0000\u0000\bu\u0001\u0000\u0000\u0000\n~\u0001\u0000\u0000"+
		"\u0000\f\u0091\u0001\u0000\u0000\u0000\u000e\u00ad\u0001\u0000\u0000\u0000"+
		"\u0010\u00af\u0001\u0000\u0000\u0000\u0012\u00ba\u0001\u0000\u0000\u0000"+
		"\u0014\u00bc\u0001\u0000\u0000\u0000\u0016\u00c2\u0001\u0000\u0000\u0000"+
		"\u0018\u00c4\u0001\u0000\u0000\u0000\u001a\u00cc\u0001\u0000\u0000\u0000"+
		"\u001c\u00d4\u0001\u0000\u0000\u0000\u001e\u00dc\u0001\u0000\u0000\u0000"+
		" \u00e4\u0001\u0000\u0000\u0000\"\u00f2\u0001\u0000\u0000\u0000$\u00f4"+
		"\u0001\u0000\u0000\u0000&\u0115\u0001\u0000\u0000\u0000(\u0117\u0001\u0000"+
		"\u0000\u0000*\u0119\u0001\u0000\u0000\u0000,\u011b\u0001\u0000\u0000\u0000"+
		".\u011d\u0001\u0000\u0000\u00000\u011f\u0001\u0000\u0000\u00002\u0127"+
		"\u0001\u0000\u0000\u00004\u0130\u0001\u0000\u0000\u00006\u0139\u0001\u0000"+
		"\u0000\u00008\u013b\u0001\u0000\u0000\u0000:\u014c\u0001\u0000\u0000\u0000"+
		"<\u0150\u0001\u0000\u0000\u0000>\u0152\u0001\u0000\u0000\u0000@\u016f"+
		"\u0001\u0000\u0000\u0000B\u0171\u0001\u0000\u0000\u0000D\u017f\u0001\u0000"+
		"\u0000\u0000F\u0191\u0001\u0000\u0000\u0000H\u0193\u0001\u0000\u0000\u0000"+
		"JN\u00032\u0019\u0000KN\u00034\u001a\u0000LN\u0003\u0006\u0003\u0000M"+
		"J\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005"+
		"\u0000\u0000\u0001S\u0001\u0001\u0000\u0000\u0000TU\u0003<\u001e\u0000"+
		"UV\u0005/\u0000\u0000VX\u0005\t\u0000\u0000WY\u00038\u001c\u0000XW\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0005\n\u0000\u0000[\\\u0005\u0004\u0000\u0000\\\u0003\u0001\u0000"+
		"\u0000\u0000]^\u0003<\u001e\u0000^_\u0005/\u0000\u0000_a\u0005\t\u0000"+
		"\u0000`b\u00038\u001c\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0005\n\u0000\u0000de\u0003\b\u0004"+
		"\u0000e\u0005\u0001\u0000\u0000\u0000ft\u0003\f\u0006\u0000gt\u0003\u000e"+
		"\u0007\u0000ht\u0003\u0002\u0001\u0000it\u0003\u0004\u0002\u0000jt\u0003"+
		"\u0010\b\u0000kt\u0003>\u001f\u0000lt\u0003F#\u0000mt\u0003H$\u0000nt"+
		"\u0003\n\u0005\u0000ot\u0003\b\u0004\u0000pq\u0003\u0014\n\u0000qr\u0005"+
		"\u0004\u0000\u0000rt\u0001\u0000\u0000\u0000sf\u0001\u0000\u0000\u0000"+
		"sg\u0001\u0000\u0000\u0000sh\u0001\u0000\u0000\u0000si\u0001\u0000\u0000"+
		"\u0000sj\u0001\u0000\u0000\u0000sk\u0001\u0000\u0000\u0000sl\u0001\u0000"+
		"\u0000\u0000sm\u0001\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000so\u0001"+
		"\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000t\u0007\u0001\u0000\u0000"+
		"\u0000uy\u0005\u0005\u0000\u0000vx\u0003\u0006\u0003\u0000wv\u0001\u0000"+
		"\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"|}\u0005\u0006\u0000\u0000}\t\u0001\u0000\u0000\u0000~\u007f\u0005\u001f"+
		"\u0000\u0000\u007f\u0080\u0003\u0014\n\u0000\u0080\u0081\u0005\u0004\u0000"+
		"\u0000\u0081\u000b\u0001\u0000\u0000\u0000\u0082\u0083\u0005,\u0000\u0000"+
		"\u0083\u0084\u0005\t\u0000\u0000\u0084\u0085\u0005/\u0000\u0000\u0085"+
		"\u0086\u0005\n\u0000\u0000\u0086\u0092\u0005\u0004\u0000\u0000\u0087\u0088"+
		"\u0005-\u0000\u0000\u0088\u0089\u0005\t\u0000\u0000\u0089\u008a\u0005"+
		"/\u0000\u0000\u008a\u008b\u0005\n\u0000\u0000\u008b\u0092\u0005\u0004"+
		"\u0000\u0000\u008c\u008d\u0005.\u0000\u0000\u008d\u008e\u0005\t\u0000"+
		"\u0000\u008e\u008f\u0005/\u0000\u0000\u008f\u0090\u0005\n\u0000\u0000"+
		"\u0090\u0092\u0005\u0004\u0000\u0000\u0091\u0082\u0001\u0000\u0000\u0000"+
		"\u0091\u0087\u0001\u0000\u0000\u0000\u0091\u008c\u0001\u0000\u0000\u0000"+
		"\u0092\r\u0001\u0000\u0000\u0000\u0093\u0094\u0005(\u0000\u0000\u0094"+
		"\u0095\u0005\t\u0000\u0000\u0095\u0096\u0003\u0014\n\u0000\u0096\u0097"+
		"\u0005\n\u0000\u0000\u0097\u0098\u0005\u0004\u0000\u0000\u0098\u00ae\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0005)\u0000\u0000\u009a\u009b\u0005\t"+
		"\u0000\u0000\u009b\u009c\u0003\u0014\n\u0000\u009c\u009d\u0005\n\u0000"+
		"\u0000\u009d\u009e\u0005\u0004\u0000\u0000\u009e\u00ae\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0005*\u0000\u0000\u00a0\u00a1\u0005\t\u0000\u0000"+
		"\u00a1\u00a2\u0003\u0014\n\u0000\u00a2\u00a3\u0005\n\u0000\u0000\u00a3"+
		"\u00a4\u0005\u0004\u0000\u0000\u00a4\u00ae\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005+\u0000\u0000\u00a6\u00a9\u0005\t\u0000\u0000\u00a7\u00aa"+
		"\u0003\u0014\n\u0000\u00a8\u00aa\u0005#\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0005\n\u0000\u0000\u00ac\u00ae\u0005\u0004"+
		"\u0000\u0000\u00ad\u0093\u0001\u0000\u0000\u0000\u00ad\u0099\u0001\u0000"+
		"\u0000\u0000\u00ad\u009f\u0001\u0000\u0000\u0000\u00ad\u00a5\u0001\u0000"+
		"\u0000\u0000\u00ae\u000f\u0001\u0000\u0000\u0000\u00af\u00b0\u0003\u0012"+
		"\t\u0000\u00b0\u00b1\u0005\u000b\u0000\u0000\u00b1\u00b2\u0003\u0014\n"+
		"\u0000\u00b2\u00b3\u0005\u0004\u0000\u0000\u00b3\u0011\u0001\u0000\u0000"+
		"\u0000\u00b4\u00bb\u0005/\u0000\u0000\u00b5\u00b6\u0005/\u0000\u0000\u00b6"+
		"\u00b7\u0005\u0007\u0000\u0000\u00b7\u00b8\u0003\u0014\n\u0000\u00b8\u00b9"+
		"\u0005\b\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b4\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b5\u0001\u0000\u0000\u0000\u00bb\u0013\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0003\u0016\u000b\u0000\u00bd\u0015\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0005/\u0000\u0000\u00bf\u00c0\u0005\u000b"+
		"\u0000\u0000\u00c0\u00c3\u0003\u0016\u000b\u0000\u00c1\u00c3\u0003\u0018"+
		"\f\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c3\u0017\u0001\u0000\u0000\u0000\u00c4\u00c9\u0003\u001a\r\u0000"+
		"\u00c5\u00c6\u0005\u0015\u0000\u0000\u00c6\u00c8\u0003\u001a\r\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\u0019\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00d1\u0003\u001c\u000e\u0000\u00cd\u00ce\u0005\u0014\u0000\u0000\u00ce"+
		"\u00d0\u0003\u001c\u000e\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d2\u001b\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d9\u0003\u001e\u000f\u0000\u00d5"+
		"\u00d6\u0007\u0000\u0000\u0000\u00d6\u00d8\u0003\u001e\u000f\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\u001d\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00e1\u0003 \u0010\u0000\u00dd\u00de\u0007\u0001\u0000\u0000\u00de\u00e0"+
		"\u0003 \u0010\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e2\u001f\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e9\u0003\"\u0011\u0000\u00e5\u00e6\u0007\u0002"+
		"\u0000\u0000\u00e6\u00e8\u0003\"\u0011\u0000\u00e7\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea!\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0013\u0000\u0000"+
		"\u00ed\u00f3\u0003\"\u0011\u0000\u00ee\u00ef\u0005\u000f\u0000\u0000\u00ef"+
		"\u00f3\u0003\"\u0011\u0000\u00f0\u00f3\u0003$\u0012\u0000\u00f1\u00f3"+
		"\u0003&\u0013\u0000\u00f2\u00ec\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3#\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\t"+
		"\u0000\u0000\u00f5\u00f6\u0003D\"\u0000\u00f6\u00f7\u0005\n\u0000\u0000"+
		"\u00f7\u00f8\u0003\"\u0011\u0000\u00f8%\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u00036\u001b\u0000\u00fa\u00fb\u0005\t\u0000\u0000\u00fb\u00fc"+
		"\u0005\n\u0000\u0000\u00fc\u0116\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005"+
		"/\u0000\u0000\u00fe\u00ff\u0005\u0007\u0000\u0000\u00ff\u0100\u0003\u0014"+
		"\n\u0000\u0100\u0101\u0005\b\u0000\u0000\u0101\u0116\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0005/\u0000\u0000\u0103\u0105\u0005\t\u0000\u0000"+
		"\u0104\u0106\u00030\u0018\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107"+
		"\u0116\u0005\n\u0000\u0000\u0108\u0116\u0005/\u0000\u0000\u0109\u0116"+
		"\u0003(\u0014\u0000\u010a\u0116\u0003*\u0015\u0000\u010b\u0116\u0003,"+
		"\u0016\u0000\u010c\u0116\u0003.\u0017\u0000\u010d\u010e\u0005\t\u0000"+
		"\u0000\u010e\u010f\u0003\u0014\n\u0000\u010f\u0110\u0005\n\u0000\u0000"+
		"\u0110\u0116\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u0005\u0000\u0000"+
		"\u0112\u0113\u00030\u0018\u0000\u0113\u0114\u0005\u0006\u0000\u0000\u0114"+
		"\u0116\u0001\u0000\u0000\u0000\u0115\u00f9\u0001\u0000\u0000\u0000\u0115"+
		"\u00fd\u0001\u0000\u0000\u0000\u0115\u0102\u0001\u0000\u0000\u0000\u0115"+
		"\u0108\u0001\u0000\u0000\u0000\u0115\u0109\u0001\u0000\u0000\u0000\u0115"+
		"\u010a\u0001\u0000\u0000\u0000\u0115\u010b\u0001\u0000\u0000\u0000\u0115"+
		"\u010c\u0001\u0000\u0000\u0000\u0115\u010d\u0001\u0000\u0000\u0000\u0115"+
		"\u0111\u0001\u0000\u0000\u0000\u0116\'\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0005!\u0000\u0000\u0118)\u0001\u0000\u0000\u0000\u0119\u011a\u0005 "+
		"\u0000\u0000\u011a+\u0001\u0000\u0000\u0000\u011b\u011c\u0005\"\u0000"+
		"\u0000\u011c-\u0001\u0000\u0000\u0000\u011d\u011e\u0005#\u0000\u0000\u011e"+
		"/\u0001\u0000\u0000\u0000\u011f\u0124\u0003\u0014\n\u0000\u0120\u0121"+
		"\u0005\u0003\u0000\u0000\u0121\u0123\u0003\u0014\n\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000\u0124\u0122\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u01251\u0001\u0000"+
		"\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u0128\u0003<\u001e"+
		"\u0000\u0128\u0129\u0005/\u0000\u0000\u0129\u012b\u0005\t\u0000\u0000"+
		"\u012a\u012c\u00038\u001c\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0005\n\u0000\u0000\u012e\u012f\u0005\u0004\u0000\u0000\u012f3"+
		"\u0001\u0000\u0000\u0000\u0130\u0131\u0003<\u001e\u0000\u0131\u0132\u0005"+
		"/\u0000\u0000\u0132\u0134\u0005\t\u0000\u0000\u0133\u0135\u00038\u001c"+
		"\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000"+
		"\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0005\n\u0000\u0000"+
		"\u0137\u0138\u0003\b\u0004\u0000\u01385\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\u0007\u0003\u0000\u0000\u013a7\u0001\u0000\u0000\u0000\u013b\u0140"+
		"\u0003:\u001d\u0000\u013c\u013d\u0005\u0003\u0000\u0000\u013d\u013f\u0003"+
		":\u001d\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0142\u0001\u0000"+
		"\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000"+
		"\u0000\u0000\u01419\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000"+
		"\u0000\u0143\u0144\u0003<\u001e\u0000\u0144\u0145\u0005/\u0000\u0000\u0145"+
		"\u0146\u0005\u0007\u0000\u0000\u0146\u0147\u0005\b\u0000\u0000\u0147\u014d"+
		"\u0001\u0000\u0000\u0000\u0148\u014a\u0003<\u001e\u0000\u0149\u014b\u0005"+
		"/\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"+
		"\u0000\u0000\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u0143\u0001\u0000"+
		"\u0000\u0000\u014c\u0148\u0001\u0000\u0000\u0000\u014d;\u0001\u0000\u0000"+
		"\u0000\u014e\u0151\u0005\u001e\u0000\u0000\u014f\u0151\u0003D\"\u0000"+
		"\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u014f\u0001\u0000\u0000\u0000"+
		"\u0151=\u0001\u0000\u0000\u0000\u0152\u0153\u0003D\"\u0000\u0153\u0158"+
		"\u0003@ \u0000\u0154\u0155\u0005\u0003\u0000\u0000\u0155\u0157\u0003@"+
		" \u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000"+
		"\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0159\u015b\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000"+
		"\u0000\u015b\u015c\u0005\u0004\u0000\u0000\u015c?\u0001\u0000\u0000\u0000"+
		"\u015d\u0160\u0005/\u0000\u0000\u015e\u015f\u0005\u000b\u0000\u0000\u015f"+
		"\u0161\u0003\u0014\n\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161"+
		"\u0001\u0000\u0000\u0000\u0161\u0170\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0005/\u0000\u0000\u0163\u0165\u0005\u0007\u0000\u0000\u0164\u0166\u0003"+
		"\u0014\n\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000"+
		"\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u016d\u0005\b\u0000"+
		"\u0000\u0168\u016b\u0005\u000b\u0000\u0000\u0169\u016c\u0003B!\u0000\u016a"+
		"\u016c\u0003\u0014\n\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016a"+
		"\u0001\u0000\u0000\u0000\u016c\u016e\u0001\u0000\u0000\u0000\u016d\u0168"+
		"\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u0170"+
		"\u0001\u0000\u0000\u0000\u016f\u015d\u0001\u0000\u0000\u0000\u016f\u0162"+
		"\u0001\u0000\u0000\u0000\u0170A\u0001\u0000\u0000\u0000\u0171\u0172\u0005"+
		"\u0005\u0000\u0000\u0172\u0173\u00030\u0018\u0000\u0173\u0174\u0005\u0006"+
		"\u0000\u0000\u0174C\u0001\u0000\u0000\u0000\u0175\u0178\u0005\u001c\u0000"+
		"\u0000\u0176\u0177\u0005\u0007\u0000\u0000\u0177\u0179\u0005\b\u0000\u0000"+
		"\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000"+
		"\u0179\u0180\u0001\u0000\u0000\u0000\u017a\u017d\u0005\u001d\u0000\u0000"+
		"\u017b\u017c\u0005\u0007\u0000\u0000\u017c\u017e\u0005\b\u0000\u0000\u017d"+
		"\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e"+
		"\u0180\u0001\u0000\u0000\u0000\u017f\u0175\u0001\u0000\u0000\u0000\u017f"+
		"\u017a\u0001\u0000\u0000\u0000\u0180E\u0001\u0000\u0000\u0000\u0181\u0182"+
		"\u0005\'\u0000\u0000\u0182\u0183\u0005\t\u0000\u0000\u0183\u0184\u0003"+
		"\u0014\n\u0000\u0184\u0185\u0005\u0004\u0000\u0000\u0185\u0186\u0003\u0014"+
		"\n\u0000\u0186\u0187\u0005\u0004\u0000\u0000\u0187\u0188\u0003\u0014\n"+
		"\u0000\u0188\u0189\u0005\n\u0000\u0000\u0189\u018a\u0003\b\u0004\u0000"+
		"\u018a\u0192\u0001\u0000\u0000\u0000\u018b\u018c\u0005&\u0000\u0000\u018c"+
		"\u018d\u0005\t\u0000\u0000\u018d\u018e\u0003\u0014\n\u0000\u018e\u018f"+
		"\u0005\n\u0000\u0000\u018f\u0190\u0003\b\u0004\u0000\u0190\u0192\u0001"+
		"\u0000\u0000\u0000\u0191\u0181\u0001\u0000\u0000\u0000\u0191\u018b\u0001"+
		"\u0000\u0000\u0000\u0192G\u0001\u0000\u0000\u0000\u0193\u0194\u0005$\u0000"+
		"\u0000\u0194\u0195\u0005\t\u0000\u0000\u0195\u0196\u0003\u0014\n\u0000"+
		"\u0196\u0197\u0005\n\u0000\u0000\u0197\u019a\u0003\b\u0004\u0000\u0198"+
		"\u0199\u0005%\u0000\u0000\u0199\u019b\u0003\b\u0004\u0000\u019a\u0198"+
		"\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019bI\u0001"+
		"\u0000\u0000\u0000%MOXasy\u0091\u00a9\u00ad\u00ba\u00c2\u00c9\u00d1\u00d9"+
		"\u00e1\u00e9\u00f2\u0105\u0115\u0124\u012b\u0134\u0140\u014a\u014c\u0150"+
		"\u0158\u0160\u0165\u016b\u016d\u016f\u0178\u017d\u017f\u0191\u019a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}