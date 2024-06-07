package fr.epsi.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Définition de l'entité
@Entity
// Redéfinition du nom de la Table dans la BDD
@Table(name = "cat")
// Cat hérite de la classe Animal
public class Cat extends Animal {
    // Pas besoin de définir un ID étant donné que l'objet crée sera relié à l'objet de la classe dont elle hérite : Animal
    // Redéfinition du nom de la Colonne dans la BDD
    @Column(name = "CHIP_ID")
    private String chipId;

    // Constructeur sans argument pour définir le POJO
    public Cat() {
    }

    // Constructeur avec arguments pour créer un objet plus facilement
    public Cat(String chipId) {
        this.chipId = chipId;
    }

    // Getters & Setters
    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
