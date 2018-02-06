

/**
 * 示例说明
 * 
 * HelloOSS是OSS Java SDK的示例程序，您可以修改endpoint、accessKeyId、accessKeySecret、bucketName后直接运行。
 * 运行方法请参考README。
 * 
 * 本示例中的并不包括OSS Java SDK的所有功能，详细功能及使用方法，请参看“SDK手册 > Java-SDK”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/preface.html?spm=5176.docoss/sdk/java-sdk/。
 * 
 * 调用OSS Java SDK的方法时，抛出异常表示有错误发生；没有抛出异常表示成功执行。
 * 当错误发生时，OSS Java SDK的方法会抛出异常，异常中包括错误码、错误信息，详细请参看“SDK手册 > Java-SDK > 异常处理”，
 * 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/exception.html?spm=5176.docoss/api-reference/error-response。
 * 
 * OSS控制台可以直观的看到您调用OSS Java SDK的结果，OSS控制台地址是：https://oss.console.aliyun.com/index#/。
 * OSS控制台使用方法请参看文档中心的“控制台用户指南”， 指南的来链接地址是：https://help.aliyun.com/document_detail/oss/getting-started/get-started.html?spm=5176.docoss/user_guide。
 * 
 * OSS的文档中心地址是：https://help.aliyun.com/document_detail/oss/user_guide/overview.html。
 * OSS Java SDK的文档地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/install.html?spm=5176.docoss/sdk/java-sdk。
 * 
 */
package com.bootdo.common.utils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.BucketInfo;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: AliyunOSSUtil 
 * @Description: TODO 阿里云OSS文件存储工具类
 * @author: hayder
 * @date: 2016年11月29日 上午10:16:02  
 */
@Component
@ConfigurationProperties(prefix="aliyun.oss")
public class AliyunOSSUtil {
    static Logger logger = Logger.getLogger(AliyunOSSUtil.class);
    // endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
    // 如果您还没有创建Bucket，endpoint选择请参看文档中心的“开发人员指南 > 基本概念 > 访问域名”，
    // 链接地址是：https://help.aliyun.com/document_detail/oss/user_guide/oss_concept/endpoint.html?spm=5176.docoss/user_guide/endpoint_region
    // endpoint的格式形如“http://oss-cn-hangzhou.aliyuncs.com/”，注意http://后不带bucket名称，
    // 比如“http://bucket-name.oss-cn-hangzhou.aliyuncs.com”，是错误的endpoint，请去掉其中的“bucket-name”。
//    @Value("#{configProperties['aliyun.oss.endpoint']}")
    private  String endpoint;

    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
//    @Value("#{configProperties['aliyun.oss.accessKeyId']}")
    private  String accessKeyId;
//    @Value("#{configProperties['aliyun.oss.accessKeySecret']}")
    private  String accessKeySecret;

    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
//    @Value("#{configProperties['aliyun.oss.bucketName']}")
    private  String bucketName;

    // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private static String firstKey = "my-first-key";

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    /**
	 * @Title: getOSSClient 
	 * @Description: TODO 获取OSS客户端
	 * @return
	 * @return: OSSClient
	 */
	public  synchronized OSSClient getOSSClient() {
        OSSClient ossClient=null;
		try {
			 ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取OSS客户端异常", e);
		}
        return ossClient;
    }
	

