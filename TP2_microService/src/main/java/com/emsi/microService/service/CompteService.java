package com.emsi.microService.service;

import com.emsi.microService.dto.CompteRequestDTO;
import com.emsi.microService.dto.CompteResponseDTO;
import com.emsi.microService.entities.Compte;

public interface CompteService {
     CompteResponseDTO ajouterCompte(CompteRequestDTO compteDTO);
}
