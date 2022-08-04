package org.asterisk.ums.server.service;

/**
 * @author yihaosun
 * @date 2022/8/3 15:17
 */
public interface MessageMailService {
    /**
     * 简单邮件
     *
     * @param to 接受人
     * @param subject 邮件主题
     * @param text 邮件内容
     */
    void sendSimpleEmail(String to,String subject,String text);

    /**
     * 复杂邮件
     */
    void sendComplexEmail(String to,String subject,String text);
}
