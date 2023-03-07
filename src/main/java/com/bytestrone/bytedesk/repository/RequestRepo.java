package com.bytestrone.bytedesk.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestrone.bytedesk.model.RequestModel;
@Repository
public interface RequestRepo extends JpaRepository<RequestModel, String> {


	Page<RequestModel> findAllByDepartmentAndTicketStatus(Pageable pageable, String department, String ticketStatus);

	RequestModel findByRequestId(String requestId);

}
