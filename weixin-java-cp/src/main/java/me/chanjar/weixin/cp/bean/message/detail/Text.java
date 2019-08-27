package me.chanjar.weixin.cp.bean.message.detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString
public class Text implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 消息内容，最长不超过2048个字节，超过将截断（支持id转译）
   */
  private String content;

  public Text(String content) {
    this.content = content;
  }
}
