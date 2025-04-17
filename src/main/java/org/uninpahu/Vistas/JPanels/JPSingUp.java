package org.uninpahu.Vistas.JPanels;

import java.util.Optional;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.uninpahu.Controlers.ControlerPerson;
import org.uninpahu.Controlers.ControlerRol;
import org.uninpahu.Controlers.ControlerUser;
import org.uninpahu.Modelo.Person;
import org.uninpahu.Modelo.Rol;
import org.uninpahu.Modelo.User;
import org.uninpahu.Vistas.JFrames.JFIndex;

public class JPSingUp extends javax.swing.JPanel {
    
    private final JFIndex jFIndex;
    private boolean rolActive = false;
    ControlerUser controlerUser = new ControlerUser();
    ControlerPerson controlerPerson = new ControlerPerson();
    ControlerRol controlerRol = new ControlerRol();
    
    
    public JPSingUp(JFIndex index) {
        initComponents();
        this.jFIndex = index;
        jFIndex.addPlaceHolderStyle(jTnames);
        jFIndex.addPlaceHolderStyle(jTlastnames);
        jFIndex.addPlaceHolderStyle(jTemail);
        jFIndex.addPlaceHolderStyle(jTnickname);
        jFIndex.addPlaceHolderStyle(jPassword);
        jFIndex.addPlaceHolderStyle(jPasswordConfirm);
    }
    
    public void returnLogin(){
        JPIndexAuth index = new JPIndexAuth(this.jFIndex);
        JFIndex changePanel = (JFIndex) SwingUtilities.getWindowAncestor(this);
        changePanel.changeContent(index);
    }
    
    private Rol assignRol(boolean rolActive){
        if(rolActive){
            return controlerRol.readRol("Artista");
        }
        else{
            return controlerRol.readRol("Usuario");
        }
    }
    
    private void newRegistry(){
        String id = UUID.randomUUID().toString();
        Person newPerson = new Person(id, jTnames.getText(), jTlastnames.getText(), jTemail.getText());
        controlerPerson.insertPerson(newPerson);
        User newUser = new User(id, jTnickname.getText(), jPassword.getText(), assignRol(rolActive), newPerson);
        controlerUser.insertUser(newUser);
    }
    
    private Boolean duplicateData(String email, String nickname){
        /*
        * Se aplica consulta lambda y se maneja Optional para el almacenamiento de datos
        */
        Optional<User> userOpt = Optional.ofNullable(controlerUser.searchByNickname(nickname));
        Optional<Person> personOpt = Optional.ofNullable(controlerPerson.emailSearch(email));
        
        if(userOpt.isPresent() || personOpt.isPresent()){
            JOptionPane.showMessageDialog(null, "The email or nickma is already");
            return false;
        }
        else{
            return true;
        }
    }
    
    private Boolean confirmData(){
        if(jTnames.getText().equals("Names") || jTnames.getText().length()==0 && jTlastnames.getText().equals("Lastnames") || 
                jTlastnames.getText().length() == 0 && jTemail.getText().equals("Email") || jTemail.getText().length() == 0 &&
                jTnickname.getText().equals("Nickname") || jTnickname.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "you have empty fields");
            return false;
        }
        else{
            if(jPassword.getText().length() == 0 || jPasswordConfirm.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "The passwords is empty");
                return false;
            }
            else if(!jPassword.getText().equals(jPasswordConfirm.getText())){
                JOptionPane.showMessageDialog(null, "The passwords is not same");
                return false;
            }
            else if(jPassword.getText().contains(" ") || jPasswordConfirm.getText().contains(" ")){
                JOptionPane.showMessageDialog(null, "The password cannot have spaces");
                return false;
            }
            else{
                return true;
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        singUpImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTnames = new javax.swing.JTextField();
        jTlastnames = new javax.swing.JTextField();
        jTemail = new javax.swing.JTextField();
        jTnickname = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jPasswordConfirm = new javax.swing.JPasswordField();
        ToggleConfirmArtis = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jBcancel = new javax.swing.JButton();
        jBregistry = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(703, 429));

        jPanel1.setPreferredSize(new java.awt.Dimension(703, 429));

        singUpImg.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/edit.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("New Registry");

