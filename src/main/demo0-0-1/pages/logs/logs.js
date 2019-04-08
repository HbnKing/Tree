

const app = getApp()
Page({
  data: {
    listData:[{
      name:"名古屋",
      day:"4/29 (月)",
      live:"ライブ予定"
    },
      {
        name: "名古屋",
        day: "4/30［火祝］ "  ,
        live: "RADHALLワンマン"
      },
      {
        name: "名古屋",
        day: "5/01 (水)",
        live: "ダイヤモンドホール"
      },
      {
        name: "名古屋",
        day: "5/02 (木)",
        live: "ライブ予定"
      },
      {
        name: "東京",
        day: "5/05 (日)",
        live: "「AKASAKA ストリーマーズ」"
      }





    ],
    // listData: [
    //   '4月29日 名古屋',
    //   '4月30日 名古屋',
    //   '5月1日 名古屋',
    //   '5月2日 名古屋',
    //   '5月5日 AKASAKAストリーアーズ',
    //   '5月6日 東京'
    // ],
    // listDatas:[
    //   ' 名古屋',
    //   ' 名古屋',
    //   ' 名古屋',
    //   ' 名古屋'

    // ],
    // activeIndex: -1,
    // list_style: '',
    // startX: 0,
 
  },

  onLoad:function(options){
    this.setData({
      "listData.name":"123456"
    })
  },

  onLoad() {
    let rate = 750 / wx.getSystemInfoSync().screenWidth
    this.setData({
      rate: rate
    })
  },
  update:function(){
    console.log('qqq')
  },
  touchstart: function (e) {
    let startX = e.touches[0].clientX
    this.setData({
      startX: startX
    })
  },
  touchmove: function (e) {
    let moveX = e.touches[0].clientX
    let dis = (this.data.startX - moveX) * this.data.rate // 换算成rpx
    let activeIndex = e.currentTarget.dataset.index
    let left = 240
    if (dis <= 0) {
      left = 240
    } else if (dis >= 240) {
      left = 0
    } else {
      left = 240 - dis
    }
    this.setData({
      list_style: 'transform:translateX(' + left + 'rpx)',
      activeIndex: activeIndex
    })
  },
  touchend: function (e) {
    let endX = e.changedTouches[0].clientX
    let dis = (this.data.startX - endX) * this.data.rate
    let activeIndex = e.currentTarget.dataset.index
    let left = 0
    if (dis >= 200) {
      left = 0
    } else {
      left = 240
    }
    this.setData({
      activeIndex: activeIndex,
      list_style: 'transform:translateX(' + left + 'rpx)'
    })
  },
  delete: function () {
    this.data.listData.splice(this.data.activeIndex, 1)
  
    this.setData({
      listData: this.data.listData
    })
   
  }
})