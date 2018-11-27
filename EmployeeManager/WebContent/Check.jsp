<%@page import="java.sql.ResultSet"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Điểm danh</title>
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
			                    <li class="menu-style"><a href="/EmployeeManager/IndexEmployee.html">Trang chủ</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/ChagePassEmployee.html">Đổi mật khẩu</a></li><br>
			                    <li class="menu-style"><a href="/EmployeeManager/OfferDayOff.html">Đề xuẩt nghỉ</a></li><br>
			                    <li class="active-menu"><a href="/EmployeeManager/Check.html">Điểm danh</a></li>
			                </ul>
			            </div> 
			        </div>
			    </nav>
			</div>
			<div class="col-sm-10" style="height:600px;background:#eeeeee;">
				<div class="panel panel-success account-session" style="background:#449d44;">
				    <h4 style="text-align:right;color:white;">Hello, <%=request.getSession().getAttribute("username") %>/ <a href="/EmployeeManager/Logout.html" style="color:#86d8fd;">Đăng xuất</a></h4>
				</div>
				<div class="col-sm-12 clear">
				<%ResultSet res = (ResultSet)request.getAttribute("listCheck"); %>
					<div class="panel-group">
		            <div class="panel panel-primary">
		                <div class="panel-heading"><h2>Điểm danh</h2></div>
		                <div class="panel-body">
		                    <table class="table table-hover">
		                    	<thead>
		                    		<tr>
		                    			<th>Time In</th>
		                    			<th>Time Out</th>
		                    		</tr>
		                    	</thead>
		                    	<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
		                    	<%java.text.DateFormat df1 = new java.text.SimpleDateFormat("HH:mm"); %>
		                    	<tbody>
		                    	<%while(res.next()){ %>
		                    		<tr>
		                    			<%String timein = df.format(res.getDate(2))+ " " +df1.format(res.getTime(2)); %>
		                    			<td><%=timein %></td>
		                    			<%if(res.getDate(3) != null){ %>
		                    			<%String timeout = df.format(res.getDate(3))+ " " +df1.format(res.getTime(3)); %>
		                    			<td><%=timeout %></td>
		                    			<%}else %>
		                    			<td></td>
		                    		</tr>
		                    		<%} %>
		                    	</tbody>
		                    </table>
		                </div>
		            </div>
		        </div>
				</div>
				<div class="col-sm-12">
					<%if((int)request.getAttribute("check")==1){ %>
					<form>
						<button class="btn btn-success" formmethod="post">CheckIn</button>
					</form>
					<%}else{ %>
					<form>
						<button class="btn btn-danger" formmethod="post">CheckOut</button>
					</form>
					<%} %>
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