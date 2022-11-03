/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package defentthefort;


import Arma.Arma;
import Arma.ArmaBloque;
import BaseDeDatos.BDUsuarios;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class GUIPartida extends javax.swing.JFrame implements Serializable{
    int SIZE = 30;
    Partida partida;
    BDUsuarios usuarios;
    ImageIcon tempImageArma;
    
    public GUIPartida(String jugador, Partida partida) {
        initComponents();
        this.partida = partida;
        this.setTitle("Defent The Fort: Zombie Attack \t"+jugador);
        lblNivel.setText("NIVEL: "+partida.getNivel());
        
        generarMatriz();
        partida.espacios[312].boton.setIcon(new ImageIcon("src\\Imagenes\\Arbol.png"));
    }
    
    private void generarMatriz(){   //Generar botones
       int posX = 0;
       int posY = 0;
       //------------------------------------------
       for(int i = 0; i < 625; i++){
           JButton btn = new JButton("");
           if((i%2) == 0){
               btn.setBackground(new Color(0,153,0));
           }else{
              btn.setBackground(new Color(0,102,0));
           }          
           btn.setSize(SIZE, SIZE);
        //-------------------------------
           if(i%25 == 0 && i>0){
               posX = 0;
               posY += SIZE;
           }
        //------------------------------
           btn.setLocation((SIZE*posX++), posY);
           pnlAreaJuego.add(btn);
           partida.espacios[i].setBoton(btn);
           
           btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMatrizActionPerformed(evt,btn);
            }
           });
       }
    }

    private void jButtonMatrizActionPerformed(ActionEvent evt, JButton btn) {
        
        if (tempImageArma == null){                         //Restricción al poner arma por que no se presionó un botón
            System.out.println("POR FALTA DE SELECCIÓN");
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar un arma a colocar");
            return;
        } 
        if (btn.getIcon() != null){                         //Restricción al poner arma
            System.out.println("POR IMAGEN SUPERPUESTA");   //Para quitar imagen debe esta seleccionado algo
            JOptionPane.showMessageDialog(null, "Espacio ya ocupado por un arma");
            System.out.println(btn.getIcon()+"");           //Y se deben recuperar lo puntos
            return;
        }      
        
        btn.setText("NG");                              //Se registras un boton diferente de todos
        
        for (int i = 0; i < 625; i++){                  //Se busca el boton seleccionado en el array
            if (partida.espacios[i].boton.getText().equals("NG")){
                Espacio espacio = partida.espacios[i];
                //TO DO:
                /*-Cambiar el estado del espacio X
                  -Dependiendo del nombre de la imagen se crea distinto tipo de arma
                  -Crear una nuevo arma enviandole la imagen
                  -Antes se verifica si se tiene campos suficientes(DINERO)
                */
                espacio.boton.setText("");              //Se quita la bandera
                btn.setIcon(tempImageArma);             //Se cambia la iamgen
                espacio.setHasArma(true);               //Se cambia el estado del espacio a que si tiene arma
                
                //Cambiar imagen, pero en realidadse debe asignar al 
                //-----------Comparacion de Tipo de Arma
                //System.out.println("DESCRIPCIÓN: "+tempImageArma.getDescription());   //Ver la descripcion del icono tomado
                if (tempImageArma.getDescription().contains("ArmaAerea")){       //crear ArmaAerea Normal
                    System.out.println("Se creo arma Aerea");
                }if (tempImageArma.getDescription().contains("ArmaMuro")){      //crear ArmaMuro Normal
                    System.out.println("Se creo arma Bloque");
                    ArmaBloque muro = new ArmaBloque(100, 10, 1, 0, "Muro", tempImageArma, btn, partida.getEspacios());
                    
                }if (tempImageArma.getDescription().contains("ArmaContacto")){  //crear Armacontacto Normal
                    System.out.println("Se creo arma Contacto");
                }if (tempImageArma.getDescription().contains("ArmaAlcance")){   //crear ArmaAlcance Normal
                    System.out.println("Se creo arma Alcance");
                }if (tempImageArma.getDescription().contains("ArmaImpacto")){  //crear Armacontacto Normal
                    System.out.println("Se creo arma Impacto");
                }if (tempImageArma.getDescription().contains("ArmaMultiple")){  //crear Armacontacto Normal
                    System.out.println("Se creo arma Multiple");
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAreaJuego = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblArmas = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        pnlArmas = new javax.swing.JPanel();
        btnArmaContacto = new javax.swing.JButton();
        btnArmaMuro = new javax.swing.JButton();
        btnArmaImpacto = new javax.swing.JButton();
        btnArmaAerea = new javax.swing.JButton();
        btnArmaDistancia = new javax.swing.JButton();
        btnArmaMultiple = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblLastBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setPreferredSize(new java.awt.Dimension(1110, 750));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        pnlAreaJuego.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblArmas.setBackground(new java.awt.Color(204, 204, 204));
        lblArmas.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArmas.setText("Armas");
        lblArmas.setOpaque(true);

        lblNivel.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNivel.setText("NIVEL: ");

        btnStart.setBackground(new java.awt.Color(0, 153, 51));
        btnStart.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        pnlArmas.setBackground(new java.awt.Color(102, 102, 102));
        pnlArmas.setPreferredSize(new java.awt.Dimension(160, 400));

        btnArmaContacto.setBackground(new java.awt.Color(204, 204, 204));
        btnArmaContacto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnArmaContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArmaContacto.png"))); // NOI18N
        btnArmaContacto.setText("Contacto");
        btnArmaContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaContactoActionPerformed(evt);
            }
        });

        btnArmaMuro.setBackground(new java.awt.Color(204, 204, 204));
        btnArmaMuro.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnArmaMuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArmaMuro.png"))); // NOI18N
        btnArmaMuro.setText("Muro");
        btnArmaMuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaMuroActionPerformed(evt);
            }
        });

        btnArmaImpacto.setBackground(new java.awt.Color(204, 204, 204));
        btnArmaImpacto.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnArmaImpacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArmaImpacto.png"))); // NOI18N
        btnArmaImpacto.setText("Impacto");
        btnArmaImpacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaImpactoActionPerformed(evt);
            }
        });

        btnArmaAerea.setBackground(new java.awt.Color(204, 204, 204));
        btnArmaAerea.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnArmaAerea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArmaAerea.png"))); // NOI18N
        btnArmaAerea.setText("Aérea");
        btnArmaAerea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaAereaActionPerformed(evt);
            }
        });

        btnArmaDistancia.setBackground(new java.awt.Color(204, 204, 204));
        btnArmaDistancia.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnArmaDistancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArmaAlcance.png"))); // NOI18N
        btnArmaDistancia.setText("Distancia");
        btnArmaDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaDistanciaActionPerformed(evt);
            }
        });

        btnArmaMultiple.setBackground(new java.awt.Color(204, 204, 204));
        btnArmaMultiple.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnArmaMultiple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ArmaMultiple.png"))); // NOI18N
        btnArmaMultiple.setText("Múltiple");
        btnArmaMultiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmaMultipleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlArmasLayout = new javax.swing.GroupLayout(pnlArmas);
        pnlArmas.setLayout(pnlArmasLayout);
        pnlArmasLayout.setHorizontalGroup(
            pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArmasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArmaImpacto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArmaDistancia)
                    .addComponent(btnArmaContacto)
                    .addComponent(btnArmaMuro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArmaAerea, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArmaMultiple, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlArmasLayout.setVerticalGroup(
            pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArmasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnArmaContacto)
                .addGap(18, 18, 18)
                .addComponent(btnArmaMuro)
                .addGap(18, 18, 18)
                .addComponent(btnArmaImpacto)
                .addGap(18, 18, 18)
                .addComponent(btnArmaDistancia)
                .addGap(18, 18, 18)
                .addComponent(btnArmaAerea)
                .addGap(18, 18, 18)
                .addComponent(btnArmaMultiple)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("LastSet:");

        lblLastBtn.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblLastBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLastBtn.setText("###");

        javax.swing.GroupLayout pnlAreaJuegoLayout = new javax.swing.GroupLayout(pnlAreaJuego);
        pnlAreaJuego.setLayout(pnlAreaJuegoLayout);
        pnlAreaJuegoLayout.setHorizontalGroup(
            pnlAreaJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAreaJuegoLayout.createSequentialGroup()
                .addContainerGap(789, Short.MAX_VALUE)
                .addGroup(pnlAreaJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAreaJuegoLayout.createSequentialGroup()
                        .addComponent(lblArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAreaJuegoLayout.createSequentialGroup()
                        .addComponent(pnlArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAreaJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAreaJuegoLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblLastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        pnlAreaJuegoLayout.setVerticalGroup(
            pnlAreaJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAreaJuegoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlAreaJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArmas))
                .addGroup(pnlAreaJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAreaJuegoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnlArmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAreaJuegoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(175, 175, 175)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAreaJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAreaJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if (((int)evt.getKeyChar())==27){
            this.setVisible(false);
        }
    }//GEN-LAST:event_formKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            //ImageIcon p = new ImageIcon("src\\Imagenes\\Arbol.png");
        
//        if (encendido){
//           jButton1.setIcon(p);
//            System.out.println("Aparece");
//       }else{
//           jButton1.setIcon(null);
//           System.out.println("Desaparece");
//    }
//        encendido = !encendido;
//        validate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnArmaContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaContactoActionPerformed
        tempImageArma = (ImageIcon) btnArmaContacto.getIcon();
    }//GEN-LAST:event_btnArmaContactoActionPerformed

    private void btnArmaMuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaMuroActionPerformed
        tempImageArma = (ImageIcon) btnArmaMuro.getIcon();
    }//GEN-LAST:event_btnArmaMuroActionPerformed

    private void btnArmaImpactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaImpactoActionPerformed
        tempImageArma = (ImageIcon) btnArmaImpacto.getIcon();
    }//GEN-LAST:event_btnArmaImpactoActionPerformed

    private void btnArmaDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaDistanciaActionPerformed
        tempImageArma = (ImageIcon) btnArmaDistancia.getIcon();
    }//GEN-LAST:event_btnArmaDistanciaActionPerformed

    private void btnArmaAereaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaAereaActionPerformed
        tempImageArma = (ImageIcon) btnArmaAerea.getIcon();
    }//GEN-LAST:event_btnArmaAereaActionPerformed

    private void btnArmaMultipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmaMultipleActionPerformed
        tempImageArma = (ImageIcon) btnArmaMultiple.getIcon();
    }//GEN-LAST:event_btnArmaMultipleActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArmaAerea;
    private javax.swing.JButton btnArmaContacto;
    private javax.swing.JButton btnArmaDistancia;
    private javax.swing.JButton btnArmaImpacto;
    private javax.swing.JButton btnArmaMultiple;
    private javax.swing.JButton btnArmaMuro;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblArmas;
    private javax.swing.JLabel lblLastBtn;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JPanel pnlAreaJuego;
    private javax.swing.JPanel pnlArmas;
    // End of variables declaration//GEN-END:variables
}
