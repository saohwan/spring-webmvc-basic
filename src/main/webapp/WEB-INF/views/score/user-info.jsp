<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<style>
    .h1 {
        width: 10px;
        height: 10px;
        background: red;
        color: white;
        border-radius: 5px;
        margin-left: 5px;
    }
</style>
</head>
<body>

    <h1> ${name}님 성적 정보</h1>
    <form action="/score/userinfo" method="post">
        <p>
            # 학번: ${stuNum}
        </p>
        <p>
            # 국어: ${kor}점
        </p>
        <p>
            # 영어:  ${eng}점
        </p>
        <p>
            # 수학: ${math}점
        </p>
        <p>
            # 총점: ${total}점
        </p>
        <p>
            # 평균: ${average}점
        </p>
    </form>

    <hr>

    <ul>
        <a href="/score/list">리스트로 돌아가기</a>
    </ul>

</body>
</html>