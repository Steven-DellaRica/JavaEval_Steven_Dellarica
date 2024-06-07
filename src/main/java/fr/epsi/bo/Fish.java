package fr.epsi.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Définition de l'entité
@Entity
// Redéfinition du nom de la Table dans la BDD
@Table(name = "fish")
// Fish hérite de la classe Animal
public class Fish extends Animal {
    // Pas besoin de définir un ID étant donné que l'objet crée sera relié à l'objet de la classe dont elle hérite : Animal
    // Redéfinition du nom de la Colonne dans la BDD
    @Column(name = "LIVING_ENV")
    private FishLivEnv livingEnv;

    // Constructeur sans argument pour définir le POJO
    public Fish() {
    }

    // Constructeur avec arguments pour créer un objet plus facilement
    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    // Getters & Setters
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
