package com.app.rdv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Integer id;
    private String nom;
    private String prenom;
    private Integer age;
    private Integer tel;
    private List<String> maladies;
}