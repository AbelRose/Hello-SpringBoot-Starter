package org.asterisk.ums.server.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * 渠道数据 Json VO
 *
 * @author yihaosun
 * @date 2022/8/3 17:17
 */
@Data
@ApiModel("渠道数据 Json VO")
public class ChannelDataJsonVO {
    private String theme;

    private List<String> receiverPerson;

    private String sendPerson;

    private List<String> ccPerson;
}
