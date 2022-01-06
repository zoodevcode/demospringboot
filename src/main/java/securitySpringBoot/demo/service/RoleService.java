package securitySpringBoot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securitySpringBoot.demo.entities.Role;
import securitySpringBoot.demo.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role){
        return roleRepository.save(role);
    }
    public List<Role> listRole(){
        return roleRepository.findAll();
    }

}
