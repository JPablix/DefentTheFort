/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zombie;

import defentthefort.Espacio;
import defentthefort.GUIPartida;
import defentthefort.Partida;
import java.awt.Color;
import java.awt.Image;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author 167069
 */
public class Zombie extends Thread implements Serializable{
    private int vida;
    private int ataque;
    private int campos;
    private int rango;
    private String nombre;
    private ImageIcon imagen;
    private Espacio matriz[];
    private Partida partida;
    private ArrayList<Integer> listaNumeros;
    private ArrayList<String> ataqueEjercido;
    private ArrayList<String> ataqueRecibido;
    private int posicion;
    private boolean vivo;
    
    public Zombie(int pVida, int pAtaque, int pCampo, int pRango, String pNombre, String pImagen, Partida partida) {
        this.vida = pVida;
        this.ataque = pAtaque;
        this.campos = pCampo;
        this.rango = pRango;
        this.nombre = pNombre;
        this.imagen = new ImageIcon("src\\Imagenes\\" + pImagen);
        this.posicion = 0;
        this.ataqueEjercido = new ArrayList<String>();
        this.ataqueRecibido = new ArrayList<String>();
        this.partida = partida;
        this.matriz = partida.getEspacios();
        this.vivo = true;
        
        partida.setZombiesActivos(partida.getZombiesActivos()+1);   //Aumentamos en una la aparicion de los zombies
    }
    public void aparecerZombie(){ //Pone la imagen
        if (!vivo)
            return;
        matriz[posicion].getBoton().setIcon(imagen);
        matriz[posicion].setHasZombie(true);
        matriz[posicion].setZombie(this);
    }
    public void desaparecerZombie(){ //Quita la imagen
        if (!matriz[posicion].isHasZombie())
            return;
        matriz[posicion].getBoton().setIcon(null);
        matriz[posicion].setHasZombie(false);
        matriz[posicion].setZombie(null);
    }
    
    public void morir(){
        matriz[posicion].getBoton().setIcon(null);
        matriz[posicion].setHasZombie(false);
        matriz[posicion].setZombie(null);
        
        int idAntigua = matriz[posicion].getID();
        JButton botonAntiguo = matriz[posicion].getBoton();
                
        matriz[posicion] = new Espacio(idAntigua);
        matriz[posicion].setBoton(botonAntiguo);
        this.vivo = false;
    }
    
    @Override
    public void run(){
        listaNumeros = new ArrayList<Integer>();
        //----------------------GENERA NUMERO ALEATORIO-------------------------
        for(int i = 25; i < 626; i += 25){ //Inserta numeros a los lados
           listaNumeros.add(i);
           listaNumeros.add(i-1);
        }
        for (int i = 0; i < 25; i++) { //inserta numeros arriba y abajo
            listaNumeros.add(i);
            listaNumeros.add(i+600);
        }
       
        ThreadLocalRandom tlr3 = ThreadLocalRandom.current();
        int randomNum = tlr3.nextInt(0, listaNumeros.size());
        this.posicion = listaNumeros.get(randomNum);
        //---------------------------------------------------------------------
        try {
            sleep(1000);
            aparecerZombie();
            System.out.println("("+this.matriz[posicion].getPosition('x')+","+this.matriz[posicion].getPosition('y')+") "+this.matriz[posicion].getZombie().getNombre());
        } catch (InterruptedException ex) {
        }
        
        movimiento(matriz[posicion]); //Se produce el movimiento del zombie   
    }
    
