package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.Text;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class MarkdownMessage extends AbstractWxCpMessage {

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
    private MsgSafeEnum safe = MsgSafeEnum.NO;
    private IdTransEnum enableIdTrans = IdTransEnum.DISABLE;
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

    public Builder setSafe(MsgSafeEnum safe) {
      this.safe = safe;
      return this;
    }

    public Builder setEnableIdTrans(IdTransEnum enableIdTrans) {
      this.enableIdTrans = enableIdTrans;
      return this;
    }

    public MarkdownMessage build() {
      MarkdownMessage markdownMessage = new MarkdownMessage();
      markdownMessage.setText(new Text(content));
      markdownMessage.setAgentId(agentId);
      markdownMessage.setToUser(toUser);
      markdownMessage.setToParty(toParty);
      markdownMessage.setToTag(toTag);
      markdownMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      markdownMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return markdownMessage;
    }
  }
}
