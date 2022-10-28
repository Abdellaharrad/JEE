package com.emsi.microService.web;

import com.emsi.microService.dto.CompteRequestDTO;
import com.emsi.microService.dto.CompteResponseDTO;
import com.emsi.microService.entities.Compte;
import com.emsi.microService.mappers.CompteMapper;
import com.emsi.microService.repositories.CompteRepository;
import com.emsi.microService.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {
    private CompteRepository compteRepo;
    private CompteService compteServ;
    private CompteMapper compteMapp;

    public CompteRestController(CompteRepository compteRepo, CompteService compteServ, CompteMapper compteMapp) {
        this.compteRepo = compteRepo;
        this.compteServ = compteServ;
        this.compteMapp = compteMapp;
    }
    @GetMapping("/Comptes")
    public List<Compte> comptesList(){
        return compteRepo.findAll();
    }
    @GetMapping("/Comptes/{id}")
    public Compte compte(@PathVariable String id){
        return compteRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("Compte %s inexistant",id)));
    }
    @PostMapping ("/Comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO cpt){
        return compteServ.ajouterCompte(cpt);
    }
    @PutMapping ("/Comptes/{id}")
    public Compte save(@PathVariable String id,@RequestBody Compte cpt){
        Compte compte = compteRepo.findById(id).orElseThrow();
        if (cpt.getCurrency()!=null) compte.setCurrency(cpt.getCurrency());
        if (cpt.getSolde()!=null) compte.setSolde(cpt.getSolde());
        if (cpt.getSolde()!=null) compte.setType(cpt.getType());
        if (cpt.getDateCreation()!=null) compte.setDateCreation(new Date());
        return compteRepo.save(compte);
    }
    @DeleteMapping ("/Comptes/{id}")
    public void delete(@PathVariable String id){
        compteRepo.deleteById(id) ;
    }
}
