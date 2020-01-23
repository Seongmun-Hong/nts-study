const button = document.querySelector("button");
const target = document.querySelector(".outside");

button.addEventListener("click", function(e) {
    var pre = parseInt(target.style.left);
    target.style.left = pre + 100 + "px";
})



