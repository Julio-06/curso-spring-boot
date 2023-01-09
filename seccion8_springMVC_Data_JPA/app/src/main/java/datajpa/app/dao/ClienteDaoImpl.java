package datajpa.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import datajpa.app.models.entities.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    public Cliente findOne(long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public void save(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() > 0){
            entityManager.merge(cliente);
        }else{
            entityManager.persist(cliente);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
    }
}
