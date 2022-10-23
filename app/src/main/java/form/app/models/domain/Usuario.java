package form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario {

    private String identificador;
    
    @NotEmpty(message = "EL nombre no puede sere vacío.")
    private String nombre;

    @NotEmpty(message = "EL apellido no puede sere vacío.")
    private String apellido;

    @NotEmpty(message = "EL username no puede sere vacío.")
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty(message = "EL correo no puede sere vacío.")
    @Email
    private String email;

    @NotEmpty(message = "La password no puede sere vacío.")
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
