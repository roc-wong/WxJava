package me.chanjar.weixin.common.constant;

/**
 * 表示是否开启id转译，0表示否，1表示是，默认0
 *
 * @author roc
 * @since 2019/8/27 20:01
 */
public enum IdTransEnum {

  /**
   * 关闭
   */
  DISABLE("0"),

  /**
   * 开启
   */
  ENABLE("1");

  private String value;

  IdTransEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
