package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")    // Get 방식으로 데이터 전달
    public String hello(Model model){
        model.addAttribute( "data", "spring!!");
        return "hello"; // hello.html 실행. 스프링이 자동적으로 reources\templates\hello.html을 탐색하여 실행함(viewResolver)
    }
}
