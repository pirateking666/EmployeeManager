<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang chủ nhân viên</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/Css/style.css ">
</head>
<body>
	<header>
		<div class="container" style="border:1px solid #dddddd;">
			<div class="row">
				<div class="col-sm-12"><img style="margin-left:auto;margin-right:auto;display:block;" alt="" src="${pageContext.request.contextPath }/Image/header.gif"></div>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-sm-2 clear">
				<nav class="navbar navbar-default clear" role="navigation" style="width:auto;">
			        <div class="container clear">
			            <div class="navbar-header">
			                <button type="button" class="navbar-toggle button-collapse" data-toggle="collapse" data-target="#navbar-left">
			                    <span class="icon-bar"></span>
			                    <span class="icon-bar"></span>
			                    <span class="icon-bar"></span>
			                </button>
			            </div>
			            <div class="collapse navbar-collapse clear" id="navbar-left">
			                <ul class="nav navbar-nav clear">
			                    <li class="active-menu"><a href="/EmployeeManager/IndexEmployee.html">Trang chủ</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/ChagePassEmployee.html">Đổi mật khẩu</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/OfferDayOff.html">Đề xuẩt nghỉ</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/Check.html">Điểm danh</a></li>
			                </ul>
			            </div> 
			        </div>
			    </nav>
			</div>
			<div class="col-sm-10 clear" style="height:800px;background:#eeeeee;">
				<div class="panel panel-success account-session" style="background:#449d44;">
				    <h4 style="text-align:right;color:white;">Hello, <%=request.getSession().getAttribute("username") %>/ <a href="/EmployeeManager/Logout.html" style="color:#86d8fd;">Đăng xuất</a></h4>
				</div>
				<div class="panel-group">
		            <div class="panel panel-primary">
		                <div class="panel-heading"><h2>Trang chủ employee</h2></div>
		                <div class="panel-body">
		                    <h4>- Trang employee với username = <%=session.getAttribute("username") %>.</h4>
		                </div>
		            </div>
		        </div>
			</div>
		</div>
	</div>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-sm-12" style="background: #dddddd;height: 100px;border:1px solid #cccccc;">
					<p style="padding-top: 20px;">Copyright &copy; - NguyenHoangTan</p>
				</div>
			</div>
		</div>
	</footer>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>