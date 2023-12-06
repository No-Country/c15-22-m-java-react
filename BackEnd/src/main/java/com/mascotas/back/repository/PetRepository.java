package com.mascotas.back.repository;

import com.mascotas.back.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends  JpaRepository <Pet, Long>{
    Page<Pet> findAll(Pageable paginacion);

    /*
    @Query("SELECT p FROM Pet p")
    List<Pet> listaPets();
    
    @Query("SELECT p FROM Pet p WHERE p.state = 'ADOPTED' OR p.state = 'FOUND'")
    Optional<Pet> buscarMascotasConFinalFeliz();
    
    @Query("SELECT p FROM Pet p WHERE p.state = 'LOST'")
    Optional<Pet> buscarMascotasPerdidas();

       
    @Query("SELECT p FROM Pet WHERE p.state = ADOPTION")

    
    @Query("SELECT p FROM Pet p WHERE p.state = 'ADOPTION'")
    Optional<Pet> buscarMascotasEnAdopcion();
    
    @Modifying
    @Query("UPDATE Pet p SET p.name = :name WHERE p.id = :id")
    void modificarMascotaNombre(@Param("name")String name, @Param("id")Long id);
    
    @Modifying
    @Query("UPDATE Pet p SET p.description = :description WHERE p.id = :id")
    void modificarMascotaDescription(@Param("description")String description, @Param("id")Long id);
    
    @Modifying
    @Query("UPDATE Pet p SET p.type = :type WHERE p.id = :id")
    void modificarMascotaType(@Param("type")String type, @Param("id")Long id);
    
    @Modifying
    @Query("UPDATE Pet p SET p.race = :race WHERE p.id = :id")
    void modificarMascotaRace(@Param("race")String race, @Param("id")Long id);
    
    @Modifying
    @Query("UPDATE Pet p SET p.age = :age WHERE p.id = :id")
    void modificarMascotaAge(@Param("age")String age, @Param("id")Long id);
    
    @Modifying
    @Query("UPDATE Pet p SET p.state = :state WHERE p.id = :id")
    void modificarMascotaState(@Param("state") String state, @Param("id")Long id);
    
    @Modifying
    @Query("UPDATE Pet p SET p.name = :name , p.description = :description"
            + ", p.type = :type , p.race = :race "
            + ", p.age = :age , p.state = :state "
            + ", p.state = :state WHERE p.id = :id"
    )
    void modificarPet(@Param("name") String name,
            @Param("description") String description,
            @Param("type") String type,
            @Param("race") String race,
            @Param("age") String age,
            @Param("state") String state,
            @Param("id")Long id);
    */
    
}
