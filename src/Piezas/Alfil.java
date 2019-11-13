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
            super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
        } else {
            System.out.println("No puede realizar este movimiento, intenta de nuevo");
        }
    }
    
}
