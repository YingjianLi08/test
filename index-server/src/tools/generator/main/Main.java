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
		config.tableName="product_info";

		//类描述
		config.description="商品信息";

		//包路径
		config.packageUrl="com.zmyjn.product.info";

		//类名称
		config.className="ProductInfo";



		config.controllerFlag = YES;
		config.serviceFlag = YES;
		config.entityFlag = YES;
		config.mapperDaoFlag = YES;
		config.mapperXmlFlag = YES;



		config.testFlag=NO;
		config.outFlag = NO;
		//计算其它参数
		config.refreshConfig();

		Generator generator = Generator.getInstance(config);
		generator.createCode();

	}
}