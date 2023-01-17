package datajpa.app.dao;

import org.springframework.data.repository.CrudRepository;

import datajpa.app.models.entities.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{
    
}
