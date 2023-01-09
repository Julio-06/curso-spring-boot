package datajpa.app.dao;

import java.util.List;

import datajpa.app.models.entities.Cliente;

public interface IClienteDao {
    public List<Cliente> findAll();

    public void save(Cliente cliente);
}
