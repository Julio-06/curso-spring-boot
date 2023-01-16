package datajpa.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import datajpa.app.models.entities.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
    
    //CONSULTA A NIVEL DE CLASE ENTITY
    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findByNombre(String nombre);

    public List<Producto> findByNombreLikeIgnoreCase(String nombre);
}
