package datajpa.app.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String folio;

    @NotEmpty
    private String descripcion;

    private String observacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    /*
     * CON 'ManyToOne' MUCHAS FACTURAS UN CLIENTE.
     * 
     * CON EL 'FetchType.LAZY' SOLO REALIZA LA CONSULTA CUANDO SE LE LLAMA
     * Y EL EAGER CARGA TODOS LOS DATOS INCLUSO CUANDO NO SE NECESITEN.
     */

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    /*
     * SE COLOCO EL '@JoinColumn' PARA ESPECIFICAR EL CAMPO PARA RELACIONARLOS
     * YA QUE SE TRATA DE UNA RELACIÓN UNIDIRECCIONAL CON EL MODELO ItemFactura Y NO
     * COMO LA RELACIÓN
     * ENTRE Cliente Y Factura QUE ES EN AMBOS SENTIDOS POR LO QUE PODEMOS USAR EL
     * 'mappedBy'.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> itemsFactura;

    public Factura() {
        itemsFactura = new ArrayList<ItemFactura>();
    }

    @PrePersist
    public void prePersist() {
        folio = UUID.randomUUID().toString();
        createdAt = new Date();
    }

    public List<ItemFactura> getItemsFactura() {
        return itemsFactura;
    }

    public void setItemsFactura(List<ItemFactura> itemsFactura) {
        this.itemsFactura = itemsFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void addItemFactura(ItemFactura itemFactura) {
        itemsFactura.add(itemFactura);
    }

    public Double getTotal(){
        Double total = 0.0;

        for (ItemFactura itemFactura : itemsFactura) {
            total += itemFactura.calcularImporte();
        }

        return total;
    }
}
