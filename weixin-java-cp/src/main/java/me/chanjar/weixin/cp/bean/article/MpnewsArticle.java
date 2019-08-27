package me.chanjar.weixin.cp.bean.article;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *  Created by BinaryWang on 2017/3/27.
 * </pre>
 *
 * @author Binary Wang
 * @author Roc Wong
 */
@Data
@Builder(builderMethodName = "newBuilder")
public class MpnewsArticle implements Serializable {
  private static final long serialVersionUID = 6985871812170756481L;

  /**
   * 标题，不超过128个字节，超过会自动截断（支持id转译）
   */
  private String title;

  /**
   * 图文消息缩略图的media_id, 可以通过素材管理接口获得。此处thumb_media_id即上传接口返回的media_id
   */
  @SerializedName("thumb_media_id")
  private String thumbMediaId;

  /**
   * 图文消息的作者，不超过64个字节
   */
  private String author;

  /**
   * 图文消息点击“阅读原文”之后的页面链接
   */
  @SerializedName("content_source_url ")
  private String contentSourceUrl;

  /**
   * 图文消息的内容，支持html标签，不超过666 K个字节（支持id转译）
   */
  private String content;

  /**
   * 图文消息的描述，不超过512个字节，超过会自动截断（支持id转译）
   */
  private String digest;

  /**
   * 未知，没有在企业微信API中找到对应的说明
   */
  @SerializedName("show_cover_pic ")
  private String showCoverPic;

}
