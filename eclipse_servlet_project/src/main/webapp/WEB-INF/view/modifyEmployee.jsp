<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<html lang="UTF-8">
<head>
<title>退職処理 ＞ 社員退職管理</title>
<meta charset="UTF-8" />
<meta name="keywords" content="payzon, 인사관리, 급여관리" />
<meta name="description" content="급여관리 페이존 - 퇴직관리 > 사원퇴직처리" />

<meta name="naver-site-verification"
	content="navercdc5a22c7fcc5c46acb3324a06bc9f11" />

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/_ssl/style.css" />

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>!window.jQuery && document.write(unescape('%3Cscript src="//www.payzon.co.kr/_commonJs/external/jquery-1.11.1.min.js"%3E%3C/script%3E'))</script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery-migrate-1.2.1.min.js"></script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery.cookie.js"></script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/ajaxFileUpload.js"></script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/common.js?v=20220221"></script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/noticeBrowser.js" defer="defer"></script>

<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/_ssl/external/jquery/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery-ui.js"></script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery-ui.customer.formUI.js"></script>
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/external/jquery-ui.customer.formUI.css" />

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery.alphanum.js"></script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery.dd.js"></script>
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/external/jquery.dd.css" />

<link
	href="//www.payzon.co.kr/_commonCss/external/jquery/scrollbar/jquery.mCustomScrollbar.css"
	rel="stylesheet" />
<script
	src="//www.payzon.co.kr/_commonJs/external/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/external/jquery.maratz.radio.css" />



<script type="text/javascript"> 
    var setChkMd5; 
    setChkMd5 = '7c3fb31cce40534310072ffb2aa028e8'; 
    var setShortKeyVer = 2; 
    var isCuUrl;
    if (document.location.href.split('?')[0].indexOf("cu.payzon.co.kr") > -1 ) isCuUrl = "cu"; 
 
    const hiworksLinked = '';
  </script>

<script type="text/javascript" src="/pzRetirement/js/pzRetirement.js"></script>


<script src="//www.payzon.co.kr/_commonJs/shortKey.js"></script>
</head>
<body>
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-55667387-4"></script>
	<script> 
  window.dataLayer = window.dataLayer || []; 
  function gtag(){dataLayer.push(arguments);} 
  gtag('js', new Date()); 
 
  gtag('config', 'UA-55667387-4'); 
  gtag('config', 'G-CCK8YDQV0H'); 
  </script>

	<script> 
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){ 
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o), 
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m) 
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga'); 
 
  ga('create', 'UA-55667387-4', 'auto'); 
  ga('send', 'pageview'); 
</script>

	<script type="text/javascript"> 
    var roosevelt_params = { 
        retargeting_id:'Q-xRfWi38dMBWz8cmhE3ew00', 
        tag_label:'GXO6C48SRjeVl99UM5Nhng' 
    }; 
</script>
	<script type="text/javascript" charset="UTF-8"
		src="//t1.daumcdn.net/adfit/static/kp.js"></script>
	<script type="text/javascript"> 
      kakaoPixel('1130293680471885162').pageView(); 
</script>
	<script type="text/javascript"
		src="//adimg.daumcdn.net/rt/roosevelt.js" async></script>


	<div id="layerProc" class="disHide"
		style="text-align: center; padding-top: 3px;">
		<iframe name="iFrmBox" id="iFrmBox" src="" width="100%" height="0px;"
			frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
		<input type="hidden" id="idLayerDestroyTrigger"
			name="idLayerDestroyTrigger">
	</div>

	<header>

		<style>
.jbMenu {
	text-align: center;
	color: #ffffa6;
	background-color: #ff4242;
	padding: 6px 0px;
	width: 100%;
}

.jbFixed {
	position: fixed;
	top: 0px;
	z-index: 1;
}
</style>
		<script> 
