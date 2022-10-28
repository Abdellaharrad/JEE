package com.emsi.microService.entities;

import com.emsi.microService.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class, name="proj")
public interface CompteProjection {
    public String getId();
    public AccountType getType();
}
