
package org.uninpahu.Vistas.JFrames;

import java.awt.BorderLayout;
import org.uninpahu.Vistas.JPanels.JPPlaylist;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import org.uninpahu.ConfigPlayer.Reproductor;
import org.uninpahu.Vistas.JPanels.JPAlbums;
import org.uninpahu.Vistas.JPanels.JPSettings;

public class JFHome extends javax.swing.JFrame {
    
    Reproductor reproductor = new Reproductor();
    
    public JFHome() {
        this.setUndecorated(true);
        initComponents();
        new JFXPanel();
        JPPlaylist playlistPanel = new JPPlaylist();
        playlistPanel.setSize(500, 411);
        playlistPanel.setLocation(0, 0);
        
        jPanelContentHome.removeAll();
        jPanelContentHome.add(playlistPanel, BorderLayout.CENTER);
        jPanelContentHome.revalidate();
        jPanelContentHome.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Playlist = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelContentHome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/pipejfdv/Desktop/programs/SpotifyDesktop/src/main/java/org/uninpahu/Vistas/Images/user.png")); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Albums");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Playlist.setBackground(new java.awt.Color(0, 102, 0));
        Playlist.setForeground(new java.awt.Color(255, 255, 255));
        Playlist.setText("Playlists");
        Playlist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Playlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaylistActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Favorite Songs");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Exit");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Settings");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 0));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Create song");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Playlist, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(85, 85, 85)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(Playlist)
                    .addContainerGap(280, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanelContentHomeLayout = new javax.swing.GroupLayout(jPanelContentHome);
        jPanelContentHome.setLayout(jPanelContentHomeLayout);
        jPanelContentHomeLayout.setHorizontalGroup(
            jPanelContentHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanelContentHomeLayout.setVerticalGroup(
            jPanelContentHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanelContentHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelContentHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reproductor.stopExit();
        JFIndex index = new JFIndex();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
        index.setResizable(false);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JPSettings settingsPanel = new JPSettings();
        settingsPanel.setSize(500, 411);
        settingsPanel.setLocation(0,0);
        
        jPanelContentHome.removeAll();
        jPanelContentHome.add(settingsPanel, BorderLayout.CENTER);
        jPanelContentHome.revalidate();
        jPanelContentHome.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JPAlbums albumPanel = new JPAlbums();
        albumPanel.setSize(500, 411);
        albumPanel.setLocation(0, 0);
        
        jPanelContentHome.removeAll();
        jPanelContentHome.add(albumPanel, BorderLayout.CENTER);
        jPanelContentHome.revalidate();
        jPanelContentHome.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaylistActionPerformed
        JPPlaylist playlistPanel = new JPPlaylist();
        playlistPanel.setSize(500, 411);
        playlistPanel.setLocation(0, 0);
        
        jPanelContentHome.removeAll();
        jPanelContentHome.add(playlistPanel, BorderLayout.CENTER);
        jPanelContentHome.revalidate();
        jPanelContentHome.repaint();
    }//GEN-LAST:event_PlaylistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Playlist;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContentHome;
    // End of variables declaration//GEN-END:variables
}
