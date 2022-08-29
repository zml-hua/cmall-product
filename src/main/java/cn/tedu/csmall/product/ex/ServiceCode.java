package cn.tedu.csmall.product.ex;

/**
 * 业务状态码
 */
public enum ServiceCode {

    OK(20000),
    ERR_NOT_FOUND(40400),
    ERR_CONFLICT(40900),
    ERR_INSERT(50000),
    ERR_DELETE(50100),
    ERR_UPDATE(50200);

    private int value;

    public int getValue(){
        return value;
    }

    ServiceCode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ServiceCode{" +
                "value=" + value +
                '}';
    }
}
