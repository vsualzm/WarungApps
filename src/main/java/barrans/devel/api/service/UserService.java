package barrans.devel.api.service;

import barrans.devel.api.api.dto.UserDTO;
import barrans.devel.api.model.User;
import barrans.devel.api.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User persistUser(@Valid User user) {
        user.persist();
        return user;
    }


    public List<UserDTO> getListAll() {
        PanacheQuery<UserDTO> result = userRepository.find("Select a.user_id, a.name, a.birthDate, a.email from User a where a.status = 1").project(UserDTO.class);
        return result.list();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id);
        user.delete();
    }

    @Transactional
    public void updateUser(Long id, JsonObject params) {

    }
}
