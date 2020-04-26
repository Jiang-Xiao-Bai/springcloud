package com.ssm.springboot.DemoTests;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信公众号推送
 * @author zhaohf
 * @date 2020/4/26 23:07
 */
public class WeChatPushTest {

    public void push() {
        final String TEMPLATEID="HSoVwHhVAIAC8a4D3qDNDL4pCxF5cbw_NXjRd0QW7Vo";//测试
//        final String APPID = "wx207c0346b5784b16";
        final String APPID = "wx4cbabc17ed1499cb";//测试

//        final String SECRET = "fb44638634e03ab8fb3b5b01fc02b149";
        final String SECRET = "6fac3ce5dd261a06cda9f9ab60fb0490";//测试

        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(APPID);
        wxStorage.setSecret(SECRET);

        //微信工具类
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);//连接微信

        //2,推送消息
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(TEMPLATEID);

        List<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
        List<String> openList = new ArrayList<>();
        try {
            openList = recursionOpenId(openList,null,wxMpService);
            for(String id : openList){
                templateMessage.setToUser(id);//要推送的用户openid
                wxMpTemplateData.add(new WxMpTemplateData("first", "交通违停提醒","#FF00FF"));
                wxMpTemplateData.add(new WxMpTemplateData("message", "xxx道路违停","#FF00FF"));
                wxMpTemplateData.add(new WxMpTemplateData("numberPlate", "粤S8888","#FF00FF"));
                wxMpTemplateData.add(new WxMpTemplateData("createTime","2020-04-05","#FF00FF"));
                templateMessage.setData(wxMpTemplateData);//存放数据
                wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            }
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 递归查询openId,一次最多拉取10000各个关注者的OpenId,可以多次拉取满足需求
     * @param openIdList
     * @param nextOpenId 第一次拉取的openId,不填默认从头开始拉取
     * @param wxMpService
     * @return
     */
    public List<String> recursionOpenId(List<String> openIdList, String nextOpenId, WxMpService wxMpService){
        try {
            WxMpUserList openList = wxMpService.getUserService().userList(nextOpenId);
            for(String strId :openList.getOpenids()){
                openIdList.add(strId);
            }
            if(openList.getOpenids().size()>10000){
                recursionOpenId(openIdList,openList.getNextOpenid(),wxMpService);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return openIdList;
    }

    public static void main(String[] args) {
        WeChatPushTest weChatPushTest=new WeChatPushTest();
        weChatPushTest.push();
//        weChatPushTest.push2();
    }

    public void push2(){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx4cbabc17ed1499cb");
        wxStorage.setSecret("6fac3ce5dd261a06cda9f9ab60fb0490");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o5bHDs7PqMETAbHo6_MFJ05Yzodo")//要推送的用户openid
                .templateId("KjUW3z60AC3_O8x3aOIW3ZIxLXszVPTDwPSgaBNA4lM")//模版id
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
