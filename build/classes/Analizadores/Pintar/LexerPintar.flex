package Analizadores.Pintar;

import static Analizadores.Pintar.sym.*;
import Analizadores.Objetos.Token;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%

%class LexerPintar
%public
%cup
%line
%column

/* special chars */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = [ \t\f]+

/* identifiers */
L = [a-zA-Z]

/* integer literals */
Digito = [0-9]
IntegerLiteral = 0 | [1-9]{Digito}*

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment   = "/*" [^*] ~"*/"
Cadena               = "\"" [^*] ~"\""
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?

%{
    private List<String> errorsList;
    private List<Token> tokens;

    private Symbol symbol(int type) {
        String lexeme = yytext();
        tokens.add(new Token(lexeme, yyline+1, yycolumn+1, type));
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1, type));
    }

    private Symbol symbol(int type, String lexeme) {
        tokens.add(new Token(lexeme, yyline+1, yycolumn+1, type));
        return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1, type));
    }

    private void error(String lexeme) {
        errorsList.add("Se encontro un caracter/simbolo desconocido en la linea: "+yyline+", columna: "+yycolumn+" con el simbolo "+lexeme);
    }

    public List<Token> getTokensList(){
        return tokens;
    }

    public List<String> getErrorsList() {
        return errorsList;
    }
%}

%init{
    tokens = new ArrayList<>();
    errorsList = new ArrayList<>();
%init}


%%

/* reglas lexicas */
<YYINITIAL> {

    /* Reserved words */
    "VARS"                                  { return symbol(PR_VARS);}
    "int"                                   { return symbol(PR_INT);}
    "String"                                { return symbol(PR_STRING);}
    "boolean"                               { return symbol(PR_BOOLEAN);}
    "true"                                  { return symbol(BOOLEAN);}
    "false"                                 { return symbol(BOOLEAN);}
    "INSTRUCCIONES"                         { return symbol(PR_INSTRUCCIONES);}
    "PINTAR"                                { return symbol(PR_PINTAR);}
    ".."                                    { return symbol(PR_RANGE);}
    "if"                                    { return symbol(PR_IF);}
    "else"                                  { return symbol(PR_ELSE);}
    "while"                                 { return symbol(PR_WHILE);}
    {Comment}                               { /*ignore*/}
    "+"                                     { return symbol(S_SUMA);}
    "-"                                     { return symbol(S_RESTA);}
    "*"                                     { return symbol(S_MUL);}
    "/"                                     { return symbol(S_DIV);}
    "<"                                     { return symbol(COMPARADOR);}
    ">"                                     { return symbol(COMPARADOR);}
    "=="                                    { return symbol(COMPARADOR);}
    "<="                                    { return symbol(COMPARADOR);}
    ">="                                    { return symbol(COMPARADOR);}
    "<>"                                    { return symbol(COMPARADOR);}
    ";"                                     { return symbol(FINAL);}
    ","                                     {   return symbol(COMA);                  }
    "{"                                     {   return symbol(LLAVE_A);}
    "}"                                     {   return symbol(LLAVE_C);}
    "["                                     {   return symbol(CORCHETE_A);}
    "]"                                     {   return symbol(CORCHETE_C);}
    "("                                     {   return symbol(PARENTESIS_A);}
    ")"                                     {   return symbol(PARENTESIS_C);}
    "="                                     {   return symbol(ASIGNACION);              }
    {Cadena}                                {   return symbol(CADENA);}
    {IntegerLiteral}                        {   return symbol(ENTERO, yytext());        }
    ({L}|("\_"))({L}|{Digito}|("\_"))*      {   return symbol(ID, yytext());            }
    {LineTerminator}                        {   /*return symbol(FIN_LINEA);*/               }

    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

}

/* error fallback */
[^]                              {   error(yytext());    }
