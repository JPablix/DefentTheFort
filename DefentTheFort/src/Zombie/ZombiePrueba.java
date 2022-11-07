/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zombie;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author JPablix
 */
public class ZombiePrueba extends Zombie implements Serializable{
    private int vida;
    private int ataque;
    private int campos;
    private String nombre;
    private JButton btnPosicion;
    private ImageIcon imagen;

    public ZombiePrueba(int vida, int ataque, int campos, String nombre, JButton btnPosicion, ImageIcon imagen) {
        super(vida, ataque, campos, nombre, imagen, btnPosicion);
        this.vida = vida;
        this.ataque = ataque;
        this.campos = campos;
        this.nombre = nombre;
        this.btnPosicion = btnPosicion;
        this.imagen = imagen;
    }
    
    @Override
    public void atacar() {
       
    }
    
}
