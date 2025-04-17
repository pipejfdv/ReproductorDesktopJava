
package org.uninpahu.Services;

import org.uninpahu.Modelo.Person;
import org.uninpahu.Modelo.User;
import org.uninpahu.Repository.RepositoryUser;
import org.uninpahu.Repository.RepositoryPerson;


public class ServicesUser {
    private final RepositoryUser repositoryUser;
        
    public ServicesUser(RepositoryUser interfaceUser){
        this.repositoryUser = interfaceUser;
    }
    
    public void insertUser(User user){
        repositoryUser.insertUser(user);
    }
    
    public User searhByNickname(String nickname){
        return repositoryUser.searhByNickname(nickname);
    }
}
