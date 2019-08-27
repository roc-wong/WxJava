package me.chanjar.weixin.common.constant;

import com.google.gson.annotations.SerializedName;

/**
 * 表示是否是保密消息，0表示否，1表示是，默认0.
 *
 * @author roc
 * @since 2019/8/27 20:07
 */
public enum MsgSafeEnum {

  /**
   * 非保密
   */
  @SerializedName("0")
  NO("0"),

  /**
   * 保密
   */
  @SerializedName("1")
  YES("1");

  private String value;

  MsgSafeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}


