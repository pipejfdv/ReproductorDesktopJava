
package org.uninpahu.Vistas.JFrames;

import java.awt.HeadlessException;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import org.uninpahu.Controlers.ControlerPlaylist;
import org.uninpahu.Controlers.ControlerPlaylistSongs;
import org.uninpahu.Controlers.ControlerSong;
import org.uninpahu.Modelo.Playlist;
import org.uninpahu.Modelo.Song;

public class JFAddSongPlaylist extends javax.swing.JFrame {
    
    ControlerPlaylist controlerPlaylist = new ControlerPlaylist();
    ControlerPlaylistSongs controlerPlaylistSongs = new ControlerPlaylistSongs();
    ControlerSong controlerSong = new ControlerSong();
    
    String selectedSong = null;
    
    public JFAddSongPlaylist() {
        this.setUndecorated(true);
        initComponents();
        addPlaylistBox();
    }
    
    public void songAddPlaylistSelected (String song){
        this.selectedSong = song;
    }
    
    public void addPlaylistBox(){
        Optional<List<Playlist>> listPlaylists = controlerPlaylist.listsOfPlaylist();
        BoxPlaylist.removeAllItems();
        listPlaylists.ifPresent(listPlaylistOptional -> {
            for(Playlist p : listPlaylistOptional){
                BoxPlaylist.addItem(p.getNamePlaylist());
            }
            
        });
    }
    
    private void addSongToPlaylist(String namePlaylist){
        try{
            Playlist playlist = controlerPlaylist.searchPlaylist(null, namePlaylist);
            Song songAdd = controlerSong.searchSong(null, selectedSong);
            controlerPlaylistSongs.insertSongToPlaylist(playlist.getIdPlaylist(), songAdd.getIdSong());
            JOptionPane.showMessageDialog(null, "The song was added to your playlist "+ namePlaylist);
        }
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "could not add the song, try again ");
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BoxPlaylist = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Add song to playlist");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("choose the playlist");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BoxPlaylist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(BoxPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(BoxPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tituloPlaylist = (String) BoxPlaylist.getSelectedItem();
        if(tituloPlaylist == null){
            tituloPlaylist = BoxPlaylist.getItemAt(0);
        }
        addSongToPlaylist(tituloPlaylist);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxPlaylist;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
