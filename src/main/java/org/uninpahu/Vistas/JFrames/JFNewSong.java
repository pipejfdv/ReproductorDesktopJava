package org.uninpahu.Vistas.JFrames;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import org.uninpahu.ConfigPlayer.saveSong;
import org.uninpahu.Controlers.ControlerAlbum;
import org.uninpahu.Controlers.ControlerGender;
import org.uninpahu.Controlers.ControlerSong;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Modelo.Gender;
import org.uninpahu.Modelo.Song;


public class JFNewSong extends javax.swing.JFrame {

    JFIndex index = new JFIndex();
    
    ControlerSong controlerSong = new ControlerSong();
    ControlerGender controlerGender = new ControlerGender();
    ControlerAlbum controlerAlbum = new ControlerAlbum();
    
    public JFNewSong() {
        initComponents();
        setDataBoxGender();
        index.addPlaceHolderStyle(jTNameSong);
        index.addPlaceHolderStyle(jTCreationDate);
        index.addPlaceHolderStyle(jTDuration);
        index.addPlaceHolderStyle(jTAlbum);
    }

    private void setDataBoxGender(){
        List<Gender> listaGeneder = controlerGender.listGender();
        for(Gender g: listaGeneder){
            BoxGender.addItem(g.getNameGender());
        }
    }
    
    private void addSong(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate creationDate = LocalDate.parse(jTCreationDate.getText(), dateFormat);
        
        String duracion = jTDuration.getText();
        String[] timeParts = duracion.split(":");
        long hours = Long.parseLong(timeParts[0]);
        long minutes = Long.parseLong(timeParts[1]);
        long seconds = Long.parseLong(timeParts[2]);
        Duration duration = Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        
        String genderSelected = (String) BoxGender.getSelectedItem();
        Gender gender = controlerGender.searchGender(null, genderSelected);
        Album album = new Album(UUID.randomUUID().toString(), jTAlbum.getText(), LocalDate.now(), gender);
        controlerAlbum.createAlbum(album);
        String nameFile = saveSong.uploadMP3Song();
        Song song = new Song(UUID.randomUUID().toString(),
                jTNameSong.getText(), 
                creationDate, 
                duration, 
                gender,
                album, 
                nameFile);
        controlerSong.insertSong(song);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jTNameSong = new javax.swing.JTextField();
        jTCreationDate = new javax.swing.JTextField();
        jTDuration = new javax.swing.JTextField();
        BoxGender = new javax.swing.JComboBox<>();
        jTAlbum = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        label.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        label.setText("Create new Song");

        jTNameSong.setText("Song");
        jTNameSong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTNameSongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNameSongFocusLost(evt);
            }
        });
        jTNameSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNameSongActionPerformed(evt);
            }
        });

        jTCreationDate.setText("\"dd-mm-yyyy\"");
        jTCreationDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTCreationDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCreationDateFocusLost(evt);
            }
        });
        jTCreationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCreationDateActionPerformed(evt);
            }
        });

        jTDuration.setText("HH:MM:SS");
        jTDuration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTDurationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDurationFocusLost(evt);
            }
        });

        jTAlbum.setText("Album");
        jTAlbum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTAlbumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAlbumFocusLost(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Save song");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("Cancel");
        jToggleButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label1.setText("If the album name is not");

        label2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label2.setText("a single.");

        label3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label3.setText("added, it will be saved as ");

        label4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label4.setText("Name");

        label5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label5.setText("Date of creation song");

        label6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label6.setText("Duration");

        label7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label7.setText("Gender of music");

        label8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label8.setText("Name album");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(label))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label1)
                                        .addComponent(label3)
                                        .addComponent(label2))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTNameSong, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label6))))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(label7)
                            .addComponent(label8))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label)
                        .addGap(26, 26, 26)
                        .addComponent(label5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTNameSong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(label7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1)
                    .addComponent(label8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3)
                    .addComponent(jTAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCreationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCreationDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCreationDateActionPerformed

    private void jTNameSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNameSongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNameSongActionPerformed

    private void jTNameSongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNameSongFocusGained
        if(jTNameSong.getText().equals("Song")){
            jTNameSong.setText(null);
            jTNameSong.requestFocus();
            index.removePlaceHolderStyle(jTNameSong);
        }
    }//GEN-LAST:event_jTNameSongFocusGained

    private void jTNameSongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNameSongFocusLost
        if(jTNameSong.getText().length()==0){
            jTNameSong.setText("Song");
            index.addPlaceHolderStyle(jTNameSong);
        }
    }//GEN-LAST:event_jTNameSongFocusLost

    private void jTCreationDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCreationDateFocusGained
        if(jTCreationDate.getText().equals("\"dd-mm-yyyy\"")){
            jTCreationDate.setText(null);
            jTCreationDate.requestFocus();
            index.removePlaceHolderStyle(jTCreationDate);
        }
    }//GEN-LAST:event_jTCreationDateFocusGained

    private void jTCreationDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCreationDateFocusLost
        if(jTCreationDate.getText().length()==0){
            jTCreationDate.setText("\"dd-mm-yyyy\"");
            index.addPlaceHolderStyle(jTCreationDate);
        }
    }//GEN-LAST:event_jTCreationDateFocusLost

    private void jTDurationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDurationFocusGained
        if(jTDuration.getText().equals("HH:MM:SS")){
            jTDuration.setText(null);
            jTDuration.requestFocus();
            index.removePlaceHolderStyle(jTDuration);
        }
    }//GEN-LAST:event_jTDurationFocusGained

    private void jTDurationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDurationFocusLost
        if(jTDuration.getText().length()==0){
            jTDuration.setText("HH:MM:SS");
            index.addPlaceHolderStyle(jTDuration);
        }
    }//GEN-LAST:event_jTDurationFocusLost

    private void jTAlbumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAlbumFocusGained
        if(jTAlbum.getText().equals("Album")){
            jTAlbum.setText(null);
            jTAlbum.requestFocus();
            index.removePlaceHolderStyle(jTAlbum);
        }
    }//GEN-LAST:event_jTAlbumFocusGained

    private void jTAlbumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAlbumFocusLost
        if(jTAlbum.getText().length()==0){
            jTAlbum.setText("Album");
            index.addPlaceHolderStyle(jTAlbum);
        }
    }//GEN-LAST:event_jTAlbumFocusLost

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        addSong();
        this.setVisible(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxGender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTAlbum;
    private javax.swing.JTextField jTCreationDate;
    private javax.swing.JTextField jTDuration;
    private javax.swing.JTextField jTNameSong;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    // End of variables declaration//GEN-END:variables
}
