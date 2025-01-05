package com.it.healthinformation.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.common.entity.HealthInformation;
import com.it.healthinformation.mapper.HealthInformationMapper;
import com.it.healthinformation.service.HealthInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthInformationService {
    @Autowired
    private HealthInformationMapper healthInformationMapper;

    @Override
    public Long getTotal() {
        QueryWrapper<HealthInformation> wrapper = new QueryWrapper<>();
        return healthInformationMapper.selectCount(wrapper);
    }

    @Override
    public List<HealthInformation> getHealthInformationProfileByPage(int currentPage, int pageSize) {
        // 创建分页对象
        Page<HealthInformation> page = new Page<>(currentPage, pageSize);

        // 调用selectPage方法进行分页查询
        IPage<HealthInformation> healthInformationPage = healthInformationMapper.selectPage(page, null);

        return healthInformationPage.getRecords();
    }

    @Override
    public HealthInformation getHealthInformationDetail(int id) {
        return healthInformationMapper.selectById(id);
    }
}
