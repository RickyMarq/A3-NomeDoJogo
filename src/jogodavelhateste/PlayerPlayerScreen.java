/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jogodavelhateste;
import Util.Req;
import Util.ReqPlayerPlayer;
import Util.Resp;
import Util.RespPlayerPlayer;
import Util.playerThread;
import Util.thread;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 *
 * @author rick
 */
public class PlayerPlayerScreen extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form PlayerPlayerScreen
     */
    public PlayerPlayerScreen() {
        initComponents();
    }
    
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    int porta = 54321;
    String ip = "127.0.0.1";    
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    public static final int jogador1 = 1;
    public static final int jogador2 = 2;
    private boolean minhaVez = false;
    boolean continueToPlay = true;
    private boolean waiting = true;
    public static final int CONTINUE = 4;
    private char meuOperador = ' ', OperadorInimigo = ' ';
        public static final int jogador1Ganhou = 1;
    public static final int jogador2Ganhou = 2;
    public static final int empate = 3;
    
    
    private int rowSelected;
    private int columnSelected;
    
    
    public void Jogar() {
         try {
            // o cliente está pedindo conexão com o servidor que está no IP e Porta informados
            socket = new Socket(ip, porta);
            System.out.println("Conectado com o servidor, buscando jogadores");  
            
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }
                
        Thread thread = new Thread();
        thread.start();
                  
    }   
    
    // TODO: RODAR ESSA PORRA DE THREAD.
    
    @Override
    public void run() {
        
         try {
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            
            int player = fromServer.readInt();
            System.out.println("DEBUG MODE: Você é o jogador " + player);

            // TODO: ENVIAR DADOS P/ SERVIDOR
//           out = new ObjectOutputStream(socket.getOutputStream());
//           in = new ObjectInputStream(socket.getInputStream());
//            Req request = new Req(0, -2, -2, false, false);
//            out.writeObject(request);  

            System.out.println("Sou o player " + player);
             
            if (player == jogador1) {
                meuOperador = 'X';
                OperadorInimigo = 'O';
                jLabel2.setText("Operador: " + meuOperador);
                fromServer.readInt();
                jLabel3.setText("Status: Player 2 iniciou. Eu começo.");
                minhaVez = true;
            } else if (player == jogador2) {
                meuOperador = 'O';
                OperadorInimigo = 'X';
                jLabel2.setText("Operador: " + meuOperador); 
                jLabel3.setText("Status: Esperando jogador 1 jogar...");

            }
            
            while (continueToPlay) {
                if (player == jogador1) {
                    esperarPelaJogada();
                    fazerJogada();
                    receberInfoServidor();
                }
                
                else if (player == jogador2) {
                    receberInfoServidor();
                    esperarPelaJogada();
                    fazerJogada();
                }
            }
                   
            
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
        
        /*
      try {
            
            Req request = new Req(2, 2, 1, false, true);
            out.writeObject(request);
            
 //           Resp response = (Resp) = in.readObject();
 
            // O Cliente deve apenas receber e apresentar no board. 
      
      } catch (Exception e) {
          System.out.println("error" + e.getMessage());
      }
        */
        
        
    }
 
  
 /*          try {
    
         
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            int valor2 = 1;

            Req request = new Req(valor2, row, col, false);

            out.writeObject(request);   
            
            Resp response = (Resp) in.readObject();
            
            
            jogodavelhateste.JogoDaVelhaTeste.arr.get(response.getRowIndex()).set(response.getColIndex(), response.getPcOperator());
            // o cliente está pedindo conexão com o servidor que está no IP e Porta informados
//            socket = new Socket(ip, porta);
 //           System.out.println("Conectado com o servidor.");
//            jLabel1.setText("Vez do Computador");
 //       } catch (Exception e) {
 //           System.out.println("Erro: " + e.getMessage());
 //           return;
//        }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar Oponente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton12.setText("< Voltar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton5.setText(".");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText(".");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText(".");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText(".");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText(".");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton2.setText(".");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(".");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(".");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton10.setText(".");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel1.setText("Porta: ");

        jLabel2.setText("Operador: ");

        jButton11.setText("jButton11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton11)
                                    .addComponent(jButton4)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String portaString = jTextField1.getText();
        int portaServidor = Integer.parseInt(portaString);
        
        try {
            // o cliente está pedindo conexão com o servidor que está no IP e Porta informados
            socket = new Socket(ip, portaServidor);
            System.out.println("Conectado com o servidor, buscando jogadores");          
                   
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }
        
        Thread thread = new Thread(this);
        thread.start();
 
        
//        Jogar();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void esperarPelaJogada() throws InterruptedException {
        while (waiting) {
            try {
                Thread.sleep(100); 
            } catch (Exception e) {
                System.out.println("error " + e.getMessage());
            }
        }
        waiting = true;
    }
    
    
    public void receberInfoServidor() throws IOException {
       
        int status = fromServer.readInt();
        if (status == jogador1Ganhou) {
            continueToPlay = false;
            if (meuOperador == 'X') {
                jLabel2.setText("Eu ganhei 🤠 (X)");
            }
            else if (meuOperador == 'O') {
                jLabel2.setText("Jogador 1 ganhou 🤡 (X) ");
                receberDoServidor();
            }
        } 
        else if (status == jogador2Ganhou) {
            continueToPlay = false;
            if (meuOperador == 'O') {
                jLabel2.setText("Eu ganhei 🤠 (O)");
            }
            else if (meuOperador == 'X') {
                jLabel2.setText("Jogador 2 ganhou 🤡 (O) ");
                receberDoServidor();
            }
        }
        else if (status == empate) {
            continueToPlay = false;
            jLabel2.setText("Game is over, no winner!");
            
            if (meuOperador == 'O') {
                receberDoServidor();
            }
        }
        else {
            receberDoServidor();
            jLabel2.setText("My turn");
            minhaVez = true;
        }
        
        // Antigo 
  //      receberDoServidor();
  //      jLabel2.setText("Minha vez");
  //      minhaVez = true;
        
    } 
    
    
    public void receberDoServidor() throws IOException {
        int row = fromServer.readInt();
        int column = fromServer.readInt();
       
        System.out.println("DEBUG: Recebendo do outro lado " + row + column);
        
        if (row == 0 && column == 0 ) {
            jButton2.setText(""+ OperadorInimigo);
        } else if (row == 0 && column == 1) {
            jButton3.setText(""+ OperadorInimigo);
        } else if (row == 0 && column == 2) {
            jButton4.setText(""+ OperadorInimigo);
        } else if (row == 1 && column == 0) {
            jButton10.setText(""+ OperadorInimigo);
        } else if (row == 1 && column == 1 ) {
            jButton5.setText(""+OperadorInimigo); 
        } else if (row == 1 && column == 2) {
            jButton6.setText(""+OperadorInimigo);
        } else if (row == 2 && column == 0) {
            jButton7.setText(""+OperadorInimigo);
        } else if (row == 2 && column == 1) {
            jButton8.setText(""+OperadorInimigo);
        } else if (row == 2 && column == 2) {
            jButton9.setText(""+OperadorInimigo);
        }
    }
    
    public void fazerJogada() throws IOException {
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }
    
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        PlayerPlayerScreen.super.setVisible(false);
        ChooseGameScreen telaHome = new ChooseGameScreen();
        telaHome.getContentPane().setBackground( Color.lightGray );
        telaHome.setLocationRelativeTo(null);
        telaHome.setSize(500, 400);
        telaHome.setResizable(false);
        telaHome.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (minhaVez) {
            
            jButton5.setText(""+ meuOperador);
            
            minhaVez = false;
            rowSelected = 1;
            columnSelected = 1;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (minhaVez) {
            
            jButton6.setText(""+ meuOperador);
            
            minhaVez = false;
            rowSelected = 1;
            columnSelected = 2;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (minhaVez) {
            
            jButton7.setText(""+ meuOperador);
            
            minhaVez = false;
            rowSelected = 2;
            columnSelected = 0;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
          if (minhaVez) {
            
            jButton8.setText(""+ meuOperador);
            
            minhaVez = false;
            rowSelected = 2;
            columnSelected = 1;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       if (minhaVez) {
            
            jButton9.setText(""+ meuOperador);
            
            minhaVez = false;
            rowSelected = 2;
            columnSelected = 2;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (minhaVez) {
            jogodavelhateste.JogoDaVelhaTeste.arr.get(0).set(0, 1);
            
            jButton2.setText(""+ meuOperador);
            
 //           setToken(myToken);
            minhaVez = false;
            rowSelected = 0;
            columnSelected = 0;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (minhaVez) {
 //           jogodavelhateste.JogoDaVelhaTeste.arr.get(0).set(0, 1);
            
            jButton3.setText(""+ meuOperador);
            
 //           setToken(myToken);
            minhaVez = false;
            rowSelected = 0;
            columnSelected = 1;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if (minhaVez) {
 //           jogodavelhateste.JogoDaVelhaTeste.arr.get(0).set(0, 1);
            
            jButton4.setText(""+ meuOperador);
            
 //           setToken(myToken);
            minhaVez = false;
            rowSelected = 0;
            columnSelected = 2;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         if (minhaVez) {
 //           jogodavelhateste.JogoDaVelhaTeste.arr.get(0).set(0, 1);
            
            jButton10.setText(""+ meuOperador);
            
 //           setToken(myToken);
            minhaVez = false;
            rowSelected = 1;
            columnSelected = 0;
            waiting = false;
       } else if (minhaVez == false) {
            System.out.println("Não é a sua vez");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        try {
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
            
            int player = fromServer.readInt();
            System.out.println("DEBUG MODE: Você é o jogador " + player);

            // TODO: ENVIAR DADOS P/ SERVIDOR
//           out = new ObjectOutputStream(socket.getOutputStream());
//           in = new ObjectInputStream(socket.getInputStream());
//            Req request = new Req(0, -2, -2, false, false);
//            out.writeObject(request);  

            System.out.println("Sou o player " + player);
             
            if (player == jogador1) {
                meuOperador = 'X';
                OperadorInimigo = 'O';
                jLabel2.setText("Operador: " + meuOperador);
                fromServer.readInt();
                jLabel3.setText("Status: Player 2 iniciou. Eu começo.");
                minhaVez = true;
            } else if (player == jogador2) {
                meuOperador = 'O';
                OperadorInimigo = 'X';
                jLabel2.setText("Operador: " + meuOperador); 
                jLabel3.setText("Status: Esperando jogador 1 jogar...");

            }
            
            while (continueToPlay) {
                if (player == jogador1) {
                    esperarPelaJogada();
                    fazerJogada();
                    receberInfoServidor();
                }
                else if (player == jogador2) {
                    receberInfoServidor();
                    esperarPelaJogada();
                    fazerJogada();
                }
            }
                   
            
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerPlayerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerPlayerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerPlayerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerPlayerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerPlayerScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

  


}
