package me.chanjar.weixin.cp.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.cp.bean.message.subassembly.TaskCard;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString(callSuper = true)
public class TaskCardMessage extends BaseWxCpMessage {

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

    public TaskCardMessage build() {
      TaskCardMessage taskCardMessage = new TaskCardMessage();
      taskCardMessage.taskCard = taskCard;
      taskCardMessage.agentId = agentId;
      taskCardMessage.toUser = toUser;
      taskCardMessage.toParty = toParty;
      taskCardMessage.toTag = toTag;
      return taskCardMessage;
    }
  }
}
