package com.it.nursing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.common.entity.Nursing;
import com.it.common.entity.UserNursingComment;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface NursingMapper extends BaseMapper<Nursing> {
    List<Nursing> conditionSearch(String query, int pageSize, int pageNum);

    List<Nursing> findAll();

    List<Nursing> findByCondition(String query);

    List<Nursing> getNurseBySkill(String query);



    Integer getCount(String query);

    Nursing findNurseById(int id);

    List<UserNursingComment> findNurseCommentById(int id);

}
