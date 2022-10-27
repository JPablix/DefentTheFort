/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defentthefort;

import Arma.Arma;
import Zombie.Zombie;

/**
 *
 * @author JPablo
 */
public class Espacio {
    boolean hasZombie;
    boolean hasArma;
    Zombie zombie;
    Arma arma;

    public Espacio() {
        this.hasZombie = false;
        this.hasArma = false;
        this.zombie = null;
        this.arma = null;
    }

    
    
    public boolean isHasZombie() {
        return hasZombie;
    }

    public void setHasZombie(boolean hasZombie) {
        this.hasZombie = hasZombie;
    }

    public boolean isHasArma() {
        return hasArma;
    }

    public void setHasArma(boolean hasArma) {
        this.hasArma = hasArma;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
    
    
    
}
