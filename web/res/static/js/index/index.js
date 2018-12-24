layui.use(['carousel', 'jquery', 'element'], function() {
	var carousel = layui.carousel,
		$ = layui.$;
		
		
	

	$(function() {
		
		$.ajax({
			url: "/index/carouselinfo/list",
			type: "get",
			async: true,
			data: {groupId:1},
			success: function(data) {

				var array = data.data;
				$.each(array, function(i, v) {
					$(".imgH:parent").append('<div><img style="width: 100%" src="' + v.src + '"></div>');
				});

				//建造实例
				carousel.render({
					elem: '#test1',
					width: '100%' //设置容器宽度
						,
					arrow: 'always',
					height: 'auto'
					//,anim: 'updown' //切换动画方式
				});
				$('.app-header-menuicon').on('click', function() {
					$('.header-down-nav').toggleClass('down-nav')
				})
				var imgH = $('.imgbox div.layui-this').outerHeight();
				$('.imgH').css('height', imgH + 'px')
				window.onresize = function() {
					var imgH = $('.imgbox div.layui-this').outerHeight();
					$('.imgH').css('height', imgH + 'px')
				};
			}
		});
		
		//carouselData2();
		
		
	});
	carousel.render({
		elem: '#test1',
		width: '100%' //设置容器宽度
			,
		arrow: 'always',
		height: 'auto'
		//,anim: 'updown' //切换动画方式
	});
	$('.app-header-menuicon').on('click', function() {
		$('.header-down-nav').toggleClass('down-nav')
	})
	var imgH = $('.imgbox div.layui-this').outerHeight();
	$('.imgH').css('height', imgH + 'px')
	window.onresize = function() {
		var imgH = $('.imgbox div.layui-this').outerHeight();
		$('.imgH').css('height', imgH + 'px')
	};
	
	
	function carouselData2() {

		$.ajax({
			url: "/index/carouselinfo/list",
			type: "get",
			async: true,
			data: {groupId:2},
			success: function(data) {
				
				$.each(data.data, function(i,v) {
					var dd = '<div class="layui-col-xs6 layui-col-sm6 layui-col-md3">'+
							'<div class="img-txt">'+
							'<img style="width: 100%;" src="'+ v.src +'" alt="">'+
							'<h3>'+v.name+'</h3>'+
							'</div>'+
							'</div>';
					$("#image-products2:parent").append(dd);
					
				});
				
			}
		});
	}
	
	
	
});

