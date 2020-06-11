package com.it.controller;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/06/10 17:14
 */
@RestController
public class ElkController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
}
