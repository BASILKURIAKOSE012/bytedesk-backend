package com.bytestrone.bytedesk.service;



import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.bytestrone.bytedesk.model.RequestModel;

@Service
public interface RequestService {


	Page<RequestModel> getRequestsByStatusAndDepartment(int pageNumber, int pageSize, String department,
			String ticketStatus);

	RequestModel resolveRequest(String requestId, RequestModel requestModel);

	RequestModel reassignRequest(String requestId, RequestModel requestModel);

}
