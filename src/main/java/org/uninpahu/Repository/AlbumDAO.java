package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uninpahu.Controlers.ControlerGender;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Album;


public class AlbumDAO implements RepositoryAlbum{

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
            
            ControlerGender controlerGender = new ControlerGender();
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
    
}
