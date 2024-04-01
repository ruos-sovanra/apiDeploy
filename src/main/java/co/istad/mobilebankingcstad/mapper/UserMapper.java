package co.istad.mobilebankingcstad.mapper;

import co.istad.mobilebankingcstad.domain.User;
import co.istad.mobilebankingcstad.features.user.dto.UserRequest;
import co.istad.mobilebankingcstad.features.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target ="roles", ignore = true)
    UserResponse toUserResponse(User user);

    @Mapping(target ="roles", ignore = true)
    User requestToUser(UserRequest userRequest);

}
