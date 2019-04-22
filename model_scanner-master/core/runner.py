"""
  Created by Xiaozhong on 2018/11/8.
  Copyright (c) 2018/11/8 Xiaozhong. All rights reserved.
"""
from core import scanner, generator, scanner
from pathlib import Path


p = Path()

s = scanner.Scanner()
s.load_models(p)
print(s.get_fill_obj())
print(s.get_models())
print(s.get__store())

g = generator.Generator(s.get_fill_obj(), s.get__store())
g.generate_dao()
