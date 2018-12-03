layui.define(["form", "upload","jquery"], function(t) {

    var $ = layui.jquery;

    $.ajax({
        url:"/index/syssite/findById",
        type:"get",
        async:true,
        data: {id:1},
        success : function(data) {

            $(document).attr("title",data.data.title);//修改title值
            // $(document).attr("keywords",data.data.keywords);//修改keywords值
            // $(document).attr("description",data.data.description);//修改description值

            var metas = document.getElementsByTagName("meta");
            metas[0].name ="keywords";
            metas[0].content=data.data.keywords;
            metas[1].name ="description";
            metas[1].content=data.data.description;

            $("#logo").attr("src",data.data.logo);

            $("#copyright").text(data.data.copyright);
            $("#beian").text(data.data.beian);
        }
    });




});


/**
 * 点击微信弹出
 */
function wxClick(){
	
	layui.use("layer",function(){
		
		var layer = layui.layer;  //layer初始化
		
		//示范一个公告层
		layer.open({
		  type: 1
		  ,title: false //不显示标题栏
		  ,closeBtn: true
		  ,area: '220px;'
		  ,shade: 0.8
		  ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		  ,resize: false
		  //,btn: ['火速围观', '残忍拒绝']
		  ,btnAlign: 'c'
		  ,moveType: 1 //拖拽模式，0或者1
		  ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><img src="res/static/images/home/erweima.jpg"/></div>'
		  ,success: function(layero){
		    var btn = layero.find('.layui-layer-btn');
		    btn.find('.layui-layer-btn0').attr({
		      href: 'http://www.layui.com/'
		      ,target: '_blank'
		    });
		  }
		});
	
	})
}

