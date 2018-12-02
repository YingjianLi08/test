/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(["laytpl", "layer"], function(e) {
	var t = layui.jquery,
		a = layui.laytpl,
		n = layui.layer,
		r = layui.setter,
		o = (layui.device(), layui.hint()),
		i = function(e) {
			return new d(e)
		},
		s = "LAY_app_body",
		d = function(e) {
			this.id = e, this.container = t("#" + (e || s))
		};
	i.loading = function(e) {
		e.append(this.elemLoad = t('<i class="layui-anim layui-anim-rotate layui-anim-loop layui-icon layui-icon-loading layadmin-loading"></i>'))
	}, i.removeLoad = function() {
		this.elemLoad && this.elemLoad.remove()
	}, i.exit = function(e) {
		layui.data(r.tableName, {
			key: r.request.tokenName,
			remove: !0
		}), e && e()
	}, i.req = function(e) {
		var a = e.success,
			n = (e.error, r.request),
			o = r.response,
			s = function() {
				return r.debug ? "<br><cite>URL：</cite>" + e.url : ""
			};
		if(e.data = e.data || {}, e.headers = e.headers || {}, n.tokenName) {
			var d = "string" == typeof e.data ? JSON.parse(e.data) : e.data;
			e.data[n.tokenName] = n.tokenName in d ? e.data[n.tokenName] : layui.data(r.tableName)[n.tokenName] || "", e.headers[n.tokenName] = n.tokenName in e.headers ? e.headers[n.tokenName] : layui.data(r.tableName)[n.tokenName] || ""
		}
		return delete e.success, delete e.error, t.ajax(t.extend({
			type: "get",
			dataType: "json",
			success: function(t) {
				var n = o.statusCode;
				if(t[o.statusName] == n.ok) "function" == typeof e.done && e.done(t);
				else if(t[o.statusName] == n.logout) i.exit();
				else {
					var r = ["<cite>Error：</cite> " + (t[o.msgName] || "返回状态码异常"), s()].join("");
					i.error(r)
				}
				"function" == typeof a && a(t)
			},
			error: function(e, t) {
//				var a = ["请求异常，请重试<br><cite>错误信息：</cite>" + t, s()].join("");
//				i.error(a), "function" == typeof a && a(res)
//				alert("请求异常，请重试或重新登录");
				var data = e.responseJSON;
				if(!data.result){
//					layer.popup({
//				        content: '单页面专业版默认未开启“多标签”功能，实际运用时，你可以自定义是否开启'
//				        ,area: '300px'
//				        ,btnAlign: 'c'
//				        ,shade: false
//				      });
					
				layer.open({
			        type: 1,
			        skin: 'layui-layer-admin',
			        closeBtn: false,
			        area: '350px',
			        anim: 5,
			        shadeClose: true,
//			        content: '<div style="padding:20px;">即传入skin:"样式名"，然后你就可以为所欲为了。你怎么样给她整容都行</div>',
					content: '请求异常，请重试或重新登录',
			        btn:['刷新','登录'],
			        yes:function(){
			        	window.location.reload();
			        },
			        btn2:function(){
			        	window.location.href = "/admin/login.html";
			        }
			      });
				}
//				console.log(e.responseJSON);
//				console.log(data.result);
//				console.log(data.msg);
				
			}
		}, e))
	}, i.popup = function(e) {
		var a = e.success,
			r = e.skin;
		return delete e.success, delete e.skin, n.open(t.extend({
			type: 1,
			title: "提示",
			content: "",
			id: "LAY-system-view-popup",
			skin: "layui-layer-admin" + (r ? " " + r : ""),
			shadeClose: !0,
			closeBtn: !1,
			success: function(e, r) {
				var o = t('<i class="layui-icon" close>&#x1006;</i>');
				e.append(o), o.on("click", function() {
					n.close(r)
				}), "function" == typeof a && a.apply(this, arguments)
			}
		}, e))
	}, i.error = function(e, a) {
		return i.popup(t.extend({
			content: e,
			maxWidth: 300,
			offset: "t",
			anim: 6,
			id: "LAY_adminError"
		}, a))
	}, d.prototype.render = function(e, a) {
		var n = this;
		layui.router();
		return e = r.views + e + r.engine, t("#" + s).children(".layadmin-loading").remove(), i.loading(n.container), t.ajax({
			url: e,
			type: "get",
			dataType: "html",
			data: {
				v: layui.cache.version
			},
			success: function(e) {
				e = "<div>" + e + "</div>";
				var r = t(e).find("title"),
					o = r.text() || (e.match(/\<title\>([\s\S]*)\<\/title>/) || [])[1],
					s = {
						title: o,
						body: e
					};
				r.remove(), n.params = a || {}, n.then && (n.then(s), delete n.then), n.parse(e), i.removeLoad(), n.done && (n.done(s), delete n.done)
			},
			error: function(e) {
				return i.removeLoad(), n.render.isError ? i.error("请求视图文件异常，状态：" + e.status) : (404 === e.status ? n.render("template/tips/404") : n.render("template/tips/error"), void(n.render.isError = !0))
			}
		}), n
	}, d.prototype.parse = function(e, n, r) {
		var s = this,
			d = "object" == typeof e,
			l = d ? e : t(e),
			u = d ? e : l.find("*[template]"),
			c = function(e) {
				var n = a(e.dataElem.html()),
					o = t.extend({
						params: p.params
					}, e.res);
				e.dataElem.after(n.render(o)), "function" == typeof r && r();
				try {
					e.done && new Function("d", e.done)(o)
				} catch(i) {
					console.error(e.dataElem[0], "\n存在错误回调脚本\n\n", i)
				}
			},
			p = layui.router();
		l.find("title").remove(), s.container[n ? "after" : "html"](l.children()), p.params = s.params || {};
		for(var y = u.length; y > 0; y--) ! function() {
			var e = u.eq(y - 1),
				t = e.attr("lay-done") || e.attr("lay-then"),
				n = a(e.attr("lay-url") || "").render(p),
				r = a(e.attr("lay-data") || "").render(p),
				s = a(e.attr("lay-headers") || "").render(p);
			try {
				r = new Function("return " + r + ";")()
			} catch(d) {
				o.error("lay-data: " + d.message), r = {}
			}
			try {
				s = new Function("return " + s + ";")()
			} catch(d) {
				o.error("lay-headers: " + d.message), s = s || {}
			}
			n ? i.req({
				type: e.attr("lay-type") || "get",
				url: n,
				data: r,
				dataType: "json",
				headers: s,
				success: function(a) {
					c({
						dataElem: e,
						res: a,
						done: t
					})
				}
			}) : c({
				dataElem: e,
				done: t
			})
		}();
		return s
	}, d.prototype.autoRender = function(e, a) {
		var n = this;
		t(e || "body").find("*[template]").each(function(e, a) {
			var r = t(this);
			n.container = r, n.parse(r, "refresh")
		})
	}, d.prototype.send = function(e, t) {
		var n = a(e || this.container.html()).render(t || {});
		return this.container.html(n), this
	}, d.prototype.refresh = function(e) {
		var t = this,
			a = t.container.next(),
			n = a.attr("lay-templateid");
		return t.id != n ? t : (t.parse(t.container, "refresh", function() {
			t.container.siblings('[lay-templateid="' + t.id + '"]:last').remove(), "function" == typeof e && e()
		}), t)
	}, d.prototype.then = function(e) {
		return this.then = e, this
	}, d.prototype.done = function(e) {
		return this.done = e, this
	}, e("view", i)
});