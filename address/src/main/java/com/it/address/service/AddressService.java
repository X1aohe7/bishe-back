package com.it.address.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.it.common.entity.Address;
import jakarta.annotation.Nonnull;

import java.util.List;


public interface AddressService extends IService<Address> {

    /**
     * 根据用户id获取用户的所有可用的地址
     */
    List<Address> findByUid(@Nonnull Integer uid);
}
