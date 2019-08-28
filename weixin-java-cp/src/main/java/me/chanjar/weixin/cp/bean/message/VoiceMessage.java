package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.cp.bean.message.subassembly.Media;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class VoiceMessage extends BaseWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 语音文件id，可以调用上传临时素材接口获取
   */
  @SerializedName("voice")
  private Media media;

  private VoiceMessage() {
    setMsgType(WxConsts.KefuMsgType.VOICE);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private Integer agentId;
    private String toUser;
    private String toParty;
    private String toTag;
    private String mediaId;

    private Builder() {
    }

    public Builder setMediaId(String mediaId) {
      this.mediaId = mediaId;
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

    public VoiceMessage build() {
      VoiceMessage voiceMessage = new VoiceMessage();
      voiceMessage.media = new Media(mediaId);
      voiceMessage.agentId = agentId;
      voiceMessage.toUser = toUser;
      voiceMessage.toParty = toParty;
      voiceMessage.toTag = toTag;
      return voiceMessage;
    }
  }
}
