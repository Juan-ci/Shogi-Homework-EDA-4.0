
package Piezas;

import shogi.General;
/**
 *
 * @author JuanCaballero
 */
public class Lancero extends General{

    private String nombre;
    
    public Lancero(String name){
        nombre = name;
    }
    
    public String getNombrePieza(){
        return nombre;
    }
    
    @Override
    public void movimiento(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero) {
        
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);
       
         if(verificarMov(defensor_Retador, currentI,currentJ, nextI, nextJ)){
            if(super.getRecorridoBloqueado( 0, currentI, currentJ, nextI, nextJ, tablero)){      //Nro 0:para identificarse como lancero
                super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
            } else {
                System.out.println("No puedes saltar piezas, intenta de nuevo;");
            }
        } else {
            System.out.println("No puedes realizar este movimiento, intenta de nuevo.");
        }
    }
    
    public boolean verificarMov(char def_Ret, int currentI,int currentJ, int nextI, int nextJ){            
        boolean decision = false;                                               
        
        switch(def_Ret){
            case 'v':       //lancero defensor " Lv "
                if( nextJ == currentJ && nextI > currentI ){       //Verifica que sea la misma columna y que nextI sea mayor que currentI
                    for (int i = currentI; i < 9; i++) {
                        if(nextI == i){
                            decision = true;
                            //break;
                        }
                    }
                }    
            break;
            case '^':       //lancero retador " L^ "
                if( nextJ == currentJ && nextI < currentI ){       //Verifica que sea la misma columna y que nextI sea menor que currentI
                    for (int i = currentI; i > 0; i--) {
                        if(nextI == i){
                            decision = true;
                            //break;
                        }
                    }
                }
            break;
            default:
                System.out.println("ERROR en switch de def_ret.");
            break;
        }
        return decision;
    }
}
