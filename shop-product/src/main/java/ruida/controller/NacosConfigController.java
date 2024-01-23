package ruida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RefreshScope
public class NacosConfigController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    //编写自动配置
    @RequestMapping("/test-config1")
    public String testConfig1() {
        return applicationContext.getEnvironment().getProperty("config.appName");
    }
//    @Value("${config.appName}")
//    private String appName;
//    @GetMapping("/test-config2")
//    public String testConfig2(){
//        return appName;
//    }
    @RequestMapping("/test-config3")
    public String testConfig3() {
        return applicationContext.getEnvironment().getProperty("config.env");
    }
}

