<%@page import="java.sql.ResultSet"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm nhân viên</title>
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
			                    <li class="menu-style"><a href="/EmployeeManager/IndexAdmin.html">Trang chủ</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/ChangePassAdmin.html">Đổi mật khẩu</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/AcceptDayOffAdmin.html">Duyệt nghỉ phép</a></li><br>
			                    <li class="active-menu"><a href="/EmployeeManager/AddEmployeeAdmin.html">Thêm nhân viên</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/AddEmployeeTypeAdmin.html">Thêm loại NV</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/SalaryAdmin.html">Tính lương</a></li>
			                </ul>
			            </div> 
			        </div>
			    </nav>
			</div>
			<div class="col-sm-10" style="height:auto;background:#eeeeee;">
				<div class="panel panel-success account-session" style="background:#449d44;">
				    <h4 style="text-align:right;color:white;">Hello, <%=request.getSession().getAttribute("username") %>/ <a href="/EmployeeManager/Logout.html" style="color:#86d8fd;">Đăng xuất</a></h4>
				</div>			
				<div class="col-sm-12">
				<div class="col-sm-12" style="height:30px;"></div>
		            <div class="clearfix"></div>
		            <div class="panel-group">
		                <div class="panel panel-primary">
		                    <div class="panel-heading login-header"><h3 style="text-align:center;">Thêm nhân viên</h3></div>
		                    <div class="panel-body">
		                        <form id="change-password-form">
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Tên nhân viên:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="text" name="name" class="form-control" placeholder="Tên nhân viên...">
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Giới tính:</label></div>
		                                <div class="col-sm-7">
		                                    <select name="gender" class="form-control">
		                                    	<option value="Nam">Nam</option>
		                                    	<option value="Nữ">Nữ</option>
		                                    </select>
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Ngày sinh:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="date" name="birth" class="form-control">
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Quê quán:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="text" name="country" class="form-control" placeholder="Quê quán...">
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Địa chỉ:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="text" name="address" class="form-control" placeholder="Địa chỉ...">
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Quyền:</label></div>
		                                <div class="col-sm-7">
		                                    <select name="position" class="form-control">
		                                    	<%ResultSet res = (ResultSet)request.getAttribute("listPosition"); %>
		                                    	<%while (res.next()){ %>
		                                    	<option value="<%=res.getInt(1)%>"><%=res.getString(2) %></option>
		                                    	<%} %>
		                                    </select>
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Tên tài khoản:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="text" name="username" class="form-control" placeholder="Tên tài khoản...">
		                                </div>
		                            </div>
		                            <div class="form-group col-sm-12">
		                                <div class="col-sm-5"><label>Mật khẩu:</label></div>
		                                <div class="col-sm-7">
		                                    <input type="password" name="password" class="form-control" placeholder="Mật khẩu...">
		                                </div>
		                            </div>
		                            <div class="col-sm-12"><button class="btn btn-primary" formmethod="post" style="margin-left:auto;margin-right:auto;display:block;">Thêm nhân viên</button></div>
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