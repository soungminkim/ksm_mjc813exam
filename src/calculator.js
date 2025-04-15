// let leftNumber = "";
// let rightNumber = "";
// let operator = "";
// let result = "";
// console.log(`안녕하세요 지금 시각은 ${new Date()} 입니다.`);
//
// function checkWhere(number) {
//     if( operator === "" ) {
//         leftNumber += number.toString();
//     } else {
//         rightNumber += number.toString();
//     }
//     document.getElementById("outDiv").innerText = leftNumber + " " + operator + " " + rightNumber;
// }
//
// function buttonNum(number) {
//     checkWhere(number);
// }
//
// function buttonAdd() {
//     operator = "+";
// }
//
// function buttonSub() {
//     operator = "-";
// }
//
// function buttonMul() {
//     operator = "*";
// }
//
// function buttonDiv() {
//     operator = "/";
// }
//
// function buttonEqu() {
//     try {
//         let res = eval(leftNumber);
//     } catch(ex) {
//         console.log(ex.message);
//         leftNumber = leftNumber.replaceAll('A','');
//     }
//     let a = typeof leftNumber;
//     console.log(a);
//     console.log(a instanceof Number);
//     try {
//         let res = eval(rightNumber);
//     } catch(ex) {
//         console.log(ex.message);
//         rightNumber = rightNumber.replaceAll('A','');
//     }
//     switch(operator) {
//         case "+":
//             result = (Number(leftNumber) + Number(rightNumber)).toString();
//             break;
//         case "-":
//             result = (Number(leftNumber) - Number(rightNumber)).toString();
//             break;
//         case "*":
//             result = (Number(leftNumber) * Number(rightNumber)).toString();
//             break;
//         case "/":
//             result = (Number(leftNumber) / Number(rightNumber)).toString();
//             break;
//     }
//     document.getElementById("outDiv").innerText = leftNumber + " " + operator
//         + " " + rightNumber + " = " + result;
// }
//
// function buttonCE() {
//     leftNumber = "";
//     rightNumber = "";
//     operator = "";
//     result = "0";
//     document.getElementById("outDiv").innerText = result;
// }
//
// class Car1 {
//     name = "";
//     construct(a) {
//         this.name = a;
//     }
//     start() {
//         console.log(this.name + " start");
//     }
// }
//
// let car1 = new Car1("Fiat");
// car1.start();
//
// function Person(first, last, age, eye) {
//     this.firstName = first;
//     this.lastName = last;
//     this.age = age;
//     this.eyeColor = eye;
// }
//
// let p1 = new Person("first", "last", 20, "black");
// console.log(p1);
// console.log(JSON.stringify(p1));
//
//
// // JavaScript 에서 클래스 선언하고 객체 탄생하는 방법으로 사용한다.
// class Human {
//     height = 180; // 인스턴스 변수, 멤버변수
//     name = "";
//     age = 0;
//
//     constructor(name, age) {	// 비기본 생성자
//         // this는 클래스가 생성할 인스턴스를 가리킨다.
//         this.name = name;
//         this.age = age;
//     }
//
//     print() {
//         console.log("이름은 " + this.name + ", 나이는 " + this.age
//             + ", 키는 " + this.height);
//     }
//
//     start() {
//         console.log(this.name + " Start !!");
//     }
// }
//
// let human1 = new Human("이순신", 30);
// human1.print();
// let human2 = new Human("홍길동", 25);
// human2.print();
// human2.start();
//
// class Car {
//     name = "";
//     model = "";
//     weight = "";
//     color = "";
//
//     constructor(name, m, w, color) { //자바스크립트에서 constructor는 이름으로 정의되어있음 그리고 constructor를 2개 생성하면 오류남
//         // 또한 기본 생성자 constructor()은 굳이 선언하지 않아도 가능하고 해당 기본 생성자에 역활은 그 클래스 안에 있는 클래스들을 메모리 만 할당하지 다른것은 하지 않음.
//         this.name = name;
//         this.model = m;
//         this.weight = w;
//         this.color = color;
//         // this는 클래스를 설계할때는 어떤 이름으로 인스턴스될지 모른다.(나 자신을 뜻하는 객체)
//         // 왜 사용하는가? -> 클래스를 설계했는데 간혹가다 클래스 내부에 있는 메소드가 같은 클래스 안에 있는
//         // 메소드를 사용할떄 this.변수 = m 을 호출하여 해당 변수로 사용할수 있다.
//         // 인스턴스 된 자기 객체를 뜻할때 this 라는 단어를 사용한다.
//     }
//
//
//     start() {
//         //console.log(JSON.stringify(this) + " 출발합니다.");
//         // JSON 문자열 형식 {이름:값, 이름:값, ...}
//         // 생성된 객체의 멤버변수이름과 멤버변수 값을 출력한다.
//         console.log(`${JSON.stringify(this)} 출발합니다.`);
//         // ` 문자열 ${자바스크립트객체,수식} 문자열`
//     }
//
//     drive() {
//         console.log(this.name + " 운전합니다.");
//     }
//
//     brake() {
//         console.log(this.name + " 브레이크 페달 밟아요.");
//     }
//
//     stop() {
//         //console.log(this.name + " 정지합니다.");
//         console.log(`${this.name} 정지합니다.`);
//     }
//
//     showRedSign() {
//         console.log(this.name + " 빨간불을 봤습니다.");
//         this.brake();
//         this.stop();
//     }
// }
//
// let fiat500 = new Car(); // NEW 뒤에 온다면 생성자이다.
// fiat500.name = "Fiat";  // 객체를 만든후에 멤버변수를 할당하는 방법인데
// fiat500.model = "500";  // 이 방법은 별로 추천하지 않습니다.
// fiat500.weight = "850kg";
// fiat500.color = "white";
// fiat500.start();
// fiat500.drive();
// fiat500.stop();
//
// let accentMD = new Car("Accent", "MD", "700kg", "gray");
// // 객체를 만들때 생성자로 객체를 생성하면서 멤버변수의 값을 할당하는 방법을 추천합니다.
// accentMD.start();
// accentMD.drive();
// accentMD.showRedSign();
//
// class Zeep extends Car {
//     // Car 클래스를 상속받아서 Zeep 클래스를 선언한다.
//     // Car 클래스에 존재하는 멤버변수와 멤버메소드를 모두 사용할 수 있다.
//     engine = "";
//     constructor(name, m, w, color, engine) {
//         super(name, m, w, color); // super(c, java 사용), c#에선 base 라는 단어로 사용 라는 단어는 객체 지향에서 부모를 뜻함
//                                   // 자기 아버지 뿐만 아니라 할아버지, 증조 할아버지를 찾음
//         this.engine = engine;
//     }
//     fourWd() {
//         console.log(this.name + ", " + this.engine + " 4휠 입니다.");
//     }
// }
//
// let zeep1 = new Zeep("코란도4", "코란도", "1200kg", "brown", "120마력");
// zeep1.start();
// zeep1.drive();
// zeep1.fourWd();
// zeep1.stop();
// // 자식클래스 객체는 부모클래스의 속성(멤버변수)와 메소드(멤버메소드)를 사용할 수 있다.
// // 그리고 자식클래스의 속성과 메소드를 사용할 수 있다.
//
//
// let morning1 = new Car("모닝", "M500", "700kg", "red");
// morning1.start();
// morning1.drive();
// // morning1.fourWd();  // 에러가 발생합니다.
// // 부모클래스 객체는 부모클래스만 사용할 수 있다.
// // 부모클래스 객체는 자식클래스를 모른다.
// morning1.stop();
//
// //class 선언을 안했기에 메소드는 아님
//
// let gugudan = [1,2,3,4,5,6,7,8,9];
// gugudan.forEach(function (i){
//     console.log(`구구단의 3단(1) = ${i * 3}`);
// });
//
// gugudan.forEach((i) => {
//     console.log(`구구단의 3단(2) = ${i * 3}`)
// });
//
// gugudan.forEach(myForEach);
// //myForEach 에서 중괄호를 안하는 이유-> 리턴값이 없는 void 형의 매개변수를 받음
// function myForEach(i){
//     console.log(`구구단의 3단(3) = ${i * 3}`);
// }
//
// let array02 = ["A","B","C","D"]
// let resultarray02 = array02.map(function(value,index,array){
//     return value + index;
// });
// console.log(resultarray02)
//
// const array03 = [36, 122, 79, 8, "무궁화", 391, "words", 509, 20192, "B", 321, 473, 73, "france", "Korea", 24, 99];
// //console.log() => 출력
// //1. 위 배열을 오름차순으로 정렬해서 출력하세요.
// const array0301 = array03
//     .sort((a, b) => a - b);
// console.log("1. 오름차순 정렬된 숫자 배열:", array0301);
// //2. 가장 큰 값을 출력 하세요
// const array0302 = Math.max(...array03.filter(el => typeof el === 'number'));
// console.log("2. 가장 큰 값:", array0302);
// //3. 짝수인 요소만 배열로 출력하세요
// const array0303 = array03.filter(el => typeof el === 'number' && el % 2 === 0);
// console.log("3. 짝수만 필터링:", array0303);
// //4. 문자열이 요소만 대문자로 변경하여 출력하세요
// const array0304 = array03
//     .filter(el => typeof el === 'string')
//     .map(str => str.toUpperCase());
// console.log("4. 대문자 문자열:", array0304);