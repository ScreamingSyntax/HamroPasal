console.log("Hello welocme to the world of javascript")

let height = screen.height
let width = screen.width
console.log(height)
console.log(width)

// toggle = () => {
//     var blur = document.getElementById('blur')
//     blur.classList.toggle('active')
// }

var imagefield = document.getElementById("image-field")
var maincontainer = document.getElementById("maincontainer")
var closeButton = document.querySelector(".fa-sharp")
var body = document.querySelector("body")

maincontainer.style.display = 'none'

imagefield.addEventListener("click", ()=>{
    // maincontainer.classList.toggle('active')
    maincontainer.style.display = 'flex'
    body.classList.add('active')
    body.style.backdropFilter = 'blur(5px)'
})

closeButton.addEventListener("click", ()=>{
    maincontainer.style.display = "none"
    body.classList.remove("active")
    body.style.backdropFilter = 'none'
})

