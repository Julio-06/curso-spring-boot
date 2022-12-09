package form.app.services;

import java.util.List;

import form.app.models.domain.Role;

public interface RoleService {
    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
