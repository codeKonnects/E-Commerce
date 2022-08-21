package io.codeKonnects.ecommerce.controller;

import io.codeKonnects.ecommerce.dto.users.SignInDto;
import io.codeKonnects.ecommerce.dto.users.SignInResponseDto;
import io.codeKonnects.ecommerce.dto.users.SignUpResponseDto;
import io.codeKonnects.ecommerce.dto.users.SignupDto;
import io.codeKonnects.ecommerce.exception.AuthenticationFailException;
import io.codeKonnects.ecommerce.exception.CustomException;
import io.codeKonnects.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException, AuthenticationFailException {
        return userService.signIn(signInDto);
    }
}
