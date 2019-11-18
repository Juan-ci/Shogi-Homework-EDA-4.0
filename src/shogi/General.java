
package shogi;

import java.util.ArrayList;
import java.util.List;
import Piezas.CasilleroVacio;

/**
 *
 * @author JuanCaballero
 */
public abstract class General {
    
    CasilleroVacio vacio = new CasilleroVacio();
    
    private List<String> capturadosDefensor = new ArrayList<String>();      //Piezas capturadas por el defensor
    private List<String> capturadosRetador = new ArrayList<String>();
    
    public abstract void movimiento(int currentI, int currentJ, int nextI, int nextJ, String [][] tablero);
    
    public void setCapturados(char def_Ret, String[][] pieza, int i, int j){
        
        switch(def_Ret){
            case 'v':
                if(pieza[i][j] == " K^ "){    //Verifica si la pieza capturada es el rey
                    System.out.println("\tJAQUE MATE \n  El ganador del juego es el jugador Defensor. ");
                    System.exit(0);
                } else {
                    capturadosDefensor.add(pieza[i][j]);
                }
            break;
            case '^':
                if(pieza[i][j] == " Kv "){    //Verifica si la pieza capturada es el rey
                    System.out.println("\tJAQUE MATE \n  El ganador del juego es el jugador Retador. ");
                    System.exit(0);
                } else {
                    capturadosRetador.add(pieza[i][j]);
                }
            break;
            default:
                System.out.println(" Error en setCapturados. ");
            break;
        }
    }
    
    public List<String> getCapturados(char def_Ret){
        
        if(def_Ret == 'v'){
            return capturadosDefensor;
        } else {
            return capturadosRetador;
        }
    }
    
    public boolean getRecorridoBloqueado(int casos,int currentI, int currentJ,int nextI, int nextJ, String[][] tablero){
        boolean resultado = false;
        int desplazandoI = currentI;
        int desplazandoJ = currentJ;
        char def_Ret = tablero[currentI][currentJ].charAt(2);
        
        //Evaluando movimiento lancero
        switch(casos){
            case 0:     //El numero 0 hace referencia al lancero
                switch(def_Ret){
                    case 'v':       //lancero defensor " Lv "
                        desplazandoI++;
                        while(resultado == false || desplazandoI < nextI){
                            if(tablero[desplazandoI][currentJ] == vacio.getCasilleroVacio() && desplazandoI < nextI){
                                desplazandoI++;
                            } else {
                                if(tablero[desplazandoI][currentJ] != vacio.getCasilleroVacio() && desplazandoI < nextI){
                                    break;
                                } else {
                                    resultado = true;
                                }
                            }
                        }
                    break;
                    case '^':       //lancero retador " L^ "
                        desplazandoI--;
                        while(resultado == false || desplazandoI > nextI){
                            if(tablero[desplazandoI][currentJ] == vacio.getCasilleroVacio() && desplazandoI > nextI){
                                desplazandoI--;
                            } else {
                                if(tablero[desplazandoI][currentJ] != vacio.getCasilleroVacio() && desplazandoI > nextI){
                                    break;
                                } else {
                                    resultado = true;
                                }
                            }
                        }
                    break;
                }
            break;
            case 1:     //movimiento de Torre
                
                if(nextI == currentI){      //movimiento misma fila hacia izquierda o derecha
                    resultado = moverTorreIzquierda_Derecha( currentI, currentJ, nextI, nextJ, tablero);
                } else if(nextJ == currentJ){
                    resultado = moverTorreAtras_Adelante( currentI, currentJ, nextI, nextJ, tablero);
                }
            break;
            case 2:     //movimiento de alfil
                if(nextI < currentI){       //Movimiento hacia atras
                    resultado = desplazandoDiagonalAtras(resultado, desplazandoI, desplazandoJ, nextI, nextJ, tablero);
                } else if( nextI > currentI) {                    //currentI < nextI
                    resultado = desplazandoDiagonalAdelante(resultado, desplazandoI, desplazandoJ, nextI, nextJ, tablero);
                }
            break;
            default:
                System.out.println(" Error en getRecorridoBloqueado. ");
            break;
    }
    return resultado;
 }
    public boolean desplazandoDiagonalAtras(boolean resul, int desplazandoI, int desplazandoJ, int nextI, int nextJ, String[][] tablero){
    
        if( nextJ < (desplazandoJ-1)){      //movimiento izquierda
                        while(nextJ < desplazandoJ){
                            desplazandoI--;
                            desplazandoJ--;
                            if(tablero[desplazandoI][desplazandoJ] != vacio.getCasilleroVacio() && nextJ < desplazandoJ){
                                resul = false;
                                break;
                            } else {
                                resul = true;
                            } 
                        }
                    } else if(nextJ > (desplazandoJ+1)){    //movimiento derecha
                        while(nextJ > desplazandoJ){
                            desplazandoI--;
                            desplazandoJ++;
                            if(tablero[desplazandoI][desplazandoJ] != vacio.getCasilleroVacio() && nextJ > desplazandoJ){
                                resul = false;
                                break;
                            } else {
                                resul = true;
                            }
                        }
                    }
                    else {        //en caso de avanzar 1 devuelve true
                        resul =  true;
                    }
        return resul;
    }
    public boolean desplazandoDiagonalAdelante(boolean resul, int desplazandoI, int desplazandoJ, int nextI, int nextJ, String[][] tablero){
    
        if( nextJ < (desplazandoJ-1)){      //movimiento izquierda
                        while(nextJ < desplazandoJ){
                            desplazandoI++;
                            desplazandoJ--;
                            if(tablero[desplazandoI][desplazandoJ] != vacio.getCasilleroVacio() && nextJ < desplazandoJ){
                                resul = false;
                                break;
                            } else {
                                resul = true;
                            } 
                        }
                    } else if(nextJ > (desplazandoJ+1)){    //movimiento derecha
                        while(nextJ > desplazandoJ){
                            desplazandoI++;
                            desplazandoJ++;
                            if(tablero[desplazandoI][desplazandoJ] != vacio.getCasilleroVacio() && nextJ > desplazandoJ){
                                resul = false;
                                break;
                            } else {
                                resul = true;
                            } 
                        }
                    } else {
                        resul =  true;
                    }
        return resul;
    }
    
