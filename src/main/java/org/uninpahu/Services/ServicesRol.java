
package org.uninpahu.Services;

import org.uninpahu.Modelo.Rol;
import org.uninpahu.Repository.RepositoryRol;

public class ServicesRol {
    private final RepositoryRol rolRepository;
    
    public ServicesRol(RepositoryRol repositoryRol){
        this.rolRepository = repositoryRol;
    }
    
    public Rol readRolName(String nameRol){
        return rolRepository.readRol(nameRol);
    }
}
