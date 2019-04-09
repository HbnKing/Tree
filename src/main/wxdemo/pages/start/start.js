//login.js
//获取应用实例
var app = getApp();
Page({

  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    remind: '加载中',
    angle: 0,
    userInfo: {},
  },

  onLoad: function () {
   
    
  },
  bindGetUserInfo: function (e) {
    console.log(e)
    if (e.detail.userInfo) {
      console.log(e)
      //用户按了允许授权按钮
      var that = this;
      //插入登录的用户的相关信息到数据库
      // 未完成
      // wx.request({
      //   url: app.globalData.urlPath + 'user/add',
      //   data: {
      //     openid: getApp().globalData.openid,
      //     nickName: e.detail.userInfo.nickName,
      //     avatarUrl: e.detail.userInfo.avatarUrl,
      //     province: e.detail.userInfo.province,
      //     city: e.detail.userInfo.city
      //   },
      //   header: {
      //     'content-type': 'application/json'
      //   },
      //   success: function (res) {
      //     //从数据库获取用户信息
      //     that.queryUsreInfo();
      //     console.log("插入小程序登录用户信息成功！");
      //   }
      // });
      //授权成功后，跳转进入小程序首页
      wx.redirectTo({
        url: '/pages/index/index'
      })
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击了“返回授权”')
          }
        }
      })
    }
  },
  //获取用户信息接口
  queryUsreInfo: function () {
    wx.request({
      url: "http://localhost:9010/wxLogin?code="+code,
      method: "POST",
      // data: {
      //  openid: app.globalData.openid
      // },
      header: {
        'content-type': 'application/json'
      },
      success: function (res) {
        console.log(res.data);
        getApp().globalData.userInfo = res.data;
      }
    });
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
        
        if (code) {
          

          // 调用后端，获取微信的session_key, secret  需要测试该 data{}  传值方法
          wx.request({
            url: "http://localhost:9010/wxLogin?code="+code,
            method: "POST",
            //data: {
            //  'code': code},
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
              console.log(app);
              wx.redirectTo({
                url: '/pages/index/index',
              });
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