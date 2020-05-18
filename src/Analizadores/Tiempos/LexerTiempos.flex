package Analizadores.Tiempos;

import static Analizadores.Tiempos.sym.*;
import Objetos.Token;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

%%

%class LexerTiempos
%public
%cup
%line
%column

/* special chars */
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]+

/* identifiers */
L = [a-zA-Z_]

/* integer literals */
Digito = [0-9]
IntegerLiteral = 0 | [1-9][0-9]*

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
    "inicio"                        {   return symbol(PR_INICIO); }
    "fin"                           {   return symbol(PR_FIN);  }
    "imagenes"                      {   return symbol(PR_IMAGENES); }
    "id"                            {   return symbol(PR_ID);   }
    "duracion"                      {   return symbol(PR_DURACION); }
    "TIEMPOS"                       {   return symbol(PR_TIEMPOS);}

    {LineTerminator}                {   /*return symbol(FIN_LINEA);*/               }
    {IntegerLiteral}                {   return symbol(ENTERO, yytext());        }
    ({L}|("\_"))({L}|{Digito}|("\_"))*        {   return symbol(ID, yytext());            }
    ","                             {   return symbol(COMA);                  }
    "{"                             {   return symbol(LLAVE_A);}
    "}"                             {   return symbol(LLAVE_C);}
    ":"                             {   return symbol(ASIGNACION);              }
    "["                             {   return symbol(CORCHETE_A);  }
    "]"                             {   return symbol(CORCHETE_C);  }
    "\""                            {   return symbol(COMILLA);}

    {WhiteSpace} 	{   /*return symbol(WHITESPACE); */  }

}

/* error fallback */
[^]                              {   error(yytext());    }
