package com.test.HappyTest.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="API", description = "Sample API 입니다.")
@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "Goodbye!";
    }
}
