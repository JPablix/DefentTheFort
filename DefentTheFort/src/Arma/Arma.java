/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author JPablix
 */
public abstract class Arma {
    private int vida;
    private int ataque;
    private int campos;
    private String nombre;
    private JButton txfPosicion;
    private Image imagen;

    public Arma(int vida, int ataque, int campos, String nombre, Image imagen, JButton posicion) {
        this.vida = vida;
        this.ataque = ataque;
        this.campos = campos;
        this.nombre = nombre;
        this.imagen = imagen;
        this.txfPosicion = posicion;
        //Falta Arrays
    }
    
    public void morir(){
        setVida(0);
    }
    public abstract void atacar();
    
    
    public void aparecer(){ //Pone la imagen
        this.txfPosicion.setIcon((Icon) imagen);
    }
    
    public void desaparecer(){ //Quita la imagen
        this.txfPosicion.setDisabledIcon((Icon) imagen);
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
    public Image getImagen() {
        return imagen;
    }
    public void setImagen(Image imagen) {
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
    public JButton getTxfPosicion() {
        return txfPosicion;
    }
    public void setTxfPosicion(JButton txfPosicion) {
        this.txfPosicion = txfPosicion;
    }
    
    
    
   
    
}
