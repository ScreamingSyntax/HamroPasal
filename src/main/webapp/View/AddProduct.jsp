<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>

	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/navb.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/AddProduct.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

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
        <div class="profile-section">
            <div class="top">
                <h1>User Profile</h1>
                <i class='bx bxl-xing'></i>
            </div>
            <div class="middle">
                <a href="#">Login as Admin</a>
                <a href="#">Login as User</a>
            </div>
        </div>
    </header>
    <section class="admin-header">
    	<a href="#">Dashboard</a>
    	<a href="#">Add Product</a>
    	<a href="#">Edit Product</a>
    </section>
    
    <div class="add-product-form">
        <form action="">
            <div class="top">
                <div class="left2">
                    <span>
                        <label for="prod-name">Product Name:</label><br>
                        <input type="text" placeholder="Product Name" id="prod-name" name="prod-name">
                    </span>
    
                    <span>
                        <label for="prod-price">Product Price:</label><br>
                        <input type="number" placeholder="Product Price" id="prod-price" name="prod-price">
                    </span>
    
                    <span>
                        <label for="prod-quantity">Product Quantity:</label><br>
                        <input type="number" placeholder="Product Quantity" id="prod-quantity" name="prod-quantity">
                    </span>
                </div>
                <div class="right2">
                    <label for="prod-image" class="img-section">
                        <img src="" alt="">
                    </label>
                    <input type="file" id="prod-image" name="prod-image">
                </div>
            </div>
            <div class="bottom">
                <button type="submit" value="Add Product">Add Product</button>
                <a href="#">Cancle</a>
            </div>
        </form>
    </div>
</body>
</html>