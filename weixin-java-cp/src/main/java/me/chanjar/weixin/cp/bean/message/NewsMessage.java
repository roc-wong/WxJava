package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.News;

/**
 * safe表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，2表示仅限在企业内分享，默认为0；
 * 注意仅mpnews类型的消息支持safe值为2，其他消息类型不支持
 *
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class NewsMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 图文消息，一个图文消息支持1到8条图文
   */
  @SerializedName("mpnews")
  private News news;

  private NewsMessage() {
    setMsgType(WxConsts.KefuMsgType.NEWS);
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
    private News news;

    private Builder() {
    }

    public Builder setNews(News news) {
      this.news = news;
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

    public NewsMessage build() {
      NewsMessage newsMessage = new NewsMessage();
      newsMessage.setNews(news);
      newsMessage.setAgentId(agentId);
      newsMessage.setToUser(toUser);
      newsMessage.setToParty(toParty);
      newsMessage.setToTag(toTag);
      newsMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      newsMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return newsMessage;
    }
  }
}
