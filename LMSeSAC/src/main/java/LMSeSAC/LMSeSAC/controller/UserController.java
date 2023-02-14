package LMSeSAC.LMSeSAC.controller;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.service.CourseService;
import LMSeSAC.LMSeSAC.service.UserService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
@RestController
public class UserController {
    private final UserService userService;

}
