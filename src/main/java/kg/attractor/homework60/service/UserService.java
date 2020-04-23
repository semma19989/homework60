package kg.attractor.homework60.service;


import kg.attractor.homework60.dto.UserDTO;
import kg.attractor.homework60.model.Users;
import kg.attractor.homework60.repository.UsersRepository;
import kg.attractor.homework60.util.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository ur;

    public UserDTO getUserByName(String name){
        return UserDTO.from(ur.findUsersByName(name));
    }

    public Users getUserByEmail(String mail){
        return ur.findUsersByMail(mail);
    }

    public UserDTO getUserByMail(String mail){
        return UserDTO.from(ur.findUsersByMail(mail));
    }

    public boolean existUserByMail(String mail){
        return ur.existsUsersByMail(mail);
    }

    public UserDTO createUser(UserDTO userDTO){
        Users user = Users.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .mail(userDTO.getMail())
                .pass(SecurityConfig.encoder().encode(userDTO.getPass()))
                .build();
        ur.save(user);
        return UserDTO.from(user);
    }

    public void deleteUsersByName(String name){
        ur.deleteUsersByName(name);
    }
}