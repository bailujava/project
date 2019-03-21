package com.buka.bailu.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketLoggingResult;
import com.aliyun.oss.model.SetBucketLoggingRequest;
import com.buka.bailu.constant.Constant;

import static com.buka.bailu.constant.Constant.accessKeySecret;

public class LogController {
    OSSClient ossClient = new OSSClient(Constant.endpoint, Constant.accessKeyId, accessKeySecret);

    //  开启存储空间的访问日志记录
    public void open(String BucketName) {
        SetBucketLoggingRequest request = new SetBucketLoggingRequest("<yourSourceBucketName>");
// 设置存放日志文件的存储空间。
        request.setTargetBucket(BucketName);
// 设置日志文件存放的目录。
        request.setTargetPrefix("<yourTargetPrefix>");
        ossClient.setBucketLogging(request);

// 关闭OSSClient。
        ossClient.shutdown();
    }

    //查看存储空间的访问日志设置
    public void queryBucket(String BucketName) {
        BucketLoggingResult result = ossClient.getBucketLogging(BucketName);
        System.out.println(result.getTargetBucket());
        System.out.println(result.getTargetPrefix());
        ossClient.shutdown();
    }

    //关闭存储空间的访问日志记录
    public void close(String BucketName) {
        SetBucketLoggingRequest request = new SetBucketLoggingRequest(Constant.bucketName);
        request.setTargetBucket(null);
        request.setTargetPrefix(null);
        ossClient.setBucketLogging(request);

// 关闭OSSClient。
        ossClient.shutdown();
    }

}
