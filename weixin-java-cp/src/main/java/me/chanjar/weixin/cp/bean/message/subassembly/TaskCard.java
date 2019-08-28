package me.chanjar.weixin.cp.bean.message.subassembly;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import me.chanjar.weixin.cp.bean.taskcard.TaskCardButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author roc
 * @since 2019/8/23 20:12
 */
@Getter
@ToString
public class TaskCard implements Serializable {

  private static final long serialVersionUID = 1L;

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
   * 任务id，同一个应用发送的任务卡片消息的任务id不能重复，只能由数字、字母和“_-@.”组成，最长支持128字节
   */
  @SerializedName("task_id")
  private String taskId;

  /**
   * 按钮个数为1~2个
   */
  @SerializedName("btn")
  private List<TaskCardButton> buttons = new ArrayList<>();

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {
    private String title;
    private String description;
    private String url;
    private String taskId;
    private List<TaskCardButton> buttons = new ArrayList<>();

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

    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    public Builder setTaskId(String taskId) {
      this.taskId = taskId;
      return this;
    }

    public Builder setButtons(List<TaskCardButton> buttons) {
      this.buttons = buttons;
      return this;
    }

    public Builder addButton(TaskCardButton taskCardButton) {
      this.buttons.add(taskCardButton);
      return this;
    }

    public Builder addButtons(TaskCardButton... taskCardButton) {
      Collections.addAll(this.buttons, taskCardButton);
      return this;
    }

    public TaskCard build() {
      TaskCard taskCard = new TaskCard();
      taskCard.buttons = this.buttons;
      taskCard.description = this.description;
      taskCard.title = this.title;
      taskCard.taskId = this.taskId;
      taskCard.url = this.url;
      return taskCard;
    }
  }
}
