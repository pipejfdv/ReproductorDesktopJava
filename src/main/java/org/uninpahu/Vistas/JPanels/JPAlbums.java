package org.uninpahu.Vistas.JPanels;

import java.util.List;
import java.util.Optional;
import javax.swing.table.DefaultTableModel;
import org.uninpahu.ConfigPlayer.Reproductor;
import org.uninpahu.Controlers.ControlerAlbum;
import org.uninpahu.Controlers.ControlerSong;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Modelo.Song;


public class JPAlbums extends javax.swing.JPanel {
    DefaultTableModel dtm = new DefaultTableModel();
    Reproductor reproductor = new Reproductor();
    ControlerAlbum controlerAlbum = new ControlerAlbum();
    ControlerSong controlerSong = new ControlerSong();
    String tituloAlbum = null;
    
    public JPAlbums() {
        initComponents();
        addAlbumsComboBox();
        String[] tittle = new String[]{"Title", "Duration", "Gender"};
        dtm.setColumnIdentifiers(tittle);
        TableAlbum.setModel(dtm);
    }
    
    public void addAlbumsComboBox(){
        List<Album> listaAlbums = controlerAlbum.listAlbums();
        for(Album album: listaAlbums){
            BoxAlbums.addItem(album.getNameAlbum());
        }
    }
    
    public void addDataTableAlbums(String tituloAlbum){
        dtm.setRowCount(0);
        Optional<List<Song>> songsList = controlerSong.listSong();
        songsList.ifPresent(songs -> {
            songs.forEach(songIterator ->{
                if(songIterator.getIdAlbum() != null && songIterator.getIdAlbum().getNameAlbum().equals(tituloAlbum)){
                    dtm.addRow(new Object[]{
                        songIterator.getNameSong(),
                        songIterator.getDuration(),
                        songIterator.getIdGender().getNameGender()
                    });
                }
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAlbum = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BoxAlbums = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jBCheckAlbum = new javax.swing.JButton();
        jBPlaySong = new javax.swing.JButton();
        jTogglePause = new javax.swing.JToggleButton();
        jBPlaySong2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 411));

        TableAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableAlbum);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Albums");

        BoxAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxAlbumsActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("select your album");

        jBCheckAlbum.setBackground(new java.awt.Color(0, 153, 0));
        jBCheckAlbum.setForeground(new java.awt.Color(255, 255, 255));
        jBCheckAlbum.setText("Check album");
        jBCheckAlbum.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBCheckAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCheckAlbumActionPerformed(evt);
            }
        });

        jBPlaySong.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/botondeplay.png")); // NOI18N
        jBPlaySong.setText("  Play");
        jBPlaySong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPlaySongActionPerformed(evt);
            }
        });

        jTogglePause.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/pause-button.png")); // NOI18N
        jTogglePause.setText("  Pause");
        jTogglePause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTogglePauseActionPerformed(evt);
            }
        });

        jBPlaySong2.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/stop-button.png")); // NOI18N
        jBPlaySong2.setText("  Stop");
        jBPlaySong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPlaySong2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(50, 50, 50)
                                .addComponent(BoxAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jBCheckAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jBPlaySong)
                .addGap(59, 59, 59)
                .addComponent(jTogglePause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBPlaySong2)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jBCheckAlbum)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPlaySong)
                    .addComponent(jTogglePause)
                    .addComponent(jBPlaySong2))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBPlaySongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPlaySongActionPerformed
        int row = TableAlbum.getSelectedRow();
        if(row >= 0){
            String selectedSong = TableAlbum.getValueAt(row, 0).toString();
            Song song = controlerSong.searchSong(null, selectedSong);
            reproductor.play(song.getPathFile());
        }
    }//GEN-LAST:event_jBPlaySongActionPerformed

    private void jTogglePauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTogglePauseActionPerformed
        if(jTogglePause.isSelected()){
            reproductor.pauseSong();
        }
        else{
            reproductor.resumeSong();
        }
    }//GEN-LAST:event_jTogglePauseActionPerformed

    private void jBPlaySong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPlaySong2ActionPerformed
        reproductor.stopSong();
    }//GEN-LAST:event_jBPlaySong2ActionPerformed

    private void jBCheckAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCheckAlbumActionPerformed
        tituloAlbum = (String) BoxAlbums.getSelectedItem();
        addDataTableAlbums(tituloAlbum);
    }//GEN-LAST:event_jBCheckAlbumActionPerformed

    private void BoxAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxAlbumsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxAlbumsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxAlbums;
    private javax.swing.JTable TableAlbum;
    private javax.swing.JButton jBCheckAlbum;
    private javax.swing.JButton jBPlaySong;
    private javax.swing.JButton jBPlaySong2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jTogglePause;
    // End of variables declaration//GEN-END:variables
}
