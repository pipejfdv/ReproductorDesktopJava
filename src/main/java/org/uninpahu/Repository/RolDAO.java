package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Rol;


public class RolDAO implements RepositoryRol{

    @Override
    public Rol readRol(String nameRol) {
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Roles WHERE nameRol = ?";
        Rol rol = null;
        try(PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, nameRol);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                rol = new Rol(rs.getString("idRol"), rs.getString("nameRol"));
            }
            else{
                System.out.println("role not found");
            }
        }
        catch(SQLException e){
            System.out.println("Error in the role query: "+ e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return rol;
    }
    
}
