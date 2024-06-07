package fr.epsi.bo;

import jakarta.persistence.*;

import java.time.LocalDate;

// Définition de l'entité
@Entity
// Mise en place de l'héritage de type Joined (Précision du pourquoi dans le readMe)
@Inheritance(strategy = InheritanceType.JOINED)
// Redéfinition du nom de la Table dans la BDD
@Table(name = "animal")
public class Animal {
    // @Id défini la clé primaire de notre table, @GeneratedValue(...) met en place l'auto increment de notre ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Redéfinition du nom de la Colonne dans la BDD
    @Column(name = "ID")
    private Long id;
    @Column(name = "BIRTH")
    private LocalDate birth;
    @Column(name = "COLOR")
    private String color;

    // Définition de la relation ManyToOne avec la classe PetStore
    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private PetStore petstore;

    // Constructeur sans argument pour définir le POJO
    public Animal() {
    }

    // Constructeur avec arguments pour créer un objet plus facilement
    public Animal(LocalDate birth, String color, PetStore petstore) {
        this.birth = birth;
        this.color = color;
        this.petstore = petstore;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetstore() {
        return petstore;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }
}
