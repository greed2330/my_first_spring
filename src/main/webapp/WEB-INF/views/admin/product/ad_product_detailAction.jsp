<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../common/setting.jsp"%>
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
<link rel="stylesheet"
	href="${path}/resources/css/admin/ad_boardList.css">

<!-- js -->
<script src="https://kit.fontawesome.com/657537baae.js"
	crossorigin="anonymous"></script>

<!-- (3-3-2). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 실행된다. -->
<script src="${path}/resources/js/common/main.js" defer></script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@ include file="../../common/header.jsp"%>
		<!-- header 끝 -->

		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center">상품 상세페이지</h1>
				</div>
				<!-- 상단 중앙1 종료 -->

				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 좌측메뉴 시작 -->
					<%@ include file="../../admin/common/leftMenu.jsp"%>
					<!-- 좌측메뉴 종료 -->

					<!-- 우측화면 시작 -->
					<div id="right">
						<div class="table_div">
						
							<form name="ad_product_add" action="ad_product_updateAction.pd"
								method="post" enctype="multipart/form-data">
								<table>
									<!-- hidden : 직접 input 박스에서 전달받지 못한 값들을 전달할 때 사용 -->
									<input type="hidden" name="hiddenPageNum" value="${pageNum}">
									<input type="hidden" name="hiddenPdNo" value="${dto.pdNo}">
									<input type="hidden" name="hiddenPdImg" value="${dto.pdImg}">
									<tr>
										<th>상품번호</th>
										<td>
											${dto.pdNo}
										</td>
									</tr>
									
									<tr>
										<th>* 브랜드</th>
										<td style="text-align: center"><input type="text"
											class="input" name="pdBrand" id="pdBrand" size="50"
											value="${dto.pdBrand}" placeholder="50자 이내로 작성" required autofocus></td>
									</tr>

									<tr>
										<th>* 상품명</th>
										<td>
											<input type="text" class="input" name="pdName"
											id="pdName" size="50" value="${dto.pdName}" placeholder="50자 이내로 작성" required>
										</td>
									</tr>
									<tr>
										<th>* 상품이미지</th>
										<td>
											<img src="${dto.pdImg}" style="width:100px"><br>
											<input type="file" class="input" name="pdImg" id="pdImg" accept="image/*">
										</td>
									</tr>
									<tr>
										<th>* 상품카테고리</th>
										<td>
											<select class="input" name="pdCategory" id="pdCategory" required>
													<option value="">상품카테고리</option>
													<option <c:if test="${dto.pdCategory =='주방가전'}"> selected </c:if> value="주방가전">주방가전</option>
													<option <c:if test="${dto.pdCategory =='생활가전'}"> selected </c:if> value="생활가전">생활가전</option>
													<option <c:if test="${dto.pdCategory =='휴대폰'}"> selected </c:if> value="휴대폰">휴대폰</option>
											</select>
										</td>
									</tr>

									<tr>
										<th>* 상품설명</th>
										<td>
												<textarea rows="5" cols="77" name="pdContent"
												id="pdContent" placeholder="상품설명 작성">${dto.pdContent}</textarea>
										</td>
									</tr>

									<tr>
										<th>* 상품가격</th>
										<td><input type="number" class="input" name="pdPrice"
											id="pdPrice" size="10" value="${dto.pdPrice}" placeholder="상품가격 작성" required>
										</td>
									</tr>

									<tr>
										<th>* 상품수량</th>
										<td>
											<input type="number" class="input" name="pdQuantity"
											id="pdQuantity" size="10" value="${dto.pdQuantity}" placeholder="상품 수량" required>
										</td>
									</tr>

									<tr>
										<th>* 상품상세코드</th>
										<td>
											<select class="input" name="pdStatus" id="pdStatus" required>
													<option value="">상품상태코드</option>
													<option <c:if test="${dto.pdStatus =='판매중'}"> selected </c:if> value="판매중">판매중</option>
													<option <c:if test="${dto.pdStatus =='입고대기'}"> selected </c:if> value="입고대기">입고대기</option>
													<option <c:if test="${dto.pdStatus =='품절'}"> selected </c:if> value="품절">품절</option>
											</select>
										</td>
									</tr>

									<tr>
										<td colspan="4" style="text-align: center"><br> <!-- 게시글번호 hidden 추가 : input이 없으므로(게시글 번호는 입력받지 않으므로 input이 없음) -->
											<input type="submit" class="inputButton" value="상품수정">
											<input type="button" class="inputButton" value="초기화">
											<input type="button" class="inputButton" value="상품목록"
											onclick="window.location='${path}/ad_product_list.pd'">
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<!-- 우측화면 종료 -->
				</div>
				<!-- 상단 중앙2 종료 -->
			</div>
		</div>

		<!-- 컨텐츠 끝 -->

		<!-- footer 시작 -->
		<%@ include file="../../common/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>