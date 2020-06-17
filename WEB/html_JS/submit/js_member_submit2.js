//배열선언
var members = [];

//생성자함수
function Member(memberId, password, memberName){
    this.id=memberId;
    this.pw=password;
    this.name=memberName;
}

//회원저장함수 - 배열에..
function addMember(member){
    members.push(member);
    //동기화
    setStorage();

    console.log(members);
    // displayTable();

}

//회원저장함수 - 입력받는..
function createMember(){
    var id = document.getElementById('mid').value;
    var pw = document.getElementById('mpw').value;
    var name = document.getElementById('mname').value;

    //배열에 저장함수 콜
    addMember(new Member(id, pw, name));

    console.log(members);

    this.reset();

    //form태그 action실행되지 않도록 return false!
    return false;
}

//테이블에 출력 함수
function displayTable(){
    var listHtml='';
    listHtml += ''
}


//수정 출력세팅 함수

//수정하고 저장 함수

//삭제 함수

//스토리지 함수

//window.load