    /**
     * 线程等待时间
     * @param seconds 等待时间（秒）
     */
    public void sleep(int seconds) {
        if (seconds <= 0) {
            return;
        }
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    /** 
     * @Title: uploadFileToOSS  
     * @Description: TODO 上传文件到OSS
     * @param srcFile 文件对象
     * @param saveKey 保存文件地址 如"sjxd/test.txt"
     * @return: String 返回外部调用URL
     */
    public  String uploadFileToOSS(File srcFile, String saveKey){
    	 logger.info("started...");
    	if(saveKey.indexOf("/") == 0){
    		saveKey = saveKey.substring(1, saveKey.length());
    	}

    	//获取客户端
    	OSSClient ossClient	= getOSSClient();
        try {
        	 if(StringUtils.isBlank(bucketName)){
				 logger.info("阿里云OSS配置错误，找不到Bucket配置！");
				 return null;
			 }
			 if (ossClient.doesBucketExist(bucketName)) {
                 logger.info("您已经创建Bucket：" + bucketName + "。");
             } else {
                 logger.info("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                 // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
                 // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
                 ossClient.createBucket(bucketName);
             }
            // 上传文件
        	ossClient.putObject(bucketName, saveKey, srcFile);
            return "/" + saveKey;
        } catch (Exception e) {
            logger.error("OSS上传"+srcFile.getName()+"文件出错,停止上传该文件!", e);
        }finally {
            ossClient.shutdown();
        }
        logger.info("Completed");
        return "/" + saveKey;
    }

  
    /** 
     * 验证OSS上是否存在名称为bucketName的Bucket 
     * @param oss
     * @param bucketName 
     * @return 
     */  
    public boolean checkBucketExists (OSSClient oss, String bucketName) {  
        List<Bucket> buckets = oss.listBuckets();
        for (Bucket bucket : buckets) {
            if (Objects.equals(bucket.getName(), bucketName)) {  
                return true;  
            }  
        }
        return false;  
    } 
    
    /** 
     * @Title: downOutputStream 
     * @Description: TODO 输出文件流，用于下载
     * @param out 文件输出流
     * @param key 文件地址
     * @return: void
     */
    public void downOutputStream(OutputStream out,String key) {  
    	//获取客户端
    	OSSClient ossClient= getOSSClient();
         try {
        	 OSSObject ossObject=null;
        	 try {
        		  ossObject = ossClient.getObject(bucketName, key);
    	 	  } catch (Exception e) {
				 out.write("文件不存在！".getBytes());
				 return;
			  }
        	 byte[] buffer = new byte[8192];
        	 
        	 InputStream objectData = ossObject.getObjectContent();
        	 int bytesRead = 0;
        	 while ((bytesRead = objectData.read(buffer, 0, 8192)) != -1) {
			   out.write(buffer, 0, bytesRead);
        	 }
        	 objectData.close();
          } catch (Exception ase) {
        	  logger.error("下载异常！", ase);
          }finally{
        	  try {
        		  ossClient.shutdown();
        		  out.flush();
      	       	  out.close();
				} catch (Exception e) {
				}
          }
    }
     /** 
     * @Title: deleteFileFromOSS 
     * @Description: TODO 从OSS删除文件
     * @param saveKey 文件地址（不包含桶名）
     * @return: void
     */
    public  void deleteFileFromOSS(String saveKey) {
     	//获取客户端
    	 OSSClient ossClient= getOSSClient();
	    try {
	    	if(saveKey.indexOf("/") == 0){
	    		saveKey = saveKey.substring(1, saveKey.length());
	    	}
	    	ossClient.deleteObject(bucketName, saveKey);
	    } catch (Exception e) {
	         logger.error("OSS删除文件异常", e);
	    }finally{
	    	ossClient.shutdown();
	    }
     }
     
     public static void main(String[] args) {

         // 日志配置，OSS Java SDK使用log4j记录错误信息。示例程序会在工程目录下生成“oss-demo.log”日志文件，默认日志级别是INFO。
         // 日志的配置文件是“conf/log4j.properties”，如果您不需要日志，可以没有日志配置文件和下面的日志配置。
//         PropertyConfigurator.configure("conf/log4j.properties");
 //
//         logger.info("Started");

         // 生成OSSClient，您可以指定一些参数，详见“SDK手册 > Java-SDK > 初始化”，
         // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
//         OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//         try {
//
//             // 判断Bucket是否存在。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//             if (ossClient.doesBucketExist(bucketName)) {
//                 System.out.println("您已经创建Bucket：" + bucketName + "。");
//             } else {
//                 System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
//                 // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//                 // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//                 ossClient.createBucket(bucketName);
//             }
//
//             // 查看Bucket信息。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//             BucketInfo info = ossClient.getBucketInfo(bucketName);
//             System.out.println("Bucket " + bucketName + "的信息如下：");
//             System.out.println("\t数据中心：" + info.getBucket().getLocation());
//             System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
//             System.out.println("\t用户标志：" + info.getBucket().getOwner());
//
//             // 把字符串存入OSS，Object的名称为firstKey。详细请参看“SDK手册 > Java-SDK > 上传文件”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/upload_object.html?spm=5176.docoss/user_guide/upload_object
//             InputStream is = new ByteArrayInputStream("Hello OSS".getBytes());
//             ossClient.putObject(bucketName, firstKey, is);
//             System.out.println("Object：" + firstKey + "存入OSS成功。");
//
//             // 下载文件。详细请参看“SDK手册 > Java-SDK > 下载文件”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/download_object.html?spm=5176.docoss/sdk/java-sdk/manage_object
//             OSSObject ossObject = ossClient.getObject(bucketName, firstKey);
//             InputStream inputStream = ossObject.getObjectContent();
//             StringBuilder objectContent = new StringBuilder();
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//             while (true) {
//                 String line = reader.readLine();
//                 if (line == null)
//                     break;
//                 objectContent.append(line);
//             }
//             inputStream.close();
//             System.out.println("Object：" + firstKey + "的内容是：" + objectContent);
//
//             // 文件存储入OSS，Object的名称为fileKey。详细请参看“SDK手册 > Java-SDK > 上传文件”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/upload_object.html?spm=5176.docoss/user_guide/upload_object
//             String fileKey = "README.md";
//             ossClient.putObject(bucketName, fileKey, new File("README.md"));
//             System.out.println("Object：" + fileKey + "存入OSS成功。");
//
//             // 查看Bucket中的Object。详细请参看“SDK手册 > Java-SDK > 管理文件”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_object.html?spm=5176.docoss/sdk/java-sdk/manage_bucket
//             ObjectListing objectListing = ossClient.listObjects(bucketName);
//             List<OSSObjectSummary> objectSummary = objectListing.getObjectSummaries();
//             System.out.println("您有以下Object：");
//             for (OSSObjectSummary object : objectSummary) {
//                 System.out.println("\t" + object.getKey());
//             }
//
//             // 删除Object。详细请参看“SDK手册 > Java-SDK > 管理文件”。
//             // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_object.html?spm=5176.docoss/sdk/java-sdk/manage_bucket
//             ossClient.deleteObject(bucketName, firstKey);
//             System.out.println("删除Object：" + firstKey + "成功。");
//             ossClient.deleteObject(bucketName, fileKey);
//             System.out.println("删除Object：" + fileKey + "成功。");
//
//         } catch (OSSException oe) {
//             oe.printStackTrace();
//         } catch (ClientException ce) {
//             ce.printStackTrace();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             ossClient.shutdown();
//         }
//
//         logger.info("Completed");
     }
     

}
