package org.sang.backendecommerce.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sang.backendecommerce.dto.model.UserDTO;
import org.sang.backendecommerce.model.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	UserDTO toUserDTO(User user);
	User toUser(UserDTO userDTO);
	List<UserDTO> toUserDTOList(List<User> users);
}
