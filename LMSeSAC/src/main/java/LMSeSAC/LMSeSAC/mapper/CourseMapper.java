package LMSeSAC.LMSeSAC.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.dto.CourseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper extends BasicMapper<CourseDTO, Course> {
	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    /*
    @Mapping(source = "dto.id", target = "id")
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.campus", target = "campus")
    @Mapping(source = "dto.category", target = "category")
    @Mapping(source = "dto.institution", target = "institution")
    @Mapping(source = "dto.period", target = "period")
    @Mapping(source = "dto.ccode", target = "ccode")
    Course toEntity(CourseDTO.Request dto, Course course);
    */

	@Mapping(source = "course.id", target = "id")
	@Mapping(source = "course.name", target = "name")
	@Mapping(source = "course.category", target = "category")
	@Mapping(source = "course.code", target = "code")
	@Mapping(source = "course.startDate", target = "startDate")
	@Mapping(source = "course.endDate", target = "endDate")
	@Mapping(source = "course.institution", target = "institution")
	@Mapping(source = "course.campus", target = "campus")
	CourseDTO.Response toResponseDto(Course course);
}
