/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["setter", "admin"], function(a) {
	var n = layui.admin;
	
	// 此方法只检测是否登录
	n.req({
		url: "/sys/sysuser/testLogin",
		type: "get",
		data: {},
		done: function(e) {
			//alert(e);
		}
	});
});