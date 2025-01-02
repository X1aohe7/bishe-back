package com.it.nursing.controller;

import com.it.common.entity.Nursing;
import com.it.common.entity.UserNursingComment;
import com.it.nursing.service.NursingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RequestMapping("/nursing")
@RestController
public class NursingController {

    @Autowired
    private NursingService nursingService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllNursing(){
        List<Nursing> list=nursingService.getAllNursing();
        if(list!=null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else{ return new ResponseEntity<>("查询失败", HttpStatus.BAD_REQUEST);}
    }

//    @GetMapping("/test")
//    public String test(){
//        return "ok";
//    }
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> getNurseByCondition(@RequestParam("query")String query,
                                                                   @RequestParam("pageSize")int pageSize,
                                                                   @RequestParam("pageNum")int pageNum){
//        System.out.println(query+'!'+pageNum+'!'+pageSize);
        List<Nursing> list=nursingService.getNurseByCondition(query,pageSize,pageNum);

        Integer total=nursingService.getCount(query);

        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("list", list);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/getNurseById")
    public ResponseEntity<Object> getNurseById(@RequestParam("id") int id){
        return new ResponseEntity<>(nursingService.getNurseById(id), HttpStatus.OK);
    }

    @GetMapping("/getNurseCommentById")
    public ResponseEntity<List<UserNursingComment>> getNurseCommentByid(@RequestParam("id") int id){
        List<UserNursingComment> nurseComment = nursingService.getNurseCommentById(id);
        return new ResponseEntity<>(nurseComment, HttpStatus.OK);

    }
}