    public void movimiento(Espacio espacio){
        int cuadrante = validar(posicion);
        while(partida.isActivate()){
            //--------EXCEPCIONES---------
            if(matriz[posicion].getID() == 312){        //Zombie en posición del árbol
                System.out.println("Muerte al árbol");
                partida.setActivate(false);
                partida.seguirJugando();
                System.out.println("BREAK por zombie en árbol");
                break;
                }
            if (!matriz[posicion].isHasZombie()){                 //Zombie Borrado
                System.out.println("BREAK por falta de zombie");
                break;
            }
            if (!vivo){
                System.out.println("BREAK por muerte");
                break;
            }
                
            //Proceso de movimiento
            try{
                sleep(1000);
                desaparecerZombie();
                switch (cuadrante) {
                    case 1:
                        if(movimientoLineal(posicion).equals("baja")){
                            posicion += 25;
                        }
                        else if(movimientoLineal(posicion).equals("sube")){
                            posicion -= 25;
                        }
                        else if(movimientoLineal(posicion).equals("derecha")){
                            posicion += 1;
                        }
                        else if(movimientoLineal(posicion).equals("izquierda")){
                            posicion -= 1;
                        }
                        else{
                            posicion += 24;
                        }


                        break;
                    case 2:
                        if(movimientoLineal(posicion).equals("baja")){
                            posicion += 25;
                        }
                        else if(movimientoLineal(posicion).equals("sube")){
                            posicion -= 25;
                        }
                        else if(movimientoLineal(posicion).equals("derecha")){
                            posicion += 1;
                        }
                        else if(movimientoLineal(posicion).equals("izquierda")){
                            posicion -= 1;
                        }
                        else
                            posicion += 26;


                        break;
                    case 3:

                        if(movimientoLineal(posicion).equals("baja")){
                            posicion += 25;
                        }
                        else if(movimientoLineal(posicion).equals("sube")){
                            posicion -= 25;
                        }
                        else if(movimientoLineal(posicion).equals("derecha")){
                            posicion += 1;
                        }
                        else if(movimientoLineal(posicion).equals("izquierda")){
                            posicion -= 1;
                        }
                        else
                            posicion -= 24;

                        break;
                    default:
                        if(movimientoLineal(posicion).equals("baja")){
                            posicion += 25;
                        }
                        else if(movimientoLineal(posicion).equals("sube")){
                            posicion -= 25;
                        }
                        else if(movimientoLineal(posicion).equals("derecha")){
                            posicion += 1;
                        }
                        else if(movimientoLineal(posicion).equals("izquierda")){
                            posicion -= 1;
                        }
                        else
                            posicion -= 26;
                        break;
                }
                    aparecerZombie();
                    int posZombie = verificarZombie(posicion);                    
                    if(posZombie > 0){
                        try{
                            if(matriz[posZombie].isHasZombie()){    //Hacer una pausa para no trepar sobre zombie
                                sleep(1000);
                            }
                        }
                        catch(InterruptedException ex){
                        }
                    }
                    buscarObjetivo();
                }//Cierre try
            catch( InterruptedException ex){}

        }
    }
    private String movimientoLineal(int pPosicion){
        double number = (double)pPosicion/25;
        long iPart = (long) number;
        double fPart = number - iPart;
        int x = ((int) (fPart*25))+1;
        int y = (pPosicion/25) + 1;
        
        if(x == 13 && y >= 0 && y <= 12){
            return "baja";
        }
        else if(y == 13 && x >= 0 && x < 13){
            return "derecha";
        }
        else if(x == 13 && y >= 12 && y <= 25){
            return "sube";
        }
        else if(y == 13 && x >= 12 && x <= 25){
            return "izquierda";
        }
        return "";
    }
    
    private int validar(int pPosicion){
        double number = (double)pPosicion/25;
        long iPart = (long) number;
        double fPart = number - iPart;
        int x = ((int) (fPart*25))+1;
        int y = (pPosicion/25) + 1;
        
        
        if(x >= 0 && x < 13 && y >= 0 && y < 13){
            return 2;
        }
        else if(x >= 12 && x <= 25 && y >= 0 && y <= 12){
            return 1;
        }
        else if(x >= 0 && x < 13 && y >= 12 && y <= 25 ){
            return 3;
        }   
        else{
            return 4; 
        }          
    }
    public boolean buscarObjetivo() {
        for (int i = 0; i < matriz.length; i++) {
            if (Math.abs(matriz[i].getPosition('x') - matriz[posicion].getPosition('x')) <= rango && 
                Math.abs(matriz[i].getPosition('y') - matriz[posicion].getPosition('y')) <= rango){
                if (!vivo)
                    return false;
                if (matriz[i].isHasArma()){          //Si el espacio encontrado tiene zombie se procede con el ataque 
                    this.atacar(matriz[i]);            //Atacar
                    return true;                       //Retornar Booleano
                }
            }
        }
        return false;                                  //Retornar Booleano
    }
    
    private int verificarZombie(int posicion){
        if(matriz[posicion-26].isHasZombie() == true){
            return posicion-26;
        }
        else if( matriz[posicion-25].isHasZombie() == true){
            return posicion-25;
        }
        
        else if(matriz[posicion-24].isHasZombie() == true){
            return posicion-24;
        }
        
        else if(matriz[posicion-1].isHasZombie() == true){
            return posicion-1;
        }
        
        else if(matriz[posicion+1].isHasZombie() == true){
            return posicion+1;
        }
        
        else if(matriz[posicion+24].isHasZombie() == true){
            return posicion+24;
        }
        
        else if( matriz[posicion+25].isHasZombie() == true){
            return posicion+25;
        }
        
        else if(matriz[posicion+26].isHasZombie() == true){
            return posicion+26;
        }
        return 0;
    }
    
    private void atacar(Espacio espacio){
        if (!vivo)
            return;
        if (espacio.getArma() == null)
            return;
        while(espacio.getArma() != null && espacio.getArma().getVida() > 0){
            try{
                if (!vivo)
                    return;
                if (partida.isActivate()){
                    sleep(2000);
                    if (espacio.isHasArma()){
                        espacio.getArma().setVida(espacio.getArma().getVida()-this.getAtaque());
                        System.out.println( nombre + " ataca -> " + espacio.getArma().getNombre()+" vida restante " + espacio.getArma().getVida());
                    }
                }
             }
            catch(InterruptedException ex){
            }
        }
        if (espacio.isHasArma())
            espacio.getArma().desaparecer();
            
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
    public ArrayList<Integer> getListaNumeros() {
        return listaNumeros;
    }
    public void setListaNumeros(ArrayList<Integer> listaNumeros) {
        this.listaNumeros = listaNumeros;
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

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    
}