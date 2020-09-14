package com.wifi.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentEditRequest;
import com.wifi.comment.model.CommentListView;
import com.wifi.comment.model.CommentRegRequest;
import com.wifi.comment.service.CommentDeleteService;
import com.wifi.comment.service.CommentEditService;
import com.wifi.comment.service.CommentListService;
import com.wifi.comment.service.CommentRegService;

@RestController
@RequestMapping("/comments")
public class CommentRestController {
	
	@Autowired
	private CommentListService listService;
	@Autowired
	private CommentRegService regService;
	@Autowired
	private CommentDeleteService deleteService;
	@Autowired
	private CommentEditService editService;

	
	@GetMapping
	public CommentListView getCommentList(HttpServletRequest request){
		
		System.out.println("In CommentRestController - request ▶ "+request);
		
		CommentListView commentListView = null;
		commentListView = listService.getCommentList(request);
		
		return commentListView;
	}
	
	// 댓글 등록
	@PostMapping
	@ResponseBody
	public int regComment(CommentRegRequest regRequest, HttpServletRequest request) {
		
		System.out.println("In Controller - CommentRegRequest ▶ "+ regRequest);
		
		return regService.regComment(regRequest, request);
		
	}
	
	@DeleteMapping("/{cidx}")
	public int deleteComment(@PathVariable("cidx") int cidx) {
		
		return deleteService.deleteComment(cidx);
	}
	
	@PostMapping("/{cidx}")
	public int editComment(@PathVariable("cidx") int cidx, CommentEditRequest editRequest, HttpServletRequest request) {
		
		System.out.println("In Controller - CommentEditRequest ▶ "+ editRequest);

		editRequest.setCidx(cidx);
		
		return editService.editComment(editRequest, request);
		
	}
	
}
