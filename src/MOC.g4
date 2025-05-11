grammar MOC;

/******************** TOKENS ******************* */

//NOVALINHA (Retirado da gramatica de C)
NEWLINE
    : ('\r' '\n'? | '\n') -> channel(HIDDEN)
    ;

// Pontuacao
DOT             : '.';
COMA            : ',';
SEMICOLON       : ';';
LEFTBRACE       : '{';
RIGHTBRACE      : '}';
LEFTBRACKET     : '[';
RIGHTBRACKET    : ']';
LEFTPARENTESIS  : '(';
RIGHTPARENTESIS : ')';

// Atribuiçao
ASSIGN          : '=';

// Comentarios (Retirados da Gramatica de C)
BLOCKCOMMENT
    : '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINECOMMENT
    : '//' ~[\r\n]* -> channel(HIDDEN)
    ;

//Operadores Aritmeticos
ADD         :'+';
SUBTRACT    :'-';
MULTIPLY    :'*';
DIVIDE      :'/';
MODULE      :'%';

// Operadores Logicos
NOT         :'!';
AND         :'&&';
OR          :'||';
LT          :'<';
GT          :'>';
LEQ         :'<=';
GEQ         :'>=';
EQUAL       :'==';
NOTEQUAL    :'!=';

// Variaveis
INT :'int';
DOUBLE : 'double';

// Funçoes
VOID : 'void';
RETURN : 'return';

// Literais (Definem o que e uma uma variavel)
DOUBLE_LITERAL : [0-9]+ DOT [0-9]+ | DOT [0-9]+ ;

