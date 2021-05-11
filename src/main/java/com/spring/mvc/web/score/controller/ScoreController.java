package com.spring.mvc.web.score.controller;

import com.spring.mvc.web.score.domain.Score;
import com.spring.mvc.web.score.repository.ScoreRepository;
import com.spring.mvc.web.score.service.ScoreService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2 //로그를 만들어주는 롬복 에너테이션
@RequestMapping("/score") // 이맵핑은 컨트롤러 내부에서만 /score 주소가 자동으로 삽입 됌.

@Service //필수 스프링. 안하면 안넣어줌.
public class ScoreController {


    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    //점수 등록 화면 요청
    @GetMapping("/register")
    public String register() {
        log.info("/score/register GET 요청 발생! - ");
        return "score/write-form";
    }

    //점수 정보 저장 요청
    @PostMapping("/register")
    public String register(Score score) {
        log.info("/register POST - " + score);
        scoreService.register(score);
        return "redirect:/score/list"; //리다이렉트 URL
    }

    //점수 전체 조회 요청
    @GetMapping("/list")
    public String list(Model model) {
        List<Score> scoreList = scoreService.getScoreList();
        log.info("/score/list GET 요청! - " + scoreList);
        model.addAttribute("scoreList", scoreList); //write-form에도 출력시키기 위해 model로 호출?
        return "score/write-form";
    }

    //점수 정보 삭제 요청
    @GetMapping("/delete")
    public String delete(int stuNum) {
        log.info("/score/delete GET: " + stuNum);
        scoreService.delete(stuNum);
        return "redirect:/score/list";
    }

    //개인 점수 상세 정보
    @GetMapping("/userinfo")
    public String userinfo(int stuNum, Model model) {
        Score score = scoreService.getScoreOne(stuNum);

        log.info("/score/userinfo POST 요청! - " + score);
        model.addAttribute("name", score.getName());
        model.addAttribute("stuNum", score.getStuNum());
        model.addAttribute("kor", score.getKor());
        model.addAttribute("eng", score.getEng());
        model.addAttribute("math", score.getMath());
        model.addAttribute("total", score.getTotal());
        model.addAttribute("average", score.getAverage());
        return "score/user-info";

    }
}













