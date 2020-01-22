var blues = document.querySelectorAll("section .blue");

blues.forEach(function (blue) {
  var parent = blue.closest("section");
  var h2 = parent.querySelector("h2");
  parent.removeChild(h2);
})