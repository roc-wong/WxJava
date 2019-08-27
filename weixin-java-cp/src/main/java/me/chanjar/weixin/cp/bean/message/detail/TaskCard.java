package me.chanjar.weixin.cp.bean.message.detail;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.chanjar.weixin.cp.bean.taskcard.TaskCardButton;

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

}
