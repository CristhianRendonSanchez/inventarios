/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Transaccion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class TransaccionJpaController.
 *
 * @author joans
 */
public class TransaccionJpaController implements Serializable {

    /**
     * Instantiates a new transaccion jpa controller.
     */
    public TransaccionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PruebaConexPU");
    }
    
    /** The emf. */
    private EntityManagerFactory emf = null;



    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Creates the.
     *
     * @param transaccion the transaccion
     */
    public void create(Transaccion transaccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(transaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edits the.
     *
     * @param transaccion the transaccion
     * @throws NonexistentEntityException the nonexistent entity exception
     * @throws Exception the exception
     */
    public void edit(Transaccion transaccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            transaccion = em.merge(transaccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transaccion.getIdTransaccion();
                if (findTransaccion(id) == null) {
                    throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Destroy.
     *
     * @param id the id
     * @throws NonexistentEntityException the nonexistent entity exception
     */
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion transaccion;
            try {
                transaccion = em.getReference(Transaccion.class, id);
                transaccion.getIdTransaccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.", enfe);
            }
            em.remove(transaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Find transaccion entities.
     *
     * @return the list
     */
    public List<Transaccion> findTransaccionEntities() {
        return findTransaccionEntities(true, -1, -1);
    }

    /**
     * Find transaccion entities.
     *
     * @param maxResults the max results
     * @param firstResult the first result
     * @return the list
     */
    public List<Transaccion> findTransaccionEntities(int maxResults, int firstResult) {
        return findTransaccionEntities(false, maxResults, firstResult);
    }

    /**
     * Find transaccion entities.
     *
     * @param all the all
     * @param maxResults the max results
     * @param firstResult the first result
     * @return the list
     */
    private List<Transaccion> findTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transaccion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Find transaccion.
     *
     * @param id the id
     * @return the transaccion
     */
    public Transaccion findTransaccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transaccion.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Gets the transaccion count.
     *
     * @return the transaccion count
     */
    public int getTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transaccion> rt = cq.from(Transaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
