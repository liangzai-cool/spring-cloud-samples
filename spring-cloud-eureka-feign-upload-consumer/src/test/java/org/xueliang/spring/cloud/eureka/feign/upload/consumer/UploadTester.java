package org.xueliang.spring.cloud.eureka.feign.upload.consumer;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xueliang.spring.cloud.eureka.feign.upload.consumer.consumer.EurekaFeignUploadConsumerApplication;
import org.xueliang.spring.cloud.eureka.feign.upload.consumer.consumer.UploadService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EurekaFeignUploadConsumerApplication.class)
public class UploadTester {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadTester.class);

    @Autowired
    private UploadService uploadService;

    @Test
//    @SneakyThrows
    public void testHandleFileUpload() {
        URL url = this.getClass().getClassLoader().getResource("test.txt");
        System.out.println(url.getPath());
        File file = new File(url.getPath());
        DiskFileItem diskFileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.MULTIPART_FORM_DATA_VALUE, true, file.getName());
        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = diskFileItem.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(diskFileItem);
        LOGGER.info("data from client: " + uploadService.handleFileUpload(multipartFile));
    }
}
