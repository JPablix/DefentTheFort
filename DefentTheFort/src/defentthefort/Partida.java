/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defentthefort;

import java.io.Serializable;

/**
 *
 * @author JPablix
 */
public class Partida implements Serializable{
    private int nivel;
    private int espaciosZombies;
    private int espaciosSoldados;
    private GUIPartida GUI;

    public Partida() {
        this.nivel = 1;
        this.espaciosZombies = 5;
        this.espaciosSoldados = 5;
        this.GUI = new GUIPartida();
    }

    public GUIPartida getGUI() {
        return GUI;
    }
    
    
    
    
}
                                     