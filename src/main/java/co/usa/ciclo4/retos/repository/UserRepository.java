/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.repository;


import co.usa.ciclo4.retos.model.User;
import co.usa.ciclo4.retos.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * Clase Repositorio 'UserRepository'
 */
@Repository
public class UserRepository {
    
    /**
     * Atributo objeto 'userCrudRepository' instancia de la interface
     * 'UserCrudRepository'
     */
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    /**
     * Metodo para obtener y retornar una lista de todos los registros 
     * de cuentas de usuario hacia el metodo 'findAll' del CrudRepository
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    
    /**
     * Metodo para guardar y retornar una registro de cuenta de usuario
     * hacia el metodo 'save' del CrudRepository
     * @param user
     * @return 
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'id', hacia el metodo 'findById' del CrudRepository
     * @param id
     * @return 
     */
    public Optional<User> getUserById(int id) {
        return userCrudRepository.findById(id);
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'name', hacia el metodo 'findByName' del CrudRepository
     * @param name
     * @return 
     */
    public Optional<User> getUserByName(String name) {
        return userCrudRepository.findByName(name);
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'email', hacia el metodo 'findByEmail' del 
     * CrudRepository
     * @param email
     * @return 
     */
    public Optional<User> getUserByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'name'o de su atributo 'email', hacia el metodo 
     * 'findByNameOrEmail' del CrudRepository
     * @param name
     * @param email
     * @return 
     */
    public List<User> getUsersByNameOrEmail(String name, String email) {
        return userCrudRepository.findByNameOrEmail(name, email);
    }
    
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de sus atributos 'email' y 'password', hacia el metodo 
     * 'findByEmailAnd Password' del CrudRepository
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> getUserEmailAndPassword(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
 
}
