Component({
  
  pageLifetimes: {
    
    show() {
      console.log(".....")
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 1
        })
      }
    }
  }
})
