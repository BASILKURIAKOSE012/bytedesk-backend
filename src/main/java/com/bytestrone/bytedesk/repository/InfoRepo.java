package com.bytestrone.bytedesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestrone.bytedesk.model.InfoModel;
@Repository
public interface InfoRepo extends JpaRepository<InfoModel, Long> {

	List<InfoModel> findAllByrequestId(String requestId);

}
