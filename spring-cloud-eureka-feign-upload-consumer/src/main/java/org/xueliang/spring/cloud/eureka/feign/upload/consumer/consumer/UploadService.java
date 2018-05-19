package org.xueliang.spring.cloud.eureka.feign.upload.consumer.consumer;

import feign.Request;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "spring-cloud-eureka-feign-upload-client", configuration = UploadService.MultipartSupportConfig.class)
public interface UploadService {

    @RequestMapping(value = "/api/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile multipartFile);

    @Configuration
    class MultipartSupportConfig {

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }

        @Bean
        Request.Options feignOptions() {
            return new Request.Options(/**connectTimeoutMillis**/10 * 1000, /** readTimeoutMillis **/10 * 1000);
        }
    }
}
