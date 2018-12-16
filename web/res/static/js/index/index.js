layui.use(['carousel','jquery','element'],function(){
    var carousel = layui.carousel,$ = layui.$;
    
    $(function(){
			$.ajax({
				url:"/index/carouselinfo/list",
				// url:"/sys/carouselinfo/list",
				type:"get",
				async:true,
				data: {},
				success : function(data) {
					
					var array = data.data;
					$.each(array, function(i,v) {
						$(".imgH:parent").append('<div><img style="width: 100%" src="'+v.src+'"></div>');
					});
					
					//建造实例
                  carousel.render({
                    elem: '#test1'
                    ,width: '100%' //设置容器宽度
                    ,arrow: 'always'
                    ,height:'auto'
                    //,anim: 'updown' //切换动画方式
                  });
                  $('.app-header-menuicon').on('click',function(){
                    $('.header-down-nav').toggleClass('down-nav')
                  })
                  var imgH = $('.imgbox div.layui-this').outerHeight();
                  $('.imgH').css('height',imgH+'px')
                  window.onresize = function () {
                    var imgH = $('.imgbox div.layui-this').outerHeight();
                    $('.imgH').css('height',imgH+'px')
                  };
				}
			});
		});
              carousel.render({
                elem: '#test1'
                ,width: '100%' //设置容器宽度
                ,arrow: 'always'
                ,height:'auto'
                //,anim: 'updown' //切换动画方式
              });
              $('.app-header-menuicon').on('click',function(){
                $('.header-down-nav').toggleClass('down-nav')
              })
              var imgH = $('.imgbox div.layui-this').outerHeight();
              $('.imgH').css('height',imgH+'px')
              window.onresize = function () {
                var imgH = $('.imgbox div.layui-this').outerHeight();
                $('.imgH').css('height',imgH+'px')
              };
  });