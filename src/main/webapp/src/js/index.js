// 轮播图
function Banner(){
    // 轮播图
    this.bannerGroup = $("#banner-group");
    this.bannerUl = $('#banner-ul');
    this.liList = this.bannerUl.children('li');
    // 轮播图宽度
    this.bannerWidth = 748;
    // 轮播图数量
    this.bannerCount = this.liList.length;
    // 轮播图片索引
    this.index = 1;
    // 箭头
    this.arrow = $('.arrow');
    this.leftArrow = $('.left-arrow');
    this.rightArrow = $('.right-arrow');
    // 小圆点
    this.pageControl = $('.page-control')
}

// 初始化轮播图
Banner.prototype.initBannerUl = function(){
    var firstLi = this.liList.eq(0).clone()
    var lastLi = this.liList.eq(this.bannerCount-1).clone()
    this.bannerUl.prepend(lastLi);
    this.bannerUl.append(firstLi);
    this.bannerUl.css({'width': this.bannerWidth * (this.bannerCount + 2)});
    this.bannerUl.css({'left': -this.bannerWidth});
};

// 初始化小圆点
Banner.prototype.initPageControl = function(){
    for(var i=0;i<this.bannerCount;i++){
        var circle = $('<li></li>');
        this.pageControl.append(circle);
        if(i === 0){
            circle.addClass('active');
        }
    }
    this.pageControl.css({'width':(12+16)*this.bannerCount})
    this.pageControlLi = this.pageControl.children('li')
};

// 鼠标悬停在banner上
Banner.prototype.listenBannerHover = function(){
    var self = this;
    this.bannerGroup.hover(
        function(){
            // 鼠标移动到banner上执行的函数
            clearInterval(self.timer);
            self.arrow.fadeIn(400)
        },
        function(){
            // 鼠标移出banner执行的函数
            self.loop()
            self.arrow.fadeOut(400)
        }
    );
}

// 鼠标点击箭头监听
Banner.prototype.listenArrowClick = function(){
    var self = this;
    // 点击左侧按钮时右移
    this.leftArrow.click(function(){
        self.rightShift();
    });
    // 点击右侧按钮时左移
    this.rightArrow.click(function(){
        self.leftShift();
    })
};

// 轮播图左移
Banner.prototype.leftShift = function(){
    if(this.index >= this.bannerCount + 1){
        this.bannerUl.css({'left':-this.bannerWidth})
        this.index = 2;
    } else{
        this.index++;
    }
    this.animate();
}

// 轮播图右移
Banner.prototype.rightShift = function() {
    if(this.index === 0){
        this.bannerUl.css({'left':-this.bannerWidth*(this.bannerCount)})
        this.index = this.bannerCount - 1;
    } else{
        this.index--;
    }
    this.animate();
}

// 轮播图移动
Banner.prototype.animate = function(){
    // 小圆点
    var index = 0;
    if(this.index === 0){
        index = this.bannerCount-1;
    } else if(this.index === this.bannerCount + 1){
        index = 0;
    } else{
        index = this.index - 1
    }
    this.pageControlLi.eq(index).addClass('active').siblings().removeClass('active');
    // 轮播图
    this.bannerUl.stop().animate({'left':-748*this.index},500);
};

// 鼠标点击小圆点监听
Banner.prototype.listenPageControlClick = function(){
    var self = this
    this.pageControlLi.each(function(index, obj){
        $(obj).click(function(){
            self.index = index;
            self.animate();
        });
    });
};

// 执行轮播
Banner.prototype.loop = function (){
    var self = this;
    this.timer = setInterval(function(){
        self.leftShift();
    },2000);
}

// 开启轮播
Banner.prototype.run = function (){
    // 初始化
    this.initBannerUl();
    this.initPageControl();
    // 开启轮播
    this.loop()
    // 监听事件
    this.listenBannerHover();
    this.listenArrowClick();
    this.listenPageControlClick();
}

$(function(){
    var banner = new Banner();
    banner.run();
});