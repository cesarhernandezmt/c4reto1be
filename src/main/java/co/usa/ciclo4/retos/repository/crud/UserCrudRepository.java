/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo4.retos.repository.crud;


import co.usa.ciclo4.retos.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * Interface UserCrudRepository hereda los metodos y atributos de la clase
 * CrudRepository
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor 
     * de su atributo 'name'
     * @param name
     * @return 
     */
    public Optional<User> findByName(String name);
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor
     * de su atributo 'email'
     * @param email
     * @return 
     */
    public Optional<User> findByEmail(String email);
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor
     * de su atributo 'name' o por su atributo 'email'
     * @param name
     * @param email
     * @return 
     */
    public List<User> findByNameOrEmail(String name, String email);
    
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por los valores
     * de sus atributos 'email' y 'password'
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}
