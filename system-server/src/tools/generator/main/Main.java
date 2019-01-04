package main;
import common.Generator;
import common.GeneratorConfig;

/**
 * 代码生成器
 * @author huangga
 *
 */
public class Main {
	
	static String YES = "1";
	static String NO = "0";

	public static void main(String[] args) throws Exception {


		GeneratorConfig config = new GeneratorConfig();
		//数据表名
		config.tableName="sys_test";

		//类描述
		config.description="测试";

		//包路径
		config.packageUrl="com.zmyjn.sys.test";

		//类名称
		config.className="SysTest";

		config.requestPrefix = "sys";// 请求链接前缀
		config.listHtmlTitle = "测试管理 - 列表页面 ";
		config.addHtmlTitle = "测试管理 - 新增页面 ";
		config.editHtmlTitle = "测试管理 - 编辑页面 ";

		config.controllerFlag = YES;
		config.serviceFlag = YES;
		config.entityFlag = YES;
		config.mapperDaoFlag = YES;
		config.mapperXmlFlag = YES;
		config.htmlFlag = YES;



		config.testFlag=NO;
		config.outFlag = NO;
		//计算其它参数
		config.refreshConfig();

		Generator generator = Generator.getInstance(config);
		generator.createCode();

	}
}