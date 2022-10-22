/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import java.io.Serializable;

/**
 *
 * @author JPablix
 */
public class Usuario implements Serializable{
    private String username;
    //Deben tener una partida

    public Usuario(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    
    
}
