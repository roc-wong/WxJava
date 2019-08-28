package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.subassembly.Media;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class ImageMessage extends BaseWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 图片媒体文件id，可以调用上传临时素材接口获取
   */
  @SerializedName("image")
  private Media media;

  /**
   * 表示是否是保密消息，0表示否，1表示是，默认0
   */
  @SerializedName("safe")
  protected String safe = MsgSafeEnum.NO.getValue();

  private ImageMessage() {
    setMsgType(WxConsts.KefuMsgType.IMAGE);
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

    public ImageMessage.Builder setSafe(MsgSafeEnum safe) {
      this.safe = safe;
      return this;
    }

    public ImageMessage build() {
      ImageMessage imageMessage = new ImageMessage();
      imageMessage.media = new Media(mediaId);
      imageMessage.agentId = agentId;
      imageMessage.toUser = toUser;
      imageMessage.toParty = toParty;
      imageMessage.toTag = toTag;
      imageMessage.safe = safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue();
      return imageMessage;
    }
  }
}
