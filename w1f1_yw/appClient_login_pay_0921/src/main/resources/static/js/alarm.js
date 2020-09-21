document.write("<script src='js/_define.js'></script>");

//var domain = "";

//var loginInfo = sessionStorage.getItem("loginInfo");
//var loginMidx = sessionStorage.getItem("loginMidx");
//var loginName = sessionStorage.getItem("loginName");

// websocket을 지정한 URL로 연결
var sock = new SockJS(domain+"echo");

// websocket 서버에서 신호를 보내면 자동으로 실행된다.
sock.onmessage = getAlarm;
// websocket과 연결을 끊고 싶을때 실행하는 메소드.
sock.onclose = onClose;

/* WebSocket으로 보내기 */
function sendMessage(id, idx, status){
   
    var alarm = {
       midx : id,
       iidx : idx,
       tab : status
    };
 
    sock.send(JSON.stringify(alarm));
 
 };
 
 /* WebSocket으로 받기 */
 function getAlarm(evt){
 
    var data = evt.data; // 전달받은 데이터
    
    msgData = JSON.parse(data);

    var sender = msgData.midx;  // 알림을 보낸 사람 midx
    var iidx = msgData.iidx;    // 해당 게시글 iidx
    var tab = msgData.tab;      // 구매= buy, 판매= sell 탭 구분

    if(tab == "sell"){
        $('#alarm_s').addClass('alarm');
    }
    else if(tab == "buy"){
        $('#alarm_b').addClass('alarm');
    }

 };
 
 function onClose(evt){
 
 };

 function showAllAlarm(){
    document.getElementById()
 };