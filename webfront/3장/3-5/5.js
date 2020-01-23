const ul = document.querySelector("ul");
const template = document.querySelector("#template-list-item");

// console.log(template.innerHTML);

var data = [
    {title : "hello",content : "content1",price : 2000},
    {title : "world",content : "content2",price : 5000}
];

var resultHTML = "";

String.prototype.interpolate = function(params) {
    const names = Object.keys(params);
    const vals = Object.values(params);
    return new Function(...names, `return \`${this}\`;`)(...vals);
  }

data.forEach(function( {title, content, price }) {
    const template = document.querySelector("#template-list-item");
    const innerHTML = template.innerHTML;

    // resultHTML += innerHTML.replace("${title}", title)
    //     .replace("${content}", content)
    //     .replace("${price}", price);

    // resultHTML +=  eval('`' + `${innerHTML}` + '`');

    // resultHTML += innerHTML.interpolate({title, content, price})
})

ul.innerHTML += resultHTML;