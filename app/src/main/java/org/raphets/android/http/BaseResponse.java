package org.raphets.android.http;

public class BaseResponse<T>  {
    //返回码，服务器对业务处理的结果
    private String status_code ;
    //消息提示错误描述，可用于显示给用户查看
    private String message;
    //具体消息数据
    private T data ;

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
