package horario.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("horario")
public class HorarioInterceptor implements HandlerInterceptor {

    @Value("${config.horario.apertura}")
    private Integer apertura;

    @Value("${config.horario.cierre}")
    private Integer cierre;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        
        if(hora >= apertura && hora < cierre){
            StringBuilder horario = new StringBuilder("Bienvenidos al horario de atencion a clientes");
            horario.append(", atendemos desde las ");
            horario.append(apertura);
            horario.append("hrs. ");
            horario.append("hasta las ");
            horario.append(cierre);
            horario.append("hrs. ");
            horario.append("Gracias por su visita.");

            request.setAttribute("horario", horario.toString());

            return true;
        }

        response.sendRedirect(request.getContextPath().concat("/cerrado"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        String horario = (String) request.getAttribute("horario");

        modelAndView.addObject("horario", horario);
    }

}
