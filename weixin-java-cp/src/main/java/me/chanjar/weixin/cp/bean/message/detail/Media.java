package me.chanjar.weixin.cp.bean.message.detail;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author roc
 * @since 2019/8/27 16:30
 */
@Getter
@Setter
@ToString
public class Media implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * media_id，可以调用上传临时素材接口获取
   */
  @SerializedName("media_id")
  private String mediaId;

  public Media(String mediaId) {
    this.mediaId = mediaId;
  }
}
