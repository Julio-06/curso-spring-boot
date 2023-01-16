package datajpa.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import datajpa.app.models.entities.Cliente;
import datajpa.app.models.entities.Producto;

public interface IClienteService {
    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public void save(Cliente cliente);

    public Cliente findOne(long id);

    public void delete(Long id);

    public List<Producto> findByNombre(String nombre);
}
