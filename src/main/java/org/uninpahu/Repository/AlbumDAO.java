package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.uninpahu.Controlers.ControlerGender;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Album;
import org.uninpahu.Modelo.Gender;


public class AlbumDAO implements RepositoryAlbum{

    ControlerGender controlerGender = new ControlerGender();
    
    @Override
    public Album typeAlbum(String idAlbum, String nameAlbum) {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Albums WHERE 1=1";
        Album album = null;
        if(idAlbum != null) sql += " AND idAlbum = ?";
        if(nameAlbum != null) sql += " AND nameAlbum = ?";
        
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            int index = 1;
            if(idAlbum != null) stm.setString(index++, idAlbum);
            if(nameAlbum != null) stm.setString(index++, nameAlbum);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                Date creationAlbum = rs.getDate("creationAlbum");
                return album = new Album(
                        rs.getString("idAlbum"),
                        rs.getString("nameAlbum"),
                        creationAlbum.toLocalDate(),
                        controlerGender.searchGender(rs.getString("idGenderAlbum"), null));
            }
        }
        catch(SQLException e){
            System.out.println("Error when searching for Album "+ e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return album;
    }

    @Override
    public List<Album> albumsList() {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Albums";
        List<Album> listAlbum = new ArrayList<>();
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Date creationDateDb = rs.getDate("creationAlbum");
                LocalDate creationDate = creationDateDb != null ? creationDateDb.toLocalDate():null;
                listAlbum.add(
                        new Album(
                                rs.getString("idAlbum"), 
                                rs.getString("nameAlbum"), 
                                creationDate, 
                                controlerGender.searchGender(rs.getString("idGenderAlbum"), null))
                                );
            }
        }
        catch(SQLException e){
            System.err.println("Albums not loaded"+ e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return listAlbum;
    }

    @Override
    public void createAlbum(Album album) {
        Connection conex = DataBase.getConnection();
        String sql = "INSERT INTO Albums (idAlbum, nameAlbum, creationAlbum, idGenderAlbum) VALUES (?,?,?,?)";
        
        try(PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, album.getIdAlbum());
            smt.setString(2, album.getNameAlbum());
            Date creationAlbum = Date.valueOf(album.getCreateAlbum());
            smt.setDate(3, creationAlbum);
            smt.setString(4, album.getIdGender().getIdGender());
            smt.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("Error to create Album "+e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
    }
    
    
}
