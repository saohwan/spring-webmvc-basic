package com.spring.mvc.web.score.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class Score {

    //순차적인 학번 부여 필드
    private static int sequence;

    private int stuNum; //학번
    private String name; //이름
    private int kor; //국어점수
    private int eng; //영어점수
    private int math; //수학점수
    private int total; //총점
    private double average; //평균

    public Score() {
        this.stuNum = ++sequence;
    }

    public Score(String name, int kor, int eng, int math) {
        this(); //this.stuNum = ++sequence;를 불러옴
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    //총점, 평균을 구하는 메서드

    public void calcTotalAvg() {
        this.total = kor + eng + math;
        this.average = Math.round((this.total / 3.0) * 100) / 100.0; // 두째짜리까지 표기하고싶으면 이렇게, 세쨋자리까지는 1000곱하고/ 10000.0나누기.
    }
}
