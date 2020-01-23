let count = 0;
const el = document.querySelector(".outside");
el.style.left = "0px";
el.style.top = "0px";

function run() {
    if(count > 80) return;
    count ++;
    console.log(count);
    el.style.left = parseInt(el.style.left) + 5 + "px";
    requestAnimationFrame(run);
}

requestAnimationFrame(run);

function run2() {
    if(count > 50) return;
    count ++;
    console.log(count);
    el.style.top = parseInt(el.style.top) + 10 + "px";
    requestAnimationFrame(run2);
}

requestAnimationFrame(run);
requestAnimationFrame(run2);