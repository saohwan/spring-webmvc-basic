<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>

<body>
    <h1>mvc폴더의 age.jsp파일입니다.</h1>
    <form action="/mvc/check">
        <label>
            <input type="text" name="age" placeholder="나이를 숫자로 입력하세요!">
        </label>
        <button type="submit">확인</button>
    </form>
</body>

</html>