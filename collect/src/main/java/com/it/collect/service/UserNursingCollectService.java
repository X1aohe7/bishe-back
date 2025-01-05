package com.it.collect.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.collect.mapper.UserNurSingCollectMapper;
import com.it.common.entity.Nursing;
import com.it.common.entity.UserNursingCollect;
import jakarta.annotation.Nonnull;

import java.util.List;

public interface UserNursingCollectService extends IService<UserNursingCollect> {
    void remove(@Nonnull Integer uid, @Nonnull Integer nid);

    List<Nursing> findByUid(@Nonnull Integer uid);
}
