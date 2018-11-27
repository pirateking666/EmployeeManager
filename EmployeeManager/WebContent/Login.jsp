<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng nhập</title>
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
			                    <li class="menu-style"><a href="/EmployeeManager/Index.html">Trang chủ</a></li><br>
			                    <li class="active-menu"><a href="/EmployeeManager/Login.html">Đăng nhập</a></li>
			                </ul>
			            </div> 
			        </div>
			    </nav>
			</div>
			<div class="col-sm-10" style="height:800px;background:#eeeeee;">
				<div class="col-sm-12">
		            <div class="clearfix"></div>
		            	<div class="panel-group login-box">
		                <div class="panel panel-primary">
		                    <div class="panel-heading login-header"><h3 id="login-header-text">Đăng nhập</h3></div>
		                    <div class="panel-body">
		                        <form id="login-form">
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Tên đăng nhập:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="text" name="username" class="form-control" placeholder="Tên tài khoản..." autofocus>
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Mật khẩu:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="password" name="password" class="form-control" placeholder="Mật khẩu...">
		                                </div>
		                            </div>
		                            <div class="col-sm-12">
		                            	<button class="btn btn-primary button-submit" formmethod="post" style="margin-left:auto;margin-right:auto;display:block;">Đăng nhập</button>
		                            </div>
		                        </form>
		                    </div>
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