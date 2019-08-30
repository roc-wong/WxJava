package me.chanjar.weixin.cp.bean.message;

import com.google.gson.Gson;
import me.chanjar.weixin.common.constant.IdTransEnum;
import me.chanjar.weixin.common.constant.MsgSafeEnum;
import me.chanjar.weixin.cp.bean.article.MpnewsArticle;
import me.chanjar.weixin.cp.bean.article.NewArticle;
import me.chanjar.weixin.cp.bean.message.subassembly.MiniProgramNotice;
import me.chanjar.weixin.cp.bean.message.subassembly.MpNews;
import me.chanjar.weixin.cp.bean.message.subassembly.News;
import me.chanjar.weixin.cp.bean.message.subassembly.TaskCard;
import me.chanjar.weixin.cp.bean.message.subassembly.TextCard;
import me.chanjar.weixin.cp.bean.message.subassembly.Video;
import me.chanjar.weixin.cp.bean.taskcard.TaskCardButton;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author roc
 * @since 2019/8/27 19:41
 */
public class WxCpMessageTest {

  private Gson gson = new Gson();

  @Test
  public void testTextMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1|PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"text\",\"agentid\":1,\"text\":{\"content\":\"你的快递已到，请携带工卡前往邮件中心领取。出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"},\"safe\":0,\"enable_id_trans\":0}";
    TextMessage templateMessage = gson.fromJson(originalTemplateJson, TextMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    TextMessage textMessage = TextMessage.newBuilder()
      .setContent("你的快递已到，请携带工卡前往邮件中心领取。出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。")
      .setAgentId(1)
      .setEnableIdTrans(IdTransEnum.DISABLE)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1|PartyID2")
      .setToTag("TagID1 | TagID2")
      .setSafe(MsgSafeEnum.NO).build();

    String compareValue = gson.toJson(textMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testVoiceMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1|PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"voice\",\"agentid\":1,\"voice\":{\"media_id\":\"MEDIA_ID\"}}";
    VoiceMessage templateMessage = gson.fromJson(originalTemplateJson, VoiceMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    VoiceMessage voiceMessage = VoiceMessage.newBuilder()
      .setMediaId("MEDIA_ID")
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1|PartyID2")
      .setToTag("TagID1 | TagID2").build();

    String compareValue = gson.toJson(voiceMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testImageMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1|PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"image\",\"agentid\":1,\"image\":{\"media_id\":\"MEDIA_ID\"},\"safe\":0}";
    ImageMessage templateMessage = gson.fromJson(originalTemplateJson, ImageMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    ImageMessage imageMessage = ImageMessage.newBuilder()
      .setMediaId("MEDIA_ID")
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1|PartyID2")
      .setToTag("TagID1 | TagID2")
      .setSafe(MsgSafeEnum.NO).build();

    String compareValue = gson.toJson(imageMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testVideoMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1|PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"video\",\"agentid\":1,\"video\":{\"media_id\":\"MEDIA_ID\",\"title\":\"Title\",\"description\":\"Description\"},\"safe\":0}";
    VideoMessage templateMessage = gson.fromJson(originalTemplateJson, VideoMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    Video video = Video.newBuilder().mediaId("MEDIA_ID").title("Title").description("Description").build();

    VideoMessage videoMessage = VideoMessage.newBuilder()
      .setVideo(video)
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1|PartyID2")
      .setToTag("TagID1 | TagID2")
      .setSafe(MsgSafeEnum.NO).build();

    String compareValue = gson.toJson(videoMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testFileMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1|PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"file\",\"agentid\":1,\"file\":{\"media_id\":\"1Yv-zXfHjSjU-7LH-GwtYqDGS-zz6w22KmWAT5COgP7o\"},\"safe\":0}";
    FileMessage templateMessage = gson.fromJson(originalTemplateJson, FileMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    FileMessage fileMessage = FileMessage.newBuilder()
      .setMediaId("1Yv-zXfHjSjU-7LH-GwtYqDGS-zz6w22KmWAT5COgP7o")
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1|PartyID2")
      .setToTag("TagID1 | TagID2")
      .setSafe(MsgSafeEnum.NO).build();

    String compareValue = gson.toJson(fileMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testTextCardMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1 | PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"textcard\",\"agentid\":1,\"textcard\":{\"title\":\"领奖通知\",\"description\":\"<div class=\\\"gray\\\">2016年9月26日</div> <div class=\\\"normal\\\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\\\"highlight\\\">请于2016年10月10日前联系行政同事领取</div>\",\"url\":\"URL\",\"btntxt\":\"更多\"},\"enable_id_trans\":0}";
    TextCardMessage templateMessage = gson.fromJson(originalTemplateJson, TextCardMessage.class);

    String gsonSerializeTemplate = gson.toJson(templateMessage);

    TextCard textCard = TextCard.newBuilder().title("领奖通知")
      .description("<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>")
      .url("URL")
      .btnTxt("更多")
      .build();

    TextCardMessage textCardMessage = TextCardMessage.newBuilder()
      .setTextCard(textCard)
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1 | PartyID2")
      .setToTag("TagID1 | TagID2")
      .setEnableIdTrans(IdTransEnum.DISABLE).build();

    String compareValue = gson.toJson(textCardMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testNewsMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1 | PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"news\",\"agentid\":1,\"news\":{\"articles\":[{\"title\":\"中秋节礼品领取\",\"description\":\"今年中秋节公司有豪礼相送\",\"url\":\"URL\",\"picurl\":\"http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png\"}]},\"enable_id_trans\":0}";
    NewsMessage templateMessage = gson.fromJson(originalTemplateJson, NewsMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    News news = new News();

    NewArticle newArticle = NewArticle.builder().title("中秋节礼品领取")
      .description("今年中秋节公司有豪礼相送")
      .url("URL")
      .picUrl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png")
      .build();

    news.addArticle(newArticle);

    NewsMessage newsMessage = NewsMessage.newBuilder()
      .setNews(news)
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1 | PartyID2")
      .setToTag("TagID1 | TagID2").build();

    String compareValue = gson.toJson(newsMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }


  @Test
  public void testMpNewsMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1 | PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"mpnews\",\"agentid\":1,\"mpnews\":{\"articles\":[{\"title\":\"Title\",\"thumb_media_id\":\"MEDIA_ID\",\"author\":\"Author\",\"content_source_url\":\"URL\",\"content\":\"Content\",\"digest\":\"Digest description\"}]},\"safe\":0,\"enable_id_trans\":0}";
    MpnewsMessage templateMessage = gson.fromJson(originalTemplateJson, MpnewsMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    MpNews mpNews = new MpNews();

    MpnewsArticle newArticle = MpnewsArticle.newBuilder().title("Title")
      .thumbMediaId("MEDIA_ID")
      .author("Author")
      .contentSourceUrl("URL")
      .content("Content")
      .digest("Digest description")
      .build();

    mpNews.addArticle(newArticle);

    MpnewsMessage fileMessage = MpnewsMessage.newBuilder()
      .setMpnews(mpNews)
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1 | PartyID2")
      .setToTag("TagID1 | TagID2").build();

    String compareValue = gson.toJson(fileMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testMarkdownMessage() {

    String originalTemplateJson = "{\n" +
      "   \"touser\" : \"UserID1|UserID2|UserID3\",\n" +
      "   \"toparty\" : \"PartyID1|PartyID2\",\n" +
      "   \"totag\" : \"TagID1 | TagID2\",\n" +
      "   \"msgtype\": \"markdown\",\n" +
      "   \"agentid\" : 1,\n" +
      "   \"markdown\": {\n" +
      "        \"content\": \"您的会议室已经预定，稍后会同步到`邮箱` \n" +
      "                >**事项详情** \n" +
      "                >事　项：<font color=\\\"info\\\">开会</font> \n" +
      "                >组织者：@miglioguan \n" +
      "                >参与者：@miglioguan、@kunliu、@jamdeezhou、@kanexiong、@kisonwang \n" +
      "                > \n" +
      "                >会议室：<font color=\\\"info\\\">广州TIT 1楼 301</font> \n" +
      "                >日　期：<font color=\\\"warning\\\">2018年5月18日</font> \n" +
      "                >时　间：<font color=\\\"comment\\\">上午9:00-11:00</font> \n" +
      "                > \n" +
      "                >请准时参加会议。 \n" +
      "                > \n" +
      "                >如需修改会议信息，请点击：[修改会议信息](https://work.weixin.qq.com)\"\n" +
      "   }\n" +
      "}";
    MarkdownMessage templateMessage = gson.fromJson(originalTemplateJson, MarkdownMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    MarkdownMessage markdownMessage = MarkdownMessage.newBuilder()
      .setContent("您的会议室已经预定，稍后会同步到`邮箱` \n" +
        "                >**事项详情** \n" +
        "                >事　项：<font color=\"info\">开会</font> \n" +
        "                >组织者：@miglioguan \n" +
        "                >参与者：@miglioguan、@kunliu、@jamdeezhou、@kanexiong、@kisonwang \n" +
        "                > \n" +
        "                >会议室：<font color=\"info\">广州TIT 1楼 301</font> \n" +
        "                >日　期：<font color=\"warning\">2018年5月18日</font> \n" +
        "                >时　间：<font color=\"comment\">上午9:00-11:00</font> \n" +
        "                > \n" +
        "                >请准时参加会议。 \n" +
        "                > \n" +
        "                >如需修改会议信息，请点击：[修改会议信息](https://work.weixin.qq.com)")
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1|PartyID2")
      .setToTag("TagID1 | TagID2").build();

    String compareValue = gson.toJson(markdownMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testMiniProgramNoticeMessage() {

    String originalTemplateJson = "{\"touser\":\"zhangsan|lisi\",\"toparty\":\"1|2\",\"totag\":\"1|2\",\"msgtype\":\"miniprogram_notice\",\"miniprogram_notice\":{\"appid\":\"wx123123123123123\",\"page\":\"pages/index?userid=zhangsan&orderid=123123123\",\"title\":\"会议室预订成功通知\",\"description\":\"4月27日 16:16\",\"emphasis_first_item\":true,\"content_item\":[{\"key\":\"会议室\",\"value\":\"402\"},{\"key\":\"会议地点\",\"value\":\"广州TIT-402会议室\"},{\"key\":\"会议时间\",\"value\":\"2018年8月1日 09:00-09:30\"},{\"key\":\"参与人员\",\"value\":\"周剑轩\"}]}}";
    MiniProgramNoticeMessage templateMessage = gson.fromJson(originalTemplateJson, MiniProgramNoticeMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    MiniProgramNotice miniProgramNotice = MiniProgramNotice.newBuilder()
      .setAppId("wx123123123123123")
      .setPage("pages/index?userid=zhangsan&orderid=123123123")
      .setTitle("会议室预订成功通知")
      .setDescription("4月27日 16:16")
      .setEmphasisFirstItem(true)
      .addContentItem("会议室", "402")
      .addContentItem("会议地点", "广州TIT-402会议室")
      .addContentItem("会议时间", "2018年8月1日 09:00-09:30")
      .addContentItem("参与人员", "周剑轩")
      .build();

    MiniProgramNoticeMessage miniProgramNoticeMessage = MiniProgramNoticeMessage.newBuilder()
      .setMiniProgramNotice(miniProgramNotice)
      .setToUser("zhangsan|lisi")
      .setToParty("1|2")
      .setToTag("1|2").build();

    String compareValue = gson.toJson(miniProgramNoticeMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }

  @Test
  public void testTaskCardMessage() {

    String originalTemplateJson = "{\"touser\":\"UserID1|UserID2|UserID3\",\"toparty\":\"PartyID1 | PartyID2\",\"totag\":\"TagID1 | TagID2\",\"msgtype\":\"taskcard\",\"agentid\":1,\"taskcard\":{\"title\":\"赵明登的礼物申请\",\"description\":\"礼品：A31茶具套装<br>用途：赠与小黑科技张总经理\",\"url\":\"URL\",\"task_id\":\"taskid123\",\"btn\":[{\"key\":\"key111\",\"name\":\"批准\",\"replace_name\":\"已批准\",\"color\":\"red\",\"is_bold\":true},{\"key\":\"key222\",\"name\":\"驳回\",\"replace_name\":\"已驳回\"}]}}";
    TaskCardMessage templateMessage = gson.fromJson(originalTemplateJson, TaskCardMessage.class);
    String gsonSerializeTemplate = gson.toJson(templateMessage);

    TaskCardButton taskCardButton1 = TaskCardButton.builder()
      .key("key111")
      .name("批准")
      .replaceName("已批准")
      .color("red")
      .bold(true).build();

    TaskCardButton taskCardButton2 = TaskCardButton.builder()
      .key("key222")
      .name("驳回")
      .replaceName("已驳回").build();

    TaskCard taskCard = TaskCard.newBuilder().setTaskId("taskid123")
      .setTitle("赵明登的礼物申请")
      .setDescription("礼品：A31茶具套装<br>用途：赠与小黑科技张总经理")
      .setUrl("URL")
      .addButtons(taskCardButton1, taskCardButton2)
      .build();

    TaskCardMessage taskCardMessage = TaskCardMessage.newBuilder()
      .setTaskCard(taskCard)
      .setAgentId(1)
      .setToUser("UserID1|UserID2|UserID3")
      .setToParty("PartyID1 | PartyID2")
      .setToTag("TagID1 | TagID2").build();

    String compareValue = gson.toJson(taskCardMessage);

    assertThat(gsonSerializeTemplate).isEqualTo(compareValue);
  }
}
