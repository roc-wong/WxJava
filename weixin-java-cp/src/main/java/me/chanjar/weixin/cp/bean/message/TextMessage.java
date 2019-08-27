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
public class TextMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 消息内容，最长不超过2048个字节，超过将截断（支持id转译）
   */
  @SerializedName("text")
  private Text text;

  public TextMessage() {
    setMsgType(WxConsts.KefuMsgType.TEXT);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    protected Integer agentId;
    protected String toUser;
    protected String toParty;
    protected String toTag;
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

    public TextMessage build() {
      TextMessage textMessage = new TextMessage();
      textMessage.setText(new Text(content));
      textMessage.setAgentId(agentId);
      textMessage.setToUser(toUser);
      textMessage.setToParty(toParty);
      textMessage.setToTag(toTag);
      textMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      textMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return textMessage;
    }
  }
}
