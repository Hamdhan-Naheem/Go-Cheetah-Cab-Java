<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DarkPan - Bootstrap 5 Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Go Cheetah Cab</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">Owner</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="index.html" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>User Custom</a>
                        <div class="dropdown-menu bg-transparent border-0">
                            <a href="add_view?action=all" class="dropdown-item">Customer</a>
                            <a href="driver_view?action=all" class="dropdown-item">Driver</a>
                            <a href="vehicle_view?action=all" class="dropdown-item">Vehicle</a>
                            <a href="element.html" class="dropdown-item">Branch</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <form class="d-none d-md-flex ms-4">
                    <input class="form-control bg-dark border-0" type="search" placeholder="Search">
                </form>
                <div class="navbar-nav align-items-center ms-auto">
                   
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">Admin</span>
                        </a>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->
   <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <span class="d-none d-lg-inline-flex">GO Cheeta Customer Details</span>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-white">
									<th scope="col">Customer ID</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Phone Number</th>
									<th scope="col">Age</th>
									<th scope="col">Password</th>
                                </tr>
                            </thead>
                            <tbody>
                               
                           <tag:forEach var="cust" items="${customerAll}">
								<tr>
									<td>${cust.getId()}</td>
									<td>${cust.getUsername()}</td>
									<td>${cust.getEmail()}</td>
									<td>${cust.getPhoneNo()}</td>
									<td>${cust.getAge()}</td>
									<td>${cust.getPassword()}</td>
			
								</tr>
							</tag:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Customer Start -->
           
            <!-- Customer End -->
            


            <!-- Driver details -->
            
            <p>${message}</p>
	<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
	
	<div class="container">
		<div>
			<a href="addDriver.jsp"><button type="submit" class="btn btn-primary">
					Add Driver</button></a>
		</div>
	</div>
	<br />
	<br />
          
            <!-- Driver End -->


            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-white">
                                    <th scope="col">Driver ID</th>
									<th scope="col">Driver Name</th>
									<th scope="col">Driver Age</th>
									<th scope="col">Driver Email</th>
									<th scope="col">Driver PhoneNO</th>
									<th scope="col">Branch Id</th>
									<th scope="col">Password</th>
                                </tr>
                            </thead>
                            <tbody>
                               
                            <tag:forEach var="drv" items="${driverList}">
							<tr>
								<td>${drv.getD_id()}</td>
								<td>${drv.getUsername()}</td>
								<td>${drv.getAge()}</td>
								<td>${drv.getEmail()}</td>
								<td>${drv.getPhoneNo()}</td>
								<td>${drv.getBranchId()}</td>
								<td>${drv.getPassword()}</td>
								<td>
									<form action="editDriver.jsp" method="post">
										<input type="hidden" name="D_id" value="${drv.getD_id()}">
										<input type="hidden" name="name" value="${drv.getUsername()}">
										<input type="hidden" name="age" value="${drv.getAge()}">
										<input type="hidden" name="email" value="${drv.getEmail()}">
										<input type="hidden" name="phone" value="${drv.getPhoneNo()}">
										<input type="hidden" name="branchid" value="${drv.getBranchId()}">
										<input type="hidden" name="password" value="${drv.getPassword()}">
										<button type="submit" class="btn btn-success">Edit</button>
									</form>
								</td>
								<td>
									<form action="driver_delete" method="post">
										<input type="hidden" name="action" value="delete"> <input
											type="hidden" name="D_id" value="${drv.getD_id()}">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
								</td>
		
							</tr>
							</tag:forEach> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->
            
     <p>${message}</p>
	<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
	
	<div class="container">
		<div>
			<a href="addVehicle.jsp"><button type="submit" class="btn btn-primary">
					Add Vehicle</button></a>
		</div>
	</div>
	<br />
	<br />
	
	           <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-white">
                                    <th scope="col">Vehicle ID</th>
									<th scope="col">Vehicle Type</th>
									<th scope="col">Vehicle Name</th>
                                </tr>
                            </thead>
                            <tbody>
                               
                            <tag:forEach var="veh" items="${VehicleList}">
							<tr>
								<td>${veh.getV_id()}</td>
								<td>${veh.getV_type()}</td>
								<td>${veh.getV_name()}</td>
								<td>
									<form action="editVehicle.jsp" method="post">
										<input type="hidden" name="V_id" value="${veh.getV_id()}">
										<input type="hidden" name="V_type" value="${veh.getV_type()}">
										<input type="hidden" name="V_name" value="${veh.getV_name()}">
										<button type="submit" class="btn btn-success">Edit</button>
									</form>
								</td>
								<td>
									<form action="vehicle_delete" method="post">
										<input type="hidden" name="action" value="delete"> <input
											type="hidden" name="V_id" value="${veh.getV_id()}">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
								</td>
		
							</tr>
							</tag:forEach> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
	
	


            <!-- Widgets Start -->
            <!-- Widgets End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                            <br>Distributed By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>