package pe.edu.i202220496.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import pe.edu.i202220496.entity.City;
import pe.edu.i202220496.entity.Country;
import pe.edu.i202220496.entity.CountryLanguage;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        // Iniciar la transacción
        transaction.begin();

        // Crear un nuevo país
        Country country = new Country("IMY", "Imaginaria", "Fictional", "ImaginaryRegion", 10000000, 200000000, 150000000, 250.5, 1000000000.00, 1050000000.00, "Imaginaria", "Republic", "Nicolas Poma", 1, "IM");

        // Crear 3 ciudades para el país
        City city1 = new City(1, "CiudadUno", country, "DistritoUno", 800000);
        City city2 = new City(2, "CiudadDos", country, "DistritoDos", 1200000);
        City city3 = new City(3, "CiudadTres", country, "DistritoTres", 700000);


        country.addCity(city1);
        country.addCity(city2);
        country.addCity(city3);


        CountryLanguage language1 = new CountryLanguage(country, "Imaginario", "T", 99.0);
        CountryLanguage language2 = new CountryLanguage(country, "ImaginarioSecundario", "F", 85.0);


        em.persist(country);
        em.merge(city1);
        em.merge(city2);
        em.merge(city3);
        em.merge(language1);
        em.merge(language2);


        transaction.commit();

        em.close();
        emf.close();
    }
}


