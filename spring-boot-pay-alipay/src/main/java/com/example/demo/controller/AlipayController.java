package controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
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

        // 通知验签
        boolean verifyResult = AlipaySignature.rsaCheckV1(params, "ALIPAY_PUBLIC_KEY", "CHARSET", "RSA2");

        // 验证失败
        if (!verifyResult){
            return "fail";
        }

        /* TODO 校验通知数据的正确性 */
        // 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号
        String outTradeNo = request.getParameter("trade_status");
        if (StringUtils.isBlank(outTradeNo)) {
            return "fail";
        }

        // 2、判断total_amount是否确实为该订单的实际金额
        String totalAmount = request.getParameter("total_amount");
        if (StringUtils.isBlank(totalAmount)) {
            return "fail";
        }

        // 3、校验通知中的seller_id是否为out_trade_no这笔单据的对应的操作方
        String sellerId = request.getParameter("seller_id");
        if (StringUtils.isBlank(sellerId)) {
            return "fail";
        }

        // 4、验证app_id是否为该商户本身
        String appId = request.getParameter("app_id");
        if (StringUtils.isBlank(appId)) {
            return "fail";
        }

        // TODO 付款成功
        String tradeStatus = request.getParameter("trade_status");
        if(StringUtils.equals("TRADE_FINISHED", tradeStatus) || StringUtils.equals("TRADE_SUCCESS", tradeStatus)){
        }
        return "success";
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
