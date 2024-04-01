package co.istad.mobilebankingcstad.features.user;

import co.istad.mobilebankingcstad.features.user.dto.UserRequest;
import co.istad.mobilebankingcstad.features.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();
}
