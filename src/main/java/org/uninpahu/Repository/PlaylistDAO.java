package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import org.uninpahu.Controlers.ControlerUser;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Playlist;
import org.uninpahu.Modelo.User;
import org.uninpahu.Services.Session;

public class PlaylistDAO implements RepositoryPlaylist {

    ControlerUser controlerUser = new ControlerUser();

    @Override
    public void createPlaylist(Playlist playlist) {
        Connection conex = DataBase.getConnection();
        String sqlSearchPlaylist = "SELECT * FROM Playlists WHERE namePlaylist = ?";
        try (PreparedStatement stmSearch = conex.prepareStatement(sqlSearchPlaylist)) {
            stmSearch.setString(1, playlist.getNamePlaylist());
            ResultSet rs = stmSearch.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Change the name already exists");
                conex.rollback();
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error: query not complete for playlist " + e.getMessage());
            return;
        }

        String sqlInsertPlaylist = "INSERT INTO Playlists (idPlaylist, namePlaylist, idUserPlaylist) VALUES (?, ?, ?)";
        try (PreparedStatement stmInsert = conex.prepareStatement(sqlInsertPlaylist)) {
            stmInsert.setString(1, playlist.getIdPlaylist());
            stmInsert.setString(2, playlist.getNamePlaylist());
            stmInsert.setString(3, playlist.getIdUser().getIdUser());
            stmInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertion: " + e.getMessage());
            return;
        } finally {
            DataBase.closeConnection(conex);
        }
    }

    @Override
    public Optional<List<Playlist>> listOfPlaylist() {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Playlists";
        List<Playlist> list = new ArrayList<>();
        try (PreparedStatement stm = conex.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                User idUser = controlerUser.searchByNickname(Session.getNickname());
                Playlist playlist = new Playlist(
                        rs.getString("idPlaylist"),
                        rs.getString("namePlaylist"),
                        idUser);
                list.add(playlist);
            }
            return list.isEmpty() ? Optional.empty() : Optional.of(list);
        } catch (SQLException e) {
            System.out.println("Failure to search for playlist "+ e.getSQLState());
            System.err.println(e.getMessage());
            return Optional.empty();
        } finally {
            DataBase.closeConnection(conex);
        }
    }

    @Override
    public Playlist searchPlaylist(String idPlaylist, String namePlaylist) {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Playlists WHERE 1=1";
        Playlist playlist = null;
        if(idPlaylist != null) sql += " AND idPlaylist = ?";
        if(namePlaylist != null) sql += " AND namePlaylist = ?";
        
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            int index = 1;
            if(idPlaylist != null) stm.setString(index++, idPlaylist);
            if(namePlaylist != null) stm.setString(index++, namePlaylist);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                User idUser = controlerUser.searchByNickname(Session.getNickname());
                playlist = new Playlist(rs.getString("idPlaylist"), rs.getString("namePlaylist"), idUser);
            }
        }
        catch(SQLException e){
            System.err.println("Error search playlist "+e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return playlist;
    }

}
