package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.Video;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class VideoMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  @SerializedName("video")
  private Video video;

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
    private IdTransEnum enableIdTrans = IdTransEnum.DISABLE;
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

    public Builder setEnableIdTrans(IdTransEnum enableIdTrans) {
      this.enableIdTrans = enableIdTrans;
      return this;
    }

    public VideoMessage build() {
      VideoMessage videoMessage = new VideoMessage();
      videoMessage.setVideo(video);
      videoMessage.setAgentId(agentId);
      videoMessage.setToUser(toUser);
      videoMessage.setToParty(toParty);
      videoMessage.setToTag(toTag);
      videoMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      videoMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return videoMessage;
    }
  }
}
