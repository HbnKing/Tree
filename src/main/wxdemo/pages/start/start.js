//login.js
//获取应用实例
var app = getApp();
Page({
  
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    remind: '加载中',
    angle: 0,
    userInfo: {}
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
  bindGetUserInfo(e) {
    console.log(e.detail.userInfo);
    this.goToIndex()
  }
});