package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.subassembly.Text;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class TextMessage extends BaseWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 消息内容，最长不超过2048个字节，超过将截断（支持id转译）
   */
  @SerializedName("text")
  private Text text;

  /**
   * 表示是否是保密消息，0表示否，1表示是，默认0
   */
  @SerializedName("safe")
  protected String safe = MsgSafeEnum.NO.getValue();

  /**
   * 表示是否开启id转译，0表示否，1表示是，默认0
   */
  @SerializedName("enable_id_trans")
  protected String enableIdTrans = IdTransEnum.DISABLE.getValue();

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
      textMessage.text = new Text(content);
      textMessage.agentId = agentId;
      textMessage.toUser = toUser;
      textMessage.toParty = toParty;
      textMessage.toTag = toTag;
      textMessage.safe = safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue();
      textMessage.enableIdTrans = enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue();
      return textMessage;
    }
  }
}
