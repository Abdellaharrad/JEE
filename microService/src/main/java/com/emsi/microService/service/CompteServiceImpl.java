package com.emsi.microService.service;

import com.emsi.microService.dto.CompteRequestDTO;
import com.emsi.microService.dto.CompteResponseDTO;
import com.emsi.microService.entities.Compte;
import com.emsi.microService.enums.AccountType;
import com.emsi.microService.mappers.CompteMapper;
import com.emsi.microService.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepo;
    private CompteMapper compteMapp;

    @Override
    public CompteResponseDTO ajouterCompte(CompteRequestDTO compteDTO) {
        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .type(compteDTO.getType())
                .currency(compteDTO.getCurrency())
                .solde(compteDTO.getSolde())
                .dateCreation(new Date())
                .build();
        Compte compteSaved = compteRepo.save(compte);
        CompteResponseDTO compteResponseDTO = compteMapp.deCompte(compteSaved);
        return compteResponseDTO;
    }
}
