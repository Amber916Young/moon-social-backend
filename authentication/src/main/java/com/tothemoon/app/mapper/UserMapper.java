package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.UserDTO;
import com.tothemoon.common.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    List<UserDTO> toDTOList(List<User> users);
}
