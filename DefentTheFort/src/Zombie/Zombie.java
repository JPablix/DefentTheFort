/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zombie;

import defentthefort.Espacio;
import defentthefort.Partida;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author 167069
 */
public abstract class Zombie implements Serializable{
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
    private Partida partida;

    public  Zombie(int vida, int ataque, int campos, int rango, String nombre, Espacio espacio, Partida partida) {
        this.vida = vida;
        this.ataque = ataque;
        this.campos = campos;
        this.rango = rango;
        this.nombre = nombre;
        this.espacio = espacio;
        this.matriz = partida.getEspacios();
        this.ataquesEjercidos = new ArrayList<String>();
        this.ataquesRecibidos = new ArrayList<String>();
        this.partida = partida;
    }
    
    public abstract void atacar();
    
    public void aparecer(){ //Pone la imagen
        this.espacio.getBoton().setIcon(imagen);
        this.espacio.setHasZombie(true);
        this.espacio.setZombie(this);
        System.out.println("("+this.espacio.getPosition('x')+","+ this.espacio.getPosition('y')+") " + nombre +" Zombie Buscando objetivo...");
    }
    
    public void desaparecer(){ //Quita la imagen
        this.espacio.getBoton().setIcon(null);
        this.espacio.setHasZombie(false);
        this.espacio.setZombie(null);
    } 
    
    
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getCampos() {
        return campos;
    }
    public void setCampos(int campos) {
        this.campos = campos;
    }
    public ImageIcon getImagen() {
        return imagen;
    }
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public ArrayList<String> getAtaquesEjercidos() {
        return ataquesEjercidos;
    }

    public void setAtaquesEjercidos(ArrayList<String> ataquesEjercidos) {
        this.ataquesEjercidos = ataquesEjercidos;
    }

    public ArrayList<String> getAtaquesRecibidos() {
        return ataquesRecibidos;
    }

    public void setAtaquesRecibidos(ArrayList<String> ataquesRecibidos) {
        this.ataquesRecibidos = ataquesRecibidos;
    }

    public Espacio[] getMatriz() {
        return matriz;
    }

    public void setMatriz(Espacio[] matriz) {
        this.matriz = matriz;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    
    public void recibirDaño(int daño){
        this.vida = this.vida - daño;
    }
}
