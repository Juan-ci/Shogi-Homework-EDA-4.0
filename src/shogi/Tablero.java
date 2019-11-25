
package shogi;

import java.util.Scanner;

//Jugador Defensor

import Piezas.Peon;
import Piezas.Oro;
import Piezas.Plata;
import Piezas.Caballo;
import Piezas.Lancero;
import Piezas.Alfil;
import Piezas.Torre;
import Piezas.Rey;
import Piezas.CasilleroVacio;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 *
 * @author JuanCaballero
 */
public class Tablero extends Piezas{
    
    CasilleroVacio vacio = new CasilleroVacio();

    Peon peonDefensor;
    Oro oroDefensor;
    Plata plataDefensor;
    Caballo caballoDefensor;
    Lancero lanceroDefensor;
    Alfil alfilDefensor;
    Torre torreDefensor;
    Rey reyDefensor;
    
    Peon peonRetador;
    Alfil alfilRetador;
    Torre torreRetador;
    Lancero lanceroRetador;
    Caballo caballoRetador;
    Rey reyRetador;
    Plata plataRetador;
    Oro oroRetador;
    
    
    public static int turno = 0;
    int currentI;          //posicion i tomada por teclado para elejir pieza
    int currentJ;          //posicion j tomada por teclado para elejir pieza
    int nextI;          //posicion i tomada por teclado para posicion siguiente
    int nextJ;          //posicion j tomada por teclado para posicion siguiente
    int designarTurno;
    int tamañoTablero;
    
    Scanner scan = new Scanner(System.in);
    
    
    
    public Tablero(){
        //Piezas del jugador defensor.
        
        peonDefensor = new Peon(" Pv ");
        oroDefensor = new Oro(" Gv ");
        plataDefensor = new Plata(" Sv ");
        caballoDefensor = new Caballo(" Hv ");
        lanceroDefensor = new Lancero(" Lv ");
        alfilDefensor = new Alfil(" Bv ");
        torreDefensor = new Torre(" Tv ");
        reyDefensor = new Rey(" Kv ");
        
        //Piezas del jugador retador.
        
        peonRetador = new Peon(" P^ ");
        alfilRetador = new Alfil(" B^ ");
        torreRetador = new Torre(" T^ ");
        lanceroRetador = new Lancero(" L^ ");
        caballoRetador = new Caballo(" H^ ");
        reyRetador = new Rey(" K^ ");
        plataRetador = new Plata(" S^ ");
        oroRetador = new Oro(" G^ ");
        
        String[][] tablero = new String[9][9];
        tamañoTablero = tablero.length;
        
        inicioPartida(tablero);
        
    }
    
