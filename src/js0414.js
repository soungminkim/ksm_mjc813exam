//let strToDay = new Date();// 몇월 몇일에 특정 일을 원한다면
//                                // "년도-월-일" 해당 함수에 년 월 일 넣으면 됌
//
//console.log(`오늘은 ${strToDay} 입니다.`);
//console.log(`현재 년도는 ${strToDay.getFullYear()} 입니다.`);
//console.log(`현재 월은 ${strToDay.getMonth()+1} 입니다.`);
//console.log(`현재 일은 ${strToDay.getDate()} 입니다.`);
//console.log(`현재 시각은 ${strToDay.getHours()} 입니다.`);
//console.log(`현재 분은 ${strToDay.getMinutes()} 입니다.`);
//console.log(`현재 초은 ${strToDay.getSeconds()} 입니다.`);

//1번 로또 만들기
//1~45번 까지의 숫자 5개 + 보너스1개를 랜덤으로 만든다.
//중복된 숫자는 제거한다.
//숫자 6개 저장되는 배열 선언하여 오름차순으로 정렬한다.
// math.andom()
// 곱하기
// math.ceil(값)

let lotto = [];

for (let i = 0; i < 6; i++){
    let num = Math.floor(Math.random() * 45) + 1;

    for (let j in lotto){
        while(num === lotto[j]){
            num = Math.floor(Math.random() * 45) + 1;
        }
    }
    lotto.push(num);
}
lotto.sort((a,b) => a - b);
console.log("이번주의 로또 번호는 " + lotto);

//2번 문제10번 별찍기
 const n = prompt('숫자를 입력하세요.');
 let tree = '';

 for(let i=1; i<=n; i++){
     let star = '';
     for(let j=1; j<=n-i; j++){
         star += ' ';
     }
     for(let k=1; k<=2*i-1; k++){
         star += '*';
     }
     tree += star + '\n';
 }
 console.log(tree);

// 3번 문제12번 게임캐릭터클래스
// 데이터 여기에 class 를 작성.
const Wizard = class Wizard {
    constructor(health, mana, armor) {
        this.health = health;
        this.mana = mana;
        this.armor = armor;
    }
    attack(){
        console.log("파이어볼");
    }
}

const x = new Wizard(545,210,10);
console.log(x.health, x.mana, x.armor);
x.attack()

//4번 문제13번
let strInput = prompt("입력하세요");

switch(strInput){
    case "1":console.log("수성");
        break;
    case "2":console.log("금성");
        break;
    case "3":console.log("지구");
        break;
    case "4":console.log("화성");
        break;
    case "5":console.log("목성");
        break;
    case "6":console.log("토성");
        break;
    case "7":console.log("천왕성");
        break;
    case "8":console.log("해왕성");
        break;
    default:console.log("해당 "+strInput+"번쨰 행성은 없습니다.")
}

// 5번 문제16번
let strInput = prompt("입력하세요");
let newString = "";

for (let i = strInput.length - 1; i>=0; i--) {
    newString += strInput[i];
}

console.log(newString);

 let reversStr =strInput.split("");

 let reverseArray = reversStr.reverse();

 let joinArray = reverseArray.join("");

 console.log(joinArray);
