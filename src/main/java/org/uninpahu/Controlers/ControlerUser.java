
package org.uninpahu.Controlers;

import org.uninpahu.Modelo.User;
import org.uninpahu.Repository.RepositoryUser;
import org.uninpahu.Repository.UserDAO;
import org.uninpahu.Services.ServicesUser;


public class ControlerUser {
    private ServicesUser servicesUser;
    
    public ControlerUser(){
        RepositoryUser repositoryUser = new UserDAO();
        this.servicesUser = new ServicesUser(repositoryUser);
    }
    
    public void insertUser(User user){
        servicesUser.insertUser(user);
    }
    
    public User searchByNickname(String nickname){
        return servicesUser.searhByNickname(nickname);
    }
}
