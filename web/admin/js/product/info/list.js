/**
 * 商品管理 - 列表页面  js
 */
layui.config({
    base: '../../../js/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'admin', 'table', 'form', 'laydate'], function () {
    /** 插件 **/
    var $ = layui.$
        , form = layui.form
        , table = layui.table
        , laydate = layui.laydate
        , admin = layui.admin;
    /** 插件end **/

    /** 时间插件 **/
    laydate.render({
        elem: '#time1'
    });
    /** 时间插件end **/

    /** 监听搜索 **/
    form.on('submit(LAY-search)', function (data) {
        var field = data.field;
        //执行重载
        table.reload('LAY-list', {
            where: field
        });
    });
    /** 监听搜索end **/


    /** 绑定回车事件 **/
    $(document).on('keydown', function (e) {  //document为当前元素，限制范围，如果不限制的话会一直有事件
        if (e.keyCode == 13) {
            //监听搜索
            //console.log(form);
            var field = form.field;
            //执行重载
            table.reload('LAY-list', {
                where: field
            });
        }
    })
    /** 绑定回车事件end **/


    /** 加载数据 **/
    table.render({
        elem: "#LAY-list",
        url: "/sys/productInfo/list",
        cols: [
            [
                {type: "checkbox", fixed: "left"},
                // { field: "id", width: 100, title: "主键ID" },

				{ field: "code", width: 100, title: "商品编号" },
				{ field: "name", width: 100, title: "商品名称" },
				{ field: "keywords", width: 100, title: "商品关键字" },
				{ field: "model", width: 100, title: "商品型号" },
				{ field: "typeId", width: 100, title: "商品类型id" },
                { templet: "#imageP", width: 100, title: "商品图片"  },
				// { field: "price", width: 100, title: "商品价格" },
				// { field: "parame", width: 100, title: "商品参数" },
				// { field: "description", width: 100, title: "商品描述" },
				{ templet:"#isHotC", width: 100, title: "推荐商品" },
				{ field: "unit", width: 100, title: "单位" },
				{ field: "stockCount", width: 100, title: "商品库存数量" },
				{ field: "sort", width: 100, title: "商品排序", sort: !0 },

                {field: "status1", title: "状态", templet: "#buttonTpl", width: 80, align: "center"},
                {title: "操作", minWidth: 150, align: "center", fixed: "right", toolbar: "#table-operation-list"}
            ]
        ],
        page: !0,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: "对不起，加载出现异常！"
    })
    /** 加载数据end **/


    /** 表单操作 **/
    var active = {
        batchdel: function () {
            var checkStatus = table.checkStatus('LAY-list')
                , checkData = checkStatus.data; //得到选中的数据

            if (checkData.length === 0) {
                return layer.msg('请选择数据');
            }

            layer.confirm('确定删除吗？', function (index) {
                var ids = "";
                $.each(checkData, function (e, v) {
                    ids += v.id + " ";
                });
                //执行 Ajax 后重载
                admin.req({
                    url: "/sys/productInfo/deleteByIds",
                    type: "post",
                    data: {ids: ids},
                    done: function (e) {
                        table.reload('LAY-list'); //重载表格
                        layer.close(index); //再执行关闭
                        layer.msg('已删除');
                    }
                });
            });
        },
        add: function () {
            layer.open({
                type: 2
                , title: '商品管理 - 新增页面 '
                , content: 'add.html'
                , maxmin: true
                , area: ['80%', '80%']
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    //点击确认触发 iframe 内容中的按钮提交
                    var submit = layero.find('iframe').contents().find("#layuiadmin-form-submit");
                    submit.click();
                }
            });
        }
    };
    $('.layui-btn.layuiadmin-btn-list').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    /** 表单操作end **/


    /** 表格操作 **/
    table.on("tool(LAY-list)", function (t) {

        var i = t.data;
        if ("del" === t.event) layer.confirm("确定删除此信息？", function (e) {
            // 表格删除
            //t.del(), layer.close(e)
            admin.req({
                url: "/sys/productInfo/deleteById",
                type: "post",
                data: {id: i.id},
                done: function (data) {
                    layui.table.reload('LAY-list'); //重载表格
                    layer.close(e); //再执行关闭
                }
            });
        });
        else if ("edit" === t.event) {
            // 表格编辑
            $(t.tr);
            layer.open({
                type: 2,
                title: "商品管理 - 编辑页面 ",
                content: "edit.html?id=" + i.id,
                maxmin: true,
                area: ["80%", "80%"],
                btn: ["确定", "取消"],
                yes: function (e, i) {
                    var submit = i.find('iframe').contents().find("#layuiadmin-form-submit");
                    submit.click();
                },
                success: function (t, e) {
//					var n = t.find("iframe").contents().find("#layuiadmin-app-form-tags").click();
//					n.find('input[name="tags"]').val(i.tags)
                }
            })
        }
    });
    /** 表格操作end **/

});