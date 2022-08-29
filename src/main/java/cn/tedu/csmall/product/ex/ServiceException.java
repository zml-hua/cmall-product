package cn.tedu.csmall.product.ex;

public class ServiceException extends RuntimeException{
    private ServiceCode serviceCode;

    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    public ServiceException() {
    }

    public ServiceException(ServiceCode code,String message) {
        super(message);
        this.serviceCode = code;
    }


}
