package com.example.demo.controller.img;

import com.example.demo.util.LoggerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/img")
public class DuoImgController {

    @RequestMapping("/duoimg")
    public String Img() {
        return "view/img/duoimg";
    }

    /**
     * @author: jinliang
     * @create: 2018/9/5 10:13
     * @desc:   代码雍容，但数据准确（推荐）
     * @param
     **/
    @RequestMapping(value = "/houseform")
    @ResponseBody
    public String houseLoanImgForm(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="myfile1") MultipartFile file,
                                    @RequestParam(value="myfile2") MultipartFile file2, @RequestParam(value="myfile3") MultipartFile file3,
                                    @RequestParam(value="myfile4") MultipartFile file4, @RequestParam(value="name")String name
    ) throws IOException {
        LoggerUtils.info(getClass(),"name>>>>>>>>"+name);
        String truefile=file.getOriginalFilename();
        File mFile=new File("C:\\qt\\new");
        //判断是否已经有file文件夹
        if (mFile.exists()) {
            mFile.mkdirs();
        }
        //将文件名称放入文件夹中
        File myFile=new File(mFile, truefile);
        //执行文件上传
        file.transferTo(myFile);
        return "aa";
    }

    /**
     * @author: jinliang
     * @create: 2018/9/5 10:12
     * @desc: 优势：代码简洁，但是传入图片无法区别具体是哪一张
     * @param
     **/
/*    @RequestMapping(value = "/houseform")
    public String houseLoanImgForm2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File mFile=new File("C:\\qt\\new");
        boolean exists = mFile.exists();
        //判断是否已经有file文件夹
        if (exists == false) {
            mFile.mkdirs();
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> imgs = multipartRequest.getFiles("img");
        for (MultipartFile imf : imgs) {
            if (null!=imf){
                imf.transferTo(new File(mFile, imf.getOriginalFilename()));
            }
        }
        return "aa";
    }*/

    @GetMapping("/form_webuploader")
    public String webUploader() {
        return "view/img/form_webuploader";
    }
    @GetMapping("/form_file_upload")
    public String form_file_upload() {
        return "view/img/form_file_upload";
    }

    @RequestMapping("webuploaderFile")
    public String webuploaderFile(HttpServletRequest request,HttpServletResponse response){
        return "view/img/form_webuploader";
    }


}
