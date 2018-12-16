///** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;

// 附件预览地址
var filePreview = "http://localhost:8190/";


layui.define(function(e) {
	var i = (layui.$, layui.layer, layui.laytpl, layui.setter, layui.view, layui.admin);
	i.events.logout = function() {
		
		
//		var layData = layui.data(layui.setter.tableName);
//		var access_token = layData.request.tokenName;
//		alert(access_token);
		
		i.req({
			url: "sys/sysuser/logout",
			type: "get",
			data: {},
			done: function(e) {
				i.exit(function() {
					location.href = "/login.html"
				})
			}
		})
	}, e("common", {})
});


function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}