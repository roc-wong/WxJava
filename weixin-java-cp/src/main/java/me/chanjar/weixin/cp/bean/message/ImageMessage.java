package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.Media;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ImageMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 图片媒体文件id，可以调用上传临时素材接口获取
   */
  @SerializedName("image")
  private Media media;

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
    private IdTransEnum enableIdTrans = IdTransEnum.DISABLE;
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

    public ImageMessage.Builder setEnableIdTrans(IdTransEnum enableIdTrans) {
      this.enableIdTrans = enableIdTrans;
      return this;
    }

    public ImageMessage build() {
      ImageMessage imageMessage = new ImageMessage();
      imageMessage.setMedia(new Media(mediaId));
      imageMessage.setAgentId(agentId);
      imageMessage.setToUser(toUser);
      imageMessage.setToParty(toParty);
      imageMessage.setToTag(toTag);
      imageMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      imageMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return imageMessage;
    }
  }
}
