package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.uninpahu.DB.DataBase;


public class PlaylistSongsDAO implements RepositoryPlaylistSongs{

    @Override
    public void addSongToPlaylist(String idPlaylist, String idSong) {
        Connection conex = DataBase.getConnection();
        String sql = "INSERT INTO PlaylistSongs (idPlaylist, idSong) VALUES (?, ?)";
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            stm.setString(1, idPlaylist);
            stm.setString(2, idSong);
            stm.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "could not add the song to the playlist");
            System.err.println(e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
    }
}
