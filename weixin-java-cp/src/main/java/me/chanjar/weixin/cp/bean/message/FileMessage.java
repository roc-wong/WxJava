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
public class FileMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 文件id，可以调用上传临时素材接口获取
   */
  @SerializedName("file")
  private Media media;

  private FileMessage() {
    setMsgType(WxConsts.KefuMsgType.FILE);
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

    public Builder setSafe(MsgSafeEnum safe) {
      this.safe = safe;
      return this;
    }

    public Builder setEnableIdTrans(IdTransEnum enableIdTrans) {
      this.enableIdTrans = enableIdTrans;
      return this;
    }

    public FileMessage build() {
      FileMessage fileMessage = new FileMessage();
      fileMessage.setMedia(new Media(mediaId));
      fileMessage.setAgentId(agentId);
      fileMessage.setToUser(toUser);
      fileMessage.setToParty(toParty);
      fileMessage.setToTag(toTag);
      fileMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      fileMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return fileMessage;
    }
  }
}
