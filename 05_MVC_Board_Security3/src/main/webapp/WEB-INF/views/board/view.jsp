<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 사진클릭시 파일 다운로드 -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      h1 {
        margin-top: 70px;
      }
      .form-group {
        margin: 20px 0;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>게시글 정보</h1>
      <form>
        <div class="form-group">
          <label for="title">Title</label>
          <input type="text" name="title" id="title" readonly value ="${vo.title}" class="form-control" />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            name="content"
            id="content"
            class="form-control"
            cols="30"
            rows="10"
            style="resize: none" 
            readonly
          >${vo.content}</textarea>
         <!-- <a href="/board/download?filename=${fn:replace(vo.url, '/upload/', '')}"><img src="${vo.url}"/></a> --> <!-- 사진 클릭하면 다운로드 되도록 -->
       		<a href="${vo.url}" download><img src="${vo.url}"/></a> <!-- html에서 제공하는 다운로드 기능, 안될 때도 있음 -->
        </div>
        <div class="form-group">
          <label for="writer">Writer</label>
          <input type="text" readonly value="${vo.writer}" id="writer" name="writer" class="form-control" />
        </div>
        
        
		<!--
			principal: 계정 정보를 가지고 있음
						만약에 로그인된 정보가 없으면 anonymousUser(문자열)가 들어감
						
			* authorize: 권한부여와 관련된 것
			  authentication: 인증과 관련된 것, 계정 정보		
								
	    	<sec:authentication property="principal" var="info"/>  로그인한 정보 가지고 오기 
	 
	        <c:if test="${vo.writer eq info.username}">   작성자 정보가 일치하는 경우에만 수정 삭제 버튼 보이게 하기
	    	   	<a class="btn btn-outline-warning" href="/board/update?no=${vo.no}">수정</a>
	      		<a class="btn btn-outline-danger" href="/board/delete?no=${vo.no}">삭제</a>
	        </c:if>  
	    -->
	        
	    <!--  anonymouseUser로 조건이 안걸리기 때문에 더 확실한 조건으로 걸어줌 -->    
	    <sec:authorize access="hasRole('ROLE_MEMBER')">   
	    	
	   		<a class="btn btn-outline-warning" href="/board/update?no=${vo.no}">수정</a>
	    	<a class="btn btn-outline-danger" href="/board/delete?no=${vo.no}">삭제</a>
        </sec:authorize>
        
      	<a class="btn btn-outline-warning" href="/board/list">목록으로 돌아가기</a>
      </form>
    </div>
  </body>
</html>
