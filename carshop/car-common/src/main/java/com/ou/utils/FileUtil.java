package com.ou.utils;

import com.ou.entity.ResultCommon;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static ResultCommon upload(MultipartFile file, String path){
        if(file.isEmpty()){
            return ResultUtil.error("请重新上传文件");
        }
        String originalFilename = file.getOriginalFilename();
        File newFile = new File(path + originalFilename);
        try {
            file.transferTo(newFile);
            return ResultUtil.success("上传成功");
        } catch (IOException e) {
            return ResultUtil.error("上传失败");
        }
    }
}
