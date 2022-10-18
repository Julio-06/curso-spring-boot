package di.di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import di.di.models.domain.IteamFactura;
import di.di.models.domain.Producto;
import di.di.models.services.IServicio;
import di.di.models.services.MiServicio;
import di.di.models.services.MiServicioComplejo;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    @Primary
    public IServicio registrarMiServicio(){
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    public IServicio registrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<IteamFactura> registrarIteams(){
        Producto producto1 = new Producto("Camara sony", 100);
        Producto producto2 = new Producto("Teclado", 200);
        Producto producto3 = new Producto("Monitor", 300);

        IteamFactura linea1 = new IteamFactura(producto1, 1);
        IteamFactura linea2 = new IteamFactura(producto2, 3);
        IteamFactura linea3 = new IteamFactura(producto3, 1);

        return Arrays.asList(linea1, linea2, linea3);
    }
}
