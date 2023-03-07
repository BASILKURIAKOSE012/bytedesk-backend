package com.bytestrone.bytesdesk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bytestrone.bytedesk.model.InfoModel;
import com.bytestrone.bytedesk.repository.InfoRepo;
import com.bytestrone.bytedesk.service.InfoService;
import com.bytestrone.bytedesk.serviceimpl.InfoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = InfoServiceImpl.class)
 class InfoServiceTest {

	@Autowired
	private InfoService infoService;

	@MockBean
	private InfoRepo infoRepo;

	@Test
	@DisplayName("test post request success")
	 void requestTestSuccess() {
		InfoModel request = new InfoModel();
		infoService.postReassignRequest(request);
		verify(infoRepo, times(1)).save(request);
	}

	@Test
	@DisplayName("test post request failure")

	 void requestTestFailure() {
		InfoModel request = new InfoModel();
		infoService.postReassignRequest(null);
		verify(infoRepo, times(0)).save(null);
	}

	@Test
	@DisplayName("test get request success")
	 void getRequestsTestSuccess() {
		List<InfoModel> lists = new ArrayList<InfoModel>();
		InfoModel request = new InfoModel();
		request.setRequestId("TID1000");
		lists.add(request);
		when(infoRepo.findAllByrequestId("TID1000")).thenReturn(lists);
		infoService.getRequestById("TID1000");
		verify(infoRepo).findAllByrequestId("TID1000");
		assertEquals(lists, infoService.getRequestById("TID1000"));
	}

	@Test
	@DisplayName("test get request failure")
	 void getRequestsTestFailure() {
		List<InfoModel> lists = new ArrayList<InfoModel>();
		InfoModel request = new InfoModel();
		request.setRequestId("TID1000");
		lists.add(request);
		when(infoRepo.findAllByrequestId("TID1000")).thenReturn(lists);
		infoService.getRequestById(null);
		verify(infoRepo, times(0)).findAllByrequestId("TID1000");

	}

}