$( document ).ready( function() { 
  if($( '.jbMenu' ).length > 0){ 
    var jbOffset = $( '.jbMenu' ).offset(); 
    $( window ).scroll( function() { 
      if ( $( document ).scrollTop() > jbOffset.top ) { 
        $( '.jbMenu' ).addClass( 'jbFixed' ); 
      } 
      else { 
        $( '.jbMenu' ).removeClass( 'jbFixed' ); 
      } 
    }); 
  } 
 
}); 
  
 
</script>

		<div class="jbMenu" style="text-align: left; color: #FFFFFF;">
			<div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3チーム
				이예찬,노대성,이택훈,김상원,홍종우</div>
			<span style="color: #FFFFFF;"></span></a>
		</div>
		<div id="main_header">
			<div class="header">
				<ul class='logo p_t10'>
				</ul>
				<ul class='login_menu'>
					<div class='direct'>
						<u:isLogin>
							<span><a href=logout.do>ログアウト</a></span>
						</u:isLogin>
						<u:notLogin>
							<span><a href=join.do>社員登録</a></span>
							<span><a href=login.do>ログイン</a></span>
						</u:notLogin>
					</div>
				</ul>
			</div>
		</div>
	</header>
	<!-- 아이콘 메뉴 -->

	<nav>

		<div id="top_gnb_2017">
			<div class="navi_2017">
				<ul class="navi_L_2017">
					<li class="n01">
						<button onclick="location.href='" home view 넣기"' title="ホ-ム">
							<span><strong>ホ-ム</strong></span>
						</button>
					</li>
					<li class="n02">
						<button onclick="location.href='" 사원등록 view 넣기"' title="社員登録">
							<span><strong>社員登録</strong></span>
						</button>
					</li>
					<li class="n03">
						<button onclick="location.href='employeeList.do'" title="社員現況">
							<span><strong>社員現況</strong></span>
						</button>
					</li>
					<li class="n04">
						<button onclick="location.href='deleteList.do'" title="退職管理">
							<span><strong>退職管理</strong></span>
						</button>
					</li>

				</ul>
			</div>
		</div>

	</nav>


	<style>