// Para int escolhemos não permitir numeros começados por 0 alem de 0 em si
INT_LITERAL    : '0' | [1-9][0-9]*;
STRING_LITERAL : '"' (STR_ESCAPE | ~["\\\r\n])* '"' ;


// Permite a inserçao de caracteres especiais dentro de um string literal
fragment STR_ESCAPE
    : '\\' [btnrf"\\]
    ;

// Condicionais
IF  :   'if';
ELSE :  'else';

//Loops
WHILE           :'while';
FOR             :'for';

// WRITE
WRITE           :'write';
WRITEC          :'writec';
WRITEV          :'writev';
WRITES          :'writes';

// READS
READ            :'read';
READC           :'readc';
READS           :'reads';

// Identifiers
IDENTIFIER   : [a-zA-Z_][a-zA-Z0-9_]*;
DIGIT        : [0-9]+ ;

// Espaços em branco
SPACE   : [ \t\r\n]+ -> skip;


/******************** REGRAS ********************/

// Regra de inicio do programa
program
    : (funcDeclaration | funcDefinition | statement)* EOF
    ;

// Statements
statement
    : readStatement
    | writeStatement
    | assignment
    | declaration
    | loop
    | conditional
    | returnStatement
    | blockStatement
    | expression SEMICOLON
    ;

// Block statement permite a criaçao de blocos, { ( x= 4) }  por exemplo
blockStatement
    : LEFTBRACE statement* RIGHTBRACE
    ;

returnStatement
    : RETURN expression SEMICOLON
    ;

readStatement
    : READ LEFTPARENTESIS IDENTIFIER RIGHTPARENTESIS SEMICOLON
    | READC LEFTPARENTESIS IDENTIFIER RIGHTPARENTESIS SEMICOLON
    | READS LEFTPARENTESIS IDENTIFIER RIGHTPARENTESIS SEMICOLON
    ;

writeStatement
    : WRITE LEFTPARENTESIS expression RIGHTPARENTESIS SEMICOLON
    | WRITEC LEFTPARENTESIS expression RIGHTPARENTESIS SEMICOLON
    | WRITEV LEFTPARENTESIS expression RIGHTPARENTESIS SEMICOLON
    | WRITES LEFTPARENTESIS (expression | STRING_LITERAL) RIGHTPARENTESIS SEMICOLON
    ;

// Assignement permite a criaçao de assignments a variaveis ja existentes. Por exemplo, (x =4) permitindo mudar o valor da variavel
assignment
    : assignable ASSIGN expression SEMICOLON
    ;

// assignable e a lista do que é possivel designar, funciona para ambos variaveis regular e elementos de um array
assignable
    : IDENTIFIER
    | IDENTIFIER LEFTBRACKET expression RIGHTBRACKET
    ;

// Expressions
expression
    : assExpr
    ;

// permite a criaçao de assigment expressions
assExpr
    : IDENTIFIER ASSIGN assExpr
    | orExpr
    ;

orExpr
    :andExpr (OR andExpr)*
    ;

andExpr
    : relExpr (AND relExpr)*
    ;

relExpr
    : addExpr ( (LT | GT | LEQ | GEQ | EQUAL | NOTEQUAL ) addExpr )*
    ;

addExpr
    : mulExpr ( (ADD | SUBTRACT) mulExpr )*
    ;

mulExpr
    : unaryExpr ( (MULTIPLY | DIVIDE) unaryExpr )*
    ;

unaryExpr
    : NOT unaryExpr
    | SUBTRACT unaryExpr
    | castExpr
    | primeExpr
    ;

// Permite casting
castExpr
    : LEFTPARENTESIS varType RIGHTPARENTESIS unaryExpr
    ;

// Primary expression
primeExpr
    : readFunc LEFTPARENTESIS RIGHTPARENTESIS
    // A linha a baixo permite algo como v[0] = 1
    | IDENTIFIER LEFTBRACKET expression RIGHTBRACKET
    | IDENTIFIER LEFTPARENTESIS expressionList? RIGHTPARENTESIS
    | IDENTIFIER
    | INT_LITERAL
    | DOUBLE_LITERAL
    | LEFTPARENTESIS expression RIGHTPARENTESIS
    // Array literal como expressao literal
    | LEFTBRACE expressionList RIGHTBRACE
    ;

// Lista de expressoes separadas por virgula
expressionList
    : expression (COMA expression)*
    ;

// Funtions

// Permite a criaçao de declaraçoes de prototipos de funçoes int add(int,int);
funcDeclaration
    : funcType IDENTIFIER LEFTPARENTESIS parameterList? RIGHTPARENTESIS SEMICOLON
    ;

// Permite defenir funçoes.
funcDefinition
    : funcType IDENTIFIER LEFTPARENTESIS parameterList? RIGHTPARENTESIS blockStatement
    ;

// Readfunction, permite a criaçao de n = read() por exemplo
readFunc
    : READ
    | READC
    | READS
    ;

// Permite a inserçao de mais que um parametro numa funçao
parameterList
    : parameter (COMA parameter)*
    ;

// permite a criaçao de um parametro, para ser inserido numa funçao
parameter
    // Permite arrays como parametros
    : funcType IDENTIFIER LEFTBRACKET RIGHTBRACKET
    // "?" está presento caso se queira declarar um parametro sem nome
    | funcType IDENTIFIER?
    ;

// Tipo de funçoes, para nao rescrever int e double, usou se a lista de variaveis ja presente
funcType
    : VOID
    | varType
    ;

// Variable initialization
declaration
    : varType variableInit ( COMA variableInit | varType )* SEMICOLON;

variableInit
    : IDENTIFIER ( ASSIGN expression | varType )?
    | IDENTIFIER LEFTBRACKET expression? RIGHTBRACKET (ASSIGN arrayLiteral)?
    ;

// Literal de Arrays Define um array como uma lista de expressões entre chaves
arrayLiteral
    : LEFTBRACE expressionList RIGHTBRACE
    ;

// Tipos de variaveis
varType
    : INT ( LEFTBRACKET RIGHTBRACKET )?
    | DOUBLE ( LEFTBRACKET RIGHTBRACKET )?
    ;

// Para ambos Loops e condicionais usamos blockStatement em vez de statement visto que no enunciado nos foi declarado
// que todas as estruturas deviam ter chavetas

// Loops
loop
    : FOR LEFTPARENTESIS expression SEMICOLON expression SEMICOLON expression RIGHTPARENTESIS blockStatement
    | WHILE LEFTPARENTESIS expression RIGHTPARENTESIS blockStatement
    ;
// Conditionais
conditional
    : IF LEFTPARENTESIS expression RIGHTPARENTESIS blockStatement ( ELSE blockStatement )?
    ;



