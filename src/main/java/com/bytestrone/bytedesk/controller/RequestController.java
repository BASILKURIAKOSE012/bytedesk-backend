package com.bytestrone.bytedesk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestrone.bytedesk.model.RequestModel;
import com.bytestrone.bytedesk.service.RequestService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RequestController {

	@Autowired
	private RequestService requestService;
	// to get the requests based on status and Administrator department

	@GetMapping("/requests/{pageNumber}/{pageSize}/{department}/{ticketStatus}")
	public ResponseEntity<Map<String, Object>> getRequestByStatusAndAdminDepartment(
			@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize,
			@PathVariable("department") String department, @PathVariable("ticketStatus") String ticketStatus) {
		Page<RequestModel> availableRequests = requestService.getRequestsByStatusAndDepartment(pageNumber, pageSize,
				department, ticketStatus);
		List<RequestModel> userRequests = availableRequests.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("userRequests", userRequests);
		response.put("currentPage", availableRequests.getNumber());
		response.put("totalItems", availableRequests.getTotalElements());
		response.put("totalPages", availableRequests.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	// to resolve the requests

	@PutMapping("/resolve/{requestId}")
	public ResponseEntity<RequestModel> resolveRequests(@PathVariable("requestId") String requestId,
			@RequestBody RequestModel requestModel) {
		return new ResponseEntity<RequestModel>(requestService.resolveRequest(requestId, requestModel), HttpStatus.OK);
	}

//	to reassign the requests 

	@PutMapping("/reassign/{requestId}")
	public ResponseEntity<RequestModel> reassignRequests(@PathVariable("requestId") String requestId,
			@RequestBody RequestModel requestModel) {
		return new ResponseEntity<RequestModel>(requestService.reassignRequest(requestId, requestModel), HttpStatus.OK);
	}

}
