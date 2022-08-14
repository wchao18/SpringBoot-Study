package com.it.skywalking;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkywalkingDemoController {
    @GetMapping("/")
    public String hello() {
        return "hello skywalking!!!";
    }

    @GetMapping("/getTrace")
    public String getTrace() {
        ActiveSpan.info("sky info");
        //ActiveSpan.error(new RuntimeException("测试sky的异常"));
        return TraceContext.traceId();
    }

    @GetMapping("/exclude")
    public String exclued() {
        return TraceContext.traceId();
    }
}