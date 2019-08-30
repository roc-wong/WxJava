package me.chanjar.weixin.cp.bean.message.subassembly;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString
public class Video implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 视频媒体文件id，可以调用上传临时素材接口获取
   */
  @SerializedName("media_id")
  private String mediaId;

  /**
   * 视频消息的标题，不超过128个字节，超过会自动截断
   */
  private String title;

  /**
   * 视频消息的描述，不超过512个字节，超过会自动截断
   */
  private String description;

  /**
   * 图文消息缩略图的media_id, 可以通过素材管理接口获得。此处thumb_media_id即上传接口返回的media_id。
   * <p>
   * 接口文档中未找到该字段的在本接口的使用说明。
   */
  @SerializedName("thumb_media_id")
  private String thumbMediaId;

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String mediaId;
    private String title;
    private String description;
    private String thumbMediaId;

    private Builder() {
    }

    public Builder mediaId(String mediaId) {
      this.mediaId = mediaId;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder thumbMediaId(String thumbMediaId) {
      this.thumbMediaId = thumbMediaId;
      return this;
    }

    public Video build() {
      Video video = new Video();
      video.description = this.description;
      video.mediaId = this.mediaId;
      video.thumbMediaId = this.thumbMediaId;
      video.title = this.title;
      return video;
    }
  }
}
