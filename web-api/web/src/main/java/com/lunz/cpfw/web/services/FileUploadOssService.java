package com.lunz.cpfw.web.services;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.tb_product_allannex;
import com.lunz.cpfw.web.interfaces.IFileUploadService;
import com.lunz.cpfw.web.mappers.tb_product_allannexMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Future;

@Service
public class FileUploadOssService extends ServiceBase<tb_product_allannexMapper, tb_product_allannex>
        implements IFileUploadService {

    @Value("${aliyun.oss.access-id}")
    private String accessKeyId;

    @Value("${aliyun.oss.access-key}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucket}")
    private String bucketName;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.dir}")
    private String folder;

    @Override
    public Future<WebApiResult> fileUploadOss(HttpServletRequest request) {
        AsyncResult<WebApiResult> result = null;
        String curId = getUserId();
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        // List<MultipartFile> files = params.getFiles("file");
        List<MultipartFile> files = params.getFiles("file[]");
        // String id = params.getParameter("id");
        List<Map<String, Object>> mapList = new ArrayList<>();

        List<String> urls = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                // if (file != null && id != null && id != "")
                if (file != null) {
                    Map<String, Object> map = new HashMap<>();
                    String url = getFileOssUrl(file);
                    urls.add(url);

                    if (url != null) {
                        tb_product_allannex allannex = new tb_product_allannex();
                        // allannex.setBusinessid(id);
                        allannex.setType(file.getContentType());
                        allannex.setName(file.getOriginalFilename());
                        allannex.setUrl(url);
                        allannex.setCreatedat(new Date());
                        allannex.setCreatedbyid(curId);
                        allannex.setUpdatedat(new Date());
                        allannex.setUpdatedbyid(curId);
                        allannex.setJsonstring(JSON.toJSONString(allannex));
                        insert(allannex);
                        map.put("name", file.getOriginalFilename());
                        map.put("url", url);
                        mapList.add(map);
                    }
                }
            }
            result = new AsyncResult<WebApiResult>(WebApiResult.ok(mapList));

        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }
        return result;
    }

    public String getFileOssUrl(MultipartFile file) {
        String res = null;
        Date expiration = new Date(new Date().getTime() + 60000 * 100);
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();

            String fileName = file.getOriginalFilename();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(inputStream.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(file.getContentType());
            metadata.setContentDisposition("filename=" + fileName);

            ossClient.putObject(bucketName, folder + fileName, inputStream, metadata);
            String url = ossClient.generatePresignedUrl(bucketName, folder + fileName, expiration).toString();
            res = url.substring(0, url.indexOf("?"));
        } catch (Exception ex) {
            res = null;
        }
        return res;
    }

}