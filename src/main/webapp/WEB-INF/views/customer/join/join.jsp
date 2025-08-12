<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>

<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/customer/join.css">

<!-- js -->
<script src="https://kit.fontawesome.com/657537baae.js" crossorigin="anonymous"></script>
<!-- 우편번호 서비스 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- (3-3-2). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 실행된다. -->
<script src="${path}/resources/js/common/main.js" defer></script>

<script src="${path}/resources/js/customer/join.js" defer></script>

<script>
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            document.getElementById("all_address").value = roadAddr + data.jibunAddress + data.zonecode;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
</script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@ include file="../../common/header.jsp" %><!-- customer/webapp/common/header.jsp -->
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center">회원가입</h1>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<div id="s2_inner">
						<div class="join">
							<form name="inputform" action="joinAction.do" method="post"
							onsubmit="return signInCheck()">
							
								<!-- 2-1. 중복체크 안했을 시 value = 0 체크하면 value =1 -->
								<input type="hidden" name="hiddenUserid" value="0">
								<table>
									<tr>
										<th> 아이디 * </th>
										<td>
											<input type="text" class="input" name="user_id" 
											size="20" placeholder="공백없이 20자 이내로 작성" required autofocus>
											<input type="button" name="dubChk" value="중복확인" style="margin-left:10px"
											onclick="confirmId()">
										</td>
									</tr>
									
									<tr>
										<th> 비밀번호 * </th>
										<td>
											<input type="password" class="input" name="user_password" 
											size="20" placeholder="공백없이 20자 이내로 작성" required>
										</td>
									</tr>
									
									<tr>
										<th> 비밀번호(확인) * </th>
										<td>
											<input type="password" class="input" name="re_password" 
											size="20" placeholder="비밀번호 확인" required>
										</td>
									</tr>
									
									<tr>
										<th> 이름 * </th>
										<td>
											<input type="text" class="input" name="user_name" 
											size="20" placeholder="이름 작성" required>
										</td>
									</tr>
									
									<tr>
										<th> 생년월일 * </th>
										<td>
											<input type="date" class="input" name="user_birthday" 
											size="8" placeholder="-없이 생년월일 8자리" required>
										</td>
									</tr>
									
									<tr>
										<th> 주소 * </th>
										<td>
											<input type="text" class="input" name="user_address" 
											size="50" placeholder="주소 작성" id="all_address" required>
											<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" required><br>
											<input type="text" name="postcode" id="sample4_postcode" placeholder="우편번호" required>
											<input type="text" name="roadAddress" id="sample4_roadAddress" placeholder="도로명주소" required>
											<input type="text" name="jibunAddress" id="sample4_jibunAddress" placeholder="지번주소" required>
											<span id="guide" style="color:#999;display:none"></span>
											<input type="text" name="detailAddress" id="sample4_detailAddress" placeholder="상세주소(직접입력)" required>
											<input type="text" id="sample4_extraAddress" placeholder="참고항목">
										</td>
									</tr>
									
									<tr>
										<th> 연락처 </th>
										<td>
											<input type="text" class="input" name="user_hp1" 
											size="3" style="width:70px">-
											<input type="text" class="input" name="user_hp2" 
											size="4" style="width:70px">-
											<input type="text" class="input" name="user_hp3" 
											size="4" style="width:70px">
										</td>
									</tr>
									
									<tr>
										<th> 이메일 * </th>
										<td>
											<input type="text" class="input" name="user_email1" 
											size="20" style="width:100px" required>@
											<input type="text" class="input" name="user_email2" 
											size="20" style="width:100px" required>
											
											<select class="input" name="user_email3" 
											 style="width:100px" onchange="seletEmailChk()">
											 	<option value="0">직접입력</option>
											 	<option value="naver.com">네이버</option>
											 	<option value="gmail.com">google</option>
											 	<option value="daum.net">다음</option>
											 	<option value="nate.net">네이트</option>
											 </select>
										</td>
									</tr>
									
									<tr>
										<td colspan="2" style="border-bottom: none">
											<br> 
											<div align="right">
												<input class="inputButton" type="submit" value="회원가입">
												<input class="inputButton" type="reset" value="초기화">
												<input class="inputButton" type="button" value="가입취소" onclick="window.location='main.do'"><!-- controller의 .do로 감. -->
											</div>
										</td>
									</tr>
								</table>
							</form>
						</div>	<!-- join -->
					</div>
				</div>
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<%@ include file="../../common/footer.jsp" %>
		<!-- footer 끝 -->
	</div>
</body>
</html>