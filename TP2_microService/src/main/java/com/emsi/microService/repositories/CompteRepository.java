package com.emsi.microService.repositories;

import com.emsi.microService.entities.Compte;
import com.emsi.microService.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,String> {
    @RestResource(path= "/byType")
    List<Compte> findByType(@Param("t") AccountType type);
}
