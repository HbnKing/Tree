import {network} from "../../utils/network.js";

Page({
  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // MVC：Model,View,Controller
    var that = this;
    // 电影
    network.getMovieList({
      success: function(movies){
        that.setData({
          movies: movies
        });
      }
    });

    // 电视剧
    network.getTVList({
      success: function(tvs){
        that.setData({
          tvs: tvs
        });
      }
    });

    // 综艺
    network.getShowList({
      success: function (shows) {
        that.setData({
          shows: shows
        });
      }
    });
  }
})