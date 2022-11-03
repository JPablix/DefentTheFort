/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defentthefort;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JPablix
 */
public class Partida implements Serializable{
    private int nivel;
    private int espaciosZombies;
    private int espaciosSoldados;
    Espacio espacios[] = new Espacio[625];

    public Partida() {
        init();
        this.nivel = 1;
        this.espaciosZombies = 5;
        this.espaciosSoldados = 5;
    }
    
    private void init(){
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = new Espacio();
        }
        System.out.println(""+espacios.length);
    }

    public Espacio[] getEspacios() {
        return espacios;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    

   
    
    
    
    
}
                                     