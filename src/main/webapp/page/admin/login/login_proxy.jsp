<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	 if('${mesg}'!=''){
    		alert('${mesg}');
    	}
        top.location.href = "${pageContext.request.contextPath}/loginAction!showAdminLogin";
    });
</script>
</body>
</html>