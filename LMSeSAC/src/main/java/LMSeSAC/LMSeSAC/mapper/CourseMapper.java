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
    @Mapping(source = "dto._id", target = "_id")
    @Mapping(source = "dto.cname", target = "cname")
    @Mapping(source = "dto.campus", target = "campus")
    @Mapping(source = "dto.category", target = "category")
    @Mapping(source = "dto.institution", target = "institution")
    @Mapping(source = "dto.period", target = "period")
    @Mapping(source = "dto.ccode", target = "ccode")
    Course toEntity(CourseDTO.Request dto, Course course);
    */

	@Mapping(source = "course._id", target = "_id")
	@Mapping(source = "course.cname", target = "cname")
	@Mapping(source = "course.campus", target = "campus")
	@Mapping(source = "course.category", target = "category")
	@Mapping(source = "course.institution", target = "institution")
	@Mapping(source = "course.period", target = "period")
	@Mapping(source = "course.ccode", target = "ccode")
	CourseDTO.Response toResponseDto(Course course);
}
