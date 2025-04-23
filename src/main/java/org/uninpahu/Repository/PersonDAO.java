
package org.uninpahu.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.uninpahu.DB.DataBase;
import org.uninpahu.Modelo.Person;


public class PersonDAO implements RepositoryPerson{

    @Override
    public void insertPerson(Person person) {
        Connection conex = DataBase.getConnection();
        String sql = "INSERT INTO Persons (idPerson, names, lastnames, email) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conex.prepareStatement(sql)){
            stmt.setString(1, person.getIdPerson());
            stmt.setString(2, person.getNames());
            stmt.setString(3, person.getLastnames());
            stmt.setString(4, person.getEmail());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Failed insertion Person:"+ e.getMessage());
        } finally {
            DataBase.closeConnection(conex);
        }
    }
    
    @Override
    public Person searchByEmail(String email){
        Connection conex = DataBase.getConnection();
        String sql = "SELECT * FROM Persons WHERE email = ?";
        Person person = null;
        
        try(PreparedStatement stmEmail = conex.prepareStatement(sql)){
            stmEmail.setString(1, email);
            ResultSet rs = stmEmail.executeQuery();
            if(rs.next()){
                person = new Person(
                        rs.getString("idPerson"),
                        rs.getString("names"),
                        rs.getString("lastnames"),
                        rs.getString("email"));
            }
            else{
                System.out.println("the mail not exists");
            }
        }
        catch(SQLException e){
            System.out.println("Error in the email query: "+e.getMessage());
        }
        finally{
            DataBase.closeConnection(conex);
        }
        return person;
    }

    @Override
    public void updatePerson(String names, String lastnames, String email, String idPerson) {
        Connection conex = DataBase.getConnection();
        String sql = "UPDATE Persons SET names = ?, lastnames = ?, email = ? WHERE idPerson = ?";
        try(PreparedStatement stm = conex.prepareStatement(sql)){
            stm.setString(1, names);
            stm.setString(2, lastnames);
            stm.setString(3, email);
            stm.setString(4, idPerson);
            stm.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("update Person: "+e.getMessage());
        }
    }

    @Override
    public void removePerson(String idPerson) {
        Connection conex = DataBase.getConnection();
        String sql = "DELETE FROM Persons WHERE idPerson = ?";
        try(PreparedStatement stm = conex.prepareCall(sql)){
            stm.setString(1, idPerson);
            stm.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("Delete Person: "+e.getMessage());
        }
    }
    
}
