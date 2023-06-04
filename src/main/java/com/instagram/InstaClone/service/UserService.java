package com.instagram.InstaClone.service;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.dto.UserRegistrationRequest;
import com.instagram.InstaClone.dto.UserUpdateRequestData;
import com.instagram.InstaClone.dto.conventor.UserConvertor;
import com.instagram.InstaClone.entity.User;
import com.instagram.InstaClone.entity.enumiration.Role;
import com.instagram.InstaClone.repository.UserRepository;
import com.instagram.InstaClone.security.AuthenticationRequest;
import com.instagram.InstaClone.security.AuthenticationResponse;
import com.instagram.InstaClone.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements com.instagram.InstaClone.service.api.UserService {
    private final UserRepository userRepository;
    private final UserConvertor userConvertor;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserMainDataDTO findById(long id) {
        return userConvertor.convertMainDataToDTO(userRepository.findById(id));
    }

    @Override
    public AuthenticationResponse addUser(UserRegistrationRequest newUser) {
        var user = User.builder()
                        .username(newUser.getUsername())
                        .email(newUser.getEmail())
                        .password(passwordEncoder.encode(newUser.getPassword()))
                        .role(Role.USER)
                        .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public void updateUser(long id, UserUpdateRequestData newUser) {
        User user = userRepository.findById(id);

        if(newUser.getUsername() != null)
            user.setUsername(newUser.getUsername());

        if(newUser.getBio() != null)
            user.setBio(newUser.getBio());

        if(newUser.getEmail() != null)
            user.setEmail(newUser.getEmail());

        if(newUser.getPassword() != null)
            user.setPassword(newUser.getPassword());

        if(newUser.getBirthday() !=  null)
            user.setBirthday(newUser.getBirthday());

        if(newUser.getSex() != null)
            user.setSex(newUser.getSex());

        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = Optional.ofNullable(userRepository.getReferenceByUsername(request.getUsername())).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    @Override
    public List<UserMainDataDTO> findAllByUsername(String username) {
        List<UserMainDataDTO> users;

        users = userRepository.searchAllByUsername(username).stream().map(userConvertor::convertMainDataToDTO).toList();

        return users;
    }
}
