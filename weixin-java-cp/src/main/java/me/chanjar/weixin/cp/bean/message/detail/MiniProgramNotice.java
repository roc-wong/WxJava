package me.chanjar.weixin.cp.bean.message.detail;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@Builder
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
}
