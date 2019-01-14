package com.handsome.common.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.handsome.common.model.oss.OssObjectKeys;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OssClientUtils {
    static Logger logger = Logger.getLogger(OssClientUtils.class);

    // endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
    // 如果您还没有创建Bucket，endpoint选择请参看文档中心的“开发人员指南 > 基本概念 > 访问域名”，
    // 链接地址是：https://help.aliyun.com/document_detail/oss/user_guide/oss_concept/endpoint.html?spm=5176.docoss/user_guide/endpoint_region
    // endpoint的格式形如“http://oss-cn-hangzhou.aliyuncs.com/”，注意http://后不带bucket名称，
    // 比如“http://bucket-name.oss-cn-hangzhou.aliyuncs.com”，是错误的endpoint，请去掉其中的“bucket-name”。
    private static final String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
    private static final String accessKeyId = "LTAIWMGa9tYAEreE";
    private static final String accessKeySecret = "37qAs3jwUbczd2Pq57zRMwUmrlZuPH";

    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static final String bucketName = "wedding-photos";

    // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private static String firstKey = "my-first-key";

    private static OSSClient ossClient;

    public static BucketInfo getBucketObject(){
        if(ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
        if (ossClient.doesBucketExist(bucketName)) {
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            ossClient.createBucket(bucketName);
        }
        return ossClient.getBucketInfo(bucketName);
    }

    public static String getObjectExpirUrl(String folder, String filename){
        if(ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
        if (ossClient.doesBucketExist(bucketName)) {
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            ossClient.createBucket(bucketName);
        }
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl(bucketName, folder + "/" + filename, expiration).toString();
        return url;
    }

    public static void uploadFile(String fileName, InputStream inputStream){
        if(ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
        if (ossClient.doesBucketExist(bucketName)) {
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            ossClient.createBucket(bucketName);
        }

        ossClient.putObject(bucketName, fileName, inputStream);
    }

    public static List<OssObjectKeys> getObjectKeyList(String bucketName){
        if(bucketName == null){
            bucketName = OssClientUtils.bucketName;
        }
        if(ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
        if (ossClient.doesBucketExist(bucketName)) {
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            ossClient.createBucket(bucketName);
        }
        List<OssObjectKeys> resultList = new ArrayList<>();
        ObjectListing objects = ossClient.listObjects(bucketName);
        List<OSSObjectSummary> objectSummaries = objects.getObjectSummaries();
        if(objectSummaries != null && objectSummaries.size() > 0) {
            for (OSSObjectSummary summary : objectSummaries) {
                String key = summary.getKey();
                if(key.contains("/")) {
                    if(key.trim().endsWith("/")){
                        resultList.add(new OssObjectKeys(key.substring(0, key.length() - 1), null));
                    } else if (key.trim().startsWith("/")) {
                        resultList.add(new OssObjectKeys(null, key.substring(1, key.length())));
                    } else {
                        String[] split = key.split("/");
                        resultList.add(new OssObjectKeys(split[0], split[1]));
                    }
                } else {
                    resultList.add(new OssObjectKeys(null, key));
                }
            }
        }
        return resultList;
    }

    public static void close(){
        ossClient.shutdown();
    }
}
