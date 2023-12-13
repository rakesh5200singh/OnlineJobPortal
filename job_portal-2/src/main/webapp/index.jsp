<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/all_css.jsp"%>
<style>
.bg-custom {
	background: #283593
}

.nacbar .nav-item .nav-link {
	font-size: 20px;
	color: white;
}

.navbar .nav-item:hover .nav-link {
	background: white;
	color: black;
	border-radius: 10px;
}

.back-img {
	background: url("img/j1.jpeg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class=text-whitep-4">
				<i class="fa fa-book" aria-hidden="true"></i>Online job portal
			</h1>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>

</body>
</html>