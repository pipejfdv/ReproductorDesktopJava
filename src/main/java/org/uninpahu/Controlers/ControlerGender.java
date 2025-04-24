
package org.uninpahu.Controlers;

import java.util.List;
import org.uninpahu.Modelo.Gender;
import org.uninpahu.Repository.GenderDAO;
import org.uninpahu.Repository.RepositoryGender;
import org.uninpahu.Services.ServicesGender;


public class ControlerGender {
    private ServicesGender servicesGender;
    
    public ControlerGender(){
        RepositoryGender repositoryGender = new GenderDAO();
        this.servicesGender = new ServicesGender(repositoryGender);
    }
    
    public Gender searchGender(String idGender, String nameGender){
        return servicesGender.searchGender(idGender, nameGender);
    }
    
    public List<Gender> listGender (){
        return servicesGender.listGender();
    }
}