.navi_L_2017 button {
	width: 80px;
	height: 67px;
	padding: 0 20px;
	background: linear-gradient(#3A79C4, #9DCFFF);
	border-radius: 7px;
	color: color: fffffff;
}
</style>


	<style>
body {
	margin: 0;
}

.disContentList {
	height: 330px;
	width: 696px;
	overflow: auto;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

input[type=text]:-ms-clear {
	display: none;
}

input[type=text]::-ms-clear {
	display: none;
}

<!--
수정 테이블 보여주기 -->body {
	margin: 0;
	font-family: Arial, sans-serif;
}

.container {
	width: 80%;
	margin: 0 auto;
	padding-top: 50px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

input[type="submit"] {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>


	<!-- 대메뉴 -->
	<nav>
		<div id="bottom_gnb2017">
			<div id="menu" class="menu2020">
				<ul class="">
					<li class="n01"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='home view 넣기'" title="基本環境設定"><span
							id="SK01"><strong>基本環境設定</strong></span></span>

						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="/pzConfig/membersInfo.php">ユーザー情報</a></li>
								<li><a href="/pzPersonnel/employeeIns.php">社員登録</a></li>
							</ul>
						</div>
					<li class="n02"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='home view 넣기'" title="人事管理"><span
							id="SK02"><strong>人事管理</strong></span></span>
						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="/pzPersonnel/employeeMnt.php">社員現況/管理</a></li>
							</ul>
						</div>
					<li class="n03"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='deleteList.do'" title="退職管理"><span
							id="SK03"><strong>退職管理</strong></span></span>
						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="deleteList.do">社員 退職処理</a></li>
							</ul>
						</div>
				</ul>
			</div>
		</div>

	</nav>

	<style>
.menu2020 ul {
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
}

.menu2020 li {
	list-style: none;
	margin-right: 20px;
}
</style>


	<script type="text/javascript">
</script>
	<style>
form {
	background-color: #ffffff;
	border-radius: 8px;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 400px;
	display: flex;
	justify-content: center;
	align-items: center;
}

p {
	margin-bottom: 15px;
}

input[type="text"], input[type="password"], input[type="submit"] {
	width: calc(100% - 22px); /* 너비 조정 */
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

select {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.error {
	color: red;
}
</style>
	<style>
.form-container {
	display: flex;
	justify-content: space-between;
}

.form-container .left-column, .form-container .right-column {
	width: 45%; /* 좌우 여백을 주기 위해 45%로 설정합니다. */
}
</style>
<body>
	<h2>Employee Information</h2>
	<form action="modifyEmployee.do" method="post">
		<div class="form-container">
			<div class="left-column">
				<p>
					部署コード : <br> <select name="departmentCode" required>
						<option value="0" selected disabled hidden>--部署--</option>
						<c:forEach var="department" items="${departmentCodes}">
							<option value="${department.key}"
								${department.key == param.departmentCode ? 'selected' : '' }>
								${department.value}</option>
						</c:forEach>
					</select>
					<c:if test="${errors.departmentCode}">部署を選択してください。</c:if>
					선택된 값 : <span id="selectedDepartment"></span>
				</p>
				<p>
					職位コード : <br> <select name="positionCode" required>
						<option value="0" selected disabled hidden>--職位--</option>
						<c:forEach var="position" items="${positionCodes}">
							<option value="${position.key}"
								${position.key == param.positionCode ? 'selected' : '' }>
								${position.value}</option>
						</c:forEach>
					</select>
					<c:if test="${errors.positionCode}">職位を選択してください。</c:if>
					선택된 값 : <span id="selectedPosition"></span>
				</p>
				<p>
					社員名 : <br> <input type="text" name="employeeName" value="${ employee.employeeName }">
					<c:if test="${errors.employeeName}">
						<span class="error">社員名を入力してください。</span>
					</c:if>
					<br>
				</p>
				<br>
				<p>
					雇用形態 : <br> 
						<select name="employmentType" required>
							    <option value="0" selected disabled hidden>--雇用形態--</option>
								<option value="正社員">正社員</option>
								<option value="契約職">契約職</option>
								<option value="臨時職">臨時職</option>
								<option value="派遣職">派遣職</option>
								<option value="委嘱職">委嘱職</option>
								<option value="日雇い">日雇い</option>
					</select>
					 <input type="hidden" id="selectedValueInput" name="selectedValue">
								선택된 값 :<span id="selectedValue"></span>
					
					<%-- <select name="employmentTypeCode">
						<option value="0">--雇用形態--</option>
						<c:forEach var="employmentType" items="${positionCodes}">
							<option value="${employmentType.key}"
								${employmentType.key == param.employmentType ? 'selected' : '' }>
								${employmentType.value}</option>
						</c:forEach>
					</select> --%>
				</p>
				<br>
			</div>
			<div class="right-column">
				<p>
					居所 : <br> <input type="text" name="address" value="${ employee.address }">
					<c:if test="${errors.address}">
						<span class="error">居所を入力してください。</span>
					</c:if>
					<br>
				</p>
				<br>
				<p>
					電話番號 : <br> <input type="text" name="phoneNumber" value="${ employee.phoneNumber }" width="1000">
					<c:if test="${errors.phoneNumber}">
						<span class="error">電話番號を入力してください。</span>
					</c:if>
					<br>
				</p>
				<br>
				<p>
					メール : <br> <input type="text" name="email" value="${ employee.email }">
					<c:if test="${errors.email}">
						<span class="error">メールを入力してください。</span>
					</c:if>
					<br>
				</p>
				<br>
				<p>
					入社日 : <br> <input type="date" name="hireDate" value="${ employee.hireDate }">
					<c:if test="${errors.hireDate}">
						<span class="error">入社日を入力してください。</span>
					</c:if>
					<br>
				</p>
				<br>

			</div>
		</div>
		<input type="hidden" name="employeeCode"
			value="${ param.employeeCode }">
		<input type="submit" value="修整">
	</form>
	<br>

</body>
<script>
    // 페이지가 로드될 때 실행되는 함수
    window.onload = function() {
        // 드롭다운 메뉴에서 선택된 값이 변경될 때마다 실행되는 함수
        document.getElementsByName("departmentCode")[0].onchange = function() {
            // 선택된 옵션의 인덱스(index)를 가져옴
            var selectedIndex = this.selectedIndex;
            // 선택된 옵션의 텍스트를 가져옴
            var selectedText = this.options[selectedIndex].text;
            // 선택된 값을 표시하는 span 요소를 가져와서 선택된 텍스트로 업데이트
            console.log("Selected department:", selectedText);
            document.getElementById("selectedDepartment").innerText = selectedText;
        };
      	 document.getElementsByName("positionCode")[0].onchange = function() {
             // 선택된 옵션의 인덱스(index)를 가져옴
             var selectedIndex = this.selectedIndex;
             // 선택된 옵션의 텍스트를 가져옴
             var selectedText = this.options[selectedIndex].text;
             // 선택된 값을 표시하는 span 요소를 가져와서 선택된 텍스트로 업데이트
              console.log("Selected position:", selectedText);
             document.getElementById("selectedPosition").innerText = selectedText;
         };
      	 document.getElementsByName("selectedEmploymentTypeCode")[0].onchange = function() {
             // 선택된 옵션의 인덱스(index)를 가져옴
             var selectedIndex = this.selectedIndex;
             // 선택된 옵션의 텍스트를 가져옴
             var selectedText = this.options[selectedIndex].text;
             // 선택된 값을 표시하는 span 요소를 가져와서 선택된 텍스트로 업데이트
              console.log("Selected employmentTypeCode:", selectedText);
             document.getElementById("selectedEmploymentTypeCode").innerText = selectedText;
         };
    };
    
    function saveSelectedValue() {
        var selectElement = document.getElementById("employmentType");
        var selectedValue = selectElement.options[selectElement.selectedIndex].text;
        document.getElementById("selectedValueInput").value = selectedValue;
    }
</script>


<!-- footer -->
<footer>
	<div class="jbMenu" style="text-align: left; color: #FFFFFF;">
		<div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3チームプロジェクト</div>
		<a href="/pzServiceGuide/php/inLogoutProc.php?ref=ExZon"><span
			style="color: #FFFFFF;"></span></a>
	</div>
</footer>

</body>
</html>
