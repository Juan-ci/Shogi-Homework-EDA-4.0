
package Piezas;

import shogi.General;

/**
 *
 * @author JuanCaballero
 */
public class Torre extends General{

    private String nombre;
    
    public Torre(String name){
        nombre = name;
    }
    
    public String getNombrePieza(){
        return nombre;
    }
    
    @Override
    public void movimiento(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero) {
        
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);
        
        if((currentI == nextI && (nextJ < currentJ || nextJ > currentJ))            //movimiento izquierda o derecha
           || (currentJ == nextJ && (nextI < currentI || nextI > currentI))){       //movimiento hacia arriba o abajo
            if(super.getRecorridoBloqueado( 1, currentI, currentJ, nextI, nextJ, tablero)){     //Nro 1 para identificarse como Torre
                super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
            }    
        } else {
            System.out.println("No puedes realizar este movimiento, intenta de nuevo.");
        }
    }
    
}
