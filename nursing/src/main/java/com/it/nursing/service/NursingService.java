package com.it.nursing.service;

import com.it.common.entity.Nursing;
import com.it.common.entity.UserNursingComment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


public interface NursingService {

    List<Nursing> getAllNursing();
    List<Nursing> getNurseByCondition(String query, int pageSize, int pageNum);
    Integer getCount(String query);

    Nursing getNurseById(int id);

    List<UserNursingComment> getNurseCommentById(int id);
}
