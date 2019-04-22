"""
  Created by Xiaozhong on 2018/11/8.
  Copyright (c) 2018/11/8 Xiaozhong. All rights reserved.

  模板模块，所有的模板应该放到这里进行注册
"""

# Dao层模板字符串
str_template_dao = """/**\n
 * 该代码为自动生成\n
 *\n
 */\n
package {package_name}.{level};\n

import {package_name}.model.{model_name};\n

import java.util.List;\n

public interface {model_name}Dao {\n

    /**\n
     * 持久化{model_name}对象\n
     * @param {lower_case_model_name} 要持续化的{lower_case_model_name}对象\n
     */\n
    void save({model_name} {lower_case_model_name});\n

    /**\n
     * 从数据库中删除指定的{model_name}对象\n
     * @param {lower_case_model_name} 指定{model_name}对象的模仿对象\n
     */\n
    void delete({model_name} {lower_case_model_name});\n

    /**\n
     * 获取符合指定查询条件的{model_name}对象\n
     * @return 从数据库中获取到的{model_name}对象\n
     */\n
    {model_name} get({model_name} {lower_case_model_name});\n

    /**\n
     * 获取指定查询范围内的{model_name}对象\n
     * @return 由指定范围所查询到的{model_name}对象\n
     */\n
    List<{model_name}> get{model_name}s();\n
}\n
"""
# Service层模板字符串
str_template_service = """package {package_name}.service;\n

import {package_name}.model.{model_name};\n

public interface {model_name}Service {\n

    /**\n
     * 持久化{model_name}对象\n
     * @param {lower_case_model_name} 要持久化的{model_name}对象\n
     */\n
    void save({model_name} {lower_case_model_name});\n

    /**\n
     * 从数据库中删除掉{model_name}对象\n
     * @param {lower_case_model_name} 要删除的{model_name}对象副本\n
     */\n
    void delete({model_name} user);\n

    /**\n
     * 从数据库中获取类似的{model_name}对象\n
     * @param {lower_case_model_name} 要获取的{model_name}对象的副本\n
     * @return 从数据库中获取到的{model_name}对象\n
     */\n
    {model_name} get({model_name} {lower_case_model_name});\n

    /**\n
     * 根据提供的信息更新指定{model_name}\n
     * @param user 要查询的{model_name}\n
     * @return 返回跟新前的对象\n
     */\n
    {model_name} update({model_name} {lower_case_model_name});\n
}\n
"""
