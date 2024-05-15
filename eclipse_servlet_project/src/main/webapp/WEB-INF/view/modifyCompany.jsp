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
                  <button onclick="location.href='getCompany.do'" title="ホ-ム">
                     <span><strong>ホ-ム</strong></span>
                  </button>
               </li>
               <li class="n02">
                  <button onclick="location.href='register.do'" title="社員登録">
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

        input[type="text"], input[type="url"], input[type="tel"], input[type="date"] {
            width: calc(100% - 22px); /* width - (padding * 2) - (border * 2) */
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 10px;
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
                  onclick="location.href='employeeList.do'" title="人事管理"><span
                     id="SK02"><strong>人事管理</strong></span></span>
                  <div class='menu_2depth_01_2020' style="z-index: 9999;">
                     <ul class='menu_01'
                        style="display: flex; flex-direction: column;">
                        <li><a href="employeeList.do">社員現況/管理</a></li>
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

<!-- 본인 틀 넣으면됨 -->
<div class="container">
    <!-- 수정 테이블 보여주기, 修正テーブルの表示 -->
    <div id="main_container">
        <!-- 회사 정보 수정 폼, 会社情報修正フォーム -->
        <div class="modify_form_container">
            <h2>会社情報修正</h2>
            <form action="modifyCompany.do" method="post">
            	<input type='hidden' name="companyCode" value="${company.companyCode}">
                <!-- 회사 정보 입력 폼, 会社情報入力フォーム -->

					<p>
						部署コード : <br> <select name="businessTypeCode" required>
							<option value="0" selected disabled hidden>--部署--</option>
							<c:forEach var="businessType" items="${businessTypes}">
								<option value="${businessType.key}"
									${businessType.key == param.businessType ? 'selected' : '' }>
									${businessType.value}</option>
							</c:forEach>
						</select>
						<c:if test="${errors.businessTypeCode}">部署を選択してください。</c:if>
					</p>

					<p>
						部署コード : <br> <select name="businessItemCode" required>
							<option value="0" selected disabled hidden>--部署--</option>
							<c:forEach var="businessItem" items="${businessItems}">
								<option value="${businessItem.key}"
									${businessItem.key == param.businessItem ? 'selected' : '' }>
									${businessItem.value}</option>
							</c:forEach>
						</select>
						<c:if test="${errors.businessItemCode}">部署を選択してください。</c:if>
					</p>
				<label for="companyName">ID:</label>
                <input type="text" id="id" name="id" required value="${ company.id }"><br>
                
				<label for="companyName">Password:</label>
                <input type="text" id="password" name="password" required value="${ company.password }"><br>
                
				<label for="companyName">社名:</label>
                <input type="text" id="companyName" name="companyName" required value="${ company.companyName }"><br>
                
                <label for="ceoName">代表者名:</label>
                <input type="text" id="ceoName" name="ceoName" required value="${ company.ceoName }"><br>

                <label for="businessNumber">事業者番号:</label>
                <input type="text" id="businessNumber" name="businessNumber" required value="${ company.businessNumber }"><br>

                <label for="corporateNumber">法人登録番号:</label>
                <input type="text" id="corporateNumber" name="corporateNumber" required value="${ company.corporateNumber }"><br>

                <label for="establishmentDate">設立日:</label>
                <input type="date" id="establishmentDate" name="establishmentDate" required value="${ company.establishmentDate }"><br>

                <label for="website">ホームページ:</label>
                <input type="text" id="website" name="website" value="${ company.website }"><br>

                <label for="address">事業場の住所:</label>
                <input type="text" id="address" name="address" required value="${ company.address }"><br>

                <label for="phoneNumber">電話番号:</label>
                <input type="tel" id="phoneNumber" name="phoneNumber" required value="${ company.phoneNumber }"><br>

                <label for="faxNumber">ファックス番号:</label>
                <input type="tel" id="faxNumber" name="faxNumber" value="${ company.faxNumber }"><br>

                <!-- 수정 버튼 -->
                <button type="submit">修整</button>
            </form>
        </div>
    </div>
</div>

<script language='Javascript'> 
        
         // 회사 정보로 폼 필드를 채우는 함수
         function fillCompanyForm(companyCode, businessTypeCode, businessItemCode, id, password, registerDate, companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website, address, phoneNumber, faxNumber) {
             document.getElementById("companyCode").value = companyCode;
             document.getElementById("businessTypeCode").value = businessTypeCode;
             document.getElementById("businessItemCode").value = businessItemCode;
             document.getElementById("id").value = id;
             document.getElementById("password").value = password;
             document.getElementById("registerDate").value = registerDate;
             document.getElementById("companyName").value = companyName;
             document.getElementById("ceoName").value = ceoName;
             document.getElementById("businessNumber").value = businessNumber;
             document.getElementById("corporateNumber").value = corporateNumber;
             document.getElementById("establishmentDate").value = establishmentDate;
             document.getElementById("website").value = website;
             document.getElementById("address").value = address;
             document.getElementById("phoneNumber").value = phoneNumber;
             document.getElementById("faxNumber").value = faxNumber;
         }

         // 클릭된 회사 정보를 가져와서 fillCompanyForm 함수를 호출하는 함수
         function handleCompanyClick(companyCode, businessTypeCode, businessItemCode, id, password, registerDate, companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website, address, phoneNumber, faxNumber) {
             fillCompanyForm(companyCode, businessTypeCode, businessItemCode, id, password, registerDate, companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website, address, phoneNumber, faxNumber);
         }
    

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