    public void inicioPartida(String[][] tablero){
        
       /*
        * Armando el tablero y posicionando las piezas en su lugar 
        */
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                
                switch( i ){
                    //filas
                    case 0: //fila 1 
                            switch( j ){
                                //columnas
                                case 0:
                                    tablero[i][j] = lanceroDefensor.getNombrePieza();
                                case 8:
                                    tablero[i][j] = lanceroDefensor.getNombrePieza();
                                    break;
                                case 1:
                                    tablero[i][j]= caballoDefensor.getNombrePieza();
                                case 7:
                                    tablero[i][j]= caballoDefensor.getNombrePieza();
                                    break;
                                case 2:
                                    tablero[i][j]= plataDefensor.getNombrePieza();
                                case 6:
                                    tablero[i][j]= plataDefensor.getNombrePieza();
                                    break;
                                case 3:
                                    tablero[i][j]= oroDefensor.getNombrePieza();
                                case 5:
                                    tablero[i][j]= oroDefensor.getNombrePieza();
                                    break;
                                case 4:
                                    tablero[i][j]= reyDefensor.getNombrePieza();
                                    break;
                                default:
                                tablero[i][j]= vacio.getCasilleroVacio();
                                break;
                            }
                    break;
                    case 1: //fila 2
                        switch( j ){
                            case 1:
                                tablero[i][j]= torreDefensor.getNombrePieza();
                                break;
                            case 7:
                                tablero[i][j]= alfilDefensor.getNombrePieza();
                                break;
                            default:
                                tablero[i][j]= vacio.getCasilleroVacio();
                                break;
                        }
                    break;
                    case 2: //fila 3
                        tablero[i][j]= peonDefensor.getNombrePieza();
                    break;
                    case 6:
                        tablero[i][j] = peonRetador.getNombrePieza();
                    break;
                    case 7:
                        switch( j ){
                            case 1:
                                tablero[i][j]= alfilRetador.getNombrePieza();
                                break;
                            case 7:
                                tablero[i][j]= torreRetador.getNombrePieza();
                                break;
                            default:
                                tablero[i][j]= vacio.getCasilleroVacio();
                                break;
                        }
                    break;
                    case 8:
                        switch( j ){
                                //columnas
                                case 0:
                                    tablero[i][j] = lanceroRetador.getNombrePieza();
                                case 8:
                                    tablero[i][j] = lanceroRetador.getNombrePieza();
                                    break;
                                case 1:
                                    tablero[i][j]= caballoRetador.getNombrePieza();
                                case 7:
                                    tablero[i][j]= caballoRetador.getNombrePieza();
                                    break;
                                case 2:
                                    tablero[i][j]= plataRetador.getNombrePieza();
                                case 6:
                                    tablero[i][j]= plataRetador.getNombrePieza();
                                    break;
                                case 3:
                                    tablero[i][j]= oroRetador.getNombrePieza();
                                case 5:
                                    tablero[i][j]= oroRetador.getNombrePieza();
                                    break;
                                case 4:
                                    tablero[i][j]= reyRetador.getNombrePieza();
                                    break;
                                default:
                                tablero[i][j]= vacio.getCasilleroVacio();
                                break;
                            }
                    break;
                    default:
                        tablero[i][j] = vacio.getCasilleroVacio();
                    break;
                }
                
            }
        }   
        mostrarTablero(tablero);
    }
    
    public void mostrarTablero( String[][]tablero ){
        
       /*
        * Se  muestra el tablero y luego se procede con el siguiente turno
        */
        
        
        System.out.println("   0   1   2   3   4   5   6   7   8");
        System.out.println("  ===================================");
        
        for (int i = 0; i < 9; i++) {
            System.out.print(i+ "|");
            for (int j = 0; j < 9; j++) {
                if(j == 8){
                    System.out.print(tablero[i][j]+ "|"+ i);
                } else {
                    System.out.print(tablero[i][j]);
                }
            }
            System.out.println("\n");
        }
        System.out.println("  ===================================");
        System.out.println("   0   1   2   3   4   5   6   7   8\n");
        
        siguienteMovimiento(tablero, turno);
        
    }
    
    public void siguienteMovimiento(String[][]tablero, int turno){      
        
        
        designarTurno = turno%2;
        
        int decision = -1;
        char defensor = 'v';
        char retador = '^';
               
       /*
        * Pregunta si quiere reinsertar piezas
        * o procede con turno normal
        */
       
        do {
            System.out.println("#Turno "+ turno);
            
            switch(designarTurno){
                case 0:
                    System.out.println(" Turno Retador.\n");
                    if(General.capturadosRetador.size() > 0){
                        
                        do{
                            try{
                                System.out.println(" Deseas reinsertar piezas?\n1.Si\n2.No ");
                                decision = scan.nextInt();
                            } catch( InputMismatchException e){
                                System.out.println("Debes ingresar 1 o 2.");
                                scan.nextLine();
                            }
                        } while(decision < 1 || decision > 2);
                        
                        if( decision == 1){
                            mostrarCapturados( retador , tablero);      //muestra los capturados y se elige pieza a reinsertar
                        } else {
                            defensorORetador(tablero);
                        }
                    }  else {
                        
                        defensorORetador(tablero);      //verifica a quien le toca el turno al retador o al defensor
                    }    
                break;
                case 1:
                    System.out.println(" Turno Defensor.\n");
                    if(General.capturadosDefensor.size() > 0){
                        
                        do{
                            try{
                                System.out.println(" Deseas reinsertar piezas?\n1.Si\n2.No ");
                                decision = scan.nextInt();
                            } catch( InputMismatchException e){
                                System.out.println("Debes ingresar 1 o 2.");
                                scan.nextLine();
                            }
                        } while(decision < 1 || decision > 2);
                        
                        if( decision == 1){
                            mostrarCapturados( defensor , tablero);      //muestra los capturados y se elige pieza a reinsertar
                        } else {
                            defensorORetador(tablero);
                        }
                    }  else {
                        defensorORetador(tablero);
                    }
                break;
                default:
                    System.out.println(" Error en siguienteMovimiento. ");
                break;
            }
        } while(currentI == nextI && currentJ == nextJ || nextI < 0 || nextI > 8 || nextJ < 0 || nextJ > 8);
                //misma posicion tanto i como j        o fuera del tablero  
        
       /*
        * Dependiendo de la pieza seleccionada se verifica
        * si el movimiento que se quiere realizar esta permitido
        * para la pieza elegida
        */
                
       if(designarTurno != 0){       //turno del defensor
            switch(tablero[currentI][currentJ]){        //verifica la pieza a mover
                case " Pv ":
                    peonDefensor.movimiento(currentI, currentJ, nextI,nextJ, tablero);
                break;
                case " Gv ":
                    oroDefensor.movimiento(currentI, currentJ, nextI,nextJ, tablero);
                break;
                case " Sv ":
                    plataDefensor.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " Hv ":
                    caballoDefensor.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " Lv ":
                    lanceroDefensor.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " Bv ":
                    alfilDefensor.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " Tv ":
                    torreDefensor.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " Kv ":
                    reyDefensor.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
            }
        } else {            //turno del retador
            switch(tablero[currentI][currentJ]){        //verifica la pieza a mover
                case " P^ ":
                    peonRetador.movimiento(currentI, currentJ, nextI,nextJ, tablero);
                break;
                case " G^ ":
                    oroRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " S^ ":
                    plataRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " H^ ":
                    caballoRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " L^ ":
                    lanceroRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " B^ ":
                    alfilRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " T^ ":
                    torreRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
                case " K^ ":
                    reyRetador.movimiento(currentI, currentJ, nextI, nextJ, tablero);
                break;
            }
        }
        mostrarTablero(tablero);
    }
    
    public void defensorORetador(String[][] tablero){
        
        try{
            if(designarTurno == 0){
                procederTurno( '^', tablero );
            } else {
                procederTurno( 'v', tablero );
            }
        } catch(InputMismatchException e){
            System.out.println(" Debes ingresasr un digito del 0 al 8. ");
            scan.nextLine();
        }
    }
    
    public void procederTurno( char indicador, String[][] tablero){
        
       /*
        * Segun el char recibido se verifica si la pieza seleccionada
        * le pertenece al jugador que le toca el turno (jugador retador o defensor)
        */
        
        System.out.println("Elija pieza:\n"
                            + "Ingrese fila: ");
        currentI = scan.nextInt();
        System.out.println("Ingrese columna: ");
        currentJ = scan.nextInt();

        int defensorOretador = tablero[currentI][currentJ].indexOf(indicador);      //se le pasa el caracter para saber si es defensor o retador

        if(defensorOretador >= 0){ //turno retador
            //Ubicacion siguiente de la pieza
            System.out.println("Elija destino:\n"
                                + "Ingrese fila: ");
            nextI = scan.nextInt();
            System.out.println("Ingrese columna: ");
            nextJ = scan.nextInt();
        } else {
            nextI = currentI;
            nextJ = currentJ;

            System.out.println("Estas eligiendo una ficha de tu contrincante, intenta de nuevo");
        }
    }
    
    public void mostrarCapturados(char defensor_retador, String[][] tablero){   //mostrar array de piezas capturadas y se elige pieza a reinsertar
        
       /*
        * Se muestran las piezas capturadas por el jugador defensor o jugador retador
        * segun a quien le corresponda el turno, se toma por teclado la pieza a reinsertar y luego
        * se llama al metodo que renombra la pieza segun el jugador
        */
        
        int contador = 0;
        int posicion;
        String piezaSeleccionada;
        
        switch(defensor_retador){
            case 'v':           //muestra capturados de defensor
                Iterator iter = General.capturadosDefensor.iterator();
                while( iter.hasNext()){
                    System.out.println(contador+ ". " + iter.next()+ "\n");
                    contador++;
                }
                
                posicion = verificarEntradaTeclado(General.capturadosDefensor.size(), "Elija pieza a reinsertar. ");      //Hacer metodo para ver que pieza se reinserta y cambiar simbolo retador defensor
                
                piezaSeleccionada = General.capturadosDefensor.get(posicion);
                
                cambiarNombrePieza(posicion, defensor_retador, piezaSeleccionada, tablero);
            break;
            case '^':           //muestra capturados por retador
                Iterator itera = General.capturadosRetador.iterator();
                while( itera.hasNext()){
                    System.out.println(contador+ ". " + itera.next()+ "\n");
                    contador++;
                }
                
                posicion = verificarEntradaTeclado(General.capturadosRetador.size(), "Elija pieza a reinsertar. ");      //Hacer metodo para ver que pieza se reinserta y cambiar simbolo retador defensor
                
                piezaSeleccionada = General.capturadosRetador.get(posicion);
                
                cambiarNombrePieza(posicion, defensor_retador, piezaSeleccionada, tablero);
            break;
            default:
                System.out.println(" Error en mostrarCapturados.");
            break;
        }
    }
    
    public void cambiarNombrePieza(int posicion, char defensor_retador, String pieza, String[][] tablero){
        
        int fila;       //fila donde insertar pieza
        int columna;    //columna donde insertar pieza
        boolean verificar = false;      //variable para verificar si hay un peon en la misma columna
        
       /*
        * Segun la pieza seleccionada de los capturados, se le asigna el nuevo
        * nombre y se reinserta en la posicion que se toma por teclado y
        * se incrementa el turno , luego se muestra el tablero
        */
        
        if(defensor_retador == 'v'){    //Defensor
            switch(pieza){
                case " P^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    
                   /*
                    * Verifica si ya hay un peon en la columna donde se 
                    * desea reinsertar el peon
                    */
                    for(int i = 0; i < tamañoTablero; i++){
                        if(tablero[i][columna] == peonDefensor.getNombrePieza()){
                            System.out.println("No puedes insertar un peón en una columna donde ya hay un peón. ");
                            verificar = false;
                            break;
                        } else {
                            verificar = true;
                        }
                    }
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio() && verificar){
                        tablero[fila][columna] = peonDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " G^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = oroDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " S^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = plataDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " H^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = caballoDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " L^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = lanceroDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " B^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = alfilDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " T^ ":
                    System.out.println(" Insertar en:");
                    fila = verificarEntradaTeclado(tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = torreDefensor.getNombrePieza();
                        General.capturadosDefensor.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                default:
                    System.out.println(" Error en cambiarNombrePieza");
                break;    
            }
        } else {                        //retador (segun pieza capturada de defensor cambia el nombre a retador)
            switch(pieza){
                case " Pv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    /*
                    * Verifica si ya hay un peon en la columna donde se 
                    * desea reinsertar el peon
                    */
                    for(int i = 0; i < tamañoTablero; i++){
                        if(tablero[i][columna] == peonRetador.getNombrePieza()){
                            System.out.println("No puedes insertar un peón en una columna donde ya hay un peón. ");
                            verificar = false;
                            break;
                        } else {
                            verificar = true;
                        }
                    }
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio() && verificar){
                        tablero[fila][columna] = peonRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " Gv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = oroRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " Sv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = plataRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " Hv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = caballoRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " Lv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = lanceroRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " Bv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = alfilRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                case " Tv ":
                    System.out.println(" Insertar en:\n");
                    fila = verificarEntradaTeclado( tamañoTablero, " Fila: ");
                    columna = verificarEntradaTeclado( tamañoTablero, " Columna: ");
                    
                    if( tablero[fila][columna] == vacio.getCasilleroVacio()){
                        tablero[fila][columna] = torreRetador.getNombrePieza();
                                
                        General.capturadosRetador.remove(posicion);        //elimina del array la pieza seleccionada
                        
                        turno++;
                        mostrarTablero(tablero);
                    }
                break;
                default:
                    System.out.println(" Error en cambiarNombrePieza");
                break;    
            }
        }
    }
    
    public int verificarEntradaTeclado(int limite, String mensaje){
        
       /*
        *Metodo para verificar la entrada por teclado
        */
        int entrada = -1;  //se inicializa porque da error la funcion si no se hace
        
        do{
            System.out.println(mensaje);
            try{
                entrada = scan.nextInt();
            } catch( InputMismatchException e){
                mensaje = " Debes ingresar un dígito";
                scan.nextLine();
            }
        } while(entrada < 0 || entrada > limite);
        
        return entrada;
    }
}
