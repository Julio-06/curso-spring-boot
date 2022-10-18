package di.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
}
