<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/Include/topmenu.jsp" %>

<html>
<head>
<title>회원등록</title>
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움"; FONT-SIZE:9pt
} 
--->
</STYLE>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>

<script>
	$(function(){
		$("input[name='userid']").on("change", function(){
			var useridExp = /^([a-zA-Z]{1})([a-zA-Z0-9]{5,10})$/;
			var userid = $('#userid').val();
			if(!useridExp.test(userid)){
				userID_c.innerHTML='아이디 형식이 맞지 않습니다.';
				$('#userid').focus();
				return;
			}
			$.ajax({
				url:'id_check_ajax.do',
				type:'post',
				data:{'userid':userid},
				success:function(result){
					if(result==0){
						userID_c.innerHTML='사용가능한 아이디입니다.';
						$('#passwd').focus();
					}else{
						userID_c.innerHTML='중복된  아이디 입니다.';
						$('#userid').val('');
						$('#userid').focus();
					}
				},
				error:function(error){
					alert("error :" + error);
				}
				
			});
			
		});//id 체크끝
		
		//비번 검사
		$("input[name='repasswd']").on("change",function(){
			var passwd = $('#passwd').val();
			var repasswd = $('#repasswd').val();
			if(passwd!=repasswd){
				repasswd_c.innerHTML="비밀번호를 다시입력하세요";
				$('#repasswd').val()='';
				$('#repasswd').focus();
			}else if(passwd==repasswd){
				repasswd_c.innerHTML="비밀번호가 확인되었습니다.";
			}
		});
		
		
	});
	
	
	
	function send(){
		if(user.name.value==""){
			alert("이름을 입력하세요");
			user.name.focus();
			return;
		}
		if(user.tel.value==""){
			alert("전화번호을 입력하세요");
			user.tel.focus();
			return;
		}else if(!tel_check(user.tel.value)){
			alert("전화번호형식오류입니다.");
			user.tel.focus();
			return;
		}
	    // 이메일 유효성 검사
		if(!user.email1.value){ 
			alert("이메일을 입력하세요");
			user.email1.focus();
			return;
		}else if(!user.email2.value && user.email3.value=="0"){
			alert("이메일을 입력 또는 선택하세요");
			user.email2.focus();
			return;
		}else{
			if(user.email3.value!=0){// 선택입력
				user.email2.value=user.email3.value;
			}
		}
		user.action="user_insert_ajax.do";
		user.submit();
	}
	
	//전화번호 유효성 검사
	function tel_check(str){
		/*
		   전화번호 유효성 체크
		   010-xxxx-xxxx 또는  010xxxxxxxx
		  성공이면 true 실패이면 false
		*/
		str=str.split('-').join('');
		var phone=/^(010[0-9]{8})$/;
		return phone.test(str);	
	}
</script>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0  TOPMARGIN=0 >
 
 <!-- 탑 메뉴 영역 삽입-->


<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">
	
	<!--로그인 영역 삽입-->
	<%@ include file="/Include/login_form.jsp" %>
	
  </td>
  <td width="80%" valign="top">&nbsp;<img src="./img/title1.gif" ><br>    
	<form name=user method=post>
	<table border=0 cellpadding=0 cellspacing=0 border=0 width=730 valign=top>
		<tr><td align=center><br>                            
			<table cellpadding=0 cellspacing=0 border=0 width=650 align=center>       
				<tr>
					<td bgcolor="#7AAAD5">            
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b02.gif"></td>
								<td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>사용자등록&nbsp;</b><font color=black>(</font><font color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은 반드시 입력하십시요.)</font></FONT></td>
								<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b03.gif"></td>
							</tr>
						</table>
						<table cellpadding=3 cellspacing=1 border=0 width=100%>
							<tr>
								<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=name size=16 maxlength=20 value="">성명은 빈칸없이 입력하세요.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<table cellspacing=0 cellpadding=0>
										<tr>
											<td align=absmiddle>
												<input type=text name="userid" id="userid" size=12 maxlength=16 value="" style="width:120">
											</td>
											<td id="userID_c"> [5~16자 이내의 영문이나 숫자만 가능합니다.]
                  							</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
								<input type=password name=passwd id="passwd" size=8 maxlength=12 style="width:80">
									6~12자 이내의 영문이나 숫자만 가능합니다.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE><input type=password name=repasswd id="repasswd" size=8 maxlength=12 value="" style="width:80"><font id="repasswd_c" color="red"> 비밀번호 확인을 위해서 비밀번호를 한번 더 입력해주세요.</font> </td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=tel size=13 maxlength=13 value="">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;E-mail
                					<font color=red>&nbsp;</font>
								</td>
								<td bgcolor=WHITE valign=middle>
									<input type="text" name="email1" maxlength="15">
									@ <input type="text" name="email2" maxlength="15">
									<select name="email3">
		      							<option value="0">직접입력</option>
		      							<option value="naver.com">naver.com</option>
		      							<option value="daum.net">daum.net</option>
		      							<option value="nate.com">nate.com</option>
		      							<option value="gmail.com">gmail.com</option>
		  							   </select>
									 <input type="button"  value="인증하기">
								</td>
							</tr>
						</table>
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td valign=bottom>
									<img src="./img/u_b04.gif" align=left hspace=0 vspace=0 border=0>
								</td>
								<td align=center></td>
								<td valign=bottom>
									<img src="./img/u_b05.gif" align=right hspace=0 vspace=0 border=0>
								</td>
							</tr>
							<tr bgcolor=#ffffff>
								<td colspan=3 align=center>
									<img src="./img/u_bt06.gif" vspace=3 border=0 name=img3 onClick="send()">
									<img src="./img/u_bt05.gif" border=0 hspace=10 vspace=3 name=img4>
								</td>
							</tr>
						</table> 
					</td>
				</tr>
				</td>
			</tr>
		</table>
	</form>
	</td>
</tr>
</table>

 <!-- copyright 영역 삽입-->
  

</body>
</html>
