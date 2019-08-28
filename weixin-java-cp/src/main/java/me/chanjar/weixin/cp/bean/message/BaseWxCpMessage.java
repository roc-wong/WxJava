package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;

import java.io.Serializable;

/**
 * @author roc
 * @since 2019/8/23 20:15
 */
@Getter
@Setter
@ToString
public class BaseWxCpMessage implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 消息类型：{@link  WxConsts.KefuMsgType}
   */
  @SerializedName("msgtype")
  protected String msgType;

  /**
   * 企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
   */
  @SerializedName("agentid")
  protected Integer agentId;

  /**
   * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
   */
  @SerializedName("touser")
  protected String toUser;

  /**
   * 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
   */
  @SerializedName("toparty")
  protected String toParty;

  /**
   * 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
   */
  @SerializedName("totag")
  protected String toTag;
}
