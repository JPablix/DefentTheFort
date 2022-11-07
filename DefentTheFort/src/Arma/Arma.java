/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

import defentthefort.Espacio;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author JPablix
 */
public abstract class Arma implements Serializable{
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

    public  Arma(int vida, int ataque, int campos, int rango, String nombre, ImageIcon imagen, Espacio espacio, Espacio matriz[]) {
        this.vida = vida;
        this.ataque = ataque;
        this.campos = campos;
        this.rango = rango;
        this.nombre = nombre;
        this.espacio = espacio;
        this.imagen = imagen;
        this.matriz = matriz;
        this.ataquesEjercidos = new ArrayList<String>();
        this.ataquesRecibidos = new ArrayList<String>();

        
    }
    
    public void morir(){
        setVida(0);
    }
    
    public abstract void atacar(Espacio espacio);
    
    public abstract boolean buscarObjetivo();
    
    public void aparecer(){ //Pone la imagen
        this.espacio.getBoton().setIcon(imagen);
        this.espacio.setHasArma(true);
        this.espacio.setArma(this);
    }
    
    public void desaparecer(){ //Quita la imagen
        this.espacio.getBoton().setIcon(null);
        this.espacio.setHasArma(false);
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
    public Espacio getEspacio() {
        return espacio;
    }
    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }
    public void recibirDaño(int daño){
        this.vida = this.vida - daño;
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
    
}
