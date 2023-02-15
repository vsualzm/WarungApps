package barrans.devel.api.service;

import barrans.devel.api.api.dto.UserDTO;
import barrans.devel.api.model.User;
import barrans.devel.api.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User persistUser(@Valid User user) {
        user.persist();
        return user;
    }


    public Map<String, Object> getUserAll(Integer status, Integer index, Integer size) {
        Map<String, Object> result = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> meta = new LinkedHashMap<>();
        PanacheQuery<UserDTO> data = userRepository
                .find("Select a.id, a.name, a.birthDate, a.email from User a where a.status = ?1", status)
                .project(UserDTO.class)
                .page(Page.of(index, size));

        meta.put("totalPages",data.pageCount());
        meta.put("total", (int) data.count());
        meta.put("page", index);

        result.put("users",data.list());
        result.put("meta",meta);
        return result;
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
