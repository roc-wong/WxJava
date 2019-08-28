package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.cp.bean.message.subassembly.TextCard;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class TextCardMessage extends BaseWxCpMessage {

  private static final long serialVersionUID = 1L;

  @SerializedName("textcard")
  private TextCard textCard;

  /**
   * 表示是否开启id转译，0表示否，1表示是，默认0
   */
  @SerializedName("enable_id_trans")
  protected String enableIdTrans = IdTransEnum.DISABLE.getValue();

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

    public Builder setEnableIdTrans(IdTransEnum enableIdTrans) {
      this.enableIdTrans = enableIdTrans;
      return this;
    }

    public TextCardMessage build() {
      TextCardMessage textCardMessage = new TextCardMessage();
      textCardMessage.textCard = textCard;
      textCardMessage.agentId = agentId;
      textCardMessage.toUser = toUser;
      textCardMessage.toParty = toParty;
      textCardMessage.toTag = toTag;
      textCardMessage.enableIdTrans = enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue();
      return textCardMessage;
    }
  }
}
