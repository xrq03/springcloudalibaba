//package ruida.loader;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.ApplicationEventPublisherAware;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.stereotype.Component;
//
//@RefreshScope
//@Slf4j
//@Component
//@DependsOn({"gatewayRoutersConfiguration"})
//public class DynamicRouteLoader implements ApplicationEventPublisherAware {
//    /**
//     * 路由配置方式：database，yml，nacos
//     */
//    @Value("${jeecg.route.config.data-type:database}")
//    public  String DATA_TYPE;
//}