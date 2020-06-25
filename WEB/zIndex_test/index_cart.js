

var shopingList = [];


function Cart(selectSort, selectMenu, sAmount, sPrice) {
    this.sort = selectSort;
    this.menu = selectMenu;
    this.amount = sAmount;
    this.price = sPrice;
}


function createShoping() {

    var buttom = document.querySelector(".menu_btn");

    var sort = "dessert";
    var menu = $('.menu_btn').val();
    var amount=1;
    var price =buttom.getAttribute("data-value");

    shopingList.push(new Cart(sort, menu, amount, price));

    cart_list();
    setLocal();

}


function getSumPrice() {


}




function cart_list() {
    var list = '';
    list+='<table id="cart_listb">';
    for (var idx = 0; idx < shopingList.length; idx++) {
        list += '<tr>     <td>' + idx + '</td>';
        list += '     <td>' + shopingList[idx].sort + '</td>';
        list += '     <td>' + shopingList[idx].menu + '</td>';
        list += '     <td>' + shopingList[idx].amount + '</td>';
        list += '     <td>' + shopingList[idx].price + '</td></tr>';
    }   
    list+='</table>';
    $('#cart_listb').html(list);
}



function initStore() {

    var data = localStorage.getItem('foodcart');
    if (data == null) {
        var jdata = JSON.stringify(shopingList);
        localStorage.setItem('foodcart', jdata);
    } else {
        shopingList = JSON.parse(data);
    }

}



//로컬저장소에 저장
function setLocal() {
    var jsondata = JSON.stringify(shopingList);
    localStorage.setItem('foodcart', jsondata);
}

$(document).ready(function () {

    initStore();
    cart_list();
    $('.menu_btn').click(createShoping);

});


