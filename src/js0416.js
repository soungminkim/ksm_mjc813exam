// 비동기 -> 순차적인것이 아닌 언제 실행 될지 모름
// 동기 -> 위에서 아래부터 순차적으로 실행됨.
// function printTime(){
//     console.log(`setTimeout : ${new Date()}`);
// }
// let handle = setTimeout(printTime,1000);
//
// function printTime2(){
//     console.log(`setInterval : ${new Date()}`);
// }
// let handle2 = setInterval(printTime2,1000);

//call back 예제
// function myDisplayer(some) {
//     document.getElementById("demo").innerHTML = some;
// }
//
// function myCalculator(num1, num2, myCallback) {
//     let sum = num1 + num2;
//     myCallback(sum);
// }
//
// myCalculator(5, 5, myDisplayer);
// myDisplayer -> 함수를 나중에 실행할꺼니까 이름을 던져둠
// 여기선 myCallback에는 던져짐
// 그래서 let sum 을 들고 myCallback에서 sum을 가지고
// myDosplayer로 변수를 들고감.
// ()를 넣으면 해당 함수만 실행했을거임.

//Asynchronous는 순서대로 진행되지 않을수도 있음 setTimeout()이기본임

//Promise -> 약속을 만들떄 그약속이 성공적일떈 a 함수 실패하면 b 함수를 실행해줘
// let myPromise = new Promise(function(a,b){});

//Async 중간에 있으면 라인대로 꼭 실행할수 없는 상황일떄 사용함 -> 언제 실행될지 모름

//document.createElement(element)
//document.removeChild(element)
//document.appendChild(element)
//document.replaceChild(new, old)
//document.write(text)

//AJAX -> 서버통신 A-> 비동기 요청자라는 객체를 만들어서 서버와 통신함
//너무 길어져서 잘 사용하지 않고 jQuery AJAX(선언형 프로그램)에서 사용함

//문제 19 : 제곱을 구하자
//공백으로 구분하여 두 숫자 a와 b가 주어지면, a의 b승을 구하는 프로그램을 작성하세요.

class SquareFunc{
    constructor(number, number1) {
        this.number = number;
        this.number1 = number1;
        console.log(Math.pow(Number(number1), Number(number)));
    }
}
let Square = prompt("a와 b를 작성해주세요(숫자로)").split(' ');
new SquareFunc(Square[0], Square[1]);

//문제 25 : 원의 넓이를 구하세요
//원의 넓이는 반지름의 길이 x 반지름의 길이 x 3.14로 구할 수 잇습니다.
//함수를 사용하여 원의 넓이를 구하는 코드를 작성해봅시다.
//입력으로 반지름의 길이 정수 n이 주어지면 원의 넓이를 반환하는 함수를 만들어주세요.

class CircleFunc{
    constructor(rdus) {
    this.rdus = rdus;
    console.log(Math.pow(Number(rdus), 2) * 3.14);
    }
}
let radius = prompt("원의 반지름을 작성해주세요(숫자)");
new CircleFunc(radius);

//문제26 : 행성문제2
//우리 태양계를 이루는 행성은 수성, 금성, 지구, 화성 ,목성, 토성, 천왕성, 해왕성이 있습니다.
//이행성들의 영어이름은 Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune 입니다.
// 이행성의 한글 이름을 입력하면 영어 이름을 반환하는 프로그램을 만들어주세요.
class PlaneFunc {
    constructor(planetName) {
        this.planetName = planetName;
        switch(planetName) {
            case "수성":
                console.log("Mercury");
                break;
            case "금성":
                console.log("Venus");
                break;
            case "지구":
                console.log("Earth");
                break;
            case "화성":
                console.log("Mars");
                break;
            case "목성":
                console.log("Jupiter");
                break;
            case "토성":
                console.log("Saturn");
                break;
            case "천왕성":
                console.log("Uranus");
                break;
            case "해왕성":
                console.log("Neptune");
                break;
            default:
                console.log(planetName + "이란 행성은 없습니다.");
        }

    }
}
let pName = prompt("행성 이름을 한글로 입력해주세요");
new PlaneFunc(pName);
