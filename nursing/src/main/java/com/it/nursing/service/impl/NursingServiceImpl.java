package com.it.nursing.service.impl;

import com.it.common.entity.Nursing;
import com.it.common.entity.Skill;
import com.it.common.entity.UserNursingComment;
import com.it.nursing.mapper.NursingMapper;
import com.it.nursing.mapper.SkillMapper;
import com.it.nursing.service.NursingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NursingServiceImpl implements NursingService {
    @Autowired
    private NursingMapper nursingMapper;

    @Autowired
    private SkillMapper skillMapper;

    private static Map<Integer , List<String>> map = new HashMap<>();

    public List<Nursing> getAllNursing() {
        List<Nursing> list = nursingMapper.selectList(null);
//        System.out.println(list.get(0).getNurseName());
        for (Nursing n : list) {
            int id = n.getNursingId();
            List<Skill> skillList = skillMapper.getSkill(id);

            for (Skill s : skillList) {
                n.addList(s);
            }
        }
        return list;

    }


    public List<Nursing> getNurseByCondition(String query,int pageSize,int pageNum){
//        System.out.println(query+'!'+pageNum+'!'+pageSize);
        List<Nursing> list = nursingMapper.conditionSearch(query, pageSize, pageNum);
        System.out.println(list.toString());
        for(Nursing n : list){
            int id=n.getNursingId();
            List<Skill> skillList=skillMapper.getSkill(id);

            for(Skill s :skillList){
                n.addList(s);
            }

        }

        return list;
    }

    public Integer getCount(String query) {


        return nursingMapper.getCount(query);
    }

    public Nursing getNurseById(int id) {
        Nursing n=nursingMapper.findNurseById(id);
        List<Skill> skillList=skillMapper.getSkill(id);
        for(Skill s :skillList){
            n.addList(s);
        }
        return n;
    }

    public List<UserNursingComment> getNurseCommentById(int id){
        return nursingMapper.findNurseCommentById(id);
    }
}
