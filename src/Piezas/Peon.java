
package Piezas;

import shogi.General;
import Piezas.CasilleroVacio;

/**
 *
 * @author JuanCaballero
 */
public class Peon extends General{
    
    CasilleroVacio vacio = new CasilleroVacio();
    
    private String nombrePeon;
    
    //variable para verificar que la pieza no se agrega mas de una vez al array de piezasPromocionables
    private boolean inArray = false;
    
    public Peon(String nombrePieza){
        this.nombrePeon = nombrePieza;
    }
    
    public String getNombrePieza(){
        return this.nombrePeon;
    }
    
    public void setInArray(boolean bandera){
        this.inArray = bandera;
        
        General.promocionableDefensor.add(nombrePeon);
    }
    
    public boolean getInArray(){
        return this.inArray;
    }

    @Override
                      //posicion actual | posicion siguiente
    public void movimiento(int currentI, int currentJ,int nextI,int nextJ, String[][] tablero) {
        
        char defensor_Retador = tablero[currentI][currentJ].charAt(2);
        
        switch(defensor_Retador){
            case 'v':
                if(nextI == (currentI+1) && nextJ == currentJ){
                        super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
                        
                        //AGREGADO PARA VERIFICAR PROMOCION PIEZA
                        if(nextI >= 6){
                            if(nextI == 6 && inArray == false){
                                setInArray(true);
                            }
                            piezasPromocionables(this.getNombrePieza(),nextI, nextJ, tablero, nombrePiezaProm);
                        }
                }else {
                    if( nextI == (currentI+1) && (nextJ == (currentJ+1) || nextJ == (currentJ-1)))   //movimiento para comer
                    {
                        if(tablero[nextI][nextJ] != vacio.getCasilleroVacio()){                  //verifica que realiza este movimiento para comer
                           if(tablero[nextI][nextJ].indexOf("v") >= 0){
                               System.out.println("No puedes comerte una pieza de tu mismo equipo, intenta de nuevo. ");
                           } else {
                               this.setCapturados( defensor_Retador,tablero, nextI, nextJ);
                                System.out.println("Capturó la pieza: "+ tablero[nextI][nextJ]);
                                tablero[nextI][nextJ] = tablero[currentI][currentJ];
                                tablero[currentI][currentJ] = vacio.getCasilleroVacio();
                                
                                //AGREGADO PARA VERIFICAR PROMOCION PIEZA
                                if(nextI >= 6){
                                    piezasPromocionables(this.getNombrePieza(),nextI, nextJ, tablero, nombrePiezaProm);
                                }
                           } 
                        } else {                            //Si esta vacio no puede realizar el movimiento
                             System.out.println("No puedes realizar este movimiento.");
                        }
                    } else {
                        System.out.println("No puedes realizar este movimiento, intenta de nuevo.");
                    }   
                }
            break;
            case '^':
                if(nextI == (currentI-1) && nextJ == currentJ){     //Movimiento hacia adelante
                        super.avanzar_capturar(defensor_Retador, currentI, currentJ, nextI, nextJ, tablero);
                }else {
                    if( nextI == (currentI-1) && (nextJ == (currentJ+1) || nextJ == (currentJ-1)))   //movimiento para comer en diagonal
                    {
                        if(tablero[nextI][nextJ] != vacio.getCasilleroVacio()){                  //verifica que realiza este movimiento para comer
                           if(tablero[nextI][nextJ].indexOf(defensor_Retador) >= 0){
                               System.out.println("No puedes comerte una pieza de tu mismo equipo, intenta de nuevo. ");
                           } else {
                               this.setCapturados( defensor_Retador, tablero, nextI, nextJ);
                                System.out.println("Capturó la pieza: "+ tablero[nextI][nextJ]);
                                tablero[nextI][nextJ] = tablero[currentI][currentJ];
                                tablero[currentI][currentJ] = vacio.getCasilleroVacio();
                           } 
                        } else {                            //Si esta vacio no puede realizar el movimiento
                             System.out.println("No puedes realizar este movimiento.");
                        }
                    } else {
                        System.out.println("No puedes realizar este movimiento, intenta de nuevo.");
                    }   
                }
            break;
        }
    }
}