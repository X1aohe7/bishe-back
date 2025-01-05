package com.it.address.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.address.mapper.AddressMapper;
import com.it.address.service.AddressService;
import com.it.common.entity.Address;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Override
    public List<Address> findByUid(@Nonnull Integer uid) {
        LambdaQueryWrapper<Address> queryWrapper = Wrappers.lambdaQuery(Address.class);
        queryWrapper.eq(Address::getUserId, uid);
        return baseMapper.selectList(queryWrapper);
    }
}
