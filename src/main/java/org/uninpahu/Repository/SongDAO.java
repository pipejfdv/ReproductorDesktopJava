package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.swing.JOptionPane;
import org.uninpahu.Controlers.ControlerAlbum;
import org.uninpahu.Controlers.ControlerGender;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Modelo.Gender;
import org.uninpahu.Modelo.Song;
import org.uninpahu.Services.DurationToTime;
import org.uninpahu.Services.TimeToDuration;

public class SongDAO implements RepositorySong {

    ControlerGender controlerGender = new ControlerGender();
    ControlerAlbum controlerAlbum = new ControlerAlbum();
    
    @Override
    public Optional<List<Song>> listSongs() {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Songs";
        List<Song> songlist = new ArrayList<>();
        try (PreparedStatement stmSongs = conex.prepareStatement(sql)) {
            ResultSet rs = stmSongs.executeQuery();

            //iterar varios datos
            while (rs.next()) {
                Date creationDateDb = rs.getDate("creationSong");
                LocalDate creationDate = creationDateDb != null ? creationDateDb.toLocalDate() : null;
                Duration duration = TimeToDuration.convertSqlTimeToDuration(rs.getTime("durationSong"));
                Song song = new Song(rs.getString("idSong"),
                        rs.getString("nameSong"),
                        creationDate,
                        duration,
                        controlerGender.searchGender(rs.getString("idGender"), null),
                        controlerAlbum.searchAlbum(rs.getString("idAlbum"), null),
                        rs.getString("pathFile"));
                songlist.add(song);
            }
            return songlist.isEmpty() ? Optional.empty() : Optional.of(songlist);
        } catch (SQLException e) {
            System.out.println("Failed songs | return null");
            return Optional.empty();
        } finally {
            DataBase.closeConnection(conex);
        }
    }


    @Override
    public Song searchSong(String idSong, String nameSong) {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Songs WHERE 1=1";
        Song song = null;
        if(idSong != null) sql += " AND idSong = ?";
        if(nameSong != null) sql += " AND nameSong = ?";
        
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            int index = 1;
            if(idSong != null) stm.setString(index++, idSong);
            if(nameSong != null) stm.setString(index++, nameSong);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Date creationDateDb = rs.getDate("creationSong");
                LocalDate creationDate = creationDateDb != null ? creationDateDb.toLocalDate() : null;
                Duration duration = TimeToDuration.convertSqlTimeToDuration(rs.getTime("durationSong"));
                song = new Song(
                        rs.getString("idSong"),
                        rs.getString("nameSong"),
                        creationDate,
                        duration,
                        controlerGender.searchGender(rs.getString("idGender"), null),
                        controlerAlbum.searchAlbum(rs.getString("idAlbum"), null),
                        rs.getString("pathFile"));
            }
        }
        catch(SQLException e){
            System.err.println("Error search song "+e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return song;
    }

    @Override
    public void createSong(Song newSong) {
        Connection conex = DataBase.getConnection();
        String sql = "INSERT INTO Songs (idSong, nameSong, creationSong, durationSong, idGender, idAlbum, pathFile) VALUES (?,?,?,?,?,?,?)";
        Song existSong = searchSong(null, newSong.getNameSong());
        if(existSong == null || !newSong.getNameSong().equals(existSong.getNameSong())){
            try(PreparedStatement stm = conex.prepareStatement(sql)){
                stm.setString(1, newSong.getIdSong());
                stm.setString(2, newSong.getNameSong());
                Date creationDateSong = Date.valueOf(newSong.getCreationSong());
                stm.setDate(3, creationDateSong);
                Time duration = DurationToTime.convertirDuration(newSong.getDuration());
                stm.setTime(4, duration);
                Gender gender = controlerGender.searchGender(null, newSong.getIdGender().getNameGender());
                stm.setString(5, gender.getIdGender());
                Album album = controlerAlbum.searchAlbum(null, newSong.getIdAlbum().getNameAlbum());
                stm.setString(6, album.getIdAlbum());
                stm.setString(7, newSong.getPathFile());
                stm.executeUpdate();
            }
            catch(SQLException e){
                System.err.println("Error to create Song "+e.getMessage());
            }
            finally{
                DataBase.closeConnection(conex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "The name of the cation already exists");
        }
        
    }
}
