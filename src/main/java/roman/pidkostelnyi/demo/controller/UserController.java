package roman.pidkostelnyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelnyi.demo.dto.request.UserRequest;
import roman.pidkostelnyi.demo.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody UserRequest request) {
        userService.create(request);
    }
}
