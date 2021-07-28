<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   <h1>사진 전송 페이지</h1>
   <hr/>
   <form method="post" action="/image" enctype="multipart/form-data">
        <input type="file" name="pic"/>
        <button>사진전송</button>
    </form>
    <!-- form은 기본적으로 xwww.form.url.encoded타입으로 들어간다.
         enctype="multipart/form-data" 멀티파트는 폼태그안에 여러가지 데이터타입이 들어갔다라는 뜻이다. 그중 사진도 있다라는 뜻이다.
        쉽게말해 짬뽕 데이터를 보낸다는뜻.
        
        자바스크립트에서는 정확한 데이터타입을 명시해줘야한다.-->
</body>
</html>