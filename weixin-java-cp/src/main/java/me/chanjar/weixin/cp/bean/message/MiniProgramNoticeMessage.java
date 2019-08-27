package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.MiniProgramNotice;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class MiniProgramNoticeMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  @SerializedName("miniprogram_notice")
  private MiniProgramNotice miniProgramNotice;

  public MiniProgramNoticeMessage() {
    setMsgType(WxConsts.KefuMsgType.MINIPROGRAM_NOTICE);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    protected Integer agentId;
    protected String toUser;
    private String toParty;
    private String toTag;
    private MsgSafeEnum safe = MsgSafeEnum.NO;
    private IdTransEnum enableIdTrans = IdTransEnum.DISABLE;
    private MiniProgramNotice miniProgramNotice;

    private Builder() {
    }

    public Builder setMiniProgramNotice(MiniProgramNotice miniProgramNotice) {
      this.miniProgramNotice = miniProgramNotice;
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

    public MiniProgramNoticeMessage build() {
      MiniProgramNoticeMessage miniProgramNoticeMessage = new MiniProgramNoticeMessage();
      miniProgramNoticeMessage.setMiniProgramNotice(miniProgramNotice);
      miniProgramNoticeMessage.setAgentId(agentId);
      miniProgramNoticeMessage.setToUser(toUser);
      miniProgramNoticeMessage.setToParty(toParty);
      miniProgramNoticeMessage.setToTag(toTag);
      miniProgramNoticeMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      miniProgramNoticeMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return miniProgramNoticeMessage;
    }
  }
}
