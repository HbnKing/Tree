//login.js
//获取应用实例
var app = getApp();
Page({

  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    remind: '加载中',
    angle: 0,
    userInfo: {},
    
  },
  goToIndex: function() {
    wx.switchTab({
      url: '/pages/index/index',
    });
  },
  onLoad: function() {
    var that = this
    wx.setNavigationBarTitle({
      title: wx.getStorageSync('mallName')
    })
  },
  onShow: function() {
    let that = this
    let userInfo = wx.getStorageSync('userInfo')
    if (!userInfo) {
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
          })
        }
      })
    } else {
      that.setData({
        userInfo: userInfo
      })
    }
  },
  onReady: function() {
    var that = this;
    setTimeout(function() {
      that.setData({
        remind: ''
      });
    }, 1000);
    wx.onAccelerometerChange(function(res) {
      var angle = -(res.x * 30).toFixed(1);
      if (angle > 14) {
        angle = 14;
      } else if (angle < -14) {
        angle = -14;
      }
      if (that.data.angle !== angle) {
        that.setData({
          angle: angle
        });
      }
    });
  },

  //  点击后的登录页面 
  bindGetUserInfo(e) {
    console.log(e.detail.userInfo);
    this.doLogin(e);

    //随后跳转页面
    this.goToIndex()
  },

  // 登录   的 方法
  doLogin: function(e) {
    //console.log(e.detail.errMsg)
    //console.log(e.detail.userInfo)
    //console.log(e.detail.rawData)

    wx.login({
      success: function(res) {

        console.log(res.header)
        console.log(res)
        var code = res.code;
        console.log("res.code is :" + code);
        if (code) {

          // 调用后端，获取微信的session_key, secret  需要测试该 data{}  传值方法
          wx.request({
            url: "http://localhost:9010/wxLogin",
            method: "POST",
            data: {
              'code': code
            },
            success: function(result) {
              console.log("result header is :");
              console.log( result.header);
              console.log("sessionid is ",result.header.sessionId)
              var sessionId = result.header.sessionId ;
              // 保存用户信息到本地缓存，可以用作小程序端的拦截器  需要自定义方法保存 
              console.log(result.data);
              console.log("e is :" + e);
              //app.setGlobalUserInfo(e.detail.userInfo);
              //wx.redirectTo({
              //url: '../list/list',
              //})
              //保存 数据  sessionId  

              wx.setStorageSync('sessionId', sessionId);
              app.globalData.sessionId = sessionId;
              console.log(app)
            }
          });
          

        } else {
          console.log('登录失败！' + res.errMsg)
        }
      },
      fail: function(res) {
        console.log(res.errMsg)
      },
      complete: function(res) {

      }
    })
  },




});