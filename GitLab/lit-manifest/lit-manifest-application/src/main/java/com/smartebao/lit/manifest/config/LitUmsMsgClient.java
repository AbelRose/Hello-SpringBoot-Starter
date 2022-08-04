package com.smartebao.lit.manifest.config;

import com.unified.messaging.sdk.unifiedmessagingsdk.client.UmsMsgClientApi;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author yihaosun
 * @date 2022/8/3 14:44
 */
@Component
public class LitUmsMsgClient extends UmsMsgClientApi {
    protected LitUmsMsgClient(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }
}
