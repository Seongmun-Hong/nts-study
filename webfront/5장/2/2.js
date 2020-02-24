// console.log("123-123".match(/\d\d\d-\d\d\d/));
// console.log("123-123".match(/\d{3}-\d{3}/));
// console.log("12345".match(/\d{5}/));

// console.log("12345".match(/(\d{5}|\d{3}-\d{3})/));
// console.log("123-456".match(/(\d{5}|\d{3}-\d{3})/));

// // 5자리인 경우 첫자리가 9가 되면 안된다.
// console.log("92405".match(/([012345678]\d{4}|\d{3}-\d{3})/));
// console.log("92405".match(/([0-8]\d{4}|\d{3}-\d{3})/));
// console.log("42405".match(/([0-8]\d{4}|\d{3}-\d{3})/));

// // 5자리인 경우 첫자리 5, 9 안된다.
// console.log("92405".match(/([0-46-8]\d{4}|\d{3}-\d{3})/));
// console.log("12405".match(/([0-46-8]\d{4}|\d{3}-\d{3})/));
// console.log("52405".match(/([0-46-8]\d{4}|\d{3}-\d{3})/));

// 핸드폰

console.log("010-6374-6244".match(/(01[01689]-\d{3,4}-\d{4})/));

console.log("010-6374-6244".match(/(01\d-\d{3,4}-\d{4})/));

// 연습 js 코드에서 function name ( args ) 찾기
// console.log("javascript code....?".match(/\(?function\s+[a-zA-Z_$]+\s*\(\w*\)/));


// console.log("$$$iloveyou###".replace(/.*([a-zA-Z]{8}).*/, "$1"));


// console.log("011-021-0011-12312-123".match(/\d.*/));
// console.log("011-021-0011-12312-123".match(/\d.*-/));
