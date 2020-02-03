var data = [{title : "hello",content : "간지철철", price : 12000},
            {title : "crong",content : "괜춘한 상품", price : 5500},
            {title : "codesquad",content : "쩌는상품", price : 1200}];

data.forEach(function (item) {
    // console.log(item.title, item.price);
});


const newData1 = data.map(function (item) {
    const newItem = {price : item.price * 1.1, ...item};
    return newItem;
})

// console.log(data);
// console.log(newData1);

const newData2 = data.filter(function (item) {
    return item.price > 5000;
}).map(function (item) {
    item.price = (''+item.price).replace(/^(\d+)(\d{3})$/, "$1,$2원");
    return item;
})

console.log(newData2);