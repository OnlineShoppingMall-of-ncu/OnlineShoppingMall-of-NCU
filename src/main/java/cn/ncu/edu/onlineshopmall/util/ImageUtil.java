package cn.ncu.edu.onlineshopmall.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {
    public static String imagePath(MultipartFile file, String shopName){
        if(file.isEmpty()){
            return "false";
        }
        //判断系统，根据不同的系统选择不同的保存路径
        String path = "D:/upload/pictures/";
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("linux")){
            path="/usr/upload";
        }
        //生成随机数字并于商品名拼接，防止文件名重复
        String fileName = UUID.randomUUID().toString().substring(0,4)+shopName;

        File dest = new File(path+"/"+fileName);
        System.out.println("保存的绝对路径为："+dest);
        //判断图片存放位置（图片所在的文件夹）是否存在，若不存在则创建文件夹
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }try{
            //根据系统不同，保存到不同的路径
            file.transferTo(dest);
            return fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        }catch (IOException e){
            e.printStackTrace();
            return "false";
        }
    }
}
