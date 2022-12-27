package form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        LOGGER.info("TiempoTranscurridoInterceptor: preHandle() entrando ...");
        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido =  tiempoFinal - tiempoInicio;
        
        if(modelAndView != null){
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }

        LOGGER.info("Tiempo transcurrido: " + tiempoTranscurrido + " milisegundos");
        LOGGER.info("TiempoTranscurridoInterceptor: postHandle() saliendo ...");
    }

}
