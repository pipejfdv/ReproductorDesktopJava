package org.uninpahu.Vistas.JFrames;

import java.util.UUID;
import javax.swing.JOptionPane;
import org.uninpahu.Controlers.ControlerPlaylist;
import org.uninpahu.Controlers.ControlerPlaylistSongs;
import org.uninpahu.Controlers.ControlerSong;
import org.uninpahu.Controlers.ControlerUser;
import org.uninpahu.Modelo.Playlist;
import org.uninpahu.Modelo.Song;
import org.uninpahu.Modelo.User;
import org.uninpahu.Services.Session;


public class JFCreatePlaylist extends javax.swing.JFrame {

    ControlerPlaylist controlerPlaylist = new ControlerPlaylist();
    ControlerUser controlerUser = new ControlerUser();
    ControlerPlaylistSongs controlerPlaylistSongs = new ControlerPlaylistSongs();
    ControlerSong controlerSong = new ControlerSong();
    
    String selectedSong;
    
    public JFCreatePlaylist() {
        this.setUndecorated(true);
        initComponents();
    }
    
    public void albumsongselection(String songSelected){
        this.selectedSong = songSelected;
        jLSong.setText(selectedSong);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        jTNamePlaylist = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();
        jLSong = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        label.setText("Create your playlist");

        label1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label1.setText("Playlist name");

        jTNamePlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNamePlaylistActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/anadir.png")); // NOI18N
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        label2.setText("the previously selected song will be added");

        jLSong.setText("Song");

        jButton2.setText("Cancel");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(label))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLSong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTNamePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNamePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1))
                .addGap(18, 18, 18)
                .addComponent(label2)
                .addGap(18, 18, 18)
                .addComponent(jLSong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        User user = controlerUser.searchByNickname(Session.getNickname());
        String id = UUID.randomUUID().toString();
        Playlist playlist = new Playlist(id, jTNamePlaylist.getText(), user);
        controlerPlaylist.inserPlaylist(playlist);
        Song song = controlerSong.searchSong(null, selectedSong);
        controlerPlaylistSongs.insertSongToPlaylist(id, song.getIdSong());
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "Playlist created and song added");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTNamePlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNamePlaylistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNamePlaylistActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLSong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTNamePlaylist;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    // End of variables declaration//GEN-END:variables
}
