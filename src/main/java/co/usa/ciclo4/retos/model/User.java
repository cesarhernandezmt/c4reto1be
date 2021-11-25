/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo4.retos.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Clase Modelo Entidad User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    
    /**
     * Atributo 'id' de la Entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Atributo 'email' de la Entidad
     */
    @Column(name = "user_email", length = 50, nullable = false, unique = true)
    private String email;
    
    /**
     * Atributo 'password' de la Entidad
     */
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    
    /**
     * Atributo 'name' de la Entidad
     */
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;


}
