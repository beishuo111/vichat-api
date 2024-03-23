package com.beishuo.demo.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String msg;
    private T data;
    private T count;

    public Result(T data) {
        this.data = data;
    }

    public static com.beishuo.demo.common.Result success() {
        com.beishuo.demo.common.Result result = new com.beishuo.demo.common.Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> com.beishuo.demo.common.Result<T> success(T data, T count) {
        com.beishuo.demo.common.Result<T> result = new com.beishuo.demo.common.Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        result.setData(data);
        result.setCount(count);
        return result;
    }
    public static <T> com.beishuo.demo.common.Result<T> success(T data) {
        com.beishuo.demo.common.Result<T> result = new com.beishuo.demo.common.Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static com.beishuo.demo.common.Result error(String code, String msg) {
        com.beishuo.demo.common.Result result = new com.beishuo.demo.common.Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
