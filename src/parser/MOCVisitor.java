// Generated from d:/_UAb/Ano_3/2Sem/21018 - Compilação/2104775_EfolioB/Efolio/src/MOC.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MOCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MOCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MOCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MOCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#localFuncDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFuncDecl(MOCParser.LocalFuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#localFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFuncDef(MOCParser.LocalFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MOCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MOCParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MOCParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(MOCParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(MOCParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MOCParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#assignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignable(MOCParser.AssignableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MOCParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#assExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssExpr(MOCParser.AssExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(MOCParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(MOCParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(MOCParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(MOCParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(MOCParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(MOCParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#castExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(MOCParser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#primeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimeExpr(MOCParser.PrimeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(MOCParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#doubleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteral(MOCParser.DoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#charLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(MOCParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MOCParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MOCParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#funcDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclaration(MOCParser.FuncDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#funcDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefinition(MOCParser.FuncDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#readFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadFunc(MOCParser.ReadFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MOCParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MOCParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(MOCParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MOCParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#variableInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInit(MOCParser.VariableInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(MOCParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(MOCParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(MOCParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MOCParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(MOCParser.ConditionalContext ctx);
}