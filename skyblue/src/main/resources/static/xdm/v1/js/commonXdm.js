
// Log In
document.getElementById("loginBtn").onclick = function (){
	$.ajax({
		async: true 
		,cache: false
		,type: "post"
		/* ,dataType:"json" */
		,url: "/v1/infra/customer/customerLoginProc"
		/* ,data : $("#formLogin").serialize() */
		,data : { "id" : $("#id").val(),
			"password" : $("#password").val(),
// 			"autoLogin" : $("#autoLogin").is(":checked")
		}
		,success: function(response) {
			if(response.rt == "success") {
				alert("성공");
					location.href = "/v1/infra/customer/customerXdmMain";
			} else {
				alert("실패");
// 		 		document.getElementById("modalAlertTitle").innerText = "확 인";
// 		 		document.getElementById("modalAlertBody").innerText = "일치하는 회원이 존재 하지 않습니다!";
// 		 		$("#modalAlert").modal("show");
			}
		}
// 		,error : function(jqXHR, textStatus, errorThrown){
// 			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
// 		}
	});
}

// Log Out
document.getElementById("logoutBtn").onclick = function () {
     alert("로그아웃되었습니다");
        $.ajax({  
          async: true   
          ,cache: false
          ,type: "post"
          /* ,dataType:"json" */
          ,url: "/xdm/v1/infra/customer/customerLogoutProc"
          /* ,data : $("#formLogin").serialize() */
          ,success: function(response) {
             if(response.rt == "success") {
                location.href="/xdm/v1/infra/customer/customerLogIn";  
             } else {        
                // by pass  
             }
            }      
           }); // ajax end
 } // logoutBtn end

