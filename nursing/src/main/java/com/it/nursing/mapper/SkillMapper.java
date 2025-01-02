package com.it.nursing.mapper;


import com.it.common.entity.Skill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SkillMapper {
    List<Skill> getSkill(int nid);


}
