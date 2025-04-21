
package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Playlist;


public class PlaylistDAO implements RepositoryPlaylist{

    @Override
    public void createPlaylist(Playlist playlist) {
        Connection conex = DataBase.getConnection();
        String sqlSearchPlaylist = "SELECT * FROM Playlists WHERE namePlaylist = ?";
        try(PreparedStatement stmSearch = conex.prepareStatement(sqlSearchPlaylist)){
            stmSearch.setString(1, playlist.getNamePlaylist());
            ResultSet rs = stmSearch.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Change the name already exists");
                conex.rollback();
                return;
            }
        }
        catch(SQLException e){
            System.out.println("Error: query not complete for playlist "+e.getMessage());
            return;
        }
        
        String sqlInsertPlaylist = "INSERT INTO Playlists (idPlaylist, namePlaylist, idUserPlaylist) VALUES (?, ?, ?)";
        try(PreparedStatement stmInsert = conex.prepareStatement(sqlInsertPlaylist)){
            stmInsert.setString(1, playlist.getIdPlaylist());
            stmInsert.setString(2, playlist.getNamePlaylist());
            stmInsert.setString(3, playlist.getIdUser().getIdUser());
            stmInsert.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Error insertion: "+e.getMessage());
            return;
        }
        finally{
            DataBase.closeConnection(conex);
        }
    }
    
}
