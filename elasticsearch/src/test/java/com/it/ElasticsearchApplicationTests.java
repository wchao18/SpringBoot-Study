package com.it;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    //创建索引
    @Test
    public void testCreateIndex() throws IOException {

        CreateIndexRequest saas = new CreateIndexRequest("saas");
        restHighLevelClient.indices().create(saas, RequestOptions.DEFAULT);
    }


    //判断索引存在
    @Test
    public void testExistIndex() throws IOException {

        GetIndexRequest saas = new GetIndexRequest("saas");
        boolean exists = restHighLevelClient.indices().exists(saas, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //删除索引
    @Test
    public void delIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("saas");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }


}
