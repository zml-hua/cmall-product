package cn.tedu.csmall.product.web;

import cn.tedu.csmall.product.ex.ServiceCode;
import cn.tedu.csmall.product.ex.ServiceException;
import lombok.Data;

@Data
public class JsonResult<T> {

    /**
     * 业务状态码
     */
    private Integer state;
    /**
     * 错误时的提示消息
     */
    private String message;
    /**
     * 成功时响应的数据
     */
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static JsonResult ok() {
        return ok(null);
    }

    public static <T> JsonResult ok(T data) {
        return new JsonResult(ServiceCode.OK.getValue(), null, data);
    }

    public static  JsonResult fail(ServiceException e) {
        return fail(e.getServiceCode().getValue(), e.getMessage());
    }

    public static JsonResult fail(Integer state, String message) {
        return new JsonResult(state, message,null);
    }
}
