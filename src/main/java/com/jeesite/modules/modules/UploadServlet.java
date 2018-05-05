package com.jeesite.modules.modules;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
//@Controller
//@RequestMapping("/api/member")
@WebServlet("/UploadServlet.do")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path1 = Constants.ROOT_FILE_PATH + Constants.ACCOUNTAVATAR_FOLDER;
        System.out.println("================"+path1);
//        String path = uploadPicture(request, Constants.ACCOUNTAVATAR_FOLDER, "", "", Constants.P_TX);


        // 判断上传表单是否为multipart/form-data类型
        HttpSession session = request.getSession();
        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                // 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹
                // 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。
                ServletFileUpload sfu = new ServletFileUpload(factory);
                sfu.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte =
                // 1kb 1024kb=1M 1024M = 1G
                sfu.setHeaderEncoding("utf-8");

                // 3.
                // 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
                @SuppressWarnings("unchecked")
                List<FileItem> fileItemList = sfu.parseRequest(request);
                Iterator<FileItem> fileItems = fileItemList.iterator();

                // 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
                while (fileItems.hasNext()) {
                    FileItem fileItem = fileItems.next();
                    // 普通表单元素
                    if (fileItem.isFormField()) {
                        String name = fileItem.getFieldName();// name属性值
                        String value = fileItem.getString("utf-8");// name对应的value值

                        System.out.println(name + " = " + value);
                    }
                    // <input type="file">的上传文件的元素
                    else {
                        String fileName = fileItem.getName();// 文件名称
                        System.out.println("原文件名：" + fileName);// Koala.jpg

                        String suffix = fileName.substring(fileName.lastIndexOf('.'));
                        System.out.println("扩展名：" + suffix);// .jpg

                        // 新文件名（唯一）
                        String newFileName = new Date().getTime() + suffix;
                        System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg

                        // 5. 调用FileItem的write()方法，写入文件
//                        File file = new File("D:/WebContent/touxiang/" + newFileName);
                        File file = new File(path1 + newFileName);
                        if (!file.exists()){
                            file.createNewFile();
                        }
                        System.out.println(file.getAbsolutePath());
                        fileItem.write(file);

                        // 6. 调用FileItem的delete()方法，删除临时文件
                        fileItem.delete();

                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    // 广州双双信息科技有限公司 版本所有
    // 标签: FT20170116001
    // 作者: Sikefeng
    // 日期: 2017-01-22
    // Jira: TRUE-26
    // 描述:
    private String uploadPicture(HttpServletRequest request, final String Path, final String FileName, final String FileSuffix, final int type) {
        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
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

    @RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
    public ResponseEntity<Object> userUpdate(HttpServletRequest request) throws Exception {
        String path = uploadPicture(request, Constants.ACCOUNTAVATAR_FOLDER, "", "", Constants.P_TX);
        System.out.println("================="+path);
        return new ResponseEntity<Object>("OKKKKKKKKK", HttpStatus.OK);
    }

}  