package me.chanjar.weixin.cp.bean.message.subassembly;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author roc
 * @since 2019/8/27 16:56
 */
@Getter
@Setter
@ToString
public class MiniProgramContentItem implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 长度10个汉字以内
   */
  private String key;

  /**
   * 长度10个汉字以内
   */
  private String value;

  public MiniProgramContentItem(String key, String value) {
    this.key = key;
    this.value = value;
  }
}
