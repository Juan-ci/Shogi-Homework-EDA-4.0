
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
        
        if(nextI == currentI && (nextJ == (currentJ-1) || nextJ == (currentJ+1))        //misma fila derecha o izquierda
           || nextJ == currentJ && (nextI ==(currentI+1) || nextI == (currentI-1))      //misma columna arriba o abajo
           || (desplazamientoI == desplazamientoJ && desplazamientoI == 1)){            //diagonales, mueve de a uno
            super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
        } else {
            System.out.println(" No puedes realizar esta movimiento, intenta de nuevo.");
        }
    }
}
