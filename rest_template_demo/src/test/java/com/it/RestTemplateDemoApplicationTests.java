package com.it;

import com.it.pojo.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateDemoApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    //测试：http://127.0.0.1:8090/info

    @Test
    public void testGet() {
        String forObject = restTemplate.getForObject("http://127.0.0.1:8090/info", String.class);
        System.out.println("返回结果：" + forObject);
    }


    @Test
    public void testPost() {
        String param = null;
        Member member = new Member();
        String forObject = restTemplate.postForObject("http://127.0.0.1:8090/info", param,String.class);
        System.out.println("返回结果：" + forObject);
    }

}
