
//사용자 입력 폼 Casting

//기본적인 유효성 검사

//1.<form> Casting
var form = document.getElementById('loginform');

// form.setAttribute('action', 'http://www.naver.com');

//2.onsubmit
form.onsubmit = function(){

    // <input> Casting
    var uid = document.getElementById('id');
    var upw = document.getElementById('pw');

    if(uid.value==null || uid.value.legnth<1){
        alert('ID를 입력해주세요.');
        return false;
    }

    if(upw.value==null || upw.value.legnth<1){
        alert('PASSWORD를 입력해주세요.');
        return false;
    }
}

