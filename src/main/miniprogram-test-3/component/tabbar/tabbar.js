Page({
  data: {
    curIdx: 0,
    listInfo: [
      {
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
    ]
  },
  chooseImg: function (e) {
    this.setData({
      curIdx: e.currentTarget.dataset.current
    })
    //  console.log(e)
    console.log(this.data.curIdx)
    if (this.data.curIdx == 0) {
      wx.navigateTo({
        url: '../main/main',
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
  }
})
