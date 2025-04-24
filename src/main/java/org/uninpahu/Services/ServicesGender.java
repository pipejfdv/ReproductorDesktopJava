
package org.uninpahu.Services;

import java.util.List;
import org.uninpahu.Modelo.Gender;
import org.uninpahu.Repository.RepositoryGender;


public class ServicesGender {
    private final RepositoryGender repositoryGender;
    
    public ServicesGender(RepositoryGender repositoryGender){
        this.repositoryGender = repositoryGender;
    }
    
    public Gender searchGender(String idGender, String nameGender){
        return repositoryGender.typeGender(idGender, nameGender);
    }
    
    public List<Gender> listGender(){
        return repositoryGender.listGenders();
    }
}
