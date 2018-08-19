package com.baizhi.Lorry.service;

import java.util.List;

import com.baizhi.Lorry.entity.D_sort;
import com.baizhi.Lorry.entity.D_user;

public interface LoginService {
	public D_user login(String email,String password);

}
