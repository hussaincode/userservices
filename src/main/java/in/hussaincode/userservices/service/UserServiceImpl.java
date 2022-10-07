package in.hussaincode.userservices.service;

import in.hussaincode.userservices.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    //fake user list
    List<User> userList=List.of(
            new User(13111L,"Hussain","9999999999"),
            new User(13112L,"Haris","9999999998"),
            new User(13113L,"Waris","9999999997"),
            new User(13114L,"Intekhab","9999999996")
    );

    @Override
    public User getUser(Long id) {
        return this.userList.stream().filter(user ->
                user.getUserId().equals(id)).findAny().orElse(null);
    }
}
