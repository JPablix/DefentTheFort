/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defentthefort;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JPablix
 */
public class Partida implements Serializable{
    private int nivel;
    private int espaciosZombies;
    private int espaciosArmas;
    private boolean Activate;
    private boolean hasPartida;
    private float dificultad;                 //Variable que define los valores 
    Espacio espacios[] = new Espacio[625];
    JLabel infoNivel;
    
    private int zombiesActivos;

    public Partida() {
        init();
        this.nivel = 1;
        this.espaciosZombies = 20;
        this.espaciosArmas = 20;
        this.Activate = false;
        this.dificultad = 1;
    }
    
    public void subirNivel(){
        System.out.println("\n---NIVEL Y DIFICULTAD AUMENTAN---");
        Activate = false;
        zombiesActivos = 0;
        //------AUMENTO DE ESADISTICA USUARIO
        nivel++;                //Se sube de nivel y se entregan los puntos a Armas 
        espaciosArmas = nivel * 5;
        espaciosZombies = nivel * 5;
        System.out.println("Espacios Z, Espacis A");
        //-------AUMENTO DE DIFICULTAD
        float aumentoDif = ((new Random()).nextFloat((float) 0.21)); //Random de 0-20
        dificultad += aumentoDif;
        System.out.println("La dificultad ahora es: "+ dificultad);
        //------RESETEO DE LA INTERFAZ
        limpiarNivel();
        infoNivel.setText("Nivel: "+nivel);
        espacios[312].getBoton().setIcon(new ImageIcon("src\\Imagenes\\Arbol.png"));
    }
    
    public void seguirJugando(){
        Activate = false;
        int option = JOptionPane.showConfirmDialog(null, "¿Desea pasar al nivel?", "El árbol ah sido destruido.", JOptionPane.YES_NO_OPTION);
        if (option == 0){
            System.out.println("Sigue");
            subirNivel();
        }
        else 
            System.out.println("No sigue");
            limpiarNivel();
    }
    
    public void limpiarNivel(){
        System.out.println("\nLimpiando partida...\n");
        for (int i = 0; i < espacios.length; i++) {
            Espacio espacio = espacios[i];
            if (espacio.hasZombie){
                System.out.println("Borrando zombie en "+espacio.getID());
                espacio.getZombie().morir();
            }  
        }
    }
    
    private void init(){
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = new Espacio(i);
        }
    }
    
    public void lblInfoAccess(JLabel infoNivel){
        this.infoNivel = infoNivel;
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

    public float getDificultad() {
        return dificultad;
    }

    public void setDificultad(float dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isHasPartida() {
        return hasPartida;
    }

    public void setHasPartida(boolean hasPartida) {
        this.hasPartida = hasPartida;
    }

    public JLabel getInfoNivel() {
        return infoNivel;
    }

    public void setInfoNivel(JLabel infoNivel) {
        this.infoNivel = infoNivel;
    }

    public int getZombiesActivos() {
        return zombiesActivos;
    }

    public void setZombiesActivos(int zombiesActivos) {
        this.zombiesActivos = zombiesActivos;
    }
    

    
    
    
    
    
    
}
                                     