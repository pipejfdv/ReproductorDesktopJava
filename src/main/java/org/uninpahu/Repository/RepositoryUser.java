
package org.uninpahu.Repository;

import org.uninpahu.Modelo.User;

public interface RepositoryUser {
    //add user
    void insertUser(User user);
    //seach by nickname
    User searhByNickname(String nickname);
    //update user
    void updateUser(String nickname, String password, String idUser);
    //delete User
    void removeUser(String IdUser);
}
