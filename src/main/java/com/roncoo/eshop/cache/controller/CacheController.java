package com.roncoo.eshop.cache.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.roncoo.eshop.cache.model.ProductInfo;
import com.roncoo.eshop.cache.service.CacheService;

/**
 * 缓存Controller
 * @author Administrator
 *
 */
@Controller
public class CacheController {

    @Resource
    private CacheService cacheService;

    //http://localhost:7081/testPutCache?id=1&name=liuxi&price=55.1
    @RequestMapping("/testPutCache")
    @ResponseBody
    public String testPutCache(ProductInfo productInfo) {
        cacheService.saveLocalCache(productInfo);
        return "success";
    }

    //http://localhost:7081/testGetCache?id=1
    @RequestMapping("/testGetCache")
    @ResponseBody
    public ProductInfo testGetCache(Long id) {
        return cacheService.getLocalCache(id);
    }

}
