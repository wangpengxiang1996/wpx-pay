package com.wpx.wpxpay;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;

public class MainTest {
    public static void main(String[] args) throws Exception {
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(getOptions());
        try {
            // 2. 发起API调用
            AlipayTradePagePayResponse response = Factory.Payment.Page().pay("test", "2234567234890", "0.01", "http://www.zfb.com/back.aspx");
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.err.println("调用成功：" + response.getBody());
            } else {
                System.err.println("调用失败，原因：" + response.getBody());
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";

        config.appId = "2021000121680653";

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCGT3r2e7vkF66tFcAoYVqgp65MMAnMh9OoP9YHfkvAmCWOQyDF/SAKWiRBRAzr3XTal7baYOFC7Gs/KfynaKN2sTAOiQ4KtIhdmH8TTgySJeFdtWpWgMyOQ6C/pcK5bucYnVBcvJdwTHoBbwxVMEWj5ZwdXswvRWGLlt7MV5wTDJhxb9uvxSKaWsVr1pXvy8Yd8kdcUwqyNKXucqQoYEku2wapjFNO1hO6nfHU/JTdRxJCORa7y19XVeevQ6GTaQ/QXw/vm7QLt2qZWZaHHJ9nsJb1XVDEs9p2mJoiJC7+ne5/4VKnYpI9Wiotyi1Ikj1jVNcb+dUKCWm90h2FLylhAgMBAAECggEAGDrYdQUHdXOsSH9nBiHiBp+ZexcjfWl3jp/NjdaD9f+8rrh/fhhXImb2qWuMZTSzcwfxrd3SZY9fHasGcHEZJD187PJevSGqhDARpLrs26THzm7++xILVRLwOgK+aVOPj0o6CDDhpRm23PFaqTenKJUwn7/NWC3NFjCmivi3KFxWi38jPO2pVYiS5Wh9ivZr0L6wNjr37gBQzoGqRI/VRIO9Bvw3VW249CRNWHVFzvihyKPsmlwV12D7PJu8UNQg/fgcFbkXJhAyLwOHKgyJzkaO3hzoVtGVNr14uXgDculqZFA8gD3QxPuCAIs+gdhThiAqdiL582HjjEHgsoosLQKBgQDaVmAXF7nNZayWxVUKW3x/8Rkp3Gat2TIeFsV7N8z498ARKUm0OYce5o2tNkFcC7s3pgBeCPKGgN5J3vEmvRaGec7qdOU921TnE2Ohc89mMIP2aNvge4y5dSEhqBlpimIhH3z4+lOsGPVf6oDunAo9M2PxTGQuuFer67gxm7+igwKBgQCdeokHZB+NACcliPafXC/GND4PpMtAkeWma4LKWxU7uWlD3j/XzKQFhoqS20JJKTrxbSIcXCJ7yTg5w/WGwXCHhGZP7BqsVs+YQxTwQYlgvFoubK5WKCfi1XQauMaRKhN06M/nQLOArpNHXv8KNR7CtJecYUaztuGCRchQPdGvSwKBgGY206tb7x8KP18iKKq9o65d17LyPJuct8rATFlgCTRw/9jI5HlcCTbdJmx1numRkGb/7uIW/Dsdr3MTzP+evCHeepDmgr+Po9K+EAFwryKfCdhcxLr1/C6CeC1Cfgsbvs7U5/PDdVJ3KMBrj0qlgGGgYmR/p9L7eAfDRarryC4zAoGANXZJGOpDz9GSeKqz10wrp+VKgHMY0ZX2WfY708jyP3FlrDXChNejg4C2gL7RFRdbPGUpZGlfB5k7blj5fMMlGcy4Ez/7mjBqj62OaTZGlkG7d/FLilJdoCOJJB1AxD19l34GPuL3TaN2uo8klGmORNmccumPYCmhC2H3bE5gZlsCgYASqs3hGgKUIJg8jtqY7tMB216eCRrE+YRgto9r4dkUznF0rTJeSH5NUVndHKlTIqwy9w9SMxXTCfgd1va3cy+r4o7fuo6ATMJyegZY+wPHwA6gnmWLVYBqt35FJ7JpfyOrvSIHVe97DNETsWNk4nM8VyVf3kQDgguj/UpiYD3Xyg==";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgX6fYC4rmTcCXzq8uVncdD4S+xqvw0y682Ovk5lRdEIr413YvDYTe6M82O6GfZTorHT4lwnoD5zLY1xIPNpslccZjWpRMqDiMfzzq2KJTcJr1g2doDJLPN/z8AHQsRelg/JtKMKrgvfPBpWXgc7hqCiyuTNO3SZY2cJN4IwUscsoolR4I0iXDIE1c110aHVa6DFvlP7H+BBAUWsQFbNTJeaqLaFfxG1bZdWn7mi33fMQV/qYlyMsWLe2kCb5Bx97JFuD7Qf2zMpqu3ZYjPcInlACP7K9m+3mVkO/gXLFTqbLvDV8KjDY2EOFKwhtCCU/7b90MyuGl/91vXvrUsD4hQIDAQAB";

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "";

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        config.encryptKey = "";

        return config;
    }
}