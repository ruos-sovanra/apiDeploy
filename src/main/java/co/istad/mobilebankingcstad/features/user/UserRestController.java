package co.istad.mobilebankingcstad.features.user;


import co.istad.mobilebankingcstad.features.user.dto.UserRequest;
import co.istad.mobilebankingcstad.features.user.dto.UserResponse;
import co.istad.mobilebankingcstad.utils.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register new user")

    public BaseResponse<UserResponse> registerUser(
           @Valid  @RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public BaseResponse<List<UserResponse>> getAllUser(){
        return BaseResponse.<List<UserResponse>>ok()
                .setPayload(userService.getAllUsers());

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public BaseResponse<UserResponse> getUserById(@PathVariable String id){
        return BaseResponse.<UserResponse>ok()
                .setPayload(userService.getUserById(id));
    }
}
