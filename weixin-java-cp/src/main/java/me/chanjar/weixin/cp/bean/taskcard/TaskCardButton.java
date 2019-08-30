package me.chanjar.weixin.cp.bean.taskcard;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

/**
 * <pre>
 *  任务卡片按钮
 *  Created by Jeff on 2019-05-16.
 * </pre>
 *
 * @author <a href="https://github.com/domainname">Jeff</a>
 * @date 2019-05-16
 */
@Getter
@ToString
public class TaskCardButton {

  /**
   * 按钮key值，用户点击后，会产生任务卡片回调事件，回调事件会带上该key值，只能由数字、字母和“_-@.”组成，最长支持128字节
   */
  private String key;

  /**
   * 按钮名称
   */
  private String name;

  /**
   * 点击按钮后显示的名称，默认为“已处理”
   */
  @SerializedName("replace_name")
  private String replaceName;

  /**
   * 按钮字体颜色，可选“red”或者“blue”,默认为“blue”
   */
  private String color;

  /**
   * 按钮字体是否加粗，默认false
   */
  @SerializedName("is_bold")
  private Boolean bold;

  public static Builder builder() {
    return new Builder();
  }


  public static final class Builder {
    private String key;
    private String name;
    private String replaceName;
    private String color;
    private Boolean bold;

    private Builder() {
    }

    public Builder key(String key) {
      this.key = key;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder replaceName(String replaceName) {
      this.replaceName = replaceName;
      return this;
    }

    public Builder color(String color) {
      this.color = color;
      return this;
    }

    public Builder bold(Boolean bold) {
      this.bold = bold;
      return this;
    }

    public TaskCardButton build() {
      TaskCardButton taskCardButton = new TaskCardButton();
      taskCardButton.name = this.name;
      taskCardButton.key = this.key;
      taskCardButton.replaceName = this.replaceName;
      taskCardButton.color = this.color;
      taskCardButton.bold = this.bold;
      return taskCardButton;
    }
  }
}
