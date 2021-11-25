/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.service;


import co.usa.ciclo4.retos.model.User;
import co.usa.ciclo4.retos.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * Clase Servicio 'UserService'
 */
@Service
public class UserService {
    
    /**
     * Atributo objeto 'userCrudRepository' instancia de la clase
     * 'UserRepository'
     */
    @Autowired
    private UserRepository userRepository;
    
    /**
     * Metodo para obtener y retornar una lista de todos los registros 
     * de cuentas de usuario hacia el metodo 'getAll' del UserRepository
     * @return 
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    /**
     * Metodo para guardar y retornar una registro de cuenta de usuario
     * hacia el metodo 'save' del UserRepository
     * @param user
     * @return 
     */
    public User save(User user) {
        if(user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return user;
        }
        else {
            List<User> existUserByNameOrEmail = userRepository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            
            if(existUserByNameOrEmail.isEmpty()) {
                if(user.getId() == null) {
                    return userRepository.save(user);
                }
                else {
                    Optional<User> existUserById = userRepository.getUserById(user.getId());
                    if(existUserById.isEmpty()) {
                        return userRepository.save(user);
                    }
                    else {
                        return user;
                    }
                }
            }
            else {
                return user;
            }
        }
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'email', hacia el metodo 'findByEmail' del 
     * UserRepository
     * @param email
     * @return 
     */
    public boolean getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).isPresent();
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de sus atributos 'email' y 'password', hacia el metodo 
     * 'findByEmailAndPassword' del UserRepository
     * @param email
     * @param password
     * @return 
     */
    public User getUserEmailAndPassword(String email, String password) {
        String name = "NO DEFINIDO";
        Optional<User> userExist = userRepository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()) {
            return userExist.get();
        }
        else {
            return new User(null, email, password, name);
        }
    }
    
    /*
    public Optional<User> getUserById(int id) {
        return userRepository.getUserById(id);
    }
    */
}
