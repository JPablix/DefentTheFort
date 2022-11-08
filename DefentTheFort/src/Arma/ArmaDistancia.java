/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

import Zombie.Zombie;
import defentthefort.Espacio;
import defentthefort.Partida;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author JPablo
 */
public class ArmaDistancia extends Arma{

    public ArmaDistancia(int vida, int ataque, int campos, int rango, String nombre, ImageIcon imagen, Espacio espacio, Espacio[] matriz, Partida partida) {
        super(vida, ataque, campos, rango, nombre, espacio, partida);

        this.setImagen(new ImageIcon("src\\Imagenes\\ArmaAlcance.png"));
        this.aparecer();        
    }
    
    @Override
    public void atacar(Espacio zombieEncontrado) {
        Zombie zombie = zombieEncontrado.getZombie();
        zombie.recibirDaño(this.getAtaque());
        System.out.println(zombie.getNombre()+" -"+this.getAtaque()+" de vida.");
        this.getAtaquesEjercidos().add(zombie.getNombre());
    }

}
