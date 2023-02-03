package demo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import demo.crud.repository.UserRepository;
import demo.crud.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository user_repository;

    public List<User> getUsers() {
        return user_repository.findAll();
    }

    public User getUser(String id) {
        return user_repository.findById(id).get();
    }

    public User addUser(User newUsr) {
        user_repository.save(newUsr);
        return newUsr;
    }

    public User updateUser(User usr) {
        User u = user_repository.findById(usr.getId()).get();
        u.setUsername(usr.getUsername());
        u.setPassword(usr.getPassword());
        user_repository.save(u);
        return u;
    }

    public User deleteUser(String id) {
        User u = user_repository.findById(id).get();
        user_repository.delete(u);
        return u;
    }

}