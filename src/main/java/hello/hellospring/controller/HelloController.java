package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    // Get 방식으로 데이터 전달
    public String hello(Model model){
        model.addAttribute( "data", "spring!!");
        return "hello"; // hello.html 실행. 스프링이 자동적으로 reources\templates\hello.html을 탐색하여 실행함(viewResolver)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // <body>에 응답 내용을 직접 삽입해주는 어노테이션
    public String helloSpring(@RequestParam("name") String name){
        return "hello" + name; // "hello 입력내용" 형태로 출력
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
