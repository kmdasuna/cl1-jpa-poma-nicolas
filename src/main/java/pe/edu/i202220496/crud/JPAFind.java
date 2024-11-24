package pe.edu.i202220496.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220496.entity.Country;

public class JPAFind {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country peru = em.find(Country.class, "PER");

        if (peru != null) {
            peru.getCities().stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println(city.getName()));
        } else {
            System.out.println("No se encontró el país con código PER.");
        }

        em.close();
        emf.close();
    }
}
