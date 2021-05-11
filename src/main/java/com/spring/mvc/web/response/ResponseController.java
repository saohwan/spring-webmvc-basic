package com.spring.mvc.web.response;

import com.spring.mvc.web.request.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResponseController {

    @GetMapping("/response/res-ex")
    public void resEx() {
    }

    @GetMapping("/response/test2")
    public String test(int age
                       //, HttpServletRequest request
                       , Model model
    ) {
        System.out.println("age = " + age);
        //request.setAttribute("userAge", age + 10);
        model.addAttribute("userAge", age);
        model.addAttribute("nickName", "바보");
        return "response/test";
    }

    @PostMapping("/response/test2")
    public String test2(User user, Model model) {
        model.addAttribute("user", user);
        return "response/test2";
    }

    @GetMapping("/response/res-quiz")
    public String quiz(User user, Model model) {
        model.addAttribute("user", user);
        return "response/res-quiz";
    }

    @PostMapping("/response/quiz")
    public String quizPOST(User user, Model model) {
        model.addAttribute("user", user.getUserId());
        if (user.getUserId().equals("kim1234") && user.getUserPw().equals("kkk1234")) {
            return "response/success";
        } else {
            return "response/fail";
        }
    }


}

