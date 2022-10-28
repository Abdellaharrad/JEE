package com.emsi.microService.entities;

import com.emsi.microService.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data @Entity @NoArgsConstructor @AllArgsConstructor @Builder
public class Compte {
    @Id
    private String id;
    private Double solde;
    private Date dateCreation;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
