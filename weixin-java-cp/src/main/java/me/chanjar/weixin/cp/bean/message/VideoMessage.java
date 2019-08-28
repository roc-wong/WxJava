package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.subassembly.Video;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class VideoMessage extends BaseWxCpMessage {

  private static final long serialVersionUID = 1L;

  @SerializedName("video")
  private Video video;

  /**
   * 表示是否是保密消息，0表示否，1表示是，默认0
   */
  @SerializedName("safe")
  protected String safe = MsgSafeEnum.NO.getValue();

  private VideoMessage() {
    setMsgType(WxConsts.KefuMsgType.VIDEO);
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
    private Video video;

    private Builder() {
    }

    public Builder setVideo(Video video) {
      this.video = video;
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

    public VideoMessage build() {
      VideoMessage videoMessage = new VideoMessage();
      videoMessage.video = video;
      videoMessage.agentId = agentId;
      videoMessage.toUser = toUser;
      videoMessage.toParty = toParty;
      videoMessage.toTag = toTag;
      videoMessage.safe = safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue();
      return videoMessage;
    }
  }
}