        jTnames.setText("Names");
        jTnames.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTnamesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTnamesFocusLost(evt);
            }
        });
        jTnames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnamesActionPerformed(evt);
            }
        });

        jTlastnames.setText("Lastnames");
        jTlastnames.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTlastnamesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTlastnamesFocusLost(evt);
            }
        });

        jTemail.setText("Email");
        jTemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTemailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTemailFocusLost(evt);
            }
        });

        jTnickname.setText("Nickname");
        jTnickname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTnicknameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTnicknameFocusLost(evt);
            }
        });

        jPassword.setText("Password");
        jPassword.setEchoChar('\u0000');
        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFocusLost(evt);
            }
        });

        jPasswordConfirm.setText("Confirm Password");
        jPasswordConfirm.setEchoChar('\u0000');
        jPasswordConfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordConfirmFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordConfirmFocusLost(evt);
            }
        });

        ToggleConfirmArtis.setBackground(new java.awt.Color(204, 255, 204));
        ToggleConfirmArtis.setText("Yes");
        ToggleConfirmArtis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ToggleConfirmArtisFocusLost(evt);
            }
        });
        ToggleConfirmArtis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleConfirmArtisActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("Are you artist?");

        jBcancel.setBackground(new java.awt.Color(255, 0, 0));
        jBcancel.setForeground(new java.awt.Color(255, 255, 255));
        jBcancel.setText("Cancel");
        jBcancel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelActionPerformed(evt);
            }
        });

        jBregistry.setBackground(new java.awt.Color(0, 102, 0));
        jBregistry.setForeground(new java.awt.Color(255, 255, 255));
        jBregistry.setText("Create account");
        jBregistry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBregistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBregistryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jBregistry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jBcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTnames, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTlastnames, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jTemail, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jTnickname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ToggleConfirmArtis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(singUpImg)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(singUpImg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTnames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTlastnames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTnickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ToggleConfirmArtis))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBregistry)
                    .addComponent(jBcancel))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ToggleConfirmArtisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ToggleConfirmArtisFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ToggleConfirmArtisFocusLost

    private void jTnamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnamesActionPerformed
        
    }//GEN-LAST:event_jTnamesActionPerformed

    private void jTnamesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnamesFocusGained
        if(jTnames.getText().equals("Names")){
            jTnames.setText(null);
            jTnames.requestFocus();
            jFIndex.removePlaceHolderStyle(jTnames);
        }
    }//GEN-LAST:event_jTnamesFocusGained

    private void jTnamesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnamesFocusLost
        if(jTnames.getText().length()==0){
            jTnames.setText("Names");
            jFIndex.addPlaceHolderStyle(jTnames);
        }
    }//GEN-LAST:event_jTnamesFocusLost

    private void jTlastnamesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTlastnamesFocusGained
        if(jTlastnames.getText().equals("Lastnames")){
            jTlastnames.setText(null);
            jTlastnames.requestFocus();
            jFIndex.removePlaceHolderStyle(jTlastnames);
        }
    }//GEN-LAST:event_jTlastnamesFocusGained

    private void jTlastnamesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTlastnamesFocusLost
        if(jTlastnames.getText().length()==0){
            jTlastnames.setText("Lastnames");
            jFIndex.addPlaceHolderStyle(jTlastnames);
        }
    }//GEN-LAST:event_jTlastnamesFocusLost

    private void jTemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTemailFocusGained
        if(jTemail.getText().equals("Email")){
            jTemail.setText(null);
            jTemail.requestFocus();
            jFIndex.removePlaceHolderStyle(jTemail);
        }
    }//GEN-LAST:event_jTemailFocusGained

    private void jTemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTemailFocusLost
        if(jTemail.getText().length()==0){
            jTemail.setText("Email");
            jFIndex.addPlaceHolderStyle(jTemail);
        }
    }//GEN-LAST:event_jTemailFocusLost

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained
        if(jPassword.getText().equals("Password")){
            jFIndex.removePlaceHolderStyle(jPassword);
            jPassword.setText(null);
            jPassword.requestFocus();
            jPassword.setEchoChar('0');
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusLost
        if(jPassword.getText().length()==0){
            jFIndex.addPlaceHolderStyle(jPassword);
            jPassword.setText("Password");
            jPassword.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jPasswordFocusLost

    private void jPasswordConfirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordConfirmFocusGained
        if(jPasswordConfirm.getText().equals("Confirm Password")){
            jFIndex.removePlaceHolderStyle(jPasswordConfirm);
            jPasswordConfirm.setText(null);
            jPasswordConfirm.requestFocus();
            jPasswordConfirm.setEchoChar('0');
        }
    }//GEN-LAST:event_jPasswordConfirmFocusGained

    private void jPasswordConfirmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordConfirmFocusLost
        if(jPasswordConfirm.getText().length()==0){
            jFIndex.addPlaceHolderStyle(jPasswordConfirm);
            jPasswordConfirm.setText("Confirm Password");
            jPasswordConfirm.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jPasswordConfirmFocusLost

    private void jTnicknameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnicknameFocusGained
        if(jTnickname.getText().equals("Nickname")){
            jTnickname.setText(null);
            jTnickname.requestFocus();
            jFIndex.removePlaceHolderStyle(jTnickname);
        }
    }//GEN-LAST:event_jTnicknameFocusGained

    private void jTnicknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnicknameFocusLost
        if(jTnickname.getText().length()==0){
            jTnickname.setText("Nickname");
            jFIndex.addPlaceHolderStyle(jTnickname);
        }
    }//GEN-LAST:event_jTnicknameFocusLost

    private void jBcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelActionPerformed
        returnLogin();
    }//GEN-LAST:event_jBcancelActionPerformed

    private void jBregistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBregistryActionPerformed
        if(confirmData() && duplicateData(jTemail.getText(), jTnickname.getText())){
            newRegistry();
            JOptionPane.showMessageDialog(null, "Registry succesfull");
            returnLogin();
        }
    }//GEN-LAST:event_jBregistryActionPerformed

    private void ToggleConfirmArtisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToggleConfirmArtisActionPerformed
        if(ToggleConfirmArtis.isSelected()){
            rolActive = true;
        }
    }//GEN-LAST:event_ToggleConfirmArtisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ToggleConfirmArtis;
    private javax.swing.JButton jBcancel;
    private javax.swing.JButton jBregistry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPasswordConfirm;
    private javax.swing.JTextField jTemail;
    private javax.swing.JTextField jTlastnames;
    private javax.swing.JTextField jTnames;
    private javax.swing.JTextField jTnickname;
    private javax.swing.JLabel singUpImg;
    // End of variables declaration//GEN-END:variables
}
