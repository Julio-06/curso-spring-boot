package di.di.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary /* SI QUEREMOS QUE ESTA CLASE SEA LA POR DEFECTO COLOCAMOS Primary */
public class MiServicioComplejo implements IServicio{

    @Override
    public String operacion() {
        return "ejecutando algún proceso complejo...";
    }
}
