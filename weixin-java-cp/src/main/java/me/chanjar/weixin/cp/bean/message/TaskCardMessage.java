package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.message.detail.TaskCard;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class TaskCardMessage extends AbstractWxCpMessage {

  private static final long serialVersionUID = 1L;

  /**
   * 按钮个数为1~2个
   */
  @SerializedName("taskcard")
  private TaskCard taskCard;

  private TaskCardMessage() {
    setMsgType(WxConsts.KefuMsgType.TASKCARD);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    protected Integer agentId;
    protected String toUser;
    protected String toParty;
    protected String toTag;
    private MsgSafeEnum safe = MsgSafeEnum.NO;
    private IdTransEnum enableIdTrans = IdTransEnum.DISABLE;
    private TaskCard taskCard;

    private Builder() {
    }

    public Builder setTaskCard(TaskCard taskCard) {
      this.taskCard = taskCard;
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

    public TaskCardMessage build() {
      TaskCardMessage taskCardMessage = new TaskCardMessage();
      taskCardMessage.setTaskCard(taskCard);
      taskCardMessage.setAgentId(agentId);
      taskCardMessage.setToUser(toUser);
      taskCardMessage.setToParty(toParty);
      taskCardMessage.setToTag(toTag);
      taskCardMessage.setSafe(safe != null ? safe.getValue() : MsgSafeEnum.NO.getValue());
      taskCardMessage.setEnableIdTrans(enableIdTrans != null ? enableIdTrans.getValue() : IdTransEnum.DISABLE.getValue());
      return taskCardMessage;
    }
  }
}
