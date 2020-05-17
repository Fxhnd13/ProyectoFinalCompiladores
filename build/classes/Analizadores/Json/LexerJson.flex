package Analizadores.Json;

import static Analizadores.Json.sym.*;
import Objetos.Token;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%

%class LexerJson
%public
%cup
%line
%column

/* special chars */
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]+

/* identifiers */
L = [a-zA-Z]

/* integer literals */
Digito = [0-9]
IntegerLiteral = 0 | [1-9][0-9]*

/* hexa literal */
Hexadecimal = #[0-9a-fA-F0]{6}

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

    {LineTerminator}                {   /*return symbol(FIN_LINEA);*/               }
    {IntegerLiteral}                {   return symbol(VALOR, yytext());        }
    {Hexadecimal}                   {   return symbol(VALOR, yytext());           }
    ({L})({L}|{Digito}|"_")*        {   return symbol(ID, yytext());            }
    ("\"")({L}|{Digito}|(" ")|("_"))*("\"") {   return symbol(VALOR, yytext()); }
    ","                             {   return symbol(COMA);                  }
    "{"                             {   return symbol(LLAVE_A);}
    "}"                             {   return symbol(LLAVE_C);}
    ":"                             {   return symbol(ASIGNACION);              }

    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

}

/* error fallback */
[^]                              {   error(yytext());    }
