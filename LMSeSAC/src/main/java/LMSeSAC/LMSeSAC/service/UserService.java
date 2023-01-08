package LMSeSAC.LMSeSAC.service;

import LMSeSAC.LMSeSAC.domain.Course;
import LMSeSAC.LMSeSAC.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
