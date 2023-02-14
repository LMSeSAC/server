package LMSeSAC.LMSeSAC.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import LMSeSAC.LMSeSAC.domain.User;
import LMSeSAC.LMSeSAC.dto.AuthDTO;
import LMSeSAC.LMSeSAC.dto.UserDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BasicMapper<AuthDTO, User> {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({
		@Mapping(source = "dto.uid", target = "uid"),
		@Mapping(source = "dto.password", target = "password")
	})
	User toEntity(AuthDTO.Request dto);

	@Mappings({
		@Mapping(source = "dto.uid", target = "uid"),
		@Mapping(source = "dto.password", target = "password"),
		@Mapping(source = "dto.email", target = "email"),
		@Mapping(source = "dto.uname", target = "uname"),
		@Mapping(source = "dto.phone", target = "phone"),
		@Mapping(source = "dto.login_type", target = "login_type"),
		@Mapping(source = "dto.utype", target = "utype")
	})
	User toEntityRegister(AuthDTO.RegisterRequest dto);

	@Mapping(source = "user._id", target = "_id")
	@Mapping(source = "user.uid", target = "uid")
	@Mapping(source = "user.uname", target = "uname")
	@Mapping(source = "user.email", target = "email")
	@Mapping(source = "user.phone", target = "phone")
	@Mapping(source = "user.utype", target = "utype")
	@Mapping(source = "user.login_type", target = "login_type")
	UserDTO.Response toResponseDto(User user);
}