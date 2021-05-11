package com.spring.mvc.web.score.service;

import com.spring.mvc.web.score.domain.Score;
import com.spring.mvc.web.score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public void register(Score score) {
        score.calcTotalAvg(); //DB에 넣기전에 총점 평균을 도메인에서 불러와 아래로 save
        scoreRepository.save(score);
    }
    
    //점수 리스트를 받아오는 기능
    public List<Score> getScoreList() {
        return scoreRepository.findAll();
    }

    //점수 정보 삭제 기능
    public void delete(int stuNum) {
        scoreRepository.remove(stuNum);
    }

    //개인 상세 정보 받오기
    public Score getScoreOne(int stuNum) {
        return scoreRepository.findOne(stuNum);
    }

}
