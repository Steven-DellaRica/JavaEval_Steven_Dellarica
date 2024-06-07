package fr.epsi.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// Définition de l'entité
@Entity
// Redéfinition du nom de la Table dans la BDD
@Table(name = "petstore")
public class PetStore {
    // @Id défini la clé primaire de notre table, @GeneratedValue(...) met en place l'auto increment de notre ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Redéfinition du nom de la Colonne dans la BDD
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGER_NAME")
    private String managerName;

    // Définition de la relation ManyToMany avec la classe Product, PetStore est la classe maître
    @ManyToMany
    @JoinTable(name = "PET_PRO",
            joinColumns = @JoinColumn(name = "ID_PET", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRO", referencedColumnName = "ID")
    )
    private Set<Product> products;

    // Définition de la relation OneToMany avec la classe Animal
    @OneToMany(mappedBy = "petstore")
    private Set<Animal> animals = new HashSet<Animal>();

    // Constructeur sans argument pour définir le POJO
    public PetStore() {
    }

    // Constructeur avec arguments pour créer un objet plus facilement
    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
