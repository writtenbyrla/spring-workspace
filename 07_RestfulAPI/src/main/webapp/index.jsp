<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>휴대전화 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>		
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	<br><hr>
	<h1>휴대전화 정보</h1>
	<form id="phoneFrm">
		모델번호 : <input type="text" name="num" id="num"><br>
		모델명 : <input type="text" name="model" id="model"><br>
		가격 : <input type="text" name="price" id="price"><br>
		제조사 : 
		<select id="vcode" name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select>
		<br>
		<input type="button" value="추가하기" id="insert">
		<input type="button" value="수정하기" id="update">
		<input type="button" value="삭제하기" id="delete">
	</form>
	
	<script>

	function list(){
		$.ajax({
			url: "http://localhost:8080/api/phone",
			type: "GET",
			dataType: 'json',
			
			success: function(data){
				console.log(data);
				
				/* 내가 한 방식
				for(var i=0; i<data.length; i++){
					num = data[i].num;
					model = data[i].model;
					price = data[i].price;
					company = data[i].company;
					vendor = company.vendor;
					
					$('#list').append(
							"<tr>"
							+ "<td>" + num + "</td>"
							+ "<td>" + model + "</td>"
							+ "<td>" + price + "</td>"
							+ "<td>" + vendor + "</td>"
							+ "</tr>"
					)
				}
				*/

				// 선생님 방식
				let html = '';
				for(let phone of data) {
					html += "<tr>"
						+ "<td class=num>" + phone.num + "</td>"
						+ "<td>" + phone.model + "</td>"
						+ "<td>" + phone.price + "</td>"
						+ "<td>" + phone.company.vendor + "</td>"
						+ "</tr>";
				}
				$('#list').append(html);

			},
			error: function(){
				console.log('시스템상 에러 발생!');
			}
	
		});
	}
	list();
	
	// list중 하나 클릭했을 때
	$('#list').on('click', '.num', function(){
		console.log($(this).text());
		
		$.ajax({
			url: "http://localhost:8080/api/phone/" + $(this).text() ,
			type: "GET",
			
			success: function(data){
				console.log(data);
				console.log(data.model);
				$('#num').val(data.num);
				$('#model').val(data.model);
				$('#price').val(data.price);
				$('#vcode').val(data.vcode);
			}
		})	
	});
	
	// 추가
	$('#insert').on('click', function(){
		
		let phone = {
			num: $("#num").val(),
			model: $("#model").val(),
			price: $("#price").val(),
			vcode: $("#vcode").val()
		};
		
		$.ajax({
			url: "http://localhost:8080/api/phone/",
			type: "POST",
			data: JSON.stringify(phone),
			contentType: "application/json",
			dataType: 'json',
			
			success: function(data){
				alert($("#num").val() + ' 추가 완료!');
				$('#list').html('');
				list();
			},
			error: function(){
				console.log('시스템상 에러 발생!');
			}

			})
	});
	
	// 수정
	$('#update').on('click', function(){
		let phone = {
				num: $("#num").val(),
				model: $("#model").val(),
				price: $("#price").val(),
				vcode: $("#vcode").val()};
		
		$.ajax({
			url: "http://localhost:8080/api/phone/",
			type: "PUT",
			data: JSON.stringify(phone),
			contentType: "application/json",
			
			success: function(data){
				alert($("#num").val() + ' 수정 완료!');
				$('#list').html('');
				list();
			},
			error: function(){
				console.log('시스템상 에러 발생!');
			}

			})	
	});
	
	// 삭제
	$('#delete').on('click', function(){
		
		
		$.ajax({
			url: "http://localhost:8080/api/phone/" + $('#num').val(),
			type: "DELETE",

			success: function(){
				alert($('#num').val() + ' 삭제 완료!');
				$('#list').html('');
				list();
			},
			error: function(){
				console.log('시스템상 에러 발생!');
	          },
        });
      });
	
	</script>
</body>
</html>