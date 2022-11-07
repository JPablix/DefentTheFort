/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

import Zombie.Zombie;
import defentthefort.Espacio;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author JPablo
 */
public class ArmaAerea extends Arma{
    private int vida;
    private int ataque;
    private int campos;
    private int rango;
    private String nombre;
    private Espacio espacio;
    private ImageIcon imagen;
    private ArrayList<String> ataquesEjercidos;
    private ArrayList<String> ataquesRecibidos;
    private Espacio matriz[];

    public ArmaAerea(int vida, int ataque, int campos, int rango, String nombre, ImageIcon imagen, Espacio espacio, Espacio[] matriz) {
        super(vida, ataque, campos, rango, nombre, imagen, espacio, matriz);
        this.vida = vida;
        this.ataque = ataque;
        this.campos = campos;
        this.rango = rango;
        this.nombre = nombre;
        this.espacio = espacio;
        this.imagen = new ImageIcon("src\\Imagenes\\ArmaAerea.png");
        this.matriz = matriz;

        this.aparecer();
        System.out.println();
        System.out.println("("+this.espacio.getPosition('x')+","+ this.espacio.getPosition('y')+") " + nombre +" Buscando objetivo...");
        this.buscarObjetivo();
    }
    
    @Override
    public void atacar(Espacio zombieEncontrado) {
        Zombie zombie = zombieEncontrado.getZombie();
        zombie.setVida(zombie.getVida()-ataque);
      
        System.out.println("Zombie atacado, -"+ataque+" de vida.");
    }

    @Override
    public boolean buscarObjetivo() {
        for (int i = 0; i < matriz.length; i++) {
            if (Math.abs(matriz[i].getPosition('x') - espacio.getPosition('x')) <= rango && 
                Math.abs(matriz[i].getPosition('y') - espacio.getPosition('y')) <= rango){
                
                if (matriz[i].isHasZombie()){   //Si el espacio encontrado tiene zombie se procede con el ataque 
                    matriz[i].getZombie().getNombre(); //Añadir el atacado al Array
                    atacar(matriz[i]);                 //Atacar
                    return true;                       //Retornar Booleano
                }
            }
        }
        return false;                                  //Retornar Booleano
    }
}
