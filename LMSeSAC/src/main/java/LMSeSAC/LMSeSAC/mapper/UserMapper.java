package LMSeSAC.LMSeSAC.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import LMSeSAC.LMSeSAC.domain.User;
import LMSeSAC.LMSeSAC.dto.AuthDTO;
import LMSeSAC.LMSeSAC.dto.UserDTO;
import LMSeSAC.LMSeSAC.enums.UserRoleEnum;
import LMSeSAC.LMSeSAC.enums.UserTypeEnum;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BasicMapper<AuthDTO, User> {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({
		@Mapping(source = "dto.userid", target = "userid"),
		@Mapping(source = "dto.password", target = "password")
	})
	User toEntity(AuthDTO.Request dto);

	@Mappings({
		@Mapping(source = "dto.userid", target = "userid"),
		@Mapping(source = "dto.password", target = "password"),
		@Mapping(source = "dto.email", target = "email"),
		@Mapping(source = "dto.name", target = "name"),
		@Mapping(source = "dto.phone", target = "phone"),
		@Mapping(source = "type", target = "type"),
		@Mapping(source = "role", target = "role")
	})
	User toEntityRegister(AuthDTO.RegisterRequest dto, UserRoleEnum role, UserTypeEnum type);

	@Mapping(source = "user.id", target = "id")
	@Mapping(source = "user.userid", target = "userid")
	@Mapping(source = "user.name", target = "name")
	@Mapping(source = "user.email", target = "email")
	@Mapping(source = "user.phone", target = "phone")
	@Mapping(source = "user.type", target = "type")
	@Mapping(source = "user.role", target = "role")
	UserDTO.Response toResponseDto(User user);
}