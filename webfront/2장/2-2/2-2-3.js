var el = document.querySelector(".outside");

el.addEventListener("click", function (e) {
    var target = e.target;
    console.log("clicked!!");
    console.log(target.className, target.nodeName)
    console.log(target.innerText);
    debugger;
})