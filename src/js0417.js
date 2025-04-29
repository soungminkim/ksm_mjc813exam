// class Exam27 {
//     maps = new Map();
//     inputFunc() {
//         let names = prompt("이름을 공백으로 구분하여 입력하세요.");
//         let score = prompt("점수를 공백으로 구분하여 입력하세요.");
//         let arrName = names.split(" ");
//         let arrScore = score.split(" ");
//         if (arrName.length != arrScore.length) {
//             alert("두개 배열의 길이가 다릅니다. 다시 입력하세요.");
//             return false;   // 함수가 false 를 리턴한다.
//         }
//         for (let i = 0; i < arrScore.length; i++) {
//             this.maps.set(arrName[i], Number(arrScore[i])); // Number 는 문자열을 숫자로 변경
//             console.log(this.maps);
//         }
//         return true; // 함수가 true 를 리턴
//     }
//
//     outputFunc() {
//         let strOutput = "{";
//         for( let item of this.maps ) {
//             let j = 0;
//             console.log(item);
//             strOutput += `'${item[j]}': ${item[j+1]}, `;
//             j++;
//         }
//         strOutput = strOutput.substring(0 , strOutput.length - 2);
//         // 문자열의 길이에서 -2 시킨 길이의 문자열로 다시 저장. "abcd" => "ab"
//         strOutput += "}";
//         console.log(strOutput);
//     }
// }
//
// let exam = new Exam27();
// while (true) { // 길게 작성해서 맞지 않으면 다시 물어본다.
//     if (exam.inputFunc()) {   // inputFunc() 를 실행하고 리턴값이 true 이면
//         exam.outputFunc(); // outputFunc() 를 실행한다.
//         break;
//     }
// }
//
// class Exam28 {
//     strInput = "";
//     constructor(str) {
//         this.strInput = str;
//     }
//     output(){
//         for (let i = 0; i < this.strInput.length-1; i++) {
//             console.log(`${this.strInput[i]} ${this.strInput[i+1]}`);
//         }
//     }
// }
//
// let exam28 = new Exam28(prompt("문자열을 입력하세요."));
// exam28.output();

//문제 37번
class Exam37 {
    arrItem = [];
    maps = new Map();

    constructor(input) { // 생성자 사용하여 입력받은 문자열을 뛰어쓰기로 구분하여 배열 생성
        this.arrItem = input.split(" ");
    }

    checkVotes() {
        for (let i = 0 ; i < this.arrItem.length; i++) { // 입력받은 문자열 랭스만큼
            let name = this.arrItem[i]; // i번쨰 이름을 name 에 입력
            if (this.maps.has(name)) { // 해당 name 이름이 현재 있는 maps에 비교
                this.maps.set(name, this.maps.get(name) + 1); // maps에 있으면 key 값에 +1
            } else {
                this.maps.set(name, 1); // 아니라면 해당 name으로 maps에 id와 key에는 1로 생성
            }
        }

        let maxVotes = 0;
        let winner = "";
        for (let [name, votes] of this.maps) { // maps배열에 있는 name과 votes를 활용

            if (votes > maxVotes){ // 현재 투표수가 기존에 가장많았던 투표수보다 많다면 winner 에 현재 name과 maxVotes에 투표수 저장
                maxVotes = votes;
                winner = name;
            }
        }
        return [winner, maxVotes]; // 위너 투표수 출력
    }
}
let exam37 = new Exam37(prompt("투표할 항목을 공백으로 구분해서 입력하세요."));
let result = exam37.checkVotes();
console.log(`투표 결과 ${result[0]}가 ${result[1]}표로 가장 많습니다.`);