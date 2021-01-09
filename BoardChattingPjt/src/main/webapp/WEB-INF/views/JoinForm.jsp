<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	.joinWrapper{
	display: flex;
	justify-content: center;
	text-align: center;
	margin-top: 100px;
	}
	.id_check{
	background-color: #A9BCF5;
	}
	.form-control{
	width: 200px;
	}

	</style>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">

	function checkValue(){
		if(!document.info.id.value){
			alert('아이디를 입력하세요.');
			return false;}
		
		var idChecked = $('#check_hidden').val();
		if(idChecked !="yes"){
			alert('아이디 중복확인을 해주세요.');
			return false;}
		if(!document.info.pw.value){
			alert('비밀번호를 입력하세요.');
			return false;}
		if(!document.info.pw_check.value){
			alert('비밀번호를 동일하게 해주세요.');
			return false;}
		if(!document.info.name){
			alert('이름을 입력해주세요.')
			return false;}
		if(!document.info.mail1){
			alert('이메일을 입력해주세요.')
			return false;}
		if(!document.info.mail2){
			alert('이메일을 입력해주세요.')
			return false;}
		 if(userInfo.phone.value=="") {
           alert("전화번호를 입력해 주세요");
           info.phone.focus();
           return false;
	       }
		}

	function idCheck(){
		var id = $('#id').val();

		$.ajax({
			url : 'http://localhost:8080/idCheck?id='+id,
			type : 'get',
			success : function(data) {
				
				if(data == 1) {
					alert("아이디가 중복됩니다.");
					$('#check_hidden').val("no");
				} else {
					alert("아이디를 사용할 수 있습니다.");
					$('#check_hidden').val("yes");
					}
			},
			error : function(){
				console.log("실패");
				}
			});
		}
	
	
	function check_pw(){
   	 if(document.getElementById('pw').value !='' && document.getElementById('pw_check').value!=''){
             if(document.getElementById('pw').value==document.getElementById('pw_check').value){
                 document.getElementById('check').innerHTML='  일치'
                 document.getElementById('check').style.color='blue';
                 document.getElementById('check').style.fontSize="12px";
             }
             else{
                 document.getElementById('check').innerHTML='  불일치';
                 document.getElementById('check').style.color='red';
                 document.getElementById('check').style.fontSize="12px";
             }
		}
	}

	$(function(){
	$('#selectMail').change(function(){
		var selected = $('#selectMail option:selected').val();
		if( selected =='0'){
			$('#writeMail').show();
		}else{
			$('#writeMail').hide();
			}
		});
	});

	 /*우편번호 찾기 기능*/
    function execDaumPostcode() {
           new daum.Postcode({
               oncomplete: function(data) {
                var addr = ''; 
                   var extraAddr = ''; 
                   if (data.userSelectedType === 'R') { 
                       addr = data.roadAddress;
                   } else { 
                       addr = data.jibunAddress;
                   }

                   if(data.userSelectedType === 'R'){
                       if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                           extraAddr += data.bname;
                       }                    
                       if(data.buildingName !== '' && data.apartment === 'Y'){
                           extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                       }
                       if(extraAddr !== ''){
                           extraAddr = ' (' + extraAddr + ')';
                       }
                       document.getElementById("sample6_extraAddress").value = extraAddr;
                   
                   } else {
                       document.getElementById("sample6_extraAddress").value = '';
                   }
                   document.getElementById('sample6_postcode').value = data.zonecode;
                   document.getElementById("sample6_address").value = addr;
                   document.getElementById("sample6_detailAddress").focus();
               }
           }).open();
       }
	</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/Header.jsp"/>
<div class="joinWrapper">
<div class="joinDiv">

	<form action="joinAction" method="post" name="info" onsubmit="return checkValue()">
		<p>회원가입</p>
		<table>
			<tr>
				 <td colspan="4">
				 	<input class="form-control id" id="id" name="id" type="text" placeholder="아이디">
                 </td>
                 <td>   
	                 <input type="button" class="btn btn-primary id_check" id="input_userId_check" value="중복확인" onclick="idCheck()"> 
	                 <input id="check_hidden" type="hidden" value="no" />
                 </td> 
           </tr>
           <tr>
           		<td colspan="2">
           		<input type="password" class="form-control" name="pw" placeholder="비밀번호" id="pw" onchange="check_pw()"/>
           		</td>
           </tr>
           <tr>
           		<td colspan="2">
           		<input type="password" class="form-control" name="pw_check" placeholder="비밀번호 확인" id="pw_check" onchange="check_pw()"/>
           		</td>
           		<td colspan="1">
           		<span id="check"></span>
           		</td>
           </tr>
           <tr>
                <td colspan="2"> 
                <input class="form-control name"  name="name" type="text" placeholder="이름"> 
                </td>
           </tr> 
           <tr>
           		<td colspan="2">
           		<input type="text" class="form-control" name="phone" id="phone" placeholder="휴대폰번호 - 없이 입력">
           		</td>
           </tr>
           
		   <tr>
		   		<td>	
				<input type="text" class="form-control" name="mail1" id="mail1">
				</td>
				<td colspan="2">
				<select class="form-control" name="mail2" id="selectMail" onchange="selectMail()">
					<option value="1">naver.com</option>
					<option value="2">gmail.com</option>
					<option value="3">hanmail.net</option>
					<option value="4">nate.com</option>
					<option value="0">직접입력</option>
				</select>
				</td>
			</tr>
			<tr>	
				<td colspan="1">
				<span id="writeMail" style="display: none;">
				   <input type="text" class="form-control" name="mail2">
				</span>		
				</td>
		   </tr>
		    <tr>
                <td><input type="text" class="form-control" id="sample6_postcode" name="address1" placeholder="우편번호"></td>
                <td><input type="button" class="form-control searchpostnum" onclick="execDaumPostcode()" value="우편번호 찾기"></button> </td>
             </tr>
             <tr> 
                <td colspan="2"> 
                    <input type="text" class="form-control address" id="sample6_address" name="address2" placeholder="주소">
                </td> 
             </tr> 
              <tr>
                <td colspan="2"> 
                    <input type="text" class="form-control etc" id="sample6_extraAddress" placeholder="참고항목" name="address3">
                </td>
             </tr>
             <tr>
                <td colspan="2"> 
                    <input type="text" class="form-control address_long" id="sample6_detailAddress" name="address4" placeholder="상세주소">
                </td>
             </tr>  
             <td colspan="2">  
                    <input type="submit" class="btn btn-primary" value="가입" style="text-align:center" onsubmit=""> 
                    <input type="button" class="btn btn-primary" value="취소" onclick="location.href='MainForm'" style="margin-left: 5px"> 
             </td>
		</table>
	</form>

</div>
</div>
<jsp:include page="/WEB-INF/views/Footer.jsp"/>		
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
</body>
</html>