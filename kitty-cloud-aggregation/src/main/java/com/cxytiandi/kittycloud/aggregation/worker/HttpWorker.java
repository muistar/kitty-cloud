package com.cxytiandi.kittycloud.aggregation.worker;

import com.cxytiandi.kittycloud.aggregation.invoker.HttpApiInvoker;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import com.cxytiandi.kittycloud.common.helper.ApplicationContextHelper;
import com.jd.platform.async.callback.IWorker;
import java.util.Map;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 21:57
 */
public class HttpWorker implements IWorker<HttpRequest, Map> {

    private HttpApiInvoker httpApiInvoker;

    @Override
    public Map action(HttpRequest httpRequest) {
        httpApiInvoker = ApplicationContextHelper.getBean(HttpApiInvoker.class);
        return httpApiInvoker.invoke(httpRequest);
    }

    @Override
    public Map defaultValue() {
        return null;
    }
}