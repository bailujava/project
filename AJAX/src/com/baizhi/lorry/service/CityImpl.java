package com.baizhi.lorry.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.baizhi.lorry.dao.UserDao;
import com.baizhi.lorry.entity.User;
import com.baizhi.util.MyBatisUtil;

public class CityImpl{ 


	public HashMap<String, List> cha() {
			HashMap<String, List> city = new HashMap<String, List>();
			List<String> BJ=new ArrayList();
			List<String> TJ=new ArrayList();
			List<String> SH=new ArrayList();
			BJ.add("城东");
			BJ.add("城西");
			TJ.add("南开");
			TJ.add("桥西");
			SH.add("浦东");
			SH.add("浦西");
			city.put("beijing", BJ);
			city.put("tianjin", TJ);
			city.put("shanghai", SH);
			
		return city;
	}

}
