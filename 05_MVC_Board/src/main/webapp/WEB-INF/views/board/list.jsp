<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html data-bs-theme="dark">
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <style>
      .header {
        display: flex;
        justify-content: space-between;
        align-items: flex-end;
      }
      h1 {
        margin-top: 70px;
      }
      .pagination {
        display: flex;
        justify-content: center;
      }

     
    </style>
  </head>
  <body>
    <div class="container">
      <div class="header">
        <h1>List Page</h1>
        <a href="/board/insert" class="btn btn-outline-warning">게시글 등록</a>
      </div>

      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${list}" var="board">
            <tr>
              <td>${board.num}</td>
              <td><a href="/board/view?no=${board.no}">${board.title}</a></td>
              <td>${board.writer}</td>
              <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            	<!-- 날짜 형식 바꿈(상단 taglib 추가해야함) -->
            </tr>
          </c:forEach>
        </tbody>
      </table>

      <nav aria-label="Page navigation">
        <ul class="pagination">
        	
        	<!-- prev 버튼 -->
        	<!-- 이전페이지 true인 경우(시작페이지가 1이 아닌 경우) -->
        	<!-- startPage가 11인 경우 이전페이지 버튼 누르면 10페이지로 이동 -->
        	<c:if test="${paging.prev}">
        		<li class="page-item">
        			<a class="page-link" href="/board/list?page=${paging.startPage-1}">이전 페이지</a>
        		</li>
        	</c:if>
        	
        	<!-- 버튼 시작페이지~엔드페이지 10개씩 보여주기(반복문) -->
        	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
        		<li class="page-item">
           			 <a class="page-link ${paging.cri.page == num? 'active' : '' }" href="/board/list?page=${num}">${num}</a>
          		</li>
        	</c:forEach>
        	
        	<!-- next 버튼 -->
        	<!-- endPage가 lastPage보다 작은 경우 -->
        	<!-- endPage가 20일 경우 다음페이지 누르면 21페이지로 이동 -->
        	<c:if test="${paging.next}">
        		<li class="page-item">
        			<a class="page-link" href="/board/list?page=${paging.endPage+1}">다음 페이지</a>
        		</li>
        	</c:if>
        </ul>
      </nav>
    </div>
    

  </body>
</html>
