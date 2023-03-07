package com.bytestrone.bytedesk.serviceimpl;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bytestrone.bytedesk.model.RequestModel;
import com.bytestrone.bytedesk.repository.RequestRepo;
import com.bytestrone.bytedesk.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestRepo requestRepo;

	// to get the requests based on status and Administrator department
	@Override
	public Page<RequestModel> getRequestsByStatusAndDepartment(int pageNumber, int pageSize, String department,
			String ticketStatus) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return requestRepo.findAllByDepartmentAndTicketStatus(pageable, department, ticketStatus);
	}



// to reassign the requests
	@Override
	public RequestModel resolveRequest(String requestId, RequestModel requestModel) {
		RequestModel existingRequest = requestRepo.findByRequestId(requestId);
		existingRequest.setInfo(requestModel.getInfo());
		existingRequest.setTicketStatus("Resolved");
		existingRequest.setResolvedDate(LocalDate.now());
		requestRepo.save(existingRequest);
		return existingRequest;
	}

	// to resolve the requests
	@Override
	public RequestModel reassignRequest(String requestId, RequestModel requestModel) {
		RequestModel existingRequest = requestRepo.findByRequestId(requestId);
		existingRequest.setInfo(requestModel.getInfo());
		existingRequest.setTicketStatus("Reassigned");
		requestRepo.save(existingRequest);
		return existingRequest;

	}

}
