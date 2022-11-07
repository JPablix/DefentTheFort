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
    private int espaciosArmas;
    private int multiplicador;
    private boolean Activate;
    private boolean hasPartida;
    Espacio espacios[] = new Espacio[625];

    public Partida() {
        init();
        this.nivel = 1;
        this.espaciosZombies = 20;
        this.espaciosArmas = 20;
        multiplicador = 1;
    }
    
    private void init(){
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = new Espacio(i);
        }
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

    public int getEspaciosZombies() {
        return espaciosZombies;
    }

    public int getEspaciosArmas() {
        return espaciosArmas;
    }

    public void setEspaciosZombies(int espaciosZombies) {
        this.espaciosZombies = espaciosZombies;
    }

    public void setEspaciosArmas(int espaciosArmas) {
        this.espaciosArmas = espaciosArmas;
    }

    public boolean isActivate() {
        return Activate;
    }

    public void setActivate(boolean Activate) {
        this.Activate = Activate;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public boolean isHasPartida() {
        return hasPartida;
    }

    public void setHasPartida(boolean hasPartida) {
        this.hasPartida = hasPartida;
    }


    
    
    
    
    
    
}
                                     