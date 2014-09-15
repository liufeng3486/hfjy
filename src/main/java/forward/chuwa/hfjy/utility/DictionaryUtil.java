package forward.chuwa.hfjy.utility;

import java.util.Map;
import java.util.TreeMap;

public class DictionaryUtil {
	public static final String DT_PANEL_TYPE = "panel_type"; // 控制面板类型
	
	public static final String DT_RELATION_TYPE = "relation_type"; // 附件关联类型
			
	public static final String RELATION_TYPE1 = "01"; // 员工档案
	
	public static final String RELATION_TYPE2 = "02"; // 任务项目

	public static final String RELATION_TYPE3 = "03"; // 任务操作
	
	public static final String RELATION_TYPE4 = "04"; // 模板
	
	public static final String RELATION_TYPE5 = "05"; // 即时通-消息附件
	
	public static final String RELATION_TYPE6 = "06"; // 流程附件
	
	public static final String RELATION_TYPE7 = "07"; // 产品照片附件
	
	public static final String RELATION_TYPE8 = "08"; // 采购模块
	
	public static final String RELATION_TYPE9 = "09"; // 备注附件
	
	public static final String RELATION_TYPE10 = "10"; // 消息附件
	
	public static final String RELATION_TYPE11 = "11"; // 消息表 - 关联消息
	
	public static final String RELATION_TYPE12 = "12"; // 产品展示库

	public static final String RELATION_TYPE13 = "13"; // 产品展示库轮播图
	
	public static final String RELATION_TYPE14 = "14"; // 产品展示库套餐模版图
	
	public static final String ACHIVE_TYPE1 = "01"; // 照片

	public static final String ACHIVE_TYPE2 = "02"; // 身份证

	public static final String ACHIVE_TYPE3 = "03"; // 学历证书

	public static final String ACHIVE_TYPE4 = "04"; // 专业证书
	
	public static final String ACHIVE_TYPE5 = "05"; // 入职申请表
	
	public static final String ACHIVE_TYPE6 = "06"; // 劳动协议

	public static final String ACHIVE_TYPE7 = "07"; // 保密协议
	
	public static final String ACHIVE_TYPE8 = "08"; // 销售协议
	
	public static final Map<String, String> ACHIVE_TYPES;
	
	public static final String DT_PROJECT_TYPE = "project_type"; // 项目类型

	public static final String PROJECT_TYPE1 = "01"; // 项目

	public static final String PROJECT_TYPE2 = "02"; // 任务

	public static final String PROJECT_TYPE3 = "03"; // 请示

	public static final String PROJECT_TYPE4 = "04"; // 协助
	
	public static final String PROJECT_TYPE5 = "05"; // 周期项目

	public static final String PROJECT_TYPE6 = "06"; // 周期任务

	public static final String DT_PROJECT_STATE = "project_state"; // 项目状态
	
	public static final String PROJECT_STATE1 = "01"; // 未发送

	public static final String PROJECT_STATE2 = "02"; // 已发送

	public static final String PROJECT_STATE3 = "03"; // 已完成
	
	public static final String PROJECT_STATE4 = "04"; // 已取消
	
	public static final String PROJECT_STATE5 = "05"; // 编辑中

	public static final String PROJECT_STATE6 = "06"; // 已删除
	
	public static final String PROJECT_STATE7 = "07"; // 项目代笔中   
	
	public static final String PROJECT_STATE8 = "08"; // 项目审核中
	
	public static final String PROJECT_STATE9 = "09"; // 撤回

	public static final String DT_PROJECT_HISTORY_TYPE = "project_history_type"; // 项目操作类型
	
	public static final String PROJECT_HISTORY_TYPE1 = "01"; // 回复意见

	public static final String PROJECT_HISTORY_TYPE2 = "02"; // 申请验收

	public static final String PROJECT_HISTORY_TYPE3 = "03"; // 申请延期

	public static final String PROJECT_HISTORY_TYPE4 = "04"; // 同意验收

	public static final String PROJECT_HISTORY_TYPE5 = "05"; // 同意延期

	public static final String PROJECT_HISTORY_TYPE6 = "06"; // 退回调整

	public static final String PROJECT_HISTORY_TYPE7 = "07"; // 取消任务
	
	public static final String DT_PROJECT_HISTORY_STATE = "project_history_state"; // 项目操作状态
	
	public static final String PROJECT_HISTORY_STATE1 = "01"; // 未发送
	
	public static final String PROJECT_HISTORY_STATE2 = "02"; // 已发送

	public static final String PROJECT_HISTORY_STATE3 = "03"; // 已处理
	
