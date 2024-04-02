package co.istad.mobilebankingcstad.features.user;


import co.istad.mobilebankingcstad.domain.Role;
import co.istad.mobilebankingcstad.domain.User;
import co.istad.mobilebankingcstad.features.roles.RoleRepository;
import co.istad.mobilebankingcstad.features.user.dto.UserRequest;
import co.istad.mobilebankingcstad.features.user.dto.UserResponse;
import co.istad.mobilebankingcstad.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        //userRepository.save(userRequest);
        Set<Role> roles = new HashSet<>();
        for (var role : userRequest.roles()) {
            var roleObj = roleRepository.findByName(role)
                    .orElseThrow(
                            () -> new NoSuchElementException(
                                    "Role: <" + role + "> could not found!"
                            )
                    );
            roles.add(roleObj);
        }
        User newUser = userMapper.requestToUser(userRequest);
        newUser.setRoles(roles);
        userRepository.save(newUser);
        return userMapper.toUserResponse(newUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUserById(String id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("There is no user with id = " + id));
        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUserById(String id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("There is no user with id = " + id));
        userRepository.delete(user);

    }

    @Override
    public UserResponse updateUserById(String id, UserRequest userRequest) {
        var updateUser = userRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("There is no user with = " + id));
        userMapper.updateUserFromRequest(updateUser, userRequest);

        System.out.println("Updated User is : " + updateUser);

        return null;
    }

    @Override
    public UserResponse disableUser(String id) {
        return null;
    }

    @Override
    public UserResponse enableUser(String id) {
        return null;
    }

}
