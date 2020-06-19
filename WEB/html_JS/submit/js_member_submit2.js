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
    displayTable();

}

//회원저장함수 - 입력받는..
function createMember(){
    var id = document.getElementById('mid').value;
    var pw = document.getElementById('mpw').value;
    var name = document.getElementById('mname').value;

    //배열에 저장함수 콜
    addMember(new Member(id, pw, name));

    document.getElementById('loginForm').reset();

    console.log(members);
    alert(members);

    // this.reset();

    //form태그 action실행되지 않도록 return false!
    return false;
}

//테이블에 출력 함수
function displayTable(){
    var listHtml='<table class="listTable">';
    listHtml += '   <tr>';
    listHtml += '       <td>Index</td>';
    listHtml += '       <td>ID( 또는 email)</td>';
    listHtml += '       <td>Password</td>';
    listHtml += '       <td>Name</td>';
    listHtml += '       <td>관리</td>';
    listHtml += '   </tr>';

    for(let i=0; i<members.length;i++){
        listHtml +='    <tr>';
        listHtml +='        <td>'+i+'</td>';
        listHtml +='        <td>'+members[i].id+'</td>';
        listHtml +='        <td>'+members[i].pw+'</td>';
        listHtml +='        <td>'+members[i].name+'</td>';
        listHtml +='        <td><input type="button" value="EDIT"><input type="button" value="DELETE"></td>';
        listHtml +='    <tr>';
    }

    listHtml += '</table>';

    var showList = document.getElementById('list');
    showList.innerHTML = listHtml;

}


//수정 출력세팅 함수
function showToEdit(){
    
}

//수정하고 저장 함수

//삭제 함수

//스토리지 함수

//window.load
window.onload = function(){



    //저장된 회원데이터 화면 출력
    displayTable();

    //입력 폼 casting 하고 onsubmit event!
    document.getElementById('loginForm').onsubmit = createMember;


    
}
