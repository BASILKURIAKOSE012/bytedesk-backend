package com.bytestrone.bytedesk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytestrone.bytedesk.model.InfoModel;

@Service
public interface InfoService {

	InfoModel postReassignRequest(InfoModel info);

	List<InfoModel> getRequestById(String requestId);

}
