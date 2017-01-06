package com.mjapp.payment.model;

import com.mjapp.util.PROPERTIESUTIL;

/**
 * @title: ApplyForPayOrderMustZFBModel
 * @description: 支付宝申请支付 必须的参数
 * @author: zhangfan
 * @data: 2016年11月27日 17:49
 */
public class ApplyForPayOrderParameterZFBModel {

    private final String app_id = PROPERTIESUTIL.get("app_id_zfb"); //支付宝分配给开发者的应用ID                                     必须:是
    private final String method = PROPERTIESUTIL.get("method_zfb"); //接口名称	  alipay.trade.app.pay                                   是
    private final String format = PROPERTIESUTIL.get("format_zfb"); // JSON                                                           否
    private final String charset = PROPERTIESUTIL.get("charset_zfb"); //请求使用的编码格式;              utf-8                            是
    private final String sign_type = PROPERTIESUTIL.get("sign_type_zfb"); //商户生成签名字符串所使用的签名算法类型，目前支持RSA                 是
    private String sign; //商户请求参数的签名串，详见签名                                        是
    private String timestamp; //发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"                       是
    private final String version = PROPERTIESUTIL.get("version_zfb"); //调用的接口版本，固定为：1.0                                       是
    private final String notify_url = PROPERTIESUTIL.get("notify_url_zfb"); //支付宝服务器主动通知商户服务器里指定的页面http/https路径。         是
    private String biz_content; //业务请求参数的集合，最大长度不限，json格式                       是


    public String getApp_id() {
        return app_id;
    }

    public String getMethod() {
        return method;
    }


    public String getFormat() {
        return format;
    }


    public String getCharset() {
        return charset;
    }


    public String getSign_type() {
        return sign_type;
    }


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public String getBiz_content() {
        return biz_content;
    }

    public void setBiz_content(String biz_content) {
        this.biz_content = biz_content;
    }


    public class ApplyForPayOrderNotMustParameterZFBModel {

        private String body; //对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。              必须:是
        private String subject;//商品的标题/交易标题/订单标题/订单关键字等。                                           是
        private String out_trade_no;//商户网站唯一订单号                                                            是
        private String timeout_express; //该笔订单允许的最晚付款时间，逾期将关闭交易。
        // 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点， 如 1.5h，可转换为 90m。                                                            否
        private String total_amount; //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]                是
        private String seller_id;//收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID                 否
        private final String product_code = PROPERTIESUTIL.get("product_code_zfb");
        //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY                                             是
        private String goods_type;//商品主类型：0—虚拟类商品，1—实物类商品 注：虚拟类商品不支持使用花呗渠道                是
        private String passback_params;//公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。
        // 支付宝会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝                              否
        private String promo_params;//优惠参数 注：仅与支付宝协商后可用      {"storeIdType":"1"}                      否
        private String extend_params;//业务扩展参数                                                                否
        private String disable_pay_channels; //禁用渠道，用户不可用指定渠道支付
        //当有多个渠道时用“,”分隔 注：与enable_pay_channels互斥                                                       否
        private String sys_service_provider_id;//系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID  否


        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getTimeout_express() {
            return timeout_express;
        }

        public void setTimeout_express(String timeout_express) {
            this.timeout_express = timeout_express;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getProduct_code() {
            return product_code;
        }


        public String getGoods_type() {
            return goods_type;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }

        public String getPassback_params() {
            return passback_params;
        }

        public void setPassback_params(String passback_params) {
            this.passback_params = passback_params;
        }

        public String getPromo_params() {
            return promo_params;
        }

        public void setPromo_params(String promo_params) {
            this.promo_params = promo_params;
        }

        public String getExtend_params() {
            return extend_params;
        }

        public void setExtend_params(String extend_params) {
            this.extend_params = extend_params;
        }

        public String getDisable_pay_channels() {
            return disable_pay_channels;
        }

        public void setDisable_pay_channels(String disable_pay_channels) {
            this.disable_pay_channels = disable_pay_channels;
        }

        public String getSys_service_provider_id() {
            return sys_service_provider_id;
        }

        public void setSys_service_provider_id(String sys_service_provider_id) {
            this.sys_service_provider_id = sys_service_provider_id;
        }
    }
}


