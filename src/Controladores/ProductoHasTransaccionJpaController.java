/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Entidades.ProductoHasTransaccion;
import Entidades.ProductoHasTransaccionPK;
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
 * The Class ProductoHasTransaccionJpaController.
 *
 * @author joans
 */
public class ProductoHasTransaccionJpaController implements Serializable {

    /**
     * Instantiates a new producto has transaccion jpa controller.
     */
    public ProductoHasTransaccionJpaController() {
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
     * @param productoHasTransaccion the producto has transaccion
     * @throws PreexistingEntityException the preexisting entity exception
     * @throws Exception the exception
     */
    public void create(ProductoHasTransaccion productoHasTransaccion) throws PreexistingEntityException, Exception {
        if (productoHasTransaccion.getProductoHasTransaccionPK() == null) {
            productoHasTransaccion.setProductoHasTransaccionPK(new ProductoHasTransaccionPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoHasTransaccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoHasTransaccion(productoHasTransaccion.getProductoHasTransaccionPK()) != null) {
                throw new PreexistingEntityException("ProductoHasTransaccion " + productoHasTransaccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edits the.
     *
     * @param productoHasTransaccion the producto has transaccion
     * @throws NonexistentEntityException the nonexistent entity exception
     * @throws Exception the exception
     */
    public void edit(ProductoHasTransaccion productoHasTransaccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoHasTransaccion = em.merge(productoHasTransaccion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProductoHasTransaccionPK id = productoHasTransaccion.getProductoHasTransaccionPK();
                if (findProductoHasTransaccion(id) == null) {
                    throw new NonexistentEntityException("The productoHasTransaccion with id " + id + " no longer exists.");
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
    public void destroy(ProductoHasTransaccionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductoHasTransaccion productoHasTransaccion;
            try {
                productoHasTransaccion = em.getReference(ProductoHasTransaccion.class, id);
                productoHasTransaccion.getProductoHasTransaccionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoHasTransaccion with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoHasTransaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Find producto has transaccion entities.
     *
     * @return the list
     */
    public List<ProductoHasTransaccion> findProductoHasTransaccionEntities() {
        return findProductoHasTransaccionEntities(true, -1, -1);
    }

    /**
     * Find producto has transaccion entities.
     *
     * @param maxResults the max results
     * @param firstResult the first result
     * @return the list
     */
    public List<ProductoHasTransaccion> findProductoHasTransaccionEntities(int maxResults, int firstResult) {
        return findProductoHasTransaccionEntities(false, maxResults, firstResult);
    }

    /**
     * Find producto has transaccion entities.
     *
     * @param all the all
     * @param maxResults the max results
     * @param firstResult the first result
     * @return the list
     */
    private List<ProductoHasTransaccion> findProductoHasTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductoHasTransaccion.class));
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
     * Find producto has transaccion.
     *
     * @param id the id
     * @return the producto has transaccion
     */
    public ProductoHasTransaccion findProductoHasTransaccion(ProductoHasTransaccionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoHasTransaccion.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Gets the producto has transaccion count.
     *
     * @return the producto has transaccion count
     */
    public int getProductoHasTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductoHasTransaccion> rt = cq.from(ProductoHasTransaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
