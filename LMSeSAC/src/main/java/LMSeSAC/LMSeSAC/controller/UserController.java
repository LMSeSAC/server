package LMSeSAC.LMSeSAC.controller;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.service.CourseService;
import LMSeSAC.LMSeSAC.service.UserService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final CourseService courseService;

    @GetMapping("/userid")
    public String getCourses(Model model) {
        List<Course> result = courseService.findCourses();
        System.out.println(result);
        model.addAttribute("list", result);
        return "course";
    }

}
