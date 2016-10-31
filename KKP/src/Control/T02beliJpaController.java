/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.exceptions.NonexistentEntityException;
import Model.T02beli;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Thinkpad
 */
public class T02beliJpaController implements Serializable {

    public T02beliJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(T02beli t02beli) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t02beli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(T02beli t02beli) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            t02beli = em.merge(t02beli);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = t02beli.getT02Id();
                if (findT02beli(id) == null) {
                    throw new NonexistentEntityException("The t02beli with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            T02beli t02beli;
            try {
                t02beli = em.getReference(T02beli.class, id);
                t02beli.getT02Id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The t02beli with id " + id + " no longer exists.", enfe);
            }
            em.remove(t02beli);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<T02beli> findT02beliEntities() {
        return findT02beliEntities(true, -1, -1);
    }

    public List<T02beli> findT02beliEntities(int maxResults, int firstResult) {
        return findT02beliEntities(false, maxResults, firstResult);
    }

    private List<T02beli> findT02beliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from T02beli as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public T02beli findT02beli(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(T02beli.class, id);
        } finally {
            em.close();
        }
    }

    public int getT02beliCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from T02beli as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
