package error.app.errors;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String id) {
        super("Usuario con ID: ".concat(id).concat(" no existe en el sistema."));
    }
    
}
