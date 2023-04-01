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
    <link rel="stylesheet" href="./CSS/register.css">
    <link rel="stylesheet" href="./CSS/popup.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
</head>

<body>
    <section class="sign-up" >
        <form action="../registration" method="POST">
            <div class="input-field">
                <h1>Sign Up</h1>
                <span class="name">
                    <label for="name"><i class='bx bx-child'></i></label>
                    <input type="text" id="name" name="name" placeholder="Enter Full Name">
                </span>
                <span class="email">
                    <label for="email"><i class='bx bxl-gmail'></i></label>
                    <input type="text" id="email" name="email"placeholder="Your Email Address">
                </span>
                <span class="password">
                    <label for="password"><i class='bx bx-dialpad-alt'></i></label>
                    <input type="text" id="password" name="password" placeholder="Enter Password">
                </span>
                <span class="confirm-password">
                    <label for="confirm-password"><i class='bx bxs-key'></i></label>
                    <input type="text" name="confirm-password" id="confirm-password" placeholder="Re-Enter Password">
                </span>
                <span class="agreement">
                    <input type="checkbox" id="agreement">
                    <label for="agreement">I agree to all sentences.</label>
                </span>
                <input type="submit" value="Sign Up">

                <div class="login-option">
                    <div class="or">
                        <span></span>
                        <p>Or</p>
                        <span></span>
                    </div>
                    <a href="./login.html" class="login-btn">Log In</a>
                </div>
            </div>

            <div class="image-field" id="image-field">
                <img src="./Images/profile-eg.png" alt="">
                <input type="file" id="file" name="image" onchange="
                    const img = document.querySelector('.image-field img');
                    const name = document.querySelector('#file').value.split('fakepath\\');
                    const path = './Images/'+name[1];
                    console.log(path)
                    img.setAttribute('src', path);
                " accept="Image/*">
                <label for="file" id="upload-btn"><i class='bx bx-cloud-upload'></i>Choose Photo</label>
                <a href="home.html" class="return">Return to Home</a>
            </div>
        </form>
        <!-- <div class="maincontainer" id="maincontainer">
            <i class="fa-sharp fa-solid fa-xmark"></i>
            <h4 class="heading4">Upload Your Profile Image</h4>
            <div class="secondcontainer">
                <i class='bx bx-cloud-upload' id="upload-icon"></i>
                <p class="firstparagraph">Drag and Drop or Browse to Choose a File</p>
            </div>
        </div> -->
    </section>
    <!-- <script src="img.js"></script> -->
</body>

</html>