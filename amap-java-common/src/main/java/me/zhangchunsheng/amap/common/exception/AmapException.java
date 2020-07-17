package me.zhangchunsheng.amap.common.exception;

import com.google.common.base.Joiner;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 高德地图异常结果类
 * Created by Chunsheng Zhang on 2020-4-20.
 * </pre>
 *
 * @author ChunshengZhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AmapException extends Exception {
    private static final long serialVersionUID = 2214381471513460742L;

    /**
     * 自定义错误讯息.
     */
    private String customErrorMsg;
    /**
     * 返回状态码.
     */
    private String returnStatus;
    /**
     * 返回信息.
     */
    private String returnInfo;

    /**
     * 业务结果.
     */
    private String returnInfoCode;

    /**
     * Instantiates a new Amap exception.
     *
     * @param customErrorMsg the custom error msg
     */
    public AmapException(String customErrorMsg) {
        super(customErrorMsg);
        this.customErrorMsg = customErrorMsg;
    }

    /**
     * Instantiates a new Amap exception.
     *
     * @param customErrorMsg the custom error msg
     * @param tr             the tr
     */
    public AmapException(String customErrorMsg, Throwable tr) {
        super(customErrorMsg, tr);
        this.customErrorMsg = customErrorMsg;
    }

    private AmapException(Builder builder) {
        super(builder.buildErrorMsg());
        returnStatus = builder.returnStatus;
        returnInfo = builder.returnInfo;
        returnInfoCode = builder.returnInfoCode;
    }

    /**
     * 通过BaseAmapResult生成异常对象.
     *
     * @param baseResult the base result
     * @return the amap exception
     */
    public static AmapException from(me.zhangchunsheng.amap.common.bean.result.BaseAmapResult baseResult) {
        return AmapException.newBuilder()
                .returnStatus(baseResult.getStatus())
                .returnInfo(baseResult.getInfo())
                .returnInfoCode(baseResult.getInfoCode())
                .build();
    }

    /**
     * New builder builder.
     *
     * @return the builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String returnStatus;
        private String returnInfo;
        private String returnInfoCode;

        private Builder() {
        }

        /**
         * Return status builder.
         *
         * @param returnStatus the return status
         * @return the builder
         */
        public Builder returnStatus(String returnStatus) {
            this.returnStatus = returnStatus;
            return this;
        }

        /**
         * Return info builder.
         *
         * @param returnInfo the return info
         * @return the builder
         */
        public Builder returnInfo(String returnInfo) {
            this.returnInfo = returnInfo;
            return this;
        }

        /**
         * Result code builder.
         *
         * @param returnInfoCode the result code
         * @return the builder
         */
        public Builder returnInfoCode(String returnInfoCode) {
            this.returnInfoCode = returnInfoCode;
            return this;
        }

        /**
         * Build amap geo exception.
         *
         * @return the amap geo exception
         */
        public AmapException build() {
            return new AmapException(this);
        }

        /**
         * Build error msg string.
         *
         * @return the string
         */
        public String buildErrorMsg() {
            return Joiner.on("，").skipNulls().join(
                    returnStatus == null ? null : String.format("返回代码：[%s]", returnStatus),
                    returnInfo == null ? null : String.format("返回信息：[%s]", returnInfo),
                    returnInfoCode == null ? null : String.format("结果代码：[%s]", returnInfoCode)
            );
        }
    }
}
