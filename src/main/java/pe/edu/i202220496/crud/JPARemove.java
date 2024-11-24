package pe.edu.i202220496.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220496.entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "XYZ");

        if (country != null) {
            em.getTransaction().begin();
            em.remove(country);

            em.getTransaction().commit();
            System.out.println("El país y sus ciudades y lenguajes fueron eliminados correctamente.");
        } else {
            System.out.println("No se encontró el país con el código proporcionado.");
        }

        em.close();
        emf.close();
    }
}
