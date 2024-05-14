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
				<span style="color: #FFFFFF;">${ authUser.name }株式会社、こんにちは.</span>
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
						<button onclick="location.href='getCompany.do'" home view 넣기"' title="ホ-ム">
							<span><strong>ホ-ム</strong></span>
						</button>
					</li>
					<li class="n02">
						<button onclick="location.href='register.do'" 사원등록 view 넣기"' title="社員登録">
							<span><strong>社員登録</strong></span>
						</button>
					</li>
					<li class="n03">
						<button onclick="location.href='" 사원형황 view 넣기"' title="社員現況">
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
</style>


	<!-- 대메뉴 -->
	<nav>
		<div id="bottom_gnb2017">
			<div id="menu" class="menu2020">
				<ul class="">
					<li class="n01"><span
						style="font-weight: bold; color: #fff; cursor: pointer; font-size: 22px; padding: 15px 15px;"
						onclick="location.href='register.do'" title="基本環境設定"><span
							id="SK01"><strong>基本環境設定</strong></span></span>

						<div class='menu_2depth_01_2020' style="z-index: 9999;">
							<ul class='menu_01'
								style="display: flex; flex-direction: column;">
								<li><a href="getCompany.do">ユーザー情報</a></li>
								<li><a href="register.do">社員登録</a></li>
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

	<section>
		<div id="main_container">
			<div class='sub_titimg'>
				<ul>
					<li class='p_t5'><div align="center">退職対象社員を選択し、退職処理に伴う情報を入力することができます。
							退職社員に分類して、全体の退職社員を見ることができます。</div></li>
				</ul>
			</div>
			<hr>

			<div class='main_titimg wp_100'>

				<div class='e_total'>
					<div id='table1'>
						<p class='caption'></p>
						<ul>
							<li class='w_50 tit'>番号</li>
							<li class='w_102 tit'><strong>社員番号</strong></li>
							<li class='w_100 tit'><strong>氏名</strong></li>
							<li class='w_120 tit'><strong>部署</strong></li>
							<li class='w_120 tit'><strong>役職</strong></li>
							<li class='w_120 tit'><strong>入社日</strong></li>
							<li class='w_120 tit'><strong>退職</strong></li>
						</ul>
						<div id="disContentList" class="disContentList"
							style="width: 1200px;">
							<div id="table_dil_data">
								<c:forEach var="employee" items="${employees}" varStatus="loop">
									<ul id="EM${employee.employeeCode}"
										onClick="$.fn.selUlEmployee(this);" class="anchor">
										<li class='w_50 c'>${loop.index+1}</li>
										<li class='w_102 c'>${employee.employeeCode}</li>
										<li class='w_100 c'>${employee.employeeName}</li>
										<li class='w_120 c'>${employee.department.departmentName}</li>
										<li class='w_120 c'>${employee.position.positionName}</li>
										<li class='w_120 c'>${employee.hireDate}</li>
										<li class='w_120 c'>
											<form action="delete.do" method="post">
												<input type="hidden" name="employeeCode"
													value="${employee.employeeCode}">
												<button type="submit" title="削除">退職</button>
											</form>
										</li>
									</ul>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>

			<script language='Javascript'> 
</script>


			<hr class='hr_50'></hr>
	</section>

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

