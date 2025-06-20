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

// Atribuicao
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

// Funcoes
VOID : 'void';
RETURN : 'return';

// Literais (Definem o que e uma uma variavel)
DOUBLE_LITERAL : [0-9]+ DOT [0-9]+ | DOT [0-9]+ ;

// Para int escolhemos nao permitir numeros comecados por 0 alem de 0 em si
INT_LITERAL    : '0' | [1-9][0-9]*;

// Literal de caractere
CHAR_LITERAL   : '\'' (~['\\\r\n] | STR_ESCAPE) '\'' ;

// String literal atualizado para aceitar caracteres especiais
STRING_LITERAL : '"' (STR_ESCAPE | ~["\\\r\n])* '"' ;

// Permite a insercao de caracteres especiais dentro de um string literal
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

// Identifiers - atualizado para aceitar caracteres especiais
IDENTIFIER   : [a-zA-Z\u00C0-\u00FF_][a-zA-Z0-9\u00C0-\u00FF_]*;
DIGIT        : [0-9]+ ;

// Espacos em branco
SPACE   : [ \t\r\n]+ -> skip;


/******************** REGRAS ********************/

// Regra de inicio do programa
program
    : (funcDeclaration | funcDefinition | statement)* EOF
    ;

// ADICIONADO
// a local prototype/declaration (no body)
localFuncDecl
    : funcType IDENTIFIER LEFTPARENTESIS parameterList? RIGHTPARENTESIS SEMICOLON
    ;

// a local definition (with a block)
localFuncDef
    : funcType IDENTIFIER LEFTPARENTESIS parameterList? RIGHTPARENTESIS blockStatement
    ;

// Statements
statement
    : readStatement
    | writeStatement
    | localFuncDecl
    | localFuncDef
    | assignment
    | declaration
    | loop
    | conditional
    | returnStatement
    | blockStatement
    | expression SEMICOLON
    ;

// Block statement permite a criacao de blocos, { ( x= 4) }  por exemplo
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

// Assignement permite a criacao de assignments a variaveis ja existentes. Por exemplo, (x =4) permitindo mudar o valor da variavel
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

// permite a criacao de assigment expressions
assExpr
    : IDENTIFIER ASSIGN assExpr
    | orExpr
    ;

orExpr
    : andExpr (OR andExpr)*
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
    | IDENTIFIER LEFTBRACKET expression RIGHTBRACKET
    | IDENTIFIER LEFTPARENTESIS expressionList? RIGHTPARENTESIS
    | IDENTIFIER
    | intLiteral
    | doubleLiteral
    | charLiteral
    | stringLiteral
    | LEFTPARENTESIS expression RIGHTPARENTESIS
    | LEFTBRACE expressionList RIGHTBRACE
    ;

// Literais com verificacao de tipo
intLiteral
    : INT_LITERAL
    ;

doubleLiteral
    : DOUBLE_LITERAL
    ;

charLiteral
    : CHAR_LITERAL
    ;

stringLiteral
    : STRING_LITERAL
    ;

// Lista de expressoes separadas por virgula
expressionList
    : expression (COMA expression)*
    ;

// Funtions

// Permite a criacao de declaracoes de prototipos de funcoes int add(int,int);
funcDeclaration
    : funcType IDENTIFIER LEFTPARENTESIS parameterList? RIGHTPARENTESIS SEMICOLON
    ;

// Permite defenir funcoes.
funcDefinition
    : funcType IDENTIFIER LEFTPARENTESIS parameterList? RIGHTPARENTESIS blockStatement
    ;

// Readfunction, permite a criacao de n = read() por exemplo
readFunc
    : READ
    | READC
    | READS
    ;

// Permite a insercao de mais que um parametro numa funcao
parameterList
    : parameter (COMA parameter)*
    ;

// permite a criacao de um parametro, para ser inserido numa funcao
parameter
    // Permite arrays como parametros
    : funcType IDENTIFIER LEFTBRACKET RIGHTBRACKET
    // "?" está presento caso se queira declarar um parametro sem nome
    | funcType IDENTIFIER?
    ;

// Tipo de funcoes, para nao rescrever int e double, usou se a lista de variaveis ja presente
funcType
    : VOID
    | varType
    ;

// Variable initialization
declaration
    : varType variableInit (COMA variableInit)* SEMICOLON
    ;

variableInit
    : IDENTIFIER (ASSIGN expression)?
    | IDENTIFIER LEFTBRACKET expression? RIGHTBRACKET (ASSIGN (arrayLiteral | expression))?
    ;

// Literal de Arrays Define um array como uma lista de expressões entre chaves
arrayLiteral
    : LEFTBRACE expressionList RIGHTBRACE
    ;

// Tipos de variaveis
varType
    : INT (LEFTBRACKET RIGHTBRACKET)?
    | DOUBLE (LEFTBRACKET RIGHTBRACKET)?
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