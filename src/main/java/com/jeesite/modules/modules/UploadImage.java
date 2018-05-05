package com.jeesite.modules.modules;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class UploadImage {

    // 广州双双信息科技有限公司 版本所有
    // 标签: FT20170116001
    // 作者: Sikefeng
    // 日期: 2017-01-22
    // Jira: TRUE-26
    // 描述:
    private String uploadPicture(HttpServletRequest request, final String Path, final String FileName, final String FileSuffix, final int type) {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                String rt = saveFile(file, Path, FileName, type);
                return rt;
            }
            // 记录上传该文件后的时间
            int finaltime = (int) System.currentTimeMillis();
        }
        return "fail";
    }


    /**
     * 保存文件
     *
     * @param file
     * @param Path
     * @param FileName
     * @param type
     *            类别，1为头像，2表盘
     * @return
     */
    private String saveFile(MultipartFile file, final String Path, String FileName, final int type) {

        if (file != null) {
            // 取得当前上传文件的文件名称
            String fileName = file.getOriginalFilename();
            // logger.debug(" >>> fileName = "+ fileName);
            // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
            if (!com.jeesite.modules.modules.StringUtils.isEmpty(fileName)) {
                // 获取文件后缀名
                String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                // 定义上传路径/home/tomcat/ycfserver/webapps/image/
                String path = Constants.ROOT_FILE_PATH + Path;
                System.out.println(" >>> rootpath: " + path + " >>> path = " + path);
                // logger.debug(" >>> path = " + path);
                // File localFile = new File(path);
                if (com.jeesite.modules.modules.StringUtils.isBlank(FileName)) {
                    FileName = new SimpleDateFormat("yyyymmddhhMMssSSS").format(new Date());
                    System.out.println(" --------------->>>" + FileName);
                }
                try {
                    // FileUtils.copyInputStreamToFile(file.getInputStream(),
                    // new File(path, FileName + '.' + prefix));
                    // 如果文件夹不存在，创建一个
                    File pfile = new File(path);
                    if (!pfile.exists()) {
                        pfile.mkdirs();
                    }

                    StringBuffer rt = new StringBuffer();
                    rt.append(Path);
                    rt.append(FileName);
                    rt.append('.');
                    rt.append(prefix);

                    File file1 = new File(path, FileName + '.' + prefix);
                    InputStream inputSteam = file.getInputStream();
                    BufferedInputStream fis = new BufferedInputStream(inputSteam);
                    FileOutputStream fos = new FileOutputStream(file1);
                    int f;
                    while ((f = fis.read()) != -1) {
                        fos.write(f);
                    }
                    fos.flush();
                    fos.close();
                    fis.close();
                    inputSteam.close();
                    // 成功返回成功信息
                    // 组织路径返回
                    // 压缩图片
//                    if (type == 1) {
//                        ImageTools.thumbnailatorImage(path, FileName + "." + prefix, prefix, 120, 120);
//                    }
                    return rt.toString();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return "fail";
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return "fail";
                }
            }
        }
        return "fail";
    }


}
