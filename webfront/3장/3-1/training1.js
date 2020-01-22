const data = {
    "debug": "on",
    "window": {
        "title": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
    },
    "image": { 
        "src": "Images/Sun.png",
        "name": "sun1",
        "hOffset": 250,
        "vOffset": 250,
        "alignment": "center"
    },
    "text": {
        "data": "Click Here",
        "size": 36,
        "style": "bold",
        "name": "text1",
        "hOffset": 250,
        "vOffset": 100,
        "alignment": "center",
        "onMouseUp": "sun1.opacity = (sun1.opacity / 100) * 90;"
    }
}



function findNumberKey(data, resultArr) {
    
    Object.keys(data).forEach(function (key) {
        if(typeof(data[key]) === "object") {
            findNumberKey(data[key], resultArr);
        } else if(typeof(data[key]) === "number") {
            resultArr.push(key);
        }
    })
}

const resultArr = [];
findNumberKey(data, resultArr);
console.log(resultArr);