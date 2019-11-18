
package Piezas;


import shogi.General;
/**
 *
 * @author JuanCaballero
 */
public class Alfil extends General{

    private String nombre;
    
    public Alfil(String name){
        nombre = name;
    }
    
    public String getNombrePieza(){
        return nombre;
    }
    
    @Override
    public void movimiento(int currentI, int currentJ, int nextI, int nextJ, String[][] tablero) {
        
        int desplazamientoI = Math.abs(nextI-currentI);
        int desplazamientoJ = Math.abs(nextJ-currentJ);
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);   //
        
        if((currentI != nextI) && (desplazamientoI == desplazamientoJ)){
            if(super.getRecorridoBloqueado( 2, currentI, currentJ, nextI, nextJ, tablero)){
                super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
            } else {
                System.out.println(" No puedes saltar piezas, intenta de nuevo. ");
            }
        } else {
            System.out.println("No puede realizar este movimiento, intenta de nuevo");
        }
    }
    
}
