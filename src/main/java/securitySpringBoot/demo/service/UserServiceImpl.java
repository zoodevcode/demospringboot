package securitySpringBoot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securitySpringBoot.demo.entities.User;
import securitySpringBoot.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }


//    @Override
//    public User findByUsername(String username) {
//        User user = null;
//        try {
//            user = userRepository.findByUsername(username);
//        }catch (Exception e){
//            throw e;
//        }
//        return user;
//    }
}
