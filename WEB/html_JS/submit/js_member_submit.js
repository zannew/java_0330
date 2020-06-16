var members = [];

function Member(memberid, pw, memberName){
    this.id=memberid;
    this.password=pw;
    this.name=memberName;

    this.getId = function(){
        return id;
    }
    this.getPw = function(){
        return password;
    }
    this.getName = function(){
        return name;
    }

    this.setId = function(memberid){
        id=memberid;
    }
    this.setId = function(pw){
        password=pw;
    }
    this.setId = function(memberName){
        name=memberName;
    }
    
    
}

Member.prototype.toString = function(){

    var html = '';
    html += '<tr>';
    html += '<td>';
    html += this.id;
    html += '</td>';
    html += '<td>';
    html += this.password;
    html += '</td>';
    html += '<td>';
    html += this.name;
    html += '</td>';
    // html += '<td>';
    // html += '<input type="button" value="Edit">';
    // html += '<input type="button" value="Delete">';
    // html += '</td>';
    html += '</tr>';

    return html;
}

//데이터 저장 함수
function addMember(member){
    members.push(member);

    // console.log(members);
}

//회원 데이터 저장
function createMember(){

    var id = document.getElementById('mid').value;
    var pw = document.getElementById('mpw').value;
    var name = document.getElementById('mname').value;

    //배열에 데이터 추가
    addMember(new Member(id, pw, name));

    // this.reset()

    console.log(members);
    alert(members);

    //form태그의 action 실행이 되지 않도록 반드시 return false
    return false;
}

//등록 회원 리스트 출력
function displayTable(){

    var listHtml ='';
    listHtml += '<table class="listtable">';
    listHtml += '   <tr>';
    listHtml += '       <th>ID(EMAIL)</th>';
    listHtml += '       <th>PASSWORD</th>';
    listHtml += '       <th>NAME</th>';
    listHtml += '       <th>SETTING</th>';
    listHtml += '   </tr>';

    for(let i=0; i<members.length;i++) {
        listHtml +='    <tr>';
        listHtml +='        <td>'+i+'</td>';
        listHtml +='        <td>'+members[i].id+'</td>';
        listHtml +='        <td>'+members[i].pw+'</td>';
        listHtml +='        <td>'+members[i].name+'</td>';
        listHtml +='        <td><input type="button" value="EDIT"><input type="button" value="DELETE"></td>';
        listHtml +='    <tr>';
    }

    listHtml += '</table>';

    var listTable = document.getElementById('list');
    listTable.innerHTML = listHtml;

}

function setStorage(){
    localStorage.setItem('members', JSON.stringify(members));
  
}

function initStorage(){
    var storageData = localStorage.getItem('members');

    if(storageData==null){
        // 프로그램 최초 시작 또는 데이터가 없는 상태
        localStorage.setItem('members', JSON.stringify(members));
    } else {
        // 저장되어 있는 JOSN 데이터를 배열 객체로 변환 
        members = JSON.parse(storageData);
    }
}



window.onload = function(){

    document.getElementById('loginform').onsubmit = createMember;
    
    initStorage();

    //자바스크립트 객체를 문자열로 변환
    var newMember_str = JSON.stringify(members);
    document.getElementById("json").innerHTML=newMember_str;

    
    alert(newMember_str);

    // var id = members[0];
    // var pw = members[1];
    // var name = members[2];
    // var pw = members[0].password;
    // var mname = members[0].name;
    
    
    //localStorage 저장
    // localStorage.setItem('id', member_str);
    // localStorage.setItem('pw', '4321');
    // localStorage.setItem('name','잔뉴넌');


    // localStorage.clear();
}









// window.onload = function(){
// //사용자 입력 폼 Casting

// //기본적인 유효성 검사

// //1.<form> Casting
// var form = document.getElementById('loginform');

// // form.setAttribute('action', 'http://www.naver.com');

// //2.onsubmit
// form.onsubmit = function(){

//     // <input> Casting
//     var uid = document.getElementById('id');
//     var upw = document.getElementById('pw');
//     var uname = document.getElementById('name');

//     if(uid.value==null || uid.value.legnth<1){
//         alert('ID를 입력해주세요.');
//         return false;
//     }

//     if(upw.value==null || upw.value.legnth<1){
//         alert('PASSWORD를 입력해주세요.');
//         return false;
//     }

//     if(uname.value==null || uname.value.legnth<1){
//         alert('이름을 입력해주세요.');
//         return false;
//     }
// }

// }

