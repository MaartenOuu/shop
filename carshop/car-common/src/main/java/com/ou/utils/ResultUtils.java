package com.ou.utils;

import com.ou.entity.ResultCode;
import com.ou.entity.ResultCommon;
import lombok.Data;

@Data
public class ResultUtils {

    /**
     *
     *  @param @param  object
     * @return ResultCommon 返回类型
     * @Description: 成功有返回
     */
    public static ResultCommon success(Object object){
        ResultCommon resultCommon = new ResultCommon(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
        resultCommon.setData(object);
        return resultCommon;
    }

    /**
     *
     *  @param @param  object
     * @return ResultCommon 返回类型
     * @Description: 成功无返回
     */
    public static ResultCommon success(){
        return ResultUtils.success(null);
    }

    /**
     *
     *  @param @param  object
     * @return ResultCommon 返回类型
     * @Description: 失败有返回
     */
    public static ResultCommon error(Object object){
        ResultCommon resultCommon = new ResultCommon(ResultCode.FALSE.getCode(), ResultCode.FALSE.getMessage());
        resultCommon.setData(object);
        return resultCommon;
    }

    /**
     *
     *  @param @param  object
     * @return ResultCommon 返回类型
     * @Description: 失败无返回
     */
    public static ResultCommon error(){
        return ResultUtils.success(null);
    }
}
