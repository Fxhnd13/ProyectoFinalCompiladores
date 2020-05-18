
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores.Json;

import Analizadores.Objetos.Atributo;
import Analizadores.Objetos.Token;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserJson extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserJson() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserJson(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserJson(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\014\000\002\002\004\000\002\002\004\000\002\003" +
    "\004\000\002\004\004\000\002\004\003\000\002\004\004" +
    "\000\002\004\005\000\002\005\005\000\002\005\005\000" +
    "\002\005\004\000\002\006\003\000\002\006\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\004\007\005\001\002\000\004\002\032\001" +
    "\002\000\006\003\011\005\006\001\002\000\004\011\025" +
    "\001\002\000\004\002\000\001\002\000\010\003\016\006" +
    "\015\010\020\001\002\000\006\006\012\010\013\001\002" +
    "\000\006\003\011\005\006\001\002\000\010\003\ufff8\006" +
    "\ufff8\010\ufff8\001\002\000\010\003\ufff9\006\ufff9\010\ufff9" +
    "\001\002\000\006\003\011\005\006\001\002\000\006\006" +
    "\021\010\022\001\002\000\012\002\uffff\003\uffff\006\uffff" +
    "\010\uffff\001\002\000\012\002\ufffd\003\ufffd\006\ufffd\010" +
    "\ufffd\001\002\000\006\003\011\005\006\001\002\000\012" +
    "\002\ufffc\003\ufffc\006\ufffc\010\ufffc\001\002\000\012\002" +
    "\ufffb\003\ufffb\006\ufffb\010\ufffb\001\002\000\012\002\ufffe" +
    "\003\ufffe\006\ufffe\010\ufffe\001\002\000\006\004\026\007" +
    "\030\001\002\000\010\003\ufff7\006\ufff7\010\ufff7\001\002" +
    "\000\010\003\ufffa\006\ufffa\010\ufffa\001\002\000\006\003" +
    "\011\005\006\001\002\000\010\003\ufff6\006\ufff6\010\ufff6" +
    "\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\030\000\004\002\003\001\001\000\002\001\001\000" +
    "\006\003\006\005\007\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\004\016\001\001\000\002\001\001\000" +
    "\006\003\013\005\007\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\003\023\005\007\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\003\022" +
    "\005\007\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\026\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\003\030\005\007\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserJson$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserJson$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserJson$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



        
        private List<String> listErrores = new ArrayList<String>();

        public List<String> getErrores(){
            return listErrores;
        }
        
        public ParserJson(LexerJson lex) { 
            super(lex);   
            listErrores = lex.getErrorsList();
	}
        
        public void setAccion(String tipo, String mensaje, String accion){
            System.out.println(tipo+"         "+mensaje);
        }

        public void unrecovered_syntax_error(Symbol cur_token){
            System.err.println("Couldn't repair and continue parse "+cur_token.value);
        }

        public void syntax_error(Symbol s){
            String message = "";
            StringBuilder m = new StringBuilder("Error:");
            String cadena = ((Token)s.value).getLexema();
            int linea = (((Token)s.value).getLinea());
            int columna = (((Token)s.value).getColumna());
            switch(s.toString()){
            }
            listErrores.add("Se ha encontrado un error en la linea: "+linea+", columna: "+columna+" con la cadena "+cadena+"|Descripcion: <falta implementar>");
        }
        


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserJson$actions {
  private final ParserJson parser;

  /** Constructor */
  CUP$ParserJson$actions(ParserJson parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserJson$do_action_part00000000(
    int                        CUP$ParserJson$act_num,
    java_cup.runtime.lr_parser CUP$ParserJson$parser,
    java.util.Stack            CUP$ParserJson$stack,
    int                        CUP$ParserJson$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserJson$result;

      /* select the action based on the action number */
      switch (CUP$ParserJson$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)).right;
		List<Atributo> start_val = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)).value;
		RESULT = start_val;
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserJson$parser.done_parsing();
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= LLAVE_A Asigs 
            {
              List<Atributo> RESULT =null;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).right;
		List<Atributo> atributo = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserJson$stack.peek()).value;
		
                            if(atributo == null) atributo = new ArrayList<Atributo>();
                            RESULT = atributo;
                        
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Asigs ::= Asig AsigsPrima 
            {
              List<Atributo> RESULT =null;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)).right;
		Atributo atributo = (Atributo)((java_cup.runtime.Symbol) CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)).value;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserJson$stack.peek()).value;
		
                            if(listAtributos == null) listAtributos = new ArrayList<Atributo>();
                            if(atributo != null) listAtributos.add(atributo);
                            RESULT = listAtributos;
                        
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("Asigs",1, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // AsigsPrima ::= COMA Asigs 
            {
              List<Atributo> RESULT =null;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserJson$stack.peek()).value;
		
                            if(listAtributos == null) listAtributos = new ArrayList<Atributo>();
                            RESULT = listAtributos;
                        
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("AsigsPrima",2, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // AsigsPrima ::= LLAVE_C 
            {
              List<Atributo> RESULT =null;

              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("AsigsPrima",2, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // AsigsPrima ::= error LLAVE_C 
            {
              List<Atributo> RESULT =null;

              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("AsigsPrima",2, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // AsigsPrima ::= error COMA Asigs 
            {
              List<Atributo> RESULT =null;

              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("AsigsPrima",2, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-2)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Asig ::= ID ASIGNACION param 
            {
              Atributo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-2)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-2)).right;
		Token valor = (Token)((java_cup.runtime.Symbol) CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-2)).value;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).right;
		Atributo atributo = (Atributo)((java_cup.runtime.Symbol) CUP$ParserJson$stack.peek()).value;
		
                            if(atributo != null){
                                if(atributo.getValor() != null) {
                                    atributo.setTipo(valor.getLexema());
                                }else{
                                    atributo = null;
                                }
                            }
                            RESULT = atributo;
                        
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("Asig",3, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-2)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Asig ::= error COMA Asigs 
            {
              Atributo RESULT =null;

              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("Asig",3, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-2)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Asig ::= error LLAVE_C 
            {
              Atributo RESULT =null;

              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("Asig",3, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // param ::= VALOR 
            {
              Atributo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).right;
		Token valor = (Token)((java_cup.runtime.Symbol) CUP$ParserJson$stack.peek()).value;
		
                            Atributo atributo = new Atributo();
                            atributo.setValor(valor.getLexema());
                            RESULT = atributo;
                        
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("param",4, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // param ::= LLAVE_A Asigs 
            {
              Atributo RESULT =null;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserJson$stack.peek()).value;
		
                            Atributo atributo = new Atributo();
                            atributo.setValor(listAtributos);
                            RESULT = atributo;
                        
              CUP$ParserJson$result = parser.getSymbolFactory().newSymbol("param",4, ((java_cup.runtime.Symbol)CUP$ParserJson$stack.elementAt(CUP$ParserJson$top-1)), ((java_cup.runtime.Symbol)CUP$ParserJson$stack.peek()), RESULT);
            }
          return CUP$ParserJson$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserJson$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserJson$do_action(
    int                        CUP$ParserJson$act_num,
    java_cup.runtime.lr_parser CUP$ParserJson$parser,
    java.util.Stack            CUP$ParserJson$stack,
    int                        CUP$ParserJson$top)
    throws java.lang.Exception
    {
              return CUP$ParserJson$do_action_part00000000(
                               CUP$ParserJson$act_num,
                               CUP$ParserJson$parser,
                               CUP$ParserJson$stack,
                               CUP$ParserJson$top);
    }
}

}
