class Exam27 {
    maps = new Map();
    inputFunc() {
        let names = prompt("이름을 공백으로 구분하여 입력하세요.");
        let score = prompt("점수를 공백으로 구분하여 입력하세요.");
        let arrName = names.split(" ");
        let arrScore = score.split(" ");
        if (arrName.length != arrScore.length) {
            alert("두개 배열의 길이가 다릅니다. 다시 입력하세요.");
            return false;   // 함수가 false 를 리턴한다.
        }
        for (let i = 0; i < arrScore.length; i++) {
            this.maps.set(arrName[i], Number(arrScore[i])); // Number 는 문자열을 숫자로 변경
            console.log(this.maps);
        }
        return true; // 함수가 true 를 리턴
    }

    outputFunc() {
        let strOutput = "{";
        for( let item of this.maps ) {
            let j = 0;
            console.log(item);
            strOutput += `'${item[j]}': ${item[j+1]}, `;
            j++;
        }
        strOutput = strOutput.substring(0 , strOutput.length - 2);
        // 문자열의 길이에서 -2 시킨 길이의 문자열로 다시 저장. "abcd" => "ab"
        strOutput += "}";
        console.log(strOutput);
    }
}

let exam = new Exam27();
while (true) { // 길게 작성해서 맞지 않으면 다시 물어본다.
    if (exam.inputFunc()) {   // inputFunc() 를 실행하고 리턴값이 true 이면
        exam.outputFunc(); // outputFunc() 를 실행한다.
        break;
    }
}