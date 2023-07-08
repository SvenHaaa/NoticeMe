package com.noticeme.db;

import com.noticeme.model.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class NoteRepository {

    public static final String ENTITY_MANAGER_URL = "noticeme-persistence-unit";

    private EntityManagerFactory emf;

    private EntityManager em;

    public NoteRepository() {
//        this.emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER_URL);
        //this.emf = new HibernatePersistenceProvider().createEntityManagerFactory(ENTITY_MANAGER_URL); //todo zum laufen bekommen
        //und herausfinden wie man checken kann, ob die persistence.xml in classpath ist
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Note> findAll() {
        em = getEntityManager();
        em.getTransaction().begin();
        List<Note> resultList = em.createQuery("FROM note n", Note.class).getResultList();
        em.getTransaction().commit();
        return resultList;
    }

    public void create(Note note) {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(note);
        em.getTransaction().commit();
    }

//    @Transactional
//    public void create(Note note) {
//        em.persist(note);
//    }

    public Long update(Note newNote) {
        em = getEntityManager();
        em.getTransaction().begin();
        Note saved = em.find(Note.class, newNote.getId());
        saved.update(newNote);
        em.persist(saved);
        em.getTransaction().commit();
        return newNote.getId();
    }

//    @Transactional
//    public Long update(Note newNote){
//        Note saved = em.find(Note.class, newNote.getId());
//        saved.update(newNote);
//        em.persist(saved);
//        return saved.getId();
//    }

}
