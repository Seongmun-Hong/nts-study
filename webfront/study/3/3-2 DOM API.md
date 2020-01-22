## DOM 탐색 APIs

유용한 속성
    - tagName
    - textContent
    - nodeType
  
이동
    - childNodes
    - firstChild
        - 공백이나 텍스트노드가 있으면 그것을 찾아줌
    - firstElementChild
    - parentElement
    - nextSibling
    - nextElementSibling

## DOM 조작 API

- removeChild()
- appendChild()
- 부모E.insertBefore(추가E, 기준E) // Move 를 시켜줌 copy가 아님!
- cloneNode()
- replaceChild()
- closest() // 상위로 올라가며 근접 엘리먼트 찾기

## HTML을 문자열로 처리해주는 DOM API
- innerText // text node만
- innerHTML // html 코드 전체
- targetE.insertAdjacentHTML(position, "\<h1\>hello\</h1\>") 
    - positions 

```html
<!-- beforebegin -->
<p>
<!-- afterbegin -->
foo
<!-- beforeend -->
</p>
<!-- afterend -->
```


## 링크들...
- document.으로 사용할 수 있는 api
    - https://www.w3schools.com/jsref/dom_obj_document.asp
- element. 으로 사용할 수 있는 api
    - https://www.w3schools.com/jsref/dom_obj_all.asp



## Polyfill이란 ?

폴리필(polyfill)은 개발자가 특정 기능이 지원되지 않는 브라우저를 위해 사용할 수 있는 코드 조각이나 플러그인을 말한다. 폴리필은 HTML5 및 CSS3와 오래된 브라우저 사이의 간격을 메꾸는 역할을 담당한다.

Modernizr에서 정리하여 제공하고 있는 polyfill 목록

https://github.com/Modernizr/Modernizr/wiki/HTML5-Cross-Browser-Polyfills