package Analizadores.Lienzos;

import static Analizadores.Lienzos.sym.*;
import Objetos.Token;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%

%class LexerLienzo
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

    /* Reserved words */
    "Red"                           {   return symbol(PR_RED);              }
    "Blue"                          {   return symbol(PR_BLUE); }
    "Green"                         {   return symbol(PR_GREEN); }
    "LIENZOS"                       {   return symbol(PR_LIENZOS);}
    "nombre"                        {   return symbol(PR_NOMBRE);}
    "tipo"                          {   return symbol(PR_TIPO);}
    "Fondo"                         {   return symbol(PR_FONDO);}
    "tama\ño"                       {   return symbol(PR_TAMANO);}
    "cuadro"                        {   return symbol(PR_CUADRO);}
    "dimension_x"                   {   return symbol(PR_DX);}  
    "dimension_y"                   {   return symbol(PR_DY);}
    "HEX"                           {   return symbol(PR_HEX);}
    ("png")|("gif")                 {   return symbol(EXTENSION, yytext());}

    {LineTerminator}                {   /*return symbol(FIN_LINEA);*/               }
    {IntegerLiteral}                {   return symbol(ENTERO, yytext());        }
    {Hexadecimal}                   {   return symbol(HEX, yytext());           }
    ({L})({L}|{Digito}|"_")*        {   return symbol(ID, yytext());            }
    ","                             {   return symbol(COMA);                  }
    "{"                             {   return symbol(LLAVE_A);}
    "}"                             {   return symbol(LLAVE_C);}
    ":"                             {   return symbol(ASIGNACION);              }

    "\""                            {   return symbol(COMILLA);}

    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

}

/* error fallback */
[^]                              {   error(yytext());    }