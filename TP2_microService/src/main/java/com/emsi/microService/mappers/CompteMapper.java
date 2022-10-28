package com.emsi.microService.mappers;

import com.emsi.microService.dto.CompteResponseDTO;
import com.emsi.microService.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteResponseDTO deCompte(Compte compte){
        CompteResponseDTO compteResponseDTO=new CompteResponseDTO();
        BeanUtils.copyProperties(compte,compteResponseDTO);
        return compteResponseDTO;
    }
}
