
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Timer;






public class TicTacToe extends javax.swing.JFrame {
    int p1Score = 0;
    int p2Score = 0;
    String move = "X";
    public TicTacToe() {
        initComponents();
        setSize(1200,800);
        setLocationRelativeTo(null);
    }
    Timer time = new Timer();
    public void reset(){
        jButton1.setBackground(Color.white);
        jButton2.setBackground(Color.white);
        jButton3.setBackground(Color.white);
        jButton6.setBackground(Color.white);
        jButton7.setBackground(Color.white);
        jButton8.setBackground(Color.white);
        jButton11.setBackground(Color.white);
        jButton12.setBackground(Color.white);
        jButton13.setBackground(Color.white);
        
        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton11.setText("");
        jButton12.setText("");
        jButton13.setText("");
        
    }
    
       public void addScore(){
        if(jButton1.getText().equals("X")&&jButton2.getText().equals("X")&&jButton3.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
          p1Score++;          
         player1Score.setText(String.valueOf(p1Score));
          reset();
        }
        else if(jButton1.getText().equals("X")&&jButton7.getText().equals("X")&&jButton13.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
         else if(jButton1.getText().equals("X")&&jButton6.getText().equals("X")&&jButton11.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
         else if(jButton2.getText().equals("X")&&jButton7.getText().equals("X")&&jButton12.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
         else if(jButton3.getText().equals("X")&&jButton8.getText().equals("X")&&jButton13.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
         else if(jButton3.getText().equals("X")&&jButton7.getText().equals("X")&&jButton11.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
         else if(jButton6.getText().equals("X")&&jButton7.getText().equals("X")&&jButton8.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
         else if(jButton11.getText().equals("X")&&jButton12.getText().equals("X")&&jButton13.getText().equals("X")){
            JOptionPane.showConfirmDialog(null, "Player 1 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p1Score++;
            player1Score.setText(String.valueOf(p1Score));
            reset();
        }
        
        if(jButton1.getText().equals("O")&&jButton2.getText().equals("O")&&jButton3.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
          p2Score++;
          player2Score.setText(String.valueOf(p2Score));
          reset();
        }
        else if(jButton1.getText().equals("O")&&jButton7.getText().equals("O")&&jButton13.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            player2Score.setText(String.valueOf(p2Score));
            reset();
        }
         else if(jButton1.getText().equals("O")&&jButton6.getText().equals("O")&&jButton11.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            player2Score.setText(String.valueOf(p2Score));
            reset();
        }
         else if(jButton2.getText().equals("O")&&jButton7.getText().equals("O")&&jButton12.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            player2Score.setText(String.valueOf(p2Score));
            reset();
        }
         else if(jButton3.getText().equals("O")&&jButton8.getText().equals("O")&&jButton13.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            reset();
        }
         else if(jButton3.getText().equals("O")&&jButton7.getText().equals("O")&&jButton11.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            player2Score.setText(String.valueOf(p2Score));
            reset();
        }
         else if(jButton6.getText().equals("O")&&jButton7.getText().equals("O")&&jButton8.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            player2Score.setText(String.valueOf(p2Score));
            reset();
        }
         else if(jButton11.getText().equals("O")&&jButton12.getText().equals("O")&&jButton13.getText().equals("O")){
            JOptionPane.showConfirmDialog(null, "Player 2 wins", "Hey", JOptionPane.DEFAULT_OPTION);
            p2Score++;
            player2Score.setText(String.valueOf(p2Score));
            reset();
        }
    }
       public void start(){
           if(move.equals("X")){
               move = "O";
           }
           else{
               move="X";
           }
       }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        player1Score = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        player2Score = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tic-Tac-Toe");
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.GridLayout(3, 5, 2, 3));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Player 1 Score:");
        jPanel6.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        player1Score.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        player1Score.setName("p1Scoree"); // NOI18N
        jPanel7.add(player1Score, java.awt.BorderLayout.CENTER);
        player1Score.getAccessibleContext().setAccessibleName("player1Score");

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel9);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel10);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton9.setText("Player 2 Score:");
        jPanel11.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel11);

        jPanel12.setLayout(new java.awt.BorderLayout());

        player2Score.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        player2Score.setName("p2Score"); // NOI18N
        jPanel12.add(player2Score, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel12);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel13);

        jPanel14.setLayout(new java.awt.BorderLayout());

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton12, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel14);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton13, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel15);

        jPanel16.setLayout(new java.awt.BorderLayout());

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton14.setText("Reset");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton14, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel16);

        jPanel17.setLayout(new java.awt.BorderLayout());

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton15.setText("Exit");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton15, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel17);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     jButton1.setText(move);
     if(jButton1.getText().equals("X")){
         jButton1.setBackground(Color.red);
     }
     else{
         jButton1.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  jButton2.setText(move);
     if(jButton2.getText().equals("X")){
         jButton2.setBackground(Color.red);
     }
     else{
         jButton2.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setText(move);
     if(jButton3.getText().equals("X")){
         jButton3.setBackground(Color.red);
     }
     else{
         jButton3.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       jButton6.setText(move);
     if(jButton6.getText().equals("X")){
         jButton6.setBackground(Color.red);
     }
     else{
         jButton6.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setText(move);
     if(jButton7.getText().equals("X")){
         jButton7.setBackground(Color.red);
     }
     else{
         jButton7.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       jButton8.setText(move);
     if(jButton8.getText().equals("X")){
         jButton8.setBackground(Color.red);
     }
     else{
         jButton8.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jButton11.setText(move);
     if(jButton11.getText().equals("X")){
         jButton11.setBackground(Color.red);
     }
     else{
         jButton11.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
      jButton12.setText(move);
     if(jButton12.getText().equals("X")){
         jButton12.setBackground(Color.red);
     }
     else{
         jButton12.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       jButton13.setText(move);
     if(jButton13.getText().equals("X")){
         jButton13.setBackground(Color.red);
     }
     else{
         jButton13.setBackground(Color.cyan);
     }
     start();
     addScore();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
reset();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        JFrame frame = new JFrame("Exit");
        int dialogButton = JOptionPane.YES_NO_OPTION;
    if(JOptionPane.showConfirmDialog (frame, "Are you sure you want to exit?","",dialogButton)==JOptionPane.YES_NO_OPTION){
           System.exit(0);
    }

    
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton player1Score;
    private javax.swing.JButton player2Score;
    // End of variables declaration//GEN-END:variables
}
