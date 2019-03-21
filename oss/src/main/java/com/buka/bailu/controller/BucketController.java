
package com.buka.bailu.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.buka.bailu.constant.Constant;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BucketController {
    // 创建OSSClient实例。
    OSSClient ossClient = new OSSClient(Constant.endpoint, Constant.accessKeyId, Constant.accessKeySecret);


    public String BucketInfo() {
        // 存储空间的信息包括地域（Region或Location）、创建日期（CreationDate）、拥有者（Owner）、权限（Grants）等。
        BucketInfo info = ossClient.getBucketInfo(Constant.bucketName);
// 获取地域。
        String location = info.getBucket().getLocation();
// 获取创建日期。
        Date creationDate = info.getBucket().getCreationDate();
// 获取拥有者信息。
        Owner owner = info.getBucket().getOwner();
// 获取权限信息。
        Set<Grant> grants = info.getGrants();
        System.out.println(location + "---" + creationDate + "---" + owner + "---" + grants);
        return location + "---" + creationDate + "---" + owner + "---" + grants;
    }

    public  void listAll() {



        // 列举存储空间。
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
        }
        ossClient.shutdown();
    }

    public void createBucketName() {
        // 创建存储空间。
        String bucketName = "picture";
// 新建存储空间默认为标准存储类型，私有权限。
        ossClient.createBucket(bucketName);
        ossClient.shutdown();
    }

    public void delete(String BucketName) {
        // 删除存储空间。
        ossClient.deleteBucket(BucketName);
        ossClient.shutdown();
    }

    //是否存在
    public boolean exist() {
        boolean exists = ossClient.doesBucketExist("<yourBucketName>");
        ossClient.shutdown();
        return exists;
    }

    public void ListSome() {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
// 限定此次列举存储空间的个数为500。默认值为100，最大值为1000。
        listBucketsRequest.setMaxKeys(500);
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        for (Bucket bucket : bucketList.getBucketList()) {
            System.out.println(" - " + bucket.getName());
        }
        ossClient.shutdown();
    }

    public void changeRight() {
        // 设置存储空间的访问权限为私有。还有PublicRead，PublicReadWrite
        ossClient.setBucketAcl("<yourBucketName>", CannedAccessControlList.Private);
// 获取存储空间的访问权限。
        AccessControlList acl = ossClient.getBucketAcl("<yourBucketName>");
        System.out.println(acl.toString());
        ossClient.shutdown();
    }
}

