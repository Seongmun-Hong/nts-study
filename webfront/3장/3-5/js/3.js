var log = document.querySelector(".log");
// var lists = document.querySelectorAll("ul > li");

// lists.forEach(function(item) {
//     item.addEventListener("click", function(event) {
//         log.innerHTML = `IMG URL IS ${event.currentTarget.firstElementChild.src}`;
//     })
// });

const ul = document.querySelector("ul");

ul.addEventListener("click", function (event) {
    // log.innerHTML = `CurrentTarget : ${event.currentTarget.tagName} / target : ${event.target.tagName}`;
    const target = event.target;
    if(target.tagName === "IMG") {
        log.innerHTML = `src = ${target.src}`;
    }
})