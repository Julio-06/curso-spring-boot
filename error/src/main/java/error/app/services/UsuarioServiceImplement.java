package error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    private List<Usuario> lista;
    
    public UsuarioServiceImplement() {
        this.lista = new ArrayList<>();
        this.lista.add(new Usuario(1, "Julio", "Tejeira"));
        this.lista.add(new Usuario(2, "Pablo", "Tejeira"));
        this.lista.add(new Usuario(3, "Cesar", "Tejeira"));
    }

    @Override
    public List<Usuario> listar() {
        return this.lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;

        for (Usuario usuario : this.lista) {
            if(usuario.getId().equals(id)){
                resultado = usuario;
                break;
            }
        }

        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = this.obtenerPorId(id);

        return Optional.ofNullable(usuario);
    }
    
}
