package me.chanjar.weixin.cp.bean.message.subassembly;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.cp.bean.article.NewArticle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * safe表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，2表示仅限在企业内分享，默认为0；
 * 注意仅mpnews类型的消息支持safe值为2，其他消息类型不支持
 *
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString
public class News implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 图文消息，一个图文消息支持1到8条图文
   */
  private List<NewArticle> articles = new ArrayList<>();

  public void addArticles(NewArticle... articles) {
    Collections.addAll(this.articles, articles);
  }

  public void addArticle(NewArticle article) {
    this.articles.add(article);
  }
}
