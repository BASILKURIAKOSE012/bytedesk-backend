package com.bytestrone.bytedesk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestrone.bytedesk.model.InfoModel;
import com.bytestrone.bytedesk.repository.InfoRepo;
import com.bytestrone.bytedesk.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoRepo infoRepo;

	// to save the reassigned info

	@Override
	public InfoModel postReassignRequest(InfoModel info) {
		
		
		
		if(info != null) {
			return infoRepo.save(info);
		}
		
		else {
			return null;
		}
	}

	// to get the reassigned info
	@Override
	public List<InfoModel> getRequestById(String requestId) {

		return infoRepo.findAllByrequestId(requestId);
	}

}
