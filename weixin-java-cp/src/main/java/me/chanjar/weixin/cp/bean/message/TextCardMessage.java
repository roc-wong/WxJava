package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.TextCard;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class TextCardMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  @SerializedName("textcard")
  private TextCard textCard;

  private TextCardMessage() {
    setMsgType(WxConsts.KefuMsgType.TEXTCARD);
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
    private TextCard textCard;

    private Builder() {
    }

    public Builder setTextCard(TextCard textCard) {
      this.textCard = textCard;
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

    public TextCardMessage build() {
      TextCardMessage textCardMessage = new TextCardMessage();
      textCardMessage.setTextCard(textCard);
      textCardMessage.setAgentId(agentId);
      textCardMessage.setToUser(toUser);
      textCardMessage.setToParty(toParty);
      textCardMessage.setToTag(toTag);
      textCardMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      textCardMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return textCardMessage;
    }
  }
}
