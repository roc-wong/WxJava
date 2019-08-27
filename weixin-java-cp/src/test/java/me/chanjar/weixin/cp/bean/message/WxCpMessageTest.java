package me.chanjar.weixin.cp.bean.message;

import com.google.gson.Gson;
import me.chanjar.weixin.common.constant.IdTransEnum;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author roc
 * @since 2019/8/27 19:41
 */
public class WxCpMessageTest {

  private Gson gson = new Gson();

  @Test
  public void tesFileMessage() {
    FileMessage fileMessage = FileMessage.newBuilder()
      .setMediaId("http://baidu.com")
      .setAgentId(1000)
      .setToUser("roc.wong")
      .setEnableIdTrans(IdTransEnum.ENABLE).build();
    System.out.println(fileMessage);
    String toJson = gson.toJson(fileMessage);
    System.out.println(toJson);
    assertThat(toJson).isEqualTo("{\"file\":{\"media_id\":\"http://baidu.com\"},\"msgtype\":\"file\",\"agentid\":1000,\"touser\":\"roc.wong\",\"safe\":\"0\",\"enable_id_trans\":\"1\"}");
  }
}
