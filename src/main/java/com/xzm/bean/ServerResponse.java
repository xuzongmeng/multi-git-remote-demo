package com.xzm.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失 extends HashMap<String,Object>
@ApiModel(value =  "通用返回对象")
public class ServerResponse<T>  implements Serializable   {
    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "信息")
    private String msg;
    @ApiModelProperty(value = "对象")
    private T data;
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }
    public ServerResponse(int code){
        this.code = code;
    }
    public ServerResponse(int code, T data){
        this.code = code;
        this.data = data;
    }

    public ServerResponse(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

//    @JsonIgnore
    //使之不在json序列化结果当中


    public int getCode(){
        return code;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
//    public ServerResponse<T> put(String key, Object value) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg",getMsg());
//        map.put("code",getCode());
//        map.put("data",value);
//        return createBySuccess(map);
//    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(),null);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,null);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg(),null);
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage,null);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage,null);
    }


    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage,T data){
        return new ServerResponse<T>(errorCode,errorMessage,data);
    }
//
//    public static <T> ServerResponse<T> createByErrorCodeMessage(String errorCode, String errorMessage){
//        return new ServerResponse<T>(errorCode,errorMessage);
//    }



    public enum ResponseCode {
        SUCCESS(200,"成功"),
        ERROR(-1,"失败");
        private  int code;
        private  String msg;


        ResponseCode(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode(){
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }




}
