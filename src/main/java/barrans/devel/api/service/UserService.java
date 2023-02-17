package barrans.devel.api.service;

import barrans.devel.api.model.User;
import barrans.devel.api.repository.UserRepository;
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


    public List<User> getListAll(){
        List<User> users = userRepository.findAll().list();
        return users;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id);
        user.delete();
    }

    @Transactional
    public void updateUser(Long id, JsonObject params){
        User user = userRepository.findById(id);
        user.email = params.getString("email");
        user.username = params.getString("username");
        user.mobile_phone_number = params.getString("mobile_phone_number");
        userRepository.persist(user);
    }
}
