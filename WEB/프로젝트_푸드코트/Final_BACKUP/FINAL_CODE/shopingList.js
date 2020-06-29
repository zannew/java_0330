

var shopingList = [];

var menu = {};
var check = 0; /* 사이드 메뉴 선택 확인 변수 */

function deleteCart(idx) {
    shopingList.splice(idx, 1);
    cart_list();
    show_cartList();
    getTotalAmount();
    getTotalPrice();
    setLocal();

}

function addComma(num) {
    var regexp = /\B(?=(\d{3})+(?!\d))/g;
    return num.toString().replace(regexp, ',');
  }

//장바구니 내 모든 수량 리턴 => 장바구니로
function getTotalAmount() {

    var totalAmount = 0

    for (var idx = 0; idx < shopingList.length; idx++) {
        totalAmount = totalAmount + parseInt(shopingList[idx].samount);
    }

    $('#getAmount').html('주문 수량 : ' + totalAmount);
}



//장바구니 내 모든 가격 리턴 => 장바구니로
function getTotalPrice() {
    var tPrice = 0

    for (var idx = 0; idx < shopingList.length; idx++) {
        tPrice = tPrice + ((shopingList[idx].samount * shopingList[idx].sprice) + shopingList[idx].side_price);
    }

    $('#getPrice').html('주문 금액 : ' + addComma(tPrice) +"원");
}


//장바구니 내 모든 수량 리턴 => 결제창으로
function getTotalAmountOrder() {

    var totalAmount = 0

    for (var idx = 0; idx < shopingList.length; idx++) {
        totalAmount = totalAmount + parseInt(shopingList[idx].samount);
    }

    $('#getAmountOrder').html('주문 수량 : ' + totalAmount);
}



//장바구니 내 모든 가격 리턴 => 결제창으로
function getTotalPriceOrder() {
    var tPrice = 0

    for (var idx = 0; idx < shopingList.length; idx++) {
        tPrice = tPrice + ((shopingList[idx].samount * shopingList[idx].sprice) + shopingList[idx].side_price);
    }

    $('#getPriceOrder').html('주문 금액 : ' + addComma(tPrice)+"원");
}


function cart_list() {

    var list = '';
    list += '<table id="cart_list">';

    for (var idx = 0; idx < shopingList.length; idx++) {
        list += '<tr>     <td>' + (idx+1) + '</td>';
        list += '     <td>' + shopingList[idx].sname + '</td>';

        list += '     <td>' + shopingList[idx].side_name + '</td>';

        list += '     <td> ' + shopingList[idx].samount + '</td>';
        list += '     <td>' + addComma((shopingList[idx].samount * shopingList[idx].sprice) + shopingList[idx].side_price) + '원</td>';
        list += '     <td> <a href="javascript:deleteCart(' + idx + ')">삭제</a> </td></tr>';
    }

    list += '</table>';

    $('#cart_list').html(list);
}




//선택한 메뉴 주문목록에 나오는 메서드
function show_cartList() {

    var cartList = '';
    cartList += '<table id="order_list">';

    for (var idx = 0; idx <shopingList.length; idx++) {
        cartList += '   <tr>';
        cartList += '       <td>' + (idx+1) + '</td>';
        cartList += '       <td>' + shopingList[idx].sname + '</td>';
        cartList += '       <td>' + shopingList[idx].side_name + '</td>';
        cartList += '       <td>' + shopingList[idx].samount + '</td>';
        cartList += '       <td>' + addComma((shopingList[idx].samount * shopingList[idx].sprice) + shopingList[idx].side_price) + '원</td>';
        cartList += '';
        cartList += '   </tr>';

    }
    cartList+='</table>';

    $('#order_list').html(cartList);

}



function initStore() {

    var data = sessionStorage.getItem('foodcart');
    if (data == null) {
        var jdata = JSON.stringify(shopingList);
        sessionStorage.setItem('foodcart', jdata);
    } else {
        shopingList = JSON.parse(data);
    }

}



//로컬저장소에 저장
function setLocal() {
    var jsondata = JSON.stringify(shopingList);
    sessionStorage.setItem('foodcart', jsondata);
}




$(document).ready(function () {

    initStore();
    cart_list();
    show_cartList();
    setLocal();
    

    $('.trigger').click(function () {
        $('#overlay').fadeIn(300);
    });

    $('#close').click(function () {
        $('#overlay').fadeOut(300);
        $('.side_menu_btn').removeClass('select_border');
    });




    // 메뉴선택시, 사이드창에 선택메뉴의 이미지로 변경
    $('.menu_btn').click(function () {

        var img = $(this).find('img').attr('src');

        $('#select_menu_img>img').attr('src', img);

        var name = $(this).find('h3').text();
        $('#menu_info>h2').text(name);

        var price = $(this).find('p').text();
        $('.select_menu_price').text(price);

    });


    //  (팝업-사이드창) 
    // 사이드메뉴 선택시 속성추가
    $('.side_menu_btn').click(function () {
        if ($(this).hasClass('select_border')) {
            $(this).removeClass('select_border');

        } else {
            $(this).addClass('select_border');

        }


    });



    //윤원 - 주문목록 추가
    //  (팝업-사이드창) 
    // 사이드메뉴 선택 후 ㅡ> 확인버튼 클릭시 ㅡ> 속성삭제
    $('#side_ok').click(function () {
        $('.side_menu_btn').removeClass('select_border');
        getTotalAmount();
        getTotalPrice();


    });





    // 사이드창 선택사항 - 객체로
    $('.menu_btn').click(function () {
        var name = $(this).find('h3').text();
        var price = $(this).find('p').text();
        var price1 = price.replace(',', '');
        price = parseInt(price1);

        menu = {
            sname: name,
            sprice: price,
        }
    });


    $('#payment').click(function(){
        getTotalAmountOrder();
        getTotalPriceOrder();
    });


    


    var sidemenu = {};

    // 사이드메뉴 선택. (여러개 선택시)
    $('.side_menu_btn').click(function () {
        var amount = $('#select_count').find('input').val();

        // 만약에, 선택되어있다면, 
        if ($(this).hasClass('select_border')) {

            var sidename = $(this).find('h3').text();

            var sideprice = $(this).find('p').text();
            var price1 = sideprice.replace(',', '');
            sideprice = parseInt(price1);

        } else {
            sidename = 0;
            sideprice = 0;
        }

        menu.samount = amount;
        menu.side_name = sidename;
        menu.side_price = sideprice;
        
        check = 1;
    });

    $('#side_ok').click(function () {
        /* 사이드 메뉴 선택 시 */
        if(check==1){
            shopingList.push(menu);
            cart_list();
            show_cartList();
            getTotalAmount();
            getTotalPrice();
            setLocal();
            check=0; /* push후 check 초기화 */
        }
        /* 사이드 메뉴 미선택 시 */
        else if(check==0){
            var amount = $('#select_count').find('input').val();
           
            var sidename = 0;
            var sideprice = 0;
    
            menu.samount = amount;
            menu.side_name = sidename;
            menu.side_price = sideprice;

            shopingList.push(menu);
            cart_list();
            show_cartList();
            getTotalAmount();
            getTotalPrice();
            setLocal();
        }
    });


});







