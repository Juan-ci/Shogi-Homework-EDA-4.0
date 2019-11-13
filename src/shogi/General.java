/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanCaballero
 */
public abstract class General {
    
    private List<String> capturados = new ArrayList<String>();
    
    public abstract void movimiento(int currentI, int currentJ, int nextI, int nextJ, String [][] tablero);
    
    public void setCapturados(String[][] pieza, int i, int j){
        if( pieza[i][j] == " Kv " || pieza[i][j] == " K^ "){    //Verifica si la pieza capturada es el rey
            if( pieza[i][j].indexOf("v") >= 0){
                System.out.println("\tJAQUE MATE \n  El ganador del juego es el jugador Retador. ");
            } else {
                System.out.println("\tJAQUE MATE \n  El ganador del juego es el jugador Defensor. ");
            }
            System.exit(0);
        } else {
            capturados.add(pieza[i][j]);
        }
    }
    
    public List<String> getCapturados(){
        return capturados;
    }
    
    public boolean getRecorridoBloqueado(int casos,int currentI, int currentJ,int nextI, int nextJ, String[][] tablero){
        boolean resultado = false;
        int desplazandoI = currentI;
        char def_Ret = tablero[currentI][currentJ].charAt(2);
        
        //Evaluando movimiento lancero
        switch(casos){
            case 0:     //El numero 0 hace referencia al lancero
                switch(def_Ret){
                    case 'v':       //lancero defensor " Lv "
                        desplazandoI++;
                        while(resultado == false || desplazandoI < nextI){
                            if(tablero[desplazandoI][currentJ] == "    " && desplazandoI < nextI){
                                desplazandoI++;
                            } else {
                                if(tablero[desplazandoI][currentJ] != "    " && desplazandoI < nextI){
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
                            if(tablero[desplazandoI][currentJ] == "    " && desplazandoI > nextI){
                                desplazandoI--;
                            } else {
                                if(tablero[desplazandoI][currentJ] != "    " && desplazandoI > nextI){
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
    }
    return resultado;
 }  
    
    public void avanzar_capturar(char def_ret, int currentI, int currentJ, int nextI, int nextJ, String[][] tablero){
        //Verifica si tiene el camino bloqueado
        if(tablero[nextI][nextJ] == "    "){                                                 //Espacio vacio, avanza
            tablero[nextI][nextJ] = tablero[currentI][currentJ];
            tablero[currentI][currentJ] = "    ";
            Tablero.turno++;
        } else {
            if(tablero[nextI][nextJ].indexOf(def_ret) >= 0){                                 //Pieza del mismo equipo no puede avanzar
                System.out.println("No puedes comerte una pieza de tu mismo equipo, intenta de nuevo");
            } else {
                this.setCapturados(tablero, nextI, nextJ);
                System.out.println("Capturó la pieza: "+ tablero[nextI][nextJ]);
                tablero[nextI][nextJ] = tablero[currentI][currentJ];
                tablero[currentI][currentJ] = "    ";
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
                } else if(nextI < desplazaI && tablero[desplazaI][nextJ] == "    "){
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
                    if(tablero[desplazaI][nextJ] == "    "){
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
                            } else if(nextJ < desplazaJ && tablero[nextI][desplazaJ] == "    "){
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
                            if(tablero[nextI][desplazaJ] == "    "){
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
