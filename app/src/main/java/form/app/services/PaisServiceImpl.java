package form.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.Arrays;

import form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService{
    private List<Pais> lista;
    
    public PaisServiceImpl() {
        this.lista = Arrays.asList(
            new Pais(1, "PA", "Panamá"),
            new Pais(1, "MX", "Mexico"),
            new Pais(1, "COL", "Colombia")
        );
    }

    @Override
    public List<Pais> listar() {
        return this.lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for(Pais pais: this.lista){
            if(id == pais.getId()){
                resultado = pais;
                break;
            }
        }

        return resultado;
    }
    
}
