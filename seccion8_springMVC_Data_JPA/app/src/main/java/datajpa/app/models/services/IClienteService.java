package datajpa.app.models.services;

import java.util.List;

import datajpa.app.models.entities.Cliente;

public interface IClienteService {
    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(long id);

    public void delete(Long id);
}