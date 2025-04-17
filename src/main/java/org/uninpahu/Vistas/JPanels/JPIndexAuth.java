
package org.uninpahu.Vistas.JPanels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import org.uninpahu.Vistas.JFrames.JFIndex;


public class JPIndexAuth extends javax.swing.JPanel {

    private JFIndex index;
    
    public JPIndexAuth(JFIndex index) {
        initComponents();
        this.index = index;
        index.addPlaceHolderStyle(jTnickname);
        index.addPlaceHolderStyle(jPassword);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backgroundImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTnickname = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        backgroundImg.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/backgroundIndex.jpg")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Spotify Desktop");

        jTnickname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTnickname.setText("Nickname");
        jTnickname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTnicknameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTnicknameFocusLost(evt);
            }
        });

        jPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPassword.setText("Password");
        jPassword.setDragEnabled(true);
        jPassword.setEchoChar('\u0000');
        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login In");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sign Up");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backgroundImg, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPassword)
                        .addComponent(jTnickname, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundImg, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jTnickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTnicknameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnicknameFocusGained
        if(jTnickname.getText().equals("Nickname")){
            jTnickname.setText(null);
            jTnickname.requestFocus();
            index.removePlaceHolderStyle(jTnickname);
        }
    }//GEN-LAST:event_jTnicknameFocusGained

    private void jTnicknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnicknameFocusLost
        if(jTnickname.getText().length()==0){
            index.addPlaceHolderStyle(jTnickname);
            jTnickname.setText("Nickname");
        }
    }//GEN-LAST:event_jTnicknameFocusLost

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained
        if(jPassword.getText().equals("Password")){
            jPassword.setText(null);
            jPassword.requestFocus();
            jPassword.setEchoChar('0');
            index.removePlaceHolderStyle(jTnickname);
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusLost
        if(jPassword.getText().length()==0){
            index.addPlaceHolderStyle(jPassword);
            jPassword.setText("Password");
            jPassword.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jPasswordFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JPSingUp newRegistry = new JPSingUp(index);
        index.changeContent(newRegistry);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTnickname;
    // End of variables declaration//GEN-END:variables
}
