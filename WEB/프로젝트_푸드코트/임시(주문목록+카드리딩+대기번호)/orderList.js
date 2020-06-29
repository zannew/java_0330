
window.onload = function () {


    // Get the modal
    var btn_payment = document.getElementById('payment');
    var btn_cardPay = document.getElementById('credit');
    var btn_cancelPay = document.getElementById('cancel');

    // Get the button that opens the modal
    var wrap01 = document.getElementById('wrap01');
    var wrap02 = document.getElementById('wrap02');
    var wrap_kiosk = document.getElementById('wrap_kiosk');
    var orderList = document.getElementById('wrapOrderList');

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName('close')[0];

    // When the user clicks on the button, open the modal 

    // wrap01.style.display = "none";

    btn_payment.onclick = function(){
        orderList.style.display = "block";
        wrap_kiosk.style.display = "none";

    }

    btn_cardPay.onclick = function () {

        wrap01.style.display = "block";
        orderList.style.display = "none";
        
        setTimeout(function () {
            wrap02.style.display = "block";
        }, 1000 * 5);
        setTimeout(function () {
            wrap01.style.display = "none";
        }, 1000 * 5);

        var mathRandom = Math.random();
        var randNum= document.getElementById("msg_waitingNum");
            randNum.innerText = '대기번호 : '+Math.floor( mathRandom * 1000 + 1 );
            

            setTimeout(function () {
                wrap02.style.display = "none";
            }, 1000 * 10);

    }
    
    // function click_credit(){

    //     wrap01.style.display = "block";

    //     setTimeout(function () {
    //         wrap02.style.display = "block";
    //     }, 1000 * 5);
    //     setTimeout(function () {
    //         wrap01.style.display = "none";
    //     }, 1000 * 5);
    // }


    //  btn.onclick = function() {
    //     modal.style.display = "block";
    //   }

    // When the user clicks on <span> (x), close the modal
    


    // span.onclick = function () {
    //   modal.style.display = "none";
    // }

    // When the user clicks anywhere outside of the modal, close it
    // window.onclick = function (event) {
    //     if (event.target == modal) {
    //         modal.style.display = "none";
    //     }
    // }

}

   