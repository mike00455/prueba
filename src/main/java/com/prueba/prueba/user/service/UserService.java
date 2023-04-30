package com.prueba.prueba.user.service;

import com.prueba.prueba.user.dto.UserRequestDto;
import com.prueba.prueba.user.dto.UserResponseDto;
import com.prueba.prueba.user.entity.User;
import com.prueba.prueba.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Map<String, String> saveUser(UserRequestDto userRequestDto){
        Map<String, String> map = new HashMap<>();

        /*** Convertimos el Dto en entidad ***/
        User user = modelMapper.map(userRequestDto, User.class);
        user.setUserActive(true);

        /*** Verificamos si el usuario existe ***/
        if (userRepository.existsByUserName(userRequestDto.getUserName())){
            map.put("message", "El nombre de usuario ya esta en uso");
            return map;
        }

        /*** Si el usuario no existe hacemos el guardado y retornamos mensaje de respuesta ***/
        userRepository.save(user);
        map.put("message", "Usuario creado con exito");
        return map;
    }

    public ResponseEntity<?> getAllUsers(){
        /*** Listamos usuarios activos ***/
        List<User> users = userRepository.findAllByUserActiveTrue();

        /*** almacen de usuarios como dto ***/
        List<UserResponseDto> userResponseDto = new ArrayList<>();

        /*** Convertimos la entidad en dto ***/
        for (User user : users){
            userResponseDto.add(convertToDto(user));
        }

        /*** si la lista de usuarios es vacia retornamos mensaje ***/
        if (users.isEmpty()){
            Map<String, String> map = new HashMap<>();
            map.put("message", "No hay usuarios registrados");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    public UserResponseDto getUserById(UUID userId){
        UserResponseDto user = modelMapper.map(userRepository.getByUserId(userId), UserResponseDto.class);
        return user;
    }

    /*** Metodo para convertir User a DTO***/
    private UserResponseDto convertToDto(User user){
        return modelMapper.map(user, UserResponseDto.class);
    }

    public Map<String, String> updateUser(UUID userId, UserRequestDto userRequestDto){
        Map<String, String> map = new HashMap<>();
        User user = userRepository.getByUserId(userId);
        user.setUserName(userRequestDto.getUserName());
        user.setUserPersonName(userRequestDto.getUserPersonName());
        user.setUserPersonLastname(userRequestDto.getUserPersonLastname());
        user.setUserPassword(userRequestDto.getUserPassword());
        userRepository.save(user);
        map.put("message", "Usuario actualizado con exito");
        return map;
    }

    public Map<String, String> deleteUser(UUID userId){
        Map<String, String> map = new HashMap<>();
        User user = userRepository.getByUserId(userId);
        user.setUserActive(false);
        userRepository.save(user);
        map.put("message", "Usuario eliminado con exito");
        return map;
    }
}
