/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arma;

import defentthefort.Espacio;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author JPablo
 */
public class ArmaBloque extends Arma{
    private int vida;
    private int ataque;
    private int campos;
    private int rango;
    private String nombre;
    private JButton btnPosicion;
    private ImageIcon imagen;
    private ArrayList<String> ataquesEjercidos;
    private ArrayList<String> ataquesRecibidos;
    
    public ArmaBloque(int vida, int ataque, int campos, int rango, String nombre, ImageIcon imagen, JButton posicion, Espacio matriz[]) {
        super(vida, ataque, campos,rango, nombre, imagen, posicion, matriz);
        this.vida = vida;
        this.btnPosicion = posicion;
    }

    
    
    @Override
    public void atacar() {
        
    }

    @Override
    public boolean buscarObjetivo() {
        //if (this.)
        System.out.println("uu");
        return false;
    }
    
    
}
