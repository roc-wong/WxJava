package me.chanjar.weixin.cp.bean.message.subassembly;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@NoArgsConstructor
@ToString
public class TextCard implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 标题，不超过128个字节，超过会自动截断（支持id转译）
   */
  private String title;

  /**
   * 描述，不超过512个字节，超过会自动截断（支持id转译）
   */
  private String description;

  /**
   * 点击后跳转的链接。
   */
  private String url;

  /**
   * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
   */
  @SerializedName("btntxt")
  private String btnTxt;

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String title;
    private String description;
    private String url;
    private String btnTxt;

    private Builder() {
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder btnTxt(String btnTxt) {
      this.btnTxt = btnTxt;
      return this;
    }

    public TextCard build() {
      TextCard textCard = new TextCard();
      textCard.btnTxt = this.btnTxt;
      textCard.title = this.title;
      textCard.url = this.url;
      textCard.description = this.description;
      return textCard;
    }
  }
}
