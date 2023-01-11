package datajpa.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import datajpa.app.models.entities.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {
    /* public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(long id);

    public void delete(Long id); */
}
