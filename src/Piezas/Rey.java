/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import shogi.General;
/**
 *
 * @author JuanCaballero
 */
public class Rey extends General{

    private String nombre;
    
    public Rey(String name){
        nombre = name;
    }
    
    public String getNombrePieza(){
        return nombre;
    }
    
    @Override
    public void movimiento(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero) {
        
        int desplazamientoI = Math.abs(nextI-currentI);
        int desplazamientoJ = Math.abs(nextJ-currentJ);
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);
        /*
        switch(defensor_Retador){
            case 'v':
        */
                if(nextI == currentI && (nextJ == (currentJ-1) || nextJ == (currentJ+1))        //misma fila derecha o izquierda
                   || nextJ == currentJ && (nextI ==(currentI+1) || nextI == (currentI-1))      //misma columna arriba o abajo
                   || (desplazamientoI == desplazamientoJ && desplazamientoI == 1)){            //diagonales, mueve de a uno
                    super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
                } else {
                    System.out.println(" No puedes realizar esta movimiento, intenta de nuevo.");
                }
                /*
            break;
            case '^':
                if(nextI == currentI && (nextJ == (currentJ-1) || nextJ == (currentJ+1))        //misma fila derecha o izquierda
                   || nextJ == currentJ && (nextI ==(currentI+1) || nextI == (currentI-1))      //misma columna arriba o abajo
                   || (desplazamientoI == desplazamientoJ && desplazamientoI == 1)){            //diagonales, mueve de a uno
                    super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
                } else {
                    System.out.println(" No puedes realizar esta movimiento, intenta de nuevo.");
                }
            break;
            default:
                System.out.println(" Error en movimiento Rey. ");
            break;
        }
*/
    }
}
