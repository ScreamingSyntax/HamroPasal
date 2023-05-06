<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/search.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="${pageContext.request.contextPath}/View/JS/profile.js"></script>
	<style>
	.image-div, .image-text{
	display:flex;
	justify-content:center;
	}
  .user-image {
    border: 1px solid #ccc;
    border-radius: 50%;
    max-width: 100px;
  }
   ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
  }
  
  li {
    display: block;
    margin-bottom: 10px;
    font-size: 18px;
    color: #333;
  }
  
  li:first-child {
    font-weight: bold;
  }
</style>
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
        </header>
 <section class="cart-section">
         <div class="cart-body">
            <div class="body-text">
               <img src="${pageContext.request.contextPath}/View/Images/Cart-Products/1.png" alt="" id="searh-img">
            </div>
			<div class="body-text">
                <h2>Plain Blue Shirt</h2>
            </div>
            <div class="body-text">
                <h2>Rs 8000</h2>
            </div>
            
              <div class="product">
                <span class="add-btn">Add to Cart</span>
            </div>
        </div>
       <div class="cart-body">
            <div class="body-text">
               <img src="${pageContext.request.contextPath}/View/Images/Cart-Products/2.png" alt="" id="searh-img">
            </div>
			<div class="body-text">
                <h2>Sasto Kaalo Dress</h2>
            </div>
            
            <div class="body-text">
                <h2>Rs 3000</h2>
            </div>

            <div class="product">
                <span class="add-btn">Add to Cart</span>
            </div>
        </div>
        <div class="cart-body">
            <div class="body-text">
               <img src="${pageContext.request.contextPath}/View/Images/Cart-Products/3.png" alt="" id="searh-img">
            </div>
			<div class="body-text">
                <h2>Ramro Coat</h2>
            </div>
            
            <div class="body-text">
                <h2>Rs 6000</h2>
            </div>

            <div class="product">
                <span class="add-btn">Add to Cart</span>
            </div>
        </div>
    </section>
</body>
</html>