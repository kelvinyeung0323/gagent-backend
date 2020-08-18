package com.kelvin.goodsagent.admin;

import com.kelvin.goodsagent.common.exception.BizException;
import com.kelvin.goodsagent.common.http.RestResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 9:37
 * @description:
 */
@RestController
@RequestMapping("admin")
@ConfigurationProperties(prefix = "gagent")
@Tag(name = "文件上传接口")
public class FileUploadController {


    @Value("${fileUploadPath:C:\\Users\\kelvin\\work\\projects\\goods-agent-backend\\upload}")
    private String path;

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    @Operation(tags = "单文件上传")
    @PostMapping(path = "uploadImage",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult fileUpload(@Parameter  @RequestPart("file") MultipartFile file) {
        return RestResult.success(saveFile(file));
    }

    @Operation(tags = "单文件上传")
    @PostMapping(path = "uploadImages",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RestResult fileUpload(@Parameter @RequestParam("file") MultipartFile[] files) {

        if(null ==files){
            throw new BizException("文件为空!");
        }
        List<String > fileNames=  Arrays.stream(files).parallel().map(f->{
            return saveFile(f);
        }).collect(Collectors.toList());
        return RestResult.success();
    }

    /**
     * 保存图片，反回相对路径
     * @param file
     * @return
     */
    private String saveFile(MultipartFile file) {

        if (file.isEmpty()) {
            throw new BizException("文件为空,请上传大小大于0的文件!");
        }

        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String randomStr = RandomStringUtils.random(5,true,true);
        String returnStr = dateStr + "/" + randomStr+"_" +file.getOriginalFilename();
        if(!path.endsWith("/")&& !path.endsWith("\\")){
            path = path + "/";
        }
        File newFile = null;
        try {

            Files.createDirectories(Paths.get(path  + dateStr));
            newFile = new File(path + returnStr);
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException("保存文件失败，请联系管理员!");

        }
        return returnStr;
    }
}
