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
import org.uninpahu.Controlers.ControlerAlbum;
import org.uninpahu.Controlers.ControlerGender;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Song;

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
                Duration duration = convertSqlTimeToDuration(rs.getTime("durationSong"));
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

    // Método para convertir java.sql.Time a Duration
    private Duration convertSqlTimeToDuration(Time time) {
        if (time == null) {
            return Duration.ZERO;
        }

        // Convertir el Time a LocalTime
        LocalTime localTime = time.toLocalTime();

        // Crear Duration a partir de las horas, minutos y segundos
        return Duration.ofHours(localTime.getHour())
                .plusMinutes(localTime.getMinute())
                .plusSeconds(localTime.getSecond());
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
                Duration duration = convertSqlTimeToDuration(rs.getTime("durationSong"));
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
        return song;
    }
}
