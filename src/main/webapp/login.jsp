<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">

<link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>

	<div class="container px-4 py-5 mx-auto">
		<div class="card card0">
			<div class="d-flex flex-lg-row flex-column-reverse">
				<div class="card card1">
					<div class="row justify-content-center my-auto">
						<div class="col-md-8 col-10 my-5">
							
							<h3 class="mb-5 text-center heading">We are Go Cheeta</h3>

							<h6 class="msg-info">Please login to your account</h6>
							
							<form name="myForm" method="post" action="login" class="register-form"
							id="login-form">

							<div class="form-group">
								<label class="form-control-label text-muted">Username</label> <input
									type="text" id="usename" name="usename"
									placeholder="username" class="form-control">
							</div>

							<div class="form-group">
								<label class="form-control-label text-muted">Password</label> <input
									type="password" id="psw" name="psw" placeholder="Password"
									class="form-control">
							</div>

							<div class="row justify-content-center my-3 px-3">
								<button class="btn-block btn-color">Login</button>
							</div>
							</form>

							<div class="row justify-content-center my-2">
								<a href="#"><small class="text-muted">Forgot
										Password?</small></a>
							</div>
						</div>
					</div>
					<div class="bottom text-center mb-5">
						<a href="register.jsp" class="sm-text mx-auto mb-3">
							Don't have an account?
							<button class="btn btn-white ml-2">Create new</button>
						</a>
					</div>
				
				</div>
			</div>
		</div>
	</div>

</body>
</html>