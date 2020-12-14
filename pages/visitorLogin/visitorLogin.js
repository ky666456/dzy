Page({
  data: {
    phone: '',
    password:''
  },

// 获取输入账号
  phoneInput :function (e) {
    this.setData({
      phone:e.detail.value
    })
  },

// 获取输入密码
  passwordInput :function (e) {
    this.setData({
      password:e.detail.value
    })
  },

// 登录
  login: function () {
    if(this.data.phone.length == 0 ){
      wx.showToast({  
        title: '用户名不应为空',  
        icon: 'loading',  
        duration: 2000  
      })  
}
else if(this.data.password.length == 0){
  wx.showToast({  
    title: '密码不应为空',  
    icon: 'loading',  
    duration: 2000  
  })  
}
else if(this.data.phone.length ==this.data.password.length) {
  wx.switchTab({
    url: '/pages/menu/menu',
  })
      wx.showToast({  
        title: '登录成功',  
        icon: 'success',  
        duration: 2000  
      })  
    }  
    else{
      wx.showToast({  
        title: '登录失败',  
        icon: 'loading',  
        duration: 2000  
      })  
    }
  }
})