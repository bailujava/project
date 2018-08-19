package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.entity.D_receivce_address;

public interface AddressService {
public  List<D_receivce_address> queryAddressById(Integer id);
public void addAddress(D_receivce_address address);
public	D_receivce_address queryAddress(Integer id);
}
