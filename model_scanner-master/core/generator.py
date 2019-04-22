"""
  Created by Xiaozhong on 2018/11/8.
  Copyright (c) 2018/11/8 Xiaozhong. All rights reserved.
"""
from core import template
from pathlib import Path


# 使用字符串模式生成代码
def generate_by_string_template(str_template=template.str_template_dao,
                                generate_file_object="temp", metadata=None):
    # 读字符串方式初始化模板代码
    if metadata is None:
        print("空的代码元信息")
        return
    read_contents = str_template.split("\n")
    result_content = ""
    for read_content in read_contents:
        if read_content == "":
            result_content += "\n"
        if read_content.endswith("{"):
            result_content += read_content[0:-2].format(**metadata)
            result_content += "{"
            continue
        if read_content.endswith("}"):
            result_content += read_content
            continue
        else:
            result_content += read_content.format(**metadata)
    wr_code = open(generate_file_object, mode="w", encoding="utf-8")
    wr_code.write(result_content)


class Generator(object):

    def __init__(self, fill_obj, store=None):
        self.__fill_obj = fill_obj
        self.__store = store

    # 使用模板文件生成代码
    def generate_by_template_file(self, file_name, generate_file_object):
        # 读取模板文件
        template_file = open(file_name)
        result_content = ""
        while True:
            read_content = template_file.readline()
            if not read_content:
                break
            if read_content.endswith("{\n"):
                result_content += read_content[0:-2].format(**self.__fill_obj)
                result_content += "{\n"
                continue
            if read_content.endswith("}\n"):
                result_content += read_content
                continue
            else:
                result_content += read_content.format(**self.__fill_obj)
        wr_code = open(generate_file_object, mode="w", encoding="utf-8")
        wr_code.write(result_content)

    def generate_dao(self):
        for metadata in self.__fill_obj:
            file_name = metadata.get('model_name') + metadata.get('level').title() + ".java"
            generator_path = Path(
                ".\\" + (self.__store.get('src_dir'))[
                        :self.__store.get('src_dir').find("\\model")] + "\\dao\\").absolute()
            if not generator_path.exists():
                generator_path.mkdir()
            generate_by_string_template(
                generate_file_object=str(generator_path) + "\\" + file_name, metadata=metadata)
            print("在" + str(generator_path) + file_name + "生成了：" + file_name)
