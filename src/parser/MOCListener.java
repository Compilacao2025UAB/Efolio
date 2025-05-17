// Generated from d:/_UAb/Ano_3/2Sem/21018 - Compilação/2104775_EfolioB/Efolio/src/MOC.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MOCParser}.
 */
public interface MOCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MOCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MOCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MOCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#localFuncDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalFuncDecl(MOCParser.LocalFuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#localFuncDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalFuncDecl(MOCParser.LocalFuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#localFuncDef}.
	 * @param ctx the parse tree
	 */
	void enterLocalFuncDef(MOCParser.LocalFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#localFuncDef}.
	 * @param ctx the parse tree
	 */
	void exitLocalFuncDef(MOCParser.LocalFuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MOCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MOCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MOCParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MOCParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MOCParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MOCParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(MOCParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(MOCParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(MOCParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(MOCParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MOCParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MOCParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(MOCParser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(MOCParser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MOCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MOCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#assExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssExpr(MOCParser.AssExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#assExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssExpr(MOCParser.AssExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MOCParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MOCParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MOCParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MOCParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(MOCParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(MOCParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MOCParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MOCParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(MOCParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(MOCParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MOCParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MOCParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#castExpr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(MOCParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#castExpr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(MOCParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#primeExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimeExpr(MOCParser.PrimeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#primeExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimeExpr(MOCParser.PrimeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(MOCParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(MOCParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#doubleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(MOCParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#doubleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(MOCParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MOCParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MOCParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#funcDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclaration(MOCParser.FuncDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#funcDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclaration(MOCParser.FuncDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#funcDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefinition(MOCParser.FuncDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#funcDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefinition(MOCParser.FuncDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#readFunc}.
	 * @param ctx the parse tree
	 */
	void enterReadFunc(MOCParser.ReadFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#readFunc}.
	 * @param ctx the parse tree
	 */
	void exitReadFunc(MOCParser.ReadFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MOCParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MOCParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MOCParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MOCParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(MOCParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(MOCParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MOCParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MOCParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#variableInit}.
	 * @param ctx the parse tree
	 */
	void enterVariableInit(MOCParser.VariableInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#variableInit}.
	 * @param ctx the parse tree
	 */
	void exitVariableInit(MOCParser.VariableInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(MOCParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(MOCParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(MOCParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(MOCParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(MOCParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(MOCParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MOCParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(MOCParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MOCParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(MOCParser.ConditionalContext ctx);
}