/**
 * 商品管理 - 编辑页面  js
 */

layui.config({
    base: '../../../js/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'admin', 'form', 'upload','layedit'], function () {
    /** 插件 **/
    var $ = layui.$
        , form = layui.form
        , admin = layui.admin
        , upload = layui.upload
        , layedit = layui.layedit;
    /** 插件end **/

    /** 页面加载 **/
    var id = getQueryString("id");

    if (id != null) {

        admin.req({
            url: "/sys/productInfo/init",
            type: "get",
            data: {id: id},
            done: function (data) {

                //表单初始赋值
                form.val('layuiadmin-form-list', {
                    					"id" : data.data.id ,// 主键ID 
 					"code" : data.data.code ,// 商品编号 
 					"name" : data.data.name ,// 商品名称 
 					"keywords" : data.data.keywords ,// 商品关键字 
 					"model" : data.data.model ,// 商品型号 
 					"typeId" : data.data.typeId ,// 商品类型id 
 					"price" : data.data.price ,// 商品价格 
 					"parame" : data.data.parame ,// 商品参数 
 					"description" : data.data.description ,// 商品描述 
 					"isHot" : data.data.isHot ,// 是否推荐商品（1：推荐） 
 					"image" : data.data.image ,// 商品图片 
 					"unit" : data.data.unit ,// 单位 
 					"barCode" : data.data.barCode ,// 商品条形码 
 					"stockCount" : data.data.stockCount ,// 商品库存数量 
 					"sort" : data.data.sort ,// 商品排序 
 					"status1" : data.data.status1 ,// 状态（0：待发布，1：正常） 
 					"remark" : data.data.remark ,// 备注 
 					"createBy" : data.data.createBy ,// 创建人id 
 					"createTime" : data.data.createTime ,// 创建时间 
 					"updateBy" : data.data.updateBy ,// 修改人id 
 					"updateTime" : data.data.updateTime ,// 修改时间 
 
                    "status1" : data.data.status1 == 1 ? true : false //开关状态
                })
            }
        });
    }
    /** 页面加载end **/


    /** 监听提交 **/
    form.on('submit(layuiadmin-form-submit)', function (data) {

        if (data.field.status1 == "on") {
            data.field.status1 = "1"
        } else {
            data.field.status1 = "0"
        }

        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引

        //修改
        data.field.id = id;
        var field = data.field; //获取提交的字段
        //console.log(field);
        admin.req({
            url: "/sys/productInfo/updateSave",
            type: "post",
            data: field,
            done: function (data) {
                parent.layui.table.reload('LAY-list'); //重载表格
                parent.layer.close(index); //再执行关闭
            }
        });

    })
    /** 监听提交end **/
   
   	/** 图片上传 **/
   	var imageSrc = $("#imageSrc");
 	upload.render({
		url: "/file/fileManager/upload",
		elem: "#productUpload",
		done: function(t) {
			imageSrc.val(t.url);
		}
	}), admin.events.productPreview = function(t) {
		// 查看图片
		var i = imageSrc.val();
		layer.photos({
			photos: {
				title: "查看图片",
				data: [{
					src: i
				}]
			},
			shade: .01,
			closeBtn: 1,
			anim: 5
		})
	}
  
  	/** 图片上传end **/
   
   	/** 富文本编辑器 **/
  		// 编辑器上传接口
		layedit.set({
		  uploadImage: {
		    url: '/file/fileManager/upload2' 
		    ,type: 'post' 
		  }
		});
		
		
		//商品描述编辑器
  		var description = layedit.build('description',{
  			height: 180,
  			tool: ['face','image','strong', 'italic', 'underline','del', '|', 'left','center','right','link','unlink','|','code' ],
  		});
		
  	/** 富文本编辑器end **/


});