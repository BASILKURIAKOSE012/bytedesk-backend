package com.bytestrone.bytedesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestrone.bytedesk.model.InfoModel;
import com.bytestrone.bytedesk.service.InfoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InfoController {
	@Autowired
	private InfoService infoService;

	// to save the reassigned info

	@PostMapping("/inforequest")
	public ResponseEntity<InfoModel> postRequestByRequestId(@RequestBody InfoModel info) {
		return new ResponseEntity<>(infoService.postReassignRequest(info), HttpStatus.CREATED);
	}
	
	// to get the reassigned info

	@GetMapping("/reassigned/{requestId}")
	public ResponseEntity<List<InfoModel>> getRequestsById(@PathVariable("requestId") String requestId) {
		return new ResponseEntity<List<InfoModel>>(infoService.getRequestById(requestId), HttpStatus.OK);

	}

}
