package com.mascotas.back.repository;

import com.mascotas.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    void deleteById(Long id);

    /*
    @Query("SELECT u FROM User u")
    List<User> buscarUser();

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> BuscarUserPorId(@Param("id")Long id);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> buscarUserPorNombre(@Param("name") String nombre);

    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    void modificarNombre(@Param("name") String name, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    void modificarEmail(@Param("email") String email, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.id = :id")
    void modificarPassword(@Param("password") String password, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.phone = :phone WHERE u.id = :id")
    void modificarPhone(@Param("phone") String phone, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.rol = :role WHERE u.id = :id")
    void modificarRole(@Param("role") String role, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.pets = :pets WHERE u.id = :id")
    void modificarPets(@Param("pets") String pets, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.name = :name , u.email = :email,"
            + " u.password = :password, u.phone = :phone,"
            + " u.rol = :role , u.pets = :pets"
            + " WHERE u.id = :id")
    void modificarUser(@Param("nombre") String nombre,
                          @Param("email") String email,
                          @Param("password") String password,
                          @Param("phone") String phone,
                          @Param("role") String role,
                          @Param("pets") String pets,
                          @Param("id") Long id);
    */
}
