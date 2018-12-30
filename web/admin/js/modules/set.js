/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["form", "upload","admin"], function(t) {
	
	var i = layui.$,
		e = layui.layer,
		a = (layui.laytpl, layui.setter, layui.view, layui.admin),
		n = layui.form,
		s = layui.upload;
		
	var tableName = layui.data(a.tableName);
	var access_token = tableName.access_token;
		
		
	a.req({
		url: "/sys/sysuser/getUserInfo",
		type: "get",
		data: {},
		done: function(data) {
			i("input[name='username']").val(data.data.userName);
			i("input[name='nickname']").val(data.data.nickname);
			//i("input[name='sex']:checked").val(data.data.sex);
//			i("input[name='sex']:checked").val(1);
			i("input[name=sex][value='"+data.data.sex+"']").attr("checked", data.data.sex == '1' ? true : false);
			//i("input[name='sex'][value='1'").attr('checked','true');
			i("input[name='avatar']").val(data.data.avatar);
			i("input[name='mobile']").val(data.data.mobile);
			i("input[name='email']").val(data.data.email);
			i("input[name='remarks']").val(data.data.remark);
			
		}
	});	
		
	i("body");
	n.verify({
		nickname: function(t, i) {
			return new RegExp("^[a-zA-Z0-9_一-龥\\s·]+$").test(t) ? /(^\_)|(\__)|(\_+$)/.test(t) ? "用户名首尾不能出现下划线'_'" : /^\d+\d+\d$/.test(t) ? "用户名不能全为数字" : void 0 : "用户名不能有特殊字符"
		},
		pass: [/^[\S]{6,12}$/, "密码必须6到12位，且不能出现空格"],
		repass: function(t) {
			if(t !== i("#LAY_password").val()) return "两次密码输入不一致"
		}
	}), n.on("submit(set_website)", function(t) {
		// 修改网站设置
		//return e.msg(JSON.stringify(t.field)), !1
        a.req({
            url: "/sys/syssite/updateSave",
            type: "post",
            data: t.field,
            done: function(data) {
                if(data.result){
                    layer.msg(data.msg,{
                        time: 2000
                    },function(){
                        window.location.reload();
                    });

                }
            }
        });



    }), n.on("submit(set_system_email)", function(t) {
		// 修改邮箱设置
		return e.msg(JSON.stringify(t.field)), !1
	}), n.on("submit(setmyinfo)", function(t) {
		// 修改用户信息
		a.req({
			url: "/sys/sysuser/updateUserInfo",
			type: "post",
			data: t.field,
			done: function(data) {
				if(data.result){
					layer.msg(data.msg,{
						time: 2000
					},function(){
						window.location.reload();
					});
					
				}
			}
		});	
		
		//return e.msg(JSON.stringify(t.field)), !1
	});
	var r = i("#LAY_avatarSrc");
	var logo = i("#logoSrc");
	s.render({
		url: "/file/fileManager/upload",
		elem: "#LAY_avatarUpload",
		done: function(t) {
			r.val(t.url);
//			0 == t.status ? r.val(t.url) : e.msg(t.msg, {
//				icon: 5
//			})
		}
	}), a.events.avartatPreview = function(t) {
		// 查看头像
		var i = r.val();
		e.photos({
			photos: {
				title: "查看头像",
				data: [{
					src: i
				}]
			},
			shade: .01,
			closeBtn: 1,
			anim: 5
		})
	}, n.on("submit(setmypass)", function(t) {
		// 修改密码
		a.req({
			url: "/sys/sysuser/updataUserPassword",
			type: "post",
			data: t.field,
			done: function(data) {
				if(data.result){
					layer.msg(data.msg,{
						time: 2000
					},function(){
						window.location.reload();
					});
					
				}else{
					layer.msg(data.msg, {
					    offset: '15px'
					    ,icon: 2
					  });
				}
			}
		});	
		
		//return e.msg(JSON.stringify(t.field)), !1
	},
	
	s.render({
		url: "/file/fileManager/upload",
		elem: "#logoUpload",
		done: function(t) {
			logo.val(t.url);
//			0 == t.status ? logo.val("http://localhost:8088/"+t.storagePath) : e.msg(t.msg, {
//				icon: 5
//			})
		}
	}),
	a.events.logoPreview = function(t) {
		// 查看logo
		var i = logo.val();
		e.photos({
			photos: {
				title: "查看",
				data: [{
					src: i
				}]
			},
			shade: .01,
			closeBtn: 1,
			anim: 5
		})
	}
	
	), t("set", {})
});