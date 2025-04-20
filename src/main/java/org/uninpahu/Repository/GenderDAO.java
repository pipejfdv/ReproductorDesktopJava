
package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Gender;


public class GenderDAO implements RepositoryGender{

    @Override
    public Gender typeGender(String idGender, String nameGender) {
        Connection conex = DataBase.getConnection();
        //se usa para tomar diferentes consultas 
        String sql = "SELECT * FROM Genders WHERE 1 = 1";
        Gender gender = null;
        if(idGender != null) sql += " AND idGender = ?";
        if(nameGender != null) sql += " AND nameGender = ?";
        
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            int index = 1;
            if(idGender != null) stm.setString(index++, idGender);
            if(nameGender != null) stm.setString(index++, nameGender);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return gender = new Gender(rs.getString("idGender"),
                rs.getString("nameGender"));
            }
        }
        catch(SQLException e){
            System.out.println("Error gender "+e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return gender;
    }
    
}
