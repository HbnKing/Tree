//index.js
//获取应用实例
var app = getApp()
var tabbar = require('../../component/navbar/navbar.js');


Page({
  data: {
    curIdx: 0,
    listInfo: [{
        imgUrl: '../../images/a.jpg',
        curUrl: '../../images/a.jpg',
      },
      {
        imgUrl: '../../images/a.jpg',
        curUrl: '../../images/a.jpg',
      },
      {
        imgUrl: '../../images/a.jpg',
        curUrl: '../../images/a.jpg',
      },
    ],
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')

  },
  chooseImg: function(e) {
    this.setData({
      curIdx: e.currentTarget.dataset.current
    })
    //  console.log(e)
    console.log(this.data.curIdx)
    if (this.data.curIdx == 0) {
      wx.navigateTo({
        url: '../../main/main',
      })
    } else if (this.data.curIdx == 1) {
      wx.navigateTo({
        url: '../AR/AR',
      })
    } else {
      wx.navigateTo({
        url: '../mailer/mailer',
      })
    }
  },


  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../wxlogin/wxlogin'
    })
  },
  onLoad: function() {
    app.editTabBar2();
    console.log("try  edit tabbar")
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})