
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores.Tiempos;

import Analizadores.Objetos.Atributo;
import Analizadores.Objetos.Token;
import Objetos.Tiempo;
import Objetos.Imagen;
import Objetos.Lienzo;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class ParserTiempos extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public ParserTiempos() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public ParserTiempos(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserTiempos(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\021\000\002\002\004\000\002\002\011\000\002\003" +
    "\005\000\002\003\003\000\002\004\007\000\002\005\005" +
    "\000\002\005\003\000\002\007\007\000\002\007\007\000" +
    "\002\007\007\000\002\012\005\000\002\012\003\000\002" +
    "\011\005\000\002\006\005\000\002\006\003\000\002\010" +
    "\007\000\002\010\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\065\000\004\015\005\001\002\000\004\002\067\001" +
    "\002\000\004\011\006\001\002\000\004\021\007\001\002" +
    "\000\004\015\010\001\002\000\004\013\011\001\002\000" +
    "\004\021\020\001\002\000\006\014\ufffe\016\ufffe\001\002" +
    "\000\006\014\014\016\015\001\002\000\004\013\011\001" +
    "\002\000\004\016\016\001\002\000\004\002\000\001\002" +
    "\000\006\014\uffff\016\uffff\001\002\000\004\015\021\001" +
    "\002\000\010\004\023\005\024\006\022\001\002\000\004" +
    "\021\042\001\002\000\004\021\036\001\002\000\004\021" +
    "\032\001\002\000\006\014\ufffb\016\ufffb\001\002\000\006" +
    "\014\027\016\030\001\002\000\010\004\023\005\024\006" +
    "\022\001\002\000\006\014\ufffd\016\ufffd\001\002\000\006" +
    "\014\ufffc\016\ufffc\001\002\000\004\022\033\001\002\000" +
    "\004\013\034\001\002\000\004\022\035\001\002\000\006" +
    "\014\ufff9\016\ufff9\001\002\000\004\022\037\001\002\000" +
    "\004\013\040\001\002\000\004\022\041\001\002\000\006" +
    "\014\ufffa\016\ufffa\001\002\000\004\017\043\001\002\000" +
    "\004\015\045\001\002\000\006\014\ufff6\020\ufff6\001\002" +
    "\000\006\007\054\010\053\001\002\000\006\014\047\020" +
    "\050\001\002\000\004\015\045\001\002\000\006\014\ufff8" +
    "\016\ufff8\001\002\000\006\014\ufff7\020\ufff7\001\002\000" +
    "\006\014\ufff3\016\ufff3\001\002\000\004\021\065\001\002" +
    "\000\004\021\061\001\002\000\006\014\056\016\057\001" +
    "\002\000\006\007\054\010\053\001\002\000\006\014\ufff5" +
    "\020\ufff5\001\002\000\006\014\ufff4\016\ufff4\001\002\000" +
    "\004\022\062\001\002\000\004\013\063\001\002\000\004" +
    "\022\064\001\002\000\006\014\ufff2\016\ufff2\001\002\000" +
    "\004\012\066\001\002\000\006\014\ufff1\016\ufff1\001\002" +
    "\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\065\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\003\012\004\011\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\005\025\007\024\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\007\030\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\011\043\012\045\001\001\000\002\001\001" +
    "\000\006\006\054\010\051\001\001\000\002\001\001\000" +
    "\004\011\050\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\010\057\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserTiempos$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserTiempos$actions(this);
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
    return action_obj.CUP$ParserTiempos$do_action(act_num, parser, stack, top);
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
        private List<Lienzo> listLienzos = new ArrayList<Lienzo>();

        public List<String> getErrores(){
            return listErrores;
        }
        
        public List<Lienzo> getLienzos(){
            return listLienzos;
        }

        public ParserTiempos(LexerTiempos lex, List<Lienzo> lienzos) { 
            super(lex);   
            listLienzos = lienzos;
            listErrores = lex.getErrorsList();
	}

        public void unrecovered_syntax_error(Symbol cur_token){
            System.err.println("Couldn't repair and continue parse "+((Token)cur_token.value).getLexema());
        }

        public void syntax_error(Symbol s){
            String message = "";
            StringBuilder m = new StringBuilder("Error:");
            String cadena = ((Token)s.value).getLexema();
            int linea = (((Token)s.value).getLinea());
            int columna = (((Token)s.value).getColumna());
            switch(s.toString()){
                case "#2": case "#3": case "#4": case "#5": case "#6": case "#7": {
                    message = "No se esperaba una palabra reservada, probablemente hace falta un fin de linea anteriormente";
                    break;
                }
                case "#8": message = "No se esperaba un entero, verifique que el tipo de dato del atributo que desea asignar, sea un entero"; break;
                case "#9": message = "No se esperaba un id, verifique se se haya finalizado correctamente la linea anterior"; break;
                case "#10": message = "No se esperaba una coma, verifique que efectivamente se trate de un fin de linea"; break;
                case "#11": message = "No se esperaba una llave abierta"; break;
                case "#12": message = "No se esperaba una llave cerrada"; break;
                case "#13": message = "No se esperaba un corchete abierto"; break;
                case "#14": message = "No se esperaba un corchete cerrado"; break;
                case "#15": message = "No se esperaba una asignacion, verifique que antes se encuentre un id o una palabra reservada"; break;
                case "#16": message = "No se esperaba una comilla, verifique que el tipo de dato del atributo que desea asignar, sea una cadena"; break;
            }
            listErrores.add("Se ha encontrado un error en la linea: "+linea+", columna: "+columna+" con la cadena "+cadena+"|Descripcion: "+message);
        }
        


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$ParserTiempos$actions {



    private boolean isValido(Imagen imagen){
        boolean valor = true;
        if(imagen.getId()==null) {
            listErrores.add("Hay un error con la imagen declarada en la linea: "+imagen.getLineaT()+", columna: "+imagen.getColumnaT()+" no posee un id");
            valor = false;
        }
        if(imagen.getDuracion()==(-1)){
            listErrores.add("Hay un error con la imagen declarada en la linea: "+imagen.getLineaT()+", columna: "+imagen.getColumnaT()+" no posee una duracion");
            valor = false;
        }
        return valor;
    }

    private boolean isValido(Tiempo tiempo){
        boolean valor = true;
        if(tiempo.getIdInicio()!= null && tiempo.getIdFin()!=null){
            if(tiempo.existe(tiempo.getIdInicio()) && tiempo.existe(tiempo.getIdFin())){
                if(tiempo.getIndice(tiempo.getIdInicio()) >= tiempo.getIndice(tiempo.getIdFin())){
                    listErrores.add("El idInicio se encuentra después que el idFin, en el tiempo del lienzo declarado en la linea : "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT());
                    valor = false;
                }
            }else{
                if(!tiempo.existe(tiempo.getIdInicio())){
                    listErrores.add("No existe el idInicio, en la lista de imagenes, en el tiempo del lienzo declarado en la linea: "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT());
                    valor = false;
                }
                if(!tiempo.existe(tiempo.getIdFin())) {
                    listErrores.add("No existe el idFin, en la lista de imagenes, en el tiempo del lienzo declarado en la linea : "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT());
                    valor= false;
                }
            }
        }else{
            if(tiempo.getIdInicio() == null){
                listErrores.add("Hay un error con el tiempo del lienzo declarado en la linea: "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT()+" no posee un idInicio");
                valor = false;
            }else{
                if(!tiempo.existe(tiempo.getIdInicio())){
                    listErrores.add("No existe el idInicio, en la lista de imagenes, en el tiempo del lienzo declarado en la linea: "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT());
                    valor = false;
                }
            }
            if(tiempo.getIdFin() == null){
                valor = false;
                listErrores.add("Hay un error con el tiempo del lienzo declarado en la linea: "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT()+" no posee un idFIn");
            }else{
                if(!tiempo.existe(tiempo.getIdFin())) {
                    listErrores.add("No existe el idFin, en la lista de imagenes, en el tiempo del lienzo declarado en la linea : "+tiempo.getLineaT()+", columna: "+tiempo.getColumnaT());
                    valor = false;
                }
            }
        }
        return valor;
    }

    private void inicializarTiempo(Tiempo tiempo, List<Atributo> atributos){
        for(Atributo atributo : atributos){
            switch(atributo.getTipo()){
                case "inicio":{
                    if(tiempo.getIdInicio() != null){
                        listErrores.add("Ya existe un valor asignado, atributo inicio repetido en la linea: "+atributo.getLinea()+", columna: "+atributo.getColumna());
                    }else{
                        tiempo.setIdInicio((String)atributo.getValor());
                    }
                    break;
                }
                case "fin":{
                    if(tiempo.getIdFin() != null){
                        listErrores.add("Ya existe un valor asignado, atributo fin repetido en la linea: "+atributo.getLinea()+", columna: "+atributo.getColumna());
                    }else{
                        tiempo.setIdFin((String)atributo.getValor());
                    }
                    break;
                }
                case "imagenes":{
                    if(!tiempo.getImagenes().isEmpty()){
                        listErrores.add("Ya existe un valor asignado, atributo imagenes repetido en la linea: "+atributo.getLinea()+", columna: "+atributo.getColumna());
                    }else{
                        tiempo.setImagenes((List<Imagen>)atributo.getValor());
                    }
                    break;
                }
            }
        }
    }

    private void inicializarImagen(Imagen imagen, List<Atributo> atributos){
        for(Atributo atributo : atributos){
            switch(atributo.getTipo()){
                case "id":{
                    if(imagen.getId() != null){
                        listErrores.add("Ya existe un valor asignado, atributo id repetido en la linea: "+atributo.getLinea()+", columna: "+atributo.getColumna());
                    }else{
                        imagen.setId((String) atributo.getValor());
                    }
                    break;
                }
                case "duracion":{
                    if(imagen.getDuracion() != (-1)){
                        listErrores.add("Ya existe un valor asignado, atributo duracion repetido en la linea: "+atributo.getLinea()+", columna: "+atributo.getColumna());
                    }else{
                        imagen.setDuracion(Integer.parseInt((String)atributo.getValor()));
                    }
                    break;
                }
            }
        }
    }

    private Lienzo getLienzoPorId(String id){
        Lienzo lienzo = null;
        for(Lienzo temp : listLienzos){
            if(temp.getId().equals(id)) lienzo = temp;
        }
        return lienzo;
    }


  private final ParserTiempos parser;

  /** Constructor */
  CUP$ParserTiempos$actions(ParserTiempos parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$ParserTiempos$do_action_part00000000(
    int                        CUP$ParserTiempos$act_num,
    java_cup.runtime.lr_parser CUP$ParserTiempos$parser,
    java.util.Stack            CUP$ParserTiempos$stack,
    int                        CUP$ParserTiempos$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserTiempos$result;

      /* select the action based on the action number */
      switch (CUP$ParserTiempos$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		RESULT = start_val;
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserTiempos$parser.done_parsing();
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= LLAVE_A PR_TIEMPOS ASIGNACION LLAVE_A strTiempos LLAVE_C LLAVE_C 
            {
              Object RESULT =null;

              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-6)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // strTiempos ::= strTiempos COMA inicioTiemposLienzo 
            {
              Object RESULT =null;

              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("strTiempos",1, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // strTiempos ::= inicioTiemposLienzo 
            {
              Object RESULT =null;

              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("strTiempos",1, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // inicioTiemposLienzo ::= ID ASIGNACION LLAVE_A strTiempo LLAVE_C 
            {
              Object RESULT =null;
		int lienzoleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).left;
		int lienzoright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).right;
		Token lienzo = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).value;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		
                                            Tiempo tiempo = new Tiempo();
                                            if(listAtributos != null){
                                                inicializarTiempo(tiempo, listAtributos);
                                                tiempo.setLineaT(lienzo.getLinea());
                                                tiempo.setColumnaT(lienzo.getColumna());
                                                if(getLienzoPorId(lienzo.getLexema()) != null){
                                                    if(isValido(tiempo)) getLienzoPorId(lienzo.getLexema()).setTiempos(tiempo);
                                                }else{
                                                    listErrores.add("No existe el lienzo escrito, en la linea: "+lienzo.getLinea()+", columna: "+lienzo.getColumna());
                                                }
                                            }
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("inicioTiemposLienzo",2, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // strTiempo ::= strTiempo COMA paramTiempo 
            {
              List<Atributo> RESULT =null;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).value;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Atributo atributo = (Atributo)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            if(listAtributos == null) listAtributos = new ArrayList<Atributo>();
                                            if(atributo != null) listAtributos.add(atributo);
                                            RESULT = listAtributos;
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("strTiempo",3, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // strTiempo ::= paramTiempo 
            {
              List<Atributo> RESULT =null;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Atributo atributo = (Atributo)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            ArrayList<Atributo> atributos = new ArrayList<Atributo>();
                                            if(atributo != null) atributos.add(atributo);
                                            RESULT = atributos;
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("strTiempo",3, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // paramTiempo ::= PR_INICIO ASIGNACION COMILLA ID COMILLA 
            {
              Atributo RESULT =null;
		int dclleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).left;
		int dclright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).right;
		Token dcl = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		Token id = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		
                                            if(id != null){
                                                if(dcl != null){
                                                    Atributo atributo = new Atributo("inicio", id.getLexema(), dcl.getLinea(), dcl.getColumna());
                                                    RESULT = atributo;
                                                }
                                            }    
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramTiempo",5, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // paramTiempo ::= PR_FIN ASIGNACION COMILLA ID COMILLA 
            {
              Atributo RESULT =null;
		int dclleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).left;
		int dclright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).right;
		Token dcl = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		Token id = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		
                                            if(id != null){
                                                if(dcl != null){
                                                    Atributo atributo = new Atributo("fin", id.getLexema(), dcl.getLinea(), dcl.getColumna());
                                                    RESULT = atributo;
                                                }
                                            }    
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramTiempo",5, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // paramTiempo ::= PR_IMAGENES ASIGNACION CORCHETE_A listImagenes CORCHETE_C 
            {
              Atributo RESULT =null;
		int dclleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).left;
		int dclright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).right;
		Token dcl = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).value;
		int imagenesleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int imagenesright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		List<Imagen> imagenes = (List<Imagen>)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		
                                            if(imagenes != null){
                                                if(dcl != null){
                                                    Atributo atributo = new Atributo("imagenes", imagenes, dcl.getLinea(), dcl.getColumna());
                                                    RESULT = atributo;
                                                }
                                            }    
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramTiempo",5, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // listImagenes ::= listImagenes COMA strImagen 
            {
              List<Imagen> RESULT =null;
		int imagenesleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).left;
		int imagenesright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).right;
		List<Imagen> imagenes = (List<Imagen>)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).value;
		int imagenleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int imagenright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Imagen imagen = (Imagen)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            if(imagenes == null) imagenes = new ArrayList<Imagen>();
                                            if(imagen != null){
                                                if(isValido(imagen)) imagenes.add(imagen);
                                            }
                                            RESULT = imagenes;
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("listImagenes",8, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // listImagenes ::= strImagen 
            {
              List<Imagen> RESULT =null;
		int imagenleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int imagenright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Imagen imagen = (Imagen)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
                                            if(imagen != null){
                                                if(isValido(imagen)) imagenes.add(imagen);
                                            }
                                            RESULT = imagenes;
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("listImagenes",8, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // strImagen ::= LLAVE_A paramsImagen LLAVE_C 
            {
              Imagen RESULT =null;
		int dclleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).left;
		int dclright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).right;
		Token dcl = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).value;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		
                                            if(listAtributos != null){
                                                Imagen imagen = new Imagen();
                                                if(dcl!=null) imagen.setLineaT(dcl.getLinea());
                                                if(dcl!=null) imagen.setColumnaT(dcl.getColumna());
                                                inicializarImagen(imagen, listAtributos);
                                                RESULT = imagen;
                                            }
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("strImagen",7, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // paramsImagen ::= paramsImagen COMA paramImagen 
            {
              List<Atributo> RESULT =null;
		int listAtributosleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).left;
		int listAtributosright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).right;
		List<Atributo> listAtributos = (List<Atributo>)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).value;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Atributo atributo = (Atributo)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            if(listAtributos == null) listAtributos = new ArrayList<Atributo>();
                                            if(atributo != null) listAtributos.add(atributo);
                                            RESULT = listAtributos;
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramsImagen",4, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // paramsImagen ::= paramImagen 
            {
              List<Atributo> RESULT =null;
		int atributoleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int atributoright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Atributo atributo = (Atributo)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            ArrayList<Atributo> listAtributos = new ArrayList<Atributo>();
                                            if(atributo != null) listAtributos.add(atributo);
                                            RESULT = listAtributos;
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramsImagen",4, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // paramImagen ::= PR_ID ASIGNACION COMILLA ID COMILLA 
            {
              Atributo RESULT =null;
		int dclleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).left;
		int dclright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).right;
		Token dcl = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).right;
		Token id = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-1)).value;
		
                                            if(id != null){
                                                if(dcl != null){
                                                    Atributo atributo = new Atributo("id", id.getLexema(), dcl.getLinea(), dcl.getColumna());
                                                    RESULT = atributo;
                                                }
                                            }
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramImagen",6, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-4)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // paramImagen ::= PR_DURACION ASIGNACION ENTERO 
            {
              Atributo RESULT =null;
		int dclleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).left;
		int dclright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).right;
		Token dcl = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()).right;
		Token id = (Token)((java_cup.runtime.Symbol) CUP$ParserTiempos$stack.peek()).value;
		
                                            if(id != null){
                                                if(dcl != null){
                                                    Atributo atributo = new Atributo("duracion", id.getLexema(), dcl.getLinea(), dcl.getColumna());
                                                    RESULT = atributo;
                                                }
                                            }
                                        
              CUP$ParserTiempos$result = parser.getSymbolFactory().newSymbol("paramImagen",6, ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.elementAt(CUP$ParserTiempos$top-2)), ((java_cup.runtime.Symbol)CUP$ParserTiempos$stack.peek()), RESULT);
            }
          return CUP$ParserTiempos$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$ParserTiempos$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$ParserTiempos$do_action(
    int                        CUP$ParserTiempos$act_num,
    java_cup.runtime.lr_parser CUP$ParserTiempos$parser,
    java.util.Stack            CUP$ParserTiempos$stack,
    int                        CUP$ParserTiempos$top)
    throws java.lang.Exception
    {
              return CUP$ParserTiempos$do_action_part00000000(
                               CUP$ParserTiempos$act_num,
                               CUP$ParserTiempos$parser,
                               CUP$ParserTiempos$stack,
                               CUP$ParserTiempos$top);
    }
}

}
