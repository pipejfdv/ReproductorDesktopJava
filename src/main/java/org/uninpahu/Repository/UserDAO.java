
package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.uninpahu.Modelo.Person;
import org.uninpahu.Modelo.Rol;


public class UserDAO implements RepositoryUser{
        
    @Override
    public void insertUser(User user) {
        Connection conex = DataBase.getConnection();
        String sqlPerson = "SELECT * FROM Persons WHERE idPerson = ?";
        try(PreparedStatement stmPerson = conex.prepareStatement(sqlPerson)){
            stmPerson.setString(1, user.getIdPerson().getIdPerson());
            ResultSet rs = stmPerson.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Error: the person does not exist");
                conex.rollback();
                return;
            }
        }catch(SQLException e){
            System.out.println("Error verification person: " + e.getMessage());
            return;
        }
        
        String sqlInsert = "INSERT INTO Users (idUser, nickname, passwordUser, idRolUser, idPersonUser) VALUES (?, ?, ?, ?, ?)";
        
        if(conex == null){
            System.out.println("Failed comunication Data base");
            return;
        }
        
        try(PreparedStatement stmtInsert = conex.prepareStatement(sqlInsert)){
            stmtInsert.setString(1, user.getIdUser());
            stmtInsert.setString(2, user.getNickname());
            stmtInsert.setString(3, user.getPassword());
            stmtInsert.setString(4, user.getRol().getIdRol());
            stmtInsert.setString(5, user.getIdPerson().getIdPerson());
            stmtInsert.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error insertion: "+ e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
    }

    @Override
    public User searhByNickname(String nickname) {
        Connection conex = DataBase.getConnection();
        String sql = "select u.idUser, u.nickname, u.passwordUser, r.idRol, r.nameRol as roleName, p.idPerson, p.names as personName, p.lastnames, p.email "
                + "from Users u inner join Roles r on u.idRolUser = r.idRol inner join Persons p on u.idPersonUser = p.idPerson where u.nickname = ?";
        User user = null;
        
        try(PreparedStatement stmNickname = conex.prepareStatement(sql)){
            stmNickname.setString(1, nickname);
            ResultSet rs = stmNickname.executeQuery();
            if(rs.next()){
                Rol rol = new Rol(rs.getString("idRol"), rs.getString("roleName"));
                Person person = new Person(rs.getString("idPerson"), rs.getString("personName"), rs.getString("lastnames"), rs.getString("email"));
                user = new User(
                        rs.getString("idUser"),
                        rs.getString("nickname"),
                        rs.getString("passwordUser"),
                        rol,
                        person
                );
            }
            else{
                System.out.println("The nickname not exists");
                return user;
            }
        }
        catch(SQLException e){
            System.out.println("Error in the email query: "+e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return user;
    }
    
    
    
}
