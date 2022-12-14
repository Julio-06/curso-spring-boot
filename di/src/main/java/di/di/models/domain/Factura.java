package di.di.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope /* NO PERMITE MANTENER LOS DATOS A NIVEL DE SESSIONES COMO POR EJEMPLO UN CARRITO DE COMPRAS */
public class Factura implements Serializable {

    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<IteamFactura> items;

    @PostConstruct
    public void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("desde el @PostConstruct"));
    }

    @PreDestroy
    public void destruir(){
        System.out.println("Factura destruida: ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<IteamFactura> getItems() {
        return items;
    }

    public void setItems(List<IteamFactura> items) {
        this.items = items;
    }
}