	public static final String DT_PROJECT_CUSTOM_TYPE = "project_custom_type"; // 项目自定义类型
	
	public static final String DT_IMPORTANCE_TYPE = "importance_type"; // 重要性
	public static final String PROJECT_IMPORTANCE_TYPE = "importance_type";//项目重要性
	
	public static final String DT_MESSAGE_ENCRYPTION = "message_encryption";//消息是否加密
	
	public static final String DT_EXPIRE_DATE = "expire_date"; // 到期时间
	
	public static final String DT_CREATE_DATE = "create_date"; // 创建时间
	
	
	/***************通用状态***************/
	
	public static final String STATE_DELETE = "00"; // 已删除

	public static final String STATE_NORMAL = "01"; // 正常 
	
	
	
	/******************模板****************/
	public static final String DT_PROJECT_TEMPLATE_STATE = "template_state"; // 模板状态
	
	public static final String PROJECT_TEMPLATE_STATE1 = "01"; // 保存为模板

	public static final String PROJECT_TEMPLATE_STATE2 = "02"; // 已删除
	

	/*******分组类型标记********/
	
	public static final String GROUP_DATE = "01"; // 根据日期分类
	
	public static final String GROUP_USERID = "02"; // 根据用户ID或用户名分类
	
	public static final String GROUP_PRE_USERID = "03"; // 根据上一步执行人分类
	
	public static final String GROUP_END_DATE = "04"; // 根据结束日期分类
	
	
	
	/***************
	 * 工作流
	 ***************/
	
	public static final String SELL_PRODUCE = "01";//销售到生产
	
	public static final String PRODUCE_BUY = "02";//生产到采购
	
	public static final String BUY_SELL = "03";//采购到销售
	
	public static final String SELL_LOGISTIC = "04";//销售到物流
	
	public static final String LOGISTIC_BUY = "05";//物流到采购
	
	public static final String FLOW_RELATION_INNER_TYPE = "01";//内部关联流程
	
	public static final String FLOW_RELATION_OUTER_TYPE = "02";//外部关联流程
	
	/*******节点类型*******/
	public static final String FLOW_NODE_TYPE1 = "start"; // 开始节点
	public static final String FLOW_NODE_TYPE2 = "end"; // 结束节点
	public static final String FLOW_NODE_TYPE3 = "task"; // 任务节点
	public static final String FLOW_NODE_TYPE4 = "auto"; //自动节点
	
	/*******路径类型*******/
	public static final String FLOW_ROUTE_TYPE1 = "next"; // 下一步
	public static final String FLOW_ROUTE_TYPE2 = "reject"; // 驳回
	public static final String FLOW_ROUTE_TYPE3 = "auto"; // 自动
	public static final String FLOW_ROUTE_TYPE4 = "cc"; //抄送
	public static final String FLOW_ROUTE_TYPE5 = "relateMessage"; //关联消息
	public static final String FLOW_ROUTE_TYPE6 = "relateProcess"; //关联流程
	public static final String FLOW_ROUTE_TYPE7 = "finish"; // 完成
	public static final String FLOW_ROUTE_TYPE8 = "stop"; // 终止
	
	/*******实例状态*******/
	public static final String FLOW_INSTANCE_STATE1 = "draft"; // 草稿
	public static final String FLOW_INSTANCE_STATE2 = "going"; // 进行中
	public static final String FLOW_INSTANCE_STATE3 = "finish"; // 完成
	public static final String FLOW_INSTANCE_STATE4 = "stop"; // 终止
	
	/*******任务状态*******/
	public static final String FLOW_TASK_STATE1 = "unread"; // 未开始
	public static final String FLOW_TASK_STATE2 = "going"; // 进行中
	public static final String FLOW_TASK_STATE3 = "finish"; // 已完成
	
	/*******任务类型*******/
	public static final String FLOW_TASK_TYPE1 = "sytem"; // 系统任务
	public static final String FLOW_TASK_TYPE2 = "independent"; // 独立任务
	public static final String FLOW_TASK_TYPE3 = "countersign"; // 会签任务
	public static final String FLOW_TASK_TYPE4 = "cc"; // 抄送任务
	public static final String FLOW_TASK_TYPE5 = "start"; // 开始任务
	
	/****************/
	
	/*		即时通-消息-状态		*/
	public static final String MESSAGE_STATE_01 = "01"; //未发送
	public static final String MESSAGE_STATE_02 = "02"; //已发送
	public static final String MESSAGE_STATE_03 = "03"; //编辑中
	public static final String MESSAGE_STATE_04 = "04"; //已删除
	public static final String MESSAGE_STATE_05 = "07"; //未回复
	public static final String MESSAGE_STATE_06 = "08"; //已回复
	
