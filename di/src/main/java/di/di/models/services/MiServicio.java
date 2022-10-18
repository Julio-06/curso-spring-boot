package di.di.models.services;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/* SI UTILIZAMOS SERVICES LO UNICO QUE DEFINE ES SEMANTICA QUE
 HACE REFERENCIA QUE ESTA CLASE MANEJA LOGICA DE NEGOCIO 
 PERO TAMBIEN PODEMOS UTILIZAR COMPONENT

 LA DIFERENCIA ENTRE COMPONENT Y SERVICE SOLO ES SEMANTICA.
 */

@Service
public class MiServicio {
    public String operacion(){
        return "ejecutando algún proceso.";
    }
}
