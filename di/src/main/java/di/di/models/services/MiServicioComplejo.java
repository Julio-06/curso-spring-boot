package di.di.models.services;

import org.springframework.stereotype.Service;

@Service("miServicioComplejo")
public class MiServicioComplejo implements IServicio{

    @Override
    public String operacion() {
        return "ejecutando algún proceso complejo...";
    }
}
