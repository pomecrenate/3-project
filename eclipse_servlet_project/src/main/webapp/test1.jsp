<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="jp">
<head>
<title>人事管理フェーゾン</title>
<meta charset="utf-8" />
<!--<meta http-equiv="refresh" content="7;URL=http://payzon.co.kr" />-->
<meta name="keywords" content="payzon, 인사관리, 급여관리" />
<meta name="description" content="급여관리 페이존 - 퇴직관리 > 사원퇴직처리" />

<meta name="naver-site-verification"
	content="navercdc5a22c7fcc5c46acb3324a06bc9f11" />
<meta property="og:title" content="페이존 (급여관리 자동화)" />
<meta property="og:type" content="website" />
<!-- <meta property="og:site_name" content="페이존 (급여관리 자동화)" /> -->
<meta property="og:url"
	content="http://www.payzon.co.kr/pzRetirement/retireProcess.php" />
<meta property="og:description" content="급여관리 페이존 - 퇴직관리 > 사원퇴직처리" />
<meta property="og:image"
	content="https://img.payzon.co.kr_guideImg/common/logo.png" />
<!-- <link rel="image_src" href="https://img.payzon.co.kr_guideImg/common/logo.png" /> -->

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/_ssl/style.css" />

<link rel="shortcut icon"
	href="//img.payzon.co.kr/_commonImg/favicon.ico" type="image/x-icon">

<!-- Google CDN jQuery with fallback to local -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>!window.jQuery && document.write(unescape('%3Cscript src="//www.payzon.co.kr/_commonJs/external/jquery-1.11.1.min.js"%3E%3C/script%3E'))</script>

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery-migrate-1.2.1.min.js"></script>
<!-- jquery-migrate-1.1.1.min.js -->

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
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> -->

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery-ui.customer.formUI.js"></script>
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/external/jquery-ui.customer.formUI.css" />

<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery.alphanum.js"></script>

<!-- msDropDown: 선택상자 UI -->
<script type="text/javascript"
	src="//www.payzon.co.kr/_commonJs/external/jquery.dd.js"></script>
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/external/jquery.dd.css" />

<!-- mCustomScrollbar: DIV 스크롤바 -->
<link
	href="//www.payzon.co.kr/_commonCss/external/jquery/scrollbar/jquery.mCustomScrollbar.css"
	rel="stylesheet" />
<script
	src="//www.payzon.co.kr/_commonJs/external/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>

<!-- 라디오버튼 스킨: label_radio r_on -->
<link rel="stylesheet" type="text/css"
	href="//www.payzon.co.kr/_commonCss/external/jquery.maratz.radio.css" />



<!-- <script src="http://www.google.com/jsapi"></script> -->
<script type="text/javascript">
    // 유효성 키
    var setChkMd5;
    setChkMd5 = '7c3fb31cce40534310072ffb2aa028e8';
    var setShortKeyVer = 2;
    var isCuUrl;  // 지금은 제휴중(cu)
    if (document.location.href.split('?')[0].indexOf("cu.payzon.co.kr") > -1 ) isCuUrl = "cu";

    const hiworksLinked = ''; // 가비아 하이웍스 스토어
  </script>

<!-- 지역 스크립트 -->
<!-- <script type="text/javascript" src="//www.payzon.co.kr/pzRetirement/js/pzRetirement.js"></script> -->
<script type="text/javascript" src="/pzRetirement/js/pzRetirement.js"></script>


<!-- 단축 키 설정 -->
<script src="//www.payzon.co.kr/_commonJs/shortKey.js"></script>
</head>
<body>
	<!-- 2021-01-29 -->
	<!-- Global site tag (gtag.js) - Google Analytics -->
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

	<!-- DDN 2017-03-27 이사님요청 -->
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
		<!--  title="TITLE:Basic modal dialog" background-color:red;-->
		<iframe name="iFrmBox" id="iFrmBox" src="" width="100%" height="0px;"
			frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
		<!-- /_commonHTML/ifrmLoading.html -->
		<input type="hidden" id="idLayerDestroyTrigger"
			name="idLayerDestroyTrigger">
		<!-- /_commonHTML/ifrm/ifrmLoading.html -->
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


  // 뷰어 다운
  $.fn.getExcelViewer = function() {
    var setUrl = "/pzServiceManual/php/inManualPdfDownProc.php";
    setUrl += "?setManualCode=EXV";
    setUrl += "&setChkMd5=" + setChkMd5;
    $("#iFrmMulti").attr("src", setUrl);
    return;
  };
  // 페이존 바로가기 다운
  $.fn.getPayzonQuick = function() {
    var setUrl = "/pzServiceManual/php/inManualPdfDownProc.php";
    setUrl += "?setManualCode=QLK";
    setUrl += "&setChkMd5=" + setChkMd5;
    $("#iFrmMulti").attr("src", setUrl);
    return;
  };

