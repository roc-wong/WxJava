package me.chanjar.weixin.cp.bean.article;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewArticle implements Serializable {
  private static final long serialVersionUID = 4087852055781140659L;

  /**
   * 标题，不超过128个字节，超过会自动截断（支持id转译）
   */
  private String title;

  /**
   * 描述，不超过512个字节，超过会自动截断（支持id转译）
   */
  private String description;

  /**
   * 点击后跳转的链接。
   */
  private String url;

  /**
   * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
   */
  @SerializedName("picurl")
  private String picUrl;

}
