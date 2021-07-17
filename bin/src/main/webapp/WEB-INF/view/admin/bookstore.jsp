<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/admin/bookstore.css" rel="stylesheet">
    <link href="/css/common.css" rel="stylesheet">
    <title>서점 관리 페이지</title>
</head>

<body>
    <main>
        <div class="title">ADMIN</div>
        <nav class="mini-nav">
            <a href=""  class="mini-nav-page">서점</a>
            <a href="">회원</a>
            <a href="">스탬프 투어</a>
            <a href="">후기</a>
            <a href="">해시태그</a>
        </nav>

        
        <section>
            <div class="operation">
                <!--select와 검색 중 하나만 하기 추천
                    둘 다 구현은 너무 번거로움-->
                <select>
                    <option>옵션</option>
                </select>

                <input type="text" name="" value="">
                <a href="" class="btn">검색</a>
            </div>

            <div class="card">
                <div class="card-img"></div>
                <div class="hi-span">
                    <span>서점 이름</span>
                    <span>서점 위치</span>
                    <span>서점 오픈시간</span>
                </div>
                <div class="btn-list">
                    <a href="" class="btn">서점지기 임명</a>
                    <a href="" class="btn">편집</a>
                </div>
            </div>
            </div>
        </section>
    </main>
</body>

</html>