</script>

		<div class="jbMenu" style="text-align: left; color: #FFFFFF;">
			<div align="center">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>3チーム</strong>
			</div>
			<a href="/pzServiceGuide/php/inLogoutProc.php?ref=ExZon"><span
				style="color: #FFFFFF;"></span></a>
		</div>
		<div id="main_header">
			<div class="header"
				style="display: flex; justify-content: space-between;">
				<ul class='logo p_t10'>
					<span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						title="[Shift + 1] HOME"><span id="SK01"><strong>人事管理</strong></span></span>
					<a href="/pzServiceInfo/serviceInfo.php?ref=pzLogo"></a>
				</ul>
				<ul class='login_menu' style="margin-top: 5px;">
					<div class='direct'
						style="float: right; display: flex; justify-content: flex-end; margin-left: auto;">
						<!--<span><a href="/pzMyPage/onlineQnAList.php"><span class='direct_c'>온라인 상담실</span></a></span> /pzServiceGuide/customerQnAList.php -->
						<span><a href="/pzServiceGuide/php/inLogoutProc.php"><strong>ログアウト</strong></a></span>
						<span><a
							href="/pzServiceGuide/php/inLogoutProc.php?ref=ExZon"><strong>会員登録</strong></a></span>
						<!-- 2015-01-05 /pzMyPage/myInfo.php 2015-01-19 회원가입(체험존) / 마이페이지 -->
					</div>


				</ul>
			</div>
		</div>



	</header>
	<!-- 아이콘 메뉴 -->

	<!--     <nav>
          <div id='table1'>
           <p class='caption'></p>
           <ul>
             <li class="n01"><a href="/pzServiceInfo/serviceInfo.php?ref=home">HOME</a></li>
             <li class="n02"><a href="/pzPersonnel/employeeIns.php">사원등록</a></li>
             <li class="n03"><a href="/pzPersonnel/employeeMnt.php">사원현황</a></li>
             <li class="n04"><a href="/pzPersonnel/certificatePrintWorking.php">퇴직관리</a></li>
           </ul>
        </div>
    </nav> -->

	<nav>

		<div id="top_gnb_2017">
			<div class="navi_2017">
				<ul class="navi_L_2017">
					<li class="n01">
						<button onclick="location.href='" home view
							넣기"' title="[Shift + 1] HOME">
							<span id="SK01"><strong>ホ-ム</strong></span>
						</button>
					</li>
					<li class="n02">
						<button onclick="location.href='" 사원등록 view
							넣기"' title="[Shift + 2] 사원등록">
							<span id="SK01"><strong>社員登録</strong></span>
						</button>
					</li>
					<li class="n03">
						<button onclick="location.href='" 사원형황 view
							넣기"' title="[Shift + 3] 사원현황">
							<span id="SK01"><strong>社員現況</strong></span>
						</button>
					</li>
					<li class="n04">
						<button onclick="location.href='" 퇴직관리 view
							넣기"' title="[Shift + 4] 퇴직관리">
							<span id="SK01"><strong>退職管理</strong></span>
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
	color: #FFFFFF; /* 수정된 부분 */
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
</style>


	<!-- 대메뉴 -->
	<nav>
		<div id="bottom_gnb2017">
			<div id="menu" class="menu2020">
				<ul class="">
					<!--navi_s의 클래스로 width값 height값 배경색상을 지정해줌 속해있는 li값도 미리 설정-->
					<li class="n01"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='home view 넣기'" title="[Shift + 1] HOME"><span
							id="SK01"><strong>基本環境設定</strong></span></span>

						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="/pzConfig/membersInfo.php">ユーザー情報</a></li>
								<li><a href="/pzPersonnel/employeeIns.php">社員登録</a></li>
							</ul>
						</div> <!--클래스 n01로 속해있는 a태그의 백그라운드 포지션변경-->
					<li class="n02"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='home view 넣기'" title="[Shift + 2] HOME"><span
							id="SK02"><strong>人事管理</strong></span></span>
						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="/pzPersonnel/employeeMnt.php">社員現況/管理</a></li>
							</ul>
						</div> <!--a:hover시엔 top값을 수정해서 사용-->
					<li class="n05"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='home view 넣기'" title="[Shift + 3] HOME"><span
							id="SK03"><strong> 退職管理 </strong></span></span>
						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="/pzRetirement/retireProcess.php">社員 退職処理</a></li>
							</ul>
						</div>
				</ul>
				<!-- // Class: menu_s -->
			</div>
			<!-- // Class: menu -->
		</div>
		<!-- // ID: bottom_gnb -->

	</nav>
	<!-- 2depth 메뉴 -->



	<style>
.menu2020 ul {
	display: flex; /* 아이템들을 가로로 정렬합니다 */
	flex-direction: row; /* 아이템들을 가로로 배치합니다 */
	justify-content: flex-start; /* 아이템들을 왼쪽으로 정렬합니다 */
}

.menu2020 li {
	list-style: none; /* 기본 리스트 마커를 제거합니다 */
	margin-right: 20px; /* 각 아이템 사이의 간격을 설정합니다 */
}
</style>

	<script type="text/javascript">


<!-- 페이지 링크 -->
<div class="paginate">
<a href='#' onClick="msg_pagelink(''); return false;" class='prev'>이전페이지</a> 
<a href="#현재페이지" class="on"><strong>1</strong></a> <a href='#' onClick="msg_pagelink(''); return false;" class='next'>다음페이지</a>
</div>
<!-- 페이지 링크 끝 -->
<script language='Javascript'>
function msg_pagelink(ptype) {
  if(ptype);
  else alert('더 이상 이동할 페이지가 없습니다.');
}
</script>




	<hr class='hr_50'></hr>

	<!-- footer -->
	<footer>
		<div class="jbMenu" style="text-align: left; color: #FFFFFF;">
			<div align="center">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>3チームプロジェクト</strong>
			</div>
			<a href="/pzServiceGuide/php/inLogoutProc.php?ref=ExZon"><span
				style="color: #FFFFFF;"></span></a>
		</div>
	</footer>

</body>
</html>