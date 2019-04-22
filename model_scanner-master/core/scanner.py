"""
  Created by Xiaozhong on 2018/11/8.
  Copyright (c) 2018/11/8 Xiaozhong. All rights reserved.
"""


def get_package_name(file_name):
    """根据一个model层的源代码文件获取到package信息"""
    with open(file_name, encoding="utf-8") as file_obj:
        while True:
            content = file_obj.readline()
            if content.startswith("package"):
                split_contents = content.split(" ")
                if ".model" in split_contents[1]:
                    package_name = (split_contents[1])[:split_contents[1].find(".model")]
                    return package_name


class Scanner(object):
    """
    扫描当前目录下的model层
    并加载到models列表中
    """

    def __init__(self):
        self.__models = []
        self.__metadata_list = []
        self.__store = {}

    def load_models(self, dir_name):
        for pro_dir in dir_name.iterdir():
            if pro_dir.is_file() and pro_dir.match("*/model/*.java"):
                self.__store['src_dir'] = str(pro_dir.parent)
                self.__models.append(str(pro_dir))
                package_name = get_package_name(self.__models[0])
                self.__metadata_list.append({
                    'package_name': package_name,
                    'model_name': pro_dir.stem,
                    'dao_name': pro_dir.stem + 'Dao',
                    'component_name': pro_dir.stem.lower() + 'Dao',
                    'lower_case_model_name': pro_dir.stem.lower(),
                    'level': 'dao'
                })
            elif pro_dir.is_dir():
                self.load_models(pro_dir)

    def get_models(self):
        return self.__models

    def get_fill_obj(self):
        return self.__metadata_list

    def get__store(self):
        return self.__store
