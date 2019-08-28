package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.cp.bean.message.subassembly.MiniProgramNotice;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class MiniProgramNoticeMessage extends BaseWxCpMessage {

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

    public MiniProgramNoticeMessage build() {
      MiniProgramNoticeMessage miniProgramNoticeMessage = new MiniProgramNoticeMessage();
      miniProgramNoticeMessage.miniProgramNotice = miniProgramNotice;
      miniProgramNoticeMessage.agentId = agentId;
      miniProgramNoticeMessage.toUser = toUser;
      miniProgramNoticeMessage.toParty = toParty;
      miniProgramNoticeMessage.toTag = toTag;
      return miniProgramNoticeMessage;
    }
  }
}
