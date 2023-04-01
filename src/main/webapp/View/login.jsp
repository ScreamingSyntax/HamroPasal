<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/HamroPasal/View/CSS/login.css">
    <link rel="stylesheet"
  href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
</head>
<body>
    <section class="login-form">
        <div class="first">
			
        
            <form action="../login" method="post">
                <div class="mainin">
                <h4><%
			if(request.getAttribute("errorMessage") != null){
				
				out.print(request.getAttribute("errorMessage"));
			}
				
			 %></h4>
                    <h2 class="first-heading">Log In</h2>
                    <input type="text" name="uname" placeholder="Enter Your Username" class="first-input">
                    <input type="text" name="password" placeholder="Enter Password" class="second-input">
                    <button class="first-button">Login</button>
                    <p class="first-para">Don't have an account? <span><a href="Register.jsp">Sign Up<a></a></span></p>
                </div>
            </form>
            <img src="undraw_Fingerprint_login_re_t71l 1 (1).png" alt="" class="first-image">
        </div>
    </section>
</body>
</html>