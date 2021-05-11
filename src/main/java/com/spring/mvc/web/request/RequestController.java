package com.spring.mvc.web.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//스프링 컨테이너에 해당 클래스의 객체가 빈(컨트롤러기능)으로 등록됨.
@Controller
public class RequestController {

    //요청 처리 메서드 (서블릿 역할)
    //해당 URL에 따른 GET요청을 처리하게 함.
    //@RequestMapping(value = "/req/test", method = RequestMethod.POST)
    @GetMapping("/req/test") //
    public String test() {
        System.out.println("## /req/test GET요청 발생!!");
        //return "/WEB-INF/views/test.jsp"; //리턴은 뷰파일 포워딩 개념.
        return "test";
    }

    //요청 URI : /request/req-ex
    @GetMapping("/request/req-ex")
    public String reqEx() {
        return "request/req-ex";
    }

    //둘다 다른 메소드일경우 같은 경로여도 중복가능
    @GetMapping("/request/basic")
    public String basicGET() {
        System.out.println("/basic GET요청 발생!");
        return "request/req-ex";
    }

    @PostMapping("/request/basic")
    public String basicPOST() {
        System.out.println("/basic POST요청 발생!");
        return "request/req-ex";
    }

    //요청 파라미터 받기 (/req/basic ? xxx=yyy&zzz=xxx )
    @GetMapping("/request/param")
    public String param(HttpServletRequest request) {
        String money = request.getParameter("money");
        String name = request.getParameter("name");
        System.out.println("money = " + money);
        System.out.println("name = " + name);
        return "test";
    }

    //요청 파라미터 받기2 - @RequestParam 이용하기
    @GetMapping("/request/param2")
    public String param2(@RequestParam("money") int apple
                        ,String id  //변수가 어떤것이든  @RequestParam("money") 선언시 money로 불러오겠다.
                        //,String addr
    ) { // <<실무 팁 ) {
        System.out.println("apple = " + (apple*2));
        System.out.println("id = " + id);
//        System.out.println("addr = " + addr);
        return "test";
    }

    //요청 파라미터 받기3 - 커맨드 객체 사용
    @GetMapping("/request/param3")
    public String param3(User user) {
        System.out.println("user = " + user);
        return "test";
    }

    @GetMapping("/request/join-form")
    public void form() {

    }

   @GetMapping("/request/quiz")
    public String quiz(User user) {
       System.out.println("user = " + user);
       return "request/req-quiz";
   }

   @PostMapping("/request/quiz")
    public String quizPOST(User user) {
       System.out.println("user = " + user);
       if (user.getUserId().equals("abc1234") && user.getUserPw().equals("xxx4321")) {
           return "request/success";
       } else {
           return "request/fail";
       }
   }



}
