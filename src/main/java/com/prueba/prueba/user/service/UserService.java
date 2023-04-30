package com.prueba.prueba.user.service;

import com.prueba.prueba.user.dto.UserRequestDto;
import com.prueba.prueba.user.entity.User;
import com.prueba.prueba.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(UUID userId){
        return userRepository.getByUserId(userId);
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
        userRepository.delete(user);
        map.put("message", "Usuario eliminado con exito");
        return map;
    }
}
