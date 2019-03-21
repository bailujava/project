package com.buka.bailu.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketReferer;
import com.buka.bailu.constant.Constant;


import java.util.ArrayList;
import java.util.List;


public class ChainController {
    OSSClient ossClient = new OSSClient(Constant.endpoint, Constant.accessKeyId, Constant.accessKeySecret);
    public  void set(){
        List<String> refererList = new ArrayList<String>();
// 添加Referer白名单。Referer参数支持通配符星号（*）和问号（？）。
        refererList.add("http://www.buka.tv");
        refererList.add("http://www.*.com");
        refererList.add("http://www.?.aliyuncs.com");
// 设置存储空间Referer列表。设为true表示Referer字段允许为空。
        BucketReferer br = new BucketReferer(true, refererList);
        ossClient.setBucketReferer(Constant.bucketName, br);

// 关闭OSSClient。
        ossClient.shutdown();
    }

    public void get(){
// 获取存储空间Referer白名单列表。
        BucketReferer br = ossClient.getBucketReferer(Constant.bucketName);
        List<String> refererList = br.getRefererList();
        for (String referer : refererList) {
            System.out.println(referer);
        }
        ossClient.shutdown();
    }

    public  void cleanAll(){
        // 防盗链不能直接清空，需要新建一个允许空Referer的规则来覆盖之前的规则。
        BucketReferer br = new BucketReferer();
        ossClient.setBucketReferer(Constant.bucketName, br);
        ossClient.shutdown();
    }
}
