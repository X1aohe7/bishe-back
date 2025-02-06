package com.it.nursing.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.it.common.config.RedisService;
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

    @Autowired
    private RedisService redisService;

//    private static Map<Integer , List<String>> map = new HashMap<>();

//    public List<Nursing> getAllNursing() {
//        List<Nursing> list = nursingMapper.selectList(null);
////        System.out.println(list.get(0).getNurseName());
//        for (Nursing n : list) {
//            int id = n.getNursingId();
//            List<Skill> skillList = skillMapper.getSkill(id);
//
//            for (Skill s : skillList) {
//                n.addList(s);
//            }
//        }
//        return list;
//
//    }

    public List<Nursing> getAllNursing() {
        String redisKey = "nursing:all"; // Redis Key
        List<Nursing> list;
        Object redisData = redisService.getValue(redisKey);

        if (redisData == null) {
            list = nursingMapper.selectList(null);
            for (Nursing n : list) {
                int id = n.getNursingId();
                List<Skill> skillList = skillMapper.getSkill(id);
                for (Skill s : skillList) {
                    n.addList(s);
                }
            }
            // 缓存数据到 Redis，设置 10 分钟过期时间
            redisService.setValue(redisKey, list, 600);
        } else {
            System.out.println("有缓存");
            list = JSONArray.parseArray(redisData.toString(), Nursing.class);
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

//    public Nursing getNurseById(int id) {
//        Nursing n=nursingMapper.findNurseById(id);
//        List<Skill> skillList=skillMapper.getSkill(id);
//        for(Skill s :skillList){
//            n.addList(s);
//        }
//        return n;
//    }
public Nursing getNurseById(int id) {
    String redisKey = "nursing:" + id;
    Nursing n;
    Object redisData = redisService.getValue(redisKey);
    if (redisData == null) {
//        n=null;
        n = nursingMapper.findNurseById(id);
        List<Skill> skillList = skillMapper.getSkill(id);
        for (Skill s : skillList) {
            n.addList(s);
        }
        // 缓存数据到 Redis，设置 10 分钟过期时间
        redisService.setValue(redisKey, n, 600);
    }else{
        System.out.println("有缓存");
        n = ((JSONObject) redisData).toJavaObject(Nursing.class);
    }



    return n;
}


//    public List<UserNursingComment> getNurseCommentById(int id){
//        return nursingMapper.findNurseCommentById(id);
//    }
    public List<UserNursingComment> getNurseCommentById(int id) {
        String redisKey = "nursing:comments:" + id;
        List<UserNursingComment> comments;
        Object redisData = redisService.getValue(redisKey);

        if (redisData == null) {
            comments = nursingMapper.findNurseCommentById(id);
            // 缓存 5 分钟
            redisService.setValue(redisKey, comments, 300);
        } else {
            System.out.println("有缓存");
            comments = JSONArray.parseArray(redisData.toString(), UserNursingComment.class);
        }

        return comments;
    }

}