	/*		即时通-消息-是否加密		*/
	public static final String MESSAGE_ENCRYPTION_0 = "0";//不加密
	public static final String MESSAGE_ENCRYPTION_1 = "1";//加密
	
	/*		即时通-消息-回复		*/
	public static final String MESSAGE_REPLAY_FLAG_0 = "0"; //未回复
	public static final String MESSAGE_REPLAY_FLAG_1 = "1"; //已回复
	
	/*		即时通-消息-同步		*/
	public static final String MESSAGE_SYNC_0 = "0"; //未同步
	public static final String MESSAGE_SYNC_1 = "1"; //已同步
	
	/*		即时通-消息-周期类型		*/
	public static final String DT_MESSAGE_TYPE = "message_type"; // 消息自定义类型
	public static final String MESSAGE_CYCLE_TYPE_01 = "01"; //非周期消息
	public static final String MESSAGE_CYCLE_TYPE_05 = "05"; //周期消息
	
	public static final String DT_FRIEND_GROUP = "friend_group"; // 好友分组
	/*		即时通-好友-状态		*/
	public static final String FRIEND_STATE_01 = "01"; //未确认
	public static final String FRIEND_STATE_02 = "02"; //好友
	public static final String FRIEND_STATE_03 = "03"; //拒绝
	public static final String FRIEND_STATE_04 = "04"; //删除
	
	/*		remarks_read		*/
	public static final String REMARK_READ_RELATION_TYPE_02 = "02"; //关联类型  02为消息类型
	
	public static final String REMARK_READ_ISREAD_01 = "01"; //已读
	
	/*		产品- 照片	-	*/
	public static final String PRODUCT_IMG1 = "01"; // 照片1
	public static final String PRODUCT_IMG2 = "02"; // 照片2
	public static final String PRODUCT_IMG3 = "03"; // 照片3
	
	/*		展示库- 查询时间区间	(按天-3,7,91,365)	*/
	public static final String ZSK_CREATE_DATE = "zsk_create_date"; // 时间
	
	/*		展示库- groupType		*/
	public static final String AGENT_GROUP = "0"; // 代理展示库
	public static final String OWN_GROUP = "1"; // 自有展示库
	
	/* 是否删除 */
	public static final String NOT_DELETE_FLAG = "0"; // 未删除
	public static final String IS_DELETE_FLAG = "1"; // 已删除
	
	/* 是否系统默认 */
	public static final String INIT_SYSTEM_FLAG = "1"; // 系统初始化
	public static final String ADD_SYSTEM_FLAG = "0"; // 添加
	
	/* 系统默认我的收藏夹 */
	public static final String BASE_FAV_FAVORITE = "我的收藏夹";
	
	public static final Map<String, String> PRODUCT_IMGS;
	
	static {
		ACHIVE_TYPES = new TreeMap<>();
		ACHIVE_TYPES.put(ACHIVE_TYPE1, "照片");
		ACHIVE_TYPES.put(ACHIVE_TYPE2, "身份证");
		ACHIVE_TYPES.put(ACHIVE_TYPE3, "学历证书");
		ACHIVE_TYPES.put(ACHIVE_TYPE4, "专业证书");
		ACHIVE_TYPES.put(ACHIVE_TYPE5, "入职申请表");
		ACHIVE_TYPES.put(ACHIVE_TYPE6, "劳动协议");
		ACHIVE_TYPES.put(ACHIVE_TYPE7, "保密协议");
		ACHIVE_TYPES.put(ACHIVE_TYPE8, "销售协议");
		
		PRODUCT_IMGS = new TreeMap<>();
		PRODUCT_IMGS.put(PRODUCT_IMG1, "照片1");
		PRODUCT_IMGS.put(PRODUCT_IMG2, "照片2");
		PRODUCT_IMGS.put(PRODUCT_IMG3, "照片3");
		
	}
	
	/*******流水号start********/
	public static final String NUM_RUL_TYPE_PEOJECT = "1"; // 1	项目
	public static final String NUM_RUL_TYPE_PRODUCT = "2"; // 2	产品
	public static final String NUM_RUL_TYPE_CUSTOMER = "3"; // 3	客户
	public static final String NUM_RUL_TYPE_SUPPLIER = "4"; // 4	供应商
	public static final String NUM_RUL_TYPE_TASK = "5"; // 5	任务
	public static final String NUM_RUL_TYPE_BUSINESS_UNITS = "6"; // 6	往来单位
	/*******流水号end********/
}
