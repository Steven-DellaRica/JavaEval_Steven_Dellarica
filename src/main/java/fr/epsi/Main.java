package fr.epsi;

import fr.epsi.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static fr.epsi.bo.ProdType.*;

public class Main {
    public static void main(String[] args) {

        // Création et déclaration de l'entity manager et l'entity manager factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        // Démarre une transaction
        em.getTransaction().begin();

//         Création et mise en base de données d'objets dans la table PetStore
        PetStore petStore1 = new PetStore("Toutou Paradis", "Omer Dilpleu");
        PetStore petStore2 = new PetStore("Chat'ptains D'amour", "Patrick Coteuse");
        PetStore petStore3 = new PetStore("Animour et Compagnie", "Henri Golant");

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        // Création et mise en base de données d'objets dans la table Address
        Address address1 = new Address("25", "Rue du parapluie", "31500", "Toulouse", petStore1);
        Address address2 = new Address("14", "Chemin de l'aiguille", "34070", "Montpellier", petStore2);
        Address address3 = new Address("73", "Avenue de la blague", "44060", "Nantes", petStore3);

        em.persist(address1);
        em.persist(address2);
        em.persist(address3);

        // Création et mise en base de données d'objets dans la table Produit
        Product product1 = new Product("18571", "Croquettes pour chat", FOOD, 7.59);
        Product product2 = new Product("93576", "Collier pour poisson", ACCESSORY, 14.35);
        Product product3 = new Product("15789", "Carsher pour Rhinoceros", CLEANING, 299.99);
        Product product4 = new Product("92232", "Burger de graines pour oiseaux", FOOD, 8.21);
        Product product5 = new Product("43382", "Informatique pour canard, le CanardPC", ACCESSORY, 586.44);
        Product product6 = new Product("67303", "Coupe ongle pour chihuahua", CLEANING, 3.85);

        // Liaison entre les produits et les petstores
        product1.setPetStores(new HashSet<>(Arrays.asList(petStore1, petStore2, petStore3)));
        product2.setPetStores(new HashSet<>(Arrays.asList(petStore2)));
        product3.setPetStores(new HashSet<>(Arrays.asList(petStore1, petStore2)));
        product4.setPetStores(new HashSet<>(Arrays.asList(petStore3, petStore2)));
        product5.setPetStores(new HashSet<>(Arrays.asList(petStore2, petStore1)));
        product6.setPetStores(new HashSet<>(Arrays.asList(petStore1)));

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);
        em.persist(product5);
        em.persist(product6);

        // Création et mise en base de données d'objets dans la table Cat
        Cat cat1 = new Cat();
        cat1.setBirth(LocalDate.parse("2022-06-27"));
        cat1.setColor("Noir");
        cat1.setPetstore(petStore3);
        cat1.setChipId("1254");

        Cat cat2 = new Cat();
        cat2.setBirth(LocalDate.parse("2021-09-12"));
        cat2.setColor("Blanc");
        cat2.setPetstore(petStore2);
        cat2.setChipId("5768");

        Cat cat3 = new Cat();
        cat3.setBirth(LocalDate.parse("2023-01-07"));
        cat3.setColor("Roux");
        cat3.setPetstore(petStore1);
        cat3.setChipId("9432");

        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);

        // Création et mise en base de données d'objets dans la table Fish
        Fish fish1 = new Fish();
        fish1.setBirth(LocalDate.parse("2021-10-21"));
        fish1.setColor("Bleu");
        fish1.setPetstore(petStore2);
        fish1.setLivingEnv(FishLivEnv.SEA_WATER);

        Fish fish2 = new Fish();
        fish2.setBirth(LocalDate.parse("2021-11-02"));
        fish2.setColor("Rouge");
        fish2.setPetstore(petStore1);
        fish2.setLivingEnv(FishLivEnv.FRESH_WATER);

        Fish fish3 = new Fish();
        fish3.setBirth(LocalDate.parse("2020-12-29"));
        fish3.setColor("Jaune");
        fish3.setPetstore(petStore3);
        fish3.setLivingEnv(FishLivEnv.SEA_WATER);

        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);

        em.getTransaction().commit();

        // Requête pour extraire tous les animaux d'une animalerie
        TypedQuery<Animal> queryAnimals = em.createQuery("SELECT anm FROM Animal anm where anm.petstore.name = 'Animour et Compagnie'", Animal.class);
        List<Animal> animalList = queryAnimals.getResultList();

        for (Animal animal : animalList) {
            System.out.println(animal.getColor());
        }

        // Fermeture de l'entity manager et l'entity manager factory
        em.close();
        emf.close();
    }
}