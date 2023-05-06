<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/navbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="${pageContext.request.contextPath}/View/JS/profile.js"></script>
</head>
<body>
    <header>
        <span class="logo">Hamro&nbsp;Pasal</span>
        <div class="right">
            <select name="category" id="category">
                <option value="all">Categories</option>
                <option value="shirt">Shirt</option>
                <option value="pants">Pants</option>
                <option value="shoes">Shoes</option>
            </select>
            <form action="" class="search-bar">
                <input type="text" class="search-field" placeholder="Search this Website">
                <input type="submit" id="search">
                <label for="search"><i class='bx bx-search-alt-2'></i></label>
            </form>
            <div class="icons">
                <div class="cart">
                    <img src="${pageContext.request.contextPath}/View/Images/shopping-cart.png" alt="">
                </div>
                <div class="profile" onclick="profileClicked()">
                    <a href="#"><img src="${pageContext.request.contextPath}/View/Images/user.png" alt=""></a>
                </div>
            </div>
        </div>
        <div class="profile-section">
        	<div class="top">
                <h1>User Profile</h1>
                <i class='bx bxl-xing' onclick="profileClicked()"></i>
            </div>
        	<% String email=null;
        	if(session.getAttribute("loggedInId") == null){ 
        	%>
            	<div class="middle">
	                <a href="${pageContext.request.contextPath}/View/AdminLogin.jsp">Login as Admin</a>
                	<a href="${pageContext.request.contextPath}/View/Login.jsp">Login as User</a>
            	</div>
        	<%} else{
        		email = session.getAttribute("loggedInId").toString();
        	%>
        		<h1>You are Logged In as<%= email %></h1>
        		<%if(session.getAttribute("adminEmail") != null){%>
        			<a href="${pageContext.request.contextPath}/index.jsp">Return to Home</a>
        			<a href="${pageContext.request.contextPath}/View/AdminPage.jsp">Admin Page</a>
        		<%}%>
        		<button onclick='logoutClicked()'>Log Out</button>
        	<%} %>
        	
        </div>
        <script>
            const profileClicked = () =>{
                const btn = document.querySelector(".profile")
                const mainDiv = document.querySelector(".profile-section")
                const cross = document.querySelector(".profile-section .top i")
                btn.addEventListener("click", ()=>{
                    mainDiv.classList.add("active");
                })
                cross.addEventListener("click", ()=>{
                    mainDiv.classList.remove("active");
                })
            }
            
            const logoutClicked = () =>{
            	<%session.removeAttribute("loggedInId"); 
            	  session.removeAttribute("adminEmail");
            	%>
            	window.location.href = "index.jsp";
            }
        </script>
    </header>

    <section class="banner">
        <img src="${pageContext.request.contextPath}/View/Images/banner.gif" alt="">
    </section>

    <section class="products-section">
        <h2>Products</h2>
        <div class="products">
        	<c:forEach var="pd" items="${productList}">
      
				<div class="product">
                	<img src="${pageContext.request.contextPath}/Images/${pd.productImagePath}" alt="${pd.productName}">
                	<p>${pd.productName}</p>
                	<span>${pd.productPrice }</span>
           
                	<a href="${pageContext.request.contextPath}/addCart?imagePath=${pd.productImagePath}&email=<%=email %>"><span class="add-btn">Add to Cart</span></a>
            	</div>
			</c:forEach>
        </div>
        <a href="./products.html" class="view-more-btn">View More -></a>
    </section>
    
</body>
</html>