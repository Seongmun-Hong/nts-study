var data = [{
                title : "hello",
                content: "world",
                price: 200
            },
            {
                title : "hello",
                content: "world",
                price: 200
            }];

var html = "<li><h4>{title}</h4><p>{content}</p><div>{price}</div></li>";

html.replace("{title}", data.title)
    .replace("{content}", data.content)
    .replace("{price}", data.price)