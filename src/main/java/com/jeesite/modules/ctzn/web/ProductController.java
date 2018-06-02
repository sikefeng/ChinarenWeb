package com.jeesite.modules.ctzn.web;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.utils.QRCodeUtil;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.ctzn.entity.Product;
import com.jeesite.modules.ctzn.service.ProductService;
import com.jeesite.modules.sys.entity.Post;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "${adminPath}/ctzn/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;


    /**
     * 获取数据
     */
    @ModelAttribute
    public Product get(String id, boolean isNewRecord) {
        return productService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "list")
    public String list(Product product, Model model) {
        model.addAttribute("product", product);
        return "modules/ctzn/productList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<Product> listData(Product product, HttpServletRequest request, HttpServletResponse response) {
        Page<Product> page = productService.findPage(new Page<Product>(request, response), product);
        return page;
    }

    @RequestMapping(value = "fb")
    public String feedback(Product product, Model model) {
        System.out.println("Product product="+ product);
//        model.addAttribute("feedback", feedback);
        return "modules/ctzn/feedbackList";
    }


    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(Product product, Model model) {
        model.addAttribute("product", product);
        return "modules/ctzn/productForm";
    }

    /**
     * 保存数据
     */
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated Product product) {
        System.out.println("===============222="+product.toString());
        productService.save(product);
        return renderResult(Global.TRUE, text("保存数据成功！"));
    }

    /**
     * 停用数据  0正常 1删除 2停用
     */
    @RequestMapping(value = "disable")
    @ResponseBody
    public String disable(Product product, HttpServletRequest request, HttpServletResponse response, Model model) {
        product.setStatus(Post.STATUS_DISABLE);
        productService.updateStatus(product);
        return renderResult(Global.TRUE, text("停用产品''{0}''成功", product.getProName()));
    }

    /**
     * 启用数据 0正常 1删除 2停用
     */
    @RequestMapping(value = "enable")
    @ResponseBody
    public String enable(Product product, HttpServletRequest request, HttpServletResponse response, Model model) {
        product.setStatus(Post.STATUS_NORMAL);
        productService.updateStatus(product);
        return renderResult(Global.TRUE, text("启用产品''{0}''成功", product.getProName()));
    }

    /**
     * 删除数据 0正常 1删除 2停用
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Product product) {
        productService.delete(product);
        return renderResult(Global.TRUE, text("删除产品''{0}''成功", product.getProName()));
    }




















    /**
     * 根据URL生成二维码
     *
     * @param request
     * @param response
     */

    @RequestMapping(value = "getQRCode")
    public void getQRCode(HttpServletRequest request, HttpServletResponse response) {
//        String id=request.getParameter("id");
//        System.out.println("LLLLLLLLLLLLLLLLLL="+id);
        String url = "http://www.baidu.com";
        //二维码图片输出流
        OutputStream out = null;
        try {
            response.setContentType("image/jpeg;charset=UTF-8");
            BufferedImage image = QRCodeUtil.createQRCode(url);
            //实例化输出流对象
            out = response.getOutputStream();
            //画图
            ImageIO.write(image, "png", response.getOutputStream());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response.getOutputStream()) {
                    response.getOutputStream().close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "testEncode")
    public void testEncode(HttpServletRequest request, HttpServletResponse response) throws WriterException, IOException {
        BufferedImage image = null;
        //二维码图片输出流
        OutputStream out = null;
//        String filePath = "D://";
//        String fileName = "zxing2.png";
        JSONObject json = new JSONObject();
        json.put("zxing", "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");
        json.put("author", "shihy");
        String content = json.toString();// 内容
        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
//        Path path = FileSystems.getDefault().getPath(filePath, fileName);
//        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        System.out.println("输出成功.");
        try {
            response.setContentType("image/jpeg;charset=UTF-8");
            image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            //实例化输出流对象
            out = response.getOutputStream();
            //画图
            ImageIO.write(image, "png", response.getOutputStream());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response.getOutputStream()) {
                    response.getOutputStream().close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @RequestMapping(value = "getErWeiCode")
    public String getErWeiCode() {
        return "modules/ctzn/test";
    }

}
