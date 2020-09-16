package com.wifi.order.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wifi.order.model.ItemDTO;
import com.wifi.order.item.service.ItemDelService;
import com.wifi.order.item.service.ItemRegService;
import com.wifi.order.item.service.ItemViewService;
import com.wifi.order.item.service.ItemlistService;
import com.wifi.order.item.service.MyBuyerRejectService;
import com.wifi.order.item.service.MyBuyerReviewService;
import com.wifi.order.item.service.MyBuyerSelectService;
import com.wifi.order.item.service.MyItemBuyerService;
import com.wifi.order.item.service.MyItemHideService;
import com.wifi.order.item.service.MyItemService;
import com.wifi.order.item.service.QRService;
import com.wifi.order.model.ItemRegRequest;
import com.wifi.order.model.Item_rvb;
import com.wifi.order.model.MyBuyerDTO;
import com.wifi.order.model.MyItemDTO;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	
//	공구 리스트 관련---------------------------------- 
	
	@Autowired
	ItemlistService itemlistService;

	@Autowired
	ItemViewService viewService;

//	공구 등록. 수정. 삭제 관련----------------------------
	
	@Autowired
	ItemRegService regService;

	@Autowired
	ItemDelService delItemService;
	
//	내 공구 판매현황 관련----------------------------------
	
	@Autowired	//
	MyItemService myItemService;

	@Autowired
	MyItemBuyerService myBuyerService;

	
//	판매현황별 기능 관련----------------------------------
	
	@Autowired	// 참여자 구매자로 선정하기
	MyBuyerSelectService selectBuyerService;
	
	@Autowired	// 참여자 거절. 자동거절
	MyBuyerRejectService rejectBuyerService;
	
	@Autowired
	QRService getQRService;
	
	@Autowired
	MyBuyerReviewService rvBuyerService;
	
	@Autowired
	MyItemHideService hideService;
	
	
	
	
	
	
	
	

//	공구 리스트 관련---------------------------------- 
	
	// 추천 공구 리스트 : 최신순 정렬
	@GetMapping("/recomItem")
	public List<ItemDTO> getRecomItemlist(){
		
		return itemlistService.getRecomItemlist();
	}
	
	
	// 일반 공구 리스트 : 최신순 정렬
	@GetMapping
	public List<ItemDTO> getItemlist(){
		
		return itemlistService.getItemlist();
	}

	
	
	// 공구 상세보기
	@GetMapping("/{iidx}")
	public ItemDTO viewItem(@PathVariable("iidx") int iidx) {
		
		return viewService.viewItem(iidx);
	};

	
	
	
	
//	공구 등록. 수정. 삭제 관련----------------------------------
	
	// 공구 등록 : item 등록후 iidx 반환
	@PostMapping
	public int regItem(HttpServletRequest request, ItemRegRequest itemRequest) {
		
		System.out.println("판매글 등록 controller");
		return regService.regItem(request, itemRequest);
	};
	
	
	// 공구글 수정
//	@PostMapping("/{iidx}")
//	public int editItem(@PathVariable("iidx") int iidx) {
//		
//		System.out.println("내 판매글 수정 controller");
//		return editItemService.editItem(iidx); 
//	};
	
	
	// 공구글 삭제
	@DeleteMapping("/{iidx}")
	public int delItem(@PathVariable("iidx") int iidx) {
		
		System.out.println("내 판매글 삭제 controller");
		return delItemService.delItem(iidx); 
	};
	
	
	
	
	
//	내 공구 판매현황 관련----------------------------------
	
	// 내 판매글 
	@GetMapping("/myitem/{loginMidx}")
	public List<MyItemDTO> getMyItem(@PathVariable("loginMidx") int midx){
		
		System.out.println("내 판매글 리스트 controller");
		return myItemService.getMyItem(midx);
		
	};
	
	// 내 판매글 참여자리스트 
	@GetMapping("/mybuyer/{iidx}")
	public List<MyBuyerDTO> getMyItemBuyer(@PathVariable("iidx") int iidx){
		
		System.out.println("내 판매글 - 참여자리스트 controller");
		return myBuyerService.getMyItemBuyer(iidx);
		
	};

	
	
	
	
//	판매현황별 기능 관련----------------------------------
	
	// 나의 공구판매현황[모집중] - 참여자 구매자로 선정하기
	//public int selectBuyer(@PathVariable("iidx") int iidx, @RequestParam(value="buyerArr[]") List<Integer> buyer) {
	//public int selectBuyer(@RequestParam(value="iidx") int iidx, @RequestParam(value="buyerArr[]") List<Integer> buyer) {
	//public int selectBuyer(@RequestParam(value="iidx") int iidx, HttpServletRequest request) {
	//public int selectBuyer(@RequestBody ArrayList<Integer> buyerArr, @PathVariable("iidx") int iidx ) {
	// public int selectBuyer(@PathVariable("iidx") int iidx, @RequestParam(value = "buyerArr[]") List<String> buyerArr) {
