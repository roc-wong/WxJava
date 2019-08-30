package me.chanjar.weixin.cp.bean.message.subassembly;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@NoArgsConstructor
@ToString
public class MiniProgramNotice implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 消息标题，长度限制4-12个汉字
   */
  private String title;

  /**
   * 消息描述，长度限制4-12个汉字
   */
  private String description;

  /**
   * 小程序appid，必须是与当前小程序应用关联的小程序
   */
  @SerializedName("appid")
  private String appId;

  /**
   * 点击消息卡片后的小程序页面，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
   */
  private String page;

  /**
   * 是否放大第一个content_item
   */
  @SerializedName("emphasis_first_item")
  private Boolean emphasisFirstItem;

  /**
   * 消息内容键值对，最多允许10个item
   */
  @SerializedName("content_item")
  private List<MiniProgramContentItem> contentItems = new ArrayList<>();


  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String title;
    private String description;
    private String appId;
    private String page;
    private Boolean emphasisFirstItem;
    private List<MiniProgramContentItem> contentItems = new ArrayList<>();

    private Builder() {
    }

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public Builder setPage(String page) {
      this.page = page;
      return this;
    }

    public Builder setEmphasisFirstItem(Boolean emphasisFirstItem) {
      this.emphasisFirstItem = emphasisFirstItem;
      return this;
    }

    public Builder setContentItems(List<MiniProgramContentItem> contentItems) {
      this.contentItems = contentItems;
      return this;
    }

    public Builder addContentItem(String key, String value) {
      this.contentItems.add(new MiniProgramContentItem(key, value));
      return this;
    }

    public Builder addContentItem(MiniProgramContentItem contentItem) {
      this.contentItems.add(contentItem);
      return this;
    }

    public Builder addContentItems(MiniProgramContentItem... contentItems) {
      Collections.addAll(this.contentItems, contentItems);
      return this;
    }

    public MiniProgramNotice build() {
      MiniProgramNotice miniProgramNotice = new MiniProgramNotice();
      miniProgramNotice.description = this.description;
      miniProgramNotice.emphasisFirstItem = this.emphasisFirstItem;
      miniProgramNotice.title = this.title;
      miniProgramNotice.appId = this.appId;
      miniProgramNotice.page = this.page;
      miniProgramNotice.contentItems = this.contentItems;
      return miniProgramNotice;
    }
  }
}