    public void avanzar_capturar(char def_ret, int currentI, int currentJ, int nextI, int nextJ, String[][] tablero){
        //Verifica si tiene el camino bloqueado
        if(tablero[nextI][nextJ] == vacio.getCasilleroVacio()){                              //Espacio vacio, avanza
            tablero[nextI][nextJ] = tablero[currentI][currentJ];
            tablero[currentI][currentJ] = vacio.getCasilleroVacio();
            Tablero.turno++;
        } else {
            if(tablero[nextI][nextJ].indexOf(def_ret) >= 0){                                 //Pieza del mismo equipo no puede avanzar
                System.out.println("No puedes comerte una pieza de tu mismo equipo, intenta de nuevo");
            } else {
                this.setCapturados( def_ret, tablero, nextI, nextJ);
                System.out.println("Capturó la pieza: "+ tablero[nextI][nextJ]);
                tablero[nextI][nextJ] = tablero[currentI][currentJ];
                tablero[currentI][currentJ] = vacio.getCasilleroVacio();
                Tablero.turno++;
            }
        }
    }
    
    public boolean moverTorreAtras_Adelante(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero){
    
        int desplazaI = currentI;
        boolean resultado = false;
        
        if(nextI < currentI){       //movimiento hacia la izquierda
            desplazaI--;
            while(nextI <= desplazaI){
                if(nextI == desplazaI ){
                    return resultado = true;
                } else if(nextI < desplazaI && tablero[desplazaI][nextJ] == vacio.getCasilleroVacio()){
                    desplazaI--;
                } else{
                    System.out.println("No puedes saltar piezas, intenta de nuevo.(desplazamiento atras||adelante ");
                    return resultado = false;
                }
            }
        } else {
            desplazaI++;
            while(nextI >= desplazaI){      //movimiento hacia derecha
                if(nextI == desplazaI ){
                    return resultado = true;
                }else {
                    if(tablero[desplazaI][nextJ] == vacio.getCasilleroVacio()){
                        desplazaI++;
                    } else {
                        System.out.println("No puedes saltar piezas, intenta de nuevo. ");
                        return resultado = false;
                    }
                }    
            }
                    
        }
        return resultado;
    }
    
    public boolean moverTorreIzquierda_Derecha(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero){
        
        boolean resultado = false;
        int desplazaJ = currentJ;
        
            if(nextJ < currentJ){
                        desplazaJ--;
                        while(nextJ <= desplazaJ){
                            if(nextJ == desplazaJ ){
                                return resultado = true;
                            } else if(nextJ < desplazaJ && tablero[nextI][desplazaJ] == vacio.getCasilleroVacio()){
                                desplazaJ--;
                            } else{
                                System.out.println("No puedes saltar piezas, intenta de nuevo. ");
                                return resultado = false;
                            }
                        }
            } else {
                desplazaJ++;
                    while(nextJ >= desplazaJ){      //movimiento hacia derecha
                        if(nextJ == desplazaJ ){
                            return resultado = true;
                        }else {
                            if(tablero[nextI][desplazaJ] == vacio.getCasilleroVacio()){
                                desplazaJ++;
                            } else {
                                System.out.println("No puedes saltar piezas, intenta de nuevo. ");
                                return resultado = false;
                            }
                        }    
                    }
            }
    return resultado;
    }
}
