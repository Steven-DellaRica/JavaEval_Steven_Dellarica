package fr.epsi.bo;

import jakarta.persistence.*;

import java.util.Set;

// Définition de l'entité
@Entity
// Redéfinition du nom de la Table dans la BDD
@Table(name = "product")
public class Product {
    // @Id défini la clé primaire de notre table, @GeneratedValue(...) met en place l'auto increment de notre ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Redéfinition du nom de la Colonne dans la BDD
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "TYPE")
    private ProdType type;
    @Column(name = "PRICE")
    private double price;

    // Définition de la relation ManyToMany avec la classe PetStore, Product est la classe esclave
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    // Constructeur sans argument pour définir le POJO
    public Product() {
    }

    // Constructeur avec arguments pour créer un objet plus facilement
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }
}
