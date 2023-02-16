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
import java.time.LocalDate;
import java.util.*;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public void addUser(JsonObject params){
        User user = new User();
        user.id = null;
        user.name = params.getString("name");
        user.birthPlace = params.getString("birth_place");
        user.birthDate = LocalDate.parse(params.getString("birth_date"));
        user.password = params.getString("password");
        user.roleId = params.getInteger("role_id");
        user.email = params.getString("email");
        user.status = params.getInteger("status");
        user.createdBy = params.getString("created_by");
        user.updatedBy = params.getString("updated_by");
        userRepository.persist(user);
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
       user.status = 1;
       userRepository.persist(user);
    }

    @Transactional
    public void updateUser(Long id, JsonObject params) {
        User user = userRepository.findById(id);
        user.name = params.getString("name");
        user.birthPlace = params.getString("birth_place");
        user.birthDate = LocalDate.parse(params.getString("birth_date"));
        user.password = params.getString("password");
        user.roleId = params.getInteger("role_id");
        user.email = params.getString("email");
        user.status = params.getInteger("status");
        user.createdBy = params.getString("created_by");
        user.updatedBy = params.getString("updated_by");
        userRepository.persist(user);
    }
}
