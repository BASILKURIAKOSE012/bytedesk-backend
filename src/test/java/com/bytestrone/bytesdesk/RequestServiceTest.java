package com.bytestrone.bytesdesk;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.bytestrone.bytedesk.model.RequestModel;
import com.bytestrone.bytedesk.repository.RequestRepo;
import com.bytestrone.bytedesk.service.RequestService;
import com.bytestrone.bytedesk.serviceimpl.RequestServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = RequestServiceImpl.class)
class RequestServiceTest {
	@Autowired
	RequestService service;

	@MockBean
	private RequestRepo requestRepo;

	@Test
	@DisplayName("test update resolve status success")
	void testUpdateResolveSuccess() {
		RequestModel response = new RequestModel();
		response.setRequestId("TID1000");
		response.setTicketStatus("Requested");
		when(requestRepo.findByRequestId("TID1000")).thenReturn(response);
		service.resolveRequest("TID1000", response);
		RequestModel updatedResponse = requestRepo.findByRequestId("TID1000");
		assertEquals("Resolved", updatedResponse.getTicketStatus());
		verify(requestRepo).save(updatedResponse);
	}

	@Test
	@DisplayName("test update resolve status failure")
	void testUpdateResolveFailure() {
		RequestModel response = new RequestModel();
		response.setRequestId("TID1000");
		response.setTicketStatus("Requested");
		when(requestRepo.findByRequestId("TID1000")).thenReturn(response);
		service.resolveRequest("TID1000", response);
		RequestModel updatedResponse = requestRepo.findByRequestId(null);
		verify(requestRepo, times(0)).save(updatedResponse);
	}

	@Test
	@DisplayName("test update reassign status success")
	void testUpdateReassignSuccess() {
		RequestModel response = new RequestModel();
		response.setRequestId("TID1000");
		response.setTicketStatus("Requested");
		when(requestRepo.findByRequestId("TID1000")).thenReturn(response);
		System.out.println(response);
		System.out.println(response);
		service.reassignRequest("TID1000", response);
		RequestModel updatedResponse = requestRepo.findByRequestId("TID1000");
		assertEquals("Reassigned", updatedResponse.getTicketStatus());
		verify(requestRepo).save(updatedResponse);
	}

	@Test
	@DisplayName("test update reassign status failure")
	void testUpdateReassignFailure() {
		RequestModel response = new RequestModel();
		response.setRequestId("TID1000");
		response.setTicketStatus("Requested");
		when(requestRepo.findByRequestId("TID1000")).thenReturn(response);
		service.reassignRequest("TID1000", response);
		RequestModel updatedResponse = requestRepo.findByRequestId(null);
		verify(requestRepo, times(0)).save(updatedResponse);
	}

	@Test
	@DisplayName("test get requests success")
	 void testGetRequestsSuccess() {
		int pageNumber = 2;
		int pageSize = 10;
		String department = "IT";
		String ticketStatus = "Requested";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<RequestModel> sample = createDummyPage();
		when(requestRepo.findAllByDepartmentAndTicketStatus(pageable, department, ticketStatus)).thenReturn(sample);
		Page<RequestModel> result = service.getRequestsByStatusAndDepartment(pageNumber, pageSize, department,
				ticketStatus);
		assertEquals(sample, result);
	}

	@Test
	@DisplayName("test get requests failure")
	void testGetRequestsFailure() {
		List<RequestModel> requests = new ArrayList<RequestModel>();
		int pageNumber = 2;
		int pageSize = 10;
		String department = "IT";
		String ticketStatus = "Requested";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<RequestModel> sample = createDummyPage();
		when(requestRepo.findAllByDepartmentAndTicketStatus(pageable, department, ticketStatus)).thenReturn(sample);
		Page<RequestModel> result = service.getRequestsByStatusAndDepartment(pageNumber, pageSize, null, ticketStatus);
		verify(requestRepo, times(0)).findAllByDepartmentAndTicketStatus(pageable, department, ticketStatus);
	}

	private Page<RequestModel> createDummyPage() {
		Page<RequestModel> model = new Page<RequestModel>() {

			@Override
			public int getNumber() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getNumberOfElements() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<RequestModel> getContent() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasContent() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Sort getSort() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isFirst() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isLast() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Pageable nextPageable() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Pageable previousPageable() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterator<RequestModel> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getTotalPages() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getTotalElements() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public <U> Page<U> map(Function<? super RequestModel, ? extends U> converter) {
				// TODO Auto-generated method stub
				return null;
			}

		};
		return model;
	}
}
