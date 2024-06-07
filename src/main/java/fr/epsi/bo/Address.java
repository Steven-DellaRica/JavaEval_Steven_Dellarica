package fr.epsi.bo;

import jakarta.persistence.*;

// Définition de l'entité
@Entity
// Redéfinition du nom de la Table dans la BDD
@Table(name = "address")
public class Address {
    // @Id défini la clé primaire de notre table, @GeneratedValue(...) met en place l'auto increment de notre ID dans la BDD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Redéfinition du nom de la Colonne dans la BDD
    @Column(name = "ID")
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;

    // Définition de la relation OneToOne avec la classe PetStore
    @OneToOne
    private PetStore petStore;

    // Constructeur sans argument pour définir le POJO
    public Address() {
    }

    // Constructeur avec arguments pour créer un objet plus facilement
    public Address(String number, String street, String zipCode, String city, PetStore petStore) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void petStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
