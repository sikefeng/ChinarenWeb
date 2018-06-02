package com.jeesite.modules.ctzn.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ctzn.dao.ProductDao;
import com.jeesite.modules.ctzn.entity.Product;
import com.jeesite.modules.file.utils.FileUploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductService extends CrudService<ProductDao, Product> {



    /**
     * 保存数据（插入或更新）
     *
     * @param product
     */
    @Override
    @Transactional(readOnly = false)
    public void save(Product product) {
        super.save(product);
        // 保存上传图片
        FileUploadUtils.saveFileUpload(product.getId(), "product_image");
        // 保存上传附件
//        FileUploadUtils.saveFileUpload(product.getId(), "testData_file");
    }


}
