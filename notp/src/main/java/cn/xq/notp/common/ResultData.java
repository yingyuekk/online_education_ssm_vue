package cn.xq.notp.common;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/8
 */
public class ResultData {

    private int status; // 状态码
    private String msg;// 处理消息
    private Object data; // 返回数据

    public ResultData(String msg, Object data) {
        this.status = 2000;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResultData ok(String msg, Object data){
        return new ResultData(msg,data);
    }

    public static ResultData build(int status, String msg, Object data){
        return new ResultData(status,msg,data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
