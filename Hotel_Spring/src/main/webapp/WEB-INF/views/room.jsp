<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>객실관리</title>
    
</head>
<!-- 예약관리 Reservation CSS 임포트 -->
<link rel="stylesheet" href="resources/home/css/Reservation.css">
<body>
    <div id="container">
    <header>
        <div id="gnav">
            <ul class="menu">
                <li><a href="room">객실관리</a></li>
                <li><a href="booking">예약관리</a></li>
                <li><a href="logout">로그아웃</a></li>
            </ul>
         </div><!--gnav-->
    </header>

    <main>
        <div class="nav">
            <h2>객실목록</h2>
                <select size="10" style="width:250px;">
                    <c:forEach items="${list}" var="room">
                    	<option value="${room.roomcode}">${room.roomname},${room.typename},${room.howmany},${room.howmuch}</option>
                    </c:forEach>
                </select>
    </div><!-- nav -->
        <div class="choicesystem">
            <div class="room_choice">
                <table class="choices">
                    <tr>
                        <th>객실이름</th>
                        <td><input type="text" name="room_name" size="20"></td>
                    </tr>
                    <tr>
                        <th class="bunlyu">객실분류</th>
                        <td>
                        	<select size="10" style="width:250px;">
                             <c:forEach items="${roomType}" var="room">
                             	<option value="${room.typecode}">${room.name}</option>
                             </c:forEach>
                             </select>
                        </td>
                    </tr>
                    <tr>
                        <th>숙박가능인원</th>
                        <td><input type="number" name="a1" size="20">명</td>
                    </tr>
                    <tr>
                        <th>1박요금</th>
                        <td><input type="text" name="a1" size="20">원</td>
                    </tr>
                </table>
            </div><!-- loom_choice -->
            <div class="btns">
                <input type="reset" value="등록" class="btn btn-check">
                <input type="submit" value="삭제" class="btn btn-delete">
                <input type="submit" value="초기화" class="btn btn-clear">
            </div><!-- btns -->
        </div><!-- choicesystem -->
    </main>
    </div><!--container -->
 
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.ready(function(){
	var list = ${list}.split(",");
	var
})
</html>