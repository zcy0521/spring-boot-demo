package com.example.demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(path = "/alipay")
public class AlipayController {

    /**
     * 接受支付宝支付结果异步通知
     * @param request 支付结果
     * @return  fail | success
     */
    @RequestMapping(path = "/notify")
    @ResponseBody
    public String alipayNotify(HttpServletRequest request) throws AlipayApiException, JsonProcessingException {
        // 获取请求参数
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(params);
        log.info("alipay notify params:{}", json);

        // 通知验证结果
        boolean verifyResult = AlipaySignature.rsaCheckV1(params, "ALIPAY_PUBLIC_KEY", "UTF-8", "RSA2");

        if (verifyResult){
            // 验证成功
            String tradeStatus = request.getParameter("trade_status");
            if (StringUtils.equals("TRADE_FINISHED", tradeStatus)) {
                // TODO 支付成功处理
            } else if (StringUtils.equals("TRADE_SUCCESS", tradeStatus)) {
                // TODO 支付成功处理
            }
            return "success";
        } else {
            // 验证失败
            return "fail";
        }
    }

    public static void main(String[] args) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("param1", "value1");
        params.put("param2", "value2");
        params.put("param3", "value3");

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);
    }

}
