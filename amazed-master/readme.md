# 成绩查询模块
### version1.0
### 完成以下功能
1. 用户验证
	* 身份证号作为ID
	* 姓名来做验证
2. JSON字符串封装取值结果
	* 使用alibaba的FastJson
	* 当需要的时候进行反序列化即可
3. 结合使用MUI框架，完善前端页面
4. 初步测试完成
---
### version1.0.1
1. 整合Vue框架
2. 配置CROS拦截器
3. 完成开放接口API
	* http://101.200.56.88:8080/amazed/api/open/query/transcri
		* 参数：
	
		>password	|	必选		参考数据：（1234567890,1234567891）
		>username   |   可选    
4. 重构页面数据格式
			
	