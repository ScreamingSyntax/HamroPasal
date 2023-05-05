<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/navbar.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/cart.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
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
                <div class="profile">
                    <a href="${pageContext.request.contextPath}/View/Register.jsp"><img src="${pageContext.request.contextPath}/View/Images/user.png" alt=""></a>
                </div>
            </div>
        </div>
    </header>
	 <section class="cart-section">
        <div class="cart-head">
            <div class="head-text">
                <h2>Product</h2>
            </div>
			<div class="head-text">
                <h2>   </h2>
            </div>
            
            <div class="head-text">
                <h2>Price</h2>
            </div>

            <div class="head-text">
                <h2>Quantity</h2>
            </div>

            <div class="head-text">
                <h2>Subtotal</h2>
            </div>
        </div>
      <hr class="solid">
         <div class="cart-body">
            <div class="body-text">
               <img src="${pageContext.request.contextPath}/View/Images/Cart-Products/1.png" alt="">
            </div>
			<div class="body-text">
                <h2>Plain Blue Shirt</h2>
            </div>
            
            <div class="body-text">
                <h2>Rs 4000</h2>
            </div>

            <div class="body-text">
                <h2>2</h2>
            </div>

            <div class="body-text">
                <h2>Rs 8000</h2>
            </div>
        </div>
       <hr class="solid">
       <div class="cart-body">
            <div class="body-text">
               <img src="${pageContext.request.contextPath}/View/Images/Cart-Products/2.png" alt="">
            </div>
			<div class="body-text">
                <h2>Sasto Kaalo Dress</h2>
            </div>
            
            <div class="body-text">
                <h2>Rs 3000</h2>
            </div>

            <div class="body-text">
                <h2>1</h2>
            </div>

            <div class="body-text">
                <h2>Rs 3000</h2>
            </div>
        </div>
        <hr class="solid">
        <div class="cart-body">
            <div class="body-text">
               <img src="${pageContext.request.contextPath}/View/Images/Cart-Products/3.png" alt="">
            </div>
			<div class="body-text">
                <h2>Ramro Coat</h2>
            </div>
            
            <div class="body-text">
                <h2>Rs 6000</h2>
            </div>

            <div class="body-text">
                <h2>3</h2>
            </div>

            <div class="body-text">
                <h2>Rs 18000</h2>
            </div>
        </div>
        <hr class="solid">
    </section>
</body>
</html>