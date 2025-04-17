package org.uninpahu.Controlers;

import org.uninpahu.Modelo.Rol;
import org.uninpahu.Services.ServicesRol;
import org.uninpahu.Repository.RepositoryRol;
import org.uninpahu.Repository.RolDAO;


public class ControlerRol {
    private ServicesRol servicesRol;
    
    public ControlerRol(){
        RepositoryRol repositoryRol = new RolDAO();
        this.servicesRol = new ServicesRol(repositoryRol);
    }
     
    public Rol readRol(String nameRol){
        return servicesRol.readRolName(nameRol);
    }
}
