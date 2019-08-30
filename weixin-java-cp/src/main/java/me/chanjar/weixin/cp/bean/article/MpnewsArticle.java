package me.chanjar.weixin.cp.bean.article;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <pre>
 *  Created by BinaryWang on 2017/3/27.
 * </pre>
 *
 * @author Binary Wang
 * @author Roc Wong
 */
@Getter
@NoArgsConstructor
@ToString
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
  @SerializedName("content_source_url")
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
  @SerializedName("show_cover_pic")
  private String showCoverPic;


  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String title;
    private String thumbMediaId;
    private String author;
    private String contentSourceUrl;
    private String content;
    private String digest;
    private String showCoverPic;

    private Builder() {
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder thumbMediaId(String thumbMediaId) {
      this.thumbMediaId = thumbMediaId;
      return this;
    }

    public Builder author(String author) {
      this.author = author;
      return this;
    }

    public Builder contentSourceUrl(String contentSourceUrl) {
      this.contentSourceUrl = contentSourceUrl;
      return this;
    }

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Builder digest(String digest) {
      this.digest = digest;
      return this;
    }

    public Builder showCoverPic(String showCoverPic) {
      this.showCoverPic = showCoverPic;
      return this;
    }

    public MpnewsArticle build() {
      MpnewsArticle mpnewsArticle = new MpnewsArticle();
      mpnewsArticle.title = this.title;
      mpnewsArticle.showCoverPic = this.showCoverPic;
      mpnewsArticle.contentSourceUrl = this.contentSourceUrl;
      mpnewsArticle.thumbMediaId = this.thumbMediaId;
      mpnewsArticle.content = this.content;
      mpnewsArticle.author = this.author;
      mpnewsArticle.digest = this.digest;
      return mpnewsArticle;
    }
  }
}
