// Generated from d:/_UAb/Ano_3/2Sem/21018 - Compilação/2104775_EfolioB/Efolio/src/MOC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MOCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, DOT=2, COMA=3, SEMICOLON=4, LEFTBRACE=5, RIGHTBRACE=6, LEFTBRACKET=7, 
		RIGHTBRACKET=8, LEFTPARENTESIS=9, RIGHTPARENTESIS=10, ASSIGN=11, BLOCKCOMMENT=12, 
		LINECOMMENT=13, ADD=14, SUBTRACT=15, MULTIPLY=16, DIVIDE=17, MODULE=18, 
		NOT=19, AND=20, OR=21, LT=22, GT=23, LEQ=24, GEQ=25, EQUAL=26, NOTEQUAL=27, 
		INT=28, DOUBLE=29, VOID=30, RETURN=31, DOUBLE_LITERAL=32, INT_LITERAL=33, 
		STRING_LITERAL=34, IF=35, ELSE=36, WHILE=37, FOR=38, WRITE=39, WRITEC=40, 
		WRITEV=41, WRITES=42, READ=43, READC=44, READS=45, IDENTIFIER=46, DIGIT=47, 
		SPACE=48;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_blockStatement = 2, RULE_returnStatement = 3, 
		RULE_readStatement = 4, RULE_writeStatement = 5, RULE_assignment = 6, 
		RULE_assignable = 7, RULE_expression = 8, RULE_assExpr = 9, RULE_orExpr = 10, 
		RULE_andExpr = 11, RULE_relExpr = 12, RULE_addExpr = 13, RULE_mulExpr = 14, 
		RULE_unaryExpr = 15, RULE_castExpr = 16, RULE_primeExpr = 17, RULE_expressionList = 18, 
		RULE_funcDeclaration = 19, RULE_funcDefinition = 20, RULE_readFunc = 21, 
		RULE_parameterList = 22, RULE_parameter = 23, RULE_funcType = 24, RULE_declaration = 25, 
		RULE_variableInit = 26, RULE_arrayLiteral = 27, RULE_varType = 28, RULE_loop = 29, 
		RULE_conditional = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "blockStatement", "returnStatement", "readStatement", 
			"writeStatement", "assignment", "assignable", "expression", "assExpr", 
			"orExpr", "andExpr", "relExpr", "addExpr", "mulExpr", "unaryExpr", "castExpr", 
			"primeExpr", "expressionList", "funcDeclaration", "funcDefinition", "readFunc", 
			"parameterList", "parameter", "funcType", "declaration", "variableInit", 
			"arrayLiteral", "varType", "loop", "conditional"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'.'", "','", "';'", "'{'", "'}'", "'['", "']'", "'('", "')'", 
			"'='", null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'&&'", 
			"'||'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'int'", "'double'", 
			"'void'", "'return'", null, null, null, "'if'", "'else'", "'while'", 
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
			"INT", "DOUBLE", "VOID", "RETURN", "DOUBLE_LITERAL", "INT_LITERAL", "STRING_LITERAL", 
			"IF", "ELSE", "WHILE", "FOR", "WRITE", "WRITEC", "WRITEV", "WRITES", 
			"READ", "READC", "READS", "IDENTIFIER", "DIGIT", "SPACE"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140651321131552L) != 0)) {
				{
				setState(65);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(62);
					funcDeclaration();
					}
					break;
				case 2:
					{
					setState(63);
					funcDefinition();
					}
					break;
				case 3:
					{
					setState(64);
					statement();
					}
					break;
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
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
	public static class StatementContext extends ParserRuleContext {
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				readStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				writeStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				declaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				loop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				conditional();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				returnStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(79);
				blockStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(80);
				expression();
				setState(81);
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
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(LEFTBRACE);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140650247389728L) != 0)) {
				{
				{
				setState(86);
				statement();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
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
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(RETURN);
			setState(95);
			expression();
			setState(96);
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
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_readStatement);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READ:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(READ);
				setState(99);
				match(LEFTPARENTESIS);
				setState(100);
				match(IDENTIFIER);
				setState(101);
				match(RIGHTPARENTESIS);
				setState(102);
				match(SEMICOLON);
				}
				break;
			case READC:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(READC);
				setState(104);
				match(LEFTPARENTESIS);
				setState(105);
				match(IDENTIFIER);
				setState(106);
				match(RIGHTPARENTESIS);
				setState(107);
				match(SEMICOLON);
				}
				break;
			case READS:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(READS);
				setState(109);
				match(LEFTPARENTESIS);
				setState(110);
				match(IDENTIFIER);
				setState(111);
				match(RIGHTPARENTESIS);
				setState(112);
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
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_writeStatement);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WRITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(WRITE);
				setState(116);
				match(LEFTPARENTESIS);
				setState(117);
				expression();
				setState(118);
				match(RIGHTPARENTESIS);
				setState(119);
				match(SEMICOLON);
				}
				break;
			case WRITEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(WRITEC);
				setState(122);
				match(LEFTPARENTESIS);
				setState(123);
				expression();
				setState(124);
				match(RIGHTPARENTESIS);
				setState(125);
				match(SEMICOLON);
				}
				break;
			case WRITEV:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(WRITEV);
				setState(128);
				match(LEFTPARENTESIS);
				setState(129);
				expression();
				setState(130);
				match(RIGHTPARENTESIS);
				setState(131);
				match(SEMICOLON);
				}
				break;
			case WRITES:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				match(WRITES);
				setState(134);
				match(LEFTPARENTESIS);
				setState(137);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFTBRACE:
				case LEFTPARENTESIS:
				case SUBTRACT:
				case NOT:
				case DOUBLE_LITERAL:
				case INT_LITERAL:
				case READ:
				case READC:
				case READS:
				case IDENTIFIER:
					{
					setState(135);
					expression();
					}
					break;
				case STRING_LITERAL:
					{
					setState(136);
					match(STRING_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(139);
				match(RIGHTPARENTESIS);
				setState(140);
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			assignable();
			setState(144);
			match(ASSIGN);
			setState(145);
			expression();
			setState(146);
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
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignable);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(IDENTIFIER);
				setState(150);
				match(LEFTBRACKET);
				setState(151);
				expression();
				setState(152);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
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
	}

	public final AssExprContext assExpr() throws RecognitionException {
		AssExprContext _localctx = new AssExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assExpr);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(IDENTIFIER);
				setState(159);
				match(ASSIGN);
				setState(160);
				assExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
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
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			andExpr();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(165);
				match(OR);
				setState(166);
				andExpr();
				}
				}
				setState(171);
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
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			relExpr();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(173);
				match(AND);
				setState(174);
				relExpr();
				}
				}
				setState(179);
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
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			addExpr();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 264241152L) != 0)) {
				{
				{
				setState(181);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 264241152L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(182);
				addExpr();
				}
				}
				setState(187);
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
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			mulExpr();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUBTRACT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(190);
				mulExpr();
				}
				}
				setState(195);
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
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			unaryExpr();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(197);
				_la = _input.LA(1);
				if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(198);
				unaryExpr();
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
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unaryExpr);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(NOT);
				setState(205);
				unaryExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(SUBTRACT);
				setState(207);
				unaryExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				castExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
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
	}

	public final CastExprContext castExpr() throws RecognitionException {
		CastExprContext _localctx = new CastExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_castExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(LEFTPARENTESIS);
			setState(213);
			varType();
			setState(214);
			match(RIGHTPARENTESIS);
			setState(215);
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
		public TerminalNode INT_LITERAL() { return getToken(MOCParser.INT_LITERAL, 0); }
		public TerminalNode DOUBLE_LITERAL() { return getToken(MOCParser.DOUBLE_LITERAL, 0); }
		public TerminalNode LEFTBRACE() { return getToken(MOCParser.LEFTBRACE, 0); }
		public TerminalNode RIGHTBRACE() { return getToken(MOCParser.RIGHTBRACE, 0); }
		public PrimeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primeExpr; }
	}

	public final PrimeExprContext primeExpr() throws RecognitionException {
		PrimeExprContext _localctx = new PrimeExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primeExpr);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				readFunc();
				setState(218);
				match(LEFTPARENTESIS);
				setState(219);
				match(RIGHTPARENTESIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(IDENTIFIER);
				setState(222);
				match(LEFTBRACKET);
				setState(223);
				expression();
				setState(224);
				match(RIGHTBRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(IDENTIFIER);
				setState(227);
				match(LEFTPARENTESIS);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 131954280792608L) != 0)) {
					{
					setState(228);
					expressionList();
					}
				}

				setState(231);
				match(RIGHTPARENTESIS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				match(IDENTIFIER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				match(INT_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(234);
				match(DOUBLE_LITERAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(235);
				match(LEFTPARENTESIS);
				setState(236);
				expression();
				setState(237);
				match(RIGHTPARENTESIS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(239);
				match(LEFTBRACE);
				setState(240);
				expressionList();
				setState(241);
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
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			expression();
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(246);
				match(COMA);
				setState(247);
				expression();
				}
				}
				setState(252);
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
	}

	public final FuncDeclarationContext funcDeclaration() throws RecognitionException {
		FuncDeclarationContext _localctx = new FuncDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			funcType();
			setState(254);
			match(IDENTIFIER);
			setState(255);
			match(LEFTPARENTESIS);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				setState(256);
				parameterList();
				}
			}

			setState(259);
			match(RIGHTPARENTESIS);
			setState(260);
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
	}

	public final FuncDefinitionContext funcDefinition() throws RecognitionException {
		FuncDefinitionContext _localctx = new FuncDefinitionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funcDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			funcType();
			setState(263);
			match(IDENTIFIER);
			setState(264);
			match(LEFTPARENTESIS);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				setState(265);
				parameterList();
				}
			}

			setState(268);
			match(RIGHTPARENTESIS);
			setState(269);
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
	}

	public final ReadFuncContext readFunc() throws RecognitionException {
		ReadFuncContext _localctx = new ReadFuncContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_readFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61572651155456L) != 0)) ) {
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
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			parameter();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(274);
				match(COMA);
				setState(275);
				parameter();
				}
				}
				setState(280);
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
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_parameter);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				funcType();
				setState(282);
				match(IDENTIFIER);
				setState(283);
				match(LEFTBRACKET);
				setState(284);
				match(RIGHTBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				funcType();
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(287);
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
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_funcType);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(VOID);
				}
				break;
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
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
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
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
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			varType();
			setState(297);
			variableInit();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 805306376L) != 0)) {
				{
				setState(301);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMA:
					{
					setState(298);
					match(COMA);
					setState(299);
					variableInit();
					}
					break;
				case INT:
				case DOUBLE:
					{
					setState(300);
					varType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
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
	}

	public final VariableInitContext variableInit() throws RecognitionException {
		VariableInitContext _localctx = new VariableInitContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_variableInit);
		int _la;
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(IDENTIFIER);
				setState(312);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(309);
					match(ASSIGN);
					setState(310);
					expression();
					}
					break;
				case 2:
					{
					setState(311);
					varType();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(IDENTIFIER);
				setState(315);
				match(LEFTBRACKET);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 131954280792608L) != 0)) {
					{
					setState(316);
					expression();
					}
				}

				setState(319);
				match(RIGHTBRACKET);
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(320);
					match(ASSIGN);
					setState(321);
					arrayLiteral();
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
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(LEFTBRACE);
			setState(327);
			expressionList();
			setState(328);
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
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varType);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				match(INT);
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFTBRACKET) {
					{
					setState(331);
					match(LEFTBRACKET);
					setState(332);
					match(RIGHTBRACKET);
					}
				}

				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				match(DOUBLE);
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFTBRACKET) {
					{
					setState(336);
					match(LEFTBRACKET);
					setState(337);
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
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_loop);
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(FOR);
				setState(343);
				match(LEFTPARENTESIS);
				setState(344);
				expression();
				setState(345);
				match(SEMICOLON);
				setState(346);
				expression();
				setState(347);
				match(SEMICOLON);
				setState(348);
				expression();
				setState(349);
				match(RIGHTPARENTESIS);
				setState(350);
				blockStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(WHILE);
				setState(353);
				match(LEFTPARENTESIS);
				setState(354);
				expression();
				setState(355);
				match(RIGHTPARENTESIS);
				setState(356);
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
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(IF);
			setState(361);
			match(LEFTPARENTESIS);
			setState(362);
			expression();
			setState(363);
			match(RIGHTPARENTESIS);
			setState(364);
			blockStatement();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(365);
				match(ELSE);
				setState(366);
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
		"\u0004\u00010\u0172\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000B\b\u0000\n\u0000\f\u0000"+
		"E\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001T\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0005\u0002X\b\u0002\n\u0002\f\u0002[\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004r\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u008a\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u008e\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u009b\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00a3\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u00a8\b\n\n\n\f\n"+
		"\u00ab\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b0\b\u000b"+
		"\n\u000b\f\u000b\u00b3\t\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00b8\b"+
		"\f\n\f\f\f\u00bb\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u00c0\b\r\n\r\f\r"+
		"\u00c3\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c8\b\u000e"+
		"\n\u000e\f\u000e\u00cb\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00d3\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00e6\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00f4\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00f9"+
		"\b\u0012\n\u0012\f\u0012\u00fc\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0102\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u010b\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u0115\b\u0016\n\u0016\f\u0016\u0118"+
		"\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u0121\b\u0017\u0003\u0017\u0123\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0127\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u012e\b\u0019\n\u0019"+
		"\f\u0019\u0131\t\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u0139\b\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u013e\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0143\b\u001a\u0003\u001a\u0145\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u014e\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0153"+
		"\b\u001c\u0003\u001c\u0155\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u0167\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0170\b\u001e"+
		"\u0001\u001e\u0000\u0000\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<\u0000\u0004"+
		"\u0001\u0000\u0016\u001b\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0011"+
		"\u0001\u0000+-\u0189\u0000C\u0001\u0000\u0000\u0000\u0002S\u0001\u0000"+
		"\u0000\u0000\u0004U\u0001\u0000\u0000\u0000\u0006^\u0001\u0000\u0000\u0000"+
		"\bq\u0001\u0000\u0000\u0000\n\u008d\u0001\u0000\u0000\u0000\f\u008f\u0001"+
		"\u0000\u0000\u0000\u000e\u009a\u0001\u0000\u0000\u0000\u0010\u009c\u0001"+
		"\u0000\u0000\u0000\u0012\u00a2\u0001\u0000\u0000\u0000\u0014\u00a4\u0001"+
		"\u0000\u0000\u0000\u0016\u00ac\u0001\u0000\u0000\u0000\u0018\u00b4\u0001"+
		"\u0000\u0000\u0000\u001a\u00bc\u0001\u0000\u0000\u0000\u001c\u00c4\u0001"+
		"\u0000\u0000\u0000\u001e\u00d2\u0001\u0000\u0000\u0000 \u00d4\u0001\u0000"+
		"\u0000\u0000\"\u00f3\u0001\u0000\u0000\u0000$\u00f5\u0001\u0000\u0000"+
		"\u0000&\u00fd\u0001\u0000\u0000\u0000(\u0106\u0001\u0000\u0000\u0000*"+
		"\u010f\u0001\u0000\u0000\u0000,\u0111\u0001\u0000\u0000\u0000.\u0122\u0001"+
		"\u0000\u0000\u00000\u0126\u0001\u0000\u0000\u00002\u0128\u0001\u0000\u0000"+
		"\u00004\u0144\u0001\u0000\u0000\u00006\u0146\u0001\u0000\u0000\u00008"+
		"\u0154\u0001\u0000\u0000\u0000:\u0166\u0001\u0000\u0000\u0000<\u0168\u0001"+
		"\u0000\u0000\u0000>B\u0003&\u0013\u0000?B\u0003(\u0014\u0000@B\u0003\u0002"+
		"\u0001\u0000A>\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000A@\u0001"+
		"\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000FG\u0005\u0000\u0000\u0001G\u0001\u0001\u0000\u0000\u0000HT\u0003"+
		"\b\u0004\u0000IT\u0003\n\u0005\u0000JT\u0003\f\u0006\u0000KT\u00032\u0019"+
		"\u0000LT\u0003:\u001d\u0000MT\u0003<\u001e\u0000NT\u0003\u0006\u0003\u0000"+
		"OT\u0003\u0004\u0002\u0000PQ\u0003\u0010\b\u0000QR\u0005\u0004\u0000\u0000"+
		"RT\u0001\u0000\u0000\u0000SH\u0001\u0000\u0000\u0000SI\u0001\u0000\u0000"+
		"\u0000SJ\u0001\u0000\u0000\u0000SK\u0001\u0000\u0000\u0000SL\u0001\u0000"+
		"\u0000\u0000SM\u0001\u0000\u0000\u0000SN\u0001\u0000\u0000\u0000SO\u0001"+
		"\u0000\u0000\u0000SP\u0001\u0000\u0000\u0000T\u0003\u0001\u0000\u0000"+
		"\u0000UY\u0005\u0005\u0000\u0000VX\u0003\u0002\u0001\u0000WV\u0001\u0000"+
		"\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\]\u0005\u0006\u0000\u0000]\u0005\u0001\u0000\u0000\u0000^_\u0005\u001f"+
		"\u0000\u0000_`\u0003\u0010\b\u0000`a\u0005\u0004\u0000\u0000a\u0007\u0001"+
		"\u0000\u0000\u0000bc\u0005+\u0000\u0000cd\u0005\t\u0000\u0000de\u0005"+
		".\u0000\u0000ef\u0005\n\u0000\u0000fr\u0005\u0004\u0000\u0000gh\u0005"+
		",\u0000\u0000hi\u0005\t\u0000\u0000ij\u0005.\u0000\u0000jk\u0005\n\u0000"+
		"\u0000kr\u0005\u0004\u0000\u0000lm\u0005-\u0000\u0000mn\u0005\t\u0000"+
		"\u0000no\u0005.\u0000\u0000op\u0005\n\u0000\u0000pr\u0005\u0004\u0000"+
		"\u0000qb\u0001\u0000\u0000\u0000qg\u0001\u0000\u0000\u0000ql\u0001\u0000"+
		"\u0000\u0000r\t\u0001\u0000\u0000\u0000st\u0005\'\u0000\u0000tu\u0005"+
		"\t\u0000\u0000uv\u0003\u0010\b\u0000vw\u0005\n\u0000\u0000wx\u0005\u0004"+
		"\u0000\u0000x\u008e\u0001\u0000\u0000\u0000yz\u0005(\u0000\u0000z{\u0005"+
		"\t\u0000\u0000{|\u0003\u0010\b\u0000|}\u0005\n\u0000\u0000}~\u0005\u0004"+
		"\u0000\u0000~\u008e\u0001\u0000\u0000\u0000\u007f\u0080\u0005)\u0000\u0000"+
		"\u0080\u0081\u0005\t\u0000\u0000\u0081\u0082\u0003\u0010\b\u0000\u0082"+
		"\u0083\u0005\n\u0000\u0000\u0083\u0084\u0005\u0004\u0000\u0000\u0084\u008e"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005*\u0000\u0000\u0086\u0089\u0005"+
		"\t\u0000\u0000\u0087\u008a\u0003\u0010\b\u0000\u0088\u008a\u0005\"\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0005\n\u0000\u0000"+
		"\u008c\u008e\u0005\u0004\u0000\u0000\u008ds\u0001\u0000\u0000\u0000\u008d"+
		"y\u0001\u0000\u0000\u0000\u008d\u007f\u0001\u0000\u0000\u0000\u008d\u0085"+
		"\u0001\u0000\u0000\u0000\u008e\u000b\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0003\u000e\u0007\u0000\u0090\u0091\u0005\u000b\u0000\u0000\u0091\u0092"+
		"\u0003\u0010\b\u0000\u0092\u0093\u0005\u0004\u0000\u0000\u0093\r\u0001"+
		"\u0000\u0000\u0000\u0094\u009b\u0005.\u0000\u0000\u0095\u0096\u0005.\u0000"+
		"\u0000\u0096\u0097\u0005\u0007\u0000\u0000\u0097\u0098\u0003\u0010\b\u0000"+
		"\u0098\u0099\u0005\b\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a"+
		"\u0094\u0001\u0000\u0000\u0000\u009a\u0095\u0001\u0000\u0000\u0000\u009b"+
		"\u000f\u0001\u0000\u0000\u0000\u009c\u009d\u0003\u0012\t\u0000\u009d\u0011"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0005.\u0000\u0000\u009f\u00a0\u0005"+
		"\u000b\u0000\u0000\u00a0\u00a3\u0003\u0012\t\u0000\u00a1\u00a3\u0003\u0014"+
		"\n\u0000\u00a2\u009e\u0001\u0000\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u0013\u0001\u0000\u0000\u0000\u00a4\u00a9\u0003\u0016\u000b"+
		"\u0000\u00a5\u00a6\u0005\u0015\u0000\u0000\u00a6\u00a8\u0003\u0016\u000b"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u0015\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b1\u0003\u0018\f\u0000\u00ad\u00ae\u0005\u0014\u0000\u0000"+
		"\u00ae\u00b0\u0003\u0018\f\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u0017\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b9\u0003\u001a\r\u0000\u00b5\u00b6"+
		"\u0007\u0000\u0000\u0000\u00b6\u00b8\u0003\u001a\r\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u0019\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00c1\u0003"+
		"\u001c\u000e\u0000\u00bd\u00be\u0007\u0001\u0000\u0000\u00be\u00c0\u0003"+
		"\u001c\u000e\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u001b\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c9\u0003\u001e\u000f\u0000\u00c5\u00c6\u0007"+
		"\u0002\u0000\u0000\u00c6\u00c8\u0003\u001e\u000f\u0000\u00c7\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u001d\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"\u0013\u0000\u0000\u00cd\u00d3\u0003\u001e\u000f\u0000\u00ce\u00cf\u0005"+
		"\u000f\u0000\u0000\u00cf\u00d3\u0003\u001e\u000f\u0000\u00d0\u00d3\u0003"+
		" \u0010\u0000\u00d1\u00d3\u0003\"\u0011\u0000\u00d2\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3\u001f\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0005\t\u0000\u0000\u00d5\u00d6\u00038\u001c"+
		"\u0000\u00d6\u00d7\u0005\n\u0000\u0000\u00d7\u00d8\u0003\u001e\u000f\u0000"+
		"\u00d8!\u0001\u0000\u0000\u0000\u00d9\u00da\u0003*\u0015\u0000\u00da\u00db"+
		"\u0005\t\u0000\u0000\u00db\u00dc\u0005\n\u0000\u0000\u00dc\u00f4\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0005.\u0000\u0000\u00de\u00df\u0005\u0007"+
		"\u0000\u0000\u00df\u00e0\u0003\u0010\b\u0000\u00e0\u00e1\u0005\b\u0000"+
		"\u0000\u00e1\u00f4\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005.\u0000\u0000"+
		"\u00e3\u00e5\u0005\t\u0000\u0000\u00e4\u00e6\u0003$\u0012\u0000\u00e5"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00f4\u0005\n\u0000\u0000\u00e8\u00f4"+
		"\u0005.\u0000\u0000\u00e9\u00f4\u0005!\u0000\u0000\u00ea\u00f4\u0005 "+
		"\u0000\u0000\u00eb\u00ec\u0005\t\u0000\u0000\u00ec\u00ed\u0003\u0010\b"+
		"\u0000\u00ed\u00ee\u0005\n\u0000\u0000\u00ee\u00f4\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0005\u0005\u0000\u0000\u00f0\u00f1\u0003$\u0012\u0000\u00f1"+
		"\u00f2\u0005\u0006\u0000\u0000\u00f2\u00f4\u0001\u0000\u0000\u0000\u00f3"+
		"\u00d9\u0001\u0000\u0000\u0000\u00f3\u00dd\u0001\u0000\u0000\u0000\u00f3"+
		"\u00e2\u0001\u0000\u0000\u0000\u00f3\u00e8\u0001\u0000\u0000\u0000\u00f3"+
		"\u00e9\u0001\u0000\u0000\u0000\u00f3\u00ea\u0001\u0000\u0000\u0000\u00f3"+
		"\u00eb\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001\u0000\u0000\u0000\u00f4"+
		"#\u0001\u0000\u0000\u0000\u00f5\u00fa\u0003\u0010\b\u0000\u00f6\u00f7"+
		"\u0005\u0003\u0000\u0000\u00f7\u00f9\u0003\u0010\b\u0000\u00f8\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb%\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u00fe\u00030\u0018"+
		"\u0000\u00fe\u00ff\u0005.\u0000\u0000\u00ff\u0101\u0005\t\u0000\u0000"+
		"\u0100\u0102\u0003,\u0016\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0005\n\u0000\u0000\u0104\u0105\u0005\u0004\u0000\u0000\u0105\'"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u00030\u0018\u0000\u0107\u0108\u0005"+
		".\u0000\u0000\u0108\u010a\u0005\t\u0000\u0000\u0109\u010b\u0003,\u0016"+
		"\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000"+
		"\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0005\n\u0000\u0000"+
		"\u010d\u010e\u0003\u0004\u0002\u0000\u010e)\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0007\u0003\u0000\u0000\u0110+\u0001\u0000\u0000\u0000\u0111\u0116"+
		"\u0003.\u0017\u0000\u0112\u0113\u0005\u0003\u0000\u0000\u0113\u0115\u0003"+
		".\u0017\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000"+
		"\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"+
		"\u0000\u0000\u0117-\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u00030\u0018\u0000\u011a\u011b\u0005.\u0000\u0000\u011b"+
		"\u011c\u0005\u0007\u0000\u0000\u011c\u011d\u0005\b\u0000\u0000\u011d\u0123"+
		"\u0001\u0000\u0000\u0000\u011e\u0120\u00030\u0018\u0000\u011f\u0121\u0005"+
		".\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000"+
		"\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0119\u0001\u0000"+
		"\u0000\u0000\u0122\u011e\u0001\u0000\u0000\u0000\u0123/\u0001\u0000\u0000"+
		"\u0000\u0124\u0127\u0005\u001e\u0000\u0000\u0125\u0127\u00038\u001c\u0000"+
		"\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000"+
		"\u01271\u0001\u0000\u0000\u0000\u0128\u0129\u00038\u001c\u0000\u0129\u012f"+
		"\u00034\u001a\u0000\u012a\u012b\u0005\u0003\u0000\u0000\u012b\u012e\u0003"+
		"4\u001a\u0000\u012c\u012e\u00038\u001c\u0000\u012d\u012a\u0001\u0000\u0000"+
		"\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000"+
		"\u0000\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u0005\u0004\u0000\u0000\u01333\u0001\u0000\u0000\u0000"+
		"\u0134\u0138\u0005.\u0000\u0000\u0135\u0136\u0005\u000b\u0000\u0000\u0136"+
		"\u0139\u0003\u0010\b\u0000\u0137\u0139\u00038\u001c\u0000\u0138\u0135"+
		"\u0001\u0000\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0001\u0000\u0000\u0000\u0139\u0145\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0005.\u0000\u0000\u013b\u013d\u0005\u0007\u0000\u0000\u013c\u013e\u0003"+
		"\u0010\b\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0142\u0005\b\u0000"+
		"\u0000\u0140\u0141\u0005\u000b\u0000\u0000\u0141\u0143\u00036\u001b\u0000"+
		"\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000"+
		"\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0134\u0001\u0000\u0000\u0000"+
		"\u0144\u013a\u0001\u0000\u0000\u0000\u01455\u0001\u0000\u0000\u0000\u0146"+
		"\u0147\u0005\u0005\u0000\u0000\u0147\u0148\u0003$\u0012\u0000\u0148\u0149"+
		"\u0005\u0006\u0000\u0000\u01497\u0001\u0000\u0000\u0000\u014a\u014d\u0005"+
		"\u001c\u0000\u0000\u014b\u014c\u0005\u0007\u0000\u0000\u014c\u014e\u0005"+
		"\b\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000"+
		"\u0000\u0000\u014e\u0155\u0001\u0000\u0000\u0000\u014f\u0152\u0005\u001d"+
		"\u0000\u0000\u0150\u0151\u0005\u0007\u0000\u0000\u0151\u0153\u0005\b\u0000"+
		"\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153\u0155\u0001\u0000\u0000\u0000\u0154\u014a\u0001\u0000\u0000"+
		"\u0000\u0154\u014f\u0001\u0000\u0000\u0000\u01559\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0005&\u0000\u0000\u0157\u0158\u0005\t\u0000\u0000\u0158"+
		"\u0159\u0003\u0010\b\u0000\u0159\u015a\u0005\u0004\u0000\u0000\u015a\u015b"+
		"\u0003\u0010\b\u0000\u015b\u015c\u0005\u0004\u0000\u0000\u015c\u015d\u0003"+
		"\u0010\b\u0000\u015d\u015e\u0005\n\u0000\u0000\u015e\u015f\u0003\u0004"+
		"\u0002\u0000\u015f\u0167\u0001\u0000\u0000\u0000\u0160\u0161\u0005%\u0000"+
		"\u0000\u0161\u0162\u0005\t\u0000\u0000\u0162\u0163\u0003\u0010\b\u0000"+
		"\u0163\u0164\u0005\n\u0000\u0000\u0164\u0165\u0003\u0004\u0002\u0000\u0165"+
		"\u0167\u0001\u0000\u0000\u0000\u0166\u0156\u0001\u0000\u0000\u0000\u0166"+
		"\u0160\u0001\u0000\u0000\u0000\u0167;\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0005#\u0000\u0000\u0169\u016a\u0005\t\u0000\u0000\u016a\u016b\u0003"+
		"\u0010\b\u0000\u016b\u016c\u0005\n\u0000\u0000\u016c\u016f\u0003\u0004"+
		"\u0002\u0000\u016d\u016e\u0005$\u0000\u0000\u016e\u0170\u0003\u0004\u0002"+
		"\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000"+
		"\u0000\u0170=\u0001\u0000\u0000\u0000#ACSYq\u0089\u008d\u009a\u00a2\u00a9"+
		"\u00b1\u00b9\u00c1\u00c9\u00d2\u00e5\u00f3\u00fa\u0101\u010a\u0116\u0120"+
		"\u0122\u0126\u012d\u012f\u0138\u013d\u0142\u0144\u014d\u0152\u0154\u0166"+
		"\u016f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}