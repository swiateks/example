<!-- <%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> -->

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
    crossorigin="anonymous"
    >
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"
  >
  <link 
	rel="stylesheet" 
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css"
  >
<link rel="stylesheet" href="style.css" />
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<style>
            #table {
  position: absolute;
  position: center;
  top: 30%;
  left: 10%;
  width: 80%;
  height: 5em;

}
        </style>

<script>
	function ClearFields() {

document.getElementById("name").value = "";
document.getElementById("subject").value = "";
document.getElementById("email").value = "";
document.getElementById("message").value = "";
document.getElementById("message").value = "";

document.getElementById("form1").style.visibility="hidden";
document.getElementById("goBack").style.visibility="visible";
document.getElementById("thank").style.visibility="visible";
}

</script>
<title>Send a message to Renters' Rank!</title>
</head>
	   
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top py-1 fixed-top">
		<div class="container-fluid">
		  <a href="index" class="navbar-brand me-auto">Welcome to equal space.</a>
	  
		  <button
			class="navbar-toggler"
			type="button"
			data-bs-toggle="collapse"
			data-bs-target="#navmenu"
		  >
			<span class="navbar-toggler-icon"></span>
		  </button>
	  
		  <div class="collapse navbar-collapse" id="navmenu">
			<ul class="navbar-nav ms-auto">
			  <li class="nav-item">
				<a href="login.htm" class="nav-link">Login as tennant</a>
			  </li>
			  <li class="nav-item">
				<a href="login.htm" class="nav-link">Login as landlord</a>
			  </li>
			</ul>
		  </div>
		</div>
	  </nav>



	<section class="text-dark p-5 p-lg-0 pt-lg-4 text-center text-m-start">
		<img alt="" src="/images/logo.png" class="col-m-12 img-fluid w-100">
	  </section>

	  <section class="p-5">
		<div  class="container text-center">
		  <div class="row g-5">
			</div>
			<div id="table" class="col-md">
			  <div class="card bg-dark text-light">
				<div class="card-body text-center">
				  <div class="h1 mb-2">
					<i class="bi bi-bug"></i>
				  </div>
				  <h3 class="card-title">
					Write you suggestion</h3><br>
				  <p class="card-text">
					<form action="mailing.php"
					method="POST"
					enctype="multipart/form-data"
					name="EmailForm"
					id="form1">
						<label for="name">Name:</label>
						<input type="text" class="form-control" id="name" name="name" required>
						<br>
						<label for="name">Subject:</label>
						<input type="text" class="form-control" id="subject" name="subject">
						<br>
						<label for="email">Email:</label>
						<input type="email" class="form-control" id="email" name="email" required>
						<br>
						<label for="message">Message:</label>
						<textarea id="message" class="form-control" name="message" placeholder="Be kind :)" rows="5" required></textarea>
						<br>
						<button type="submit" 
						onclick="ClearFields()"
						class="btn btn-primary">Submit</button>
					  </form>
					  <h4 style='visibility:hidden' id="thank">Thank you for the email!</h4>
					  <button type="submit" 
						class="btn btn-primary"
						id="goBack"
						style='visibility:hidden'>Go back</button>
				  </p>
				</div>
			  </div>
			</div>
		  </div>
	  </section>

	  </body>

	  

	  <script
	  src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	  integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	  crossorigin="anonymous"
	  ></script>
	
</body>
</html>