
package Piezas;

import shogi.General;
/**
 *
 * @author JuanCaballero
 */
public class Oro extends General{
    
    private String nombre;
    
    public Oro(String name){
        nombre = name;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public void movimiento(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero) {
        
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);
        
        switch(defensor_Retador){
            case 'v':
                if(nextI == (currentI+1) && (nextJ == (currentJ+1) || nextJ == (currentJ-1) || nextJ == currentJ)       //movimiento hacia adelante y todos los sentidos en j(izq, der, adelante)
                        || nextI == currentI && (nextJ == (currentJ+1) || nextJ == (currentJ-1))                 //movimiento misma fila y a los costados
                        || nextI == (currentI-1) && nextJ == currentJ)                                    //movimiento hacia atras misma columna
                {
                    super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
                } else {                                                                    //Movimientos no permitidos
                    System.out.println("No puedes realizar este movimiento, intenta nuevamente");
                }
            break;
            case '^':
                if(nextI == (currentI-1) && (nextJ == (currentJ+1) || nextJ == (currentJ-1) || nextJ == currentJ)       //movimiento hacia adelante y todos los sentidos en j(izq, der, adelante)
                        || nextI == currentI && (nextJ == (currentJ+1) || nextJ == (currentJ-1))                 //movimiento misma fila y a los costados
                        || nextI == (currentI+1) && nextJ == currentJ)                                    //movimiento hacia atras misma columna
                {
                    super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
                } else {                                                                    //Movimientos no permitidos
                    System.out.println("No puedes realizar este movimiento, intenta nuevamente");
                }
            break;
            default:
                System.out.println(" Error en movimiento oro. ");
            break;
        }
    }
    
}
