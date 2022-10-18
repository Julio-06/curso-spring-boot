package di.di.models.services;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/* SI UTILIZAMOS SERVICES LO UNICO QUE DEFINE ES SEMANTICA QUE
 HACE REFERENCIA QUE ESTA CLASE MANEJA LOGICA DE NEGOCIO 
 PERO TAMBIEN PODEMOS UTILIZAR COMPONENT

 LA DIFERENCIA ENTRE COMPONENT Y SERVICE SOLO ES SEMANTICA.
 */

@Service("miServicioSimple") /* 
    cuando se le define un nombre al servicio o componente 
    definimos un cualificador
*/
public class MiServicio implements IServicio{
    public String operacion(){
        return "ejecutando algún proceso.";
    }
}
