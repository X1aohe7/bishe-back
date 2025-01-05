package com.it.collect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.collect.client.NursingServiceClient;
import com.it.collect.mapper.UserNurSingCollectMapper;
import com.it.collect.service.UserNursingCollectService;
import com.it.common.entity.Nursing;
import com.it.common.entity.UserNursingCollect;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserNursingCollectServiceImpl extends ServiceImpl<UserNurSingCollectMapper, UserNursingCollect>
        implements UserNursingCollectService {

    @Autowired
    private NursingServiceClient nursingServiceClient;

    @Override
    public void remove(@Nonnull Integer uid, @Nonnull Integer nid) {
        LambdaQueryWrapper<UserNursingCollect> queryWrapper =
                Wrappers.lambdaQuery(UserNursingCollect.class);
        queryWrapper.eq(UserNursingCollect::getNursingId, nid).eq(UserNursingCollect::getUserId, uid);
        baseMapper.delete(queryWrapper);
    }

    @Override
    public List<Nursing> findByUid(@Nonnull Integer uid) {
        LambdaQueryWrapper<UserNursingCollect> q =
                Wrappers.lambdaQuery(UserNursingCollect.class);
        q.eq(UserNursingCollect::getUserId, uid);
        List<UserNursingCollect> userNursingCollects = baseMapper.selectList(q);
        List<Integer> collect =
                userNursingCollects.stream().map(UserNursingCollect::getNursingId).collect(Collectors.toList());
        return collect.stream().map(nursingServiceClient::getNurseById).collect(Collectors.toList());
    }


}