package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.cp.bean.message.subassembly.Text;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class MarkdownMessage extends BaseWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * markdown内容，最长不超过2048个字节，必须是utf8编码
   */
  @SerializedName("markdown")
  private Text text;

  private MarkdownMessage() {
    setMsgType(WxConsts.KefuMsgType.MARKDOWN);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private Integer agentId;
    private String toUser;
    private String toParty;
    private String toTag;
    private String content;

    private Builder() {
    }

    public Builder setContent(String content) {
      this.content = content;
      return this;
    }

    public Builder setAgentId(Integer agentId) {
      this.agentId = agentId;
      return this;
    }

    public Builder setToUser(String toUser) {
      this.toUser = toUser;
      return this;
    }

    public Builder setToParty(String toParty) {
      this.toParty = toParty;
      return this;
    }

    public Builder setToTag(String toTag) {
      this.toTag = toTag;
      return this;
    }

    public MarkdownMessage build() {
      MarkdownMessage markdownMessage = new MarkdownMessage();
      markdownMessage.text = new Text(content);
      markdownMessage.agentId = agentId;
      markdownMessage.toUser = toUser;
      markdownMessage.toParty = toParty;
      markdownMessage.toTag = toTag;
      return markdownMessage;
    }
  }
}
