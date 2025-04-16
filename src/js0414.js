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

//let lotto = [];
//
//for (let i = 0; i < 6; i++){
//    let num = Math.floor(Math.random() * 45) + 1;
//
//    for (let j in lotto){
//        while(num === lotto[j]){
//            num = Math.floor(Math.random() * 45) + 1;
//        }
//    }
//    lotto.push(num);
//}
//lotto.sort((a,b) => a - b);
//console.log("이번주의 로또 번호는 " + lotto);
//
////2번 문제10번 별찍기
// const n = prompt("숫자를 적어주세요.");
// let tree = '';
//
// for(let i=1; i<=n; i++){
//     let star = '';
//     for(let j=1; j<=n-i; j++){
//         star += ' ';
//     }
//     for(let x=1; x<=2 * i -1; x++){
//         star += '*';
//     }
//     tree += star + '\n';
// }
// console.log(tree);
//
//// 3번 문제12번 게임캐릭터클래스
//// 데이터 여기에 class 를 작성.
//const Wizard = class Wizard {
//    constructor(health, mana, armor) {
//        this.health = health;
//        this.mana = mana;
//        this.armor = armor;
//    }
//    attack(){
//        console.log("파이어볼");
//    }
//}
//
//const x = new Wizard(545,210,10);
//console.log(x.health, x.mana, x.armor);
//x.attack()
//
////4번 문제13번
//let planetnumber = prompt("숫자를 입력하세요");
//let userplanet
//
//if (isNaN(planetnumber)) {
//    console.log("숫자를 입력해주세요.");
//}
//else{
//    switch(planetnumber) {
//        case "1":
//            userplanet = "수성";
//            break;
//        case "2":
//            userplanet = "금성";
//            break;
//        case "3":
//            userplanet = "지구";
//            break;
//        case "4":
//            userplanet = "화성";
//            break;
//        case "5":
//            userplanet = "목성";
//            break;
//        case "6":
//            userplanet = "토성";
//            break;
//        case "7":
//            userplanet = "천왕성";
//            break;
//        case "8":
//            userplanet = "해왕성";
//            break;
//        default:
//            console.log("해당 " + userplanet + "번쨰 행성은 없습니다.")
//    }
//}
//
//// 5번 문제16번
//let reversinput = prompt("입력하세요");
//let newString = "";
//
//for (let i = reversinput.length - 1; i>=0; i--) {
//    newString += reversinput[i];
//}
//
//console.log(newString);

// 리버스를 사용하는 법
// let reversStr =reversinput.split("");
//
// let reverseArray = reversStr.reverse();
//
// let joinArray = reverseArray.join("");
//
// console.log(joinArray);

//this -> 클래스가 객체로 인스턴스 될떄 자기자신 객체를 말함.

//문제 17 : 놀이기구 키 제한
 class Ride{
     constructor(userkey){
         this.userkey = userkey;

         if(userkey >= 150){
             console.log("YES");
         }
         else {
             console.log("No");
         }
     }
 }

 let userkey = prompt("키를 입력해주세요.");
 while (true){
     if(isNaN(userkey)){
         userkey = prompt("숫자를 입력해주세요.");
     }
     else{
         new Ride(userkey);
         break;
     }
 }

//문제 18 : 평균 점수
//영하네 반은 국어 수학, 영어 시험을 보았습니다. 영하는 친구들의 평균 점수를 구해주기로 했습니다.
//공백으로 구분하여 세 과목의 점수가 주어지면 전체 평균 점수를 구하는 프로그램을 작성하세요. 단, 소숫점 자리는 모두 버립니다.
class TestAverage{
    constructor(test) {
        let average = 0;
        this.test = test;
        for(let i = 0; i <test.length;i++){
            test[i] = test[i]
            average += Number(test[i]);
        }

        average = Math.floor(average / test.length);
        console.log(`평균은 : ${average}`);
    }
}

let test = prompt('점수를 입력하세요.').split(' ');
new TestAverage(test);