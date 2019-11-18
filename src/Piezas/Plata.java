
package Piezas;

import shogi.General;
/**
 *
 * @author JuanCaballero
 */
public class Plata extends General{

    private String nombre;
    
    public Plata(String name){
        nombre = name;
    }
    
    public String getNombrePieza(){
        return nombre;
    }
    
    @Override
    public void movimiento(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero) {
        
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);
        
        switch(defensor_Retador){
            case 'v':
                if(nextI == (currentI+1) && (nextJ == (currentJ+1) || nextJ == (currentJ-1) || nextJ == currentJ)   //hacia adelanta y todas las direcciones
                   || nextI == (currentI-1) && (nextJ == (currentJ-1) || nextJ == (currentJ+1)))
                {                   //Atras y las diagonales
                   avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero); 
                } else {
                    System.out.println(" No puedes realizar este movimiento, intenta de nuevo.");
                }
            break;
            case '^':
                if(nextI == (currentI-1) && (nextJ == (currentJ+1) || nextJ == (currentJ-1) || nextJ == currentJ)   //hacia adelanta y todas las direcciones
                   || nextI == (currentI+1) && (nextJ == (currentJ-1) || nextJ == (currentJ+1)))
                {                   //Atras y las diagonales
                   avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero); 
                } else {
                    System.out.println(" No puedes realizar este movimiento, intenta de nuevo.");
                }
            break;
            default:
                System.out.println(" Error en movimiento plata. ");
            break;
        }
    }
    
}
