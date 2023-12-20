package com.rest.rest.service;
import com.rest.rest.model.User;
import com.rest.rest.pojo.UserPojo;
import com.rest.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User checkIt(Long id) throws Exception {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent())
            return optionalUser.get();
        throw new Exception("User Not Found");
    }

    public String createUser(UserPojo userPojo) throws Exception {
        User user;
        if(userPojo.getId() != null)
            user = checkIt(userPojo.getId());
        else
            user = new User();
        user.setUsername(userPojo.getUsername());
        user.setPhone(userPojo.getPhone());
        User savedUser = userRepo.save(user);
        userPojo.setId(savedUser.getId());
        return "user created";
    }

    public List<Map<String,Object>> getAllUsers()
    {
        return userRepo.getAllUser();
    }
    public Map<String,Object> getUserById(Long id){
        return userRepo.getUserById(id);
    }
    public void  deleteUser(Long id)
    {
        userRepo.deleteById(id);
    }
    public void deleteAllUser()
    {
        userRepo.deleteAll();
    }
}
