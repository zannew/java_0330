
	/* 0917 윤원수정 */
	/* 일반 공구 리스트 */
	function itemlist(){
        
        var html = '';
		var category = '';

		$('.sort_reg').css('background-color', 'teal');
		$('.sort_rvs').css('background-color', 'aquamarine');
		
		$.ajax({
			url: domain+'/items',
			type: 'GET',
			data: {
				
				'page':pageNum,
				'count': 10,
				'searchType' :  $('#searchType').val(),
				'keyword': $('#keywordBox').val()
			},
			success: function(data){

				// 배열 새로 비우고 담아야한다.. 안그러면 정렬하고 돌아오면 배열요소 추가로 담겨 평점정렬할 때 요소 2배로 나온다..
				items=[]; 
				itemView =[]; 
                
                html += '<div class="itemlist_buttons">';

				// 일반 공구 리스트 ㅡ> 배열에 담기
				for (i in data.itemList) {
					items.push(data.itemList[i]);
				}
			
                for(var i=0; i<data.itemList.length; i++){

                    switch(data.itemList[i].category){
                        case 0: 
                            category = '';
                            break;

                        case 1: 
                            category = '과일/채소';
                            break;

                        case 2: 
                            category = '육류/해산물';
                            break;

                        case 3:
                            category = '생필품/기타';
                            break;
                    }



                    html += '	<button type="button" class="item_card category'+data.itemList[i].category+'" onclick="itemView('+data.itemList[i].iidx+','+loginMidx+')">';
                    //html += '		<input type="hidden" value="'+data[i].iidx+'">';
                    html += '		<img class="item_img" src="/order/upload/'+data.itemList[i].photo+'">';
                    html += '		<div class="item_info">';
                    //html += '				<h2 class="item_category">'+category+'</h2>';
                    html += '				<h2 ><b class="item_title">'+data.itemList[i].iidx+': '+data.itemList[i].title+'</b></h2>';
                    //html += '				<h4 class="seller_rating">view '+data[i].view_count+'</h4>';
                    html += '				<h3 class="item_price">price : '+data.itemList[i].price+'</h4> ';
                    html += '				<h3 class="item_limitDate">D-day : '+data.itemList[i].receive+'</h4>';
                    html += '				<h3 class="item_location">location : '+data.itemList[i].location+'</h4>';
                    html += '				<h3 class="seller_name">'+data.itemList[i].midx+'.'+data.itemList[i].name+' | 평균 ★ '+data.itemList[i].rvs_avg+'(총 '+data.itemList[i].rvs_totalRow+'건)</h4>';
                    html += '		</div>';
                    html += '	</button>';


                } // for end

                html += '</div>';


                // 표시되는 위치
                $("#itemlist_small_area").html(html);
			   
                
				// items = JSON.stringify(data);
				// alert('items : '+items);
				
				//itemlist_print(data);
                itemlist_print();

			} // success end

		});

	}; // itemlist() end