package datajpa.app.dao;

import org.springframework.data.repository.CrudRepository;

import datajpa.app.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
    /* public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(long id);

    public void delete(Long id); */
}
