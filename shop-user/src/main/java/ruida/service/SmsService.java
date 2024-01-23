package ruida.service;

import com.alibaba.fastjson.JSON;
import com.ruida.domain.Order;
import com.ruida.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import ruida.dao.UserDao;
import ruida.smsutil.SmsUtil;

import java.util.Random;

//短信发送类
@Slf4j
@Service("SmsService")
@RocketMQMessageListener(
        consumerGroup = "shop-user", //消费者组名
        topic = "order-topic",//消费主题
        consumeMode = ConsumeMode.CONCURRENTLY,//消费模式,指定是否顺序消费 CONCURRENTLY(同步,默认) ORDERLY(顺序)
        messageModel = MessageModel.CLUSTERING//消息模式 BROADCASTING(广播)  CLUSTERING(集群,默认)
)
public class SmsService implements RocketMQListener<Order> {
    @Autowired
    private UserDao userDao;

    @SneakyThrows
    @Override
    public void onMessage(Order order) {
        log.info("收到一个订单{}信息，接下来发送短信", JSON.toJSONString(order));
        User user=userDao.findById(order.getUid()).get();
        StringBuilder stringBuilder=new StringBuilder();
//        String str="0123456789";
//        char ch=str.charAt(new Random().nextInt(str.length()));
        for(int i=0;i<4;i++) {
             stringBuilder.append(new Random().nextInt(9)+1);
        }
        String smsCode=stringBuilder.toString();
        Param param=new Param(smsCode);
        SmsUtil.sendSms(user.getTelephone(),"小小邢","SMS_462255359",JSON.toJSONString(param));
        log.info("短信发送成功");
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Param{
        private String coco;
    }

}
