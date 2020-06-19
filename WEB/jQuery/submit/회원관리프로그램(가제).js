//배열선언
var members = [];

//생성자함수
function Member(memberId, password, memberName) {
    this.id = memberId;
    this.pw = password;
    this.name = memberName;
}
//프로토타입..?


//회원저장함수 - 배열에..
function addMember(member) {
    members.push(member);

    //동기화
    setStorage();

    
}
//회원저장함수 - 입력 받아서..

//테이블 출력 함수

//수정 준비 출력 함수..

//수정하고 저장함수

//삭제함수

//setStorage();

//window.onload