//	public int selectBuyer(@RequestParam(value="iidx") int iidx, 
//					@RequestParam(value="buyerArr[]") List<Integer> buyer, @RequestParam(value="rejectArr[]", required =false, defaultValue="false") List<Integer> reject) {
//	public int selectBuyer(@RequestParam(value="iidx") String iidx, 
//			@RequestParam(value="buyerArr[]") List<Integer> buyerArr, @RequestParam(value="rejectArr[]", required =false) List<Integer> rejectArr) {
//	public int selectBuyer(@RequestBody JsonObject buyerArr) {
	//@PostMapping("/mybuyer")  // HttpServletRequest으로 받으면 controller 실행은 되는데, 배열이 null...
	//public int selectBuyer(HttpServletRequest request) {
	//public int selectBuyer(@RequestBody List<Integer> buyerArr) {
	//public int selectBuyer(@RequestBody HashMap<String, Object> map) {

	@PostMapping("/mybuyer")  // @RequestParam으로 받으면 controller 실행도 안된다..
	//public int selectBuyer(@RequestParam(value="oidxArr[]") String[] oidxArr) {
	public int selectBuyer(@RequestBody HashMap<String, Object> oidxArr) {  
			
		//String[] oidxArr = request.getParameterValues("oidxArr");
		
		System.out.println("참여자 구매자로 선정 controller");
		//System.out.println("iidx 확인 :" +iidx);
		//System.out.println("buyer 배열확인 toString : " + buyerArr.toString());
		//System.out.println("buyer 배열확인buyerArr.get(buyerArr) : " + buyerArr.get("buyerArr"));
		//System.out.println("buyer 배열확인 buyerArr.get(iidx) : " + buyerArr.get("iidx"));
		//System.out.println("buyer 배열확인 buyerArr.get(oidx) : " + buyerArr.get("oidx"));
		//System.out.println("map 배열확인 toString : " + map.toString());
		System.out.println("oidxArr 배열확인 toString : " + oidxArr.toString());  // {oidx=[ , ]} 이렇게나옴
		//int[] buyer = (int[]) buyerArr.get("buyerArr");
		//Object[] buyer = buyerArr.values().toArray();
		
		//System.out.println("oidxArr[0] : "+oidxArr[0]);
		//System.out.println("oidxArr[1] : "+oidxArr[1]);

		System.out.println("oidxArr.size() : "+oidxArr.size()); //1dl 나온다..
		System.out.println("oidxArr.get(0) : "+oidxArr.get(0));  //null이 나온다..
		
		//hashmap 값받아오는 방법공부필요..
		
		
//		int size = map.values().size();
//		//Object arr =map.get("oidxArr");
//		int[] oidxArr= new int[map.values().size()];
		
//		for(int i=0; i<size; i++) {
//			int arr = Integer.parseInt(arr.toString());
//		}
//		oidxArr=map.get("oidxArr");
		
//		Iterator entries = map.entrySet().iterator();
		
//		while (entries.hasNext()) {
//		    Map.Entry entry = (Map.Entry) entries.next();
//		    //Integer key = (Integer)entry.getKey();
//		    int value = (Integer)entry.getValue();
//		    //System.out.println("Key = " + key + ", Value = " + value);
//		    System.out.println("Value = " + value);
//		    //oidxArr.push(value);
//		}

		//return selectBuyerService.selectBuyer(iidx, buyer); 
		//return selectBuyerService.selectBuyer(buyerArr); 
		return 0;
	};
	
	
	
	// 나의 공구판매현황[모집중] - 참여자 거절하기
	@PutMapping("/rejectBuyer/{oidx}")
	public int rejectBuyer(@PathVariable("oidx") int oidx) {
		
		System.out.println("참여자 거절 controller");
		return rejectBuyerService.rejectBuyer(oidx); 
	};
	
	
	
	// 나의 공구판매현황[모집중. 판매실패] - 참여자 자동거절처리  
	// 구매자 선정하면 나머지 선택하지 않은 참여자, 판매실패하면 참여자 자동 거절처리
	@PutMapping("/rejectBuyer")
//	public int rejectBuyer(@PathVariable("iidx") int iidx, @RequestParam(value="buyer[]") String[] buyer) {
//	public int rejectBuyer(@PathVariable("iidx") int iidx, @RequestBody List<Integer> buyer) {
	public int rejectBuyer(@RequestBody HashMap<String, Object> oidxArr) {
		
		System.out.println("참여자 자동거절 controller");
		
		System.out.println("rejectArr 배열확인buyerArr.get(rejectArr) : " + oidxArr.get("oidxArr"));
		
		//int[] buyer = (int[]) buyerArr.get("buyerArr");
		//Object[] buyer = buyerArr.values().toArray();   //컬렉션에서 제공되는 메서드 toArray는 Object[] 로 변환밖에 안도 
		
		System.out.println("rejectArr 배열확인 toString : " + oidxArr.toString());

		//return rejectBuyerService.autoRejectBuyer(iidx, buyer); 
		return rejectBuyerService.autoRejectBuyer(oidxArr); 
	};
	
	
	
	
	// 나의 공구판매현황[모집완료] - QR생성
//	@GetMapping("/qr/{iidx}/{buyer}")
//	public String insertQR(@PathVariable("iidx") int iidx, @PathVariable("buyer") int midx) {
//		
//		System.out.println("QR생성 controller");
//		return insesrtQRService.insertQR(iidx, midx); 
//	};
	
	
	
	// 나의 공구판매현황[모집완료] - QR보기
	@GetMapping("/qr/{oidx}")
	public String getQR(@PathVariable("oidx") int oidx) {
		
		System.out.println("QR보기 controller");
		return getQRService.getQR(oidx); 
	};
	
	
	// 나의 공구판매현황[판매완료] - 구매자 평점등록하기
	@PostMapping("/review")
	public int reviewBuyer(Item_rvb rvb) {
		
		System.out.println("구매자 평점등록 controller");
		return rvBuyerService.reviewBuyer(rvb); 
	};
	
	
	// 나의 공구판매현황[판매완료, 판매실패] - 내 판매글 숨김
	@PutMapping("/hide/{iidx}")
	public int hideMyItem(@PathVariable("iidx") int iidx) {
		
		System.out.println("내 판매글 숨김 controller");
		return hideService.hideMyItem(iidx); 
	};
	

	
	
	
	

	

}
